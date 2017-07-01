<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@ include file="/businit/MIS_EMR_SE_OB-init.jsp" %>
<div id="ob" title="产科" style="display: none;">
    <form id="vld_seOb_form">
        <table width="100%" border="0" class="editForm">
            <th class="text_decollator" colspan="8" id="thOB"><span>产科</span></th>
            <tr group="thOB">
                <td class="text_into">见红</td>
                <td class="text_edit">${bloodSee}</td>
                <td class="text_into">宫缩</td>
                <td class="text_edit">${uterContrac}</td>
                <td class="text_into">胎膜</td>
                <td class="text_edit">${caul}</td>
                <td class="text_into">羊水</td>
                <td class="text_edit">${amnioticFluid}</td>
            </tr>
            <tr group="thOB">
                <td class="text_into">胎心（次/分 ）</td>
                <td class="text_edit"><input id="fetalHeart" name="fetalHeart"
                                             class="input_full" type="text"></td>
                <td class="text_into">宫口（CM）</td>
                <td class="text_edit"><input id="cervix" name="cervix"
                                             class="input_full" type="text"></td>
                <td class="text_into">先露</td>
                <td class="text_edit">${present}</td>
                <td class="text_into">其他</td>
                <td class="text_edit"><input id="obother" name="obother"
                                             class="input_full" type="text" placeholder=""></td>
            </tr>
        </table>
    </form>
    <div>
        <button type="button" class="btn" id="saveSeOb">保存</button>
    </div>
</div>
