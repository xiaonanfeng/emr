<%@ page language="java" import="java.util.*" pageEncoding="utf-8" %>
<%@ include file="/taglibs.jsp" %>
<!DOCTYPE HTML>
<html>
<head>
    <title>${systemConfig.systemTitle }</title>
    <script>
        $(document).ready(function () {
            kuangjia();
            $("#container").append("<div class='LSZZ' id='LSZZ'></div>");
            $("#logo").click(function () {
                launchFullScreen(document.documentElement);
                return false;
            });

            $("#container").on("click", "#LSZZ", function () {
                $("#perspective").removeClass("modalview");
                $("#Frame_menu").show();
            });

            $("#fanhui a").click(function () {
                $("#perspective").removeClass("modalview");
                $("#Frame_menu").show();
            });

            $("#fullscreenbtn").click(function () {
                launchFullScreen(document.documentElement);
            });

            $("#index_page").dblclick(function () {
                location.reload();
            });

            //退出
            $("#logout").click(function () {
                top.location.href = "${ctx}/login.do?method=logout";
            });

            //帮助中心
            $("#helpCenter").click(function () {
                var url = $(this).attr("link_URL");
                open_layer("帮助中心", url, 1000, 500);
            });


        });
        window.onresize = function () {//分辨率改变重载框架方法。
            kuangjia();
        }
    </script>
</head>
<body class="index_body" id="index_body">
<div class="perspective" id="perspective">
    <div class="container" id="container">
        <div class="Frame_top" id="Frame_top">
            <div class="logo" id="logo"></div>
            <div class="topMenu"
                 title="机构代码：${sysMemberInfo.sysOrgInfo.orgId}++类型：${sysMemberInfo.type}++共享模式：${systemConfig.shareMode}">
                <img src="${ctx}/css/images/ZXICO/ico_man.png" style="vertical-align:middle;width: 18px;height: 18px;"/>欢迎您！ ${sysMemberInfo.name}
                ┊ <c:if test="${systemConfig.shareMode==0}">私有模式</c:if><c:if
                    test="${systemConfig.shareMode==1}">共享模式</c:if>
                ┊ <a id="helpCenter" href="#" class="help" link_URL="${ctx}/help.jsp">帮助中心</a>
                ┊
                <button type="button" id="logout" class="top_button">退 出</button>
            </div>
            <!--       头部标题 -->
            <div id="top_menu" style="">
                <!-- 		<button type="button" class="top_menu_button" link_URL="${ctx}/business/left_menu.jsp">病历登记</button> -->
                <!-- 		<button type="button" class="top_menu_button" link_URL="${ctx}/business/left_menu.jsp">院前交接 </button> -->
                <!-- 		<button type="button" class="top_menu_button" link_URL="${ctx}/business/left_menu.jsp">病历审核 </button> -->
                <!-- 		<button type="button" class="top_menu_button" link_URL="${ctx}/business/left_menu.jsp">修改记录查询</button> -->
            </div>
            <div class="Frame_tab" id="Frame_tab">
                <div class="Frame_tab_bg01 Frame_tab_bg02" id="index_page"
                     style="position:absolute; left: 150px; padding-right:15px;">首页
                </div>
                <ul class="Frame_tab_ul" id="Frame_tab_ul"></ul>
                <div class="Frame_tab_clear" id="Frame_tab_clear">关闭所有</div>
            </div>
        </div>

        <!--------------------左侧菜单--------------------->
        <div class="Frame_menu" id="Frame_menu" style="display:none">
            <iframe frameborder="0" class="Frame_menu_left" id="Frame_menu_left" name="Frame_menu_left" src=""></iframe>
            <div class="menu_move_left" id="Frame_menu_move"></div>
        </div>

        <!--右部主页 -->
        <div class="Frame_right_box" id="Frame_right_box">
            <div class="right_index_box" id="right_index_box">
                <iframe frameborder="0" class="right_index" id="right_index" name="right_index"
                        src="${ctx}/misEmrCategory.do?method=findMisEmrCategory"></iframe>
            </div>
            <div class="Frame_pages " id="Frame_pages"></div>
        </div>

        <!--------------------弹出层页面-------------开始-------->

        <div class="the_zhezhao" id="the_zhezhao"></div>
        <!--带关闭按钮的层 -->
        <div id="layer_box" class="layer_box">
            <div class="layer_title_bg" id="layer_title_bg">
                <img src="${ctx}/css/images/ZXICO/title_ico.gif" width="12"
                     height="9"/> <span id="layer_title"></span>
                <div class="layer_closed_ico" onclick="closed_layer('layer_box')"></div>
            </div>
            <div class="index_loading_bg" id="index_loading_bg"></div>
            <iframe src="${ctx}/loading.html" id="iframe_layer"
                    name="iframe_layer" frameborder="0" width="300" height="160"
                    scrolling="auto" style="margin:0px; padding:0px; z-index:1;"></iframe>
        </div>

        <!--左下角提示消息 -->
        <!-- 			<div class="the_slow_layer" id="layer_slow" style=""> -->
        <!-- 				<div class="layer_title_bg" style=""> -->
        <!-- 					<img src="${ctx}/css/images/ZXICO/title_ico.gif" width="12" -->
        <!-- 						height="9" /> <span id="prompt_title">提示信息</span> -->
        <!-- 					<div class="layer_closed_ico" onclick="closed_slow('layer_slow')"></div> -->
        <!-- 				</div> -->
        <!-- 				<div style="padding:10px; overflow:auto" id="the_max"> -->
        <!-- 					<div id="layle_slow_iframe" style="text-align:left;"> -->
        <!-- 						<div id="slow_box" style=""></div> -->
        <!-- 					</div> -->
        <!-- 				</div> -->
        <!-- 			</div> -->
        <!--声音提示 -->
        <!-- 		    <audio id="messageAudio"> -->
        <!-- 		      <source src="${ctx}/css/message.mp3" type="audio/mpeg"></source> -->
        <!-- 		    </audio> -->
    </div>
    <!-- 	<nav class="outer-nav top horizontal " id="fanhui"> -->
    <!-- 	    <a href="http://www.baidu.com" target="_blank" class="circle" style="background: url(css/images/display_02.png) no-repeat center; background-size:100px 100px;"><div>安全管控平台</div></a> -->
    <!-- 	    <a href="http://www.163.com" target="_blank"  class="circle" style="background: url(css/images/display_01.png) no-repeat center; background-size:120px 120px;"><div>网络管控平台</div></a> -->
    <!-- 	    <a href="#" class="circle" style="background: url(css/images/display_03.png) no-repeat center; background-size:100px 100px;"><div>综合管控平台</div></a> -->
    <!-- 	    <a href="#" class="circle" style="background: url(css/images/display_04.png) no-repeat center; background-size:100px 100px;"><div>退出</div></a> -->
    <!-- 	</nav> -->
</div>
</body>
</html>
