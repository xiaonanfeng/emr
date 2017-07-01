<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<!DOCTYPE HTML>
<html>
<head>
    <link href="${ctx}/css/the_style.css" rel="stylesheet" type="text/css">
    <link href="${ctx}/js/chose/css/multi-select.css" media="screen" rel="stylesheet" type="text/css">
    <style type="text/css">
        /***********按钮***********/
        .btn {
            padding: 8px 12px;
            font-size: 14px;
            background: #40937f;
            border-radius: 5px;
            text-decoration: none;
            color: rgba(255, 255, 255, 1.00);
            display: inline-block;
            outline: none;
            color: #fff;
            transition: box-shadow .3s;
            border: none;
            box-shadow: 0 0 0 0px #fff, 0 0 0 0px #fff;
            cursor: pointer;
            margin: 5px;
            text-align: center;
            text-shadow: 1px 1px 0px rgba(0, 0, 0, 0.2);
            min-width: 70px;
            font-weight: bold;
        }

        .btn:hover {
            box-shadow: 0 0 0 1px #fff, 0 0 0 2px #40937f;
            animation: gelatine 0.5s 1;
        }

        .btn_gray {
            background: rgba(0, 0, 0, 0.3);
            color: #fff;
        }

        .btn_gray:hover {
            box-shadow: 0 0 0 1px #fff, 0 0 0 2px #BDBDBD;
            animation: gelatine 0.5s 1;
        }

        .btn_yellow {
            background: #f6a300;
            color: #fff;
        }

        .btn_yellow:hover {
            box-shadow: 0 0 0 1px #fff, 0 0 0 2px #f6a300;
            animation: gelatine 0.5s 1;
        }

        #sure {
            position: absolute;
            left: 50%;
            top: 140px;
            margin-left: -37px;
        }

    </style>
    <script src="${ctx}/js/jquery-2.1.1.min.js" type="text/javascript"></script>
    <script src="${ctx}/js/jquery.quicksearch.js" type="text/javascript"></script>
    <script src="${ctx}/js/chose/jquery.multi-select.js" type="text/javascript"></script>
    <script>
        var emt = '${loginPath}';//设备登录情况
        var inputId = '${param.flag}';//关闭页面时给哪个input赋值
        $(document).ready(function () {
            //多选组件初始化
            $('#select').multiSelect({
                keepOrder: true,
                selectableHeader: "<input type='text' style='' class='input_full' autocomplete='off' placeholder='可选项查询'>",
                selectionHeader: "<input type='text' class='search-input input_full' autocomplete='off'  placeholder='选中项查询'>",
                afterInit: function (ms) {
                    getValueAndText();//先初始化一下值
                    var that = this,
                            $selectableSearch = that.$selectableUl.prev(),
                            $selectionSearch = that.$selectionUl.prev(),
                            selectableSearchString = '#' + that.$container.attr('id') + ' .ms-elem-selectable:not(.ms-selected)',
                            selectionSearchString = '#' + that.$container.attr('id') + ' .ms-elem-selection.ms-selected';

                    that.qs1 = $selectableSearch.quicksearch(selectableSearchString).on('keydown', function (e) {
                        if (e.which === 40) {
                            that.$selectableUl.focus();
                            return false;
                        }
                    });

                    that.qs2 = $selectionSearch.quicksearch(selectionSearchString).on('keydown', function (e) {
                        if (e.which == 40) {
                            that.$selectionUl.focus();
                            return false;
                        }
                    });
                },
                afterSelect: function () {//选择回调方法
                    this.qs1.cache();
                    this.qs2.cache();
                    getValueAndText();
                },
                afterDeselect: function () {//取消回调方法
                    this.qs1.cache();
                    this.qs2.cache();
                    getValueAndText();
                }
            });
            //创建确定button
            var buttonStr = "<button type='button' id='sure' class='btn'>确定</button>";
            var objDiv = $("#ms-select");
            objDiv.append(buttonStr);


            //确定按钮，关闭层，并赋值
            $("#sure").click(
                    function () {
                        getValueAndText();
                        ///alert($("#returnText").val());
                        layer_to_page($("#returnIds").val(), $("#returnText").val(), inputId);
                        closed_layer('layer_box');
                    }
            );


        });


        //给隐藏input赋值
        function getValueAndText() {
            var valueArr = new Array();
            var textArr = new Array();
            $(".ms-selection").find("li.ms-selected").each(function () {
                valueArr.push($(this).attr("pvalue"));
                textArr.push("<span value='"++
                "' style='background:red;cursor: pointer;'>" + $(this).attr("ptext") + "</span>"
                )
                ;
            });
            //alert(textArr);
            $("#returnIds").val(valueArr);
            $("#returnText").val(textArr);
        }


        //关闭层，并赋值
        function layer_to_page(values_id, values_text, tarId) {
            var obj = null;
            var callBackDom = null;//可能会有些其他的什么东西，比如药物应用会有回调函数
            if (emt == 'web') {//web
                var relationships_ID = window.parent.$("#layer_box").attr("relationships_ID");
                obj = top.$("#" + relationships_ID).contents().find("#" + tarId);
                obj.val(values_id);//给input赋值
                obj = top.$("#" + relationships_ID).contents().find("#" + tarId + "Text");
                obj.html(values_text);//给textarea赋值

                //药物应用
                callBackDom = top.$("#" + relationships_ID).contents().find("#" + inputId + "CallBackButton");
            } else {//pad
                $(window.parent.document).find("#" + tarId).val(values_id);
                $(window.parent.document).find("#" + tarId + "Text").val(values_text);

                //药物应用
                callBackDom = $(window.parent.document).find("#" + inputId + "CallBackButton");
            }
            if (inputId == "sceneDrug" || inputId == "itwDrug") {
                callBackDom.click();
            }
        }


        //关闭层
        function closed_layer(the_id) {
            window.parent.$("#index_loading_bg").css("display", "block");
            window.parent.$("#iframe_layer").css("display", "none");
            window.parent.$("#layer_box").animate({
                width: "300px",
                height: "160px",
                marginLeft: "-150px",
                marginTop: "-80px"
            }, 300);
            window.parent.$("#layer_box").attr("relationships_ID", "");
            window.parent.$("#index_loading_bg").animate({
                width: "300px",
                height: "120px",
            }, 300);
            window.parent.$("#iframe_layer").animate({
                width: "300px",
                height: "120px",
            }, 300);
            setTimeout(function () {
                        window.parent.$("#the_zhezhao").css("display", "none");
                        window.parent.$("#iframe_layer").attr("src", "");
                        window.parent.$("#layer_box").css("display", "none");
                    },
                    300);
        }
    </script>
</head>
<body>
<input type="hidden" id="returnIds" name="returnIds">
<input type="hidden" id="returnText" name="returnText">
${select}
</body>
</html>