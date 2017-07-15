<%@ page language="java" import="java.util.*" pageEncoding="utf-8" %>
<%@ include file="/taglibs.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <script>
        $(document).ready(function () {
            init();//初始化值
            var this_ssjgdm = '${vMisEmrQuery.ssjgdm}';
            if (${orgType != center}) {//如果不是中心，则默认给所属机构赋值
                this_ssjgdm = '${sysMemberInfo.sysOrgInfo.ssjgdm}';
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

            //quickSearch
            $("input#mc").quicksearch("table#data_list tbody tr");

            //slide
            var slide = new SlideBoot('.slide', '#dataform');
            slide.init();

            //初始化select的值
            custom_options($("#szfz"), '${vMisEmrQuery.szfz}');

            if ('${vMisEmrQuery.szfz}' == null || '${vMisEmrQuery.szfz}' == "") {//分站选择医生记忆
                if ('${systemConfig.shareMode}' == 1) {
                    initDocsId('${sysMemberInfo.sysOrgInfo.orgId}');
                }
            } else {//中心选择医生记忆
                initDocsId('${vMisEmrQuery.szfz}');
            }


            /**
             **回车启动查询
             **/
            $("input").keydown(function (e) {
                var ev = document.all ? window.event : e;
                if (ev.keyCode == 13) {
                    $("#find").click();
                }
            });

            //显示自己？
            $("#showAll").click(function () {
                $("#showAll").is(':checked') == true ? $("#id").val('${memberId}') : $("#id").val(null);
            });

            $("#find").click(function () {
                $("#dataform").submit();
            });

            //清空所有input
            $("#clear").click(function () {
                $("input").val('');
            });

            //中心查询病历审核记录
            $(".listSorce").click(function () {
                var obj = $(this);
                var emrId = $(this).attr("emrId");
                $.ajax({
                    contentType: "application/x-www-form-urlencoded; charset=utf-8",
                    url: "${ctx}/vMisEmrScoreTypeStdd.do?method=findSorceRecByEmrId&emrId=" + emrId,
                    type: "post",
                    success: function (data) {
                        build_new_tr(obj, data);//追加行
                    },
                    error: function (XMLHttpRequest, textStatus, errorThrown) {
                        alert(textStatus + ":" + XMLHttpRequest.status + ":" + XMLHttpRequest.readyState);
                    }
                });
            });

            //查询
            $("#find").click(function () {
                var actionUrl = "${ctx}/misEmrQuery.do?method=queryEmrs&actionButton=" + '${actionButton}';
                if ('${param.level}' != null && '${param.level}' != "") {
                    actionUrl = actionUrl + "&level=" + '${param.level}';
                }
                $("#dataform").attr("action", actionUrl);
                $("#dataform").submit();
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
                    $("#szfz").val('${vMisEmrQuery.szfz}');
                    $("#szfz").change(function () {
                        initDocsId($(this).val());
                    });
                },
                error: function (XMLHttpRequest, textStatus) {
                    alert(XMLHttpRequest.status);
                    alert(XMLHttpRequest.readyState);
                    alert(textStatus);
                }
            });
        }


        //根据单位初始化医生下拉框
        function initDocsId(l_orgId) {
            if (l_orgId != null && l_orgId != "") {
                $.ajax({
                    contentType: "application/x-www-form-urlencoded; charset=utf-8",
                    url: "${ctx}/sysMemberInfo.do?method=findMemberSelectByOrgId&orgId=" + l_orgId,
                    type: "post",
                    success: function (data) {
                        $("#memList").empty().html(data);
                        custom_options($("#nurse"), '${vMisEmrQuery.nurse}');
                        custom_options($("#driver"), '${vMisEmrQuery.driver}');
                    },
                    error: function (XMLHttpRequest, textStatus) {
                        alert(textStatus + ":" + XMLHttpRequest.status + ":" + XMLHttpRequest.readyState);
                    }
                });
            }
        }

        //删除
        function del(id) {
            if (confirm("删除病例会删除相关所有信息（包括：用药、交接记录、告知书、修改记录等！）") == false) {
                return;
            }
            $.ajax({
                contentType: "application/x-www-form-urlencoded; charset=utf-8",
                url: "${ctx}/emr.do?method=delEmrsById",
                data: "id=" + id,
                type: "post",
                success: function () {
                    window.location.href = window.location.href;
                }
            });
        }

        //初始化方法
        function init() {
            custom_options($("#sex"), '${vMisEmrQuery.sex}');
            custom_options($("#condition"), '${vMisEmrQuery.condition}');
            custom_options($("#preEmcResult"), '${vMisEmrQuery.preEmcResult}');
            custom_options($("#cause"), '${vMisEmrQuery.cause}');
            custom_options($("#stage"), '${vMisEmrQuery.stage}');
            custom_options($("#sentTo"), '${vMisEmrQuery.sentTo}');
            custom_options($("#dClassify"), '${vMisEmrQuery.dClassify}');
        }


    </script>
</head>
<body>
<form id="dataform" method="post">
    <div class="search_div">
        <table width="100%" border="0">
            <tr>
                <td nowrap="true" align="right">呼救时刻（起）</td>
                <td nowrap="true" align="left">
                    <input type="text" name="timebegin" id="timebegin" value="${vMisEmrQuery.timebegin}"
                           onfocus="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})"/>
                </td>
                <td nowrap="true" align="right">呼救时刻（止）</td>
                <td nowrap="true" align="left">
                    <input type="text" name="timeover" id="timeover" value="${vMisEmrQuery.timeover}"
                           onfocus="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})"/>
                </td>
                <td nowrap="true" align="right">患者姓名</td>
                <td nowrap="true" align="left">
                    <input type="text" name="name" id="name" value="${vMisEmrQuery.name }"/>
                </td>
                <td nowrap="true" align="right">患者性别</td>
                <td nowrap="true" align="left">
                    ${sex }
                </td>
            </tr>
            <tr group="tog">
                <td nowrap="true" align="right">病情</td>
                <td nowrap="true" align="left">
                    ${condition }
                </td>
                <td nowrap="true" align="right">救治结果</td>
                <td nowrap="true" align="left">
                    ${preEmcResult }
                </td>
                <td nowrap="true" align="right">呼救原因</td>
                <td nowrap="true" align="left">
                    ${cause }
                </td>
                <td nowrap="true" align="right">疾病分类</td>
                <td nowrap="true" align="left">
                    ${dClassify }
                </td>
            </tr>
            <tr group="tog">
                <td nowrap="true" align="right">送往地点</td>
                <td nowrap="true" align="left">
                    ${sentTo }
                </td>

                <c:if test="${orgType == center}">
                    <td nowrap="true" align="right">中心|直属</td>
                    <td nowrap="true" align="left">
                            ${ssjgdm }
                    </td>
                </c:if>
                <!-- 中心管理员的话 具有病历 所在分站 查询项 -->
                <c:if test="${orgType != station}">
                    <td nowrap="true" align="right">分站</td>
                    <td nowrap="true" align="left" id="szfzTd">
                            ${szfz }
                    </td>
                </c:if>


                <td nowrap="true" align="right">医/护/司</td>
                <td nowrap="true" align="left">
                    <input type="text" name="ysid" id="ysid" value="${vMisEmrQuery.ysid }" class="select_short"/>
                    <div id="memList">
                    </div>
                </td>


            </tr>
            <tr>
                <td nowrap="true" align="right">年龄段</td>
                <td nowrap="true" align="left">
                    ${stage }
                </td>
                <td nowrap="true" align="right">车辆编号</td>
                <td nowrap="true" align="left">
                    <input type="text" name="clid" id="clid" value="${vMisEmrQuery.clid}"/>
                </td>
                <td nowrap="true" align="right">提交</td>
                <td nowrap="true" align="left">
                    <select name="isCommitted" id="isCommitted">
                        <option value="">---全部---</option>
                        <option value="0" <c:if test="${vMisEmrQuery.isCommitted == 0}">selected</c:if>>未提交</option>
                        <option value="1" <c:if test="${vMisEmrQuery.isCommitted == 1}">selected</c:if>>已提交</option>
                    </select>
                </td>
                <c:if test="${actionButton != 1}">
                    <td nowrap="true" align="right">
                        <c:if test="${param.level!=null&&param.level!=''}">质控</c:if>
                        <c:if test="${param.level==null||param.level==''}">填写</c:if>情况
                    </td>
                    <td nowrap="true" align="left">
                        <select id="exist" name="exist">
                            <option></option>
                            <option value="0" <c:if test="${vMisEmrQuery.exist == 0}">selected</c:if>>
                                未<c:if test="${param.level!=null&&param.level!=''}">质控</c:if>
                                <c:if test="${param.level==null||param.level==''}">填写</c:if>
                            </option>
                            <option value="1"
                                    <c:if test="${vMisEmrQuery.exist == 1&&vMisEmrQuery.exist != null}">selected</c:if>>
                                已<c:if test="${param.level!=null&&param.level!=''}">质控</c:if>
                                <c:if test="${param.level==null||param.level==''}">填写</c:if>
                            </option>
                        </select>
                    </td>
                </c:if>
            </tr>
            <tr>
                <c:if test="${orgid != munit}">
                    <td nowrap="true" align="right">显示自己</td>
                    <td nowrap="true" align="left">
                        <input type="checkbox" id="showAll" name="showAll" superBox="normal"
                               <c:if test="${(vMisEmrQuery.id!=null&&vMisEmrQuery.id!='')||(systemConfig.shareMode==0&&orgType==station)}">checked="checked"</c:if>
                               style="height: 18px;width: 18px;">
                        <input type="hidden" id="id" name="id" value="${vMisEmrQuery.id}">
                    </td>
                </c:if>
                <td colspan="2">
                    <input type="text" name="mc" value="" id="mc" class="input_full" placeholder="关键字查询" autofocus/>
                </td>
                <td nowrap="true" align="center">
                    <button type="button" class="btn" id="find">查询</button>
                    <button type="button" class="btn btn_gray" id="clear">清空</button>
                </td>
            </tr>
        </table>
    </div>
</form>
<div class="slide">
</div>
<table width="100%" border="0" cellpadding="0" cellspacing="0" id="data_list"
       class="table_list">
    <thead>
    <tr>
        <th class="debugMode${deBugMode}">debug用</th>
        <th>呼救时刻</th>
        <th>患者</th>
        <th>性别</th>
        <th>疾病分类</th>
        <th>病情</th>
        <th>初步诊断</th>
        <th>分站</th>
        <th>效果</th>
        <th>送往</th>
        <th>医生</th>
        <th>提交状态</th>
        <th>操作</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="list" items="${list}">
        <tr title="由${list.createuserid }创建">
            <td class="debugMode${deBugMode}">${list.emrid}</td>
            <td>
                <fmt:formatDate value="${list.hjsj }" pattern="yy-MM-dd HH:mm:ss" type="date" dateStyle="long"/>
            </td>
            <td>${list.name}</td>
            <td>${list.text_sex}</td>
            <td>${list.text_diseaseType}</td>
            <td>${list.text_condition}</td>
            <td>
                <c:choose>
                    <c:when test="${fn:length(list.primDiagR)>15}">
                        ${fn:substring(list.primDiagR,0,15)} ……
                    </c:when>
                    <c:otherwise>
                        ${list.primDiagR}
                    </c:otherwise>
                </c:choose>
            </td>
            <td>${list.text_szfz}</td>
            <td>${list.text_preEmcResult}</td>

            <td>${list.text_sentTo}</td>

            <td>${list.text_id}</td>
            <td>
                <c:if test="${list.isCommitted  == 1}"><span style="color: green;">已提交</span></c:if>
                <c:if test="${list.isCommitted  == 0}">未提交</c:if>
            </td>
            <td class="debugMode${deBugMode}">
                    ${actionButton }
                    ${list.isCommitted }
                    ${list.createuserid }
                    ${sysMemberInfo.id }
            </td>
            <td>
                <%@ include file="actionPage.jsp" %>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<div class="show_page" align="center">
    ${nva}
</div>

</body>
</html>
