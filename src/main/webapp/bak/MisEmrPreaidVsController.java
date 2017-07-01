package com.zxit.action;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zxit.model.MisAmEmMedicine;
import com.zxit.model.MisEmrBasicinfo;
import com.zxit.model.MisEmrIcd10;
import com.zxit.model.MisEmrPreaidVs;
import com.zxit.model.SysCode;
import com.zxit.model.SysMemberInfo;
import com.zxit.model.TObject;
import com.zxit.service.MisAmEmMedicineService;
import com.zxit.service.MisEmrBasicinfoService;
import com.zxit.service.MisEmrIcd10Service;
import com.zxit.service.MisEmrPreaidVsService;
import com.zxit.service.SysCodeService;
import com.zxit.service.SysSelectService;
import com.zxit.share.Constants;
import com.zxit.share.Pager;

/**
 * 施救措施控制器
 * @author Administrator
 */
@Controller
@RequestMapping("/misEmrPreaidVs.do")
public class MisEmrPreaidVsController {
	
	@Resource
	private SysSelectService sysSelectService;
	@Resource
	private SysCodeService sysCodeService;
	@Resource
	private MisEmrPreaidVsService misEmrPreaidVsService;
	@Resource
	private MisEmrBasicinfoService misEmrBasicinfoService; 
	@Resource
	private MisEmrIcd10Service misEmrIcd10Service;
	@Resource
	private MisAmEmMedicineService misAmEmMedicineService;
	
	/**
	 * 保存一个对象
	 */
	@ResponseBody
	@Transactional(propagation = Propagation.REQUIRED)
	@RequestMapping(params = "method=saveMisEmrPreaidVs", method = RequestMethod.POST)
	public Map<String, String> saveMisEmrPreaidVs(
			MisEmrPreaidVs misEmrPreaidVs, HttpServletRequest request) {
		Map<String, String> m = new HashMap<String, String>();
		MisEmrBasicinfo noBase = misEmrBasicinfoService.findMisEmrBasicinfoById(misEmrPreaidVs.getId());
		if(noBase==null){
			m.put("err", "请您先填写相应的基础信息项！");
			return m;
		}
		misEmrPreaidVs.setLastModifyTime(new Date());
		misEmrPreaidVs.setCreateTime(new Date());
		misEmrPreaidVs.setXzbm(((SysMemberInfo) request.getSession().getAttribute(Constants.USERNAME)).getXzbm());
		misEmrPreaidVs.toString();
		misEmrPreaidVsService.saveMisEmrPreaidVs(misEmrPreaidVs);
		return null;
	}
	
	/**
	 * 基础信息查询控制器
	 * @param id
	 * @param request
	 */
	@RequestMapping(params = "method=findMisEmrPreaidVsById")
	public void findMisEmrPreaidVsById(String id, HttpServletRequest request) {
		MisEmrPreaidVs misEmrPreaidVs = misEmrPreaidVsService.findMisEmrPreaidVsById(id);
		request.setAttribute("misEmrPreaidVs", misEmrPreaidVs);
	}
	
	

	/**
	 * 施救措施
	 * 创建多选组件
	 * @return
	 */
	@RequestMapping(params = "method=findSceneTreatlects")
	public String findSceneTreatlects(HttpServletRequest request){
		createMuSelects(Constants.sceneTreat ,"select",1,"",request);//处理措施
		return "multi-vs";//公共的多选页
	}
	
	/**
	 * 用药
	 * 创建多选组件
	 */
	@RequestMapping(params = "method=findSceneDrugSelects")
	public String findSceneDrugSelects(MisAmEmMedicine misAmEmMedicine,HttpServletRequest request){
		request.setAttribute("misAmEmMedicine", misAmEmMedicine);//可能会用到的查询方法
		String hql = misAmEmMedicineService.createHQL(misAmEmMedicine);
		List<MisAmEmMedicine> list = misAmEmMedicineService.findMisAmEmMedicineByHql(hql);
		TObject t = new TObject();
		t.setOther1(1);
		t.setSelectIdAndName("select");
		String select = misAmEmMedicineService.createSelect(t, list);
		request.setAttribute("select",select);
		return "multi-mdce";//公共的多选页
	}
	
	
	/**
	 * 异步返回药品使用情况的 汉字
	 * @param str
	 * @return
	 */
	@ResponseBody
	@RequestMapping(params = "method=findDrugText", method = RequestMethod.GET)
	public String findDrugText(String str){
		String returnStr = "";
			if(str!=null){
				if(str.length()!=0){
					String[] temp = str.split(",");
					for(int i=0;i<temp.length;i++){
						String drugName = misAmEmMedicineService.findMisAmEmMedicineById(Integer.parseInt(temp[i])).getName();
						returnStr += drugName + "        ";
					}
				}
			}
		return returnStr;
	}
	
	
	
	/**
	 * 创建多选组件
	 * @return
	 */
	@RequestMapping(params = "method=findPrimDiag")
	public String findPrimDiag(MisEmrIcd10 misEmrIcd10,HttpServletRequest request){
		request.setAttribute("misEmrIcd10", misEmrIcd10);
		String hql = misEmrIcd10Service.createHQL(misEmrIcd10);//创造查询HQL
		//int dataPerPage = 200;//Constants.MAXROWS;// 最大页码
		//Pager pager = new Pager();// 对象声明
		//pager.SetPerNum(dataPerPage);// 装载对象最大页面
		//pager.Init(misEmrIcd10Service.findCount(hql), request);// 总量，request对象
		//String nva = pager.getStr();// 生成分页字符串
		List<MisEmrIcd10> list = misEmrIcd10Service.findMisEmrIcd10ByHql(hql);
		//request.setAttribute("list", list);
		//request.setAttribute("nva", nva); // request到页面);
		TObject t = new TObject();
		t.setOther1(1);
		t.setSelectIdAndName("select");
		String select = misEmrIcd10Service.createSelect(t, list);
		request.setAttribute("select",select);
		
		return "icdList";//ICD10组件
	}
	
	
	/**
	 * 复选select构造器
	 */
	private void createMuSelects(Integer typeId, String selectId, int i,String changeMethod, HttpServletRequest request) {
		TObject t = new TObject(selectId,"",changeMethod);
		t.setOther1(i);
		List<SysCode> list = sysCodeService.findSysCodeByPid(typeId);
		String select = sysSelectService.CreateSelect(t, list);
		request.setAttribute(selectId.toString(),select);
	}
	
	/**
	 * 异步返回处理情况的 汉字
	 * @param str
	 * @return
	 */
	@ResponseBody
	@RequestMapping(params = "method=findMisEmrPreaidVsSceneTreatText", method = RequestMethod.GET)
	public String findMisEmrPreaidVsSceneTreatText(String str){
		String returnStr = "";
			if(str!=null){
				if(str.length()!=0){
					String[] temp = str.split(",");
					for(int i=0;i<temp.length;i++){
						String codeName = sysCodeService.findSysCodeByIdAndPid(Integer.parseInt(temp[i]), Constants.sceneTreat).getName();
						returnStr += codeName + "        ";
					}
				}
			}
		return returnStr;
	}

}
