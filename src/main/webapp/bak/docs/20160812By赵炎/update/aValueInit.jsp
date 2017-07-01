<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<script type="text/javascript">
    $(document).ready(function () {

        //患者ID
        custom_options($("#id"), '${misEmrBasicinfo.id}');
        //初始化基础信息
        custom_options($("#contact"), '${misEmrBasicinfo.contact}');
        custom_options($("#name"), '${misEmrBasicinfo.name}');
        custom_options($("#sex"), '${misEmrBasicinfo.sex}');
        var scope = parseTimeToAge('${misEmrBasicinfo.age}');//年龄计算。先算出是哪个范围
        custom_options($("#timeScope"), scope);
        custom_options($("#age"), ('${misEmrBasicinfo.age}' / scope));//然后相除并四舍五入
        custom_options($("#stage"), '${misEmrBasicinfo.stage}');
        custom_options($("#phone"), '${misEmrBasicinfo.phone}');
        custom_options($("#address"), '${misEmrBasicinfo.address}');
        if ('${misEmrBasicinfo.isHosptial}' == 1) {
            $("#isHosptial").attr("checked", true);
        } else {
            $("#isHosptial").attr("checked", false);
        }
        //默认为中国
        custom_options($("#nation"), '${misEmrBasicinfo.nation}' == null || '${misEmrBasicinfo.nation}' == "" ? "10" : '${misEmrBasicinfo.nation}');
        custom_options($("#ethnic"), '${misEmrBasicinfo.ethnic}');
        custom_options($("#spot"), '${misEmrBasicinfo.spot}');
        custom_options($("#dClassify"), '${misEmrBasicinfo.dClassify}');
        custom_options($("#condition"), '${misEmrBasicinfo.condition}');
        custom_options($("#preEmcResult"), '${misEmrBasicinfo.preEmcResult}');
        custom_options($("#idCard"), '${misEmrBasicinfo.idCard}' == null || '${misEmrBasicinfo.idCard}' == "" ? "不详" : '${misEmrBasicinfo.idCard}');
        custom_options($("#chiefComplaint"), '${misEmrBasicinfo.chiefComplaint}');
        custom_options($("#hxProvider"), '${misEmrBasicinfo.hxProvider}');
        custom_options($("#presentHx"), '${misEmrBasicinfo.presentHx}');
        custom_options($("#pastHx"), '${misEmrBasicinfo.pastHx}');
        custom_options($("#heartCondition"), '${misEmrBasicinfo.heartCondition}');
        custom_options($("#heartIllness"), '${misEmrBasicinfo.heartIllness}');
        custom_options($("#heartHx"), '${misEmrBasicinfo.heartHx}');
        custom_options($("#heartTherapy"), '${misEmrBasicinfo.heartTherapy}');
        custom_options($("#hbp"), '${misEmrBasicinfo.hbp}');
        custom_options($("#hbpHx"), '${misEmrBasicinfo.hbpHx}');
        custom_options($("#bpH"), '${misEmrBasicinfo.bpH}');
        custom_options($("#bpL"), '${misEmrBasicinfo.bpL}');
        custom_options($("#hbpTherapy"), '${misEmrBasicinfo.hbpTherapy}');
        custom_options($("#diabetes"), '${misEmrBasicinfo.diabetes}');
        custom_options($("#dmType"), '${misEmrBasicinfo.dmType}');
        custom_options($("#dmHx"), '${misEmrBasicinfo.dmHx}');
        custom_options($("#dmTherapy"), '${misEmrBasicinfo.dmTherapy}');
        custom_options($("#otherHx"), '${misEmrBasicinfo.otherHx}');
        custom_options($("#drugAllergy"), '${misEmrBasicinfo.drugAllergy}');
        custom_options($("#drugName"), '${misEmrBasicinfo.drugName}');

        //初始化体格检查
        custom_options($("#t"), '${misEmrPe.t}');
        custom_options($("#p"), '${misEmrPe.p}');
        custom_options($("#r"), '${misEmrPe.r}');
        custom_options($("#tTest"), '${misEmrPe.tTest}');
        custom_options($("#pTest"), '${misEmrPe.pTest}');
        custom_options($("#rTest"), '${misEmrPe.rTest}');
        custom_options($("#bpTest"), '${misEmrPe.bpTest}');

        custom_options($("#pe-bpL"), '${misEmrPe.bpL}');
        custom_options($("#pe-bpH"), '${misEmrPe.bpH}');
        custom_options($("#posture"), '${misEmrPe.posture}');
        custom_options($("#conscious"), '${misEmrPe.conscious}');
        custom_options($("#skin"), '${misEmrPe.skin}');
        custom_options($("#cyanosis"), '${misEmrPe.cyanosis}');

        custom_options($("#hnEyeTestL"), '${misEmrPe.hnEyeTestL}');
        custom_options($("#hnEyeTestR"), '${misEmrPe.hnEyeTestR}');
        custom_options($("#hnEyeL"), '${misEmrPe.hnEyeL}');
        custom_options($("#hnPlrL"), '${misEmrPe.hnPlrL}');
        custom_options($("#hnEyeR"), '${misEmrPe.hnEyeR}');
        custom_options($("#hnPlrR"), '${misEmrPe.hnPlrR}');

        custom_options($("#headNeck"), '${misEmrPe.headNeck}');
        custom_options($("#chest"), '${misEmrPe.chest}');
        custom_options($("#lung"), '${misEmrPe.lung}');
        custom_options($("#heart"), '${misEmrPe.heart}');
        custom_options($("#abdomen"), '${misEmrPe.abdomen}');
        custom_options($("#limb"), '${misEmrPe.limb}');
        custom_options($("#spine"), '${misEmrPe.spine}');
        custom_options($("#nerveReflex"), '${misEmrPe.nerveReflex}');
        custom_options($("#peOthers"), '${misEmrPe.peOthers}');

        //妇科
        custom_options($("#martialStatus"), '${misEmrSeGyn.martialStatus}');
        custom_options($("#marAge"), '${misEmrSeGyn.marAge}');
        custom_options($("#pregnancy"), '${misEmrSeGyn.pregnancy}');
        custom_options($("#childbirth"), '${misEmrSeGyn.childbirth}');
        custom_options($("#sexLife"), '${misEmrSeGyn.sexLife}');
        custom_options($("#aom"), '${misEmrSeGyn.aom}');
        custom_options($("#period"), '${misEmrSeGyn.period}');
        custom_options($("#cycle"), '${misEmrSeGyn.cycle}');
        custom_options($("#lmp"), '${misEmrSeGyn.lmp}');
        //产科
        custom_options($("#fetalHeart"), '${misEmrSeOb.fetalHeart}');
        custom_options($("#uterContrac"), '${misEmrSeOb.uterContrac}');
        custom_options($("#caul"), '${misEmrSeOb.caul}');
        custom_options($("#amnioticFluid"), '${misEmrSeOb.amnioticFluid}');
        custom_options($("#bloodSee"), '${misEmrSeOb.bloodSee}');
        custom_options($("#cervix"), '${misEmrSeOb.cervix}');
        custom_options($("#present"), '${misEmrSeOb.present}');
        custom_options($("#obother"), '${misEmrSeOb.obother}');
        //儿科
        custom_options($("#apgar1"), '${misEmrSePed.apgar1}');
        custom_options($("#apgarAp1"), '${misEmrSePed.apgarAp1}');
        custom_options($("#apgarP1"), '${misEmrSePed.apgarP1}');
        custom_options($("#apgarG1"), '${misEmrSePed.apgarG1}');
        custom_options($("#apgarAc1"), '${misEmrSePed.apgarAc1}');
        custom_options($("#apgarR1"), '${misEmrSePed.apgarR1}');
        custom_options($("#apgar5"), '${misEmrSePed.apgar5}');
        custom_options($("#apgarAp5"), '${misEmrSePed.apgarAp5}');
        custom_options($("#apgarP5"), '${misEmrSePed.apgarP5}');
        custom_options($("#apgarG5"), '${misEmrSePed.apgarG5}');
        custom_options($("#apgarAc5"), '${misEmrSePed.apgarAc5}');
        custom_options($("#apgarR5"), '${misEmrSePed.apgarR5}');
        custom_options($("#apgar10"), '${misEmrSePed.apgar10}');
        custom_options($("#apgarAp10"), '${misEmrSePed.apgarAp10}');
        custom_options($("#apgarP10"), '${misEmrSePed.apgarP10}');
        custom_options($("#apgarG10"), '${misEmrSePed.apgarG10}');
        custom_options($("#apgarAc10"), '${misEmrSePed.apgarAc10}');
        custom_options($("#apgarR10"), '${misEmrSePed.apgarR10}');
        custom_options($("#apgar15"), '${misEmrSePed.apgar15}');
        custom_options($("#apgarAp15"), '${misEmrSePed.apgarAp15}');
        custom_options($("#apgarP15"), '${misEmrSePed.apgarP15}');
        custom_options($("#apgarG15"), '${misEmrSePed.apgarG15}');
        custom_options($("#apgarAc15"), '${misEmrSePed.apgarAc15}');
        custom_options($("#apgarR15"), '${misEmrSePed.apgarR15}');

        //创伤
        custom_options($("#phiTotal"), '${misEmrSeTruma.phiTotal}');
        custom_options($("#phiBr"), '${misEmrSeTruma.phiBr}');
        custom_options($("#phiCons"), '${misEmrSeTruma.phiCons}');
        custom_options($("#phiSbp"), '${misEmrSeTruma.phiSbp}');
        custom_options($("#phiPr"), '${misEmrSeTruma.phiPr}');
        custom_options($("#dglsTotal"), '${misEmrSeTruma.dglsTotal}');
        custom_options($("#dglsEr"), '${misEmrSeTruma.dglsEr}');
        custom_options($("#dglsVr"), '${misEmrSeTruma.dglsVr}');
        custom_options($("#dglsMr"), '${misEmrSeTruma.dglsMr}');
        //辅助检查
        custom_options($("#rbg"), '${misEmrAe.rbg}');
        custom_options($("#rbgTest"), '${misEmrAe.rbgTest}');
        custom_options($("#bosTest"), '${misEmrAe.bosTest}');
        custom_options($("#bos"), '${misEmrAe.bos}');
        custom_options($("#ecg"), '${misEmrAe.ecg}');
        //如果心电图检查不是已查，就不现实下面的输入框
        hideEcg($("#ecg"));
        custom_options($("#ecgDiag"), '${misEmrAe.ecgDiag}');
        custom_options($("#ecgTo"), '${misEmrAe.ecgTo}');
        custom_options($("#aeOther"), '${misEmrAe.aeOther}' == null || '${misEmrAe.aeOther}' == "" ? "无" : '${misEmrAe.aeOther}');
        custom_options($("#ohters"), '${misEmrAe.ohters}');
        custom_options($("#ecgOther"), '${misEmrAe.ecgOther}' == null || '${misEmrAe.ecgOther}' == "" ? "无" : '${misEmrAe.ecgOther}');


        //施救措施
        custom_options($("#primDiag"), '${misEmrPreaidVs.primDiag}');
        custom_options($("#doctorSign"), '${misEmrPreaidVs.doctorSign}');
        custom_options($("#nurseSign"), '${misEmrPreaidVs.nurseSign}');
        //${nowDAT}
        //if('${misEmrPreaidVs.signDate}' == null||'${misEmrPreaidVs.signDate}'==""){
        //custom_options($("#signDate"),'${nowDAT}');
        //}else{
        custom_options($("#signDate"), '<fmt:formatDate value="${misEmrPreaidVs.signDate}" pattern="yyyy-MM-dd HH:mm:ss" type="date" dateStyle="long" />');
        //}
        custom_options($("#sceneTreat"), '${misEmrPreaidVs.sceneTreat}');
        custom_options($("#arrivalVs"), '${misEmrPreaidVs.arrivalVs}');

        //送往医院:如果初始化没有值就默认本院，如果有值就直接初始化
        if ('${misEmrBasicinfo.sentTo}' != null && '${misEmrBasicinfo.sentTo}' != "") {
            custom_options($("#sentTo"), '${misEmrBasicinfo.sentTo}');
        } else {
            custom_options($("#sentTo"), '${sysMemberInfo.sysOrgInfo.orgId}');
        }


        /**
         * 默认赋值过滤器
         **/
        //如果是是控制就自动补充
        <c:forEach var="list" items="${misEmrCmpltList}">
        if ($('#' + '${list.colname}').val() == "") {
            $('#' + '${list.colname}').val('${list.colvalue}');
        }
        </c:forEach>


        //呼叫原因和疾病分类二级初始化
        custom_options($("#cause"), '${misEmrBasicinfo.cause}');//第一级
        var code = $("#cause").val();
        if (code != null) {
            $.ajax({
                contentType: "application/x-www-form-urlencoded; charset=utf-8",
                url: "${ctx}/misEmrBasicinfo.do?method=findDiseaseType",
                data: "code=" + code,
                type: "post",
                success: function (data) {
                    $("#diseaseTypeTD").empty();
                    $("#diseaseTypeTD").append(data);
                    if (code == "256") {//TODO 疾病，特列
                        $("#diseaseType").bind("change", function () {
                            callSe(code, $(this).val())
                        });
                    }
                    createSelect($("#diseaseType"));//新select创建访法
                    //第二级初始化
                    custom_options($("#diseaseType"), '${misEmrBasicinfo.diseaseType}');
                }
            });

        }

        /*******页面选择器******/
        //妇科选择器
        $("#sex").val() == 20 ? showDiv(["segyn"]) : hideDiv(["segyn"]);//如果是女就显示妇科，如果不是女就不显示
        //病历模板选择器
        callSe('${misEmrBasicinfo.cause}', '${misEmrBasicinfo.diseaseType}');

        //不要既往病史
        if ($("#pastHx").val() == 1 || $("#pastHx").text() == "无") {
            clearGroup("pastHx");
        }

        //textarea初始化
        //AE心电图印象
        var intiValue = "";

        intiValue = document.getElementById("ecgDiag").value;
        $.ajax({
            contentType: "application/x-www-form-urlencoded; charset=utf-8",
            url: "${ctx}/misEmrAe.do?method=findMisEmrAeInnerDiag&str=" + intiValue,
            type: "get",
            success: function (data) {
                $("#ecgDiagText").val(data);
            }
        });

        //VS病情诊断
        intiValue = document.getElementById("primDiag").value;
        $.ajax({
            contentType: "application/x-www-form-urlencoded; charset=utf-8",
            url: "${ctx}/misEmrPreaidVs.do?method=findPrimDiagText&str=" + intiValue,
            type: "get",
            success: function (data) {
                $("#primDiagText").val(data);
            }
        });


        //VS现场施救措施
        intiValue = document.getElementById("sceneTreat").value;
        $.ajax({
            contentType: "application/x-www-form-urlencoded; charset=utf-8",
            url: "${ctx}/misEmrPreaidVs.do?method=findMisEmrPreaidVsSceneTreatText&str=" + intiValue,
            type: "get",
            success: function (data) {
                $("#sceneTreatText").val(data);//VS
            }
        });

        //VS中途施救措施初中诊断
        /**
         intiValue = document.getElementById("itwTreat").value;
         $.ajax({
				contentType: "application/x-www-form-urlencoded; charset=utf-8",
				url : "${ctx}/misEmrPreaidVs.do?method=findMisEmrPreaidVsSceneTreatText&str="+intiValue,
				type : "get",
				success : function(data) {
					$("#itwTreatText").val(data);
				}
			});
         **/

        //VS现场用药
        $("#senceDrugListTd").load("${ctx}/misEmrMar.do?method=findMisEmrMar&type=1&emrId=" + $("#id").val());

        intiValue = document.getElementById("sceneDrug").value;
        $.ajax({
            contentType: "application/x-www-form-urlencoded; charset=utf-8",
            url: "${ctx}/misEmrPreaidVs.do?method=findDrugText&str=" + intiValue,
            type: "get",
            success: function (data) {
                $("#sceneDrugText").val(data);
            }
        });

        //VS中途用药
        /**
         intiValue = document.getElementById("itwDrug").value;
         $.ajax({
				contentType: "application/x-www-form-urlencoded; charset=utf-8",
				url : "${ctx}/misEmrPreaidVs.do?method=findDrugText&str="+intiValue,
				type : "get",
				success : function(data) {
					$("#itwDrugText").val(data);
				}
			});
         **/

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

    //获取select值
    //@never used
    function getSelectValue(obj) {
        var str = obj.val();
        return str;
    }

</script>
				