<%@ page language="java" import="java.util.*" pageEncoding="utf-8" %>
<%@ include file="/taglibs.jsp" %>
<%@ include file="/businit/MIS_EMR_CHARGES-init.jsp" %>
<!DOCTYPE html>
<html>
<body>
<input class="debugMode${deBugMode}" id="id" name="id" value="${id}" readonly="readonly" title="主键">
<input class="debugMode${deBugMode}" id="emrId" name="emrId" value="${misEmrBasicinfo.id}" readonly="readonly"
       title="病历主键">

<center>
    <form id="vld_charges_form">
        <h2 style="text-align:center">${systemConfig.printTitle}院前急救收费记录</h2>
        <table width="60%" border="0" class="editForm">
            <tr>
                <th class="text_decollator" colspan="6" id="basicInfo"><span>收费信息</span>
                </th>
            </tr>
            <tr>
                <td class="text_into">收费类别</td>
                <td class="text_edit">${type }</td>
                <td class="text_into">收费项目</td>
                <td class="text_edit" id="itemCodeTD"></td>
                <td class="text_into">项目标准</td>
                <td class="text_edit"><span id="standards"></span>0元</td>
            </tr>
            <tr>
                <td class="text_into">应收费</td>
                <td class="text_edit"><input id="charge" name="charge" class="input_full" type="text" value=""></td>
                <td class="text_into">实收费</td>
                <td class="text_edit"><input id="received" name="received" class="input_full" type="text" value=""></td>
            </tr>
            <tr>
                <td class="text_into">差额</td>
                <td class="text_edit"><input id="balance" name="balance" class="input_full" type="text" value=""
                                             readonly="readonly"></td>
                <td class="text_into">差额原因</td>
                <td class="text_edit">${reasoncode }</td>
            </tr>
            <tr>
                <td class="text_into">备注</td>
                <td class="text_edit" colspan="5">
						<textarea id="remark" name="remark"
                                  class="textarea_full" style="width: 100%;height: 30px"></textarea>
                </td>
            </tr>
            <tr>
                <td class="text_into">收费人</td>
                <td class="text_edit">${collectorId }</td>
                <td class="text_into">发票号</td>
                <td class="text_edit"><input id="invoiceNo" name="invoiceNo" class="input_full" type="text" value="">
                </td>
            </tr>
        </table>
        <button type="button" class="btn" id="saveCharges">保存</button>
    </form>
</center>


<table width="100%" border="0" cellpadding="0" cellspacing="0"
       class="table_list">
    <tr>
        <th class="debugMode${deBugMode}">debug用</th>
        <th>发票单号</th>
        <th>收费类别</th>
        <th>收费项目</th>
        <th>应收费</th>
        <th>实收费</th>
        <th>差额</th>
        <th>差额原因</th>
        <th>收费人</th>
        <th>操作</th>
    </tr>
    <c:forEach var="list" items="${list}">
        <tr title="${list.id }">
            <td class="debugMode${deBugMode}">${list.id} +++ ${list.emrId}</td>
            <td>${list.invoiceNo}</td>
            <td>${list.type_text}</td>
            <td>${list.itemcode}</td>
            <td>${list.charge}</td>
            <td>${list.received}</td>
            <td>${list.balance}</td>
            <td>${list.reason_text}</td>
            <td>${list.collectorText}</td>
            <td>
                <a class="search" chargesId="${list.id}">收费记录</a>
                <c:if test="${list.createUserid == sysMemberInfo.id}"> <!-- 填写人 -->
                    <img alt="删除" title="删除" src="${ctx}/css/images/ZXICO/delBig.png" style="cursor: pointer;"
                         onclick="del('${list.id}')"/>
                </c:if>
            </td>
        </tr>
    </c:forEach>
</table>
<%@ include file="/busvald/chargesValidator.jsp" %>
<!-- <button type="button" class="btn" id="printCharge">打印</button> -->
</body>
</html>
