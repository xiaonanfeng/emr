<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<script type="text/javascript">
    $(document).ready(function () {


        $("#uploader").show();//如果选的是已查，就显示上传组件

        //显示附件
        $("#showPics").click(function () {
            $("#pics").show(2000);
        });
        //0  已查

        //保存对象
        $("#saveAe").click(function () {
            if (vld_Ae.form() == false) {
                return;
            }
            ;
            var MisEmrAe = {
                id: $("#id").val(),
                rbg: $("#rbg").val(),
                rbgTest: $("#rbgTest").val(),
                bosTest: $("#bosTest").val(),
                bos: $("#bos").val(),
                ecg: $("#ecg").val(),
                ecgMonitor: $("#ecgMonitor").val(),
                ecgTime: $("#ecgTime").val(),
                ecgDiag: $("#ecgDiag").val(),
                ecgTo: $("#ecgTo").val(),
                aeOther: $("#aeOther").val(),
                ohters: $("#ohters").val(),
                ecgOther: $("#ecgOther").val(),
                ecgLead: $("#ecgLead").val()
            };
            $.ajax({
                contentType: "application/x-www-form-urlencoded; charset=utf-8",
                url: "${ctx}/misEmrAe.do?method=saveMisEmrAe",
                data: MisEmrAe,
                type: "post",
                success: function (data) {
                    if (data.err != null) {
                        $("#callAe").find("i").text(data.err);
                        $("#callAe").removeClass().addClass("A_red");
                    } else {
                        $("#callAe").find("i").text("保存成功！");
                        $("#callAe").removeClass().find("i").width("0px");
                        $("#callAe").addClass("A_green");
                    }
                },
                error: function (data, textStatus) {
                    $("#callAe").find("i").text(textStatus.status + textStatus.statusText);
                    $("#callAe").removeClass().addClass("A_red");

                    alert(textStatus + "错误:" + unescape(data.responseText.replace(/\u/g, "%u")));
                }
            });
        });
    });
    //如果有心电图显示上传组件

    function showUpload(obj) {
        /**var value = obj.value;
         if(value==0&&value!=""&&value.length!=0){
			$("#uploader").show(1000);
		}else{
			$("#ecgTime").val('');//干掉心电图时间
			$("#ecgTo").val('');//心电图交与人
			$("#ecgDiagText").val('');//心电图印象汉字
			$("#ecgDiag").val('');//心电图印象代码
			$("#uploader").hide(1000);//隐藏上传组件
		}    **/
    }

</script>
				