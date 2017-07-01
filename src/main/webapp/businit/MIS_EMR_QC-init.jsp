<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<style>
    td {
        line-height: 25px;
        min-width: 50px
    }

    tr td {
        text-align: center;
    }

    td span {
        min-width: 65px;
        display: inline-block;
    }

    .printtable tr td {
        font-size: 12pt;
    }

    .subtitle {
        float: left;
        height: 40px
    }

    .text {
        min-height: 100px;
    }

    .text-end {
        float: right;
    }
</style>
<script>
    $(document).ready(function () {


        //时间段触发器，呼叫该时间段的数据
        $("#getDatas").click(function () {
            var l_startTime = $("#startTime").val();
            var l_endTime = $("#endTime").val();
            var l_levle = '${param.level}';
            if (l_startTime != null && l_endTime != null) {
                $.ajax({
                    url: "${ctx}/misEmrQcSummary.do?method=findQcCounts",
                    data: "startTime=" + l_startTime + "&endTime=" + l_endTime + "&level=" + l_levle,
                    type: "post",
                    contentType: "application/x-www-form-urlencoded; charset=utf-8",
                    success: function (data) {
                        if (data != null && data != "") {
                            dataFinded(data);
                        } else {
                            alert("错误！");
                        }
                    },
                    error: function (data, textStatus) {
                        alert(textStatus + "错误:" + data.responseText);
                    }
                });
            }
        });

        $("#getEmrs").click(function () {
            var l_startTime = $("#startTime").val();
            var l_endTime = $("#endTime").val();
            var l_levle = '${param.level}';
            window.open("${ctx}/misEmrQcSummary.do?method=findDefectEmr&startTime=" + l_startTime + "&endTime=" + l_endTime + "&level=" + l_levle);
        });

        //保存按钮
        $("#saveQc").click(function () {
            //校验
            if (vld_qc.form() == false) {
                return;
            }
            ;
            //对象组装
            var MisEmrQcSummary = {
                id: $("#id").val(),
                qcLevel: $("#qcLevel").val(),
                emrMonth: $("#emrMonth").val(),
                sumUserid: $("#sumUserid").val(),
                sumTime: $("#sumTime").val(),
                startTime: $("#startTime").val(),
                endTime: $("#endTime").val(),
                emrSum: $("#emrSum").val(),
                deathEmrSum: $("#deathEmrSum").val(),
                criticalEmrSum: $("#criticalEmrSum").val(),
                severeEmrSum: $("#severeEmrSum").val(),
                mediumErmSum: $("#mediumErmSum").val(),
                lightEmrSum: $("#lightEmrSum").val(),
                spotCheckSum: $("#spotCheckSum").val(),
                spotCheckRate: $("#spotCheckRate").val(),
                defectEmrSum: $("#defectEmrSum").val(),
                firstAGrade: $("#firstAGrade").val(),
                firstBGrade: $("#firstBGrade").val(),
                firstCGrade: $("#firstCGrade").val(),
                secondGrade: $("#secondGrade").val(),
                thirdGrade: $("#thirdGrade").val(),
                defectSummary: $("#defectSummary").val(),
                fullCreditErmSum: $("#fullCreditErmSum").val(),
                defectReason: $("#defectReason").val(),
                improvement: $("#improvement").val(),
                responsible: $("#responsible").val(),
                followUp: $("#followUp").val(),
                fuUser: $("#fuUser").val(),
                fuTime: $("#fuTime").val()
            };
            $.ajax({
                contentType: "application/x-www-form-urlencoded; charset=utf-8",
                url: "${ctx}/misEmrQcSummary.do?method=saveMisEmrQcSummary",
                data: MisEmrQcSummary,
                type: "post",
                success: function (data) {
                    if (data == "") {
                        alert("保存成功！");
                    } else {
                        alert("错误：" + data.err);
                    }
                },
                error: function (data, textStatus) {
                    alert(textStatus + "错误:" + data.responseText);
                }
            });
        });


        $("[data-control='bind']").each(function (index, element) {
            var i = $(element).attr('data-index');
            var text = $(element).find('span:eq(' + i + ')').text();
            var newText = '√ ' + text.substring(1);
            $(element).find('span:eq(' + i + ')').text(newText);
        });

    });


    function dataFinded(data) {
        custom_options($("#emrSum"), data.emrSum);
        custom_options($("#deathEmrSum"), data.deathEmrSum);
        custom_options($("#criticalEmrSum"), data.criticalEmrSum);
        custom_options($("#severeEmrSum"), data.severeEmrSum);
        custom_options($("#mediumErmSum"), data.mediumErmSum);
        custom_options($("#lightEmrSum"), data.lightEmrSum);
        custom_options($("#spotCheckSum"), data.spotCheckSum);
        custom_options($("#spotCheckRate"), data.spotCheckRate);
        custom_options($("#spontCheckPercent"), data.spontCheckPercent);
        custom_options($("#defectEmrSum"), data.defectEmrSum);
        custom_options($("#fullCreditErmSum"), data.fullCreditErmSum);
        custom_options($("#firstAGrade"), data.firstAGrade);
        custom_options($("#firstBGrade"), data.firstBGrade);
        custom_options($("#firstCGrade"), data.firstCGrade);
        custom_options($("#secondGrade"), data.secondGrade);
        custom_options($("#thirdGrade"), data.thirdGrade);
    }


    //如果这个单子不是本人填的
    function selfControl() {
        var createuserid = '${misEmrBasicinfo.createuserid}';
        if (createuserid != '${sysMemberInfo.id}' && createuserid != null && createuserid.length > 0) {
            $("#saveQc").hide();
        }
    }

</script>