<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@ include file="/taglibs.jsp" %>
<%Integer[] orgType = {10, 20};%>
机构代码：<myTag:SysOrgInfo name="sysorg" type="<%=orgType%>" id="sysorg"/>