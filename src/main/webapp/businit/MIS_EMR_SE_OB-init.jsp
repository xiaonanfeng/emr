<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<script type="text/javascript">
    $(document).ready(function () {


        $("#saveSeOb").click(function () {
            //校验
            if (vld_seOb.form() == false) {
                return;
            }
            ;

            var MisEmrSeOB = {
                id: $("#id").val(),
                fetalHeart: $("#fetalHeart").val(),
                uterContrac: $("#uterContrac").val(),
                caul: $("#caul").val(),
                amnioticFluid: $("#amnioticFluid").val(),
                bloodSee: $("#bloodSee").val(),
                cervix: $("#cervix").val(),
                present: $("#present").val(),
                obother: $("#obother").val(),
            };
            $.ajax({
                contentType: "application/x-www-form-urlencoded; charset=utf-8",
                url: "${ctx}/misEmrSeOb.do?method=saveMisEmrSeOb",
                data: MisEmrSeOB,
                type: "post",
                success: function (data) {
                    if (data.err != null) {
                        $("#callOb").find("i").text(data.err);
                        $("#callOb").removeClass().addClass("A_red");
                    } else {
                        $("#callOb").find("i").text("保存成功！");
                        $("#callOb").removeClass().find("i").width("0px");
                        $("#callOb").addClass("A_green");
                    }
                },
                error: function (data, textStatus) {
                    $("#callOb").find("i").text(textStatus.status + textStatus.statusText);
                    $("#callOb").removeClass().addClass("A_red");
                    alert(textStatus + "错误:" + data.responseText);
                }
            });
        });
    });
</script>