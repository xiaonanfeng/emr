<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@ include file="/taglibs.jsp" %>
<%@ include file="/businit/MIS_EMR_HANDOVER-init.jsp" %>

<!DOCTYPE html>
<html>
<head>
    <title>${systemConfig.systemTitle }</title>
</head>
<body>
<form id="vld_handOver_form">
    <h2 style="text-align:center">${systemConfig.printTitle}院前急救交接记录</h2>
    <table width="100%" border="0" class="editForm">
        <tr>
            <th class="text_decollator" colspan="8" id="basicInfo">
                <span>基本信息</span>
            </th>
        </tr>
        <tr group="basicInfo">
            <td class="text_into">出诊单位</td>
            <td class="text_edit">${szfz}</td>
            <td class="text_into">交接时间</td>
            <td class="text_edit"><input id="hoTime" name="hoTime" class="" type="text"
                                         value="<fmt:formatDate value="${misEmrHandover.hoTime}" pattern="yyyy-MM-dd HH:mm:ss" type="date" dateStyle="long" />"
                                         onfocus="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})"
                                         class="input_full"/></td>
            <td class="text_into">送往医院</td>
            <td class="text_edit">${sentTo}</td>
        </tr>
        <tr group="basicInfo">
            <td class="text_into">姓名</td>
            <td class="text_edit">${name }</td>
            <td class="text_into">性别</td>
            <td class="text_edit">${sex}</td>
            <td class="text_into">
                <span style="width:20%">年龄：</span>
                <span id="age"></span>
            </td>
            <td class="text_edit"><select id="timeScope">
                <option>&nbsp;</option>
                <option value="1">分</option>
                <option value="60">时</option>
                <option value="1440">天</option>
                <option value="43200">月</option>
                <option value="518400">岁</option>
            </select></td>
            <td class="text_into">病情判断</td>
            <td class="text_edit">${condition}</td>
        </tr>
        <tr>
            <th class="text_decollator" colspan="8" id="basicInfo">
                <span>主诉</span>
            </th>
        </tr>
        <tr group="basicInfo">
            <td class="text_into"></td>
            <td class="text_edit" colspan="7">
                ${chiefComplaint}
            </td>
        </tr>
        <tr>
            <th class="text_decollator" colspan="8" id="basicInfo">
                <span>交接时主要病情</span>
            </th>
        </tr>
        <tr group="basicInfo">
            <td class="text_into"></td>
            <td class="text_edit" colspan="7">
                <input id="hoMainreason" type="text"
                       name="hoMainreason" value="${misEmrHandover.hoMainreason}"
                       class="input_full"/></td>
        </tr>
        <tr>
            <th class="text_decollator" colspan="8"><span>交接时体征</span></th>
        </tr>
        <tr>
            <td class="text_into">脉搏</td>
            <td class="text_edit"><input class="input_NOfull" type="text"
                                         style="width:60px;" id="hoP" name="hoP" value="${misEmrHandover.hoP}"/>次/分
            </td>
            <td class="text_into">呼吸</td>
            <td class="text_edit"><input class="input_NOfull" type="text"
                                         style="width:60px;" id="hoR" name="hoR" value="${misEmrHandover.hoR}"/>次/分
            </td>
            <td class="text_into">血压</td>
            <td class="text_edit"><input class="input_NOfull" type="text"
                                         style="width:60px;" id="hoBpL" name="hoBpL"
                                         value="${misEmrHandover.hoBpL}"/> / <input class="input_NOfull" type="text"
                                                                                    style="width:60px;" id="hoBpH"
                                                                                    name="hoBpH"
                                                                                    value="${misEmrHandover.hoBpH}"/>
                mmHg
            </td>
            <td class="text_into">神志状态</td>
            <td class="text_edit">${hoConscious}</td>
        </tr>
        <tr>
            <td class="text_edit" colspan="8">
                <input class="input_full" type="text"
                       id="statOther" name="statOther" value="${misEmrHandover.statOther }" placeholder="其他重要体征"/>
            </td>
        </tr>
        <tr>
            <th class="text_decollator" colspan="8"><span>交接时诊断</span>
                <button class="btn btn_yellow" type="button"
                        onclick="open_layer('选择病情诊断','${ctx}/misEmrPreaidVs.do?method=findPrimDiag&values=${misEmrHandover.hoDiag}&flag=hoDiag')">
                    交接诊断
                </button>
            </th>
        </tr>
        <tr>
            <td style="vertical-align:bottom;text-align:center;" colspan="8"><textarea
                    style="width: 100%" rows="4" id="hoDiagText" name="hoDiagText"
                    placeholder="点击右侧按钮选择！" readonly="readonly"></textarea>
                <input id="hoDiag" name="hoDiag" type="text"
                       class="debugMode${deBugMode}" value="${vMisEmrHandover.primDiag}"
                       readonly="readonly">
            </td>
        </tr>
        <tr>
            <td class="text_edit" colspan="8">
                <input class="input_full" type="text"
                       id="diagOther" name="diagOther" value="${misEmrHandover.diagOther }" placeholder="其他诊断"/>
            </td>
        </tr>
        <tr>
            <th class="text_decollator" colspan="8"><span>处理措施</span>
                <button class="btn btn_yellow" type="button"
                        onclick="open_layer('选择处理措施','${ctx}/misEmrPreaidVs.do?method=findSceneTreatlects&values=${misEmrHandover.hoTreat}&flag=hoTreat')">
                    处理措施
                </button>
            </th>
        </tr>
        <tr>
            <td class="text_edit" colspan="8">
					<textarea
                            style="width: 100%" rows="4" id="hoTreatText" name="hoTreatText"
                            placeholder="点击右侧按钮选择！" readonly="readonly"></textarea>
                <input id="hoTreat" name="hoTreat"
                       class="debugMode${deBugMode}" value="${vMisEmrHandover.sceneTreat}"
                       readonly="readonly">
            </td>
        </tr>
        <tr>
            <td class="text_edit" colspan="8">
                <input class="input_full" type="text"
                       id="hoTreatOther" name="hoTreatOther" value="${misEmrHandover.hoTreatOther }"
                       placeholder="其他处理措施"/>
            </td>
        </tr>
        <tr>
            <td class="text_into">出诊医师</td>
            <td class="text_edit"><input class="input_full" type="text" id="doctor" name="doctor" value="${doctor }"
                                         readonly="readonly"/></td>
            <td class="text_into"></td>
            <td class="text_into">接诊医师</td>
            <td class="text_edit"><input class="input_full" type="text" id="hoDoctor" name="hoDoctor"
                                         value="${misEmrHandover.hoDoctor}"/></td>
        </tr>
    </table>
</form>

<div style="text-align:center;">
    <button type="button" class="btn" id="saveHandover">保存</button>
    <button type="button" class="btn" id="printHandover">打印</button>
</div>

<input class="debugMode${deBugMode}" id="id" name="id"
       value="${misEmrBasicinfo.id}" readonly="readonly" title="主键">

<div class="the_zhezhao" id="the_zhezhao"></div>
<!--带关闭按钮的层 -->
<div id="layer_box" class="layer_box">
    <div class="layer_title_bg" id="layer_title_bg">
        <img src="${ctx}/css/images/ZXICO/title_ico.gif" width="12"
             height="9"/> <span id="layer_title"></span>
        <div class="layer_closed_ico" onclick="closed_layer('layer_box')"></div>
    </div>
    <div class="index_loading_bg" id="index_loading_bg"></div>
    <iframe src="${ctx}/loading.html" id="iframe_layer"
            name="iframe_layer" frameborder="0" width="300" height="160"
            scrolling="auto" style="margin:0px; padding:0px; z-index:1;"></iframe>
</div>

<%@ include file="/busvald/handOverValidator.jsp" %>

</body>
</html>	
	
	
	