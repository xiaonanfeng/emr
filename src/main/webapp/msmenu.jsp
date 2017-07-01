<%@ page language="java" import="java.util.*" pageEncoding="utf-8" %>
<%@ include file="/taglibs.jsp" %>
<html>
<head>
    <link rel="stylesheet" href="${ctx}/js/mouse-menu-1.0/Style/mouse-menu.css">
    <script src='${ctx}/js/mouse-menu-1.0/Script/mouse-menu.js'></script>
    <script>
        var formatH1 = '<span><span class="{class}"></span></span>'
        var formatH2 = '<span><img src="{src}"></span>'
        /* 配置 */
        var option = [
            {
                format: formatH2,
                classOrSrc: "images/conversion.png",
                callback: function () {
                    window.open('${ctx}/misFiles.do?method=findMisFilesByEmrId&emrId=1', 'newwin');
                }
            }, {
                format: formatH1,
                classOrSrc: "glyphicon glyphicon-sound-dolby",
                callback: function () {
                    alert('我是2')
                }
            }, {
                format: formatH1,
                classOrSrc: "glyphicon glyphicon-sound-dolby",
                callback: function () {
                    window.location.href = "http://www.baidu.com";
                }
            }, {
                format: formatH1,
                classOrSrc: "glyphicon glyphicon-sound-dolby",
                callback: function () {
                    alert('我是4')
                }
            }, {
                format: formatH1,
                classOrSrc: "glyphicon glyphicon-sound-dolby",
                callback: function () {
                    alert('我是5')
                }
            },
            {
                format: formatH1,
                classOrSrc: "glyphicon glyphicon-sound-dolby",
                callback: function () {
                    alert('我是5')
                }
            }
        ]

        $(document).ready(function () {
            mouseMenu(option)
        })
    </script>
</head>

<body>
</body>

</html>
    