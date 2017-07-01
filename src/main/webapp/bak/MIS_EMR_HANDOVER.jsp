<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@ include file="/taglibs.jsp" %>
<%@ include file="/businit/MIS_EMR_HANDOVER-init.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <title>${systemConfig.systemTitle }</title>
</head>
<body title="CTRL+P进行打印">
<h2 style="text-align:center">郑州院前急救交接记录</h2>
<table width="100%" border="1" class="editForm_BL">
    <tr>
        <th class="text_decollator" colspan="8">基础信息</th>
    </tr>
    <tr>
        <td class="text_into">出诊单位</td>
        <td class="text_edit" colspan="3">${sentTo}</td>
        <td class="text_into">交接时间</td>
        <td class="text_edit" colspan="3"><input id="hoTime" name="hoTime" class=""
                                                 type="text"
                                                 value="<fmt:formatDate value="${misEmrHandover.hoTime}" pattern="yyyy-MM-dd HH:mm:ss" type="date" dateStyle="long" />"
                                                 onfocus="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})"
                                                 class="input_full"/></td>
    </tr>
    <tr>
        <td class="text_into" style="width: 5%">姓名</td>
        <td class="text_edit">${misEmrBasicinfo.name }</td>
        <td class="text_into" style="width: 5%">性别</td>
        <td class="text_edit">${sex}</td>
        <td class="text_into" style="width: 5%">年龄</td>
        <td class="text_edit"><span id="ageScope"></span></td>
        <td class="text_into" style="width: 5%">病情判断</td>
        <td class="text_edit">${condition}</td>
    </tr>
    <tr>
        <td class="text_into">主诉</td>
        <td class="text_into" colspan="7">
            ${misEmrBasicinfo.chiefComplaint}</td>
    </tr>
    <tr>
        <td class="text_into">交接原因</td>
        <td class="text_into" colspan="7">
            <input id="hoMainreason" type="text"
                   name="hoMainreason" value="${vMisEmrHandover.hoMainreason}"
                   class="input_full" readonly="readonly"/></td>
    </tr>
    <tr>
        <th class="text_decollator" colspan="8">交接时病情</th>
    </tr>
    <tr>

        <td class="text_into">脉搏</td>
        <td class="text_edit">
            <nobr><input class="input_NOfull" style="width:50px;" type="text"
                         id="hoP" name="hoP" value=""/>次/分
        </td>
        <td class="text_into">呼吸</td>
        <td class="text_edit">
            <nobr><input class="input_NOfull" style="width:50px;" type="text"
                         id="hoR" name="hoR" value=""/>次/分
        </td>
        <td class="text_into">血压</td>
        <td class="text_edit">
            <nobr><input class="input_NOfull" style="width:50px;" type="text"
                         id="hoBpL" name="hoBpL"
                         value=""/> / <input class="input_NOfull" style="width:50px;" type="text"
                                             id="hoBpH" name="hoBpH"
                                             value=""/> mmHg
        </td>
        <td class="text_into">神志状态</td>
        <td class="text_edit">
            <nobr>
            ${hoConscious}</td>
    </tr>
    <tr>
        <th class="text_decollator" colspan="8">交接时诊断为</th>
    </tr>
    <tr>
        <td style="vertical-align:bottom;text-align:center;" colspan="8">
					<textarea style="width: 99%;border: 0px;" rows="4" id="hoDiagText" name="hoDiagText"
                              placeholder="点击右侧按钮选择！" readonly="readonly"></textarea>
            <input id="hoDiag" name="hoDiag" type="text"
                   class="deBugMode${deBugMode}" value="${vMisEmrHandover.primDiag}"
                   readonly="readonly">
        </td>
    </tr>
    <tr>
        <th class="text_decollator" colspan="8">交接处理方式</th>
    </tr>
    <tr>
        <td class="text_into" colspan="8">
					<textarea style="width: 99%;border: 0px;" rows="4" id="hoTreatText" name="hoTreatText"
                              placeholder="点击右侧按钮选择！" readonly="readonly"></textarea>
            <input id="hoTreat" name="hoTreat"
                   class="deBugMode${deBugMode}" value="${vMisEmrHandover.sceneTreat}"
                   readonly="readonly">
        </td>
    </tr>
    <tr>
        <td class="text_into">出诊医师</td>
        <td class="text_into" colspan="3"><input class="input_full" type="text" id="doctor" name="doctor"/></td>
        <td class="text_into">接诊医师</td>
        <td class="text_into" colspan="3"><input class="input_full" type="text" id="hoDoctor" name="hoDoctor"/></td>
    </tr>
</table>
</body>
</html>	
	
	
	