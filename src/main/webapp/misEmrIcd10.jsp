<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@ include file="/taglibs.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <title>${systemTitle}</title>
    <script>
        $(document).ready(function () {
            //回车查询
            $("#diseaseName").keydown(function (e) {
                var ev = document.all ? window.event : e;
                if (ev.keyCode == 13) {
                    $("#find").click();
                }
            });
            //按钮点击主动查询
            $("#find").click(function () {
                var diseaseName = $("#diseaseName").val();
                var url = "${ctx}/misEmrPreaidVs.do?method=findPrimDiag&diseaseName=" + diseaseName;
                $("#findCtx").attr("src", url);
            });

        });


    </script>
</head>
<body>
<div class="search_div">
    <table width="100%" border="0">
        <tr>
            <td nowrap="true" align="right">搜索</td>
            <td nowrap="true" align="left">
                <input type="text" name="diseaseName" id="diseaseName" value=""
                       class="input_fulle" placeholder="输入汉字和拼音首字母进行查寻"/>
            </td>
            <td nowrap="true" align="center">
                <button type="button" class="btn" id="find">查询</button>
            </td>
        </tr>
    </table>
    <table width="100%" border="0" cellpadding="0" cellspacing="0"
           class="table_list">
        <thead>
        <tr class="table_list_first">
            <th width="40%">疾病名称</th>
            <th width="30%">疾病代码</th>
            <th width="30%">拼音</th>
        </tr>
        </thead>
    </table>
</div>
<center>
    <iframe id="findCtx" src="" width="99%" height="500" style="border: 0px;"></iframe>
</center>
</body>
</html>
