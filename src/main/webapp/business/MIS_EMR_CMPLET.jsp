<!DOCTYPE HTML>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8" %>
<html>
<head>
    <script type="text/javascript">
        $(document).ready(function () {

            //quickSearch
            $("input#mc").quicksearch("table#data_list tbody tr");

            //自动行为:用语初始化模板列表查询
            findTemplates();

            //清空所有input
            $("#clear").click(function () {
                $("input").val('');
                $("select").val('');
            });

            //查询
            $("#find").click(function () {
                findTemplates();
            });

            $("#confirmTemplate").click(function () {
                callTemplate();
                $("#li_basic").click();
            });

        });

        function initEmrCmpltList(cmpltArray) {
            var html = "";
            for (var item in cmpltArray) {
                html = html + "<tr title='双击使用模板' id='tr" + cmpltArray[item].id + "' onclick='findTempLateId(" + cmpltArray[item].id + ")'>";
                html = html + "<td>";
                html = html + cmpltArray[item].name;
                html = html + "</td>";
                //html = html + "<td>";
                //html = html + cmpltArray[item].xzbm;
                //html = html + "</td>";
                //html = html + "<td>";
                //html = html + "<input type='radio' style='width:25pt;height:15pt' id='radio"+cmpltArray[item].id+"' name='userOrNo' Persistence='true' value='"+cmpltArray[item].id+"'>";
                //html = html + "</td>";
                html = html + "</tr>";
            }
            $("#tempLate_context").html(html);
        }

        /**
         **    点击选中行获取模板ID
         **/

        var templateId = "";

        function findTempLateId(flag) {
            templateId = flag;
            var tr = $("#tempLate_context").children("tr");
            ;
            tr.css('background-color', '');
            $("#tr" + flag).css('background-color', 'rgb(61, 186, 227)');
        }

        /**
         **模板调用方法
         **/
        function callTemplate() {
            if (templateId == "" || templateId == null) {
                alert("请选择一个填写模板");
            } else {
                //调用赋值模板方法   /aValueInit.jsp
                $.ajax({
                    contentType: "application/x-www-form-urlencoded; charset=utf-8",
                    url: "${ctx}/emr.do?method=findMisErmCmpltById&templateId=" + templateId,
                    type: "post",
                    success: function (data) {
                        //病历模板调用，接受后台JSON字符串
                        var arr = eval(data);
                        //调用模板赋值方法
                        //1强制更换
                        initEmrCmplt(arr, 1);
                    },
                    error: function (XMLHttpRequest, textStatus, errorThrown) {
                        alert(textStatus + ":" + XMLHttpRequest.status + ":" + XMLHttpRequest.readyState);
                    }
                });
            }
        }


        /**
         **查询病历模板列表
         **/
        function findTemplates() {
            var MisEmrCmpltTemplate = {
                name: $("#templateName").val(),
                tmplType: $("#tmplType").val()
            };
            var actionUrl = "${ctx}/misEmrCmplt.do?method=findMisEmrCmplt";
            $.ajax({
                contentType: "application/x-www-form-urlencoded; charset=utf-8",
                url: actionUrl,
                data: MisEmrCmpltTemplate,
                type: "post",
                success: function (data) {
                    //病历模板调用，接受后台JSON字符串
                    var cmpltArray = eval(data);
                    //调用模板赋值方法
                    initEmrCmpltList(cmpltArray);
                },
                error: function (XMLHttpRequest, textStatus, errorThrown) {
                    alert(textStatus + ":" + XMLHttpRequest.status + ":" + XMLHttpRequest.readyState);
                }
            });
        }

    </script>
</head>
<body>

<form id="dataform" method="post">
    <div class="search_div" style="display: none;">
        <table width="100%" border="0">
            <tr>
                <td colspan="2">
                    <input type="text" name="mc" value="" id="mc" class="input_full" placeholder="关键字查询" autofocus/>
                </td>
                <td nowrap="true" align="right">模板类型</td>
                <td nowrap="true" align="left">
                    <select name="tmplType" id="tmplType">
                        <option value="">---全部---</option>
                        <option value="0">通用模板</option>
                        <option value="1">私人模板</option>
                    </select>
                </td>
                <td nowrap="true" align="right">模板名称</td>
                <td nowrap="true" align="left">
                    <input type="text" name="templateName" value="" id="templateName" class="input_full"/>
                </td>
                <td nowrap="true" align="center">
                    <button type="button" class="btn" id="find">查询</button>
                    <button type="button" class="btn btn_gray" id="clear">清空</button>
                </td>
            </tr>
        </table>
    </div>
</form>
<center>
    <h2 style="text-align:center">
        <font style="color: red;font-size: 20px">
            <b>选择模板并点击 *开始填写* 进入相应模板！</b>
        </font>
    </h2>

    <table width="60%" border="0" cellpadding="0" cellspacing="0" id="tempLate_list" class="table_list">
        <thead>
        <tr>
            <th>模板名称</th>
            <!-- 				<th>行政编码</th> -->
        </tr>
        </thead>
        <tbody id="tempLate_context">

        </tbody>
    </table>


    <div style="text-align:center;">
        <button type="button" class="btn" id="confirmTemplate">开始填写</button>
    </div>
</center>
</body>
</html>