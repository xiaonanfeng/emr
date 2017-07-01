<%@ page language="java" import="java.util.*" pageEncoding="utf-8" %>
<%@ include file="/businit/MIS_EMR_SE_GYN-init.jsp" %>
<div id="segyn" title="妇科" style="display: none;">
    <form id="vld_seGyn_form">
        <table width="100%" border="0" class="editForm">
            <th class="text_decollator" colspan="10" id="thGYN">
                <span>妇科检查</span>
            </th>
            <tr group="thGYN">
                <td class="text_into">婚姻状况</td>
                <td class="text_edit">${martialStatus }</td>
                <td class="text_into">结婚年龄（岁）</td>
                <td class="text_edit"><input class="input_full" type="text"
                                             id="marAge" name="marAge"></td>
                <td class="text_into">孕</td>
                <td class="text_edit"><input class="input_full" type="text"
                                             id="pregnancy" name="pregnancy"></td>
                <td class="text_into">产</td>
                <td class="text_edit"><input class="input_full" type="text"
                                             id="childbirth" name="childbirth"></td>
            </tr>
            <tr group="thGYN">
                <td class="text_into">近期性生活</td>
                <td class="text_edit">${sexLife }</td>
                <td class="text_into">初潮年龄（岁）</td>
                <td class="text_edit"><input class="input_full" type="text"
                                             id="aom" name="aom"></td>
                <td class="text_into">经期（天）</td>
                <td class="text_edit"><input class="input_full" type="text"
                                             id="period" name="period"></td>
                <td class="text_into">月经周期（天）</td>
                <td class="text_edit"><input class="input_full" type="text"
                                             id="cycle" name="cycle"></td>
                <td class="text_into">末次月经日期</td>
                <td class="text_edit"><input class="input_full" type="text"
                                             id="lmp" name="lmp" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})">
                </td>
            </tr>
        </table>
    </form>
    <div>
        <button type="button" class="btn" id="saveSeGyn">保存</button>
    </div>
</div>


