<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<script type="text/javascript">
    $(document).ready(function () {

        $("#tTest").css("width", "60px");
        $("#pTest").css("width", "60px");
        $("#rTest").css("width", "60px");
        $("#bpTest").css("width", "60px");
        $("#hnEyeTestL").css("width", "60px");
        $("#hnEyeTestR").css("width", "60px");

        $("#savePe").click(function () {

            if (vld_Pe.form() == false) {
                return;
            }
            ;//校验

            var MisEmrPe = {
                id: $("#id").val(),//患者id
                t: $("#t").val(),
                p: $("#p").val(),
                r: $("#r").val(),
                tTest: $("#tTest").val(),
                pTest: $("#pTest").val(),
                rTest: $("#rTest").val(),
                bpTest: $("#bpTest").val(),
                bpL: $("#pe-bpL").val(),
                bpH: $("#pe-bpH").val(),
                posture: $("#posture").val(),
                conscious: $("#conscious").val(),
                skin: $("#skin").val(),
                cyanosis: $("#cyanosis").val(),
                hnEyeTestL: $("#hnEyeTestL").val(),
                hnEyeTestR: $("#hnEyeTestR").val(),
                hnEyeL: $("#hnEyeL").val(),
                hnPlrL: $("#hnPlrL").val(),
                hnEyeR: $("#hnEyeR").val(),
                hnPlrR: $("#hnPlrR").val(),
                headNeck: $("#headNeck").val(),
                chest: $("#chest").val(),
                lung: $("#lung").val(),
                heart: $("#heart").val(),
                abdomen: $("#abdomen").val(),
                limb: $("#limb").val(),
                spine: $("#spine").val(),
                nerveReflex: $("#nerveReflex").val(),
                peOthers: $("#peOthers").val()

            };
            $.ajax({
                contentType: "application/x-www-form-urlencoded; charset=utf-8",
                url: "${ctx}/misEmrPe.do?method=saveMisEmrPe",
                data: MisEmrPe,
                type: "post",
                success: function (data) {
                    if (data.err != null) {
                        $("#callPe").find("i").text(data.err);
                        $("#callPe").removeClass().addClass("A_red");
                    } else {
                        $("#callPe").find("i").text("保存成功！");
                        $("#callPe").removeClass().find("i").width("0px");
                        $("#callPe").removeClass().addClass("A_green");
                    }
                },
                error: function (data, textStatus) {
                    $("#callPe").find("i").text(textStatus.status + textStatus.statusText);
                    $("#callPe").removeClass().addClass("A_red");
                    alert(textStatus + "错误:" + data.responseText);
                }
            });
        });
    });
</script>