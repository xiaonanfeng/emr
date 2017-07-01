<!DOCTYPE html>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<html>
<title>${systemConfig.printTitle}院前急救病情告知书</title>
<link rel="stylesheet" href="${ctx}/css/print/Style/bootstrap.css">
<link rel="stylesheet" href="${ctx}/css/print/Style/table.css">
<script src="${ctx}/js/jquery-2.1.1.min.js"></script>
<script src="${ctx}/js/JC_js.js"></script>
<style>
    .content {
        padding: 40px 70px;
        float: left;
    }

    .content > p > span {
        margin-right: 100px;
    }

    p.margintop {
        margin: 20px 0px 0px;
    }

    p {
        letter-spacing: 0.5px;
        width: 100%;
    }

    .textTime {
        margin-top: 50px;
        text-align: right;
        letter-spacing: 2px;
        word-spacing: 14px;
    }

    .textTime > span {
        margin-right: 40px !important;
    }

    .textRight {
        float: right;
    }

    .textRight > span {
        float: right;
    }

    input {
        width: 220px;
        border: 0px;
    }

    input.sort {
        width: 15px;
    }

    input.sort2 {
        width: 10px;
    }
</style>
<script>
    $(document).ready(function () {
        /* checkbox 转化 jtt 20160902 */
        setTimeout(function () {
            $('input[type="checkbox"]').each(function (index, element) {
                if ($(element).is(':checked')) {
                    $(element).after('<span style="margin:0px 20px 0px 43px">( √ )</span>');
                } else {
                    $(element).after('<span style="margin:0px 20px 0px 43px">(&nbsp;&nbsp; &nbsp;)</span>');
                }
                $(element).hide();
            })
        }, 500)
    })
</script>
</head>
<%@ include file="/businit/MIS_EMR_NOTICE-init.jsp" %>
<body>
<div id="page1" class="page" style="page-break-after:always">
    <div class="table-title center strong" style="margin-top:50px;">${systemConfig.printTitle}院前急救病情告知书</div>
    <div class="content">
        <p>出诊急救站：${szfz} </p>
        <!-- 			<p>医院急救站：${sentTo}</p> -->
        <p class="textTime">到达患者身边时间： <fmt:formatDate value="${misEmrNotice.arvtime}" pattern="yyyy年MM月dd日 HH时mm分"
                                                      type="date" dateStyle="long"/></p>
        <p>
            <span>患者姓名：${name}</span>
            <span>性别：${sex}</span>
            <span style="width:20%">年龄： <span
                    id="age"></span> <select id="timeScope" superSelect="normal">
							<option>&nbsp;</option>
							<option value="1">分</option>
							<option value="60">时</option>
							<option value="1440">天</option>
							<option value="43200">月</option>
							<option value="518400">岁</option>
					</select>
				</span>
        </p>
        <c:forEach var="list" items="${list}">
            <p><input type="checkbox" exit="page"
                      id="noticeBox${list.itemId}" name="noticeBox" value="${list.itemId}" superBox="normal"/>
                    ${list.sortId}.${list.display}</p>
        </c:forEach>
        <p class="margintop">患者/患方（关系：${misEmrNotice.rlt}）/见证人签字：${misEmrNotice.atte}</p>
        <p class="margintop">告知人签名：${misEmrNotice.spker}</p>
        <p class="textTime">
            <fmt:formatDate value="${misEmrNotice.noticetime}" pattern="yyyy年MM月dd日 HH时mm分" type="date"
                            dateStyle="long"/>
        </p>
        <!-- 			<p class="textRight"><span style="margin-right:30px;">${systemConfig.printTitle}市紧急医疗救援中心</span></p> -->
    </div>
</div>
<button id="btn-print" class="btn" onclick="javascript:window.print();">
    <span class="glyphicon glyphicon-print" style="margin-right: 5px;"></span>
    打印
</button>
</body>
</html>