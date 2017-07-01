package com.zxit.action;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Enumeration;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.zxit.model.MisEmrTemplatePage;
import com.zxit.model.SysMemberInfo;
import com.zxit.model.SysOrgInfo;
import com.zxit.model.SysStaffOnduty;
import com.zxit.service.LoginService;
import com.zxit.service.MisEmrTemplatePageService;
import com.zxit.service.SysOrgInfoService;
import com.zxit.service.SysStaffOndutyService;
import com.zxit.share.Constants;
import com.zxit.share.MD5FileUtil;
import com.zxit.share.SystemConfig;
import com.zxit.tools.UtilDate;

/**
 * 登录控制器
 *
 * @author nanxiaofeng
 *         "deBugMode"  调试模式
 *         "sysMemberInfo" 用户
 *         "systemConfig" 系统配置
 *         "loginPath" 系统进入路径
 *         "zbclid" 值班车辆ID
 *         "pageCssControlList" page的css控制器
 *         "orgType" 用户登录单位类型
 */
@Controller
@RequestMapping("/login.do")
@SessionAttributes({"deBugMode", "sysMemberInfo", "systemConfig", "loginPath", "zbclid", "pageCssControlList", "orgType", "centerOrg", ""})
public class LoginController {

    @Resource
    private LoginService loginService;
    @Resource
    private SysStaffOndutyService sysStaffOndutyService;
    @Resource
    private MisEmrTemplatePageService misEmrTemplatePageService;
    @Resource
    private SysOrgInfoService sysOrgInfoService;

    @Resource
    @Qualifier("systemConfig")
    private SystemConfig systemConfig;


    public static void main(String[] args) {
        String path = "D:\\logo.png";
        File file = new File(path);
        if (file.exists()) {
            try {
                String check = MD5FileUtil.getFileMD5String(file);
                System.out.println(check);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    /**
     * 登录方法
     *
     * @param id
     * @param password
     * @param m
     * @return
     */
    @RequestMapping(params = "method=login")
    public String login(String id, String password, String path, String system, ModelMap m,
                        HttpServletRequest request) {
        /**
         * 载入系统配置
         */
        m.put("systemConfig", systemConfig);
        /**
         *是否打开debug模式
         */
        String err2login = "";
        Integer deBugMode = systemConfig.getDebugMode();
        m.put("deBugMode", deBugMode);//是否打开debug模式
        /**
         * 文件验证
         */
        String ctxPath = request.getSession().getServletContext().getRealPath("/") + "css\\images\\logo.png";
        err2login = loginService.checkFile(ctxPath, systemConfig.getChecker());
        if (!err2login.equals("success")) {
            m.put("err", err2login);
            return "newLogin";
        }
        /**
         * 登录信息
         */
        System.out.println(UtilDate.get4yMdHms(new Date()) + "初始化用户配置！" + id + "loginService.login(id, password,system);");
        SysMemberInfo sysMemberInfo = loginService.login(id, password, system);
        /**
         * 找不到用户
         */
        if (sysMemberInfo == null) {
            err2login = systemConfig.getErrLogin();
            m.put("err", err2login);
            return "newLogin";
        } else {
            System.out.println(UtilDate.get4yMdHms(new Date()) + "已找到！ " + id);
            /**
             * 用户所在单位类型
             */
            Integer orgType = null;
            SysOrgInfo sysOrgInfo = sysMemberInfo.getSysOrgInfo();
            if (sysOrgInfo != null) {
                orgType = sysOrgInfo.getType();
                if (orgType != null) {
                    m.put("orgType", orgType);
                }
            }
            /**
             * 设定中心单位编码
             */
            String centerOrg = sysOrgInfoService.findCenter();
            m.put("centerOrg", centerOrg);

            /**
             * 用户校验
             */
            err2login = loginService.checkUser(sysMemberInfo, orgType);
            /**
             * 非医生类型用户
             */
            if (!err2login.equals("success")) {
                m.put("err", err2login);
                return "newLogin";
            }

            m.put(Constants.USERNAME, sysMemberInfo);
            m.put(Constants.PATH, path);// 把用户登录的路径放到本次session
            /**
             * 页面级元素样式控制
             */
            List<MisEmrTemplatePage> pageCssControlList = misEmrTemplatePageService.findMisEmrTemplatePageByHql();
            m.put("pageCssControlList", pageCssControlList);

            if ("web".equals(path)) {
                return "index-web";//web端登录
            } else {
                /**
                 * web登陆和pad登陆找到的警情查询列表是不一样的 pad 登陆找到的是上班的时候该车所有的警情 web
                 * 登陆找到的是分站所有的病历
                 */
                SysStaffOnduty sysStaffOnduty = sysStaffOndutyService.findSysStaffOndutyByUnqIndex(sysMemberInfo.getId(), 0);// 0上班
                if (sysStaffOnduty == null && path.equals("pad")) {// 如果值班信息里面找不到这个人
                    err2login = systemConfig.getErrDuty();
                    m.put("err", err2login);
                    return "newLogin";
                }
                m.put(Constants.ZBCLID, sysStaffOnduty.getZbclid());//pad登陆的时候车辆ID放到session
            }
            //pad端直接重定向到本车上接收的警情
            return "redirect:vAcceptAmbulOutdInfo.do?method=findVAcceptAmbulOutdInfo";
        }
    }

    /**
     * 登出并清除session
     *
     * @param request
     * @return
     */
    @RequestMapping(params = "method=logout")
    public String logout(HttpServletRequest request) {
        Enumeration<String> em = request.getSession().getAttributeNames();
        while (em.hasMoreElements()) {
            request.getSession().removeAttribute(em.nextElement().toString());
        }
        reMoveSessionAttribute(request);
        request.getSession().invalidate();
        return "newLogin";
    }

    /**
     * 需要清除的session
     *
     * @param request
     */
    public void reMoveSessionAttribute(HttpServletRequest request) {
        request.getSession().removeAttribute(Constants.USERNAME);// 用户对象
        request.getSession().removeAttribute(Constants.PATH);// 清除路径
        request.getSession().removeAttribute(Constants.ZBCLID);// 清除值班车辆
    }

}
