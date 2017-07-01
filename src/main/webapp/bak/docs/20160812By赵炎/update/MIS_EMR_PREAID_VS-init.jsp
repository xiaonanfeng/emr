<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<script type="text/javascript">
    //删除药物
    function del(id) {
        if (confirm("确定删除给药记录么？") == false) {
            return;
        }
        $.ajax({
            contentType: "application/x-www-form-urlencoded; charset=utf-8",
            url: "${ctx}/misEmrMar.do?method=delMisEmrMarById",
            data: "id=" + id,
            type: "post",
            success: function (data) {
                $("tr[id=" + id + "tr]").remove();
            },
            error: function (XMLHttpRequest, textStatus, errorThrown) {
                alert("删除失败！");
            }
        });
    }

    $(document).ready(function () {

        //呼出药物应用
        $("#addDrug").click(function () {
            var emrId = $("#id").val();
            open_layer("选择现场药物应用", "${ctx}/misEmrMar.do?method=findMisEmrMarForInput&flag=sceneDrug&emrId=" + emrId + "&values=${misEmrPreaidVs.sceneDrug}',900,700)");
        });

        //复制病情选择项到描述框
        $("#primDiagR").focus(function () {
            if ($(this).val() == null || $(this).val() == "") {
                var str = $("#primDiagText").val();
                str = str.replace(/,/g, "      ");
                $(this).val($(this).val() + str);
            }
        });

        //保存对象
        $("#saveVs").click(function () {
            if (vld_preaidVs.form() == false) {
                return;
            }
            ;
            //封装施救措施对象
            var misEmrPreaidVs = {
                id: $("#id").val(),
                primDiag: $("#primDiag").val(),
                primDiagR: $("#primDiagR").val(),
                doctorSign: $("#doctorSign").val(),
                nurseSign: $("#nurseSign").val(),
                signDate: $("#signDate").val(),
                sceneTreat: $("#sceneTreat").val(),
                sceneDrug: $("#sceneDrug").val(),
                sceneRecord: $("#sceneRecord").val(),
                itwChange: $("#itwChange").val(),
                itwTreat: $("#itwTreat").val(),
                itwDrug: $("#itwDrug").val(),
                itwRecord: $("#itwRecord").val(),
                arrivalVs: $("#arrivalVs").val(),
                senRcdOther: $("#senRcdOther").val(),
                drugOther: $("#drugOther").val()
            };
            $.ajax({
                contentType: "application/x-www-form-urlencoded; charset=utf-8",
                url: "${ctx}/misEmrPreaidVs.do?method=saveMisEmrPreaidVs",
                data: misEmrPreaidVs,
                type: "post",
                success: function (data) {
                    if (data.err != null) {
                        $("#callVs").find("i").text(data.err);
                        $("#callVs").removeClass().addClass("A_red");
                    } else {
                        $("#callVs").find("i").text("保存成功！");
                        $("#callVs").removeClass().find("i").width("0px");
                        $("#callVs").addClass("A_green");
                        /**
                         *@deprecated
                         **/
                        //$("#senceDrugMar").css("display","none");
                        //$("#itwDrugMar").css("display","none");
                        //document.getElementById('senceDrugListTd').contentWindow.location.reload(true);
                        //document.getElementById('itwDrugListTd').contentWindow.location.reload(true);
                    }
                },
                error: function (textStatus) {
                    $("#callVs").find("i").text(textStatus.status + textStatus.statusText);
                    $("#callVs").removeClass().addClass("A_red");
                }
            });
        });

        /****deprecated******deprecated*****deprecated*****deprecated*****deprecated******deprecated*********/

        //如果途中病情又变化就显示
        /**
         *@deprecated @deprecated @deprecated@
         **/
        $("#itwDiv").click(function () {
            $("#itwHideDiv").slideToggle();
        });
        //呼出药物使用列表
        $("#sceneDrugCallBackButton").click(function () {
            var tarId = "senceDrugMar";
            var valueStr = $("#sceneDrug").val();
            var valueText = $("#sceneDrugText").val();
            if (valueStr != null && valueStr.length > 0) {//如果选中药物有对象则生成数组
                drugsCallBack(tarId, valueStr, valueText, 1);
            } else {//如果没有就把相应的区域清空
                $("#senceDrugMar").empty();
            }
        });

        //呼出途中病情变化药物使用列表
        $("#itwDrugCallBackButton").click(function () {
            var tarId = "itwDrugMar";
            var valueStr = $("#itwDrug").val();
            var valueText = $("#itwDrugText").val();
            if (valueStr != null && valueStr.length > 0) {//如果选中药物有对象则生成数组
                drugsCallBack(tarId, valueStr, valueText, 2);
            } else {//如果没有就把相应的区域清空
                $("#itwDrugMar").empty();
            }
        });
        /**
         //用药对象封装完毕
         var misEmrMarArray = new Array();//封装药物应用对象
         var arrValue = $("#sceneDrug").val().split(",");
         for(i=0;i<arrValue.length;i++){
				var drugId = arrValue[i];
				if(drugId!=null&&drugId!=""){//如果药物ID不是空
					misEmrMarArray.push({
						type:1,//Integer type;//现场
						medId:drugId*1, //Long medId;//药物ID
						usage:$("#1usage"+drugId).val(), //String usage;//使用方法
						dose:$("#1dose"+drugId).val(), //String dose;//用量
						useTimeStr:$("#1useTime"+drugId).val() //Date useTime;//使用时间
					});
				}
			}

         arrValue = $("#itwDrug").val().split(",");
         for(i=0;i<arrValue.length;i++){
				var drugId = arrValue[i];
				if(drugId!=null&&drugId!=""){//如果药物ID不是空
					misEmrMarArray.push({
						type:2,//Integer type;//现场
						medId:drugId*1, //Long medId;//药物ID
						usage:$("#2usage"+drugId).val(), //String usage;//使用方法
						dose:$("#2dose"+drugId).val(), //String dose;//用量
						useTimeStr:$("#2useTime"+drugId).val() //Date useTime;//使用时间
					});
				}
			}
         //用药对象封装完毕
         **/

        /****deprecated******deprecated*****deprecated*****deprecated*****deprecated******deprecated*********/
    });
    /**
     *@deprecated
     *htmlDiv :需要操作的html区域
     *valueStr：值字符串
     *valueText：文本
     *type:给药类型，途中？现场
     **/
    function drugsCallBack(tarId, valueStr, valueText, type) {
        var obj = $("#" + tarId);
        //alert(valueStr);
        var arrValue = valueStr.split(",");
        var arrText = valueText.split(",");
        obj.empty();
        var htmlStr = "<table width=\"100%\" border=\"1\" class=\"editForm\">";
        //alert(arrValue.length);
        for (i = 0; i < arrValue.length; i++) {
            var drugId = arrValue[i];
            //动态生成药物使用列表
            htmlStr = htmlStr
                    + ("<tr id='" + type + "tr" + drugId + "' style=\"cursor:pointer\">" //tr加个id用于删除行
                    + "<td>"
                    + "<input type='text' id='" + type + "id" + drugId + "' value=" + drugId + " />"//class="debugMode${deBugMode}"
                    + "</td>"
                    + "<td style='text-align:center'>序号：" + i + "</td>"//用药序号
                    + "<td style='text-align:center'>立即用药</td>"//并没有什么用
                    + "<td>"
                    + "<input placeholder='用药分组，默认同组'  style='width:150px;' type=\"text\" id='" + type + "drugGrp" + drugId + "' value=\"\" />"
                    + "</td>"
                    + "<td style='text-align:left'>" + arrText[i] + "</td>"//并没有什么用
                    + "<td>"
                    + "<input  placeholder='选择给药途径' type='text' id='" + type + "usage" + drugId + "Text' readonly='readonly' "
                    + "onfocus=\"open_layer('选择给药途径','${ctx}/misEmrMar.do?method=findUseage&flag=" + type + "usage" + drugId + "&values=[] ');\"/>"
                    + "<input type='hidden' id='" + type + "usage" + drugId + "' />"
                    + "</td>"
                    + "<td>"
                    + "<input placeholder='用量！如：500mg'  style='width:150px;' type=\"text\" id='" + type + "dose" + drugId + "' required >"
                    + "</td>"
                    + "<td>"
                    + "<input  value='${nowDAT}' type='text' placeholder='请选择给药时间' id='" + type + "useTime" + drugId + "' onfocus=\"WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})\" >"
                    + "</td>"
                    //+"<td>"
                    //+"<a style=\"cursor: pointer;\" onclick=delTr('"+type+"tr"+drugId+"','"+type+"','"+drugId+"')>"   //删除图标加本行tr的id
                    //+"<img alt=\"删除\" title=\"删除\" src=\"${ctx}/css/images/ZXICO/delBig.png\">"
                    //+"</a>"
                    //+"</td>"
                    + "</tr>");
        }
        htmlStr = htmlStr + "</table>";
        obj.css("display", "block");
        obj.html(htmlStr);
    }


</script>
				