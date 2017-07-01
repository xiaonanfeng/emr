<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<script type="text/javascript">


    $(document).ready(function () {
        //高级页面样式控制
        <c:forEach var='pageCssControlList' items='${pageCssControlList}'>
        pageCssControl($("#" + '${pageCssControlList.htmlid}'), '${pageCssControlList.csskey}', '${pageCssControlList.cssvalue}');
        $("*[group='${pageCssControlList.htmlid}']").css('${pageCssControlList.csskey}', '${pageCssControlList.cssvalue}');
        </c:forEach>


        selfControl();//菜单控制

        //心电图是否已查
        $("#ecg").change(function () {
            var obj = $(this);
            hideEcg(obj);
        });

        //两级联动菜单
        $("#cause").change(function () {
            var code = $("#cause").val();
            var discode = $("#diseaseType").val();
            callSe(code, discode);//呼叫模板
            //呼出第二级
            $.ajax({
                contentType: "application/x-www-form-urlencoded; charset=utf-8",
                url: "${ctx}/misEmrBasicinfo.do?method=findDiseaseType",
                data: "&code=" + code,
                type: "post",
                success: function (data) {
                    $("#diseaseTypeTD").empty();
                    $("#diseaseTypeTD").append(data);
                    if (code == "256") {//TODO 疾病，特列
                        $("#diseaseType").bind("change", function () {
                            callSe(code, $(this).val())
                        });
                    }
                    //createSelect($("#diseaseType"));//新select创建访法
                }
            });
        });

        /**送往医院
         $("#sentTo").change(function (){
			var l_value = $(this).val();//值
			if(l_value=="99"){
				$("div[group='sendToOther']").css("display","block");
			}else{
				$("div[group='sendToOther']").css("display","none");
			}
		});
         **/


    });


    function hideEcg(obj) {
        if (obj.val() == '0') {
            showGroup("thEcg");
        } else {
            clearGroup("thEcg");
        }
    }

    //如果这个单子不是本人填的
    //包括中心审核人员
    //就隐藏保存、提交、附件
    function selfControl() {
        var createuserid = '${misEmrBasicinfo.createuserid}';
        //如果不是本人填写	或者		已经提交，则隐藏操作按钮
        if ((createuserid != '${sysMemberInfo.id}' && createuserid != null && createuserid.length > 0) || ('${misEmrBasicinfo.isCommitted}' == 1)) {
            $("#lbs1").hide();
            $("#lbs2").hide();
// 				提交按钮
            $(".commitButton").hide();
            $(".commitStyle").hide();
            $(".commitStyle0").hide();
            $(".commitStyle1").hide();
// 				上传
            $("#webuploaderJsp").hide();
// 				右侧扩展操作按钮
            $("#addEcg").hide();
            $("#addPrim").hide();
            $("#addScene").hide();
            $("#addDrug").hide();
            $("#addAar").hide();
// 				保存按钮
            $("#saveBase").hide();
            $("#savePe").hide();
            $("#saveSeTruma").hide();
            $("#saveSePed").hide();
            $("#saveSeOb").hide();
            $("#saveSeGyn").hide();
            $("#saveAe").hide();
            $("#saveVs").hide();
        }
    }

    //疾病分类选择器
    function callSe(code, discode) {
        //console.log(code);
        //console.log(discode);
        if (code == "258" || code == "259" || (code == "256" && discode == "50")) {//外科：呼出PHI和GCS
            showDiv(["truma"]);
            hideDiv(["ob", "ped", "segyn"]);
        } else if (code == "257") {//产科：呼出产科
            showDiv(["ob"]);
            hideDiv(["truma", "ped", "segyn"]);
        } else if (code == "273") {//儿科：呼出儿科
            showDiv(["ped"]);
            hideDiv(["truma", "ob", "segyn"]);
        } else {
            hideDiv(["truma", "ob", "ped", "segyn"]);
        }
    }

    //妇科选择器，大于12岁的女性
    function callGyn() {
        if ($("#sex").val() == '20' && ($("#age").val() * $("#timeScope").val() >= 12 * 518400)) {
            showDiv(["segyn"], 1000);
        } else {
            hideDiv(["segyn"], 1000);
        }
    }

    //隐藏相应div
    function hideDiv(arr) {
        for (var i = 0; i < arr.length; i++) {
            $("#" + arr[i]).css("display", "none");
        }
    }
    //显示相应div
    function showDiv(arr) {
        for (var i = 0; i < arr.length; i++) {
            $("#" + arr[i]).css("display", "block");
        }
    }

    //组hide
    function clearGroup(groupStr) {
        $("[hideGroup=" + groupStr + "]").each(function () {
            $(this).hide();
        });
    }

    //组show
    function showGroup(groupStr) {
        $("[hideGroup=" + groupStr + "]").each(function () {
            $(this).show();
        });
    }

    //toggleGroup
    function toggleGroup(groupStr) {
        $("[group=" + groupStr + "]").each(function () {
            $(this).slideToggle();
        });
    }


</script>
				