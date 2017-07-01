<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<script type="text/javascript">
    $(document).ready(function () {

        selfControl();

        //处理年龄
        var scope = parseTimeToAge('${misEmrBasicinfo.age}');//年龄计算。先算出是哪个范围
        if ('${misEmrBasicinfo.age}' != 0) {
            //基础信息
            custom_options($("#timeScope"), scope);
            custom_options($("#age"), ('${misEmrBasicinfo.age}' / scope));//然后相除并四舍五入
        } else if ('${misEmrBasicinfo.age}' == 0 && '${stage}' != "") {
            custom_options($("#age"), '${stage}');
        } else {
            custom_options($("#age"), '未知');
        }

        custom_options($("#item1"), '${misEmrNotice.item1}');
        custom_options($("#item2"), '${misEmrNotice.item2}');
        custom_options($("#item3"), '${misEmrNotice.item3}');

        var t = '${misEmrNotice.notice}';
        var arr = t.split(",");
        for (i = 0; i < arr.length; i++) {
            $("#noticeBox" + arr[i]).attr("checked", true);
        }

        //保存按钮
        $("#saveNotice").click(function () {
            //校验
            //if(vld_Notice.form()==false){return ;};
            //对象组装
            var temp = "";
            $('input:checkbox[name=noticeBox]:checked').each(function (i) {
                if (0 == i) {
                    temp = $(this).val();
                } else {
                    temp += ("," + $(this).val());
                }
            });
            //alert(temp);
            //return;
            var MisEmrNotice = {
                id: $("#id").val(),
                notice: temp,
                rlt: $("#rlt").val(),
                atte: $("#atte").val(),
                spker: $("#spker").val(),
                noticetime: $("#noticeTime").val(),
                arvtime: $("#arvTime").val(),
                item1: $("#item1").val(),
                item2: $("#item2").val(),
                item3: $("#item3").val()
            };
            //console.log(MisEmrNotice);
            $.ajax({
                contentType: "application/x-www-form-urlencoded; charset=utf-8",
                url: "${ctx}/misEmrNotice.do?method=saveMisEmrNotice",
                data: MisEmrNotice,
                type: "post",
                success: function (data) {
                    if (data == "") {
                        alert("保存成功！");
                    }
                },
                error: function (data, textStatus) {
                    $("#callBase").find("i").text(textStatus.status + textStatus.statusText);
                    $("#callBase").removeClass().addClass("A_red");
                    alert(textStatus + "错误:" + data.responseText);
                }
            });
        });

        $("#printNotice").click(function () {
            var id = $("#id").val();
            window.open("${ctx}/misEmrNotice.do?method=findMisEmrNoticeItemAndContext&print=1&id=" + id, "院前急救病情告知书");
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
            $("#saveNotice").hide();
        }
    }


</script>