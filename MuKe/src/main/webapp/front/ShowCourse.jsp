<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>显示查询的课程</title>


<link rel="stylesheet" href="css/header.css" type="text/css" />
<link rel="stylesheet" href="css/ShowCourse.css" type="text/css" />
<link rel="stylesheet" href="css/footer.css" type="text/css" />


<script type="text/javascript" src="js/jquery-1.11.3.min.js"></script>

<script type="text/javascript" src="js/showpic.js"></script>
<script type="text/javascript" src="js/ajaxfileupload.js"></script>
<script type="text/javascript" src="js/header.js"></script>
<script type="text/javascript" src="js/ShowCourse.js"></script>
</head>
	<script>
		$.post("../courseServlet?d="+new Date(),{op:"showCourseByAttention"});
	</script>




<body>

<%@ include file="header.jsp" %>

<div id="main">
	<div class="search-container">
        <!--banner start-->
        <div class="search-banner">
            <div class="search-box clearfix" data-search="search-page">
                <div class="suggest-input-box l">
                    <input id="showCname" style="border: 0px; " class="suggest-input J-suggest-input" data-suggest-trigger="suggest-trigger" placeholder="请输入想搜索的内容..." type="text" autocomplete="off"/>
                </div>
                <input type="button" style="border: 0px; height: 47px;" class="btn-search" data-search-btn="search-btn" value="搜索" onClick="findCourseByCnameTwo()" />
                <ul class="suggest-list" data-suggest-result="suggest-result">

				</ul>
            </div>
        </div>
        <!--banner end-->

        <div class="search-result clearfix">
        
            <div class="result-list J-result-list">
                <div class="result-header clearfix">
                	<c:choose>
                		
                		<c:when test="${not empty courseBean}">
                			为您找到相关课程<span style="font-size:25px">${courseBean.size()}</span>个
	                	</c:when>
	                		
	                	<c:otherwise>
	                		很抱歉没有找到你要找的信息
	                	</c:otherwise>
	                	
	               </c:choose>
                	
                </div>
                
                <div class="cp-tab-pannel js-comp-tab-pannel" style="display:block" data-pannel="course">
						 <ul class="other-list">
						 	<c:forEach items="${courseBean}" var="aaa">
						 		<li class="img" style="float:left;margin-top:40px;">
		                            <a target="_blank" href="courses_showCoursesByCno.action?cNo=${aaa.cNo }" target="_blank" >
		                                <img  id="course_img"  src="../../upload/${aaa.cPic}" >
		                                <span class="name autowrap">${aaa.cName }</span>
		                            </a>
		                        </li>
						 	</c:forEach>
                    	</ul>
        	   </div><!--cp-tab-pannel结束-->
                    
                    <div class="nodata">
                        <div class="autowrap txt" style="display:none">
                            没有关于“java基础”的结果
                        </div>
                    </div>
                </div>
        </div>
            <!--search result end-->

    
        <!--hot-search start-->
        <dl class="hot-search r">
            <dt>热门搜索</dt>
            <dd>
            	<c:forEach items="${hotCourse }" var="htcourse">
            		 <a title="ss" href="#">${htcourse.cname }</a>
            	</c:forEach>
            </dd>
        </dl>
        <!--hot-search end-->
  	  </div>
</div>

<div id="footer">
    <div class="footer_intro l">
        <div class="footer_link">
            <ul >
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
