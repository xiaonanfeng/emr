<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@ include file="/taglibs.jsp" %>
<%@ include file="/businit/MIS_EMR_MDFREQ_PRV-init.jsp" %>
<!DOCTYPE html>
<html>
<body>

<input class="debugMode${deBugMode}" id="id" name="id" value="${misEmrMdfreq.id}" readonly="readonly" title="病历主键">
<input class="debugMode${deBugMode}" id="emrId" name="emrId" value="${param.emrId}" readonly="readonly" title="申请信息主键">

<center>
    <h2 style="text-align:center">${systemConfig.printTitle}院前病历修改申请</h2>
    <table width="60%" border="0" class="editForm">
        <tr>
            <td class="text_into">申请人</td>
            <td class="text_edit">${sysMemberInfo.name}</td>
        </tr>
        <tr>
            <td class="text_into">审核人</td>
            <td class="text_edit">${recMember}</td>
        </tr>
        <tr>
            <td class="text_into">申请原因</td>
            <td class="text_edit">${mdfReason}</td>
        </tr>
        <tr>
            <td class="text_into">备注</td>
            <td class="text_edit">
                <input class="input_full"
                       id="mdfRemark" name="mdfRemark" value="${misEmrMdfreq.mdfRemark}" type="text">
            </td>
        </tr>
        <tr>
            <td class="text_into">申请时间</td>
            <td class="text_edit">
                <fmt:formatDate value="${misEmrMdfreq.createTime}" pattern="yyyy-MM-dd HH:mm:ss" type="date"
                                dateStyle="long"/>
            </td>
        </tr>
        <c:if test="${orgid == munit}">
            <tr>
                <td class="text_into">审批结果</td>
                <td class="text_edit">
                    <select id="reqResult" name="reqResult">
                        <option value="0"></option>
                        <option value="1">通过</option>
                        <option value="2">驳回</option>
                    </select>
                </td>
            </tr>
            <tr>
                <td class="text_into">审批意见</td>
                <td class="text_edit">
                    <input class="input_full"
                           id="recRemark" name="recRemark" value="${misEmrMdfreq.recRemark}" type="text">
                </td>
            </tr>
        </c:if>
    </table>
    <c:if test="${orgid == munit}">
        <button type="button" class="btn" id="saveMdfReqRec">保存</button>
    </c:if>
    <c:if test="${orgid != munit}">
        <button type="button" class="btn" id="saveMdfReq">保存</button>
    </c:if>
</center>
</body>
</html>
