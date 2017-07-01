<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@ include file="/taglibs.jsp" %>
<%@ include file="/businit/MIS_EMR_NOTICE-init.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <title>${systemConfig.systemTitle }</title>
</head>
<body>
<form id="vld_handOver_form">
    <h2 style="text-align:center">${systemConfig.printTitle}院前急救病情告知书</h2>
    <table width="100%" border="0" class="editForm">
        <tr>
            <th class="text_decollator" colspan="8" id="basicInfo"><span>基本信息</span>
            </th>
        </tr>
        <tr>
            <td class="text_into">出诊单位</td>
            <td class="text_edit">${szfz}</td>
            <!-- 				${sentTo} -->
            <td class="text_into">到达患者身边时间</td>
            <td class="text_edit"><input id="arvTime" name="arvTime" type="text"
                                         value="<fmt:formatDate value="${misEmrNotice.arvtime}" pattern="yyyy-MM-dd HH:mm:ss" type="date" dateStyle="long" />"
                                         onfocus="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})"/></td>

            <td class="text_into">告知时间</td>
            <td class="text_edit">
                <input id="noticeTime" name="noticeTime" type="text"
                       value="<fmt:formatDate value="${misEmrNotice.noticetime}" pattern="yyyy-MM-dd HH:mm:ss" type="date" dateStyle="long" />"
                       onfocus="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})"/>
            </td>
        </tr>
        <tr>
            <td class="text_into">姓名</td>
            <td class="text_edit">${name }</td>
            <td class="text_into">性别</td>
            <td class="text_edit">${sex}</td>
            <td class="text_into">
                <span style="width:20%">年龄： </span>
                <span id="age"></span>
            </td>
            <td class="text_edit">
                <select id="timeScope">
                    <option>&nbsp;</option>
                    <option value="1">分</option>
                    <option value="60">时</option>
                    <option value="1440">天</option>
                    <option value="43200">月</option>
                    <option value="518400">岁</option>
                </select>
            </td>
        </tr>
        <tr>
        </tr>
        <tr>
            <th class="text_decollator" colspan="6" id="basicInfo"><span>告知内容</span>
            </th>
        </tr>
        <c:forEach var="list" items="${list}">
            <tr>
                <td class="text_into"><input type="checkbox"
                                             id="noticeBox${list.itemId}" name="noticeBox" value="${list.itemId}"
                                             superBox="normal"/></td>
                <td class="text_edit" colspan="5">${list.sortId}.
                        ${list.display}</td>
            </tr>
        </c:forEach>
        <tr>
            <td class="text_into">患者/患方（关系）</td>
            <td class="text_edit"><input type="text" id="rlt" name="rlt" value="${misEmrNotice.rlt}"></td>
            <td class="text_into">见证人</td>
            <td class="text_edit"><input type="text" id="atte" name="atte" value="${misEmrNotice.atte}"></td>
            <td class="text_into">告知人</td>
            <td class="text_edit"><input type="text" id="spker" name="spker" value="${misEmrNotice.spker}"></td>
        </tr>
    </table>
    <center>
        <button type="button" class="btn" id="saveNotice">保存</button>
        <button type="button" class="btn" id="printNotice">打印</button>
    </center>

    <input class="debugMode${deBugMode}" id="id" name="id" value="${misEmrBasicinfo.id}" readonly="readonly" title="主键">
</body>
</html>


