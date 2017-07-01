<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<script type="text/javascript">
    $(document).ready(function () {


        //1分钟
        $("#apgarAp1,#apgarP1,#apgarG1,#apgarAc1,#apgarR1").change(function () {
            var l_apgarAp = $("#apgarAp1").val() * 1;
            var l_apgarP = $("#apgarP1").val() * 1;
            var l_apgarG = $("#apgarG1").val() * 1;
            var apgarAc = $("#apgarAc1").val() * 1;
            var l_apgarR = $("#apgarR1").val() * 1;
            $("#apgar1").val(sum([l_apgarAp, l_apgarP, l_apgarG, apgarAc, l_apgarR]));
        });

        //5
        $("#apgarAp5,#apgarP5,#apgarG5,#apgarAc5,#apgarR5").change(function () {
            var l_apgarAp = $("#apgarAp5").val() * 1;
            var l_apgarP = $("#apgarP5").val() * 1;
            var l_apgarG = $("#apgarG5").val() * 1;
            var apgarAc = $("#apgarAc5").val() * 1;
            var l_apgarR = $("#apgarR5").val() * 1;
            $("#apgar5").val(sum([l_apgarAp, l_apgarP, l_apgarG, apgarAc, l_apgarR]));
        });

        //10
        $("#apgarAp10,#apgarP10,#apgarG10,#apgarAc10,#apgarR10").change(function () {
            var l_apgarAp = $("#apgarAp10").val() * 1;
            var l_apgarP = $("#apgarP10").val() * 1;
            var l_apgarG = $("#apgarG10").val() * 1;
            var apgarAc = $("#apgarAc10").val() * 1;
            var l_apgarR = $("#apgarR10").val() * 1;
            $("#apgar10").val(sum([l_apgarAp, l_apgarP, l_apgarG, apgarAc, l_apgarR]));
        });

        //15
        $("#apgarAp15,#apgarP15,#apgarG15,#apgarAc15,#apgarR15").change(function () {
            var l_apgarAp = $("#apgarAp15").val() * 1;
            var l_apgarP = $("#apgarP15").val() * 1;
            var l_apgarG = $("#apgarG15").val() * 1;
            var apgarAc = $("#apgarAc15").val() * 1;
            var l_apgarR = $("#apgarR15").val() * 1;
            $("#apgar15").val(sum([l_apgarAp, l_apgarP, l_apgarG, apgarAc, l_apgarR]));
        });


        $("#saveSePed").click(function () {
            var MisEmrSePed = {
                id: $("#id").val(),
                apgarAp1: $("#apgarAp1").val(),
                apgarP1: $("#apgarP1").val(),
                apgarG1: $("#apgarG1").val(),
                apgarAc1: $("#apgarAc1").val(),
                apgarR1: $("#apgarR1").val(),
                apgarAp5: $("#apgarAp5").val(),
                apgarP5: $("#apgarP5").val(),
                apgarG5: $("#apgarG5").val(),
                apgarAc5: $("#apgarAc5").val(),
                apgarR5: $("#apgarR5").val(),
                apgarAp10: $("#apgarAp10").val(),
                apgarP10: $("#apgarP10").val(),
                apgarG10: $("#apgarG10").val(),
                apgarAc10: $("#apgarAc10").val(),
                apgarR10: $("#apgarR10").val(),
                apgarAp15: $("#apgarAp15").val(),
                apgarP15: $("#apgarP15").val(),
                apgarG15: $("#apgarG15").val(),
                apgarAc15: $("#apgarAc15").val(),
                apgarR15: $("#apgarR15").val()
            };
            $.ajax({
                contentType: "application/x-www-form-urlencoded; charset=utf-8",
                url: "${ctx}/misEmrSePed.do?method=saveMisEmrSePed",
                data: MisEmrSePed,
                type: "post",
                success: function (data) {
                    if (data.err != null) {
                        $("#callPed").find("i").text(data.err);
                        $("#callPed").removeClass().addClass("A_red");
                    } else {
                        $("#callPed").find("i").text("保存成功！");
                        $("#callPed").removeClass().find("i").width("0px");
                        $("#callPed").addClass("A_green");
                    }
                },
                error: function (data, textStatus) {
                    $("#callPed").find("i").text(textStatus.status + textStatus.statusText);
                    $("#callPed").removeClass().addClass("A_red");
                    alert(textStatus + "错误:" + data.responseText);
                }
            });
        });
    });

    //计算数组的和
    function sum(list) {
        var reVal = 0;
        try {
            reVal = eval(list.join("+"));
        } catch (e) {
            alert(e);
        }
        return reVal;
    }

</script>