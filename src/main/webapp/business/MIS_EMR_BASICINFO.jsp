<%@ page language="java" import="java.util.*" pageEncoding="utf-8" %>
<%@ include file="/businit/MIS_EMR_BASICINFO-init.jsp" %>
<form id="vld_base_form">
    <table width="100%" border="0" class="editForm">
        <!-- 	接警信息内容 -->
        <%@ include file="MIS_EMR_ALARMS.jsp" %>
        <tr id="lbs1">
            <th class="text_decollator" colspan="10">
                <span>远程医疗（适用于有远程医疗功能的单位）</span>
            </th>
        </tr>
        <tr id="lbs2">
            <td class="text_into">请求等级</td>
            <td class="text_edit">
                <a class="btn btn_yellow callRemote" type="button" flag="1">
                    一般
                </a>

                <a class="btn btn_yellow callRemote" type="button" flag="2">
                    紧急
                </a>

                <a class="btn btn_yellow callRemote" type="button" flag="3">
                    立即
                </a>
            </td>
        </tr>
        <tr>

            <th class="text_decollator" colspan="10" id="basicInfo">
                <span>患者信息</span>
            </th>
        </tr>
        <tr group="basicInfo">
            <td class="text_into">患者姓名</td>
            <td class="text_edit"><input class="" type="text" name="name" id="name" value=""></td>
            <td class="text_into">身份证</td>
            <td class="text_edit"><input class="input_full" type="text" placeholder="不详、拒绝提供或真实身份证"
                                         id="idCard" name="idCard"></td>
            <td class="text_into">性别</td>
            <td class="text_edit">${sex}</td>
            <td class="text_into">民族</td>
            <td class="text_edit">${ethnic}</td>
        </tr>
        <tr group="basicInfo">
            <td class="text_into">年龄</td>
            <td class="text_edit" style="word-break: keep-all;">
                <input style="width:40px;" type="text" placeholder="年龄" id="age" name="age">
                <select id="timeScope">
                    <option>&nbsp;</option>
                    <option value="1">分</option>
                    <option value="60">时</option>
                    <option value="1440">天</option>
                    <option value="43200">月</option>
                    <option value="518400">岁</option>
                </select>
            </td>
            <td class="text_into">年龄（段）</td>
            <td class="text_edit">
                ${stage}
            </td>
            <td class="text_into">国籍</td>
            <td class="text_edit">${nation }</td>
            <td class="text_into">现场环境</td>
            <td class="text_edit">${spot}</td>
        </tr>
        <tr group="basicInfo">
            <td class="text_into">联系人</td>
            <td class="text_edit">
                <input class="" type="text" placeholder="真实联系人" id="contact" name="contact">
            </td>
            <td class="text_into">联系电话</td>
            <td class="text_edit"><input class="" type="text" placeholder="真实联系电话"
                                         id="phone" name="phone"></td>
            <td class="text_into">救治地点</td>
            <td class="text_edit" colspan="3"><input class="input_full" type="text" placeholder="真实接车地址"
                                                     id="address" name="address"></td>
        </tr>
        <tr group="basicInfo">
            <td class="text_into">病史提供人</td>
            <td class="text_edit">${hxProvider}</td>
            <td class="text_into">病情</td>
            <td class="text_edit">${condition}</td>
            <td class="text_into">救治结果</td>
            <td class="text_edit">${preEmcResult}</td>
        </tr>
        <tr group="basicInfo">
            <td class="text_into">呼救原因</td>
            <td class="text_edit">${cause}</td>
            <td class="text_into">疾病类型</td>
            <td class="text_edit" id="diseaseTypeTD"></td>
            <td class="text_into" style="color: red" id="dClassifyTD">疾病分类</td>
            <td class="text_edit">
                ${dClassify}
            </td>
        </tr>
        <tr>
            <td class="text_into">送往医院</td>
            <td class="text_edit">${sentTo }</td>
            <td class="text_into">
                <div group="sendToOther" style="display: none;">
                    其他医院
                </div>
            </td>
            <td class="text_edit">
                <div group="sendToOther">
                    <input type="text" id="sendToOther" name="sendToOther" class="input_full" placeholder="其他医院">
                </div>
            </td>
            <td class="text_into">未送院</td>
            <td class="text_edit">
                <input type="checkbox" id="isHosptial" name="isHosptial" superBox="normal"
                       style="height: 18px;width: 18px;">
            </td>
        </tr>
        <tr>
            <th class="text_decollator" colspan="10" id="thChiefComplaint">
                <span>主诉</span>
            </th>
        </tr>
        <tr group="thChiefComplaint">
            <td class="text_into">主诉</td>
            <td class="text_edit" colspan="9"><input class="input_full"
                                                     type="text" placeholder="20字左右" id="chiefComplaint"
                                                     name="chiefComplaint"></td>
        </tr>
        <tr>
            <th class="text_decollator" colspan="10" id="thPresentHx">
                <span>现病史</span>
            </th>
        </tr>
        <tr group="thPresentHx">
            <td class="text_into">现病史</td>
            <td class="text_edit" colspan="9">
                <input class="input_full"
                       type="text" id="presentHx" name="presentHx">
            </td>
        </tr>
        <tr>
            <th class="text_decollator" colspan="10">
                <span>既往病史</span>
            </th>
        </tr>
        <tr group="disHistory">
            <td class="text_into">既往史</td>
            <td class="text_edit">${pastHx}</td>
            <td class="text_into">病史</td>
            <td class="text_edit" colspan="7"><input class="input_full"
                                                     id="otherHx" name="otherHx" type="text"></td>
        </tr>
        <tr group="disHistory" hideGroup="pastHx" style="display: none;">
            <td class="text_into">心脏病</td>
            <td class="text_edit">${heartCondition}</td>
            <td class="text_into">类型</td>
            <td class="text_edit">${heartIllness}</td>
            <td class="text_into">病史（年）</td>
            <td class="text_edit"><input class="input_NOfull" type="text"
                                         id="heartHx" name="heartHx"></td>
            <td class="text_into">治疗</td>
            <td class="text_edit" colspan="5"><input class="input_full"
                                                     id="heartTherapy" name="heartTherapy" type="text"></td>
        </tr>
        <tr group="disHistory" hideGroup="pastHx" style="display: none;">
            <td class="text_into">高血压</td>
            <td class="text_edit">${hbp }</td>
            <td class="text_into">血压波动</td>
            <td class="text_edit"><input style="width:60px;" type="text"
                                         id="bpH" name="bpH">/<input style="width:60px;" type="text"
                                                                     id="bpL" name="bpL">mmHg
            </td>
            <td class="text_into">病史（年）</td>
            <td class="text_edit"><input class="input_NOfull" type="text"
                                         id="hbpHx" name="hbpHx"></td>
            <td class="text_into">治疗</td>
            <td class="text_edit" colspan="3"><input class="input_full"
                                                     type="text" id="hbpTherapy" name="hbpTherapy"></td>
        </tr>
        <tr group="disHistory" hideGroup="pastHx" style="display: none;">
            <td class="text_into">糖尿病</td>
            <td class="text_edit">${diabetes}</td>
            <td class="text_into">类型</td>
            <td class="text_edit">${dmType}</td>
            <td class="text_into">病史（年）</td>
            <td class="text_edit"><input class="input_NOfull" type="text"
                                         id="dmHx" name="dmHx"></td>
            <td class="text_into">治疗</td>
            <td class="text_edit" colspan="5"><input class="input_full"
                                                     id="dmTherapy" name="dmTherapy" type="text"></td>
        </tr>
        <tr>
            <th class="text_decollator" colspan="10" id="thdisHistory">
                <span>药物过敏史</span>
            </th>
        </tr>
        <tr group="thdisHistory">
            <td class="text_into">药物过敏</td>
            <td class="text_edit">${drugAllergy}</td>
            <td class="text_into">药物名称</td>
            <td class="text_edit" colspan="7">
                <input class="input_full" style="color: red" name="drugName" id="drugName" type="text">
            </td>
        </tr>
    </table>
</form>

<div style="text-align:center;">
    <button type="button" class="btn" id="saveBase">保存</button>
    <button type="button" class="btn commitButton" style="margin-left:150px">提交</button>
</div>

