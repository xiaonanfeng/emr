<%@ page language="java" import="java.util.*" pageEncoding="utf-8" %>
<%@ include file="/taglibs.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <script>
        $(document).ready(function () {
            //初始化select的值
            custom_options($("#szfz"), '${vMisEmrAmbul.szfz}');
            /**
             //查询条件教研
             var validator =
             $("#dataform").validate({
					rules : {
						timebegin :"required",
						timeover:"required"
					},
					messages : {
						timebegin: "请选择一个时间段 ",
						timeover:"请选择一个时间段 "
					}
		});
             **/
            $("input").keydown(function (e) {
                var ev = document.all ? window.event : e;
                if (ev.keyCode == 13) {
                    $("#find").click();
                }
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

        });
    </script>
</head>
<body>
<form id="dataform" action="${ctx}/misEmrHandover.do?method=findVMisEmrAmbul"
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

                <td nowrap="true" align="right">提交</td>
                <td nowrap="true" align="left">
                    <select name="isCommitted" id="isCommitted">
                        <option value="">---全部---</option>
                        <option value="0" <c:if test="${vMisEmrAmbul.isCommitted == 0}">selected</c:if>>未提交</option>
                        <option value="1" <c:if test="${vMisEmrAmbul.isCommitted == 1}">selected</c:if>>已提交</option>
                    </select>
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
        <th>提交状态</th>
        <th>交接记录</th>
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
            <td>
                <c:if test="${list.isCommitted  == 1}"><font color="green">已提交</font></c:if>
                <c:if test="${list.isCommitted  == 0}">未提交</c:if>
            </td>
            <td>
                <a href="javascript:void(0)" biaozhi="handover${list.emrid}" openMode="tabMenu"
                   tab_title="交接单:${list.name}"
                   link_url="${ctx}/misEmrHandover.do?method=findMisEmrHandoverById&id=${list.emrid}&print=0" ;>交接记录</a>
                <a href="javascript:void(0)" biaozhi="handover${list.emrid}" openMode="newWin"
                   tab_title="交接单:${list.name}"
                   link_url="${ctx}/misEmrHandover.do?method=findMisEmrHandoverById&id=${list.emrid}&print=1" ;>打印</a>
            </td>
        </tr>
    </c:forEach>
</table>
<div class="show_page" align="center">
    ${nva}
</div>

</body>
</html>
