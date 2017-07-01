<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<script type="text/javascript">
    $(document).ready(function () {

        selfControl();

        var createUser = '${createUser}' == "" ? "保存后自动生成" : '${createUser}';
        var createTime = '${createTime}' == "" ? "保存后自动生成" : '${createTime}';
        $("#createUserid").empty().html(createUser);
        $("#createTime").empty().html(createTime);


        <c:forEach var="listExit" items="${listExit}">
        $('#value' + '${listExit.itemid}').val('${listExit.score}').attr('dbValue', '${listExit.score}');//初始化已有评分记录
        $('#remark' + '${listExit.itemid}').val('${listExit.remark}');//初始化现有的问题记录
        </c:forEach>

        //初始化计算病历评价分数
        calculate();

        $(".valueCode").blur(function () {
            var valueCheck = $(this).val();
            if (!isNaN(valueCheck)) {//如果是数字
                if (valueCheck == "" || valueCheck == null) {//为空时处理
                    valueCheck = 0;
                    $(this).val(0);
                    $(this).next("span").css({'background-color': 'transparent', color: '#006666', padding: '3px'});
                } else {//给扣分项加红
                    $(this).next("span").css({'background-color': 'red', color: '#eee', padding: '3px'});
                }
                var groupId = $(this).attr("groupid");//得到组ID
                var temp_value = 0;//计算本组小计扣分总和
                $(".valueCode[groupId=" + groupId + "]").each(function (index, element) {//本组预算
                    //console.log(index + "::"+ parseFloat($(this).val()))
                    var ii = parseFloat($(this).val());
                    temp_value += ii;
                });
                var allNumb = parseFloat($("#" + groupId).val());
                temp_value = allNumb - temp_value;//得到小计
                if (temp_value < 0) {//如果小于0则为0
                    temp_value = 0;
                    //最大的剩余可扣分数
                    var l_left = $("#left" + groupId).val() * 1;
                    $(this).val(l_left).prev("span").css({
                        'background-color': '#f04848',
                        color: '#eee',
                        padding: '3px'
                    });
                    ;
                    alert('扣分总和超出该项总分！');
                    return;
                }
                //剩余分数和剩余分数显示
                //alert(temp_value.toFixed(2));//DEBUG这里问题就这里
                $("#leftspan" + groupId).html(temp_value.toFixed(2));
                $("#left" + groupId).val(temp_value.toFixed(2));//小计得分
            }
            findTotal();//计算总分

        });

        //重置分数
        $("#clear").click(function () {
            $(".valueCode").each(function () {
                $(this).val(0);//评分细则置0
                var groupId = $(this).attr("groupid");//得到组ID
                var temp_value = $("#" + groupId).val();
                $("#leftspan" + groupId).html(temp_value);
                $("#left" + groupId).val(temp_value);//小计得分
                $("span").each(function () {
                    $(this).css({'background-color': 'transparent', color: '#006666', padding: '3px'})
                });
            });
        });


        $(".remark").focus(function () {
            var l_groupid = $(this).attr("groupid");
        });

        /**
         *保存方法
         **/
        $("#saveSocre").click(function () {
            findTotal();//计算总分

            var check = $("#vld_score").validate();//校验规则
            if (check.errorList.length != 0) {
                return;
            }

            //评分汇总对象
            var MisEmrScoreTotal = {
                                emrId: $("#emrId").val(),
                                scoreLevel:${level} * 1,
                    totalScore
            :
            $("#lastScore").html()
        }
            ;
            //病历评分对象组装
            var MisEmrScoreRecord = new Array()//声明病历评分
            //循环push
            $(".valueCode").each(function () {
                if ($(this).val() != 0 || $(this).attr("dbValue") != 0) {
                    var tempFlag = $(this).attr("itemid");
                    MisEmrScoreRecord.push({
                                emrId: $("#emrId").val(),//病历Id
                                scoreLevel:${level} * 1, //审核等级
                            itemid
                :
                    $(this).attr("itemid"),//扣分项ID
                            time
                :
                    1,//冗余字段
                            score
                :
                    $(this).val() * 1, //评分值
                            remark
                :
                    $("#remark" + tempFlag).val()//问题记录
                })
                    ;
                    //console.log($("#remark"+tempFlag).val());
                }
            });
            //console.log(JSON.stringify(MisEmrScoreRecord));
            //保存
            $.ajax({
                contentType: "application/x-www-form-urlencoded; charset=utf-8",
                url: "${ctx}/vMisEmrScoreTypeStdd.do?method=saveMisEmrScoreRecord&misEmrScoreRecordJson=" + JSON.stringify(MisEmrScoreRecord),
                type: "post",
                data: MisEmrScoreTotal,
                success: function (data) {
                    if (data == "") {
                        alert("保存成功！");
                        window.location.href = window.location.href;//刷新页面
                    }
                },
                error: function (data, textStatus) {
                    alert(textStatus + "错误:" + data.responseText);
                }
            });

        });

    });//JQUERY结束

    /**
     *初始化计算结果
     */
    function calculate() {
        $("input[max='max']").each(function () {
            var groupId = $(this).attr("groupid");//得到组ID
            var temp_value = 0;//计算本组小计扣分总和
            $(".valueCode[groupId=" + groupId + "]").each(function () {//本组预算
                temp_value += $(this).val() * 1;
                if ($(this).val() != 0) {//给扣分项加红
                    $(this).next("span").css({'background-color': '#f04848', color: '#eee', padding: '3px'});
                }
            });
            //console.log("max="+$("#"+groupId).val()+"---"+temp_value);
            temp_value = $("#" + groupId).val() - temp_value;//得到小计
            $("#leftspan" + groupId).html(temp_value.toFixed(2));
            $("#left" + groupId).val(temp_value.toFixed(2));//小计得分
        });
        findTotal();
    }

    /**
     *病历评价结果
     **/
    function findTotal() {
        //小计总分
        var left = 0;
        $("input[left='left']").each(function () {
            left += $(this).val() * 1;
        });
        $("#lastScore").html(left);
        //得到病历评定
        $.ajax({
            contentType: "application/x-www-form-urlencoded; charset=utf-8",
            url: "${ctx}/vMisEmrScoreTypeStdd.do?method=findMisEmrQuality&total=" + left,
            type: "post",
            success: function (data) {
                $("#quality").html(data);
            },
            error: function (data, textStatus) {
                $("#quality").html(textStatus + "错误:" + data.responseText);
            }
        });
    }

    function selfControl() {
        var createuserid = '${createUserId}';
        if (createuserid != '${sysMemberInfo.id}' && createuserid != null && createuserid.length > 0) {
            $("#saveSocre,#clear").hide();
        }
    }

</script>
