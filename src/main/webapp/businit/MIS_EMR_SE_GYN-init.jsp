<%@ page language="java" import="java.util.*" pageEncoding="utf-8" %>
<script type="text/javascript">
    $(document).ready(function () {

        $("#saveSeGyn").click(function () {
            //校验
            //if(vld_seGyn.form()==false){return ;};

            var MisEmrSeGyn = {
                id: $("#id").val(),
                martialStatus: $("#martialStatus").val(),
                marAge: $("#marAge").val(),
                pregnancy: $("#pregnancy").val(),
                childbirth: $("#childbirth").val(),
                sexLife: $("#sexLife").val(),
                aom: $("#aom").val(),
                period: $("#period").val(),
                cycle: $("#cycle").val(),
                lmp: $("#lmp").val(),
            };

            $.ajax({
                contentType: "application/x-www-form-urlencoded; charset=utf-8",
                url: "${ctx}/misEmrSeGyn.do?method=saveMisEmrSeGyn",
                data: MisEmrSeGyn,
                type: "post",
                success: function (data) {
                    if (data.err != null) {
                        $("#callGyn").find("i").text(data.err);
                        $("#callGyn").removeClass().addClass("A_red");
                    } else {
                        $("#callGyn").find("i").text("保存成功！");
                        $("#callGyn").removeClass().find("i").width("0px");
                        $("#callGyn").addClass("A_green");
                    }
                },
                error: function (data, textStatus) {
                    $("#callGyn").find("i").text(textStatus.status + textStatus.statusText);
                    $("#callGyn").removeClass().addClass("A_red");
                    alert(textStatus + "错误:" + data.responseText);
                }
            });
        });

    });
</script>