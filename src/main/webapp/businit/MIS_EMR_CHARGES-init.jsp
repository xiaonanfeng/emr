<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<script type="text/javascript">
    $(document).ready(function () {
        //值初始化
        init();

        //收费类别
        $("#type").change(function () {//呼出二级菜单
            var code = $(this).val();
            callSencond(code, 0);
        });


        //自动计算差额
        $("#received").blur(function () {
            var l_v;
            if ($("charge").val != "") {
                l_v = $("#received").val() - $("#charge").val();
            }
            $("#balance").val(l_v);
        });

        //修改赋值
        $(".search").click(function () {
            var l_v = 0;
            var chargesId = $(this).attr("chargesId");
            $.ajax({
                contentType: "application/x-www-form-urlencoded; charset=utf-8",
                url: "${ctx}/misEmrCharges.do?method=findMisEmrChargesById",
                data: "&id=" + chargesId,
                type: "post",
                success: function (data) {
                    custom_options($("#id"), data.id);
                    custom_options($("#type"), data.type);
                    $("#type").change();
                    custom_options($("#standards"), data.standards);
                    custom_options($("#charge"), data.charge);
                    custom_options($("#received"), data.received);
                    custom_options($("#remark"), data.remark);
                    custom_options($("#reasoncode"), data.reasoncode);
                    custom_options($("#balance"), data.balance);
                    custom_options($("#invoiceNo"), data.invoiceNo);
                    custom_options($("#collectorId"), data.collectorId);
                    callSencond(data.type, data.itemcode);
                }
            });

        });

        //保存按钮
        $("#saveCharges").click(function () {
            //校验
            if (vld_charges.form() == false) {
                return;
            }
            ;
            //对象组装
            var MisEmrCharges = {
                id: $("#id").val(),
                emrId: $("#emrId").val(),
                type: $("#type").val(),
                itemcode: $("#itemcode").val(),
                charge: $("#charge").val(),
                received: $("#received").val(),
                remark: $("#remark").val(),
                reasoncode: $("#reasoncode").val(),
                balance: $("#balance").val(),
                invoiceNo: $("#invoiceNo").val(),
                collectorId: $("#collectorId").val()
            };
            $.ajax({
                contentType: "application/x-www-form-urlencoded; charset=utf-8",
                url: "${ctx}/misEmrCharges.do?method=saveMisEmrCharges",
                data: MisEmrCharges,
                type: "post",
                success: function (data) {
                    if (data == "") {
                        alert("保存成功！");
                        window.location.href = window.location.href;//刷新页面
                    } else {
                        alert("错误：" + data.err);
                    }
                },
                error: function (data, textStatus) {
                    alert(textStatus + "错误:" + data.responseText);
                }
            });
        });

    });//JQUERY结束


    /**
     $("#printCharges").click(function (){
			var id = $("#id").val();
			window.open("${ctx}/misEmrCharges.do?method=findMisEmrChargesById&print=1&id="+id, "收费记录");
		});
     **/


    /**
     *初始化赋值
     **/
    function init() {
        custom_options($("#collectorId"), '${exitMan}');
    }

    /**
     *自动赋值
     **/
    function autoCmp(obj) {
        //$("#itemname").empty().append($(obj).find("option:selected").text());//
        $("#standards").empty().append($(obj).find("option:selected").attr("pvalue"));//为
        $("#charge").val($(obj).find("option:selected").attr("pvalue"));
    }

    /**
     *删除
     **/
    function del(chargesId) {
        if (confirm("确定删除？") == false) {
            return;
        }
        $.ajax({
            contentType: "application/x-www-form-urlencoded; charset=utf-8",
            url: "${ctx}/misEmrCharges.do?method=delMisEmrChargesById",
            data: "&id=" + chargesId,
            type: "post",
            success: function (data) {
                if (data == "") {
                    alert("删除成功！");
                    window.location.href = window.location.href;//刷新页面
                } else {
                    alert("错误：" + data.err);
                }
            }
        });
    }


    function callSencond(code, defValue) {
        if (code != "") {
            //呼出第二级
            $.ajax({
                contentType: "application/x-www-form-urlencoded; charset=utf-8",
                url: "${ctx}/misEmrCharges.do?method=findMisEmrChargesItems",
                data: "&code=" + code,
                type: "post",
                success: function (data) {
                    $("#itemCodeTD").empty();
                    $("#itemCodeTD").append(data);
                    $("#itemcode").bind("change", function () {
                        autoCmp($(this))
                    });
                    //createSelect($("#itemcode"));//新select创建访法
                    custom_options($("#itemcode"), defValue);//默认赋值
                    $("#standards").empty().append($("#itemcode").find("option:selected").attr("pvalue"));//为
                }
            });
        }
    }

    /**
     *第二级赋值

     function initItemCode(varStr){
		$.ajax({
			contentType: "application/x-www-form-urlencoded; charset=utf-8",
			url : "${ctx}/misEmrCharges.do?method=delMisEmrChargesById",
			data:"&id="+chargesId,
			type : "post",
			success : function(data) {
				if(data==""){
					alert("删除成功！");
					window.location.href = window.location.href;//刷新页面
				}else{
					alert("错误："+data.err);	
				}
			}
		});
	}
     **/

</script>