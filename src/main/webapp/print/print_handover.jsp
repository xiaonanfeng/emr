<!DOCTYPE html>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@ page import="com.zxit.share.Constants" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<html>
<head>
    <title>${systemConfig.printTitle}院前急救病历</title>
    <link rel="stylesheet" href="${ctx}/css/print/Style/bootstrap.css">
    <link rel="stylesheet" href="${ctx}/css/print/Style/table.css">
    <script src="${ctx}/js/jquery-2.1.1.min.js"></script>
    <script src="${ctx}/js/JC_js.js"></script>
    <style>
        .subtitle {
            height: 40px;
            font-size: 16px !important;
        }

        td {
            line-height: 25px;
        }
    </style>
</head>
<%@ include file="/businit/MIS_EMR_HANDOVER-init.jsp" %>
<body>
<div id="page1" class="page" style="page-break-after:always">
    <div class="table-title center strong">${systemConfig.printTitle}院前急救交接记录</div>
    <table class="printtable">
        <tr>
            <td class="strong center subtitle" colspan="8">基础信息</td>
        </tr>
        <tr>
            <td>出诊单位</td>
            <td colspan="7">${szfz}</td>
        </tr>
        <tr>
            <td>交接时间</td>
            <td>
                <fmt:formatDate value="${misEmrHandover.hoTime}" pattern="yyyy年MM月dd日 HH时mm分" type="date"
                                dateStyle="long"/>
            </td>
            <td>接诊单位</td>
            <td colspan="5">
                ${sentTo}
            </td>
        </tr>
        <tr>
            <td>姓名</td>
            <td style="min-width:100px">${name }</td>
            <td>性别</td>
            <td style="min-width:100px">${sex}</td>
            <td>年龄</td>
            <td style="min-width:100px">
                <span style="width:20%">年龄：</span>
                <span id="age"></span>
                <select id="timeScope" superSelect="normal" style="height: 20px;">
                    <option>&nbsp;</option>
                    <option value="1">分</option>
                    <option value="60">时</option>
                    <option value="1440">天</option>
                    <option value="43200">月</option>
                    <option value="518400">岁</option>
                </select>
            </td>
            <td>病情判断</td>
            <td style="min-width:100px">${condition}</td>
        </tr>
        <tr>
            <td>主诉</td>
            <td colspan="7">${chiefComplaint}</td>
        </tr>
        <tr style="min-height:50px">
            <td>交接原因</td>
            <td colspan="7">${misEmrHandover.hoMainreason}</td>
        </tr>
        <tr>
            <td colspan="8" class="strong center subtitle">交接时病情</td>
        </tr>
        <tr>
            <td>脉搏</td>
            <td>${misEmrHandover.hoP}次/分</td>
            <td>呼吸</td>
            <td>${misEmrHandover.hoR}次/分</td>
            <td>血压</td>
            <td>${misEmrHandover.hoBpL}/${misEmrHandover.hoBpH} mmHg</td>
            <td>神志状态</td>
            <td>${hoConscious}</td>
        </tr>
        <tr>
            <td colspan="8" class="strong center subtitle">交接时诊断为</td>
        </tr>
        <tr style="height:100px;vertical-align:top">
            <td colspan="8">${misEmrHandover.diagOther}</td>
        </tr>
        <tr>
            <td colspan="8" class="strong center subtitle">交接处理措施</td>
        </tr>
        <tr style="height:100px;vertical-align:top">
            <td colspan="8">${misEmrHandover.hoTreatOther}</td>
        </tr>
        <tr>
            <td>出诊医师</td>
            <td colspan="3">${doctor }</td>
            <td>接诊医师</td>
            <td colspan="3">${misEmrHandover.hoDoctor }</td>
        </tr>
    </table>
</div>
<button id="btn-print" class="btn" onclick="javascript:window.print()">
    <span class="glyphicon glyphicon-print" style="margin-left:5px"></span>打印
</button>
</body>
</html>