<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.net.URLEncoder"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!doctype html>
<html>
<head>
<meta content="text/html; charset=UTF-8" http-equiv="Content-Type">
<meta charset="utf-8">
<title>招聘讲师</title>
<link rel="shortcut icon" href="../images/1.png" type="image/x-icon"/>
<link href="css/zp.css" rel="stylesheet">
<link rel="stylesheet" href="css/header.css" type="text/css" />
<!--<link rel="stylesheet" href="css/footer.css" type="text/css" /> -->
<script type="text/javascript" src="js/jquery-2.1.1.js"></script>
<script type="text/javascript" src="js/zhaopin.js"></script>
<script type="text/javascript">

</script>
</head>

<body>
	<div id="header">
    	<div id="logo">
    		<a href="zhuye.html" target="_self" class="hide-text">慕课网</a>
    	</div>
    	<div id="choose">
        	<a href="#" class="menu-ctrl"><i class="icon-menu"></i></a>
            <ul>
                <li><a href="coursein.html" target="_self">课程</a></li>
                <li><a href="Community.html" target="_self">社区</a></li>
            </ul>
    	</div>
    	<div id="login">
            <ul class="header-unlogin clearfix">
                <li class="header-signin"><a href="#" id="js-signin-btn">登录</a></li>
                <li class="header-signup"><a href="#" id="js-signup-btn">注册</a></li>
            </ul>
    	</div>
        <div id="search_out" data-search="top-banner">
            <input id="search-input-out" data-suggest-trigger="suggest-trigger" placeholder="请输入想搜索的内容..." autocomplete="off" type="text" onFocus="change2White(this)" onBlur="change2Gray(this)">
            <ul class="search-area-result" data-suggest-result="suggest-result"></ul>
            <input id="search_btn_out" data-search-btn="search-btn" type="button">
        </div>
	</div>
	
	<div id="main">
    <div class="content">
    	<div class="left">
        	 <div class="head">
            <h2 class="deepen-col">欢迎加入慕课讲师团，世界因你而精彩</h2>
        </div>
        <div class="contents">
            <form>
                <table>
                    <tbody><tr>
                        <td class="label"><span class="star">*&nbsp;</span>我的简介</td>
                        <td class="textarea">
                            <textarea class="apply-introduction" id="apply-introduction" placeholder="输入我的简介" onKeyUp="checkWord(this);" onMouseDown="javascript:checkWord(this);" ></textarea>
                            <div class="portrait">
                                <a href="http://www.imooc.com/space/u/uid/1047215"><img src="images/mtr.jpg"></a>
                                <a class="nickname deepen-col" href="http://www.imooc.com/space/u/uid/1047215">木头人_0026</a>
                            </div>
                            <p class="tip font-num">
                                <span class="lefts">简介尽可能体现您的主攻技术方向,从业经历,公开分享的经验等</span>
                                <span id="shenzi" class="rights">剩余200字</span>
                            </p>
                            
                        </td>
                    </tr>
                    <tr>
                        <td class="label"><span class="star">*&nbsp;</span>我的姓名</td>
                        <td>
                            <input id="apply-name" class="true-name" placeholder="输入你的姓名" type="text">
                            <p class="tip">输入你的真实姓名</p>
                        </td>
                    </tr>
                    <tr>
                        <td class="label"><span class="star">*&nbsp;</span>联系方式</td>
                        <td>
                            <input id="apply-phone" class="phone-num" placeholder="输入手机号码" type="text">
                            <p class="tip">慕课网将通过此方式与你取得联系</p>
                        </td>
                    </tr>
                    <tr>
                        <td class="label">试讲视频</td>
                        <td>
                            <input id="apply-media" class="media" placeholder="选择试讲视频" type="file">
                            <p class="tip">上传试讲视频，可选填</p>
                        </td>
                    </tr>
                    <tr>
                        <td class="label"></td>
                        <td>
                            <button class="btn btn-green" type="button" id="lecturer-submit">提交</button>
                            <p class="warning tip"></p>
                        </td>
                    </tr>
                </tbody></table>
            </form>
        </div>
        </div>
   
        <div class="right" >
               <!-- 应聘讲师 -->
<div class="hire shadow">
	<img src="images/hire_img.jpg" alt="" class="hire_img">
	<p class="hire-reason">如果你对本课程领域擅长、能按照自己或者本求课的描述分享你的知识给互联网用户，就来应聘吧</p>
	<p class="hire-reason">你的课程会在慕课网及我们的合作渠道中展示和推广，你就是未来的行业大牛</p>
	<p class="hire-reason">慕课网还会为你支付课程公益津贴，让你得到既实际又实惠的回报</p>
</div>
<!-- 讲师团成员 -->
<div class="lecturer">
	<h2 class="lecturer-hd">他们也在慕课讲师团</h2>
	<ul class="lecturer-bd">
		<li>
			<a class="lecturer-col" href="http://www.imooc.com/space/teacher/id/101768" target="_blank">
				<img class="lecturer-img" src="images/dcxp.jpg" alt="">
				<i class="lecturer-name">大城小胖</i>
			</a>
			<p class="lecturer-intro">国内知名前端和Java工程师、著名HTML5专家、独立游戏开发者</p>
		</li>
		<li>
			<a class="lecturer-col" href="http://www.imooc.com/space/teacher/id/101686" target="_blank">
				<img class="lecturer-img" src="images/yr.jpg" alt="">
				<i class="lecturer-name">远人</i>
			</a>
			<p class="lecturer-intro">先后就职于腾讯、人人网，资深的云前端工程师，首席前端架构师</p>
		</li>
		<li>
			<a class="lecturer-col" href="http://www.imooc.com/space/teacher/id/103747" target="_blank">
				<img class="lecturer-img" src="images/dmqq.jpg" alt="">
				<i class="lecturer-name">大漠穷秋</i>
			</a>
			<p class="lecturer-intro">《Ext江湖》、《ActionScript3.0游戏基础（第二版）》、《使用AngularJS开发下一代WEB应用》作者</p>
		</li>
	</ul>
</div>
        	
        </div>
       	
    </div>
    <div class="footer">
        <div class="footer_intro l">
            <div class="footer_link">
                <ul>
                    <li><a href="#" target="_blank">网站首页</a></li>
                    <li><a href="#" target="_blank">人才招聘</a></li>
                    <li><a href="#" target="_blank">联系我们</a></li>
                    <li><a href="#" target="_blank">高校联盟</a></li>
                    <li><a href="aboutUs.html" target="_blank">关于我们</a></li>
                    <li><a href="#" target="_blank">讲师招募</a></li>
                    <li><a href="#" target="_blank">意见反馈</a></li>
                    <li><a href="#" target="_blank">友情链接</a></li>
                </ul>
            </div>
            <br/>
            <p>
                <span style="color:#999">Copyright  2015 imooc.com All Rights Reserved | 京ICP备 13046642号-2</span>
            </p>
        </div>
	</div>


</body>
</html>
