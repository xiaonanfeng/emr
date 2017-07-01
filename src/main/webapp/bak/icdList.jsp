<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@ include file="/taglibs.jsp" %>
<!DOCTYPE>
<script type="text/javascript">
    $(document).ready(function () {
        //声明keyvalue对象数组
        var icdKeyAndValue = [];
        //封装对象方法
        $(".icdValueTr").click(function () {
            var id = $(this).attr("id");//id;
            var name = $(this).attr("name");
            var obj = {"id": id, "name": name};//对象封存
            icdKeyAndValue.push(obj);
            icdKeyAndValue = $.grep(icdKeyAndValue, function (obj, l_id) {
                alert(obj.id + obj.name);
            });
            //console.log(icdKeyAndValue);
            //icdKeyAndValue.splice($.inArray(obj,icdKeyAndValue),1);
            //console.log(icdKeyAndValue);
        });
        /**
         * 从对象数组中删除属性为objPropery，值为objValue元素的对象
         * @param Array arrPerson  数组对象
         * @param String objPropery  对象的属性
         * @param String objPropery  对象的值
         * @return Array 过滤后数组
         function remove(arrPerson,objPropery,objValue){
   		return $.grep(arrPerson, function(cur,i){
          return cur[objPropery]!=objValue;
      	});
	}
         */
        //window.parent.parent.document.getElementById("primDiagText").value = 123;//父类的父类的窗口
    });


</script>
<table width="100%" border="0" cellpadding="0" cellspacing="0"
       class="table_list">
    <tbody>
    <c:forEach var="list" items="${list}">
        <tr class="icdValueTr" id="${list.id}" name="${list.diseaseName}">
            <td width="40%">${list.diseaseName}</td>
            <td width="30%">${list.diseaseCode}</td>
            <td width="30%">${list.inputCode1}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<div class="search_div" align="center">
    ${nva}
</div>