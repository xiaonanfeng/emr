<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<script type="text/javascript">
    //基础信息验证规则
    var vld_handOver = $("#vld_handOver_form").validate({
        rules: {
            hoP: {number: true,},
            hoR: {number: true,},
            hoBpL: {number: true,},
            hoBpH: {number: true,}
        }
    });
</script>
 