<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@ include file="/taglibs.jsp" %>
<%@ include file="/businit/MIS_EMR_SCORE_RECORD-init.jsp" %>
<!DOCTYPE html>
<html>
<body>
<center>
    <input type="hidden" value="${emrId }" id="emrId">
    <form id="vld_score">
        <h2 style="text-align:center">${systemConfig.printTitle}院前急救病历质量控制检查记录表（${level_text }）</h2>
        <div class="subtitle">
            检查人：<span id="createUserid"></span>
            检查日期：<span id="createTime"></span>
        </div>
        <table width="99%" border="1" id="table_list" class="editForm">
            <tr>
                <!-- 	<th>序号</th> -->
                <th>项目类别</th>
                <th>书写要求</th>
                <th>分值</th>
                <th>扣分标准</th>
                <th>小计</th>
            </tr>
            <c:forEach var="map" items="${map}">
                <tr>
                    <!-- 	<td width="5%">	 -->
                    <!-- 		${map.key.typeid} -->
                    <!-- 	</td> -->
                    <td width="5%" style="writing-mode:lr-tb">
                            ${map.key.typename}
                    </td>
                    <td width="15%">
                            ${map.key.remark}
                    </td>
                    <td width="5%">
                            ${map.key.maxscore}
                        <input type="hidden" groupid="${map.key.typeid}" id="${map.key.typeid}" max="max"
                               value="${map.key.maxscore}" number="true">
                    </td>
                    <td style="text-align: left;">
                        <c:forEach var="list" items="${map.value}">
                            <input type="text" groupid="${list.typeid}" id="value${list.id}" class="valueCode" value="0"
                                   dbValue="0" itemid="${list.id}" number="true" required>
                            <span id="span${list.id}">${list.name } （${list.value }分）</span>
                            <input type="text" groupid="${list.typeid}" id="remark${list.id}" class="remark" value=""
                                   placeholder="问题记录40字" maxlength="20"/>
                            <br/>
                        </c:forEach>
                    </td>
                    <td width="5%">
                        <span id="leftspan${map.key.typeid}"></span>
                        <input type="hidden" groupid="${map.key.typeid}" left="left" style="width: 40px"
                               id="left${map.key.typeid}" value="${map.key.maxscore}" number="true">
                    </td>
                </tr>
            </c:forEach>
            <tr>
                <td>
                    审核人
                </td>
                <td>
                    ${sysMemberInfo.name}
                </td>
                <td>
                    得分
                    <span id="lastScore"></span>
                </td>
                <td colspan="2">
                    病历评定
                    <span id="quality"></span>
                </td>
            </tr>
        </table>
    </form>
    <br>
    <c:if test="${b==true }">
        <button type="button" class="btn btn_gray" id="clear">清空</button>
        <button type="button" class="btn" id="saveSocre">保存</button>
    </c:if>
    <c:if test="${b==false }">
	<span id="cantPrv">
            ${cantPrv }
    </span>
    </c:if>
</center>
<%@ include file="/busvald/scoreRecordValidator.jsp" %>
</html>