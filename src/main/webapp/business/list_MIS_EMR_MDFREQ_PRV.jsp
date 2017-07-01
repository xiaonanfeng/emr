<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@ include file="/taglibs.jsp" %>
<!DOCTYPE html>
<html>
<script type="text/javascript">
    $(document).ready(function () {
        //查询数据
        $("#find").click(function () {
            $("#dataform").submit();
        });
        //清空数据
        $("#clear").click(function () {
            $("input").val('');
            $("select").val('');
        });
    });//JQUERY结束
</script>
<body>
<form id="dataform" action="${ctx}/misEmrMdfreq.do?method=findMisEmrMdfs&stat=0"
      method="post">
    <div class="search_div">
        <table width="100%" border="0">
            <tr>
                <td nowrap="true" align="right">申请时间（起）</td>
                <td nowrap="true" align="left">
                    <input placeholder="开始" type="text" name="timebegin" id="timebegin" value="${timebegin }"
                           onfocus="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})"/>
                </td>
                <td nowrap="true" align="right">申请时间（止）</td>
                <td nowrap="true" align="left">
                    <input placeholder="结束" type="text" name="timeover" id="timeover" value="${timeover }"
                           onfocus="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})"/>
                </td>
                <td nowrap="true" align="right">审核状态</td>
                <td nowrap="true" align="left">
                    <select name="reqResult" id="reqResult">
                        <option></option>
                        <option value="0" <c:if test="${reqResult=='0'}">selected</c:if>>未审核</option>
                        <option value="1" <c:if test="${reqResult=='1'}">selected</c:if>>通过</option>
                        <option value="2" <c:if test="${reqResult=='2'}">selected</c:if>>驳回</option>
                    </select>
                </td>
                <td nowrap="true" align="center">
                    <button type="button" class="btn" id="find">查询</button>
                </td>
                <td nowrap="true" align="center">
                    <button type="button" class="btn btn_gray" id="clear">清空</button>
                </td>
            </tr>
        </table>
    </div>
</form>


<table width="100%" border="1" id="table_list" class="table_list">
    <tr>
        <th>相关病历</th>
        <th>申请人</th>
        <th>申请时间</th>
        <th>申请原因</th>
        <th>审批结果</th>
        <th>再提交时间</th>
        <th>审批人</th>
        <th>备注</th>
        <th>操作</th>
    </tr>
    <c:forEach var="list" items="${list}">
        <tr>
            <td>
                <a biaozhi="${list.emrId}"
                   openMode="tabMenu"
                   class="search"
                   tab_title="修改申请相关病历"
                   link_url="${ctx}/emr.do?method=initEmrByEmrId&id=${list.emrId}"></a>
            </td>
            <td>${list.reqMember}</td>
            <td><fmt:formatDate value="${list.createTime }" pattern="yyyy-MM-dd HH:mm:ss" type="date"
                                dateStyle="long"/></td>
            <td>${list.mdfReason_text}</td>
            <td>
                <c:if test="${list.reqResult == 0}">未审批</c:if>
                <c:if test="${list.reqResult == 1}"><font style="color: green">通过</font></c:if>
                <c:if test="${list.reqResult == 2}"><font style="color: red">驳回</font></c:if>
            </td>
            <td>
                <fmt:formatDate value="${list.comtagain }" pattern="yyyy-MM-dd HH:mm:ss" type="date" dateStyle="long"/>
            </td>
            <td>${list.reqMember}</td>
            <td>${list.recRemark}</td>
            <td>
                <c:if test="${list.reqResult == 0}">
                    <a biaozhi="${list.id}"
                       openMode="open_layer"
                       class="search"
                       layer_width="500"
                       layer_heigth="300"
                       link_url="${ctx}/misEmrMdfreq.do?method=findMisEmrMdfPrevById&id=${list.id}"></a>
                </c:if>
            </td>
        </tr>
    </c:forEach>
</table>
<div class="show_page" align="center">
    ${nva}
</div>

</body>
</html>
