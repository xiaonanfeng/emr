<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<body>
<form action="/emr/misErmCallRemote.do?method=sendMsg" method="post">
    <input id="LSH" name="LSH" class="input_full" type="text"> <br/>
    <input id="CCXH" name="CCXH" class="input_full" type="text"> <br/>
    <input id="REQ_USERID" name="REQ_USERID" class="input_full" type="text"> <br/>
    <input id="EMR_ID" name="EMR_ID" class="input_full" type="text"> <br/>
    <input id="REQ_LEVEL" name="REQ_LEVEL" class="input_full" type="text">
    <input type="submit" value="submit">
</form>
</body>
</html>
