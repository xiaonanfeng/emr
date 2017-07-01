<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE html>
<html>
<head>
    <title>病历质量控制检查情况汇总表</title>
    <link rel="stylesheet" href="${ctx}/css/print/Style/bootstrap.css">
    <link rel="stylesheet" href="${ctx}/css/print/Style/table.css">
    <script src='${ctx}/js/jquery-2.1.1.min.js'></script>
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

        .printtable tr td {
            font-size: 12pt;
        }

        .subtitle {
            float: left;
            height: 100px;
            width: 100%;
            text-align: left;
        }

        .text {
            min-height: 94px;
            display: inline;
            text-align: left;
            text-indent: 34px;
        }

        .text-end {
            float: right;
            width: 100%;
            text-align: right;
        }
    </style>
    <script>
        $(document).ready(function () {
            $("[data-control='bind']").each(function (index, element) {
                var i = $(element).attr('data-index');
                var text = $(element).find('span:eq(' + i + ')').text();
                var newText = '√ ' + text.substring(1);
                $(element).find('span:eq(' + i + ')').text(newText);
            })
        })
    </script>
</head>
<body>
<div id="page1" class="page" style="page-break-after:always">
    <div class="table-title center strong" style="margin-top: 65px;">郑州市院前急救病历质量控制检查情况汇总表（${level_text }）</div>
    <table class="printtable">
        <tr>
            <td>急救站</td>
            <td colspan="2">${org_text }</td>
            <td>所查病历月份</td>
            <td colspan="2">${misEmrQcSummary.emrMonth}月</td>
        </tr>
        <tr>
            <td>汇总人</td>
            <td colspan="2">${userName }</td>
            <td>汇总日期</td>
            <td colspan="2"><fmt:formatDate value="${misEmrQcSummary.sumTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
        </tr>
        <tr>
            <td colspan="2">所查病历起止时间</td>
            <td colspan="4">
                <fmt:formatDate value="${misEmrQcSummary.startTime}" pattern="yyyy年MM月dd日 HH时"/>
                至
                <fmt:formatDate value="${misEmrQcSummary.endTime}" pattern="yyyy年MM月dd日 HH时"/>
            </td>
        </tr>
        <tr>
            <td>病历总数</td>
            <td>死亡病历数</td>
            <td>病危病历数</td>
            <td>病情重病历数</td>
            <td>病情中病历数</td>
        </tr>
        <tr>
            <td>${misEmrQcSummary.emrSum}</td>
            <td>${misEmrQcSummary.deathEmrSum}</td>
            <td>${misEmrQcSummary.criticalEmrSum}</td>
            <td>${misEmrQcSummary.severeEmrSum}</td>
            <td>${misEmrQcSummary.mediumErmSum}</td>
        </tr>
        <tr>
            <td>病情轻病历数</td>
            <td>抽查总数</td>
            <td>抽查率</td>
            <td>问题病历总数</td>
            <td>满分病历数</td>
        </tr>
        <tr>
            <td>${misEmrQcSummary.lightEmrSum}</td>
            <td>${misEmrQcSummary.spotCheckSum}</td>
            <td>${rateStr}</td>
            <td>${misEmrQcSummary.defectEmrSum}</td>
            <td>${misEmrQcSummary.fullCreditErmSum}</td>
        </tr>
        <tr>
            <td>甲A级病历数</td>
            <td>甲B级病历数</td>
            <td>甲C级病历数</td>
            <td>乙级病历数</td>
            <td>丙级病历数</td>
        </tr>
        <tr>
            <td>${misEmrQcSummary.firstAGrade}</td>
            <td>${misEmrQcSummary.firstBGrade}</td>
            <td>${misEmrQcSummary.firstCGrade}</td>
            <td>${misEmrQcSummary.secondGrade}</td>
            <td>${misEmrQcSummary.thirdGrade}</td>
        </tr>
        <tr>
            <td colspan="6">
					<span class="subtitle">存在问题汇总：<div class="text">${misEmrQcSummary.defectSummary}
                    </div></span>
            </td>
        </tr>
        <tr>
            <td colspan="6">
					<span class="subtitle">原因分析：<div class="text">${misEmrQcSummary.defectReason}
                    </div></span>
            </td>
        </tr>
        <tr>
            <td colspan="6">
					<span class="subtitle">整改及改进措施：<div class="text">${misEmrQcSummary.improvement}
                    </div></span>
                <div class="text-end">负责人：<span>${misEmrQcSummary.responsible}</span></div>
            </td>
        </tr>
        <tr>
            <td colspan="6">
					<span class="subtitle">追踪整改落实效果 ：<div class="text">${misEmrQcSummary.followUp}
                    </div>
					</span>
                <div class="text-end">追踪评估人：<span>${misEmrQcSummary.fuUser}
                </span>
                </div>
                <br/>
                <div class="text-end">
                    追踪时间：<span><fmt:formatDate value="${misEmrQcSummary.fuTime}" pattern="yyyy年MM月dd日 HH时mm分ss秒"/>
					</span>
                </div>
            </td>
        </tr>
    </table>
</div>
<button id="btn-print" class="btn" onclick="javascript:window.print()">
    <span class="glyphicon glyphicon-print" style="margin-left:5px"></span>打印
</button>
</body>
</html>