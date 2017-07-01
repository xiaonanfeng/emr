<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<script type="text/javascript">
    $(document).ready(function () {
        //审批按钮
        $("#saveMdfReqRec").click(function () {
            //对象组装
            var MisEmrMdfreq = {
                id: $("#id").val(),//患者id
                emrId: $("#emrId").val(),//患者id
                reqResult: $("#reqResult").val(),//审批状态
                recRemark: $("#recRemark").val(),//审批备注
                comtagain: $("#comtagain").val()//再次提交时间
            };
            $.ajax({
                contentType: "application/x-www-form-urlencoded; charset=utf-8",
                url: "${ctx}/misEmrMdfreq.do?method=saveMisEmrMdfPrev",
                data: MisEmrMdfreq,
                type: "post",
                success: function (data) {
                    alert("保存成功！");
                    var relationships_ID = window.parent.$("#layer_box").attr("relationships_ID");//获取当前页面容器
                    var frame = top.$("#" + relationships_ID).contents().find("#find").click();//再次点击查询
                    closed_layer('layer_box');//这个地方一定要关闭，不然的话，两端的页面保持开启一直点逻辑上有问题
                },
                error: function (data, textStatus) {
                    alert(textStatus + "错误:" + data.responseText);
                }
            });
        });

    });//JQUERY结束
</script>