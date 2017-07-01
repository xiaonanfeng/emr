<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@ include file="/taglibs.jsp" %>
<!doctype html>
<html>
<head>
    <script>
        $(document).ready(function () {

            //quickSearch
            $("input#mc").quicksearch("table#table_list tbody tr");

            //签收确认点击事件
            $(".checkout").click(function () {
                var id = $(this).attr("id");//事件Id
                //console.log(id);
                $.ajax({
                    contentType: "application/x-www-form-urlencoded; charset=utf-8",
                    url: "${ctx}/misEmrMdfreq.do?method=checkMisEmrMdfReqById",
                    data: "&id=" + id,
                    type: "post",
                    success: function (data) {
                        alert("签收成功！");
                        window.location.href = window.location.href;
                    },
                    error: function (data, textStatus) {
                        alert(textStatus + "错误:" + data.responseText);
                    }
                });
            });

            //查询按钮
            $("#find").click(function () {
                $("#dataform").submit();
            });
        });
    </script>
<body>
<!-- 	中心 -->
<c:if test="${orgid == munit}">
<form id="dataform" action="${ctx }/misEmrMdfreq.do?method=findMisEmrMdfs&stat=0" method="post">
    </c:if>
    <c:if test="${orgid != munit}">
    <form id="dataform" action="${ctx }/misEmrMdfreq.do?method=findMisEmrMdfs&stat=1" method="post">
        </c:if>
        <div class="search_div">
            <table width="100%" border="0">
                <tr>
                    <td nowrap="true" align="right">申请时间</td>
                    <td nowrap="true">
                        <input type="text" name="timebegin" id="timebegin" value=""
                               onfocus="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})"/>
                        ----
                        <input type="text" name="timeover" id="timeover" value=""
                               onfocus="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})"/>
                        <button type="button" class="btn" id="find">查询</button>
                    </td>
                    <td nowrap="true" align="left">
                        <input type="text" name="mc" value="" id="mc" placeholder="关键字查询" autofocus/>
                    </td>
                </tr>
            </table>
        </div>
    </form>


    <table width="100%" border="1" id="table_list" class="table_list">
        <thead>
        <tr>
            <th>病人名称</th>
            <th>主诉</th>
            <th>申请人</th>
            <th>申请时间</th>
            <th>申请原因</th>
            <th>审批人</th>
            <th>审批结果</th>
            <th>再提交时限</th>
            <th>操作</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="list" items="${list}">
            <tr title="申请备注：${list.mdfRemark }  审批备注：${list.recRemark}">
                <td>${list.name}</td>
                <td title="${list.chiefComplaint }">
                    <c:choose>
                        <c:when test="${fn:length(list.chiefComplaint)>15}">
                            ${fn:substring(list.chiefComplaint,0,15)} ……
                        </c:when>
                        <c:otherwise>
                            ${list.chiefComplaint }
                        </c:otherwise>
                    </c:choose>
                </td>
                <td>${list.reqMember}</td>
                <td><fmt:formatDate value="${list.createTime }" pattern="yyyy-MM-dd HH:mm:ss" type="date"
                                    dateStyle="long"/></td>
                <td>${list.mdfReason_text}</td>
                <td>${list.recMember}</td>
                <td>
                    <c:if test="${list.reqResult == 0}">未审批</c:if>
                    <c:if test="${list.reqResult == 1}"><font style="color: green">通过</font></c:if>
                    <c:if test="${list.reqResult == 2}"><font style="color: red">驳回</font></c:if>
                </td>
                <td>
                    <fmt:formatDate value="${list.comtagain }" pattern="yyyy-MM-dd HH:mm:ss" type="date"
                                    dateStyle="long"/>
                </td>
                <td>
                    <c:if test="${list.reqResult==0&&orgid==munit}">
                        <a id="mdf${list.id}" biaozhi="mdf${list.id}" openMode="open_layer"
                           tab_title="修改审批:${list.name}"
                           link_url="${ctx}/misEmrMdfreq.do?method=findMisEmrMdfReqById&id=${list.id}" ;
                           class="search">查看</a>
                    </c:if>
                    <c:if test="${list.reqResult!=0&&orgid!=munit&&list.red==0}">
                        <a id="${list.id}" href="javascript:void(0)" class="checkout">确认审批信息</a>
                    </c:if>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

</body>