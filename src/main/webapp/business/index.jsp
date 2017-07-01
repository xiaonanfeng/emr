<!DOCTYPE HTML>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8" %>
<%@ include file="/taglibs.jsp" %>
<html>
<head>
    <title>${systemConfig.systemTitle }</title>


    <!-- 初始化赋值 -->
    <%@ include file="/businit/aValueInit.jsp" %>

    <!-- 页面select选择控制器 -->
    <%@ include file="aChooser.jsp" %>

    <script type="text/javascript">
        $(document).ready(function () {
            //提交方法
            var buttonArr = ["saveBase", "savePe", "saveSeGyn", "saveSeOb", "saveSePed", "saveSeTruma", "saveAe", "saveVs"];
            $(".commitButton").click(function () {

                if (confirm("直接提交数据合法性将没有保证，并且病历将不可修改！确定么？") == true) {

                    $("#li_basic").click();//点击基础信息部分

                    //开始校验
                    var flag = true;
                    flag = vld_Base.form();

                    //如果选中未送院则所有项目不必要必填
                    if ($("#isHosptial").is(':checked') == true) {
                        $("label.error").each(function () {
                            $(this).empty();
                        });
                        flag = true;
                    }

                    if (flag == false) {
                        return;
                    }

                    for (var i = 0; i < buttonArr.length; i++) {
                        $("#" + buttonArr[i]).click();//循环提交
                    }

                    /**提交信息**/
                    var l_id = $("#id").val();
                    $.ajax({
                        contentType: "application/x-www-form-urlencoded; charset=utf-8",
                        url: "${ctx}/misEmrBasicinfo.do?method=commitMisEmrBasicinfo",
                        data: "id=" + l_id,
                        type: "post",
                        success: function (data) {
                            if (data == "") {
                                $(".btn").hide(2000);//隐藏所有的操作按钮
                                $("#webuploaderJsp").hide(2000);//隐藏上传组件
                            } else {
                                alert("错误：" + data);
                            }
                        }
                    });

                }

            });

            /**
             var keyFlag = 0;//页面按键监听
             $("body").keydown(function(e){
			var ev = document.all ? window.event : e;
	    	if(ev.keyCode==13) {
	    		keyFlag = keyFlag+1;//单击
	    		if(keyFlag==2){//双击
	    			$("#saveBase").click();
	    			$("#savePe").click();
	    			$("#saveAe").click();
	    			$("#saveVs").click();
	    			$("#saveSeGyn").click();
	    			$("#saveSeOb").click();
	    			$("#saveSePed").click();
	    			$("#saveSeTruma").click();
	    			keyFlag = 0;//初始化
	    		}
	    	}
	});
             **/

        });
    </script>
</head>
<body>
<div class="tab_div" id="tab_div_BL">
    <dl>
        <c:if test="${systemConfig.initCmplt==1&&modify==false}">
            <dt class="tab_div_dt tab_div_dt_active">选择模板</dt>
        </c:if>
        <dt class="tab_div_dt <c:if test="${modify==true}">tab_div_dt_active</c:if>" id="li_basic">基础信息</dt>
        <dt class="tab_div_dt">体格检查</dt>
        <dt class="tab_div_dt">专项检查</dt>
        <dt class="tab_div_dt">辅助检查</dt>
        <dt class="tab_div_dt">施救措施</dt>
    </dl>

    <div class="tab_div_line"></div>
    <ul id="tab_items">
        <c:if test="${systemConfig.initCmplt==1&&modify==false}">
            <li id="li_cmplt" style="display:block;">
                <!--填写辅助 -->
                <%@ include file="MIS_EMR_CMPLET.jsp" %>
            </li>
        </c:if>
        <li <c:if test="${modify==true}"> style="display:block;" </c:if>>
            <!--基础信息 -->
            <%@ include file="MIS_EMR_BASICINFO.jsp" %>
        </li>
        <li>
            <!--体格检查 -->
            <%@ include file="MIS_EMR_PE.jsp" %>
        </li>
        <li>
            <!--创伤专科检查 -->
            <%@ include file="MIS_EMR_SE_TRUMA.jsp" %>
            <!--妇科专科检查 -->
            <%@ include file="MIS_EMR_SE_GYN.jsp" %>
            <!--产科专科检查 -->
            <%@ include file="MIS_EMR_SE_OB.jsp" %>
            <!--新生儿Apgar评分 -->
            <%@ include file="MIS_EMR_SE_PED.jsp" %>
        </li>
        <li id="li_basic">
            <!--体格检查 -->
            <%@ include file="MIS_EMR_AE.jsp" %>
        </li>
        <li id="li_basic">
            <!--处理措施和病情 -->
            <%@ include file="MIS_EMR_PREAID_VS.jsp" %>
        </li>

    </ul>
</div>
<!-- Js表单验证 ，放到上面会找不到方法-->
<%@ include file="/busvald/aValidator.jsp" %>

<!-- 保存 提示 -->
<ul class="A_JDT">
    <li id="callBase"><i></i>
        <div>基础信息</div>
    </li>
    <li id="callPe"><i></i>
        <div>体格检查</div>
    </li>
    <li id="callTruma"><i></i>
        <div>PHI/GCS</div>
    </li>
    <li id="callOb"><i></i>
        <div>产科检查</div>
    </li>
    <li id="callGyn"><i></i>
        <div>妇科检查</div>
    </li>
    <li id="callPed"><i></i>
        <div>儿科检查</div>
    </li>
    <li id="callAe"><i></i>
        <div>辅助检查</div>
    </li>
    <li id="callVs"><i></i>
        <div>施救措施</div>
    </li>
</ul>


<!-- 跟随鼠标悬浮DIV-->

<!--上传组件 -->
<div id="webuploaderJsp">
    <%@ include file="/upload.jsp" %>
</div>

<!-- 	<div id="followCs">	 -->
<div>
    <%@ include file="buttonPage.jsp" %>
</div>


<!--带关闭按钮的层 -->
<div class="the_zhezhao" id="the_zhezhao"></div>
<div id="layer_box" class="layer_box">
    <div class="layer_title_bg" id="layer_title_bg">
        <img src="${ctx}/css/images/ZXICO/title_ico.gif" width="12"
             height="9"/> <span id="layer_title"></span>
        <div class="layer_closed_ico" onclick="closed_layer('layer_box')"></div>
    </div>
    <div class="index_loading_bg" id="index_loading_bg"></div>
    <iframe src="${ctx}/loading.html" id="iframe_layer" name="iframe_layer" frameborder="0" width="300" height="160"
            scrolling="auto" style="margin:0px; padding:0px; z-index:1;"></iframe>
</div>

<!-- 	患者ID：接警流水号：出车序号： -->
<input Persistence="true" class="debugMode${deBugMode}" id="id" name="id" value="${misEmrBasicinfo.id}"
       readonly="readonly" title="主键">
<input Persistence="true" class="debugMode${deBugMode}" id="isCommitted" name="isCommitted"
       value="${misEmrBasicinfo.isCommitted}" readonly="readonly" title="提交标志">
<input Persistence="true" class="debugMode${deBugMode}" id="lsh" name="lsh" value="${param.lsh}" readonly="readonly"
       title="警情流水号">
<input Persistence="true" class="debugMode${deBugMode}" id="ccxh" name="ccxh" value="${param.ccxh}" readonly="readonly"
       title="出车序号">

</body>
</html>
