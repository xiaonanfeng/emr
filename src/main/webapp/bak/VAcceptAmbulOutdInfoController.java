package com.zxit.action;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zxit.share.Constants;
import com.zxit.share.Pager;
import com.zxit.model.SysMemberInfo;
import com.zxit.model.SysOrgInfo;
import com.zxit.model.TObject;
import com.zxit.model.VAcceptAmbulOutdInfo;
import com.zxit.model.VAcceptAmbulOutdInfoId;
import com.zxit.service.SysOrgInfoService;
import com.zxit.service.VAcceptAmbulOutdInfoService;

@Controller
@RequestMapping("/vAcceptAmbulOutdInfo.do")
public class VAcceptAmbulOutdInfoController {

	@Resource
	private VAcceptAmbulOutdInfoService vAcceptAmbulOutdInfoService;
	@Resource
	private SysOrgInfoService sysOrgInfoService;

	
	/**
	 * 警情查询控制器
	 */
	@RequestMapping(params = "method=findVAcceptAmbulOutdInfo")
	public String findVAcceptAmbulOutdInfo(VAcceptAmbulOutdInfo vAcceptAmbulOutdInfo,
			HttpServletRequest request) {
		
		//TODO 如果车辆ID获取SZFZID为空，会导致这里分页出错。
		
		String path = (String) request.getSession().getAttribute(Constants.PATH);
		
		String hql = "";
		if ("web".equals(path)) {// web查询
			String orgId = ((SysMemberInfo) request.getSession().getAttribute(
					Constants.USERNAME)).getSysOrgInfo().getOrgId(); // sysMemberInfo
			vAcceptAmbulOutdInfo.setOrgId(orgId);
			hql = vAcceptAmbulOutdInfoService.createWebHQL(vAcceptAmbulOutdInfo);
			//System.out.println(hql);
		} else {// pad查询
			String clid = (String) request.getSession().getAttribute("zbclid");
			vAcceptAmbulOutdInfo.setClid(clid);
			hql = vAcceptAmbulOutdInfoService.createPadHQL(vAcceptAmbulOutdInfo);
		}
		int dataPerPage = Constants.MAXROWS;// 最大页码
		Pager pager = new Pager();// 对象声明
		pager.SetPerNum(dataPerPage);// 装载对象最大页面
		pager.Init(vAcceptAmbulOutdInfoService.findCount(hql), request);// 总量，request对象
		String nva = pager.getStr();// 生成分页字符串
		List<VAcceptAmbulOutdInfo> list = null;
			list = vAcceptAmbulOutdInfoService.findVAcceptAmbulOutdInfoPager(hql, pager.getStartPos(),dataPerPage);
		request.setAttribute("list", list);
		request.setAttribute("nva", nva); // request到页面);
		request.setAttribute("vAcceptAmbulOutdInfo", vAcceptAmbulOutdInfo);// 这是一个查询对象，别弄混了。为了保留页面查询信息存在的
		// 生成单位下拉框
				TObject t = new TObject("szfz", "", "");
				List<SysOrgInfo> orgList = sysOrgInfoService.findSysOrgInfo();
				request.setAttribute("szfz",
						sysOrgInfoService.createSysOrgSelect(t, orgList));
		return "/business/list_accept";// 转向一次出车的所有病历列表

	}
	
	
	/**
	 * 接处警、出车信息项
	 */
	@RequestMapping(params = "method=findVAcceptAmbulOutdInfoById")
	public void findVAcceptAmbulOutdInfoById(String lsh, Integer ccxh,HttpServletRequest request) {
		VAcceptAmbulOutdInfoId vAcceptAmbulOutdInfoId = new VAcceptAmbulOutdInfoId(lsh, ccxh);//生成ID先
		VAcceptAmbulOutdInfo vAcceptAmbulOutdInfo = vAcceptAmbulOutdInfoService.findVAcceptAmbulOutdInfoById(vAcceptAmbulOutdInfoId);
		request.setAttribute("vAcceptAmbulOutdInfo", vAcceptAmbulOutdInfo);// 初始化现有数据项
	}
	

}
