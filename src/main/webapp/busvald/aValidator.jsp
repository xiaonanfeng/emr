<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<script type="text/javascript">
    //基础信息验证规则
    var vld_Base = $("#vld_base_form").validate({
        rules: {
            name: {required: true},
            idCard: "isIdCardNo",
            sex: {required: true},
            ethnic: {required: true},
            age: "ageCtrl",
            timeScope: "ageCtrl",
            stage: "ageCtrl",
            nation: {required: true},
            spot: {required: true},
            //contact:{required:true},
            phone: {number: true, required: true},
            address: {required: true},
            hxProvider: {required: true},
            condition: {required: true},
            preEmcResult: {required: true},
            sentTo: {required: true},
            cause: {required: true},
            diseaseType: {required: true},
            dClassify: {required: true},
            chiefComplaint: {required: true, maxlength: 30},
            presentHx: {required: true},
            pastHx: {required: true},
            drugAllergy: {required: true},
            otherHx: "fromPrv",
            drugName: "fromPrv"
        },
        messages: {
            chiefComplaint: {
                maxlength: "20汉字左右！"
            },
            phone: {
                number: "号码必须是数字"
            }
        }

    });

    //年龄和年龄段的逻辑运算
    jQuery.validator.addMethod("fromPrv", function (value, element) {
        return fromPrv();
    }, "当选择“有”的时候必须填写内容");

    //当既往史和药敏史不详的时候
    jQuery.validator.addMethod("ageCtrl", function (value, element) {
        return ageCtrl();
    }, "年龄和年龄段必填其一且必须为正整数");

    //身份证号验证，支持带X的验证
    jQuery.validator.addMethod("isIdCardNo", function (value, element) {
        return this.optional(element) || isIdCardNo(value);
    }, "请输入正确的号码");

    //电话号码验证 ，支持手机和电话
    jQuery.validator.addMethod("isPhone", function (value, element) {
        var length = value.length;
        var mobile = /^(((13[0-9]{1})|(15[0-9]{1}))+\d{8})$/;
        var tel = /^\d{3,4}-?\d{7,9}$/;
        return this.optional(element) || (tel.test(value) || mobile.test(value));
    }, "请正确填写您的联系电话");

    //体格检查验证
    var vld_Pe = $("#vld_Pe_form").validate({
        rules: {
            t: {number: true, max: 43, min: 35},
            p: {number: true},
            //r:{number:true,max:50,min:0},
            hnEyeL: {number: true},
            hnEyeR: {number: true},
            "pe-bpL": {number: true},
            "pe-bpH": {number: true},
            hnEyeL: {number: true},
            hnEyeR: {number: true},
            hrtRate: {number: true},
            limbMs: {maxlength: 50},
            limbMf: {maxlength: 50},
            limbEdema: {maxlength: 50}
        }
    });


    //妇科验证规则
    var vld_seGyn = $("#vld_seGyn_form").validate({
        rules: {
            marAge: {number: true},
            pregnancy: {number: true},
            childbirth: {number: true},
            aom: {number: true},
            period: {number: true},
            cycle: {number: true},
            lmp: {number: true}
        }
    });


    //产科验证规则
    var vld_seOb = $("#vld_seOb_form").validate({
        rules: {
            fetalHeart: {number: true},
            cervix: {number: true}
        }
    });


    //辅助检查验证规则
    var vld_Ae = $("#vld_Ae_form").validate({
        rules: {
            rbg: {number: true},
            bos: {number: true}
        }
    });

    //辅助检查验证规则
    var vld_preaidVs = $("#vld_preaidVs_form").validate({
        rules: {
            primDiagR: {
                required: true,
                maxlength: 64
            },
            itwRecord: {
                maxlength: 2000
            },
            sceneRecord: {
                maxlength: 800
            },
            doctorSign: {
                required: true
            },
            nurseSign: {
                required: true
            },
            signDate: {
                required: true
            }
        }
    });

    /**PHI验证
     var vld_phi = $("#vld_phi_form").validate({
		rules:{
			phiBr:{required:true},
			phiCons:{required:true},
			phiSbp:{required:true},
			phiPr:{required:true}
		}
    });


     var vld_gcs = $("#vld_gcs_form").validate({
		rules:{
			dglsEr:{required:true},
			dglsVr:{required:true},
			dglsMr:{required:true},
		}
    });
     **/

    //身份证验证实现方法
    function isIdCardNo(num) {
        //alert(num);
        var factorArr = new Array(7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2, 1);
        var parityBit = new Array("1", "0", "X", "9", "8", "7", "6", "5", "4", "3", "2");
        var varArray = new Array();
        var intValue;
        var lngProduct = 0;
        var intCheckDigit;
        var intStrLen = num.length;
        var idNumber = num;
        if (num == "不详" || num == "拒绝提供") {
            return true;
        }
        // initialize
        if ((intStrLen != 15) && (intStrLen != 18)) {
            return false;
        }
        // check and set value
        for (i = 0; i < intStrLen; i++) {
            varArray[i] = idNumber.charAt(i);
            if ((varArray[i] < '0' || varArray[i] > '9') && (i != 17)) {
                return false;
            } else if (i < 17) {
                varArray[i] = varArray[i] * factorArr[i];
            }
        }
        if (intStrLen == 18) {
            //check date
            var date8 = idNumber.substring(6, 14);
            if (isDate8(date8) == false) {
                return false;
            }
            // calculate the sum of the products
            for (i = 0; i < 17; i++) {
                lngProduct = lngProduct + varArray[i];
            }
            // calculate the check digit
            intCheckDigit = parityBit[lngProduct % 11];
            // check last digit
            if (varArray[17] != intCheckDigit) {
                return false;
            }
        }
        else {        //length is 15
            //check date
            var date6 = idNumber.substring(6, 12);
            if (isDate6(date6) == false) {
                return false;
            }
        }
        return true;
    }

    function isDate6(sDate) {
        if (!/^[0-9]{6}$/.test(sDate)) {
            return false;
        }
        var year, month, day;
        year = sDate.substring(0, 4);
        month = sDate.substring(4, 6);
        if (year < 1700 || year > 2500) return false
        if (month < 1 || month > 12) return false
        return true
    }

    function isDate8(sDate) {
        if (!/^[0-9]{8}$/.test(sDate)) {
            return false;
        }
        var year, month, day;
        year = sDate.substring(0, 4);
        month = sDate.substring(4, 6);
        day = sDate.substring(6, 8);
        var iaMonthDays = [31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31]
        if (year < 1700 || year > 2500) return false
        if (((year % 4 == 0) && (year % 100 != 0)) || (year % 400 == 0)) iaMonthDays[1] = 29;
        if (month < 1 || month > 12) return false
        if (day < 1 || day > iaMonthDays[month - 1]) return false
        return true
    }

    //年龄和年龄段控制
    function ageCtrl() {
        //年龄段在年龄不详的情况下为必填项
        var flag = true;

        if ($("#age").val().indexOf(".") > 0) {
            flag = false;
            return flag;
        }

        var last_age = $("#age").val() * $("#timeScope").val();
        var l_stage = $("#stage").val();

        if (l_stage != "" && l_stage != null) {//年龄段不是空的时候
            //console.log(l_stage);
            flag = true;
        } else {//年龄段为空的时候
            if (last_age == 0) {//这个时候年龄和 年龄段肯定有一个是空
                //console.log(2);
                flag = false;
            } else {
                //console.log(3);
                var l_age = $("#age").val();
                //如果age不是正整数
                if (isNaN(l_age)) {
                    //console.log(4);
                    flag = false;
                } else {
                    //console.log(5);
                    var re = /^[0-9]*[1-9][0-9]*$/;
                    flag = re.test(l_age);
                }
            }
        }
        return flag;
    }

    //既往史和药敏史的判断
    function fromPrv() {

        var l_pastHx = $("#pastHx").val();
        var l_drugAllergy = $("#drugAllergy").val();
        var l_otherHx = $("#otherHx").val();
        var l_drugName = $("#drugName").val();

        var flag = true;

        console.log(1);

        //无既往病史
        if (l_pastHx == 0) {
            if (l_otherHx == null || l_otherHx == "") {
                flag = false;
            }
        }

        //无药敏史
        if (l_drugAllergy == 0) {
            if (l_drugName == null || l_drugName == "") {
                flag = false;
            }
        }

        return flag;
    }

</script>
 