<!DOCTYPE htm >
<%@ page language="java" import="java.util.*" pageEncoding="utf-8" %>
<html>
<head>
    <title>中兴电子病历V9.0</title>
    <link rel="stylesheet" type="text/css" href="css/styles.css">


    <script type="text/javascript">

        //pad登录
        function pad() {
            var action = "/emr/login.do?method=login&path=pad";
            document.getElementById("dataForm").action = action;
            document.getElementById("dataForm").submit();
        }

        //web登录
        function web() {
            var action = "/emr/login.do?method=login&path=web";
            document.getElementById("dataForm").action = action;
            document.getElementById("dataForm").submit();
        }
    </script>
</head>
<body>
<div id="logo">
    <h1 class="hogo">
        <i>
            <nobr>院前急救电子病历</nobr>
        </i>
    </h1>
</div>
<section class="stark-login">
    <form action="" method="post" id="dataForm">
        <div id="fade-box">
            <input type="text" name="id" id="id" placeholder="用户名" required value="">
            <input type="password" name="password" placeholder="密码" required value="">
            <!-- 				<button onclick="web()">登录</button> -->
            <button onclick="web()" style="width:40%; display:inline-block;">电脑登录</button>
            <button onclick="pad()" style="width:40%; display:inline-block;">平板登录</button>
        </div>
    </form>
    <div class="hexagons">
        <span>&#x2B22;</span> <span>&#x2B22;</span> <span>&#x2B22;</span> <span>&#x2B22;</span>
        <span>&#x2B22;</span> <span>&#x2B22;</span> <span>&#x2B22;</span> <span>&#x2B22;</span>
        <span>&#x2B22;</span> <span>&#x2B22;</span> <span>&#x2B22;</span> <span>&#x2B22;</span>
        <br> <span>&#x2B22;</span> <span>&#x2B22;</span> <span>&#x2B22;</span>
        <span>&#x2B22;</span> <span>&#x2B22;</span> <span>&#x2B22;</span> <span>&#x2B22;</span>
        <span>&#x2B22;</span> <span>&#x2B22;</span> <span>&#x2B22;</span> <span>&#x2B22;</span>
        <br> <span>&#x2B22;</span> <span>&#x2B22;</span> <span>&#x2B22;</span>
        <span>&#x2B22;</span> <span>&#x2B22;</span> <span>&#x2B22;</span> <span>&#x2B22;</span>
        <span>&#x2B22;</span> <span>&#x2B22;</span> <span>&#x2B22;</span> <span>&#x2B22;</span>
        <span>&#x2B22;</span> <br> <span>&#x2B22;</span> <span>&#x2B22;</span>
        <span>&#x2B22;</span> <span>&#x2B22;</span> <span>&#x2B22;</span> <span>&#x2B22;</span>
        <span>&#x2B22;</span> <span>&#x2B22;</span> <span>&#x2B22;</span> <span>&#x2B22;</span>
        <span>&#x2B22;</span> <br> <span>&#x2B22;</span> <span>&#x2B22;</span>
        <span>&#x2B22;</span> <span>&#x2B22;</span> <span>&#x2B22;</span> <span>&#x2B22;</span>
        <span>&#x2B22;</span> <span>&#x2B22;</span> <span>&#x2B22;</span> <span>&#x2B22;</span>
        <span>&#x2B22;</span> <span>&#x2B22;</span>
    </div>
</section>
<div id="circle1">
    <div id="inner-cirlce1">
        <h2></h2>
    </div>
</div>
<br/>
<div style="color:#00a4a2;font-size: 20px;">${err}</div>
</body>
</html>