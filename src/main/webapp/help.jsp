<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@ include file="/taglibs.jsp" %>
<table width="100%" border="0" class="editForm">
    <tr>
        <th class="text_decollator" colspan="2" id="fileDown"><span>文件下载</span>
        </th>
    </tr>
    <tr group="fileDown">
        <td class="text_into" width="20%">如果你在电脑上看到的界面很乱</td>
        <td class="text_edit"><a href="${ctx}/download/chrome.exe">EXE下载（电脑端）</a></td>
    </tr>
    <tr group="fileDown">
        <td class="text_into">如果你在电脑上看到的界面很乱</td>
        <td class="text_edit"><a href="${ctx}/download/chrome.apk">APK下载（平板端）</a></td>
    </tr>
    <tr group="fileDown">
        <td class="text_into">急救通</td>
        <td class="text_edit"><a href="${ctx}/download/amb.apk">急救通主程序</a></td>
    </tr>
    <tr group="fileDown">
        <td class="text_into">使用视频</td>
        <td class="text_edit"><a href="${ctx}/download/vdo.rar">使用视频</a></td>
    </tr>
</table>
<table width="100%" border="0" class="editForm">
    <tr>
        <th class="text_decollator" colspan="2" id="fileDown">问题答疑</span>
        </th>
    </tr>

    <tr>
        <th>
            Q:需要安装么？更新怎么办？我需要什么样的电脑和操作系统？
        </th>
    </tr>
    <tr>
        <td>
            A:本程序理论上无需任何安装，无需手动更新，支持任何操作系统的电脑包括xp/vista/7/8/8.1/10/mac/linux。
        </td>
    </tr>
    <tr>
        <th>
            Q:这个系统能不能在自己手机或者家用电脑上用？
        </th>
    </tr>
    <tr>
        <td>
            A：技术上可行，仅仅是技术上可行。看使用环境！
        </td>
    </tr>
    <tr>
        <th>
            Q:为什么提示 “对不起！您已经下班了！”？
        </th>
    </tr>
    <tr>
        <td>
            A：答案很简单，因为您已经下班了！但是您依然可以在电脑上查询电子病历！
        </td>
    </tr>
    <tr>
        <th>
            Q:病历查询出来的结果很乱？
        </th>
    </tr>
    <tr>
        <td>
            A：一、电脑登陆查询出的是近一个月内您所在分站所有的病历！您只能修改自己的！<Br/>
            二、PAD登陆查询出的是近一个月内中心拍给您所在车辆的接车信息！
        </td>
    </tr>
    <tr>
        <th>
            Q:为什么病历没有保存也没有上传附件按钮？
        </th>
    </tr>
    <tr>
        <td>
            A：一、病历已提交！<Br/>
            二、病例的第一填写人和现在登录的工号不一致！
        </td>
    </tr>
    <tr>
        <th>
            Q:病历有没有自动提交？
        </th>
    </tr>
    <tr>
        <td>
            A：一、有！按照医务科相关规定96小时自动提交。
        </td>
    </tr>
    <tr>
        <th>
            Q:病历最后出现了一个红色的X！
        </th>
    </tr>
    <tr>
        <td>
            A：一、那是删除，本人只能删除本人的，并且不能删除 已经提交的。
        </td>
    </tr>

</table>