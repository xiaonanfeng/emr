<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@ include file="/businit/MIS_EMR_AE-init.jsp" %>
<!-- 辅助检查 -->
<form id="vld_Ae_form">
    <div id="ae" title="辅助检查">
        <table width="100%" border="0" class="editForm">
            <tr>
                <th colspan="6" class="text_decollator" id="thAe"><span>辅助检查</span></th>
            </tr>
            <tr group="thAe">
                <td class="text_into">快速血糖检测</td>
                <td class="text_edit">
                    ${rbgTest}
                    <input id="rbg" name="rbg" class="" type="text" style="width: 36px;">mmol/L
                </td>
                <td class="text_into">血氧饱和度</td>
                <td class="text_edit">
                    ${bosTest}
                    <input id="bos" name="bos" class="" type="text" style="width: 36px;">%
                </td>
                <%--心电图检查情况：根据各地叫法不同可以更改--%>
                <td class="text_into">${systemConfig.ecgTdText }</td>
                <td class="text_edit">${ecg}</td>
            </tr>
            <tr style="display: none;">
                <td class="text_into">心电图检查时间</td>
                <td class="text_edit">
                    <input id="ecgTime" name="ecgTime"
                           class="" type="text"
                           value="<fmt:formatDate value="${misEmrAe.ecgTime}" pattern="yyyy-MM-dd HH:mm:ss" type="date" dateStyle="long" />"
                           style="90%"
                           onfocus="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})"></td>
                <td class="text_into">心电图检交于</td>
                <td class="text_edit">${ecgTo}</td>
            </tr>
            <tr group="thAe">
                <td class="text_into" group=ecgLead>心电图导联</td>
                <td class="text_edit" group=ecgLead>
                    ${ecgLead }
                </td>
                <td class="text_into">心电监护情况</td>
                <td class="text_edit">${ecgMonitor}</td>
            <tr group="thAe">
                <td class="text_into">其他辅助检查</td>
                <td class="text_edit" colspan="5"><input id="aeOther"
                                                         name="aeOther" class="input_full" type="text"></td>
            </tr>
            <tr style="display: none;">
                <td class="text_into">其他/专科</td>
                <td class="text_edit" colspan="5"><input id="ohters"
                                                         name="ohters" class="input_full" type="text"></td>
            </tr>

            <tr hideGroup="thEcg">
                <th colspan="6" class="text_decollator"><span>${systemConfig.ecgDiagTdText }</span>
                    <button class="btn btn_yellow" type="button" id="addEcg"
                            onclick="open_layer('${systemConfig.ecgDiagTdText }','${ctx}/misEmrAe.do?method=findMultiSelects&values=${misEmrAe.ecgDiag}&flag=ecgDiag');">
                        ${systemConfig.ecgDiagTdText }
                    </button>
                </th>
            </tr>
            <tr hideGroup="thEcg">
                <td colspan="6" style="vertical-align:bottom;text-align:center;">
                    <textarea style="width: 99%" id="ecgDiagText" name="ecgDiagText" placeholder="请选择"
                              readonly="readonly"></textarea>
                    <input id="ecgDiag" name="ecgDiag" value="" readonly="readonly" class="debugMode${deBugMode}">
                </td>
            </tr>

            <tr>
                <td class="text_edit" colspan="6">
                    <input id=ecgOther
                           name="ecgOther" class="input_full" type="text" placeholder="其他" value="${misEmrAe.ecgOther}">
                </td>
            </tr>
        </table>
    </div>
</form>

<div style="text-align:center;">
    <button type="button" class="btn" id="saveAe">保存</button>
    <button type="button" class="btn commitButton" style="margin-left:150px">提交</button>
</div>	
