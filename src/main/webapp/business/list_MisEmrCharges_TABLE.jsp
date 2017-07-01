<%@ page language="java" import="java.util.*" pageEncoding="utf-8" %>
<%@ include file="/taglibs.jsp" %>
<%@ include file="/businit/MIS_EMR_CHARGES_TABLE-init.jsp" %>
<!DOCTYPE html>
<html>
<body>
<input class="debugMode${deBugMode}" id="emrId" name="emrId" value="${misEmrBasicinfo.id}" readonly="readonly"
       title="病历主键">

<center>
    <h2 style="text-align:center">${systemConfig.printTitle}院前急救收费记录</h2>
    <form id="vld_charges">
        <table width="80%" border="0" cellpadding="0" cellspacing="0" class="table_list">
            <tr>
                <th class="debugMode${deBugMode}">debug用</th>
                <th>收费类别</th>
                <th>收费项目</th>
                <th>收费标准（元）</th>
                <th>应收（元）</th>
                <th>实收（元）</th>
                <th>说明</th>
            </tr>
            <c:forEach var="list" items="${list}">
                <tr title="${list.itemcode }">
                    <td class="debugMode${deBugMode}"><input id="id${list.itemcode}" name="id" class="ids" type="hidden"
                                                             value=""></td>
                    <td>${list.name}</td>
                    <td>${list.itemname}</td>
                    <td>${list.standards}<input id="standards${list.itemcode}" name="standards" class="standards"
                                                type="hidden" value="${list.standards}"></td>
                    <td width="5%"><input id="charge${list.itemcode}" name="charge" class="charges" type="text"
                                          value="${list.standards}"></td>
                    <td width="5%"><input id="received${list.itemcode}" name="received" class="receives" type="text"
                                          value="" flag="${list.itemcode}"></td>
                    <td width="30%"><input id="remark${list.itemcode}" name="remark" class="remarks input_full"
                                           type="text" value=""></td>
                </tr>
            </c:forEach>
        </table>
        <table width="80%" border="0" class="editForm">
            <tr>
                <td class="text_into">收费人</td>
                <td class="text_edit">${collectorId }</td>
                <td class="text_into">应收总计</td>
                <td class="text_edit"><input id="chargeTotal" name="chargeTotal" type="text"
                                             value="${misEmrChargesTable.chargeTotal }" readonly="readonly"></td>
                <td class="text_into">实收总计</td>
                <td class="text_edit"><input id="receivedTotal" name="receivedTotal" type="text"
                                             value="${misEmrChargesTable.receivedTotal }" readonly="readonly"></td>
            </tr>
            <tr>
                <td class="text_into">差额原因</td>
                <td class="text_edit">${reasoncode }</td>
                <td class="text_into">差额</td>
                <td class="text_edit"><input id="balanceTotal" name="balanceTotal" type="text"
                                             value="${misEmrChargesTable.balanceTotal }" readonly="readonly"></td>
                <td class="text_into">发票号</td>
                <td class="text_edit"><input id="invoiceNo" name="invoiceNo" type="text"
                                             value="${misEmrChargesTable.invoiceNo }"></td>
            </tr>
            <tr>
                <td class="text_into">收费类型</td>
                <td class="text_edit">${chargeKind }</td>
                <td class="text_into">备注</td>
                <td class="text_edit" colspan="3"><input id="remark" name="remark" class="input_full" type="text"
                                                         value="${misEmrChargesTable.remark }"></td>
            </tr>
        </table>
    </form>

    <button type="button" class="btn" id="saveCharges">保存</button>

</center>
<%@ include file="/busvald/chargesValidator.jsp" %>
<!-- <button type="button" class="btn" id="printCharge">打印</button> -->
</body>
</html>
