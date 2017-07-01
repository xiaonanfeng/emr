<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@ include file="/businit/MIS_EMR_PREAID_VS-init.jsp" %>
<div id="vs" title="施救措施">

    <!-- 这两个不能删，为了给药物应用提供DOM -->
    <button type="button" style="display: none;" id="sceneDrugCallBackButton">测试</button>
    <button type="button" style="display: none;" id="itwDrugCallBackButton">测试</button>

    <form id="vld_preaidVs_form">
        <table width="100%" border="0" class="editForm">
            <tr>
                <th class="text_decollator" id="thPrim">
                    <span>初步诊断</span>
                    <button class="btn btn_yellow" style="float:right" type="button" id="addPrim"
                            onclick="open_layer('选择病情诊断','${ctx}/misEmrPreaidVs.do?method=findPrimDiag&values=${misEmrPreaidVs.primDiag}&flag=primDiag')">
                        添加病情诊断
                    </button>
                </th>
            </tr>
            <tr group="thPrim">
                <td>
				<textarea
                        style="width: 100%" id="primDiagText" name="primDiagText"
                        placeholder="点击右侧按钮选择！" readonly="readonly"></textarea> <input
                        id="primDiag" name="primDiag" type="text"
                        class="debugMode${deBugMode}" readonly="readonly"></td>
            </tr>
            <tr group="thPrim">
                <td>
				<textarea class="textarea_full" id="primDiagR"
                          name="primDiagR" placeholder="初步诊断，可输入64个字">${misEmrPreaidVs.primDiagR}</textarea>
                </td>
            </tr>
            <tr>
                <th class="text_decollator" id="thSenTrt">
                    <span>处理措施</span>
                    <button class="btn btn_yellow" type="button" id="addScene"
                            onclick="open_layer('选择处理措施','${ctx}/misEmrPreaidVs.do?method=findSceneTreatlects&values=${misEmrPreaidVs.sceneTreat}&flag=sceneTreat')">
                        添加处理措施
                    </button>
                </th>
            </tr>
            <tr group="thSenTrt">
                <td>
				<textarea class="textarea_full"
                          id="sceneTreatText" name="sceneTreatText"
                          placeholder="点击右侧按钮选择！" readonly="readonly"></textarea>
                    <input id="sceneTreat" name="sceneTreat"
                           class="debugMode${deBugMode}" readonly="readonly">
                </td>
            </tr>
            <tr>
                <th class="text_decollator" id=theSenTrtResult>
                    <span>处理结果（根据实际需要填写）</span>
                </th>
            </tr>
            <tr>
                <td>
                    <table width="70%" border="0" class="editForm">
                        <tr id="call58">
                            <td class="text_into" style="width: 100px;text-align: left"><span style="font-weight: bold">静脉输液</span>
                            </td>
                            <td class="text_into">结果</td>
                            <td class="text_edit">
                                <select  id="preaidSucceed58">
                                    <option></option>
                                    <option value="1">成功</option>
                                    <option value="2">未成功</option>
                                </select>
                            </td>
                            <td class="text_into">未成功原因</td>
                            <td class="text_edit">
                                ${reason58}
                            </td>
                        </tr>
                        <tr id="call66">
                            <td class="text_into" style="width: 100px;text-align: left"><span style="font-weight: bold">CPR</span>
                            </td>
                            <td class="text_into">结果</td>
                            <td class="text_edit">
                                <select id="preaidSucceed66">
                                    <option></option>
                                    <option value="1">成功</option>
                                    <option value="2">未成功</option>
                                </select>
                            </td>
                            <td class="text_into">复苏情况</td>
                            <td class="text_edit">
                                ${reason66}
                            </td>
                            <td class="text_into">病人状态</td>
                            <td class="text_edit">
                                <select id="patientStat">
                                    <option></option>
                                    <option value="1">濒死</option>
                                    <option value="2">临床死亡</option>
                                    <option value="3">不可逆死亡</option>
                                </select>
                            </td>
                        </tr>
                        <tr id="call67">
                            <td class="text_into" style="width: 100px;text-align: left"><span style="font-weight: bold">气管插管</span>
                            </td>
                            <td class="text_into">结果</td>
                            <td class="text_edit">
                                <select id="preaidSucceed67">
                                    <option></option>
                                    <option value="1">成功</option>
                                    <option value="2">未成功</option>
                                </select>
                            </td>
                            <td class="text_into">未成功原因</td>
                            <td class="text_edit">
                                ${reason67}
                            </td>
                        </tr>
                    </table>
                </td>
            </tr>
            <tr>
                <th class="text_decollator" id="otherSenRcd">
                    <span>其他处理措施</span>
                </th>
            </tr>
            <tr group="otherSenRcd">
                <td><textarea class="textarea_full"
                              style="width: 100%" id="senRcdOther" name="senRcdOther"
                              placeholder="其他处理措施：2000字内">${misEmrPreaidVs.senRcdOther}</textarea></td>
            </tr>
            <!-- 		药物应用 -->
            <tr>
                <th class="text_decollator" id="thSenDrg">
                    <span>药物应用</span>
                    <button class="btn btn_yellow" type="button" id="addDrug">
                        添加药物应用
                    </button>
                </th>
            </tr>
            <tr>
                <td style="display:none;"><textarea
                        style="width: 100%" id="sceneDrugText"
                        name="sceneDrugText" placeholder="点击右侧按钮选择！" readonly="readonly"></textarea>
                </td>
                <td id="senceDrugMar">

                </td>
            </tr>
            <tr group="thSenDrg">
                <td>
                    <div id="senceDrugListTd" width="100%">
                    </div>
                </td>
            </tr>
            <tr group="thSenDrg">
                <td>
				<textarea class="textarea_full"
                          style="width: 100%" id="drugOther" name="drugOther"
                          placeholder="其他药物应用：400字内"><c:choose><c:when
                        test="${misEmrPreaidVs.drugOther==null||misEmrPreaidVs.drugOther==''}">无</c:when><c:otherwise>${misEmrPreaidVs.drugOther}</c:otherwise></c:choose></textarea>
                </td>
            </tr>

            <!-- 		耗材应用 -->
            <tr>
                <th class="text_decollator" id="thSenAar">
                    <span>耗材使用</span>
                    <button class="btn btn_yellow" type="button" id="addAar">
                        添加耗材使用
                    </button>
                </th>
            </tr>
            <tr>
                <td style="display:none;"><textarea
                        style="width: 100%" id="sceneAarText"
                        name="sceneAarText" placeholder="点击右侧按钮选择！" readonly="readonly"></textarea>
                    <input id="sceneAar" name="sceneAar" class="debugMode${deBugMode}"
                           readonly="readonly">
                </td>
                <td id="senceAarMar">

                </td>
            </tr>
            <tr group="thSenAar">
                <td>
                    <div id="senceAarListTd" width="100%">
                    </div>
                </td>
            </tr>
            <tr group="thSenAar">
                <td>
				<textarea class="textarea_full"
                          style="width: 100%" id="aarOther" name="aarOther"
                          placeholder="其他药物应用：400字内"><c:choose><c:when
                        test="${misEmrPreaidVs.aarOther==null||misEmrPreaidVs.aarOther==''}">无</c:when><c:otherwise>${misEmrPreaidVs.aarOther}</c:otherwise></c:choose></textarea>
                </td>
            </tr>
            <!-- 		耗材应用 （以上）-->

            <tr>
                <th class="text_decollator" id="thSenRcd">
                    <span>院前急救病情记录</span>
                </th>
            </tr>
            <tr group="thSenRcd">
                <td>
				<textarea class="textarea_full"
                          style="width: 100%;height: 200px" id="sceneRecord" name="sceneRecord"
                          placeholder="抢救记录（针对现场抢救、复苏未成功或给予抢救未接回医院等）：2000字内">${misEmrPreaidVs.sceneRecord}</textarea>
                </td>
            </tr>
        </table>


        <table width="100%" border="0" class="editForm">
            <tr>
                <td class="text_into">医生</td>
                <td class="text_edit">
                    ${doctorSign }
                </td>
                <td class="text_into">护士</td>
                <td class="text_edit">
                    ${nurseSign}
                </td>
                <td class="text_edit">日期</td>
                <td class="text_edit">
                    <input id="signDate" name="signDate"
                           class="" type="text" value="" style="90%"
                           onfocus="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})"></td>
            </tr>
        </table>
    </form>
</div>


<div style="text-align:center;">
    <button type="button" id="saveVs" class="btn">保存</button>
    <button type="button" class="btn commitButton" style="margin-left:150px;">提交</button>
</div>
