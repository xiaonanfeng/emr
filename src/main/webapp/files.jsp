<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@ include file="/taglibs.jsp" %>
<script type="text/javascript">
    $(document).ready(function () {

        $(".del").click(function () {
            if (confirm("确定删除么？") == false) {
                return;
            }

            var fileId = $(this).attr("fileId");
            var emrId = $(this).attr("emrId");
            $.ajax({
                contentType: "application/x-www-form-urlencoded; charset=utf-8",
                url: "${ctx}/misFiles.do?method=delMisFilesById&fileId=" + fileId + "&emrId=" + emrId,
                type: "post",
                success: function (data) {
                    $("#div" + fileId).hide(1500);
                    $("#adiv" + fileId).hide(1500);
                },
                error: function (XMLHttpRequest, textStatus, errorThrown) {
                    alert("删除失败！");
                }
            });
        });
    });
</script>
<table width="100%" border="0" cellpadding="0" cellspacing="0"
       class="table_list">
    <c:forEach var="fileList" items="${fileList }">
        <tr>
            <div id="adiv${fileList.id}">
                <th class="text_decollator" id="basicInfo">
                    附件类型：${fileList.relatedTypeStr }
                    <br/>
                    上传时间 <fmt:formatDate value="${fileList.uploadTime}" type="both" dateStyle="long"
                                         pattern="yyyy-MM-dd HH:mm:ss"/>
                </th>
                <th>
                    <a style="cursor: pointer;" fileId="${fileList.id }"
                       emrId="${fileList.ralatedId}" class="del"><img alt="删除" title="删除"
                                                                      src="${ctx}/css/images/ZXICO/delBig.png"/>
                    </a>
                </th>
            </div>
        </tr>
        <tr>
            <td colspan="2">
                <div id="div${fileList.id}">
                    <img
                            src="<%=basePath%><%=Constants.UPLOAD_PATH %>${sysMemberInfo.id}/${fileList.name}"
                            width="99%"/>
                    <!-- 					项目路径/缓存路径/用户缓存文件夹 /文件名	 -->
                </div>
            </td>
        </tr>
    </c:forEach>
</table>
