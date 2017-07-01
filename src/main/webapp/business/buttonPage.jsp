<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<div id="list-menu"><!-- 可显示 可不显示 -->
    <a id="showPrint" class="btn btn_yellow" type="button"
       onclick="javascript:window.open('${ctx}/emr.do?method=initEmr&print=1&id=${misEmrBasicinfo.id}&ccxh=${param.ccxh}&lsh=${param.lsh}')">
        打印
    </a>

    <c:if test="${fileSize!=0 }">
        <a id="showPic" class="btn btn_yellow" type="button"
           onclick="open_layer('附件','${ctx}/misFiles.do?method=findMisFilesByEmrId&emrId=${misEmrBasicinfo.id}')">
            查看附件
        </a>
    </c:if>

    <c:if test="${modSize!=0 }">
        <a id="showMdf" class="btn btn_yellow" type="button"
           onclick="open_layer('修改记录','${ctx}/misEmrModifyRecord.do?method=findMisEmrModifyRecordByEmrId&id=${misEmrBasicinfo.id}')">
            修改记录
        </a>
    </c:if>

    <a id="addNotice" class="btn btn_yellow" type="button" biaozhi="notice${misEmrBasicinfo.id}"
       tab_title="急救告知:${misEmrBasicinfo.name}"
       link_url="${ctx}/misEmrNotice.do?method=findMisEmrNoticeItemAndContext&id=${misEmrBasicinfo.id}&print=0"
       openMode="tabMenu">
        急救告知
    </a>

    <a id="addHandOver" class="btn btn_yellow" type="button" biaozhi="handover${misEmrBasicinfo.id}"
       tab_title="交接记录:${misEmrBasicinfo.name}"
       link_url="${ctx}/misEmrHandover.do?method=findMisEmrHandoverById&id=${misEmrBasicinfo.id}&print=0"
       openMode="tabMenu">
        交接记录
    </a>

    <a id="addCharges" class="btn btn_yellow" type="button" biaozhi="charges${misEmrBasicinfo.id}"
       tab_title="收费记录:${misEmrBasicinfo.name}"
       link_url="${ctx}/vMisEmrChargeitemsCode.do?method=findVMisEmrChargeitemsCode&emrId=${misEmrBasicinfo.id}&print=0"
       openMode="tabMenu">
        收费记录
    </a>
</div>
<script src="${ctx}/js/mouse-menu-1.0/Script/mouse-menu.js"></script>
<link href="${ctx}/js/mouse-menu-1.0/Style/mouse-menu.css" rel="stylesheet" type="text/css">
<script>
    var option = []

    $(document).ready(function () {
        $('#list-menu a').each(function (index, element) {
            var item = $(element)
            //if(item.attr('isHave')){  //可做判断 显示和不现实通过元素熟悉值当下都显示
            if (true) {
                var obj = {
                    html: '<span>' + item.prop("outerHTML") + '</span>'
                }
                option.push(obj)
            }
        })
        mouseMenu(option)//可传另一个参数 默认：input|textarea
    })
</script>			