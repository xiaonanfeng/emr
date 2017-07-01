<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<script type="text/javascript">
    $(document).ready(function () {

        $("#saveSeTruma").click(function () {
            //TODO 重写验证方式   把验证方法写到验证组件里。
            /**
             //console.log($("#phiBr").val());
             //console.log($("#phiCons").val());
             //console.log($("#phiSbp").val());
             //console.log($("#phiPr").val());
             //PHI
             if($("#phiBr").val()!=""||$("#phiCons").val()!=""||$("#phiSbp").val()!=""||$("#phiPr").val()!=""){
			if(vld_phi.form()==false){return ;};
		}
             //GCS
             if($("#dglsEr").val()!=""||$("#dglsVr").val()!=""||$("#dglsMr").val()!=""){
			if(vld_gcs.form()==false){return ;};
		}
             **/

            /**
             $("vld_phi_form select").each(function (){
				alert($(this).val());
			});
             **/
            //PHI
            if ($("#phiBr").val() != "" || $("#phiCons").val() != "" || $("#phiSbp").val() != "" || $("#phiPr").val() != "") {
                if ($("#phiBr").val() == "") {
                    $("#callTruma").find("i").text("请选择呼吸评分");
                    $("#callTruma").removeClass().addClass("A_red");
                    return;
                }
                if ($("#phiCons").val() == "") {
                    $("#callTruma").find("i").text("请选择神志评分");
                    $("#callTruma").removeClass().addClass("A_red");
                    return;
                }
                if ($("#phiSbp").val() == "") {
                    $("#callTruma").find("i").text("请选择收缩压评分");
                    $("#callTruma").removeClass().addClass("A_red");
                    return;
                }
                if ($("#phiPr").val() == "") {
                    $("#callTruma").find("i").text("请选择脉率评分");
                    $("#callTruma").removeClass().addClass("A_red");
                    return;
                }

            }
            //GCS
            if ($("#dglsEr").val() != "" || $("#dglsVr").val() != "" || $("#dglsMr").val() != "") {
                if ($("#dglsEr").val() == "") {
                    $("#callTruma").find("i").text("请选择睁眼反应评分");
                    $("#callTruma").removeClass().addClass("A_red");
                    return;
                }
                if ($("#dglsVr").val() == "") {
                    $("#callTruma").find("i").text("请选择语言反应评分");
                    $("#callTruma").removeClass().addClass("A_red");
                    return;
                }
                if ($("#dglsMr").val() == "") {
                    $("#callTruma").find("i").text("请选择运动反应评分");
                    $("#callTruma").removeClass().addClass("A_red");
                    return;
                }
            }

            var MisEmrSeTruma = {
                id: $("#id").val(),
                phiTotal: $("#phiTotal").val(),
                phiBr: $("#phiBr").val(),
                phiCons: $("#phiCons").val(),
                phiSbp: $("#phiSbp").val(),
                phiPr: $("#phiPr").val(),
                dglsTotal: $("#dglsTotal").val(),
                dglsEr: $("#dglsEr").val(),
                dglsVr: $("#dglsVr").val(),
                dglsMr: $("#dglsMr").val()
            };
            $.ajax({
                contentType: "application/x-www-form-urlencoded; charset=utf-8",
                url: "${ctx}/misEmrSeTruma.do?method=saveMisEmrSeTruma",
                data: MisEmrSeTruma,
                type: "post",
                success: function (data) {
                    if (data.err != null) {
                        $("#callTruma").find("i").text(data.err);
                        $("#callTruma").removeClass().addClass("A_red");
                    } else {
                        $("#callTruma").find("i").text("保存成功！");
                        $("#callTruma").removeClass().find("i").width("0px");
                        $("#callTruma").addClass("A_green");
                    }
                },
                error: function (data, textStatus) {
                    $("#callTruma").find("i").text(textStatus.status + textStatus.statusText);
                    $("#callTruma").removeClass().addClass("A_red");
                    alert(textStatus + "错误:" + data.responseText);
                }
            });
        });

    });

    function valPhi() {
        //校验
        //if(vld_phi.form()==false){return ;};
        //if($("#phiBr").val()==""&&$("#phiCons").val()==""&&$("#phiSbp").val()==""&&$("#phiPr").val()==""){
        //vld_phi.form()==true;
        //}
    }

    function valGcs() {
        //校验
        //if(vld_gcs.form()==false){return ;};
    }
</script>
