<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<script type="text/javascript">
    //基础信息验证规则
    var vld_mdfReq =
            $("#mdfReq").validate({
                rules: {
                    recMember: {required: true},//审核人
                    mdfReason: {required: true}//申请原因
                }
            });
</script>
 