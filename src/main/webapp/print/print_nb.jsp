<!DOCTYPE html>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@ page import="com.zxit.share.Constants" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<html>
<head>
    <title>${systemConfig.systemTitle }</title>
    <link rel="stylesheet" href="${ctx}/css/print/Style/bootstrap.css">
    <link rel="stylesheet" href="${ctx}/css/print/Style/table.css">
    <script src="${ctx}/js/jquery-2.1.1.min.js"></script>
    <script type="text/javascript">
        $(document).ready(function () {
            //处理年龄
            var scope = parseTimeToAge('${misEmrBasicinfo.age}');//年龄计算。先算出是哪个范围
            if ('${misEmrBasicinfo.age}' != 0) {
                //alert();
                //基础信息
                custom_options($("#timeScope"), scope);
                custom_options($("#age"), ('${misEmrBasicinfo.age}' / scope));//然后相除并四舍五入
                //
                custom_options($("#timeScope2"), scope);
                custom_options($("#age2"), ('${misEmrBasicinfo.age}' / scope));//然后相除并四舍五入
            } else if ('${misEmrBasicinfo.age}' == 0 && '${stage}' != "") {
                //alert(1);
                //alert('${stage}');
                custom_options($("#age"), '${stage}');
                custom_options($("#age2"), '${stage}');
            } else {
                //alert(2);
                custom_options($("#age"), '未知');
                custom_options($("#age2"), '未知');
            }


            var initValue = "";
            //心电图
            initValue = '${misEmrAe.ecgDiag}';
            $.ajax({
                contentType: "application/x-www-form-urlencoded; charset=utf-8",
                url: "${ctx}/misEmrAe.do?method=findMisEmrAeInnerDiag&str=" + initValue,
                type: "get",
                success: function (data) {
                    $("#ecgDiagText").html(data);
                }
            });

            //初步诊断
            /**
             initValue = '${misEmrPreaidVs.primDiag}';
             $.ajax({
			contentType: "application/x-www-form-urlencoded; charset=utf-8",
			url : "${ctx}/misEmrPreaidVs.do?method=findPrimDiagText&str="+initValue,
			type : "get",
			success : function(data) {
				$("#primDiagText").html(data);
			}
		});
             **/

            //处理措施
            initValue = '${misEmrPreaidVs.sceneTreat}';
            $.ajax({
                contentType: "application/x-www-form-urlencoded; charset=utf-8",
                url: "${ctx}/misEmrPreaidVs.do?method=findMisEmrPreaidVsSceneTreatText&str=" + initValue,
                type: "get",
                success: function (data) {
                    $("#sceneTreatText").html(data);//VS
                }
            });

        });

        //年龄转化
        function parseTimeToAge(ageValue) {
            var flag = null;
            var min = 1;
            var hour = 60;
            var day = 1440;
            var month = 43200;
            var year = 518400;
            if (ageValue / year % 1 === 0) {
                return year;
            } else if (ageValue / month % 1 === 0) {
                return month;
            } else if (ageValue / day % 1 === 0) {
                return day;
            } else if (ageValue / hour % 1 === 0) {
                return hour;
            }
            else {
                return min;
            }
            return flag;
        }

        /**
         * @param obj
         * @param l_v
         */
        function custom_options(obj, l_v) {
            var objId = obj.attr("id");
            if (typeof(objId) != "undefined") {
                var type = obj[0].tagName; //从jQuery对象中得到原生的DOM对象判断他是个啥
                obj.val(l_v);
            }
        }
    </script>
</head>
<body>
<div id="page1" class="page" style="page-break-after:always">
    <div class="table-title center strong">${systemConfig.printTitle}院前急救病历</div>
    <div class="table-subtitle strong special center">
        <span class="noborder" style="width:45%">${hosName}</span>
        <span class="noborder" style="width:20%">
					<fmt:formatDate
                            value="${vAcceptAmbulOutdInfo.ccsj }"
                            pattern="yyyy年MM月dd日" type="date" dateStyle="long"/>
			</span>
        <span class="noborder" style="width:35%">编号：${emrCode}
						</span>
    </div>
    <table class="printtable">
        <!-- 			<tr> -->
        <!-- 				<td colspan="5" class="special"> -->
        <!-- 					<span style="width:20%">出车时间：</span> -->
        <!-- 					<span style="width:20%">到达现场时间：</span> -->
        <!-- 					<span style="width:20%">到达病人时间：</span> -->
        <!-- 					<span style="width:20%">离现场时间：</span> -->
        <!-- 					<span style="width:20%" class="noborder">接入医院时间：</span> -->
        <!-- 				</td>		 -->
        <!-- 			</tr> -->
        <tr>
            <td colspan="5" class="special">
                <span style="width:15%">姓名：${misEmrBasicinfo.name}</span>
                <span style="width:15%">性别：${sex}</span>
                <span style="width:20%">年龄：
						<input style="width:30px;border: 0px;" type="text" id="age" name="age">
						<select id="timeScope">
							<option>&nbsp;</option>
							<option value="1">分</option>
							<option value="60">时</option>
							<option value="1440">天</option>
							<option value="43200">月</option>
							<option value="518400">岁</option>
						</select>
					</span>
                <span style="width:50%" class="noborder">救治地点：${misEmrBasicinfo.address }</span>
            </td>
        </tr>
        <tr>
            <td colspan="5" class="special">
                <span style="width:15%">民族：${ethnic}</span>
                <span style="width:15%">国籍：${nation}</span>
                <span style="width:30%">病史提供人：${hxProvider}</span>
                <span style="width:40%"
                      class="noborder">联系人及电话：${misEmrBasicinfo.contact}${misEmrBasicinfo.phone}</span>
            </td>
        </tr>
        <tr>
            <td colspan="5" class="special">
                <span style="width:25%">呼救原因：${cause}</span>
                <span style="width:40%">疾病类型：${diseaseType}</span>
                <span style="width:15%">病情：${condition}</span>
                <span style="width:20%" class="noborder">现场环境：${spot}</span>
            </td>
        </tr>
        <tr>
            <td colspan="2">送达地点：
                <c:choose>
                    <c:when test="${misEmrBasicinfo.isHosptial=='1'}">
                        未送院
                    </c:when>
                    <c:otherwise>
                        ${sentTo}
                    </c:otherwise>
                </c:choose>
            </td>
            <td colspan="2">身份证号码：${misEmrBasicinfo.idCard}</td>
            <td>救治结果：${preEmcResult}</td>
        </tr>
        <tr>
            <td colspan="5" class="strong ">主&nbsp诉：${misEmrBasicinfo.chiefComplaint}</td>
        </tr>
        <tr>
            <td class="strong center">现病史</td>
            <td colspan="4" class="notsolid-top noborder-bottom">${misEmrBasicinfo.presentHx}</td>
        </tr>
        <tr class="notsolid-bottom">
            <td class="strong center">既往史</td>
            <td colspan="4" class="notsolid-bottom">${pastHx }
                <c:if test="${pastHx  == '有'}">
                    &nbsp;&nbsp;病史：${misEmrBasicinfo.otherHx}
                </c:if>
            </td>
        </tr>

        <tr>
            <td class="center strong">
                <nobr>药物过敏史</nobr>
            </td>
            <td class="left" colspan="4">${drugAllergy }&nbsp;&nbsp;&nbsp;&nbsp;
                <c:if test="${drugAllergy  == '有'}">
                    药物名称：${misEmrBasicinfo.drugName }
                </c:if>
            </td>
        </tr>
        <tr>
            <td colspan="5" class="strong center">体格检查</td>
        </tr>
        <tr>
            <td class="norightborder center" style="border-right: 1px solid !important;" colspan="5">
                T&nbsp
                <c:choose>
                    <c:when test="${misEmrPe.t!=null}">
                        ${misEmrPe.t}℃
                    </c:when>
                    <c:otherwise>
                        ${tTest }
                    </c:otherwise>
                </c:choose>
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                P&nbsp
                <c:choose>
                    <c:when test="${misEmrPe.p!=null}">
                        ${misEmrPe.p}次/分
                    </c:when>
                    <c:otherwise>
                        ${pTest }
                    </c:otherwise>
                </c:choose>
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                R&nbsp
                <c:choose>
                    <c:when test="${misEmrPe.r!=null}">
                        ${misEmrPe.r}次/分
                    </c:when>
                    <c:otherwise>
                        ${rTest }
                    </c:otherwise>
                </c:choose>
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                BP&nbsp
                <c:choose>
                    <c:when test="${misEmrPe.bpL!=null&&misEmrPe.bpH!=null}">
                        ${misEmrPe.bpL} / ${misEmrPe.bpH}&nbsp&nbspmmHg
                    </c:when>
                    <c:otherwise>
                        ${bpTest }
                    </c:otherwise>
                </c:choose>
            </td>
        </tr>
        <tr>
            <td class="norightborder center" style="border-right: 1px solid !important;" colspan="5">
                体位：${posture} &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                神志：${conscious } &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                皮肤：${skin } &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;口唇紫绀：${cyanosis } </td>
        </tr>
        <tr class="notsolid-bottom">
            <td rowspan="2" class="strong center">头颈部</td>
            <td class="notsolid-bottom notsolid-right">
                左侧瞳孔:
                <c:choose>
                    <c:when test="${hnEyeTestL=='已查'||misEmrPe.hnEyeL!=null }">
                        ${misEmrPe.hnEyeL }mm
                    </c:when>
                    <c:otherwise>
                        ${hnEyeTestL }
                    </c:otherwise>
                </c:choose>
            </td>
            <td class="notsolid-bottom notsolid-right">对光反射:${hnPlrL}</td>
            <td class="notsolid-bottom notsolid-right">
                右侧瞳孔:
                <c:choose>
                    <c:when test="${hnEyeTestR=='已查'||misEmrPe.hnEyeR!=null }">
                        ${misEmrPe.hnEyeR }mm
                    </c:when>
                    <c:otherwise>
                        ${hnEyeTestR }
                    </c:otherwise>
                </c:choose>
            </td>
            <td class="notsolid-bottom notsolid-right" style="border-right: 1px solid !important;">对光反射:${hnPlrR }</td>
        </tr>
        <tr class="notsolid-top">
            <td colspan="4" class="notsolid-top">${misEmrPe.headNeck }</td>
        </tr>
        <tr class="noborder-bottom">
            <td rowspan="2" class="strong center">胸部</td>
            <td colspan="4" class="notsolid-top noborder-bottom">${misEmrPe.chest }</td>
        </tr>
        <tr class="noborder-top">
            <td colspan="4" class="notsolid-top noborder-top">&nbsp</td>
        </tr>
        <tr class="noborder-bottom">
            <td rowspan="2" class="strong center">肺部</td>
            <td colspan="4" class="notsolid-top noborder-bottom">${misEmrPe.lung }</td>
        </tr>
        <tr class="noborder-top">
            <td colspan="4" class="notsolid-top noborder-top">&nbsp</td>
        </tr>
        <tr class="noborder-bottom">
            <td rowspan="2" class="strong center">心脏</td>
            <td colspan="4" class="notsolid-top noborder-bottom">${misEmrPe.heart }</td>
        </tr>
        <tr class="noborder-top">
            <td colspan="4" class="notsolid-top noborder-top">&nbsp</td>
        </tr>
        <tr class="noborder-bottom">
            <td rowspan="2" class="strong center">腹部</td>
            <td colspan="4" class="notsolid-top noborder-bottom">${misEmrPe.abdomen }</td>
        </tr>
        <tr class="noborder-top">
            <td colspan="4" class="notsolid-top noborder-top">&nbsp</td>
        </tr>
        <tr class="notsolid-bottom">
            <td rowspan="2" class="strong center">脊柱及四肢</td>
            <td colspan="4" class="notsolid-top notsolid-bottom">脊柱：${misEmrPe.spine }</td>
        </tr>
        <tr class="notsolid-top">
            <td colspan="4" class="notsolid-top notsolid-top">四肢：${misEmrPe.limb }</td>
        </tr>
        <tr class="notsolid-bottom">
            <td class="strong center">神经系统</td>
            <td colspan="4" class="notsolid-top notsolid-bottom">${misEmrPe.nerveReflex }</td>
        </tr>
        <tr class="noborder-bottom">
            <td class="strong center">其他</td>
            <td colspan="4" class="notsolid-top noborder-bottom">${misEmrPe.peOthers }</td>
        </tr>
        <tr>
            <td rowspan="2" class="strong center">辅助检查</td>
            <td class="notsolid-right">
                快速血糖值：
                <c:choose>
                    <c:when test="${rbgTest=='已查'||misEmrAe.rbg!=null}">
                        ${misEmrAe.rbg }mmol/L
                    </c:when>
                    <c:otherwise>
                        ${rbgTest }
                    </c:otherwise>
                </c:choose>
            </td>
            <td class="notsolid-right">
                血氧饱和度：
                <c:choose>
                    <c:when test="${bosTest=='已查'||misEmrAe.bos!=null}">
                        ${misEmrAe.bos }%
                    </c:when>
                    <c:otherwise>
                        ${bosTest }
                    </c:otherwise>
                </c:choose>
            </td>
            <td colspan="2" class="notsolid-right" style="border-right: 1px solid !important;">
                <c:if test="${ecg=='已查'}">
                    心电图：${ecg }
                </c:if>
            </td>
        </tr>
        <tr class="notsolid-bottom">
            <td colspan="4" class="noborder" style="border-right: 1px solid !important;">
                <c:if test="${ecg=='已查'}">
                    心电图诊断：<span id="ecgDiagText"></span>${misEmrAe.ecgOther }
                    <br/>
                </c:if>
                其他辅助检查：${misEmrAe.aeOther }
            </td>
        </tr>
        <tr>
            <td rowspan="2" class="strong center">初步诊断</td>
        </tr>
        <tr>
            <td colspan="4"><span id="primDiagText">${misEmrPreaidVs.primDiagR}</span></td>
        </tr>
        <tr>
            <td rowspan="6" class="strong center">处&nbsp&nbsp理</td>
        </tr>
        <tr class="noborder">
            <td colspan="4" class="noborder" style="border-right: 1px solid !important;">处理：<span
                    id="sceneTreatText"></span></td>
        </tr>
        <tr class="noborder">
            <td colspan="4" class="noborder" style="border-right: 1px solid !important;">
                其他处理措施：${misEmrPreaidVs.senRcdOther}</td>
        </tr>
        <tr class="noborder">
            <td colspan="4">
                药物应用：<br/>
                <c:if test="${fn:length(senceDrugList) != 0}">
                    <c:forEach var="list" items="${senceDrugList}">
                        <br/>
                        <c:if test="${fn:indexOf(list.grp,'0')!='-1'}">
                            <b>${fn:replace(list.grp,'0', '')}</b>
                        </c:if>${list.name} ${list.dose} ${list.units_text}<c:if
                            test="${list.amount >= 2}">*${list.amount}</c:if>${list.usage} <c:if
                            test="${list.drip!=null&&list.drip!=''}">${list.drip}</c:if> ${list.frequency_text}
                    </c:forEach>
                </c:if>
                <c:if test="${fn:length(senceDrugList) == 0}">
                    无
                </c:if>
            </td>
        </tr>
        <tr>
            <td colspan="4">其他：${misEmrPreaidVs.drugOther}</td>
        </tr>
        <tr>
            <td colspan="5" class="special center"><span style="width:27%">医生：${doctorSign }</span>
                <span style="width:27%">护士：${nurseSign }</span> <span
                        style="width:46%;border:none">
						<fmt:formatDate
                                value="${misEmrPreaidVs.signDate }"
                                pattern="yyyy年MM月dd日  HH时mm分" type="date" dateStyle="long"/>
					</span>
            </td>
        </tr>
    </table>
    <div class="footer">
        <span class="text-left write-name">医生签名：<label></label></span>
        <span class="text-right little-font">注：<label>未盖专用章复印无效</label></span>
    </div>
</div>
<c:if test="${cause =='妊娠、围产期'}">
    <div id="page2" class="page" style="page-break-after:always;display: none;">
        <div class="table-title center strong">专&nbsp科&nbsp检&nbsp查</div>
        <br>
        <br>
        <br>
        <br>
        <c:if test="${cause =='妊娠、围产期'}"><!-- 产科 -->
        <table class="printtable">
            <tr>
                <td colspan="4" class="center">
                    产科
                </td>
            </tr>
            <tr>
                <td>见红：${bloodSee }</td>
                <td>宫缩：${uterContrac }</td>
                <td>胎膜：${caul }</td>
                <td>羊水：${amnioticFluid }</td>
            </tr>
            <tr>
                <td>胎心（次/分 ）：${misEmrSeOb.fetalHeart }</td>
                <td>宫口（CM）：${misEmrSeOb.cervix }</td>
                <td>先露：${present }</td>
                <td>其他：${misEmrSeOb.obother }</td>
            </tr>
        </table>
        </c:if>
    </div>
</c:if>

<div id="pageX" class="page" style="page-break-after:always;display: none;">
    <div class="table-title center strong">专&nbsp科&nbsp检&nbsp查</div>
    <br>
    <br>
    <br>
    <br>

    <c:if test="${misEmrSeTruma.id!=''}">
        <div class="fourfont center strong">院前指数（PHI）总分（${misEmrSeTruma.phiTotal}）</div>
        <table class="printtable">
            <tr>
                <td>呼吸：${misEmrSeTruma.phiBr}</td>
                <td>神志：${misEmrSeTruma.phiCons}</td>
            </tr>
            <tr>
                <td class="bigpadding">收缩压（mmHg)：${misEmrSeTruma.phiSbp}</td>
                <td class="bigpadding">脉率（次/分）：${misEmrSeTruma.phiPr}</td>
            </tr>
        </table>
        <br>
        <br>
    </c:if>

    <c:if test="${fn:length(misEmrSeTruma.id)!=0}">
        <div class="fourfont center strong">格拉斯哥评分（GCS）总分（${misEmrSeTruma.dglsTotal}）</div>
        <table class="printtable">
            <tr>
                <td class="bigpadding">睁眼反应：${misEmrSeTruma.dglsEr}</td>
                <td class="bigpadding">语言反应：${misEmrSeTruma.dglsVr}</td>
                <td class="bigpadding">运动反应：${misEmrSeTruma.dglsMr}</td>
            </tr>
        </table>
        <br>
        <br>
    </c:if>

    <c:if test="${fn:length(misEmrSePed.id)!=0}">
        <div class="fourfont center strong">新生儿Apgar评分</div>
        <table class="printtable">
            <tr>
                <td class="center">体征</td>
                <td class="center">评分项目</td>
                <td class="center">1分钟评分${misEmrSePed.apgar1 }</td>
                <td class="center">5分钟评分${misEmrSePed.apgar5 }</td>
                <td class="center">10分钟评分${misEmrSePe.dapgar10 }</td>
                <td class="center">15分钟评分${misEmrSePe.dapgar15}</td>
            </tr>
            <tr>
                <td class="center">皮肤颜色</td>
                <td>${misEmrSePed.apgarAp1 }</td>
                <td>${misEmrSePed.apgarAp1 }</td>
                <td>${misEmrSePed.apgarAp5 }</td>
                <td>${misEmrSePed.apgarAp10 }</td>
                <td>${misEmrSePed.apgarAp15 }</td>
            </tr>
            <tr>
                <td class="center">心率（次/分）</td>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
            </tr>
            <tr>
                <td class="center">弹足底或插鼻管反应</td>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
            </tr>
            <tr>
                <td class="center">肌张力</td>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
            </tr>
            <tr>
                <td class="center">呼吸</td>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
            </tr>
        </table>
    </c:if>
</div>

<c:if test="${fn:length(misEmrPreaidVs.sceneRecord)!=0}">
    <div id="page3" class="page">
        <div class="table-title center strong">病&nbsp历&nbsp续&nbsp页</div>
        <div class="table-subtitle strong special center"
             style="margin-top:10px">
            <span class="noborder" style="width:35%">${hosName}</span>
            <span class="noborder" style="width:30%"><fmt:formatDate
                    value="${vAcceptAmbulOutdInfo.ccsj }"
                    pattern="yyyy年MM月dd日" type="date" dateStyle="long"/></span>
            <span class="noborder" style="width:35%">编号：${emrCode }
						</span>
        </div>
        <div class="table-subtitle strong special center"
             style="margin-top:10px">
            <span class="noborder" style="width:35%;text-align:left;">姓名：${misEmrBasicinfo.name }</span>
            <span class="noborder" style="width:30%;text-align:left;">性别：${sex }</span>
            <span class="noborder" style="width:30%;text-align:left;">年龄：<input style="width:30px;" type="text"
                                                                                id="age2" name="age2">
						<select id="timeScope2">
							<option>&nbsp;</option>
							<option value="1">分</option>
							<option value="60">时</option>
							<option value="1440">天</option>
							<option value="43200">月</option>
							<option value="518400">岁</option>
						</select></span>
        </div>

        <div class="table-title center strong" style="margin:20px auto;">${systemConfig.printTitle}院前急救病情记录</div>
        <div class="table-ctx" style="border:1px solid #000;height:800px;">
                ${misEmrPreaidVs.sceneRecord}
        </div>
    </div>
</c:if>

<c:if test="${fn:length(list) != 0}">
    <c:forEach var="list" items="${list}">
        <div id="page${list.id}" class="page">
            <div class="table-title center strong">${list.relatedTypeStr } </div>
            <div class="table-subtitle strong special center"
                 style="margin-top:10px">
                <span class="noborder" style="width:35%">${hosName}</span>
                <span class="noborder" style="width:30%"><fmt:formatDate
                        value="${vAcceptAmbulOutdInfo.ccsj }"
                        pattern="yyyy年MM月dd日" type="date" dateStyle="long"/></span>
                <span class="noborder" style="width:35%">编号：${emrCode }
						</span>
            </div>
            <table class="printtable">
                <tr>
                    <td>
                        <img
                                src="<%=basePath%><%=Constants.UPLOAD_PATH %>${sysMemberInfo.id}/${list.name}"
                                width="99%"/>
                    </td>
                </tr>
            </table>
        </div>
    </c:forEach>
</c:if>

<button id="btn-print" class="btn" onclick="javascript:window.print();">
    <span class="glyphicon glyphicon-print" style="margin-right: 5px;"></span>打印
</button>
</body>
</html>