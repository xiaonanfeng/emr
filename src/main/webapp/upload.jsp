<%@ page language="java" import="java.util.*" pageEncoding="utf-8" %>
<link rel="stylesheet" type="text/css"
      href="${ctx}/js/upload/css/webuploader.css"/>
<link rel="stylesheet" type="text/css"
      href="${ctx}/js/upload/css/style.css"/>
<script type="text/javascript" src="${ctx}/js/upload/js/webuploader.js"></script>
<script type="text/javascript" src="${ctx}/js/upload/js/upload.js"></script>
<div id="uploader" style="display: none;">
    <div style="float: right;">
        附件类型${relatedType }
    </div>
    <br/>
    <div class="queueList">
        <div id="dndArea" class="placeholder">
            <div id="filePicker">
            </div>
            <p>
                拖拽到虚线区域最多可选30张
            </p>
        </div>
    </div>
    <div class="statusBar" style="display:none;">
        <div class="progress">
            <span class="text">0%</span>
            <span class="percentage"></span>
        </div>
        <div class="info"></div>
        <div class="btns">
            <div id="filePicker2"></div>
            <div class="uploadBtn">上传附件</div>
        </div>
    </div>
</div>
