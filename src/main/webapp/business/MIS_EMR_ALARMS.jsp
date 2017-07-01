<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<!-- 数据库中的基础接处警信息 -->
<tr>
    <td colspan="10" style="line-height: normal;">
        <table width="100%">
            <tr>
                <td class="text_into" colspan="9"></td>
                <td class="text_into">
                    <b>病历编号</b>
                    <a target="_blank"
                       href="${ctx}/emr.do?method=initEmr&id=${misEmrBasicinfo.id}&ccxh=${vAcceptAmbulOutdInfo.id.ccxh}&lsh=${vAcceptAmbulOutdInfo.id.lsh}">
                        ${misEmrBasicinfo.id}
                    </a>
                </td>
            </tr>
            <tr>
                <th class="text_decollator" colspan="10" id="misEmrAlarms"><span>出车信息</span>
                </th>
            </tr>
            <tr group="misEmrAlarms">
                <td class="text_into">派车时间</td>
                <td class="text_edit"><fmt:formatDate
                        value="${vAcceptAmbulOutdInfo.pcsj }"
                        pattern="yyyy-MM-dd HH:mm:ss" type="date" dateStyle="long"/></td>
                <td class="text_into">出车时间</td>
                <td class="text_edit"><fmt:formatDate
                        value="${vAcceptAmbulOutdInfo.ccsj }"
                        pattern="yyyy-MM-dd HH:mm:ss" type="date" dateStyle="long"/></td>
                <td class="text_into">到达现场时间</td>
                <td class="text_edit"><fmt:formatDate
                        value="${vAcceptAmbulOutdInfo.ddxcsj }"
                        pattern="yyyy-MM-dd HH:mm:ss" type="date" dateStyle="long"/></td>
                <td class="text_into">病人上车时间</td>
                <td class="text_edit"><fmt:formatDate
                        value="${vAcceptAmbulOutdInfo.scsj }"
                        pattern="yyyy-MM-dd HH:mm:ss" type="date" dateStyle="long"/></td>
            </tr>
            <tr group="misEmrAlarms">

                <td class="text_into">离开现场时间</td>
                <td class="text_edit"><fmt:formatDate
                        value="${vAcceptAmbulOutdInfo.scsj }"
                        pattern="yyyy-MM-dd HH:mm:ss" type="date" dateStyle="long"/></td>
                <td class="text_into">到达医院时间</td>
                <td class="text_edit"><fmt:formatDate
                        value="${vAcceptAmbulOutdInfo.swsj }"
                        pattern="yyyy-MM-dd HH:mm:ss" type="date" dateStyle="long"/></td>
                <td class="text_into">返站时间</td>
                <td class="text_edit"><fmt:formatDate
                        value="${vAcceptAmbulOutdInfo.fzsj }"
                        pattern="yyyy-MM-dd HH:mm:ss" type="date" dateStyle="long"/></td>
                <td class="text_into">完成时间</td>
                <td class="text_edit"><fmt:formatDate
                        value="${vAcceptAmbulOutdInfo.wcsj }"
                        pattern="yyyy-MM-dd HH:mm:ss" type="date" dateStyle="long"/></td>
            </tr>
            <tr group="misEmrAlarms">
                <td class="text_into">医生</td>
                <td class="text_edit">${vAcceptAmbulOutdInfo.doctor }</td>
                <td class="text_into">护士</td>
                <td class="text_edit">${vAcceptAmbulOutdInfo.nurse }</td>
                <td class="text_into">司机</td>
                <td class="text_edit">${vAcceptAmbulOutdInfo.driver }</td>
                <td class="text_edit"><fmt:formatDate
                        value="${vAcceptAmbulOutdInfo.swsj }"
                        pattern="yyyy-MM-dd HH:mm:ss" type="date" dateStyle="long"/></td>
            </tr>
            <tr group="misEmrAlarms">
                <td class="text_into">电话</td>
                <td class="text_edit">${vAcceptAmbulOutdInfo.lxdh }</td>
                <td class="text_into">联系人</td>
                <td class="text_edit">${vAcceptAmbulOutdInfo.hzxm }</td>
                <td class="text_into">救治地点</td>
                <td class="text_edit" colspan="3">${vAcceptAmbulOutdInfo.jcdz }</td>
            </tr>
        </table>
    </td>
<tr>