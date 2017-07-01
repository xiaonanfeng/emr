<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@ include file="/taglibs.jsp" %>
<%@ include file="/businit/MIS_EMR_MDFREQ-init.jsp" %>
<!DOCTYPE html>
<html>
<body>
<input class="debugMode${deBugMode}" id="id" name="id" value="${misEmrMdfreq.id}" readonly="readonly" title="病历主键">
<input class="debugMode${deBugMode}" id="emrId" name="emrId" value="${emrId}" readonly="readonly" title="申请信息主键">
<center>
    <h2 style="text-align:center">${systemConfig.printTitle}院前病历修改申请</h2>

    <form id="mdfReq">
        <table width="60%" border="0" class="editForm">
            <tr group="doc">
                <td class="text_into">申请原因</td>
                <td class="text_edit">${mdfReason}</td>
                <td class="text_into">申请时间</td>
                <td class="text_edit">
                    <fmt:formatDate value="${misEmrMdfreq.createTime}" pattern="yyyy-MM-dd HH:mm:ss" type="date"
                                    dateStyle="long"/>
                </td>
            </tr>
            <tr group="doc">
                <td class="text_into">备注</td>
                <td class="text_edit" colspan="3">
                    <input class="input_full"
                           id="mdfRemark" name="mdfRemark" value="${misEmrMdfreq.mdfRemark}" type="text">
                </td>
            </tr>
            <tr>
                <td colspan="4">
                    <hr>
                </td>
            </tr>
        </table>
    </form>

    <!-- 如果病历已经提交了才能看到申请按钮 -->
    <!-- 如果该病历下不存在未审核的信息 -->
    <c:if test="${isCommited==1&&misEmrMdfreq==null }">
        <button type="button" class="btn" id="saveMdfReq">发起申请</button>
    </c:if>

</center>
<hr>
<table width="100%" border="1" id="table_list" class="table_list">
    <tr>
        <th>病人名称</th>
        <th>主诉</th>
        <th>申请人</th>
        <th>申请时间</th>
        <th>申请原因</th>
        <th>审批结果</th>
    </tr>
    <c:forEach var="list" items="${list}">
        <tr title="申请备注：${list.mdfRemark }  审批备注：${list.recRemark}">
            <td>${list.name}</td>
            <td title="${list.chiefComplaint }">
                <c:choose>
                    <c:when test="${fn:length(list.chiefComplaint)>15}">
                        ${fn:substring(list.chiefComplaint,0,15)} ……
                    </c:when>
                    <c:otherwise>
                        ${list.chiefComplaint }
                    </c:otherwise>
                </c:choose>
            </td>
            <td>${list.reqMember}</td>
            <td><fmt:formatDate value="${list.createTime }" pattern="yyyy-MM-dd HH:mm:ss" type="date"
                                dateStyle="long"/></td>
            <td>${list.mdfReason_text}</td>
            <td>
                <c:if test="${list.reqResult == 0}">未审批</c:if>
                <c:if test="${list.reqResult == 1}"><font style="color: green">通过</font></c:if>
                <c:if test="${list.reqResult == 2}"><font style="color: red">驳回</font></c:if>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
