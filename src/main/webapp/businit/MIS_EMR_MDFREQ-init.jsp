<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<script type="text/javascript">
    $(document).ready(function () {
        //初始化
        //init();
        //保存按钮
        $("#saveMdfReq").click(function () {
            if ($("#mdfReason").val() == null || $("#mdfReason").val() == "") {
                alert("请选择修改原因！");
                return;
            }
            //对象组装
            var MisEmrMdfreq = {
                id: $("#id").val(),//患者id
                emrId: $("#emrId").val(),//病历ID
                mdfRemark: $("#mdfRemark").val(),//申请备注
                mdfReason: $("#mdfReason").val(),//申请原因
                reqResult: 0
            };
            $.ajax({
                contentType: "application/x-www-form-urlencoded; charset=utf-8",
                url: "${ctx}/misEmrMdfreq.do?method=saveMisEmrMdfReq",
                data: MisEmrMdfreq,
                type: "post",
                success: function (data) {
                    if (data.err != null) {
                        alert(data.err);
                    }
                    alert("申请成功！");
                    var relationships_ID = window.parent.$("#layer_box").attr("relationships_ID");//获取当前页面容器
                    var pid = "mdf" + $("#emrId").val();//动作发起ID
                    var frame = top.$("#" + relationships_ID).contents().find("a#" + pid).hide(1000);//暂时隐藏发起的按钮
                    closed_layer('layer_box');//这个地方一定要关闭，不然的话，两端的页面保持开启一直点逻辑上有问题
                },
                error: function (data, textStatus) {
                    alert(textStatus + "错误:" + data.responseText);
                }
            });
        });


    });//JQUERY结束
</script>