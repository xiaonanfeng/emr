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
<script type="text/javascript">
    $(document).ready(function () {

        //菜单排列
        var cateSize = '${list.size()}';
        var perWidth = 130;
        $('#index_gnmk').css('width', Math.ceil(cateSize / 4) * perWidth);

        //消息提示
        /**
         **这里没有用websocket，而选用了ajax是因为这个功能不是每时每刻都需要人守候的
         **/
        //setInterval(showalert, '${systemConfig.autoReqScope}');
        /**提示收到的修改申请和审批结果**/
        function showalert() {
            //findMsgWait4prev();
            //findMsgPrevd();
        }

        /**
         **修改申请
         **/
        function findMsgWait4prev() {

            $.ajax({
                contentType: "application/x-www-form-urlencoded; charset=utf-8",
                url: "${ctx}/misEmrMdfreq.do?method=findMisEmrMdfReqCount&stat=0",
                type: "post",
                success: function (data) {
                    if (data != 0) {
                        $("#qqq").show(1000);
                        //$("#messageAudio")[0].play();
                    } else {
                        $("#qqq").hide(1000);
                    }
                }
            });
        }

        /**
         **审批结果
         **/
        function findMsgPrevd() {
            $.ajax({
                contentType: "application/x-www-form-urlencoded; charset=utf-8",
                url: "${ctx}/misEmrMdfreq.do?method=findMisEmrMdfReqCount&stat=1",
                type: "post",
                success: function (data) {
                    if (data != 0) {
                        $("#qResult").show(1000);
                        //$("#messageAudio")[0].play();
                    } else {
                        $("#qResult").hide(1000);
                    }
                }
            });
        }

        /**
         **消息点击消失
         **/
        $("#qqq,#qResult").click(function () {
            $(this).hide(1000);
            //$("#messageAudio")[0].pause();
        });

    });

</script>
<body>
<div class="Frame_right_ico index_body_img" id="Frame_right_ico">
    <ul style="width: 255px;" class="index_gnmk" id="index_gnmk">
        <c:forEach var="list" items="${list}">
            <li>
                <a href="javascript:void(0)"
                   openMode="tabMenu" biaozhi="${list.id }"
                   link_URL="${list.url }"
                   title="${list.title }"> <span> <img
                        src="${ctx}/css/images/ZXICO/${list.img }" width="${systemConfig.imgHW}"
                        height="${systemConfig.imgHW}"/>
									<div>${list.name }</div>
							</span>
                </a>
            </li>
        </c:forEach>
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

    <ul class="index_message" style="max-width:380px;">
        <li style="width:auto;display: none;" id="qqq">
            <a href="javascript:void(0)"
               openMode="tabMenu" biaozhi="12000000"
               link_URL="${ctx }/misEmrMdfreq.do?method=findMisEmrMdfs&stat=0"
               title="修改审批">
                <span>修改申请！</span>
            </a>
        </li>
        <li style="width:auto;display: none;" id="qResult">
            <a href="javascript:void(0)"
               openMode="tabMenu" biaozhi="13000000"
               link_URL="${ctx }/misEmrMdfreq.do?method=findMisEmrMdfs&stat=1"
               title="审批结果">
                <span>审批结果！</span>
            </a>
        </li>
    </ul>

</div>
<!-- 		controls="controls" -->
<audio id="messageAudio">
    <source src="${ctx}/css/message.mp3" type="audio/mpeg"></source>
</audio>
</body>
</html>
