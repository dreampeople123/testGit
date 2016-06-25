<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<link rel="stylesheet" href="css/login.css" type="text/css" />
<script type="text/javascript" src="js/login.js"></script>
<div id="header">
    <div id="logo"><a href="zhuye.jsp" target="_self" >慕课网</a></div>
    <div id="choose">
        <a href="#" class="menu-ctrl"><i class="icon-menu"></i></a>
        <ul>
            <li><a href="course.jsp" target="_self">课程</a></li>
            <li><a href="Middle.jsp?op=community" target="_self">社区</a></li>
        </ul>
    </div>
    <div id="login">
     	<c:if test="${empty loginUser}">
	        <ul class="header-unlogin clearfix">
	            <li class="header-signin"><a href="javascript:showDiv()" id="js-signin-btn">登录</a></li>
	            <li class="header-signup"><a href="javascript:showDiv()" id="js-signup-btn">注册</a></li>
	        </ul>
        </c:if>
        
        <c:if test="${not empty loginUser}">
        <img id="login_head_img" src="images/xkjm.png" />
        <div id="self_card">
      	<ul>
        	<li id="card_img">
        		<div id="user_pic">
            		<img src="images/thisisthis.jpg" />
            	</div>
                <span>${loginUser.uname }</span>
                <span>${loginUser.posname }</span>
            </li>
            <li id="card_mya">
            	<a href="MyCourse.jsp" id="mya_active">我的慕课</a>
                <a href="Community.jsp">我的社区</a>
            </li>
            
            <li id="card_course">
            	<span>${loginUser.usign }</span>
            </li>
            
            <li id="card_set">
            	<a href="" class="set1">个人设置</a>
                <a href="javascript:exit()" class="set2">退出</a>
            </li>
        </ul>
      </div> 
      </c:if>
    </div>
    <div id="search_out" data-search="top-banner">
        <input id="search-input-out" data-suggest-trigger="suggest-trigger" placeholder="请输入想搜索的内容..." autocomplete="off" type="text" onFocus="change2White(this)" onBlur="change2Gray(this)">
        <ul class="search-area-result" data-suggest-result="suggest-result"></ul>
        <input id="search_btn_out" data-search-btn="search-btn" type="button" onClick="findCourseByCnameOne()">
    </div>
</div>
<%@ include file="login.jsp" %>