<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@ include file="/taglibs.jsp" %>
<!DOCTYPE>
<html>
<style>
    .index_gnmk li {
        float: left;
        text-align: center;
        margin: 23px 25px;
    }
</style>
<body>
<div class="Frame_right_ico index_body_img" id="Frame_right_ico">
    <ul style="width: 255px;" class="index_gnmk" id="index_gnmk">
        <c:choose>
            <c:when test="${orgid == munit}">
                <li><a href="javascript:void(0)"
                       openMode="tabMenu" biaozhi="01000000"
                       link_URL="${ctx}/misEmrReview.do?method=findVMisEmrAmbul"
                       title="病历审核"> <span> <img
                        src="${ctx}/css/images/ZXICO/120ico_06.png" width="64"
                        height="64"/>
									<div>病历审核</div>
							</span>
                </a>
                </li>
            </c:when>
            <c:otherwise>
                <li><a href="javascript:void(0)"
                       openMode="tabMenu" biaozhi="02000000"
                       link_URL="${ctx}/vAcceptAmbulOutdInfo.do?method=findVAcceptAmbulOutdInfo"
                       tab_title="病历填写"> <span> <img
                        src="${ctx}/css/images/ZXICO/120ico_07.png" width="64"
                        height="64"/>
									<div>病历填写</div>
							</span>
                </a>
                </li>
            </c:otherwise>
        </c:choose>
        <li><a href="javascript:void(0)"
               openMode="tabMenu" biaozhi="03000000"
               link_URL="${ctx}/misEmrQuery.do?method=queryEmrs&actionButton=1"
               title="病历查询"> <span> <img
                src="${ctx}/css/images/ZXICO/120ico_05.png" width="64"
                height="64"/>
							<div>病历查询</div>
					</span>
        </a></li>
        <li><a href="javascript:void(0)"
               openMode="tabMenu" biaozhi="04000000"
               link_URL="${ctx}/misEmrQuery.do?method=queryEmrs&actionButton=2"
               title="急救告知"> <span>
							<img src="${ctx}/css/images/ZXICO/120ico_03.png" width="64"
                                 height="64"/>
							<div>急救告知</div>
					</span>
        </a></li>
        <!-- 				link_URL="${ctx}/misEmrHandover.do?method=findVMisEmrAmbul"  -->
        <li><a href="javascript:void(0)"
               openMode="tabMenu" biaozhi="05000000"
               link_URL="${ctx}/misEmrQuery.do?method=queryEmrs&actionButton=3"
               title="交接记录"> <span>
							<img src="${ctx}/css/images/ZXICO/120ico_02.png" width="64"
                                 height="64"/>
							<div>交接记录</div>
					</span>
        </a></li>
        <!-- 				<li > -->
        <!-- 					<a href="javascript:void(0)" -->
        <!-- 						openMode="tabMenu" biaozhi="06000000" -->
        <!-- 						link_URL="${ctx}/misEmrQuery.do?method=queryEmrs&actionButton=5" -->
        <!-- 						title="护理记录"> <span> <img -->
        <!-- 							src="${ctx}/css/images/ZXICO/Security.png" width="64" -->
        <!-- 							height="64" /> -->
        <!-- 							<div>护理记录</div> -->
        <!-- 					</span> -->
        <!-- 					</a> -->
        <!-- 				</li> -->
        <c:choose>
            <c:when test="${orgid == munit}">
                <li><a href="javascript:void(0)"
                       openMode="tabMenu" biaozhi="07000000"
                       link_URL="${ctx}/vAcceptAmbulOutdInfo.do?method=findVAcceptAmbulOutdInfo"
                       title="填写情况"> <span> <img
                        src="${ctx}/css/images/ZXICO/120ico_08.png" width="64"
                        height="64"/>
									<div>填写情况</div>
							</span>
                </a>
                </li>
            </c:when>
            <c:otherwise>
            </c:otherwise>
        </c:choose>
        <li>
            <a href="javascript:void(0)"
               openMode="tabMenu" biaozhi="08000000"
               link_URL="${ctx}/misEmrQuery.do?method=queryEmrs&actionButton=4"
               title="收费情况"> <span> <img
                    src="${ctx}/css/images/ZXICO/120ico_09.png" width="64"
                    height="64"/>
							<div>收费情况</div>
					</span>
            </a>
        </li>
        <li><a href="javascript:void(0)"
               openMode="tabMenu" biaozhi="09000000"
               link_URL="${ctx}/misEmrModifyRecord.do?method=findVMisEmrAmbul"
               title="修改历史"> <span> <img
                src="${ctx}/css/images/ZXICO/120ico_01.png" width="64"
                height="64"/>
							<div>修改历史</div>
					</span>
        </a></li>

        <!-- 				<li > -->
        <!-- 					<a href="javascript:void(0)" -->
        <!-- 						openMode="tabMenu" biaozhi="10000000" -->
        <!-- 						link_URL="${ctx}/misEmrQuery.do?method=queryEmrs&actionButton=4" -->
        <!-- 						title="修改申请"> <span> <img -->
        <!-- 							src="${ctx}/css/images/ZXICO/Tools.png" width="64" -->
        <!-- 							height="64" /> -->
        <!-- 							<div>修改申请</div> -->
        <!-- 					</span> -->
        <!-- 					</a> -->
        <!-- 				</li> -->
    </ul>
    <ul class="my_clock" id="my_clock" style="margin-top: 20px;">
        <li class="my_seconds" id="my_seconds">
            <div></div>
        </li>
        <li class="my_minutes" id="my_minutes">
            <div></div>
        </li>
        <li class="my_hours" id="my_hours">
            <div></div>
        </li>
    </ul>
    <div class="rili" id="rili">
        <div class="my_week" id="my_week"></div>
        <div class="my_riqi" id="my_riqi"></div>
        <div class="my_year" id="my_year"></div>
    </div>

    <!-- 			<ul class="index_message" id="qqq" style="max-width:380px"> -->
    <!-- 	  			<li style="width:auto"> -->
    <!-- 	  				<a href="${ctx}/home.jsp" title="点击查看详情"> -->
    <!-- 	  					<span></span> -->
    <!-- 	  				</a> -->
    <!-- 	  			</li>  -->
    <!-- 			</ul> -->

</div>
<!-- 		<audio id="messageAudio" autoplay="autoplay" controls="controls"> -->
<!-- 	      	<source src="${ctx}/css/message.mp3" type="audio/mpeg"></source> -->
<!-- 	   	</audio> -->
</body>
</html>
