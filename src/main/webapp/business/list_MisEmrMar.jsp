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
        <th style="text-align: center;">给药方式</th>
        <th style="text-align: center;">频次</th>
        <th style="text-align: center;">滴速</th>

        <th style="text-align: center;">药品</th>
        <th style="text-align: center;">用量</th>

        <c:if test="${createuserid==sysMemberInfo.id&&isCommited!=1}">
            <th style="text-align: center;">删除</th>
        </c:if>
    </tr>
    <c:forEach var="list" items="${list}">
        <tr id="${list.id}tr">
            <td class="debugMode${deBugMode}">${list.id}</td>
            <td>${list.grp}</td>
            <td>${list.usage}</td>
            <td>${list.frequency_text}</td>
            <td>${list.drip}</td>

            <td>${list.name}</td>
            <td>${list.dose}${list.units_text}*${list.amount}</td>

            <c:if test="${createuserid==sysMemberInfo.id&&isCommited!=1}">
                <td>
                    <img alt="删除" title="删除"
                         src="${ctx}/css/images/ZXICO/delBig.png" style="cursor: pointer;"
                         onclick="del(${list.id})"/>
                </td>
            </c:if>
        </tr>
    </c:forEach>
</table>
