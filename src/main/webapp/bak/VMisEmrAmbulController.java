package com.zxit.action;

import com.zxit.model.SysMemberInfo;
import com.zxit.model.SysOrgInfo;
import com.zxit.model.TObject;
import com.zxit.model.VMisEmrAmbul;
import com.zxit.service.SysOrgInfoService;
import com.zxit.service.VMisEmrAmbulService;
import com.zxit.share.Constants;
import com.zxit.share.Pager;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/vMisEmrAmbul.do")
public class VMisEmrAmbulController {

	@Resource
	private VMisEmrAmbulService vMisEmrAmbulService;
	@Resource
	private SysOrgInfoService sysOrgInfoService;

	@RequestMapping(params = "method=findVMisEmrAmbul")
	public String findVMisEmrAmbul(VMisEmrAmbul vMisEmrAmbul,
			HttpServletRequest request) {
		/**
		 * 当前登录用户的orgId
		 */
		String orgId = ((SysMemberInfo) request.getSession().getAttribute(
				Constants.USERNAME)).getSysOrgInfo().getOrgId();
		vMisEmrAmbul.setOrgId(orgId);

		String hql = "";
		hql = vMisEmrAmbulService.createHQL(vMisEmrAmbul);
		int dataPerPage = Constants.MAXROWS;// 最大页码
		Pager pager = new Pager();// 对象声明
		pager.SetPerNum(dataPerPage);// 装载对象最大页面
		hql = hql +"  1 = 1  ";//hql的尾巴
		pager.Init(vMisEmrAmbulService.findCount(hql), request);// 总量，request对象
		String nva = pager.getStr();// 生成分页字符串
		hql = hql + " order by emrid desc";//排序
		List<VMisEmrAmbul> list = vMisEmrAmbulService.findVMisEmrAmbulPager(
				hql, pager.getStartPos(), dataPerPage);
		request.setAttribute("list", list);
		request.setAttribute("nva", nva); // request到页面);
		request.setAttribute("vMisEmrAmbul", vMisEmrAmbul);// 这是一个查询对象，别弄混了。为了保留页面查询信息存在的
		// 生成单位下拉框
		TObject t = new TObject("szfz", "", "");
		List<SysOrgInfo> orgList = sysOrgInfoService.findSysOrgInfo();
		request.setAttribute("szfz",
				sysOrgInfoService.createSysOrgSelect(t, orgList));

		return "/business/list_MisEmrAmbul";
	}

}
