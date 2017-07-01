<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@ include file="/businit/MIS_EMR_PE-init.jsp" %>
<form id="vld_Pe_form">
    <table width="100%" border="0" class="editForm">
        <tr>
            <th class="text_decollator" colspan="8" id="normalAndLife">
                <span>生命体征及一般情况</span>
            </th>
        </tr>
        <tr group="normalAndLife">
            <td class="text_into">T</td>
            <td class="text_edit" style="word-break: keep-all;">
                ${tTest}
                <input class="" style="width:36px;" type="text" name="t" id="t" value="${misEmrPe.t}" placeholder="温度">
                ℃
            </td>
            <td class="text_into">P</td>
            <td class="text_edit" style="word-break: keep-all;">
                ${pTest}
                <input class="" style="width:36px;" type="text" name="p" id="p" value="${misEmrPe.p}" placeholder="脉搏">次/分
            </td>
            <td class="text_into">R</td>
            <td class="text_edit" style="word-break: keep-all;">
                ${rTest}
                <input class="" style="width:36px;" type="text" name="r" id="r" value="${misEmrPe.r}"
                       placeholder="0-50">次/分
            </td>
            <td class="text_into">BP</td>
            <td class="text_edit">
                ${bpTest}
                <input class="input_NOfull" style="width:36px;" type="text" name="pe-bpL" id="pe-bpL"
                       value="${misEmrPe.bpL}">
                /
                <input class="input_NOfull" style="width:36px;" type="text" name="pe-bpH" id="pe-bpH"
                       value="${misEmrPe.bpH}">
                mmHg
            </td>
        </tr>
        <tr group="normalAndLife">
            <td class="text_into">体位</td>
            <td class="text_edit">${posture}</td>
            <td class="text_into">神志</td>
            <td class="text_edit">${conscious}</td>
            <td class="text_into">皮肤</td>
            <td class="text_edit">${skin}</td>
            <td class="text_into">口唇紫绀</td>
            <td class="text_edit">${cyanosis}</td>
        </tr>
        <tr>
            <th class="text_decollator" colspan="8" id="headAndNeck"><span>头颈部</span></th>
        </tr>
        <tr group="headAndNeck">
            <td class="text_into">左侧瞳孔</td>
            <td class="text_edit">${hnEyeTestL }
                <input class="" style="width:36px;" type="text" name="hnEyeL" id="hnEyeL" value="${misEmrPe.hnEyeL}">mm
            </td>
            <td class="text_into">对光反射</td>
            <td class="text_edit">${hnPlrL }</td>
            <td class="text_into">右侧瞳孔</td>
            <td class="text_edit">${hnEyeTestR }
                <input class="" style="width:36px;" type="text" name="hnEyeR" id="hnEyeR" value="${misEmrPe.hnEyeR}">mm
            </td>
            <td class="text_into">对光反射</td>
            <td class="text_edit">${hnPlrR }</td>
        </tr>
        <tr group="headAndNeck">
            <td class="text_into"></td>
            <td class="text_edit" colspan="7">
                <input class="input_full" type="text" name="headNeck" id="headNeck" value="${misEmrPe.headNeck}">
            </td>
        </tr>

        <tr>
            <th class="text_decollator" colspan="8" id="th_chest">
                <span>胸部</span>
            </th>
        </tr>
        <tr group="th_chest">
            <td class="text_edit" colspan="8"><input class="input_full" type="text" id="chest" name="chest"></td>
        </tr>
        <tr>
            <th class="text_decollator" colspan="8" id="th_lung">
                <span>肺部</span>
            </th>
        </tr>
        <tr group="th_lung">
            <td class="text_edit" colspan="8">
                <input class="input_full" type="text" id="lung" name="lung">
            </td>
        </tr>
        <tr>
            <th class="text_decollator" colspan="8" id="th_heart">
                <span>心脏</span>
            </th>
        </tr>
        <tr group="th_heart">
            <td class="text_edit" colspan="8">
                <input class="input_full" type="text" id="heart" name="heart">
            </td>
        </tr>
        <tr>
            <th class="text_decollator" colspan="8" id="th_abd">
                <span>腹部</span>
            </th>
        </tr>
        <tr group="th_abd">
            <td class="text_edit" colspan="8"><input class="input_full" type="text" id="abdomen" name="abdomen"></td>
        </tr>
        <tr>
            <th class="text_decollator" colspan="8" id="th_limb">
                <span>四肢</span>
            </th>
        </tr>
        <tr group="th_limb">
            <td class="text_edit" colspan="8">
                <input class="input_full" type="text" id="limb" name="limb">
            </td>
        </tr>
        <tr>
            <th class="text_decollator" colspan="8" id="th_spine">
                <span>脊柱</span>
            </th>
        </tr>
        <tr group="th_spine">
            <td class="text_edit" colspan="8"><input class="input_full" type="text" id="spine" name="spine"></td>
        </tr>
        <tr>
            <th class="text_decollator" colspan="8" id="th_ner">
                <span>神经系统</span>
            </th>
        </tr>
        <tr group="th_ner">
            <td class="text_edit" colspan="8">
                <input class="input_full" type="text" id="nerveReflex" name="nerveReflex">
            </td>
        </tr>
        <tr>
            <th class="text_decollator" colspan="8">
                <span>其他</span>
            </th>
        </tr>
        <tr>
            <td class="text_edit" colspan="8">
                <input class="input_full" type="text" id="peOthers" name="peOthers" value="">
            </td>
        </tr>
    </table>
</form>

<div style="text-align:center">
    <button type="button" class="btn" id="savePe">保存</button>
    <button type="button" class="btn commitButton" style="margin-left:150px;">提交</button>
</div>
