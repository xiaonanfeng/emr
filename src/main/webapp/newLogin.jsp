<!DOCTYPE html >
<%@ page language="java" import="java.util.*" pageEncoding="utf-8" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>中兴电子病历V9.0</title>
    <link rel="stylesheet" href="css/login/Style/bootstrap.css">
    <link rel="stylesheet" href="css/login/Style/newLogin.css">
    <script src="js/jquery-2.1.1.min.js"></script>
    <script src="js/jquery_tooltip.js"></script>
    <script type="text/javascript">
        $(document).ready(function () {
            $.tooltip.init();//初始化
            if ($('#alert').text != "") {
                $.tooltip.tipshow($('#alert').text());//弹出对话框
            }
        })

        function login(path) {
            if (path == "web") {
                web();
            } else {
                pad();
            }
        }
        /**
         *判断是否为移动端
         **/
        function IsPC() {
            var userAgentInfo = navigator.userAgent;
            var Agents = ["Android", "iPhone",
                "SymbianOS", "Windows Phone",
                "iPad", "iPod"];
            var flag = true;
            for (var v = 0; v < Agents.length; v++) {
                if (userAgentInfo.indexOf(Agents[v]) > 0) {
                    flag = false;
                    break;
                }
            }
            return flag;
        }

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
<div class="container-fluid">
    <div class="row" style="height:100px;"></div>
    <div class="row">
        <div class="col-md-3 col-sm-2">
        </div>
        <div class="col-md-4 col-md-offset-4 col-sm-6 col-xm col-sm-offset-3">
            <div class="row main-content">
                <img src="css/login/Images/logo.png" style="width: 60px;" alt="logo">
                <span>院前急救电子病历系统</span>
            </div>
            <form role="form" action="" method="post" id="dataForm">
                <div class="form-group has-feedback">
                    <input type="text" placeholder="用户名" class="form-control" name="id" id="id">
                    <span class="glyphicon glyphicon-user form-control-feedback"></span>
                </div>
                <div class="form-group has-feedback">
                    <input type="password" placeholder="密码" class="form-control" name="password">
                    <span class="glyphicon glyphicon-lock form-control-feedback"></span>
                </div>

                <div class="form-group">
                    <button onclick="login('web')" class="btn-login btn btn-default" style="width:49%;">
                        电脑登录
                    </button>

                    <button onclick="login('pad')" class="btn-login btn btn-default" style="width:49%;">
                        平板登录
                    </button>
                </div>
            </form>
        </div>
    </div>
    <br/>
    <div id="alert" style="display:none">${err}</div>
    <div class="row footer">
        <span>Copyright © 1998-2014 ZIT.All Rights Reserved 版权所有 南京中兴维先信息技术有限</span>
    </div>
</div>
</body>
</html>