package com.zxit.action;

import com.zxit.model.MisCategory;
import com.zxit.model.MisCategorypermission;
import com.zxit.model.SysMemberInfo;
import com.zxit.model.SysMemberRole;
import com.zxit.service.MisCategoryService;
import com.zxit.service.MisCategorypermissionService;
import com.zxit.service.SysMemberRoleService;
import com.zxit.share.Constants;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * 目录服务
 *
 * @author Administrator
 */
@Controller
@RequestMapping("/misEmrCategory.do")
public class MisEmrCategoryController {


    @Resource
    private MisCategoryService misCategoryService;
    @Resource
    private SysMemberRoleService sysMemberRoleService;
    @Resource
    private MisCategorypermissionService misCategorypermissionService;

    @RequestMapping(params = "method=findMisEmrCategory")
    public String findMisEmrCategory(MisCategory misCategory, HttpServletRequest request) {
        //获取memeberID
        String memberId = ((SysMemberInfo) request.getSession().getAttribute(Constants.USERNAME)).getId();
        //找到用户对应的角色
        List<SysMemberRole> sysMemberRoleList = sysMemberRoleService.findSysMemberRoleByMemberId(memberId);
        List<String> roleCodeList = new ArrayList<String>();//权限代码集合
        System.out.println("获取权限代码");
        for (SysMemberRole d : sysMemberRoleList) {
            //TODO 这个地方数据库类型不匹配
            if (d.getId().getRoleCode() != null) {
                roleCodeList.add(String.valueOf(d.getId().getRoleCode()));
            }
        }

        if (roleCodeList.size() != 0) {
            System.out.println("获取拥有的菜单Id");
            List<MisCategorypermission> misList = misCategorypermissionService.findMisCategorypermissionByRoleCode(roleCodeList);
            System.out.println("获取相应目录");
            List<MisCategory> list = misCategoryService.findMisEmrCategoryInUse(misList);
            request.setAttribute("list", list);
        }

        return "home";
    }

}
