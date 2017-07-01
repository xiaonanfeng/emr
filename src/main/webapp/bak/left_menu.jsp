<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@ include file="/taglibs.jsp" %>
<!DOCTYPE>
<html>
<body>
<div class="left_menu_box" id="left_menu_box">
    <div class="menu_top_title" id="menu_top_title">电子病历</div>
    <c:choose>
        <c:when test="${orgid == munit}">
            <dl>
                <dt>
                    <img src="${ctx}/css/images/ZXICO/ZX_03.png"/>病历审核
                </dt>
                <dd link_URL="${ctx}/misEmrReview.do?method=findVMisEmrAmbul" id="DZBL_03">病历审核</dd>
            </dl>
        </c:when>
        <c:otherwise>
            <dl>
                <dt>
                    <img src="${ctx}/css/images/ZXICO/ZX_01.png"/>病历登记
                </dt>
                <dd link_URL="${ctx}/vAcceptAmbulOutdInfo.do?method=findVAcceptAmbulOutdInfo" id="DZBL_01">病历登记</dd>
            </dl>
        </c:otherwise>
    </c:choose>

    <dl>
        <dt>
            <img src="${ctx}/css/images/ZXICO/ZX_02.png"/>病历查询
        </dt>
        <dd link_URL="${ctx}/misEmrQuery.do?method=queryEmrs" id="DZBL_02">病历查询</dd>
    </dl>

    <dl>
        <dt>
            <img src="${ctx}/css/images/ZXICO/ZX_04.png"/>修改历史
        </dt>
        <dd link_URL="${ctx}/misEmrModifyRecord.do?method=findVMisEmrAmbul" id="DZBL_04">修改历史</dd>
    </dl>
    <dl>
        <dt>
            <img src="${ctx}/css/images/ZXICO/ZX_05.png"/>交接记录
        </dt>
        <dd link_URL="${ctx}/misEmrHandover.do?method=findVMisEmrAmbul" id="DZBL_05">交接记录</dd>
    </dl>
    <!-- 		<dl> -->
    <!-- 			<dt> -->
    <!-- 				<img src="${ctx}/css/images/ZXICO/ZX_06.png" />病历考评 -->
    <!-- 			</dt> -->
    <!-- 			<dd link_URL="zx_new_page.html" id="DZBL_10">考评细则</dd> -->
    <!-- 			<dd link_URL="zx_new_tab.html" id="DZBL_11">病历登记情况统计</dd> -->
    <!-- 			<dd link_URL="zx_new_page.html" id="DZBL_12">病历质量评价</dd> -->
    <!-- 			<dd link_URL="zx_editForm_underline.html" id="DZBL_13">超时未录入</dd> -->
    <!-- 		</dl> -->
</div>
</body>

</html>