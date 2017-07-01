<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<script type="text/javascript">

    //基础信息验证规则
    var vld_nursing =
            $("#vld_nursing").validate({
                rules: {
                    tempreture: {number: true, max: 43, min: 35},
                    paulse: {number: true},
                    rate: {number: true},
                    bpL: {number: true},
                    bpH: {number: true},
                    spo2: {number: true},
                    eco2: {number: true},
                    postT: {number: true, max: 43, min: 35},
                    postP: {number: true},
                    postR: {number: true},
                    postBpl: {number: true},
                    postBph: {number: true},
                    postSpo2: {number: true},
                    postEco2: {number: true}
                }
            });


</script>
 