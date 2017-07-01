<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@ include file="/businit/MIS_EMR_SE_PED-init.jsp" %>
<div id="ped" title="新生儿" style="display: none;">
    <table width="100%" border="0" class="editForm">
        <th class="text_decollator" colspan="5" id="thPED"><span>新生儿Apgar评分</span></th>
        <tr group="thPED">
            <td class="text_into">体征</td>
            <td class="text_edit">1分钟总分
                <input readonly="readonly"
                       id="apgar1" name="apgar1" class="input_full" type="text"
                       placeholder="自动计算" style="width:90px;">
            </td>
            <td class="text_edit">5分钟总分
                <input readonly="readonly"
                       id="apgar5" name="apgar5" class="input_full" type="text"
                       placeholder="自动计算" style="width:90px;">
            </td>
            <td class="text_edit">10分钟总分
                <input readonly="readonly"
                       id="apgar10" name="apgar10" class="input_full" type="text"
                       placeholder="自动计算" style="width:90px;">
            </td>
            <td class="text_edit">15分钟总分
                <input readonly="readonly"
                       id="apgar15" name="apgar15" class="input_full" type="text"
                       placeholder="自动计算" style="width:90px;">
            </td>
        <tr group="thPED">
            <td class="text_into">皮肤颜色</td>
            <td class="text_edit">${apgarAp1 }</td>
            <td class="text_edit">${apgarAp5 }</td>
            <td class="text_edit">${apgarAp10 }</td>
            <td class="text_edit">${apgarAp15 }</td>
        </tr>
        <tr group="thPED">
            <td class="text_into">心率（次/分）</td>
            <td class="text_edit">${apgarP1 }</td>
            <td class="text_edit">${apgarP5 }</td>
            <td class="text_edit">${apgarP10 }</td>
            <td class="text_edit">${apgarP15 }</td>
        </tr>
        <tr group="thPED">
            <td class="text_into">弹足底或插鼻管反应</td>
            <td class="text_edit">${apgarG1 }</td>
            <td class="text_edit">${apgarG5 }</td>
            <td class="text_edit">${apgarG10 }</td>
            <td class="text_edit">${apgarG15 }</td>
        </tr>
        <tr group="thPED">
            <td class="text_into">肌张力</td>
            <td class="text_edit">${apgarAc1 }</td>
            <td class="text_edit">${apgarAc5 }</td>
            <td class="text_edit">${apgarAc10 }</td>
            <td class="text_edit">${apgarAc15 }</td>
        </tr>
        <tr group="thPED">
            <td class="text_into">呼吸</td>
            <td class="text_edit">${apgarR1 }</td>
            <td class="text_edit">${apgarR5 }</td>
            <td class="text_edit">${apgarR10 }</td>
            <td class="text_edit">${apgarR15 }</td>
        </tr>
    </table>
    <div>
        <button type="button" class="btn" id="saveSePed">保存</button>
    </div>
</div>
