<!DOCTYPE html>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<html>
<title>${systemConfig.printTitle}急救中心院前急救护理记录单</title>
<link rel="stylesheet" href="${ctx}/css/print/Style/bootstrap.css">
<link rel="stylesheet" href="${ctx}/css/print/Style/table.css">
<script src="${ctx}/js/jquery-2.1.1.min.js"></script>
<script src="${ctx}/js/JC_js.js"></script>
<style>
    td {
        line-height: 25px;
        min-width: 50px
    }

    tr td {
        text-align: center;
    }

    td span {
        min-width: 65px;
        display: inline-block;
    }

    [data-control='bind'] span {
        min-width: 35px;
    }

    .printtable tr td {
        font-size: 12pt;
    }

    .subtitle {
        height: 40px
    }
</style>
<script>
    setTimeout(function () {
        $('input[type="checkbox"],input[type="radio"]').each(function (index, element) {
            if ($(element).is(':checked')) {
                $(element).after('<span style="margin:0px">(√)</span>');
            } else {
                $(element).after('<span style="margin:0px">(&nbsp;)</span>');
            }
            $(element).hide();
        })
    }, 500)
</script>
</head>
<body>
<%@ include file="/businit/MIS_EMR_NURSING_RECORD-init.jsp" %>
<div id="page1" class="page" style="page-break-after:always">
    <div class="table-title center strong" style="margin-top: 65px;">宁波市急救中心院前急救护理记录单</div>
    <table class="printtable">
        <tr>
            <td style="width: 85px;">患者姓名</td>
            <td colspan="2">${misEmrBasicinfo.name}</td>
            <td style="width: 60px;">性别</td>
            <td>${sex }</td>
            <td>年龄</td>
            <td>
                <span id="age"></span>
                <select id="timeScope" superSelect="normal" style="height: 20px">
                    <option>&nbsp;</option>
                    <option value="1">分</option>
                    <option value="60">时</option>
                    <option value="1440">天</option>
                    <option value="43200">月</option>
                    <option value="518400">岁</option>
                </select>
            </td>
            <td>病历号</td>
            <td colspan="2">${misEmrBasicinfo.emrCode }</td>
        </tr>
        <tr>
            <td>接诊地点</td>
            <td colspan="5">${misEmrBasicinfo.address }</td>
            <td>接诊医生</td>
            <td colspan="3">${doctorSign }</td>
        </tr>
        <tr>
            <td>接诊事件</td>
            <td colspan="5">${misEmrBasicinfo.chiefComplaint }</td>
            <td>初步诊断</td>
            <td colspan="3">${misEmrPreaidVs.primDiagR }</td>
        </tr>
        <tr>
            <td rowspan="6">病情观察</td>
            <td colspan="2">生命体征</td>
            <td colspan="7">
                <span>T ${misEmrPe.t }℃</span>
                <span>P ${misEmrPe.p }次/分</span>
                <span>R ${misEmrPe.r }次/分</span>
                <span>BP ${misEmrPe.bpL }/${misEmrPe.bpH }mmHg</span>
                <span>SPO2${misEmrAE.bos }%</span>
                <span>ECO2${misEmrNursingRecord.eco2 }%</span>
            </td>
        </tr>
        <tr>
            <td colspan="2">神志</td>
            <td colspan="7">${conscious }</td>
        </tr>
        <tr>
            <td colspan="2">瞳孔</td>
            <td colspan="7">${pupil}</td>
        </tr>
        <tr>
            <td colspan="2">一般情况</td>
            <td colspan="7">
                <div style="text-align:left" data-control='bind'>精神:
                    ${mentalstate }
                </div>
                <div style="text-align:left" data-control='bind'>
                    体位:
                    ${posture }
                </div>
            </td>
        </tr>
        <tr>
            <td colspan="2">口唇色泽</td>
            <td colspan="7" style="text-align:left" data-control='bind'>
                ${cyanosis }
            </td>
        </tr>
        <tr>
            <td colspan="2">皮肤</td>
            <td colspan="7" style="text-align:left" data-control='bind'>
                ${skin }
            </td>
        </tr>
        <tr>
            <td>病情变化及危重症抢救记录</td>
            <td colspan="9">${misEmrPreaidVs.sceneRecord }</td>
        </tr>
        <tr>
            <td rowspan="${fn:length(senceDrugList)+1+1}">护理措施</td>
            <td style="width:30px">1</td>
            <td style="width:80px">相关护理</td>
            <td colspan="8" style="text-align:left" data-control='bind'>
                ${nursingCare }
            </td>
        </tr>
        <tr>
            <td rowspan="${fn:length(senceDrugList)+1}">2</td>
            <td rowspan="${fn:length(senceDrugList)+1}">治疗医嘱执行情况</td>
            这里是一个变量
            <td colspan="1"></td>
            <td colspan="2">药名</td>
            <td colspan="1">剂量</td>
            <td colspan="2">用法</td>
            <td colspan="2">执行时间</td>
        </tr>
        <c:if test="${fn:length(senceDrugList) != 0}">
            <c:forEach var="list" items="${senceDrugList}">
                <tr>
                    <br/>
                    <td colspan="1">
                        <c:if test="${fn:indexOf(list.grp,'0')!='-1'}">
                            <b>${fn:replace(list.grp,'0', '')}</b>
                        </c:if>
                    </td>
                    <td colspan="2">
                            ${list.name}
                    </td>
                    <td colspan="1">${list.dose}${list.units_text}<c:if
                            test="${list.amount >= 2}">*${list.amount}</c:if></td>
                    <td colspan="2">${list.usage}${list.drip}</td>
                    <td colspan="2">
                            ${list.frequency_text}
                    </td>
                </tr>
            </c:forEach>
        </c:if>
        <c:if test="${fn:length(senceDrugList) == 0}">
            无
        </c:if>

        <tr>
            <td>处理后的</td>
            <td colspan="10">
                <span>T ${misEmrNursingRecord.postT}℃</span>
                <span>P ${misEmrNursingRecord.postP}次/分</span>
                <span>R ${misEmrNursingRecord.postR}次/分</span>
                <span>BP ${misEmrNursingRecord.postBpl}/${misEmrNursingRecord.postBph}mmHg</span>
                <span>SPO2${misEmrNursingRecord.postSpo2}%</span>
                <span>ECO2${misEmrNursingRecord.postEco2}%</span>
            </td>
        </tr>
        <tr>
            <td>效果评价</td>
            <td colspan="6" style="text-align:left" data-control='bind' data-index='2'>
                ${outcome }
            </td>
            <td colspan="2">护士签名</td>
            <td colspan="2">${hsname}</td>
        </tr>
        <tr>
            <td>备注</td>
            <td colspan="10">${misEmrNursingRecord.remark}</td>
        </tr>
    </table>
</div>
<button id="btn-print" class="btn" onclick="javascript:window.print()">
    <span class="glyphicon glyphicon-print" style="margin-left:5px"></span>打印
</button>
</body>
</html>