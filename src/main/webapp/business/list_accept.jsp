<%@ page language="java" import="java.util.*" pageEncoding="utf-8" %>
<%@ include file="/taglibs.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <script>
        $(document).ready(function () {
            var this_ssjgdm = '${vAcceptAmbulOutdInfo.ssjgdm}';
            if (this_ssjgdm == null || this_ssjgdm == "") {
                if (${orgType == center}) {//如果是中心
                    this_ssjgdm = '${centerOrg}';//就是中心代码
                } else {//如果是分中心或者分站，就是分中心的代码
                    this_ssjgdm = '${sysMemberInfo.sysOrgInfo.ssjgdm}';
                }
            }
            //初始化select的值
            custom_options($("#ssjgdm"), this_ssjgdm);
            callStation(this_ssjgdm);//初始化时呼出第二级
            //根据分中心呼出分站集合
            $("#ssjgdm").change(function () {
                var dm = $(this).val();
                callStation(dm);
            });

            //如果是分中心
            if (${orgType == scenter}) {
                callStation('${orgid}');
            }

            //查询条件校验
            var validator =
                    $("#dataform").validate({
                        rules: {
                            hzrs: {
                                number: true
                            }
                        }
                    });
            //回车查询
            $("input").keydown(function (e) {
                var ev = document.all ? window.event : e;
                if (ev.keyCode == 13) {
                    $("#find").click();
                }
            });

            $("#find").click(function () {
                $("#dataform").submit();
            });

            //清空所有input
            $("#clear").click(function () {
                $("input").val('');//清除所有input
                $("select").val('');//清除所有select
            });

            //病历添加方法
            $(".add").click(function () {
                var lsh = $(this).attr("lsh");
                var ccxh = $(this).attr("ccxh");
                location.href = "${ctx}/emr.do?method=initEmr&ccxh=" + ccxh + "&lsh=" + lsh;//转向添加病历页面，传入流水号
            });

            //病历详单呼出
            $(".callBusiness").click(function () {
                var l_lsh = $(this).attr("lsh");
                window.open("http://${systemConfig.alarmIP}/Query/ComprehensiveBusinessDetail?LSH=" + l_lsh, "出车信息");
            });


            //列出一次出车的所有病历
            $(".listEmr").click(function () {
                var obj = $(this);
                var lsh = $(this).attr("lsh");
                var ccxh = $(this).attr("ccxh");
                $.ajax({
                    contentType: "application/x-www-form-urlencoded; charset=utf-8",
                    url: "${ctx}/emr.do?method=findEmrsByLshAndCcxh&ccxh=" + ccxh + "&lsh=" + lsh,
                    type: "post",
                    success: function (data) {
                        build_new_tr(obj, data);//追加行
                    },
                    error: function (XMLHttpRequest, textStatus, errorThrown) {
                        alert(XMLHttpRequest.status);
                        alert(XMLHttpRequest.readyState);
                        alert(textStatus);
                    }
                });
            });


        });

        /**
         **根据分中心列举分站
         **/
        function callStation(dm) {
            $.ajax({
                contentType: "application/x-www-form-urlencoded; charset=utf-8",
                url: "${ctx}/vAcceptAmbulOutdInfo.do?method=findSzfz4Scenter&orgId=" + dm,
                type: "post",
                success: function (data) {
                    $("#szfzTd").empty().html(data);
                    $("#szfz").val('${vAcceptAmbulOutdInfo.szfz}');
                },
                error: function (XMLHttpRequest, textStatus, errorThrown) {
                    alert(XMLHttpRequest.status);
                    alert(XMLHttpRequest.readyState);
                    alert(textStatus);
                }
            });
        }

    </script>
</head>
<body>
<form id="dataform" action="${ctx}/vAcceptAmbulOutdInfo.do?method=findVAcceptAmbulOutdInfo"
      method="post">
    <div class="search_div">
        <table width="100%" border="0">
            <tr>
                <td nowrap="true" align="right">受理时间（起）</td>
                <td nowrap="true" align="left">
                    <input placeholder="开始" type="text" name="timebegin" id="timebegin"
                           value="${vAcceptAmbulOutdInfo.timebegin}"
                           onfocus="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})"/>
                </td>
                <td nowrap="true" align="right">受理时间（止）</td>
                <td nowrap="true" align="left">
                    <input placeholder="结束" type="text" name="timeover" id="timeover"
                           value="${vAcceptAmbulOutdInfo.timeover}"
                           onfocus="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})"/>
                </td>
                <td nowrap="true" align="right">接车地址</td>
                <td nowrap="true" align="left" colspan="5">
                    <input type="text" name="jcdz" id="jcdz" value="${vAcceptAmbulOutdInfo.jcdz}" class="input_full"/>
                </td>

            </tr>
            <tr>
                <td nowrap="true" align="right">电话</td>
                <td nowrap="true" align="left">
                    <input type="text" name="lxdh" id="lxdh" value="${vAcceptAmbulOutdInfo.lxdh}"/>
                </td>
                <td nowrap="true" align="right">病历数量</td>
                <td nowrap="true" align="left">
                    <input type="text" name="hzrs" id="hzrs" value="${vAcceptAmbulOutdInfo.hzrs}"/>
                </td>
                <td nowrap="true" align="right">填写时间≥</td>
                <td nowrap="true" align="left">
                    <input placeholder="小时" type="text" name="overTimeLimit" id="overTimeLimit"
                           value="${vAcceptAmbulOutdInfo.overTimeLimit}"/>
                </td>
                <td nowrap="true" align="right">填写情况</td>
                <td nowrap="true" align="left">
                    <select id="emrCounts" name="emrCounts">
                        <option></option>
                        <option value="0" <c:if test="${vAcceptAmbulOutdInfo.emrCounts == 0}">selected</c:if>>
                            未填写
                        </option>
                        <option value="1"
                                <c:if test="${vAcceptAmbulOutdInfo.emrCounts != 0&&vAcceptAmbulOutdInfo.emrCounts != null}">selected</c:if>>
                            已填写
                        </option>
                    </select>
                </td>
            </tr>
            <tr>

                <td nowrap="true" align="right">分中心和直属单位</td>
                <td nowrap="true" align="left">
                    <c:if test="${orgType == center}">
                        ${ssjgdm }
                    </c:if>
                    <c:if test="${orgType != center}">
                        <!-- 显示分中心名称 -->
                        ：${ssjgmc }
                    </c:if>
                </td>

                <!-- 中心管理员的话 具有病历 所在分站 查询项 -->
                <c:if test="${orgType != station}">
                    <td nowrap="true" align="right">分站</td>
                    <td nowrap="true" align="left" id="szfzTd">
                            ${szfz }
                    </td>
                </c:if>
                <td nowrap="true" align="right">显示自己</td>
                <td nowrap="true" align="left">
                    <input type="checkbox" id="showAll" name="showAll" superBox="normal" value="1"
                           <c:if test="${vAcceptAmbulOutdInfo.showAll==1||(orgType==station&&systemConfig.shareMode==0)}">checked="checked"</c:if>
                           style="height: 18px;width: 18px;">
                </td>
                <td nowrap="true" align="center">
                    <button type="button" class="btn" id="find">查询</button>
                </td>
                <td nowrap="true" align="center">
                    <button type="button" class="btn btn_gray" id="clear">清空</button>
                </td>
            </tr>
        </table>
    </div>
</form>


<table width="100%" border="0" cellpadding="0" cellspacing="0"
       class="table_list">
    <tr>
        <th class="debugMode${deBugMode}">debug用</th>
        <th>车辆</th>
        <th>接车地址</th>
        <c:if test="${orgid != station}">
            <th>分站</th>
            <th>备注信息</th>
        </c:if>
        <c:if test="${orgid == station}">
            <th>联系电话</th>
        </c:if>
        <th>受理时间</th>
        <th>病历总量</th>
        <th>出诊医生</th>
        <th>操作</th>
    </tr>
    <c:forEach var="list" items="${list}">
        <tr title="事件编号：${list.id.lsh }  医生ID：${list.ysid }">
            <td class="debugMode${deBugMode}">${list.id.lsh}</td>
            <td>${list.clid}</td>
            <td>
                <a class="callBusiness" lsh="${list.id.lsh}">
                        ${list.jcdz }
                </a>
            </td>
            <c:if test="${orgid != station}">
            <td>${fn:substring(list.szfz,0,2)} </td>
            <td title="${list.bz }">
                <c:choose>
                    <c:when test="${fn:length(list.bz)>25}">
                        ${fn:substring(list.bz,0,25)} ……
                    </c:when>
                    <c:otherwise>
                        ${list.bz }
                    </c:otherwise>
                </c:choose>
                </c:if>
            </td>
            <c:if test="${orgid == station}">
                <td>${list.lxdh}</td>
            </c:if>
            <td>
                <fmt:formatDate value="${list.slsj }" pattern="yyyy-MM-dd HH:mm:ss" type="date" dateStyle="long"/>
            </td>
            <td>
                    ${list.hzrs }
            </td>
            <td>
                    ${list.ysid }
            </td>

            <td>
                <c:if test="${list.hzrs != 0}"><!-- 如果没有病历，就不显示这个 -->
                <a class="listEmr search" lsh="${list.id.lsh}" ccxh=${list.id.ccxh }>查看病历</a>
                </c:if>
                <!-- 							中心医生允许填写病历 -->
                <a class="add" lsh="${list.id.lsh}" ccxh=${list.id.ccxh }>添加病历</a>
            </td>
        </tr>
    </c:forEach>
</table>
<div class="show_page" align="center">
    ${nva}
</div>

</body>
</html>
