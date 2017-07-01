<%@ page language="java" import="java.util.*" pageEncoding="utf-8" %>
<%@ include file="/taglibs.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <script>
        $(document).ready(function () {
            //初始化select的值
            custom_options($("#szfz"), '${vMisEmrAmbul.szfz}');
            //查询条件教研
            var validator =
                    $("#dataform").validate({
                        rules: {
                            timebegin: "required",
                            timeover: "required"
                        },
                        messages: {
                            timebegin: "请选择一个时间段 ",
                            timeover: "请选择一个时间段 "
                        }
                    });

            $("input").keydown(function (e) {
                var ev = document.all ? window.event : e;
                if (ev.keyCode == 13) {
                    $("#find").click();
                }
            });

            $("#find").click(function () {
                //开始验证
                if (validator.form() == false) {
                    return;
                }
                ;
                $("#dataform").submit();
            });

            //清空所有input
            $("#clear").click(function () {
                $("input").val('');
            });

        });

        function newWindow() {
            var preWin = window.open("${ctx}/bingli5.html", "病历详情");

        }

    </script>
</head>
<body>
<form id="dataform" action="${ctx}/misEmrModifyRecord.do?method=findVMisEmrAmbul"
      method="post">
    <div class="search_div">
        <table width="100%" border="0">
            <tr>
                <td nowrap="true" align="right">出车时间</td>
                <td nowrap="true" align="left">
                    <input type="text" name="timebegin" id="timebegin" value="${vMisEmrAmbul.timebegin}"
                           onfocus="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})"/>--
                    <input type="text" name="timeover" id="timeover" value="${vMisEmrAmbul.timeover}"
                           onfocus="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})"/>
                </td>

                <!-- 				 	<td nowrap="true" align="right">病人姓名</td> -->
                <!-- 					<td nowrap="true" align="left"> -->
                <!-- 						<input type="text" name="jcdz" id="jcdz" value="${vMisEmrAmbul.name }" /> -->
                <!-- 					</td> -->
                <c:if test="${orgid == munit}">
                    <td nowrap="true" align="right">分站</td>
                    <td nowrap="true" align="left">
                            ${szfz}
                    </td>
                </c:if>

                <td nowrap="true" align="right">电话</td>
                <td nowrap="true" align="left">
                    <input type="text" name="lxdh" id="lxdh" value="${vMisEmrAmbul.lxdh }"/>
                </td>

                <td nowrap="true" align="center">
                    <button type="button" class="btn" id="find">查询</button>
                    <button type="button" class="btn btn_gray" id="clear">清空</button>
                </td>
            </tr>
        </table>
    </div>
</form>

<table width="100%" border="0" cellpadding="0" cellspacing="0"
       class="table_list">
    <tr>
        <th class="debugMode${deBugMode}">debug用</th>
        <th>病人姓名</th>
        <th>主诉</th>
        <th>所属分站</th>
        <th>接送车辆</th>
        <th>出车时间</th>
        <th>联系人</th>
        <th>联系电话</th>
        <th>登记人</th>
        <th>登记时间</th>
        <th>更新时间</th>
        <th>修改次数</th>
        <th>提交状态</th>
        <th>审核病历</th>
    </tr>
    <c:forEach var="list" items="${list}">
        <tr title="${list.emrid }:${list.chiefComplaint}">
            <td class="debugMode${deBugMode}">${list.emrid}</td>
            <td>${list.name}</td>
            <td>
                <c:set var="string" value="${list.chiefComplaint}"/>
                    ${fn:substring(string,0, 10)}
            </td>
            <td>${list.szfz}</td>
            <td>${list.clid}</td>
            <td><fmt:formatDate value="${list.ccsj }" pattern="yyyy-MM-dd HH:mm:ss" type="date" dateStyle="long"/></td>
            <td>${list.lxr }</td>
            <td>${list.lxdh }</td>
            <td>${list.createuserid }</td>
            <td><fmt:formatDate value="${list.createtime }" pattern="yyyy-MM-dd HH:mm:ss" type="date"
                                dateStyle="long"/></td>
            <td><fmt:formatDate value="${list.lastmodifytime }" pattern="yyyy-MM-dd HH:mm:ss" type="date"
                                dateStyle="long"/></td>
            <td>
                <a href="javascript:void(0)" biaozhi="mdf${list.emrid}" openMode="tabMenu" tab_title="修改记录：${list.name}"
                   link_url="${ctx}/misEmrModifyRecord.do?method=findMisEmrModifyRecordByEmrId&id=${list.emrid}"
                   ;>${list.xgcs }次</a>
            </td>
            <td>
                <c:if test="${list.isCommitted  == 1}"><font color="green">已提交</font></c:if>
                <c:if test="${list.isCommitted  == 0}">未提交</c:if>
            </td>
            <td>
                <a onclick="newWindow()" href="javascript:void(0)" biaozhi="mdf${list.emrid}" openMode="tabMenu"
                   tab_title="审核：${list.name}"
                   link_url="${ctx}/misEmrModifyRecord.do?method=findMisEmrModifyRecordByEmrId&id=${list.emrid}"
                   ;>审核</a>
            </td>
        </tr>
    </c:forEach>
</table>
<div class="show_page" align="center">
    ${nva}
</div>

</body>
</html>
