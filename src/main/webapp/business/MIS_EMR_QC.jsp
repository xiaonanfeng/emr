<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@ include file="/taglibs.jsp" %>
<%@ include file="/businit/MIS_EMR_QC-init.jsp" %>
<html>
<head>
    <title>郑州市院前急救病历质量控制检查</title>
    <style>
        .asTable li span:first-child {
            width: 128px;
        }

        .over-line input {
            width: calc(100% - 260px) !important;
        }

        .over-line {
            height: 40px !important;
        }
    </style>
</head>
<body>
<form id="vld_qc">
    <input type="hidden" name="id" id="id" value="${id }"/>
    <input type="hidden" name="qcLevel" id="qcLevel" value="${level }"/>

    <h2 style="text-align:center">${systemConfig.printTitle}院前急救病历质量控制检查记录表（${level_text }）</h2>
    <ul class="asTable" id="dataUl">
        <div class="text_decollator">
            <span>检查情况基本信息</span>
        </div>
        <li>
            <span title="急救站">急救站</span>
            <span>${org_text }</span>
        </li>
        <li>
            <span title="所查病历月份">所查病历月份</span>
            <span>
				<input type="text" name="emrMonth" id="emrMonth" value="${misEmrQcSummary.emrMonth}"
                       onfocus="WdatePicker({dateFmt:'yyyy/MM'})"/>
			</span>
        </li>
        <li>
            <span title="汇总人">汇总人</span>
            <span id="sumUserid">
                ${userName }
            </span>
        </li>
        <li>
            <span title="汇总时间">汇总日期</span>
            <span>
				<input type="text" name="sumTime" id="sumTime" class="input_full t-datetime"
                       value="<fmt:formatDate value="${misEmrQcSummary.sumTime}" pattern="yyyy-MM-dd HH:mm:ss"/>"
                       onfocus="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})"/>
			</span>
        </li>
        <li style="width:800px">
            <span title="所查病历起止时间">所查病历起止时间</span>
            <span style="width: 405px;display: inline-block;">
				<input type="text" name="startTime" id="startTime" class="input_full"
                       value="<fmt:formatDate value="${misEmrQcSummary.startTime}" pattern="yyyy-MM-dd HH"/>"
                       onfocus="WdatePicker({dateFmt:'yyyy-MM-dd HH'})"/>
				至
				<input type="text" name="endTime" id="endTime" class="input_full"
                       value="<fmt:formatDate value="${misEmrQcSummary.endTime}" pattern="yyyy-MM-dd HH"/>"
                       onfocus="WdatePicker({dateFmt:'yyyy-MM-dd HH'})"/>
				<button style="margin-top: -3px;" type="button" class="btn btn_yellow" id="getDatas">获取数据</button>
				<button style="margin-top: -3px;" type="button" class="btn btn_yellow" id="getEmrs">导出问题病历</button>
			</span>
        </li>
        <div class="text_decollator">
            <span>汇总情况（总量）</span>
        </div>
        <li>
            <span title="病历总数">病历总数</span>
            <span>
				<input type="text" name="emrSum" id="emrSum" value="${misEmrQcSummary.emrSum}"/>
			</span>
        </li>
        <li>
            <span title="死亡病历数">死亡</span>
            <span>
				<input type="text" name="deathEmrSum" id="deathEmrSum" value="${misEmrQcSummary.deathEmrSum}"/>
			</span>
        </li>
        <li>
            <span title="病危病历数">病危</span>
            <span>
				<input type="text" name="criticalEmrSum" id="criticalEmrSum" value="${misEmrQcSummary.criticalEmrSum}"/>
			</span>
        </li>
        <li>
            <span title="病情重病历数">病情重</span>
            <span>
				<input type="text" name="severeEmrSum" id="severeEmrSum" value="${misEmrQcSummary.severeEmrSum}"/>
			</span>
        </li>
        <li>
            <span title="病情重病历数">病情中</span>
            <span>
				<input type="text" name="mediumErmSum" id="mediumErmSum" value="${misEmrQcSummary.mediumErmSum}"/>
			</span>
        </li>
        <li>
            <span title="病情重病历数">病情轻</span>
            <span>
				<input type="text" name="lightEmrSum" id="lightEmrSum" value="${misEmrQcSummary.lightEmrSum}"/>
			</span>
        </li>
        <li>
            <span title="抽查总数">抽查总数</span>
            <span>
				<input type="text" name="spotCheckSum" id="spotCheckSum" value="${misEmrQcSummary.spotCheckSum}"/>
			</span>
        </li>
        <li>
            <span title="抽查率">抽查率</span>
            <span>
				<input type="hidden" name="spotCheckRate" id="spotCheckRate" value="${misEmrQcSummary.spotCheckRate}"/>
				<input type="text" name="spontCheckPercent" id="spontCheckPercent" value="${rateStr}"/>
			</span>
        </li>
        <li>
            <span title="问题病历总数">问题病历</span>
            <span>
				<input type="text" name="defectEmrSum" id="defectEmrSum" value="${misEmrQcSummary.defectEmrSum}"/>
			</span>
        </li>
        <li>
            <span title="问题病历总数">满分病历</span>
            <span>
				<input type="text" name="defectEmrSum" id="fullCreditErmSum"
                       value="${misEmrQcSummary.fullCreditErmSum}"/>
			</span>
        </li>
        <li>
            <span title="甲A级病历数">甲A级</span>
            <span>
				<input type="text" name="firstAGrade" id="firstAGrade" value="${misEmrQcSummary.firstAGrade}"/>
			</span>
        </li>
        <li>
            <span title="甲B级病历数">甲B级</span>
            <span>
				<input type="text" name="firstBGrade" id="firstBGrade" value="${misEmrQcSummary.firstBGrade}"/>
			</span>
        </li>
        <li>
            <span title="甲C级病历数">甲C级</span>
            <span>
				<input type="text" name="firstCGrade" id="firstCGrade" value="${misEmrQcSummary.firstCGrade}"/>
			</span>
        </li>
        <li>
            <span title="乙级病历数">乙级</span>
            <span>
				<input type="text" name="secondGrade" id="secondGrade" value="${misEmrQcSummary.secondGrade}"/>
			</span>
        </li>
        <li>
            <span title="丙级病历数">丙级</span>
            <span>
				<input type="text" name="thirdGrade" id="thirdGrade" value="${misEmrQcSummary.thirdGrade}"/>
			</span>
        </li>
        <div class="text_decollator">
            <span>存在问题汇总</span>
        </div>
        <li class="over-line">
            <span title="问题汇总">问题汇总</span>
            <input class="input_full" type="text" id="defectSummary" name="defectSummary"
                   value="${misEmrQcSummary.defectSummary}"/>
        </li>
        <div class="text_decollator">
            <span>原因分析</span>
        </div>
        <li class="over-line">
            <span title="原因分析">原因分析</span>
            <input class="input_full" type="text" id="defectReason" name="defectReason"
                   value="${misEmrQcSummary.defectReason}">
        </li>
        <div class="text_decollator">
            <span>整改及改进措施</span>
        </div>
        <li class="over-line">
            <span title="整改及改进措施">整改及改进措施</span>
            <input class="input_full" type="text" id="improvement" name="improvement"
                   value="${misEmrQcSummary.improvement}">
        <li>
            <span>责任人</span><input class="input_full" type="text" id="responsible" name="responsible"
                                   value="${misEmrQcSummary.responsible}">
        </li>
        <div class="text_decollator">
            <span>追踪整改落实效果</span>
        </div>
        <li class="over-line">
            <span title="追踪整改落实效果">追踪整改落实效果</span>
            <input class="input_full" type="text" id="followUp" name="followUp" value="${misEmrQcSummary.followUp}">
        <li>
            <span>追踪评估人</span><input class="input_full" type="text" id="fuUser" name="fuUser"
                                     value="${misEmrQcSummary.fuUser}">
        </li>
        <li>
            <span>追踪时间</span><input class="input_full t-datetime" type="text" id="fuTime" name="fuTime"
                                    value="<fmt:formatDate value="${misEmrQcSummary.fuTime}" pattern="yyyy-MM-dd HH:mm:ss"/>"
                                    onfocus="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})">
        </li>
    </ul>
</form>

<div style="text-align:center;">
    <button type="button" class="btn" id="saveQc">保存</button>
</div>

<%@ include file="/busvald/misEmrQcValidator.jsp" %>
</body>
</html>