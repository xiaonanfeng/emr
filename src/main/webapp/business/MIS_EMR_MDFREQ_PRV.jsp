<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@ include file="/taglibs.jsp" %>
<%@ include file="/businit/MIS_EMR_MDFREQ_PRV-init.jsp" %>
<!DOCTYPE html>
<html>
<body>
<center>
    <input id="id" value="${misEmrMdfreq.id }" type="hidden">
    <input id="emrId" value="${misEmrMdfreq.emrId }" type="hidden">

    <table width="95%" border="0" class="editForm">
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
            <td class="text_into">再提交时限</td>
            <td class="text_edit">
                <input placeholder="再次自动提交时间" type="text" name="comtagain" id="comtagain" value=""
                       onfocus="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})"/>
            </td>
        </tr>
        <tr>
            <td class="text_into">备注</td>
            <td class="text_edit">
                <input type="text" name="recRemark" id="recRemark" value=""/>
            </td>
        </tr>
        <tr>
            <td class="text_into">审批人</td>
            <td class="text_edit">
                ${sysMemberInfo.name }
            </td>
        </tr>
    </table>
    <button type="button" class="btn" id="saveMdfReqRec">保存</button>
</center>
</body>
</html>
