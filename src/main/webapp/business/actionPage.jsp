<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>

<!-- 审核评分（医院用） -->
<c:if test="${actionButton==0&&param.level!=0}">
    <a biaozhi="${list.emrid}" openMode="tabMenu" tab_title="${list.name }"
       class="search"
       link_url="${ctx}/emr.do?method=initEmr&id=${list.emrid}&ccxh=${list.ccxh}&lsh=${list.lsh}">查看</a>
    <c:if test="${list.isCommitted==1	}">
        <a biaozhi="sorce${list.emrid}level${param.level}" openMode="tabMenu"
           tab_title="审核:${list.name}（${param.level}）" class="add"
           link_url="${ctx}/vMisEmrScoreTypeStdd.do?method=findMisEmrScoreTypeStdd&id=${list.emrid}&level=${param.level}">审核</a>
    </c:if>
</c:if>

<!-- 审核评分（中心用） -->
<c:if test="${actionButton==0&&param.level==0}">
    <a class="listSorce" emrId="${list.emrid}">评分记录</a>

    <a biaozhi="${list.emrid}" openMode="tabMenu" tab_title="${list.name }"
       class="search"
       link_url="${ctx}/emr.do?method=initEmr&id=${list.emrid}&ccxh=${list.ccxh}&lsh=${list.lsh}">查看</a>
</c:if>


<!-- 查询打印 -->
<c:if test="${actionButton==1}">
    <a biaozhi="${list.emrid}" openMode="tabMenu" tab_title="${list.name }"
       class="search"
       link_url="${ctx}/emr.do?method=initEmr&id=${list.emrid}&ccxh=${list.ccxh}&lsh=${list.lsh}">查看</a>
    <a biaozhi="${list.emrid}" openMode="newWin" tab_title="${list.name }"
       class="print"
       link_url="${ctx}/emr.do?method=initEmr&print=1&id=${list.emrid}&ccxh=${list.ccxh}&lsh=${list.lsh}">打印</a>
    <c:if
            test="${list.isCommitted==0 && list.createuserid==sysMemberInfo.id}">
        <!-- 没有提交并且是填写人 -->
        <a href="javascript:void(0)" class="del"
           onclick="del('${list.emrid}')">删除</a>
    </c:if>
</c:if>

<!-- 急救告知通知书 -->
<c:if test="${actionButton==2}">
    <a biaozhi="notice${list.emrid}" openMode="tabMenu"
       tab_title="急救告知:${list.name}" class="add"
       link_url="${ctx}/misEmrNotice.do?method=findMisEmrNoticeItemAndContext&id=${list.emrid}&print=0">急救告知</a>
    <a biaozhi="notice${list.emrid}" openMode="newWin"
       tab_title="急救告知:${list.name}" class="print"
       link_url="${ctx}/misEmrNotice.do?method=findMisEmrNoticeItemAndContext&id=${list.emrid}&print=1">打印</a>
</c:if>

<!-- 交接记录 -->
<c:if test="${actionButton==3}">
    <a biaozhi="handover${list.emrid}" openMode="tabMenu"
       tab_title="交接记录:${list.name}" class="add"
       link_url="${ctx}/misEmrHandover.do?method=findMisEmrHandoverById&id=${list.emrid}&print=0">交接记录</a>
    <a biaozhi="handover${list.emrid}" openMode="newWin"
       tab_title="交接记录:${list.name}" class="print"
       link_url="${ctx}/misEmrHandover.do?method=findMisEmrHandoverById&id=${list.emrid}&print=1">打印</a>
</c:if>

<!-- 收费记录 -->
<c:if test="${actionButton==4}">
    <a biaozhi="charges${list.emrid}" openMode="tabMenu"
       tab_title="收费记录:${list.name}" class="add"
       link_url="${ctx}/vMisEmrChargeitemsCode.do?method=findVMisEmrChargeitemsCode&emrId=${list.emrid}&print=0">收费记录</a>
</c:if>

<!-- 护理信息 -->
<c:if test="${actionButton==5}">
    <a biaozhi="nursing${list.emrid}" openMode="tabMenu"
       tab_title="护理记录:${list.name}" class="add"
       link_url="${ctx}/misEmrNursingRecord.do?method=findMisEmrNursingRecordById&emrId=${list.emrid}&print=0">护理记录</a>

    <a biaozhi="nursing${list.emrid}" openMode="newWin"
       tab_title="护理记录:${list.name}" class="print"
       link_url="${ctx}/misEmrNursingRecord.do?method=findMisEmrNursingRecordById&emrId=${list.emrid}&print=1">护理记录</a>
</c:if>

<!-- 修改申请 -->
<!-- 如果病历已经提交并且是本人填写的病历，则允许发出一个修改申请 -->
<c:if
        test="${actionButton==6&&list.isCommitted==1&&list.createuserid==sysMemberInfo.id}">
    <a id="mdf${list.emrid}" biaozhi="mdf${list.emrid}"
       openMode="open_layer" tab_title="修改申请:${list.name}" class="add"
       link_url="${ctx}/misEmrMdfreq.do?method=findMisEmrMdfReqByEmrId&emrId=${list.emrid}">修改申请</a>
</c:if>



