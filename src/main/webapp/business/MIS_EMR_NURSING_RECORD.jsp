<!DOCTYPE HTML>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8" %>
<%@ include file="/taglibs.jsp" %>
<%@ include file="/businit/MIS_EMR_NURSING_RECORD-init.jsp" %>
<h2 style="text-align:center">${systemConfig.printTitle}院前急救护理记录</h2>
<form id="vld_nursing" novalidate="novalidate">
    <input id="id" name="id" class="input_full" type="hidden" value="${misEmrBasicinfo.id }">
    <ul class="asTable" id="dataUl">
        <div class="text_decollator">
            <span>基础信息</span>
        </div>
        <li><span>患者姓名</span><span>${misEmrBasicinfo.name }</span>
        </li>
        <li><span>性别</span><span>${sex }</span>
        </li>
        <li class="double_li">
            <span>年龄</span>
            <span id="age" name="age"></span>
            <select id="timeScope">
                <option>&nbsp;</option>
                <option value="1">分</option>
                <option value="60">时</option>
                <option value="1440">天</option>
                <option value="43200">月</option>
                <option value="518400">岁</option>
            </select>
        </li>
        <li><span>病例号</span><span>${misEmrBasicinfo.emrCode }</span>
        </li>
        <li><span>接诊时间</span><fmt:formatDate value="${misEmrNursingRecord.treatTime}" pattern="yyyy-MM-dd HH:mm:ss"
                                             type="date" dateStyle="long"/>
        </li>
        <li><span>接诊医生</span><span>${doctorSign }</span>
        </li>
        <li><span>接诊地点</span><span>${misEmrBasicinfo.address }</span></li>
        <li class="over-line"><span>接诊事件</span><span>${misEmrBasicinfo.chiefComplaint }</span></li>
        <li class="over-line"><span>初步诊断</span><span>${misEmrPreaidVs.primDiagR }</span></li>
        <div class="text_decollator">
            <span>病情观察</span>
        </div>
        <li><span>体温</span><span>${misEmrPe.t }℃</span></li>
        <li><span>脉率</span><span>${misEmrPe.p }次/分</span></li>
        <li><span>呼吸频率</span><span>${misEmrPe.r }次/分</span>
        </li>
        <li><span>血压低值</span><span>${misEmrPe.bpL }mmHg</span>
        </li>
        <li><span>血压高值</span><span>${misEmrPe.bpH }mmHg</span>
        </li>
        <li><span>血氧饱和度</span><span>${misEmrAE.bos }%</span>
        </li>
        <li><span>血清CO2浓度</span><input id="eco2" name="eco2" class="input_full" value="" type="text"
                                       placeholder="单位：mmol/L">
        </li>
        <li class="half-line"><span>神志</span><span class="data-text" id="conscious">${conscious }</span></li>
        <li class="half-line"><span>瞳孔</span><span class="data-text" id="pupil">${pupil}</span></li>
        <li class="half-line"><span>精神</span><span class="radio">${mentalstate }</span></li>
        <li class="half-line"><span>体位</span><span class="radio">${posture }</span></li>
        <li class="half-line"><span>口唇色泽</span><span class="radio">${cyanosis }</span></li>
        <li class="half-line"><span>皮肤</span><span class="radio">${skin }</span></li>
        <div class="text_decollator">
            <span>病情变化及危重症抢救记录</span>
        </div>
        <li class="over-line"><span>${misEmrPreaidVs.sceneRecord }</li>
        <div class="text_decollator">
            <span>药物应用</span>
        </div>
        <li class="over-line">
            <c:if test="${fn:length(senceDrugList) != 0}">
                <c:forEach var="list" items="${senceDrugList}">
                    <br/>
                    <c:if test="${fn:indexOf(list.grp,'0')!='-1'}">
                        <b>${fn:replace(list.grp,'0', '')}</b>
                    </c:if>${list.name} ${list.dose} ${list.units_text}
                    <c:if test="${list.amount >= 2}">*${list.amount}</c:if>
                    ${list.usage} ${list.drip} ${list.frequency_text}
                </c:forEach>
            </c:if>
            <c:if test="${fn:length(senceDrugList) == 0}">
                无
            </c:if>
        </li>

        <div class="text_decollator">
            <span>护理措施</span>
        </div>
        <li class="half-line"><span>措施</span><span class="checkbox">${nursingCare }</span></li>


        <div class="text_decollator">
            <span>处理结果</span>
        </div>
        <li><span>体温</span><input id="postT" name="postT" class="input_full" type="text" placeholder="单位：℃">
        </li>
        <li><span>脉率</span><input id="postP" name="postP" class="input_full" type="text" placeholder="单位：次/分">
        </li>
        <li><span>呼吸频率</span><input id="postR" name="postR" class="input_full" type="text" placeholder="单位：次/分">
        </li>
        <li><span>血压低值</span><input id="postBpl" name="postBpl" class="input_full" placeholder="单位：mmHg"
                                    type="text"></li>
        <li><span>血压高值</span><input id="postBph" name="postBph" class="input_full" placeholder="单位：mmHg"
                                    type="text"></li>
        <li><span>血氧饱和度</span><input id="postSpo2" name="postSpo2" class="input_full" placeholder="单位：%"
                                     type="text"></li>
        <li><span>血清CO2浓度</span><input id="postEco2" name="postEco2" class="input_full" placeholder="单位：mmol/L"
                                       type="text"></li>
        <li class="half-line"><span>效果评价</span><span class="radio">${outcome }</span></li>
        <li class="over-line"><span>备注</span><textarea id="remark" name="remark"></textarea></li>
        <li class="over-line"><span>护士ID</span><span>${hsid }</span>
        </li>
    </ul>
</form>


<div style="text-align:center;">
    <button type="button" class="btn" id="save">保存</button>
    <button type="button" class="btn" id="print">打印</button>
</div>
<%@ include file="/busvald/nursingValidator.jsp" %>
