<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<script type="text/javascript">

    $(document).ready(function () {
        //初始化
        init();
        selfControl();
        if ('${misEmrNursingRecord.age}' != null && '${misEmrNursingRecord.age}' != 0) {
            ageControl('${misEmrNursingRecord.age}');
        } else {
            ageControl('${misEmrBasicinfo.age}');
        }
        //保存按钮
        $("#save").click(function () {
            //校验
            if (vld_nursing.form() == false) {
                return;
            }
            ;
            //护理措施
            var nursingCare = new Array();
            $('input[name="nursingCare"]:checked').each(function () {
                nursingCare.push($(this).val());
            });
            //对象组装
            var MisEmrNursingRecord = {
                id: $("#id").val(),
                //name:$("#name").val(),
                //gendle:$("#gendle").val(),
                //age:$("#age").val()*$("#timeScope").val(),
                //treatAddr:$("#treatAddr").val(),
                //treatTime:$("#treatTime").val(),
                eco2: $("#eco2").val(),
                mentalstate: $("input[name='mentalstate']:checked").val(),
                posture: $("input[name='posture']:checked").val(),
                cyanosis: $("input[name='cyanosis']:checked").val(),
                skin: $("input[name='skin']:checked").val(),
                //changeRecord:$("#changeRecord").val(),
                nursingCare: nursingCare.toString(),
                postT: $("#postT").val(),
                postP: $("#postP").val(),
                postR: $("#postR").val(),
                postBpl: $("#postBpl").val(),
                postBph: $("#postBph").val(),
                postSpo2: $("#postSpo2").val(),
                postEco2: $("#postEco2").val(),
                outcome: $("input[name='outcome']:checked").val(),
                remark: $("#remark").val(),
                hsid: $("#hsid").val()
            };
            console.log(MisEmrNursingRecord);
            $.ajax({
                contentType: "application/x-www-form-urlencoded; charset=utf-8",
                url: "${ctx}/misEmrNursingRecord.do?method=saveMisEmrNursingRecord",
                data: MisEmrNursingRecord,
                type: "post",
                success: function (data) {
                    alert("保存成功！");
                },
                error: function (data, textStatus) {
                    alert(textStatus + "错误:" + data.responseText);
                }
            });
        });

        //打印
        $("#print").click(function () {
            var id = $("#id").val();
            window.open("${ctx}/misEmrNursingRecord.do?method=findMisEmrNursingRecordById&print=1&emrId=" + id, "院前护理记录");
        });

    });

    /**
     *初始化
     **/
    function init() {
        //custom_options($("#treatAddr"),'${misEmrNursingRecord.treatAddr}');
        //custom_options($("#treatTime"),'<fmt:formatDate value="${misEmrNursingRecord.treatTime}" pattern="yyyy-MM-dd HH:mm:ss" type="date" dateStyle="long" />');
        custom_options($("#eco2"), '${misEmrNursingRecord.eco2}');
        //custom_options($("#changeRecord"),'${misEmrNursingRecord.changeRecord}');
        custom_options($("#postT"), '${misEmrNursingRecord.postT}');
        custom_options($("#postP"), '${misEmrNursingRecord.postP}');
        custom_options($("#postR"), '${misEmrNursingRecord.postR}');
        custom_options($("#postBpl"), '${misEmrNursingRecord.postBpl}');
        custom_options($("#postBph"), '${misEmrNursingRecord.postBph}');
        custom_options($("#postSpo2"), '${misEmrNursingRecord.postSpo2}');
        custom_options($("#postEco2"), '${misEmrNursingRecord.postEco2}');
        custom_options($("#remark"), '${misEmrNursingRecord.remark}');
        custom_options($("#hsid"), '${misEmrNursingRecord.hsid}');

        $("input[name='mentalstate'][value='${misEmrNursingRecord.mentalstate}']").attr("checked", "checked");
        $("input[name='posture'][value='${misEmrNursingRecord.posture}']").attr("checked", "checked");
        $("input[name='cyanosis'][value='${misEmrNursingRecord.cyanosis}']").attr("checked", "checked");
        $("input[name='skin'][value='${misEmrNursingRecord.skin}']").attr("checked", "checked");
        $("input[name='outcome'][value='${misEmrNursingRecord.outcome}']").attr("checked", "checked");
        $("input[name='mentalstate'][value='${misEmrNursingRecord.mentalstate}]").attr("checked", "checked");

        //$("#"+${misEmrNursingRecord.outcome}+"outcome").attr("checked","checked");
        ///console.log('${misEmrNursingRecord.nursingCare}');
        var tempArray = new Array(${misEmrNursingRecord.nursingCare});
        //console.log(tempArray);
        for (var i = 0; i < tempArray.length; i++) {
            $("input[name='nursingCare'][value=" + tempArray[i] + "]").attr("checked", "checked");
        }
    }


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
        var createuserid = '${misEmrNursingRecord.createuserid}';
        if (createuserid != '${sysMemberInfo.id}' && createuserid != null && createuserid.length > 0) {
            $("#save").hide();
        }
    }

    //年龄控制
    function ageControl(l_ageValue) {
        var scope = parseTimeToAge(l_ageValue);//年龄计算。先算出是哪个范围
        if (l_ageValue != 0) {
            //基础信息
            custom_options($("#timeScope"), scope);
            //TODO 这里做年龄判断
            custom_options($("#age"), (l_ageValue / scope));//然后相除并四舍五入
        } else if ('${misEmrBasicinfo.age}' == 0 && '${stage}' != "") {
            custom_options($("#age"), '${stage}');
        } else {
            custom_options($("#age"), '未知');
        }
    }

</script>




