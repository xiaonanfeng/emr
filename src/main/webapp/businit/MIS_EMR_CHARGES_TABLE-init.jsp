<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<script type="text/javascript">
    $(document).ready(function () {
        //值初始化
        init();
        selfControl();

        //自动计算差额
        $(".receives,.charges").blur(function () {
            initValues();
        });

        //保存按钮
        $("#saveCharges").click(function () {
            //校验
            if (vld_charges.form() == false) {
                return;
            }
            //重新计算
            initValues();
            //收费主表对象组装
            var MisEmrChargesTable = {
                id: $("#emrId").val(),
                chargeTotal: $("#chargeTotal").val(),
                receivedTotal: $("#receivedTotal").val(),
                balanceTotal: $("#balanceTotal").val(),
                reasoncode: $("#reasoncode").val(),
                remark: $("#remark").val(),
                collectorId: $("#collectorId").val(),
                invoiceNo: $("#invoiceNo").val(),
                remark: $("#remark").val(),
                chargeKind: $("#chargeKind").val()
            };

            //收费从表对象组装
            var misEmrChargesNote = []//声明提交对象
            //收费数组的长度
            <c:forEach var='list' items='${list}'>//循环push
            misEmrChargesNote.push({
                id: $("#emrId").val() + '${list.type}' + '${list.itemcode}',
                emrId: $("#emrId").val(),//病历Id
                chargeType: '${list.type}' * 1, //收费类型
                itemcode: '${list.itemcode}',//收费项目
                charge: $("#charge" + '${list.itemcode}').val() * 1,//应收
                received: $("#received" + '${list.itemcode}').val() * 1, //实收
                balance: $("#received" + '${list.itemcode}').val() * 1 - $("#charge" + '${list.itemcode}').val() * 1,//差额
                remark: $("#remark" + '${list.itemcode}').val()
            });
            </c:forEach>

            $.ajax({
                contentType: "application/x-www-form-urlencoded; charset=utf-8",
                url: "${ctx}/vMisEmrChargeitemsCode.do?method=saveMisEmrChargesTable&misEmrChargesNoteJson=" + JSON.stringify(misEmrChargesNote),
                data: MisEmrChargesTable,
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
        });;

    });//JQUERY结束


    /**
     *初始化赋值
     **/
    function init() {
        var coller = '${misEmrChargesTable.collectorId }';
        if (coller == "" || coller == null) {
            coller = '${coller}';
        }
        custom_options($("#collectorId"), coller);//收费人
        custom_options($("#reasoncode"), '${misEmrChargesTable.reasoncode }');
        custom_options($("#chargeKind"), '${misEmrChargesTable.chargeKind }');
        <c:forEach var='misEmrChargesNoteList' items='${misEmrChargesNoteList}'>//循环赋值
        custom_options($("#charge" +${misEmrChargesNoteList.itemcode}), '${misEmrChargesNoteList.charge }');
        custom_options($("#received" +${misEmrChargesNoteList.itemcode}), '${misEmrChargesNoteList.received }');
        custom_options($("#remark" +${misEmrChargesNoteList.itemcode}), '${misEmrChargesNoteList.remark }');
        </c:forEach>

    }

    /**
     *计算差额
     **/
    function initValues() {
        //应收
        var temp1 = 0;
        $(".charges").each(function () {
            //我也不知道为啥验证不到这里
            if (isNaN($(this).val())) {//如果不是数字
                $(this).val('');
            }
            temp1 = temp1 + $(this).val() * 1;
        });
        $("#chargeTotal").val(temp1);//应收总额
        //实收
        var temp2 = 0;
        $(".receives").each(function () {
            if (isNaN($(this).val())) {
                $(this).val('');
            } else {
                //如果同类标准为空，而且应收为空
                //则把实收作为应收标准进行计算
                var flag = $(this).attr("flag");
                if (($("#standards" + flag).val() == "" && $("#charge" + flag).val() == "") || ($("#standards" + flag).val() == null && $("#charge" + flag).val() == null)) {
                    //if($("#standards"+flag).val()==""||$("#standards"+flag).val()==null){
                    $("#charge" + flag).val($(this).val());
                }
            }
            temp2 = temp2 + $(this).val() * 1;
        });


        $("#receivedTotal").val(temp2);//实收总额
        $("#balanceTotal").val(temp2 - temp1);//总差额
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


    //如果这个单子不是本人填的
    //包括中心审核人员
    //就隐藏保存、提交、附件
    function selfControl() {
        var createuserid = '${misEmrBasicinfo.createuserid}';
        if (createuserid != '${sysMemberInfo.id}' && createuserid != null && createuserid.length > 0) {
            $("#saveCharges").hide();
        }
    }


</script>