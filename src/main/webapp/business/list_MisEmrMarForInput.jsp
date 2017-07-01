<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@ include file="/taglibs.jsp" %>
<%
    String emrId = request.getParameter("emrId");
%>
<html>
<link rel="stylesheet" type="text/css" href="${ctx}/js/quicksearch/css/style.css"/>
<script type="text/javascript">
    var emrId = '<%=emrId%>';//病历ID
    var maxGrp = '${maxGrp}' * 1;//当前存在最大的用药次数
    var groupArr = [];//用药分组的临时校验变量
    for (var k = 1; k <= maxGrp; k++) {
        groupArr.push(k);//初始化校验用的数组，可以让批次从当前最大数+1
    }
    $(document).ready(function () {

        //quickSearch
        $("input#mc").quicksearch("table tbody tr");
        //隐藏所有的用药方式，频次，滴速
        $("td[group='leaderChoosed']").hide();

        //select改变时给隐藏于input赋值
        $("select").change(function () {
            var value = $(this).val();
            $(this).parent().find("input[class='debugMode${deBugMode}']").val(value);//给隐藏input赋值
        });


        //选中按钮
        $(".chosen").click(function () {
            sortDth($(this));
        });
        //搜索框失去焦点的时候把所有选中的放到最上面，这是多次一举的
        $("#mc").blur(function () {
            //$(".chosen").each(function (){
            //sortDth($(this));
            //});
        });
        //选定溶媒的时候自动给批次赋值
        $(".leader").click(function () {
            var groupId = 0;
            if (maxGrp == 0) {
                groupId = $(".leader:checked").length
            } else {
                groupId = maxGrp + 1;
            }
            ////批次初始值
            drugPackage($(this), groupId);
        });

        //批次填写
        $(".grp").keyup(function () {
            var l_value = $(this).val();
            //var l_value_floor = Math.floor(l_value);
            //console.log(l_value_floor);
            //console.log(groupArr);
            //console.log($.inArray(l_value_floor,groupArr));
            if (isNaN(l_value)) {//如果是数字&&在取整数在用药数组序列
                $(this).val('');//制空先
            } else {//如果不是

            }
        });


        //最后对象封装条件
        //被选中的药物
        //如果批次有值，那么本组中作为溶媒的药物被选中
        //如果该药物有批次，但是没溶媒，则提示，并焦点
        //所有被选中的药物值必须不能为空，如果为空，则提示，并且焦点
        $("#saveVsMeds").click(function () {
            var misEmrMarArray = new Array()//声明提交对象
            var exitDrug = $(".chosen:checked");
            for (var i = 0; i < exitDrug.length; i++) {//循环push
                var exitDrugId = exitDrug[i].id;
                //if(!vald(exitDrugId)){////有些必填项没写
                //alert("被选中的药物中存在未填项！");
                //return;
                //}else{//药物信息全部被写满，开始提交给服务器
                //}
                if (exitDrugId != null && exitDrugId != "") {//如果药物ID不是空
                    misEmrMarArray.push({
                        type: 1,//Integer type;//现场
                        emrId: emrId,//病历Id
                        medId: exitDrugId * 1, //Long medId;//被选中的药物ID
                        leader: $("#" + exitDrugId + "leader").is(':checked') == true ? 1 : 0,//作为一批
                        grp: $("#" + exitDrugId + "grp").val() * 1,//批次转换为数字
                        dose: $("#" + exitDrugId + "dose").val(), //String dose;//用量
                        /**update by 谢永富**/
                        units: $("#" + exitDrugId + "units").val() * 1,//用药单位
                        amount: $("#" + exitDrugId + "amount").val() * 1,//用量

                        usage: $("#" + exitDrugId + "usage").val(), //String usage;//使用方法
                        frequency: $("#" + exitDrugId + "frequency").val() * 1,//频次
                        drip: $("#" + exitDrugId + "drip").val()//滴速
                    });
                }
            }

            if (misEmrMarArray.length != 0) {
                $.ajax({//提交方法
                    contentType: "application/x-www-form-urlencoded; charset=utf-8",
                    url: "${ctx}/misEmrMar.do?method=saveMisEmrMisEmrMar&emrId=" + emrId + "&jsonStr=" + JSON.stringify(misEmrMarArray),
                    type: "post",
                    success: function (data) {
                        if (data.err != null) {
                            alert(data.err);
                        } else {
                            alert("保存成功！");
                            var relationships_ID = window.parent.$("#layer_box").attr("relationships_ID");//获取当前页面容器
                            var frame = top.$("#" + relationships_ID).contents().find("#senceDrugListTd");//获取需要载入的 frame
                            frame.load("${ctx}/misEmrMar.do?method=findMisEmrMar&type=1&emrId=" + emrId);//载入页面
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
            //给批次赋个值
            //找到最近的被选中的溶媒，如果有，就取那个值+0.1，
            var nearestExitLeader = $(".leader:checked");
            if (nearestExitLeader.length != 0) {
                var nearestExitGrpId = nearestExitLeader.parent().parent().next().find("input").val();
                if (nearestExitGrpId != "undefined") {
                    //console.log(nearestExitGrpId);
                    $("#" + l_value + "grp").val(nearestExitGrpId * 1 + 0.1);//属于本组，不需要啥增量了
                }
            }
        } else {
            //如果取消
            tr.removeClass('selected');
            //一、把这行放在最下面
            var lastTR = $('#dataList tr:last');
            tr.insertAfter(lastTR);
            //取消本行所有值
            calOneTr(obj.attr("id"));
        }
        $("input[class='grp']")[0].focus();//在第一个被选中的药物批次上落下焦点
    }
    /**
     **给分组赋值
     **/
    function drugPackage(obj, groupId) {
        var flag = obj.attr("flag");
        if (obj.is(':checked') == true) {//如果选中
            $("#" + flag + "grp").val(groupId);//给批次的空赋值
            //显示本行的用药方式、频次、滴速
            $("#" + flag + "tr").find("td[group='leaderChoosed']").show();
            $("#" + flag + "tr").find("input[class='drip']").val("60滴/分");
        } else {//否则
            $("#" + flag + "grp").val("");//把批次制空
            //隐藏本行的用药方式、频次、滴速
            $("#" + flag + "tr").find("td[group='leaderChoosed']").hide();
            $("#" + flag + "tr").find("input[class='drip']").val("");
        }
        groupArr = [];//push前制空，这个顺序还是对的，太特么合我的口味了
        $(".grp").each(function () {
            var temp = $(this).val();
            if (temp != "") {
                groupArr.push(temp * 1);//组装用药分组序列
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
        $("#" + drugId + "tr").find("select").multiselect("uncheckAll");//取消select的选中值
    }
    /**
     **必填项校验
     **/
    function vald(drugId) {
        if ($("#" + drugId).is(':checked') == true) {//如果药物被选中
            var ck1 = $("#" + drugId + "leader").is(':checked');//分组是否被选中//不作为验证
            var ck2 = $("#" + drugId + "grp").val();//组号是否填写
            var ck3 = $("#" + drugId + "usage").val();//用法是否选择
            var ck4 = $("#" + drugId + "dose").val();//用量是否填写
            if (ck2 == "" || ck3 == "" || ck4 == "") {
                $("#" + drugId + "tr").addClass('error');
                return false;
            } else {
                $("#" + drugId + "tr").removeClass('error');
                return true;
            }
        }
    }
    /**
     **用药方式和滴速关联，只有静滴才有滴速
     **/
    function changeDrip(e) {

        var flag = $(e).parent().parent().attr("id");
        if ($(e).val() == '70') {
            $("#" + flag).find("input[class='drip']").val("60滴/分");
        } else {
            $("#" + flag).find("input[class='drip']").val("");
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
<!-- 		<button type="button" class="btn" onclick="vald(30)">测试</button> -->
<input type="text" name="mc" value="" id="mc" placeholder="输入药物名称或拼音进行筛选" autofocus style="width: 600px"/>
<button type="button" class="btn" id="saveVsMeds">保存药物应用</button>
<table class="table_list" id="dataList" style="width: 98%">
    <thead>
    <tr>
        <th class="debugMode${deBugMode}">ID</th>
        <th width="30%" style="color: black">药品</th>
        <th width="5%" style="color: black">使用</th>
        <th width="5%" style="color: black">分批</th>
        <th width="15%" style="color: black">批次</th>
        <th width="15%" style="color: black">单次剂量</th>
        <th width="15%" style="color: black">单位</th>
        <th width="15%" style="color: black">数量</th>
        <th width="15%" style="color: black">给药方式</th>
        <th width="15%" style="color: black">频次</th>
        <th width="15%" style="color: black">滴速</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="list" items="${list}">
        <tr id="${list.id}tr">
            <td class="debugMode${deBugMode}">${list.id}</td>
            <td>${list.name}<span style="display: none;">(${list.spell})</span></td>
            <td><input type="checkbox" id="${list.id}" class="chosen"/></td>
            <td><input type="checkbox" class="leader" flag="${list.id }" id="${list.id }leader"/></td>
            <td><input type="text" id="${list.id}grp" name="${list.id}grp" placeholder="批次" style="width: 40px"
                       class="grp" value="0"></td>
            <td>
                <input type="text" id="${list.id}dose" name="${list.id}dose" style="width: 40px" placeholder="">
            </td>
            <td>
                    ${units}
                <input type="text" id="${list.id}units" name="${list.id}units" style="width: 100px"
                       class="debugMode${deBugMode}">
            </td>
            <td>
                <input type="text" id="${list.id}amount" name="${list.id}amount" placeholder="数量" style="width: 40px"
                       class="amount" value="1">
            </td>

            <td group="leaderChoosed">
                    ${usage}
                <input type="text" id="${list.id}usage" name="${list.id}usage" style="width: 100px"
                       class="debugMode${deBugMode}">
            </td>
            <td group="leaderChoosed">
                    ${frequency}
                <input type="text" id="${list.id}frequency" name="${list.id}frequency" style="width: 100px"
                       class="debugMode${deBugMode}">
            </td>
            <td group="leaderChoosed">
                <input type="text" id="${list.id}drip" name="${list.id}drip" style="width: 40px" class="drip" value="">
            </td>

        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>