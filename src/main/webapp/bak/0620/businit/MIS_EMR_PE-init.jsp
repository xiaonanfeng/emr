<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<script type="text/javascript">
    $(document).ready(function () {

        $("#t").blur(function () {
            var l_v = $(this).val();
            if (l_v != "" || l_v != null) {
                custom_options($("#tTest"), '0');//TODO  已写死
            }
        });

        $("#p").blur(function () {
            var l_v = $(this).val();
            if (l_v != "" || l_v != null) {
                custom_options($("#pTest"), '0');//TODO  已写死
            }
        });

        $("#pe-bpL,#pe-bpH").blur(function () {
            var l_v = $(this).val();
            if (l_v != "" || l_v != null) {
                custom_options($("#bpTest"), '0');//TODO  已写死
            }
        });


        $("#r").blur(function () {
            var l_v = $(this).val();
            if (l_v != "" || l_v != null) {
                custom_options($("#rTest"), '0');//TODO  已写死
            }
        });

        $("#hnEyeL").blur(function () {
            var l_v = $(this).val();
            if (l_v != "" || l_v != null) {
                custom_options($("#hnEyeTestL"), '0');//TODO  已写死
            }
        });

        $("#hnEyeR").blur(function () {
            var l_v = $(this).val();
            if (l_v != "" || l_v != null) {
                custom_options($("#hnEyeTestR"), '0');//TODO  已写死
            }
        });


        $("#limbMs").blur(function () {
            var l_v = $(this).val();
            if (l_v != "" || l_v != null) {
                custom_options($("#limbMsTest"), '0');//TODO  已写死
            }
        });

        $("#limbMf").blur(function () {
            var l_v = $(this).val();
            if (l_v != "" || l_v != null) {
                custom_options($("#limbMfTest"), '0');//TODO  已写死
            }
        });

        $("#hnTender").blur(function () {
            var l_v = $(this).val();
            if (l_v != "" || l_v != null) {
                custom_options($("#hnNeck"), '2');//TODO  已写死
            }
        });


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
                hnNeck: $("#hnNeck").val(),
                hnTender: $("#hnTender").val(),
                hnOther: $("#hnOther").val(),
                chestThorax: $("#chestThorax").val(),
                chestTender: $("#chestTender").val(),
                chestOther: $("#chestOther").val(),
                lungBsL: $("#lungBsL").val(),
                lungRL: $("#lungRL").val(),
                lungBsR: $("#lungBsR").val(),
                lungRR: $("#lungRR").val(),
                lungOther: $("#lungOther").val(),
                hrtRate: $("#hrtRate").val(),
                hrtRhythm: $("#hrtRhythm").val(),
                hrtSound: $("#hrtSound").val(),
                hrtMurmur: $("#hrtMurmur").val(),
                hrtOther: $("#hrtOther").val(),
                abdAbd: $("#abdAbd").val(),
                abdWall: $("#abdWall").val(),
                abdTender: $("#abdTender").val(),
                abdRebt: $("#abdRebt").val(),
                abdLiver: $("#abdLiver").val(),
                abdLiverSize: $("#abdLiverSize").val(),
                abdSpleen: $("#abdSpleen").val(),
                abdSplSize: $("#abdSplSize").val(),
                abdBs: $("#abdBs").val(),
                abdOther: $("#abdOther").val(),
                limbMs: $("#limbMs").val(),
                limbMf: $("#limbMf").val(),
                limbEdema: $("#limbEdema").val(),
                limbMsTest: $("#limbMsTest").val(),
                limbMfTest: $("#limbMfTest").val(),
                limbEdemaTest: $("#limbEdemaTest").val(),
                limbMsL: $("#limbMsL").val(),
                limbMsLue: $("#limbMsLue").val(),
                limbMsLle: $("#limbMsLle").val(),
                limbMsR: $("#limbMsR").val(),
                limbMsRue: $("#limbMsRue").val(),
                limbMsRle: $("#limbMsRle").val(),
                limbEdemaBle: $("#limbEdemaBle").val(),
                limbEdemaLle: $("#limbEdemaLle").val(),
                limbEdemaRle: $("#limbEdemaRle").val(),
                limbOther: $("#limbOther").val(),
                spine: $("#spine").val(),
                spnOther: $("#spnOther").val(),
                nrPr: $("#nrPr").val(),
                nrBabinski: $("#nrBabinski").val(),
                nrBabinskiR: $("#nrBabinskiR").val(),
                nrMes: $("#nrMes").val(),
                nrOther: $("#nrOther").val(),
                peOther: $("#peOther").val(),
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
                error: function (textStatus) {
                    $("#callPe").find("i").text(textStatus.status + textStatus.statusText);
                    $("#callPe").removeClass().addClass("A_red");
                }
            });
        });
    });
</script>