<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@ include file="/taglibs.jsp" %>
<!DOCTYPE HTML>
<html>
<head>
    <title>${systemConfig.systemTitle }</title>
<body>
<table width="100%" border="1">
    <tr>
        <td>项目</td>
        <td>书写要求</td>
        <td>扣分标准</td>
        <td>总分值</td>
        <td>扣分情况</td>
    </tr>
    <tr>
        <td>基本病案记录:过敏史、出诊医院、站号、<br>病历编号、6项时间及15项一般情况记录
        </td>
        <td>基本病案项目填写齐全、准确</td>

        <td>药敏史未填写扣1分<input type="checkbox"><br/> 记录不规范扣0.5分<input
                type="checkbox"><br/> 到病人身边时间填写有误或时间记录未具体到分钟的，扣1分<input
                type="checkbox"><br/> 疾病类型判断有误扣1分<input type="checkbox"><br/>
            病情判断有误扣2分<input type="checkbox"><br/> 救治结果判断有误扣2分<input
                    type="checkbox"><br/> 其他各项漏填一项扣0.3分<input type="checkbox">
        </td>
        <td>10分</td>
        <td></td>
    </tr>
</table>
</body>
</head>