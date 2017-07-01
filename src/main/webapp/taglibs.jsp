<!DOCTYPE HTML>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!-- 引入自定义标签 -->
<%@ taglib uri="/tags" prefix="myTag" %>


<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">


<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="org.apache.commons.lang.*" %>

<%@ page import="com.zxit.tools.UtilDate" %>
<%@ page import="com.zxit.share.Constants" %>
<%@ page import="com.zxit.model.SysMemberInfo" %>
<%@ page import="com.zxit.share.CreaterPK" %>

<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>

<script src="${ctx}/js/jquery-2.1.1.min.js"></script>
<script src="${ctx}/js/My97DatePicker/WdatePicker.js"></script>
<script src="${ctx}/js/validate/jquery.validate.js"></script>
<script src="${ctx}/js/jquery.quicksearch.js"></script>

<c:choose>
    <c:when test="${sysMemberInfo!=null}">
    </c:when>
    <c:otherwise>
        <script>
            alert("请登录！");
            window.location.href = "${ctx}/newLogin.jsp";
            parent.location.href = "${ctx}/newLogin.jsp";
            top.location.href = "${ctx}/newLogin.jsp";
            location.href = "${ctx}/newLogin.jsp";
        </script>
    </c:otherwise>
</c:choose>
<link href="${ctx}/css/ew.css" rel="stylesheet" type="text/css"/>
<link href="${ctx}/css/the_style.css" rel="stylesheet" type="text/css"/>
<link href="${ctx}/css/asTable.css" rel="stylesheet" type="text/css"/>
<c:choose>
    <c:when test="${loginPath=='pad'}">
        <script src="${ctx}/js/pad/JC_js-pad.js"></script>
        <link href="${ctx}/css/pad/debugPad.css" rel="stylesheet" type="text/css"/>
    </c:when>
    <c:otherwise>
        <script src="${ctx}/js/JC_js.js"></script>
        <link href="${ctx}/css/pc/debugPc.css" rel="stylesheet" type="text/css"/>
    </c:otherwise>
</c:choose>

<jsp:useBean id="dateStr" class="java.util.Date"/>
<fmt:formatDate value="${dateStr}" type="both" dateStyle="long" pattern="yyyy/MM" var="nowMon"/>
<fmt:formatDate value="${dateStr}" type="both" dateStyle="long" pattern="yyyy-MM-dd" var="nowDate"/>
<fmt:formatDate value="${dateStr}" type="both" dateStyle="long" pattern="yyyy-MM-dd HH:mm:ss" var="nowDAT"/>

<c:set var="memberId" value="${sysMemberInfo.id}"/>
<c:set var="orgid" value="${sysMemberInfo.sysOrgInfo.orgId}"/>
<c:set var="centerOrg" value="${centerOrg }"/>
<c:set var="center" value="<%=com.zxit.share.Constants.center %>"/>
<c:set var="scenter" value="<%=com.zxit.share.Constants.scenter %>"/>
<c:set var="station" value="<%=com.zxit.share.Constants.station %>"/>