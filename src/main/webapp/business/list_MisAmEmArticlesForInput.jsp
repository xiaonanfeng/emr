<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@ include file="/taglibs.jsp" %>
<%
    String emrId = request.getParameter("emrId");
%>
<html>
<link rel="stylesheet" type="text/css" href="${ctx}/js/quicksearch/css/style.css"/>
<script type="text/javascript">
    var emrId = '<%=emrId%>';//病历ID
    var maxGrp = '${maxGrp}' * 1;//当前存在最大的耗材材
    var groupArr = [];//用耗材分组的临时校验变量
    for (var k = 1; k <= maxGrp; k++) {
        groupArr.push(k);//初始化校验用的数组，可以让批次从当前最大数+1
    }
    $(document).ready(function () {

        //quickSearch
        $("input#mc").quicksearch("table tbody tr");

        //选中按钮
        $(".chosen").click(function () {
            sortDth($(this));
            var groupId = 0;
            if (maxGrp == 0) {
                groupId = $(".chosen:checked").length
            } else {
                groupId = maxGrp + 1;
            }
            //批次初始值
            aarPackage($(this), groupId);
        });


        //批次填写
        $(".grp").keyup(function () {
            var l_value = $(this).val();
            if (isNaN(l_value)) {//如果是数字&&在取整数在用耗材数组序列
                $(this).val('');//制空先
            } else {//如果不是

            }
        });

        //最后对象封装条件
        $("#saveVsMeds").click(function () {
            var misEmAar = new Array()//声明提交对象
            var exitAar = $(".chosen:checked");
            for (var i = 0; i < exitAar.length; i++) {//循环push
                var exitAarId = exitAar[i].id;
                if (exitAarId != null && exitAarId != "") {//如果耗材物ID不是空
                    misEmAar.push({
                        artcId: exitAarId * 1, //Long medId;//被选中的耗材物ID
                        grp: $("#" + exitAarId + "grp").val() * 1,//批次转换为数字
                        amount: $("#" + exitAarId + "amount").val() * 1,//用量
                        useTime: $("#" + exitAarId + "useTime").val()//使用时间
                    });
                }
            }
            //console.log(misEmAar);
            if (misEmAar.length != 0) {
                $.ajax({//提交方法
                    contentType: "application/x-www-form-urlencoded; charset=utf-8",
                    url: "${ctx}/misEmrAar.do?method=saveMisAmEmAar&emrId=" + emrId + "&jsonStr=" + JSON.stringify(misEmAar),
                    type: "post",
                    success: function (data) {
                        if (data.err != null) {
                            alert(data.err);
                        } else {
                            alert("保存成功！");
                            var relationships_ID = window.parent.$("#layer_box").attr("relationships_ID");//获取当前页面容器
                            var frame = top.$("#" + relationships_ID).contents().find("#senceAarListTd");//获取需要载入的 frame
                            frame.load("${ctx}/misEmrAar.do?method=findmisEmrAarInUse&emrId=" + emrId);//载入页面
                            closed_layer('layer_box');//关闭选择层
                        }
                    },
                    error: function (textStatus) {
                        alert(textStatus.status + textStatus.statusText);
                    }
                });
            }

        });

    });
    /**
     **tr重排序然后做点事儿
     **/
    function sortDth(obj) {
        var tr = obj.parent().parent().parent();//获取被选中的行
        if (obj.is(':checked') == true) {//选中
            tr.addClass('selected')//选中样式
            //把被选中上放到最上面
            var firstTR = $('#dataList tr:eq(0)');//第一个tr
            tr.insertAfter(firstTR);
            var l_value = obj.attr("id");
        } else {
            //如果取消
            tr.removeClass('selected');
            //一、把这行放在最下面
            var lastTR = $('#dataList tr:last');
            tr.insertAfter(lastTR);
            //取消本行所有值
            calOneTr(obj.attr("id"));
        }
        $("input[class='grp']")[0].focus();//在第一个被选中的耗材物批次上落下焦点
    }
    /**
     **给分组赋值
     **/
    function aarPackage(obj, groupId) {
        var flag = obj.attr("flag");
        if (obj.is(':checked') == true) {//如果选中
            $("#" + flag + "grp").val(groupId);//给批次的空赋值
        } else {//否则
            $("#" + flag + "grp").val("");//把批次制空
        }
        groupArr = [];//push前制空，这个顺序还是对的，太特么合我的口味了
        $(".grp").each(function () {
            var temp = $(this).val();
            if (temp != "") {
                groupArr.push(temp * 1);//组装分组序列
            }
        });
    }

    /**
     **取消一行的所有值
     **/
    function calOneTr(drugId) {
        $("#" + drugId + "tr").find("input").val('');//找到ID所在的tr中含有的input
        $("#" + drugId + "tr").find("input[type='checkbox']").attr("checked", false);//取消所有checkbox
        $("#" + drugId + "tr").find("div").removeClass("new_checkbox_yes");
    }
    /**
     **必填项校验
     **/
    function vald(drugId) {
        if ($("#" + drugId).is(':checked') == true) {//如果耗材物被选中
            var ck1 = $("#" + drugId + "chosen").is(':checked');//分组是否被选中//不作为验证
            var ck2 = $("#" + drugId + "grp").val();//组号是否填写
            var ck3 = $("#" + drugId + "amount").val();//用法是否选择
            if (ck2 == "" || ck3 == "") {
                $("#" + drugId + "tr").addClass('error');
                return false;
            } else {
                $("#" + drugId + "tr").removeClass('error');
                return true;
            }
        }
    }

</script>
<style>
    table thead th {
        background: #9AA1A0;
        color: #fff;
    }

    input {
        width: 100px;
    }
</style>
<body>
<input type="text" name="mc" value="" id="mc" placeholder="输入耗材名称或拼音进行筛选" autofocus style="width: 600px"/>
<button type="button" class="btn" id="saveVsMeds">保存耗材使用</button>
<table class="table_list" id="dataList" style="width: 98%">
    <thead>
    <tr>
        <th class="debugMode${deBugMode}">ID</th>
        <th width="40%">名称</th>
        <th width="5%">使用</th>
        <th width="10%">批次</th>
        <th width="15%">单次用量</th>
        <th width="15%">单位</th>
        <th width="20%">使用时间</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="list" items="${list}">
        <tr id="${list.id}tr">
            <td class="debugMode${deBugMode}">${list.id}</td>
            <td>${list.name}<span style="display: none;">(${list.spell})</span></td>
            <td><input type="checkbox" id="${list.id}" class="chosen" flag="${list.id }"/></td>
            <td><input type="text" id="${list.id}grp" name="${list.id}grp" placeholder="批次" style="width: 40px"
                       class="grp" value="0"></td>
            <td><input type="text" id="${list.id}amount" name="${list.id}amount" placeholder="数量" style="width: 40px"
                       class="amount" value="1"></td>
            <td>${list.useUnits}</td>
            <td><input type="text" name="${list.id}useTime" id="${list.id}useTime" value="${nowDAT}"
                       onfocus="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})" class="input_full"/></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</ht