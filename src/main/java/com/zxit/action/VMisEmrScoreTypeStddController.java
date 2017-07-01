package com.zxit.action;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONArray;

import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zxit.model.MisEmrBasicinfo;
import com.zxit.model.MisEmrScoreRecord;
import com.zxit.model.SysMemberInfo;
import com.zxit.model.VMisEmrScoreType;
import com.zxit.model.VMisEmrScoreTypeStdd;
import com.zxit.model.MisEmrScoreTotal;
import com.zxit.service.MisEmrBasicinfoService;
import com.zxit.service.SysMemberInfoService;
import com.zxit.service.MisEmrScoreTypeStddService;
import com.zxit.share.Constants;
import com.zxit.tools.ServletParameter;
import com.zxit.tools.UtilDate;
import com.zxit.tools.UtilTools;

/**
 * 病历评分细则控制器
 * 列举所有的评分细则
 * 评分项目为0的不保存
 *
 * @author Administrator
 */
@Controller
@RequestMapping("/vMisEmrScoreTypeStdd.do")
public class VMisEmrScoreTypeStddController {

    @Resource
    private MisEmrScoreTypeStddService misEmrScoreTypeStddService;
    @Resource
    private MisEmrBasicinfoService misEmrBasicinfoService;
    @Resource
    private SysMemberInfoService sysMemberInfoService;

    @RequestMapping(params = "method=findMisEmrScoreTypeStdd")
    public String findMisEmrBasicinfoList(String id, HttpServletRequest request) {

        /**
         * 已经提交&&并且修改申请里没有未处理的数据
         * 或者已经有审核记录
         */
        boolean b = misEmrScoreTypeStddService.findIfEmrCanPrev(id);

        request.setAttribute("b", b);
        if (b == false) {
            String cantPrv = "该病历未提交或存在修改申请，暂时不能审核！";
            request.setAttribute("cantPrv", cantPrv);
        } else {
            int level = ServletParameter.getParameter(request, "level", 0);
            String level_text = UtilTools.fmtNumToTxt(level) + "级";
            request.setAttribute("level", level);
            request.setAttribute("level_text", level_text);
            //病历ID
            request.setAttribute("emrId", id);
            //基础信息
            MisEmrBasicinfo misEmrBasicinfo = misEmrBasicinfoService.findMisEmrBasicinfoById(id);
            request.setAttribute("misEmrBasicinfo", misEmrBasicinfo);
            /**
             * 列举现有的评分记录
             */
            List<MisEmrScoreTotal> listTotal = misEmrScoreTypeStddService.findMisEmrScoreRecordTotalByEmrId(id, level);
            if (listTotal.size() != 0) {
                String createUserId = listTotal.get(0).getCreateUserid();
                String createUser = "";//检查人
                String createTime = "";//创建时间
                createUser = (sysMemberInfoService.findSysMemberInfoById(createUserId)).getName();
                createTime = UtilDate.formatDate(listTotal.get(0).getCreateTime(), "yyyy年MM月dd日 HH点MM分");
                request.setAttribute("createUserId", createUserId);
                request.setAttribute("createUser", createUser);
                request.setAttribute("createTime", createTime);
            }
            /**
             * 相关扣分列表
             */
            MisEmrScoreRecord misEmrScoreRecord_temp = new MisEmrScoreRecord();
            misEmrScoreRecord_temp.setEmrId(id);
            misEmrScoreRecord_temp.setScoreLevel(level);
            List<MisEmrScoreRecord> listExit = misEmrScoreTypeStddService.findMisEmrScoreRecordByObj(misEmrScoreRecord_temp);
            if (listExit.size() != 0) {
                request.setAttribute("listExit", listExit);
            }
            /**
             * 类型对象，下属各类审核细则
             */
            TreeMap<VMisEmrScoreType, List<VMisEmrScoreTypeStdd>> map = new TreeMap<VMisEmrScoreType, List<VMisEmrScoreTypeStdd>>();
            /**
             * 审核项目大类
             */
            List<VMisEmrScoreType> typeList = misEmrScoreTypeStddService.findVMisEmrScoreTypeByFlag();
            //循环大类组装对象
            for (VMisEmrScoreType d : typeList) {
                map.put(d, misEmrScoreTypeStddService.findVMisEmrScoreTypeStddByTypeid(d.getTypeid()));
            }
            request.setAttribute("map", map);
        }
        return "/business/MIS_EMR_SCORE_RECORD";
    }

    @ResponseBody
    @Transactional(propagation = Propagation.REQUIRED)
    @RequestMapping(params = "method=saveMisEmrScoreRecord")
    public Map<String, String> saveMisEmrScoreRecord(MisEmrScoreTotal misEmrScoreTotal, String misEmrScoreRecordJson, HttpServletRequest request) {

        /**
         * 保存主表
         */
        SysMemberInfo sysMemberInfo = (SysMemberInfo) request.getSession().getAttribute(Constants.USERNAME);
        if (sysMemberInfo != null) {
            misEmrScoreTotal.setCreateUserid(sysMemberInfo.getId());
            misEmrScoreTotal.setXzbm(sysMemberInfo.getXzbm());
        }
        misEmrScoreTotal.setCreateTime(new Date());
        misEmrScoreTotal.setLastModifyTime(new Date());
        misEmrScoreTypeStddService.saveOrUpdateMisEmrScoreTotal(misEmrScoreTotal);

        /**
         * 并添加新的记录
         */
        JSONArray jsonArray = JSONArray.fromObject(misEmrScoreRecordJson);
        List<MisEmrScoreRecord> misEmrScoreRecordList = UtilTools.convertToList(jsonArray, MisEmrScoreRecord.class);
        if (misEmrScoreRecordList.size() != 0) {
            for (MisEmrScoreRecord d : misEmrScoreRecordList) {
                d.setEmrId(misEmrScoreTotal.getEmrId());
                d.setScoreLevel(misEmrScoreTotal.getScoreLevel());
                d.setCreateTime(new Date());
                /**
                 * 删除更新是0的
                 */
                if (d.getScore() == 0) {
                    misEmrScoreTypeStddService.delEmrScoreRecordByItemid(d);
                } else {
                    /**
                     *保存
                     */
                    misEmrScoreTypeStddService.saveOrUpdateMisEmrScoreRecord(d);
                }
            }
        }
        return null;
    }

    /**
     * 病历评审结果
     *
     * @param total
     * @return
     */
    @ResponseBody
    @RequestMapping(params = "method=findMisEmrQuality")
    public String findMisEmrQuality(Double total) {
        String quality = misEmrScoreTypeStddService.findMisEmrQuality(total);
        return quality;
    }

    @ResponseBody
    @RequestMapping(params = "method=findSorceRecByEmrId")
    public String findSorceRecByEmrId(String emrId) {
        String emrUrls = "";
        List<MisEmrScoreTotal> list = misEmrScoreTypeStddService.findMisEmrScoreRecordTotalByEmrId(emrId, null);
        //病历审核列表
        if (list.size() != 0) {
            emrUrls = "<table width='100%' border='1' class='table_list'>";
            emrUrls = emrUrls + "<tr class='table_list_first'>";
            emrUrls = emrUrls + "<th>审核等级</th><th>病历评价</th><th>审核人</th><th>得分</th></tr>";
            for (MisEmrScoreTotal d : list) {
                Double totalScore = d.getTotalScore();
                String quality = this.findMisEmrQuality(totalScore);
                String createUser = "";//检查人
                createUser = (sysMemberInfoService.findSysMemberInfoById(d.getCreateUserid())).getName();
                emrUrls = emrUrls
                        + "<tr>"
                        + "<td>" + UtilTools.fmtNumToTxt(d.getScoreLevel()) + "级</td>"
                        + "<td>" + quality + "</td>"
                        + "<td>" + createUser + "</td>"
                        + "<td><a biaozhi=\"sorce" + d.getEmrId() + "\" openMode=\"tabMenu\" tab_title=\"病历审核\" "
                        + "link_url=\"vMisEmrScoreTypeStdd.do?method=findMisEmrScoreTypeStdd&id=" + d.getEmrId() + "&level=" + d.getScoreLevel() + "\">" + totalScore + "</td>"
                        + "</tr>";
            }
            emrUrls = emrUrls + " </table> ";
        }
        return emrUrls;

    }
}
