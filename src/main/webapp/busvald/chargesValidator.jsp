<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<script type="text/javascript">
    //基础信息验证规则
    var vld_charges =
            $("#vld_charges").validate({
                rules: {
                    <c:forEach var='list' items='${list}'>
                    charge${list.itemcode}: {number: true},
                    received${list.itemcode}: {number: true},
                    </c:forEach>
                    chargeTotal: {number: true},
                    receivedTotal: {number: true},
                    balanceTotal: {number: true},
                    remark: {maxlength: 120},
                    invoiceNo: {maxlength: 16}
                }
            });
</script>
 