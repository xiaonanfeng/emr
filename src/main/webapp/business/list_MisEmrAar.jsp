<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link href="${ctx}/css/ew.css" rel="stylesheet" type="text/css"/>
<link href="${ctx}/css/the_style.css" rel="stylesheet" type="text/css"/>
<table width="100%" id="drugList" class="table_list">
    <tr>
        <th style="text-align: center;" class="debugMode${deBugMode}">debug用</th>
        <th style="text-align: center;">批次</th>
        <th style="text-align: center;">耗材名称</th>
        <th style="text-align: center;">单次用量</th>
        <th style="text-align: center;">单位</th>
        <th style="text-align: center;">使用时间</th>
        <c:if test="${createuserid==sysMemberInfo.id&&isCommited!=1}">
            <th style="text-align: center;">删除</th>
        </c:if>
    </tr>
    <c:forEach var="list" items="${list}">
        <tr id="${list.id}tr">
            <td class="debugMode${deBugMode}">${list.id}</td>
            <td>${list.grp}</td>
            <td>${list.name}</td>
            <td>${list.amount}</td>
            <td>${list.useUnits}</td>
            <td><fmt:formatDate value="${list.useTime}" pattern="yyyy-MM-dd HH:mm:ss" type="date"
                                dateStyle="long"/></td>
            <c:if test="${createuserid==sysMemberInfo.id&&isCommited!=1}">
                <td>
                    <img alt="删除" title="删除"
                         src="${ctx}/css/images/ZXICO/delBig.png" style="cursor: pointer;"
                         onclick="delAar(${list.id})"/>
                </td>
            </c:if>
        </tr>
    </c:forEach>
</table>
