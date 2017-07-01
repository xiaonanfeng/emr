<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<script type="text/javascript">
    $(document).ready(function () {

        selfControl();

        //处理年龄
        var scope = parseTimeToAge('${misEmrBasicinfo.age}');//年龄计算。先算出是哪个范围
        if ('${misEmrBasicinfo.age}' != 0) {
            custom_options($("#timeScope"), scope);
            custom_options($("#age"), ('${misEmrBasicinfo.age}' / scope));//然后相除并四舍五入
        } else if ('${misEmrBasicinfo.age}' == 0 && '${stage}' != "") {
            custom_options($("#age"), '${stage}');
        } else {
            custom_options($("#age"), '未知');
        }
        custom_options($("#hoConscious"), '${misEmrHandover.hoConscious}');
        custom_options($("#hoDiag"), '${misEmrHandover.hoDiag}');
        custom_options($("#hoTreat"), '${misEmrHandover.hoTreat}');

        var intiValue;

        //VS病情诊断
        intiValue = document.getElementById("hoDiag").value;
        $.ajax({
            contentType: "application/x-www-form-urlencoded; charset=utf-8",
            url: "${ctx}/misEmrHandover.do?method=findPrimDiagText&str=" + intiValue,
            type: "get",
            success: function (data) {
                $("#hoDiagText").val(data);
            }
        });

        //VS现场施救措施
        intiValue = document.getElementById("hoTreat").value;
        $.ajax({
            contentType: "application/x-www-form-urlencoded; charset=utf-8",
            url: "${ctx}/misEmrPreaidVs.do?method=findMisEmrPreaidVsSceneTreatText&str=" + intiValue,
            type: "get",
            success: function (data) {
                $("#hoTreatText").val(data);//VS
            }
        });


        //保存按钮
        $("#saveHandover").click(function () {
            //校验
            if (vld_handOver.form() == false) {
                return;
            }
            ;
            //对象组装
            var MisEmrHandover = {
                id: $("#id").val(),
                hoTime: $("#hoTime").val(),
                hoMainreason: $("#hoMainreason").val(),
                hoP: $("#hoP").val(),
                hoR: $("#hoR").val(),
                hoBpL: $("#hoBpL").val(),
                hoBpH: $("#hoBpH").val(),
                hoConscious: $("#hoConscious").val(),
                hoDiag: $("#hoDiag").val(),
                hoTreat: $("#hoTreat").val(),
                hoDoctor: $("#hoDoctor").val(),
                hoTreatOther: $("#hoTreatOther").val(),//其他处理
                diagOther: $("#diagOther").val(),//其他诊断
                statOther: $("#statOther").val()//其他体征
            };
            $.ajax({
                contentType: "application/x-www-form-urlencoded; charset=utf-8",
                url: "${ctx}/misEmrHandover.do?method=saveMisEmrHandover",
                data: MisEmrHandover,
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

        $("#printHandover").click(function () {
            var id = $("#id").val();
            window.open("${ctx}/misEmrHandover.do?method=findMisEmrHandoverById&print=1&id=" + id, "院前交接记录");
        });

    });


    //年龄转化
    function parseTimeToAge(ageValue) {
        var flag = null;
        var min = 1;
        var hour = 60;
        var day = 1440;
        var month = 43200;
        var year = 518400;
        if (ageValue / year % 1 === 0) {
            return year;
        } else if (ageValue / month % 1 === 0) {
            return month;
        } else if (ageValue / day % 1 === 0) {
            return day;
        } else if (ageValue / hour % 1 === 0) {
            return hour;
        }
        else {
            return min;
        }
        return flag;
    }

    //如果这个单子不是本人填的
    //包括中心审核人员
    //就隐藏保存、提交、附件
    function selfControl() {
        var createuserid = '${misEmrBasicinfo.createuserid}';
        console.log(createuserid);
        if (createuserid != '${sysMemberInfo.id}' && createuserid != null && createuserid.length > 0) {
            $("#saveHandover").hide();
        }
    }

</script>