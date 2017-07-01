<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@ include file="/businit/MIS_EMR_SE_TRUMA-init.jsp" %>
<!-- 创伤，只有选创伤才显示 -->
<div id="truma" title="院前PHI/GCS" style="display: none;">
    <form id="vld_phi_form">
        <table width="100%" border="0" class="editForm">
            <th class="text_decollator" colspan="8" id="thPHI"><span>院前指数（PHI）</span></th>
            <tr group="thPHI">
                <td class="text_into">检查项目</td>
                <td class="text_edit">总分<input type="text" id="phiTotal"
                                               name="phiTotal" style="width: 30%" readonly="readonly"
                                               placeholder="保存后自动计算"/></td>
            </tr>
            <tr group="thPHI">
                <td class="text_into">呼吸</td>
                <td class="text_edit">${phiBr}</td>
                <td class="text_into">神志</td>
                <td class="text_edit">${phiCons}</td>
                <td class="text_into">收缩压（mmHg)</td>
                <td class="text_edit">${phiSbp}</td>
                <td class="text_into">脉率（次/分）</td>
                <td class="text_edit">${phiPr}</td>
            </tr>
        </table>
    </form>

    <form id="vld_gcs_form">
        <table width="100%" border="0" class="editForm">
            <tr>
                <th class="text_decollator" colspan="8" id="thGCS"><span>格拉斯哥评分（GCS）</span></th>
            </tr>
            <tr group="thGCS">
                <td class="text_into">检查项目</td>
                <td class="text_edit">总分<input type="text" id="dglsTotal"
                                               name="dglsTotal" style="width: 30%" readonly="readonly"
                                               placeholder="保存后自动计算"/></td>
            </tr>
            <tr group="thGCS">
                <td class="text_into">睁眼反应</td>
                <td class="text_edit">${dglsEr}</td>
                <td class="text_into">语言反应</td>
                <td class="text_edit">${dglsVr}</td>
                <td class="text_into">运动反应</td>
                <td class="text_edit">${dglsMr}</td>
                <td class="text_into"></td>
                <td class="text_edit"></td>
            </tr>
        </table>
    </form>
    <div>
        <button type="button" class="btn" id="saveSeTruma">保存</button>
    </div>
</div>

