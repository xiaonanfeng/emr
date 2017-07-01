<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<script type="text/javascript">

    $(document).ready(function () {

        $("#timeScope").css("width", "60px");
        $("#idCard").css("width", "145px");
        $("#phone").css("width", "145px");
        $("#address").css("width", "520px");
        $("#sendToOther").css("width", "145px");

        //复制报警电话到实际电话
        $("#phone").focus(function () {
            if ($(this).val() == "" || null == $(this).val()) {
                var l_v = '${vAcceptAmbulOutdInfo.lxdh }';
                $("#phone").val(l_v);
            }
        });

        //复制报警地址到实际地址
        $("#address").focus(function () {
            if ($(this).val() == "" || null == $(this).val()) {
                var l_v = '${vAcceptAmbulOutdInfo.jcdz }';
                $("#address").val(l_v);
            }
        });

        /**如果选择年龄段，则把年龄和年龄单位复原
         $("#stage").change(function (){
		if($(this).val()!=""){
			custom_options($("#age"),'');
			custom_options($("#timeScope"),'');
		}
	});
         **/

        //既往病史不详
        $("#pastHx").change(function () {
            if ($(this).val() == 2) {
                $("#otherHx").val("不详");
            }
        });

        //药敏史不详判断
        $("#drugAllergy").change(function () {
            if ($(this).val() == 2) {
                $("#drugName").val(" ");
            }
        });


        //远程医疗急救按钮
        $(".callRemote").click(function () {
            var flag = $(this).attr("flag");
            var GW_RequestOpenConf = {
                LSH: $("#lsh").val(),
                CCXH: $("#ccxh").val(),
                EMR_ID: $("#id").val(),
                REQ_LEVEL: flag
            };
            $.ajax({
                contentType: "application/x-www-form-urlencoded; charset=utf-8",
                url: "${ctx}/misErmCallRemote.do?method=sendMsg",
                data: GW_RequestOpenConf,
                type: "post",
                success: function (data) {
                    alert("请求成功！");
                },
                error: function (data, textStatus) {
                    alert(textStatus + "错误:" + data.responseText);
                }
            });
        });

        //保存按钮
        $("#saveBase").click(function () {
            //对象组装
            var MisEmrBasicinfo = {
                id: $("#id").val(),//患者id
                lsh: $("#lsh").val(),//流水号
                ccxh: $("#ccxh").val(),//出车编号
                name: $("#name").val(),//名称
                sex: $("#sex").val(),//性别
                stage: $("#stage").val(),
                age: $("#age").val() * $("#timeScope").val(),//年龄=数值*时间范围
                ethnic: $("#ethnic").val(),//民族
                nation: $("#nation").val(),//国籍
                phone: $("#phone").val(),//真实联系电话
                address: $("#address").val(),//真实接车地址
                spot: $("#spot").val(),
                sentTo: $("#sentTo").val(),
                cause: $("#cause").val(),
                condition: $("#condition").val(),
                diseaseType: $("#diseaseType").val(),
                preEmcResult: $("#preEmcResult").val(),
                idCard: $("#idCard").val(),
                chiefComplaint: $("#chiefComplaint").val(),
                hxProvider: $("#hxProvider").val(),
                presentHx: $("#presentHx").val(),
                pastHx: $("#pastHx").val(),
                heartCondition: $("#heartCondition").val(),
                heartIllness: $("#heartIllness").val(),
                heartHx: $("#heartHx").val(),
                heartTherapy: $("#heartTherapy").val(),
                hbp: $("#hbp").val(),
                hbpHx: $("#hbpHx").val(),
                bpH: $("#bpH").val(),
                bpL: $("#bpL").val(),
                hbpTherapy: $("#hbpTherapy").val(),
                diabetes: $("#diabetes").val(),
                dmType: $("#dmType").val(),
                dmHx: $("#dmHx").val(),
                dmTherapy: $("#dmTherapy").val(),
                otherHx: $("#otherHx").val(),
                drugAllergy: $("#drugAllergy").val(),
                drugName: $("#drugName").val(),
                isCommitted: 0,
                contact: $("#contact").val(),
                isHosptial: $("#isHosptial").is(':checked') == true ? 1 : 0,
                dClassify: $("#dClassify").val(),
                sendToOther: $("#sendToOther").val()
            };
            $.ajax({
                contentType: "application/x-www-form-urlencoded; charset=utf-8",
                url: "${ctx}/misEmrBasicinfo.do?method=saveMisEmrBasicinfo",
                data: MisEmrBasicinfo,
                type: "post",
                success: function (data) {
                    $("#callBase").find("i").text("保存成功！");
                    $("#callBase").removeClass().find("i").width("0px");
                    $("#callBase").addClass("A_green");
                },
                error: function (data, textStatus) {
                    $("#callBase").find("i").text(textStatus.status + textStatus.statusText);
                    $("#callBase").removeClass().addClass("A_red");
                    alert(textStatus + "错误:" + data.responseText);
                }
            });
        });

    });

</script>




