<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<script type="text/javascript">
    //删除药物
    function del(id) {
        if (confirm("确定删除给药记录么？") == false) {
            return;
        }
        $.ajax({
            contentType: "application/x-www-form-urlencoded; charset=utf-8",
            url: "${ctx}/misEmrMar.do?method=delMisEmrMarById",
            data: "id=" + id,
            type: "post",
            success: function (data) {
                $("tr[id=" + id + "tr]").remove();
            },
            error: function () {
                alert("删除失败！");
            }
        });
    }

    //删除耗材
    function delAar(id) {
        if (confirm("确定删除耗材使用记录么？") == false) {
            return;
        }
        $.ajax({
            contentType: "application/x-www-form-urlencoded; charset=utf-8",
            url: "${ctx}/misEmrAar.do?method=delMisEmrAarById",
            data: "id=" + id,
            type: "post",
            success: function (data) {
                $("tr[id=" + id + "tr]").remove();
            },
            error: function () {
                alert("删除失败！");
            }
        });
    }


    $(document).ready(function () {

        //呼出药物应用
        $("#addDrug").click(function () {
            var emrId = $("#id").val();
            open_layer("选择药物应用", "${ctx}/misEmrMar.do?method=findMisEmrMarForInput&flag=sceneDrug&emrId=" + emrId);
        });

        //呼出耗材使用
        $("#addAar").click(function () {
            var emrId = $("#id").val();
            open_layer("选择耗材应用", "${ctx}/misEmrAar.do?method=findmisAmEmArticles&emrId=" + emrId);
        });


        //复制病情选择项到描述框
        $("#primDiagR").focus(function () {
            if ($(this).val() == null || $(this).val() == "") {
                var str = $("#primDiagText").val();
                str = str.replace(/,/g, "      ");
                $(this).val($(this).val() + str);
            }
        });
        
        
        $("#reason67").change(function () {
            if ($(this).val() == null || $(this).val() == "") {
                $("#preaidSucceed67").val(1);
            }else{
                $("#preaidSucceed67").val(2);
            }
        });

        $("#reason58").change(function () {
            if ($(this).val() == null || $(this).val() == "") {
                $("#preaidSucceed58").val(1);
            }else{
                $("#preaidSucceed58").val(2);
            }
        });


        

        //保存对象
        $("#saveVs").click(function () {
            if (vld_preaidVs.form() == false) {
                return;
            }
            //封装施救措施对象
            var misEmrPreaidVs = {
                id: $("#id").val(),
                primDiag: $("#primDiag").val(),
                primDiagR: $("#primDiagR").val(),
                doctorSign: $("#doctorSign").val(),
                nurseSign: $("#nurseSign").val(),
                signDate: $("#signDate").val(),
                sceneTreat: $("#sceneTreat").val(),
                sceneRecord: $("#sceneRecord").val(),
                senRcdOther: $("#senRcdOther").val(),
                drugOther: $("#drugOther").val(),
                aarOther: $("#aarOther").val()
            };
            var misEmrPreaidStat = new Array()//声明救治成功率对象
            var obj_58 = {
                emrId: $("#id").val(),
                preaidCode: 58,
                preaidSucceed : $("#preaidSucceed58").val(),
                reason:$("#reason58").val()
            };//静脉输液
            var obj_66 = {
                emrId: $("#id").val(),
                preaidCode: 66,
                patientStat: $("#patientStat").val(),
                preaidSucceed : $("#preaidSucceed66").val(),
                reason:$("#reason66").val()
            };//CPR
            var obj_67 = {
                emrId: $("#id").val(),
                preaidCode: 67,
                preaidSucceed : $("#preaidSucceed67").val(),
                reason:$("#reason67").val()
            };//气管插管
            misEmrPreaidStat.push(obj_58, obj_66, obj_67);
            $.ajax({
                contentType: "application/x-www-form-urlencoded; charset=utf-8",
                url: "${ctx}/misEmrPreaidVs.do?method=saveMisEmrPreaidVs&stat="+JSON.stringify(misEmrPreaidStat),
                data: misEmrPreaidVs,
                type: "post",
                success: function (data) {
                    if (data.err != null) {
                        $("#callVs").find("i").text(data.err);
                        $("#callVs").removeClass().addClass("A_red");
                    } else {
                        $("#callVs").find("i").text("保存成功！");
                        $("#callVs").removeClass().find("i").width("0px");
                        $("#callVs").addClass("A_green");
                    }
                },
                error: function (data, textStatus) {
                    $("#callVs").find("i").text(textStatus.status + textStatus.statusText);
                    $("#callVs").removeClass().addClass("A_red");
                    alert(textStatus + "错误:" + data.responseText);
                }
            });
        });


    });

</script>
				