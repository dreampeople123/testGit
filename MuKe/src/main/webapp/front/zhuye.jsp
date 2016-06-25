<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>主页</title>
<!-- <base href="./front/zhuye.jsp"> -->
<link rel="shortcut icon" href="../images/1.png" type="image/x-icon"/>
<link rel="stylesheet" href="css/zhuye.css" type="text/css"/>
<!-- <link rel="stylesheet" href="../css/bootstrap.css" type="text/css"/> -->
<link rel="stylesheet" href="css/footer.css" type="text/css" />
<link rel="stylesheet" href="css/header.css" type="text/css" />
<link rel="stylesheet" href="css/login.css" type="text/css" />
<script type="text/javascript" src="js/jquery-1.11.3.min.js"></script>
<script type="text/javascript" src="js/header.js"></script>
<script type="text/javascript" src="js/zhuye.js"></script>
<script type="text/javascript" src="js/login.js"></script>



</head>
<body id="index">
<div id="heads">
<%@ include file="header.jsp" %>
</div>

<div class="g-banner">
    <div class="g-banner-content">
        <ul id="g-banner-img">
            <li style="display:block" id="first_img"><img src="images/zhuye1.jpg"></li>
            <li style="display:none" id="second_img"><img src="images/zhuye2.jpg"></li>
    	</ul>
    </div><!--g-banner-content结束-->
    <div id="banner-dots">
    	<span id="left"><img class="img-left" src="images/left.png"></span>
        <span id="right"><img class="img-right" src="images/right.png"></span>
    </div><!--banner-dots结束-->
</div><!--g-banner结束-->

<div class="intro intro1 bg-grey idx-minwidth">
	<img src="images/zhuye3.png"/>
</div><!--intro1结束-->
<div class="intro intro1 bg-grey idx-minwidth">
	<img src="images/zhuye4.png"/>
</div><!--intro1结束-->
<div class="intro intro1 bg-grey idx-minwidth">
	<img src="images/zhuye5.png"/>
</div><!--intro1结束-->
<div class="intro intro1 bg-grey idx-minwidth">
	<img src="images/zhuye6.png"/>
</div><!--intro1结束-->
<div class="intro intro1 bg-grey idx-minwidth">
	<img src="images/zhuye7.png"/>
</div><!--intro1结束-->
<div id="mooc-dynamic" class="dynamic bg-grey idx-minwidth">
	<ul class="dynamic-group ckearfix">
    	<li>
        	<a target="_blank" href="#">
            	<img alt="java学习专题" src="images/javaxxzt.jpg">
            </a>
        </li>
        <li>
        	<a target="_blank" href="#">
            	<img alt="ipad上线" src="images/ipad.jpg">
            </a>
        </li>
        <li>
        	<a target="_blank" href="#">
            	<img alt="图灵图书馆推广" src="images/tulin.jpg">
            </a>
        </li>
    </ul>
</div><!--mooc-dynamic结束-->
<div class="icourse">
	<center>
		<div class="icourse-wrap idx-width">
	    	<h2 class="icourse-title hide-text">课程</h2>
	        <ul class="icourse-course clearfix">
		        <c:forEach items="${currentCourseDetail }" var ="a">
		        	<li class="icourse-course-li">
		            	<a href="/learn/544">
		                	<div class="icourse-img">
		                    	<img id="icourse-img1" alt="" src="../${a.cpic }">
		                        <span class="icourse-learnt" style="display:none">你已参加本课程</span>
		                    </div><!--icourse-img结束-->
		                    <div class="icourse-intro title">  
		                    	<p class="icourse-intro-p">Multitasking</p>
		                        <span class="l" >更新至4-1</span>
		                        <span class="r" >课程时长：48分</span>
		                    </div><!--icourse-intro clearfix结束-->
		                    <div class="icourse-intro introduce" hidden="hidden" >
		                    	<p class="icourse-intro-p2">${a.cintro }</p>
		                        <span class="l" >14小时之前更新</span>
		                        <span class="r" >571学习</span>
		                    </div><!--icourse-tips clearfix结束-->
		                </a>
		            </li>
		        </c:forEach>
	        </ul>
	        
	        <div class="icourse-footer">
	            <a href="courses_findAllTypes.action">全部课程</a>
	        </div><!--icourse-footer结束-->
	        
	    </div><!--incourse-wrap-->
    </center>
</div><!--icourse结束-->

<div id="footer">
    <div class="footer_intro l">
        <div class="footer_link">
            <ul>
                <li><a href="#" target="_blank">网站首页</a></li>
                <li><a href="#" target="_blank">人才招聘</a></li>
                <li><a href="#" target="_blank">联系我们</a></li>
                <li><a href="#" target="_blank">高校联盟</a></li>
                <li><a href="#" target="_blank">关于我们</a></li>
                <li><a href="#" target="_blank">讲师招募</a></li>
                <li><a href="#" target="_blank">意见反馈</a></li>
                <li><a href="#" target="_blank">友情链接</a></li>
            </ul>
        </div><!--footer_link结束-->
        <br/>
        <p>
        	<span style="color:#999">Copyright  2015 imooc.com All Rights Reserved | 京ICP备 13046642号-2</span>
        </p>
    </div><!--footer_intro l结束-->
</div><!--footer结束-->
</body>
</html>
