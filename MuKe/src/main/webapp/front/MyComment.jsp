<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
<meta charset="utf-8">
<title>慕课网-学习计划</title>
<link rel="shortcut icon" href="../images/1.png" type="image/x-icon"/>
<link rel="stylesheet" href="css/My.css" type="text/css" />
<link rel="stylesheet" href="css/header.css" type="text/css" />
<link rel="stylesheet" href="css/footer2.css" type="text/css" />
<link rel="stylesheet" href="css/MyComment.css" type="text/css" />
<script type="text/javascript" src="js/jquery-2.1.1.js"></script>
<script type="text/javascript">
	var uno="${loginUser.uNo}";
	console.info("loginUser.uNo"+uno);
	$(function(){
		var comments="${comments}";
		if(comments==null || comments==""){
			location.href="Middle.jsp?op=comment&nowPage=1";
		}else{
		}
	})
</script>
<script type="text/javascript" src="js/MyCourse.js"></script>
<script type="text/javascript" src="js/header.js"></script>
<script type="text/javascript" src="js/MyComment.js"></script>
</head>
  
<body>
<%@include file="header.jsp" %>
<div id="main">
    <div class="main-body">
        <div class="l">
            <div class="sider">
                <div class="user-info">
                    <span class="user-pic"><img src="../../upload/${loginUser.uPic }" title=""></span>
                    <ul class="user-lay">
                        <li class="mynick-name"><span class="user-name">${loginUser.uName }</span></li>
                        <li><span class="user-site">meiyou </span></li>
                        <li><a href="#" class="user-setup">设置</a></li>
                    </ul>
                </div>
                <div class="user-desc">
                    <div class="sign-wrap">
                        <p style="cursor:default" id="signed" class="signed" onClick="setDesc()">
                        	<c:if test="${not empty  loginUser}">
                            	<span>${loginUser.uUsign}</span>
                        	</c:if>
                        	<c:if test="${empty  loginUser}">
                        		<span>这位同学很懒，什么也没留下~~~</span>
                        	</c:if>
                            <img src="images/edit.jpg" />
                        </p>
                        <c:if test="${not empty  loginUser}">
                          	<textarea class="sign-editor" id="js-sign-editor" onBlur="setDesc2()">${loginUser.uUsign}</textarea>
                      	</c:if>
                      	<c:if test="${empty  loginUser}">
                      		<textarea class="sign-editor" id="js-sign-editor" onBlur="setDesc2()">这位同学很懒，什么也没留下~~~</textarea>
                      	</c:if>
                    </div>
                </div>
                <ul class="mp-clearfix">
                    <li class="l-mp-item">
                        <span class="mp-atag">
                            <strong><p class="mp-num">${loginUser.uAddress_prov }</p></strong>
	                    	<p class="mp-title">${loginUser.uAddress_city }&nbsp;${loginUser.uAddress_county }</p>
                        </span>
                    </li>
                </ul>
                <h1>${key }key</h1>
                <ul class="nav">
                    <li><a class="js-count-course" href="MyCourse.jsp"><i class="icon-nav1-out"></i>我的课程</a></li>
                    <li><a class="js-count-note active" href="#"><i class="icon-nav3-out" style="background:url(images/myNote-red.jpg) no-repeat left center"></i>我的评论</a></li>
                    <li><a class="js-count-code" href="Middle.jsp?op=ask&nowPage=1"><i class="icon-nav4-out"></i>我的问答</a></li>
                    <c:if test="${loginUser.uIsTeacher eq 1}">
	            <li><a class="js-count-code" href="upload.jsp"><i class="icon-nav4-out"></i>上传视频</a></li>
	            </c:if>
                    <li class="rd-dissu">
                        <a class="read-mine" href="Community.jsp">查看我的社区</a>
                        <p class="read-notice">看看里面有什么好玩的事情吧～～</p>
                    </li>
                </ul>
            </div>
        </div>
        <div class="space-main">
        	<div class="family">
				我的评论
            </div>
            
    		<div class="course-tool-bar-note">
				<span id="commentTotal">共<span>${myCommentTotal }</span>条</span>
				<!-- <span id="nowPage">1</span>/<span id="totalPage">1</span> -->
  			</div>
  			<c:if test="${empty comments}">
	            <center>
	                <div id="nothing" style="height:308px; line-height:308px; font-size:18px; color:#ccc;">
	                    <p>暂无任何评论</p>
	                </div>
	            </center>
            </c:if>
            
            <c:if test="${not empty comments }">
	            <div class="myspace-courselist">
	                <c:forEach items="${comments }" var="item">
	                <div class="discuss" courseid="85" noteid="600367">
	                	<div class="detailmeg">
	                        <a class="detailcom practice" href="javascript:gotoCha(${item.chapter.chNo},${item.chapter.course.cNo },${item.user.uNo })" >
	                        	<i><img src="images/lxt.jpg" /></i>${item.chapter.course.cName }<i class="thin"> ${item.chapter.chName}</i>
	                        </a>
	                        <div class="report clearfix">
	                            <div class="js-notelist-content notelist-content mynote">
	                                <p>${item.coContent}</p>
	                            </div>
	                        </div>
	                        <div class="anal-time">
	                            <span class="finaltime">评论时间:${item.coTime }</span>
	                        </div>
	                    </div>
	                    <div class="editordel" style="display:none;">
	                        <a href="Middle.jsp?op=delCom&coNo=${item.coNo}" class="delnote" data-cid="85" title="删除此条评论">
	                            <i class="icon sns-delete"><img id="del-img" src="images/del-gray.jpg" /></i>
	                            <em id="del-text">删除</em>
	                        </a>
	                    </div>
	                </div>
	                </c:forEach>
	            </div>
            </c:if>
            
    	</div>
	</div>
</div>

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