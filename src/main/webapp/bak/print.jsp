<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@ include file="/taglibs.jsp" %>
<!-- 初始化赋值 -->
<%@ include file="/businit/aValueInit.jsp" %>
<!-- 页面选择器 -->
<%@ include file="/business/aChooser.jsp" %>
<!DOCTYPE>
<html>
<head>
    <title>郑州市120急救电子病历</title>
    <script type="text/javascript">
        /**
         $(document).ready(function(){
				$("input").each(function (){
					console.log($(this).attr("id"));
					$(this).attr("disabled",true);
				});
			});
         **/
    </script>
</head>
<body title="CTRL+P进行打印">
<button class="btn btn_yellow" onclick="javascript:window.print()">打印</button>
<h2>郑州市急救中心院前电子病历</h2>
<table widtd="700" border="1" class="editForm_BL"><!-- 	基础信息 -->
    <tr>
        <td>
            <table width="100%" border="0" class="editForm">
                <tr>
                    <td class="text_into" width="50px">
                        <nobr>出车时间
                    </td>
                    <td class="text_edit" width="183px">
                        <nobr>
                        <fmt:formatDate value="${vAcceptAmbulOutdInfo.ccsj }" pattern="yyyy-MM-dd hh:mm:ss" type="date"
                                        dateStyle="long"/></td>
                    <td class="text_into" width="50px">
                        <nobr>到场时间
                    </td>
                    <td class="text_edit" width="183px">
                        <nobr>
                        <fmt:formatDate value="${vAcceptAmbulOutdInfo.ddxcsj }" pattern="yyyy-MM-dd hh:mm:ss"
                                        type="date" dateStyle="long"/></td>
                    <td class="text_into" width="50px">
                        <nobr>电话
                    </td>
                    <td class="text_edit" width="183px">${vAcceptAmbulOutdInfo.lxdh }</td>
                </tr>
                <tr>
                    <td class="text_into">
                        <nobr>离场时间
                    </td>
                    <td class="text_edit">
                        <nobr>
                        <fmt:formatDate value="${vAcceptAmbulOutdInfo.scsj }" pattern="yyyy-MM-dd hh:mm:ss" type="date"
                                        dateStyle="long"/></td>
                    <td class="text_into">
                        <nobr>入院时间
                    </td>
                    <td class="text_edit">
                        <nobr>
                        <fmt:formatDate value="${vAcceptAmbulOutdInfo.swsj }" pattern="yyyy-MM-dd hh:mm:ss" type="date"
                                        dateStyle="long"/></td>
                    <td class="text_into">联系人</td>
                    <td class="text_edit">${vAcceptAmbulOutdInfo.hzxm }</td>
                </tr>
                <tr>
                    <td class="text_into">病人身边</td>
                    <td class="text_edit"><fmt:formatDate value="${vAcceptAmbulOutdInfo.ddbrsbsj }"
                                                          pattern="yyyy-MM-dd hh:mm:ss" type="date"
                                                          dateStyle="long"/></td>
                    <td class="text_into">救治地点</td>
                    <td class="text_edit" colspan="3">${vAcceptAmbulOutdInfo.jcdz }</td>
                </tr>
            </table>
        </td>
    </tr>
    <tr>
        <td>
            <table width="100%" border="0" class="editForm">
                <tr group="basicInfo">
                    <td class="text_into" width="50px">姓名</td>
                    <td class="text_edit"><input class="input_full" type="text" name="name" id="name" value=""></td>
                    <td class="text_into">性别</td>
                    <td class="text_edit">${sex}</td>
                    <td class="text_into">年龄</td>
                    <td class="text_edit" style="word-break: keep-all;">
                        <nobr>
                            <input style="width:40px;" type="text" placeholder="年龄" id="age" name="age">
                            <select id="timeScope">
                                <option value="1">分</option>
                                <option value="60">时</option>
                                <option value="1440">天</option>
                                <option value="43200">月</option>
                                <option value="518400">岁</option>
                            </select>
                        </nobr>
                    </td>
                    <td class="text_into">年龄（段）</td>
                    <td class="text_edit">
                        ${stage}
                    </td>
                </tr>
                <tr group="basicInfo">
                    <td class="text_into">身份证</td>
                    <td class="text_edit"><input class="input_full" type="text"
                                                 id="idCard" name="idCard"></td>
                    <td class="text_into">民族</td>
                    <td class="text_edit">${ethnic}</td>
                    <td class="text_into">国籍</td>
                    <td class="text_edit">${nation }</td>
                </tr>
                <tr group="basicInfo">
                    <td class="text_into">病史提供人</td>
                    <td class="text_edit">${hxProvider}</td>
                    <td class="text_into">现场环境</td>
                    <td class="text_edit">${spot}</td>
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
                    <td class="text_into">送院</td>
                    <td class="text_edit">
                        <select id="hostat">
                            <option value="1">送本院</option>
                            <option value="60">其他</option>
                            <option value="1440">未送</option>
                        </select>
                    </td>
                    <td class="text_into">送往地点</td>
                    <td class="text_edit">${sentTo }</td>
                </tr>
                <tr group="basicInfo">
                    <td class="text_into">主诉</td>
                    <td class="text_edit" colspan="9"><input class="input_full"
                                                             type="text" placeholder="少于20字" id="chiefComplaint"
                                                             name="chiefComplaint"></td>
                </tr>
                <tr group="basicInfo">
                    <td class="text_into">现病史</td>
                    <td class="text_edit" colspan="9"><input class="input_full"
                                                             type="text" id="presentHx" name="presentHx"></td>
                </tr>
                <tr group="disHistory">
                    <td class="text_into">既往病史</td>
                    <td class="text_edit" colspan="6">${pastHx}</td>
                </tr>
                <tr group="disHistory" hideGroup="pastHx">
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
                <tr group="disHistory" hideGroup="pastHx">
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
                <tr group="disHistory" hideGroup="pastHx">
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
                <tr group="disHistory" hideGroup="pastHx">
                    <td class="text_into">其他病史</td>
                    <td class="text_edit" colspan="9"><input class="input_full"
                                                             id="otherHx" name="otherHx" type="text"></td>
                </tr>
                <tr group="disHistory">
                    <td class="text_into">药物过敏</td>
                    <td class="text_edit">${drugAllergy}</td>
                    <td class="text_into">药物名称</td>
                    <td class="text_edit" colspan="7"><input class="input_full"
                                                             name="drugName" id="drugName" type="text"></td>
                </tr>
            </table>
        </td>
    </tr>
    <tr>
        <td>
            <!-- 				体格检查 -->
            <table width="100%" border="0" class="editForm">
                <tr group="normalAndLife">
                    <td class="text_into" width="48px">体温</td>
                    <td class="text_edit" style="word-break: keep-all;">
                        ${tTest}
                        <input class="" style="width:36px;" type="text" name="t" id="t" value="${misEmrPe.t}"
                               placeholder="温度"> ℃
                    </td>
                    <td class="text_into">P</td>
                    <td class="text_edit" style="word-break: keep-all;">
                        ${pTest}
                        <input class="" style="width:36px;" type="text" name="p" id="p" value="${misEmrPe.p}"
                               placeholder="脉搏">次/分
                    </td>
                    <td class="text_into">R</td>
                    <td class="text_edit" style="word-break: keep-all;">
                        ${rTest}
                        <input class="" style="width:36px;" type="text" name="r" id="r" value="${misEmrPe.r}"
                               placeholder="0-50">次/分
                    </td>
                    <td class="text_into">BP</td>
                    <td class="text_edit">
                        <nobr>
                            <input class="input_NOfull" style="width:60px;" type="text" name="pe-bpL" placeholder="血压值"
                                   id="pe-bpL" value="${misEmrPe.bpL}">
                            /
                            <input class="input_NOfull" style="width:60px;" type="text" name="pe-bpH" placeholder="血压值"
                                   id="pe-bpH" value="${misEmrPe.bpH}">
                            mmHg
                        </nobr>
                    </td>
                </tr>
                <tr group="normalAndLife">
                    <td class="text_into">体位</td>
                    <td class="text_edit">${posture}</td>
                    <td class="text_into">神志</td>
                    <td class="text_edit">${conscious}</td>
                    <td class="text_into">皮肤</td>
                    <td class="text_edit">${skin}</td>
                    <td class="text_into">口唇紫绀</td>
                    <td class="text_edit">${cyanosis}</td>
                </tr>
                <tr group="headAndNeck">
                    <td class="text_into">左侧瞳孔</td>
                    <td class="text_edit">${hnEyeTestL }
                        <input class="" style="width:36px;" type="text" name="hnEyeL" id="hnEyeL"
                               value="${misEmrPe.hnEyeL}">mm
                    </td>
                    <td class="text_into">对光反射</td>
                    <td class="text_edit">${hnPlrL }</td>
                    <td class="text_into">右侧瞳孔</td>
                    <td class="text_edit">${hnEyeTestR }
                        <input class="" style="width:36px;" type="text" name="hnEyeR" id="hnEyeR"
                               value="${misEmrPe.hnEyeR}">mm
                    </td>
                    <td class="text_into">对光反射</td>
                    <td class="text_edit">${hnPlrR }</td>
                </tr>
                <tr group="headAndNeck">
                    <td class="text_into">颈部</td>
                    <td class="text_edit">${hnNeck }</td>
                    <td class="text_into">压痛部位</td>
                    <td class="text_edit"><input class="input_full" type="text" id="hnTender" name="hnTender">
                    </td>
                    <td class="text_into">其他</td>
                    <td class="text_edit" colspan="3"><input class="input_full" type="text" id="hnOther" name="hnOther">
                    </td>
                </tr>
                <tr group="chest">
                    <td class="text_into">胸廓</td>
                    <td colspan="7" style="vertical-align:bottom;text-align:center;">
                        <textarea style="width: 99%" id="chestThoraxText" name="chestThoraxText" placeholder="无内容"
                                  readonly="readonly"></textarea>
                        <input id="chestThorax" name="chestThorax" value="" readonly="readonly"
                               class="debugMode${deBugMode}">
                    </td>
                </tr>
                <tr group="chest">
                    <td class="text_into">有无压痛</td>
                    <td class="text_edit">${chestTender }</td>
                    <td class="text_into">其他</td>
                    <td class="text_edit" colspan="5"><input class="input_full" type="text" id="chestOther"
                                                             name="chestOther"></td>
                </tr>
                <tr group="lung">
                    <td class="text_into">左侧:呼吸音</td>
                    <td class="text_edit">${lungBsL }</td>
                    <td class="text_into">啰音</td>
                    <td class="text_edit">${lungRL}</td>
                    <td class="text_into">右侧:呼吸音</td>
                    <td class="text_edit">${lungBsR }</td>
                    <td class="text_into">啰音</td>
                    <td class="text_edit">${lungRR }</td>
                </tr>
                <tr group="lung">
                    <td class="text_into">其他</td>
                    <td class="text_edit" colspan="7">
                        <input class="input_full" type="text" id="lungOther" name="lungOther">
                    </td>
                </tr>
                <tr group="heart">
                    <td class="text_into">心率</td>
                    <td class="text_edit"><input class="input_NOfull" style="width: 60px;" type="text" id="hrtRate"
                                                 name="hrtRate">次/分
                    </td>
                    <td class="text_into">心律</td>
                    <td class="text_edit">${hrtRhythm }</td>
                    <td class="text_into">心音</td>
                    <td class="text_edit">${hrtSound }</td>
                    <td class="text_into">杂音</td>
                    <td class="text_edit">${hrtMurmur }</td>
                </tr>
                <tr group="heart">
                    <td class="text_into">其他</td>
                    <td class="text_edit" colspan="7"><input class="input_full" type="text" id="hrtOther"
                                                             name="hrtOther">
                    </td>
                </tr>
                <tr group="abd">
                    <td class="text_into">腹部</td>
                    <td class="text_edit">${abdAbd }</td>
                    <td class="text_into">腹壁</td>
                    <td class="text_edit">${abdWall }</td>
                    <td class="text_into">压痛</td>
                    <td class="text_edit">${abdTender }</td>
                    <td class="text_into">反跳痛</td>
                    <td class="text_edit">${abdRebt }</td>
                </tr>
                <tr group="abd">
                    <td class="text_into">肝脏</td>
                    <td class="text_edit">${abdLiver }</td>
                    <td class="text_into">肝脏大小</td>
                    <td class="text_edit">
                        <input class="input_full" type="text" id="abdLiverSize" name="abdLiverSize">
                    </td>
                    <td class="text_into">脾脏</td>
                    <td class="text_edit">${abdSpleen }</td>
                    <td class="text_into">脾脏大小</td>
                    <td class="text_edit">
                        <input class="input_full" type="text" id="abdSplSize" name="abdSplSize">
                    </td>
                </tr>
                <tr group="abd">
                    <td class="text_into">肠鸣音</td>
                    <td class="text_edit">${abdBs }</td>
                    <td class="text_into">其他</td>
                    <td class="text_edit" colspan="5"><input class="input_full" type="text" id="abdOther"
                                                             name="abdOther"></td>
                </tr>
                <tr style="display: none;">
                    <th class="text_decollator" colspan="8">四肢</th>
                </tr>
                <tr style="display: none;">
                    <td class="text_into">其他</td>
                    <td class="text_edit" colspan="7">
                        <input class="input_full" type="hidden" id="limbOther" name="limbOther">
                    </td>
                </tr>
                <tr group="spn">
                    <td class="text_into">脊柱</td>
                    <td class="text_edit">${spine }</td>
                    <td class="text_into">具体内容</td>
                    <td class="text_edit" colspan="5"><input class="input_full" type="text" id="spnOther"
                                                             name="spnOther"></td>
                </tr>
                <tr group="ner">
                    <td class="text_into">生理反射</td>
                    <td class="text_edit">${nrPr }</td>
                    <td class="text_into">巴彬斯基征</td>
                    <td class="text_edit">${nrBabinski }</td>
                    <td class="text_into">脑膜刺激征</td>
                    <td class="text_edit">${nrMes }</td>
                </tr>
                <tr group="ner">
                    <td class="text_into">肌力</td>
                    <td class="text_edit">
                        ${limbMsTest}
                    </td>
                    <td class="text_edit" colspan="6">
                        <input class="input_full" type="text" id="limbMs" name="limbMs" placeholder="左右肢肌力 检查情况，可写50字">
                    </td>
                </tr>
                <tr group="ner">
                    <td class="text_into">肌张力</td>
                    <td class="text_edit">
                        ${limbMfTest }
                    </td>
                    <td class="text_edit" colspan="6">
                        <input class="input_full" type="text" id="limbMf" name="limbMf" placeholder="左右肢肌张力 检查情况，可写50字">
                    </td>
                </tr>
                <tr group="ner">
                    <td class="text_into">水肿</td>
                    <td class="text_edit">
                        ${limbEdemaTest}
                    </td>
                    <td class="text_edit" colspan="6">
                        <input class="input_full" type="text" id="limbEdema" name="limbEdema"
                               placeholder="左右肢水肿检查情况，可写50字"></td>
                </tr>

                <tr group="ner" style="display: none;">
                    <td class="text_into">四肢肌力（级）</td>
                    <td class="text_edit"><input class="input_full" type="text" id="limbMs" name="limbMsZZZZ"></td>
                    <td class="text_into">四肢肌张力（级）</td>
                    <td class="text_edit"><input class="input_full" type="text" id="limbMf" name="limbMfZZZZ"></td>
                    <td class="text_into">双下肢水肿</td>
                    <td class="text_edit">${limbEdemaBle }</td>
                </tr>
                <tr group="ner" style="display: none;">
                    <td class="text_into">左侧肢体肌力（级）</td>
                    <td class="text_edit"><input class="input_full" type="text" id="limbMsL" name="limbMsL"></td>
                    <td class="text_into">左上肢肌力（级）</td>
                    <td class="text_edit"><input class="input_full" type="text" id="limbMsLue" name="limbMsLue"></td>
                    <td class="text_into">左下肢肌力（级）</td>
                    <td class="text_edit"><input class="input_full" type="text" id="limbMsLle" name="limbMsLle"></td>
                    <td class="text_into">左下肢水肿</td>
                    <td class="text_edit">${limbEdemaLle }</td>
                </tr>
                <tr group="ner" style="display: none;">
                    <td class="text_into">右侧肢体肌力（级）</td>
                    <td class="text_edit"><input class="input_full" type="text" id="limbMsR" name="limbMsR"></td>
                    <td class="text_into">右上肢肌力（级）</td>
                    <td class="text_edit"><input class="input_full" type="text" id="limbMsRue" name="limbMsRue"></td>
                    <td class="text_into">右下肢肌力（级）</td>
                    <td class="text_edit"><input class="input_full" type="text" id="limbMsRle" name="limbMsRle"></td>
                    <td class="text_into">右下肢水肿</td>
                    <td class="text_edit">${limbEdemaRle }</td>
                </tr>
                <tr group="ner">
                    <td class="text_into">其他</td>
                    <td class="text_edit" colspan="7">
                        <input class="input_full" type="text" id="nrOther" name="nrOther">
                    </td>
                </tr>
            </table>
        </td>
    </tr>
    <tr>
        <td>
            <!-- 					PHI/GCS -->
        </td>
    </tr>
</table>
<button class="btn btn_yellow" onclick="javascript:window.print()">打印</button>
</body>
</html>
