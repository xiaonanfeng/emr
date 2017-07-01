<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<body>
<table>
    <c:forEach var="list" items="${list}">
        <tr>
            <td>
                    ${list.id}
            </td>
            <td>
                    ${list.name }
            </td>
        </tr>
    </c:forEach>
</table>

</body>
</html>
