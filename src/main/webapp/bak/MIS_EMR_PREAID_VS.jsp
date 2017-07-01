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
                    <input id="sceneDrug" name="sceneDrug" class="debugMode${deBugMode}"
                           readonly="readonly">
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
                          placeholder="其他药物应用：400字内">
					<c:choose>
                        <c:when test="${misEmrPreaidVs.drugOther==null||misEmrPreaidVs.drugOther==''}">无</c:when>
                        <c:otherwise>${misEmrPreaidVs.drugOther}</c:otherwise>
                    </c:choose>
				</textarea>
                </td>
            </tr>


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
            <!-- 		<tr style="display: none;"> -->
            <!-- 			<th  class="text_decollator" style="cursor: pointer;background-color: #9E9E9E;" id="itwDiv"><span>途中病情变化</span></th> -->
            <!-- 		</tr> -->
        </table>

        <!-- 	<div id="itwHideDiv" style="display: none;"> -->
        <!-- 		<table width="100%" border="0" class="editForm"> -->
        <!-- 			<tr> -->
        <!-- 				<th class="text_decollator" id="thItw"> -->
        <!-- 					<span>途中处理措施</span> -->
        <!-- 					<button type="button"  class="btn btn_yellow"  -->
        <!-- 						onclick="open_layer('选择途中处理措施','${ctx}/misEmrPreaidVs.do?method=findSceneTreatlects&flag=itwTreat&values=${misEmrPreaidVs.itwTreat}')"> -->
        <!-- 					添加处理措施</button> -->
        <!-- 				</th> -->
        <!-- 			</tr> -->
        <!-- 			<tr group="thItw"> -->
        <!-- 				<td><textarea -->
        <!-- 						style="width: 100%"  id="itwTreatText" name="itwTreatText" -->
        <!-- 						placeholder="点击右侧按钮选择！" readonly="readonly"></textarea> <input -->
        <!-- 					id="itwTreat" name="itwTreat" class="debugMode${deBugMode}" -->
        <!-- 					readonly="readonly"></td> -->
        <!-- 			</tr> -->
        <!-- 			<tr> -->
        <!-- 				<th class="text_decollator" id="itwDrugTh"><span>途中药物应用</span> -->
        <!-- 					<button class="btn btn_yellow" type="button" -->
        <!-- 						onclick="open_layer('选择途中药物应用','${ctx}/misEmrPreaidVs.do?method=findSceneDrugSelects&flag=itwDrug&values=${misEmrPreaidVs.itwDrug}')"> -->
        <!-- 						添加药物应用</button> -->
        <!-- 				</th> -->
        <!-- 			</tr> -->
        <!-- 			<tr group="itwDrugTh"> -->
        <!-- 				<td style="display: none;"> -->
        <!-- 					<textarea style="width: 100%"  id="itwDrugText" name="itwDrugText" -->
        <!-- 						placeholder="点击右侧按钮选择！" readonly="readonly"></textarea>  -->
        <!-- 					<input id="itwDrug" name="itwDrug" class="debugMode${deBugMode}" readonly="readonly"> -->
        <!-- 				</td> -->
        <!-- 				<td style="vertical-align:bottom;text-align:center" id="itwDrugMar"> -->

        <!-- 				</td>	 -->
        <!-- 			</tr> -->
        <!-- 			<tr group="itwDrugTh"> -->
        <!-- 				<td> -->
        <!-- 					<iframe id="itwDrugListTd" src='' width="100%">  -->
        <!-- 					</iframe> -->
        <!-- 				</td> -->
        <!-- 			</tr> -->
        <!-- 			<tr> -->
        <!-- 				<th class="text_decollator" id="itwRec"><span>途中抢救记录</span></th> -->
        <!-- 			</tr> -->
        <!-- 			<tr group="itwRec"> -->
        <!-- 				<td><textarea class="textarea_full" -->
        <!-- 						id="itwRecord" name="itwRecord" -->
        <!-- 						placeholder="途中抢救记录（针对现场抢救、复苏未成功或给予抢救未接回医院等）：2000字内">${misEmrPreaidVs.itwRecord}</textarea></td> -->
        <!-- 			</tr> -->
        <!-- 		</table> -->
        <!-- 	</div> -->

        <!-- 	<table width="100%" border="0" class="editForm" style="display: none;"> -->
        <!-- 		<tr> -->
        <!-- 			<th  class="text_decollator"><span>到达医院时的病情记录</span></th> -->
        <!-- 		</tr> -->
        <!-- 		<tr> -->
        <!-- 			<td><textarea class="textarea_full" -->
        <!-- 					 id="arrivalVs" name="arrivalVs" -->
        <!-- 					placeholder="到达医院时的生命体征"></textarea></td> -->
        <!-- 		</tr> -->
        <!-- 	</table> -->

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


<div class="commitStyle${misEmrBasicinfo.isCommitted}" style="text-align:center;">
    <button type="button" id="saveVs" class="btn">保存</button>
    <button type="button" class="btn commitButton" style="margin-left:150px;">提交</button>
</div>
