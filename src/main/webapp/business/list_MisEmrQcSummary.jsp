<%@ page language="java" import="java.util.*" pageEncoding="utf-8" %>
<%@ include file="/taglibs.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <script>
        $(document).ready(function () {

            //quickSearch
            $("input#mc").quicksearch("table#data_list tbody tr");

            //slide
            var slide = new SlideBoot('.slide', '#dataform');
            slide.init();

            //初始化select的值
            custom_options($("#szfz"), '${vMisEmrQuery.szfz}');

            /**
             **回车启动查询
             **/
            $("input").keydown(function (e) {
                var ev = document.all ? window.event : e;
                if (ev.keyCode == 13) {
                    $("#find").click();
                }
            });

            //显示自己？
            $("#showAll").click(function () {
                $("#showAll").is(':checked') == true ? $("#sumUserid").val('${memberId}') : $("#sumUserid").val(null);
            });


            $("#find").click(function () {
                //开始验证
                //if(validator.form()==false){return ;};
                $("#dataform").submit();
            });

            //清空所有input
            $("#clear").click(function () {
                $("input").val('');
            });

            //
            $(".search").click(function () {
                var id = $(this).attr("id");
                var qcLevel = $(this).attr("qcLevel");
                window.location.href = "${ctx}/misEmrQcSummary.do?method=findQcPage&level=" + qcLevel + "&id=" + id;
            });


        });

        //删除
        function del(id) {
            if (confirm("确认删除！") == false) {
                return;
            }
            $.ajax({
                contentType: "application/x-www-form-urlencoded; charset=utf-8",
                url: "${ctx}/misEmrQcSummary.do?method=delMisEmrQcSummary",
                data: "id=" + id,
                type: "post",
                success: function (data) {
                    window.location.href = window.location.href;
                }
            });
        }
    </script>
</head>
<body>
<form id="dataform" action="${ctx}/misEmrQcSummary.do?method=findMisEmrQcSummary&level=${param.level}"
      method="post">
    <div class="search_div">
        <table width="100%" border="0">
            <tr>
                <td nowrap="true" align="right">汇总日期（起）</td>
                <td nowrap="true" align="left">
                    <input type="text" name="timebegin" id="timebegin"
                           onfocus="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})"/>
                </td>
                <td nowrap="true" align="right">汇总日期（止）</td>
                <td nowrap="true" align="left">
                    <input type="text" name="timeover" id="timeover"
                           onfocus="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})"/>
                </td>
                <td nowrap="true" align="right">所查月份</td>
                <td nowrap="true" align="left">
                    <input type="text" name="emrMonth" id="emrMonth" value="${misEmrQcSummary.emrMonth}"
                           onfocus="WdatePicker({dateFmt:'yyyy/MM'})"/>
                </td>
                <c:if test="${orgid == munit}"><!-- 如果不是中心管理员的话 没有这个 -->
                <td nowrap="true" align="right">所属分站</td>
                <td nowrap="true" align="left">
                        ${orgId}
                </td>
                </c:if>
                <c:if test="${orgid != munit}">
                    <td nowrap="true" align="right">显示自己</td>
                    <td nowrap="true" align="left">
                        <input type="checkbox" id="showAll" name="showAll" superBox="normal"
                               style="height: 18px;width: 18px;">
                        <input type="hidden" id="sumUserid" name="sumUserid">
                    </td>
                </c:if>
                <td nowrap="true" align="center">
                    <button type="button" class="btn" id="find">查询</button>
                    <button type="button" class="btn btn_gray" id="clear">清空</button>
                </td>
            </tr>
            <tr>
                <td colspan="8">
                    <input type="text" name="mc" value="" id="mc" placeholder="关键字查询" autofocus/>
                </td>
            </tr>
        </table>
    </div>
</form>
<div class="slide">
</div>
<table width="100%" border="0" cellpadding="0" cellspacing="0" id="data_list"
       class="table_list">
    <thead>
    <tr>
        <th class="debugMode${deBugMode}">debug用</th>
        <th>分站</th>
        <th>汇总月份</th>
        <th>汇总人</th>
        <th>汇总日期</th>
        <th>病历时间（起）</th>
        <th>病历时间（止）</th>
        <th>病历总量</th>
        <th>死亡总量</th>
        <th>病危总量</th>
        <th>病重总量</th>
        <th>操作</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="list" items="${list}">
        <tr title="${list.id }">
            <td>${list.org_text }</td>
            <td>${list.emrMonth }</td>
            <td>${list.sumUser_text }</td>
            <td>
                <fmt:formatDate value="${list.sumTime }" pattern="yyyy-MM-dd HH:mm:ss" type="date" dateStyle="long"/>
            </td>
            <td>
                <fmt:formatDate value="${list.startTime }" pattern="yyyy-MM-dd HH:mm:ss" type="date" dateStyle="long"/>
            </td>
            <td>
                <fmt:formatDate value="${list.endTime }" pattern="yyyy-MM-dd HH:mm:ss" type="date" dateStyle="long"/>
            </td>
            <td>${list.emrSum }</td>
            <td>${list.deathEmrSum }</td>
            <td>${list.criticalEmrSum }</td>
            <td>${list.severeEmrSum }</td>
            <td>
                <a class="search" id="${list.id }" qcLevel=${list.qcLevel }>查看</a>
                <a biaozhi="${list.id}" openMode="newWin" tab_title="${list.emrMonth }" class="print"
                   link_url="${ctx}/misEmrQcSummary.do?method=findQcPage&print=1&level=${list.qcLevel}&id=${list.id }">打印</a>
            </td>
        </tr>
    </c:forEach>

    </tbody>
</table>
<div class="show_page" align="center">
    ${nva}
</div>

<div style="text-align:center;">
    <a class="btn btn_yellow" type="button" biaozhi="qc${memberId}" tab_title="审核汇总"
       link_url="${ctx}/misEmrQcSummary.do?method=findQcPage&level=${param.level}" openMode="tabMenu">
        添加记录
    </a>
</div>

</body>
</html>
