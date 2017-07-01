<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@ include file="/taglibs.jsp" %>
<!doctype html>
<html>
<head>
    <script>
        $(document).ready(function () {
        });

    </script>
<body>
<table width="100%" border="1" id="table_list" class="table_list">
    <tr>
        <th>修改人</th>
        <th>修改内容</th>
        <th>修改前</th>
        <th>修改后</th>
        <th>修改时间</th>
    </tr>
    <c:forEach var="list" items="${list}">
        <tr>
            <td>${list.modifyUserid}</td>
            <td>${list.modifyContent}</td>
            <td>${list.before}</td>
            <td>${list.after}</td>
            <td><fmt:formatDate value="${list.modifyTime }" pattern="yyyy-MM-dd HH:mm:ss" type="date"
                                dateStyle="long"/></td>
        </tr>
    </c:forEach>
</table>

</body>