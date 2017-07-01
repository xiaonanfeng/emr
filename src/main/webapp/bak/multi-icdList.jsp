<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<script src="${ctx}/js/jquery-2.1.1.min.js"></script>
<link href="${ctx}/js/chose/css/ui-choose.css" rel="stylesheet" type="text/css">
<script src="${ctx}/js/chose/ui-choose.js"></script>
<center>
    ${select}
</center>
<script>
    var inputId = '${param.flag}';
    //实例化select
    var mutSelect = $('#select').ui_choose();
    //初始化赋值！
    mutSelect._val_select([${param.values}]);
    //change方法
    mutSelect.change = function (value, item) {
        layer_to_page(value, inputId);
        $.ajax({
            contentType: "application/x-www-form-urlencoded; charset=utf-8",
            url: "${ctx}/misEmrPreaidVs.do?method=findPrimDiagText&str=" + value,
            type: "get",
            success: function (data) {
                layer_to_page(data, inputId + "Text");
            }
        });
    };

    function layer_to_page(layerValue, tarId) {
        var emt = '${loginPath}';
        var obj = "";
        if (emt == 'web') {//web
            var relationships_ID = window.parent.$("#layer_box").attr("relationships_ID");
            obj = top.$("#" + relationships_ID).contents().find("#" + tarId);
            obj.val(layerValue);//给input赋值
        } else {
            $(window.parent.document).find("#" + tarId).val(layerValue);
        }
    }


</script>		
