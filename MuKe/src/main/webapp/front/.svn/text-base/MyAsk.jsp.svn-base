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
<link rel="stylesheet" href="css/footer.css" type="text/css" />
<link rel="stylesheet" href="css/MyAsk.css" type="text/css" />
<script type="text/javascript" src="js/jquery-2.1.1.js"></script>
<script type="text/javascript" src="js/header.js"></script>
<script type="text/javascript">
	var uno="${loginUser.uno}";
	$(function(){
		var user='${asks}';
		if(user=="" || user==null){
			location.href="Middle.jsp?op=ask";
		} else{
			
		}
	});
</script>
<script type="text/javascript" src="js/MyCourse.js"></script>
</head>

<body>
<%@include file="header.jsp" %>
<div id="main">
    <div class="main-body">
        <div class="l">
            <div class="sider">
                <div class="user-info">
                    <span class="user-pic"><img src="images/55aef90d0001f2a502400180.jpg" title=""></span>
                    <ul class="user-lay">
                        <li class="mynick-name"><span class="user-name">${loginUser.uname }</span></li>
                        <li><span class="user-site">${loginUser.posname} </span></li>
                        <li><a href="#" class="user-setup">设置</a></li>
                    </ul>
                </div>
                <div class="user-desc">
                    <div class="sign-wrap">
                        <p style="cursor:default" id="signed" class="signed" onClick="setDesc()">
                        	<c:if test="${not empty  loginUser}">
                           		<span>${loginUser.usign}</span>
                       		</c:if>
                       		<c:if test="${empty  loginUser}">
                       			<span>这位同学很懒，什么也没留下~~~</span>
                       		</c:if>
	                    	<img src="images/edit.jpg" />
                        </p>
	                        <c:if test="${not empty  loginUser}">
	                          	<textarea class="sign-editor" id="js-sign-editor" onBlur="setDesc2()">${loginUser.usign}</textarea>
	                      	</c:if>
	                      	<c:if test="${empty  loginUser}">
	                      		<textarea class="sign-editor" id="js-sign-editor" onBlur="setDesc2()">这位同学很懒，什么也没留下~~~</textarea>
	                      	</c:if>
                    </div>
                </div>
                <ul class="mp-clearfix">
                    <li class="l-mp-item">
                        <span class="mp-atag">
                            <strong><p class="mp-num">${loginUser.address_prov }</p></strong>
                            <p class="mp-title">${loginUser.address_city }&nbsp;${loginUser.address_county }</p>
                        </span>
                    </li>
                </ul>
                <ul class="nav">
                    <li><a class="js-count-course" href="MyCourse.jsp"><i class="icon-nav1-out"></i>我的课程</a></li>
                    <li><a class="js-count-note" href="Middle.jsp?op=comment"><i class="icon-nav3-out"></i>我的评论</a></li>
                    <li><a class="js-count-code active" href="#"><i class="icon-nav4-out" style="background:url(images/myCode-red.jpg) no-repeat left center"></i>我的问答</a></li>
                    <li class="rd-dissu">
                        <a class="read-mine" href="Community.jsp">查看我的社区</a>
                        <p class="read-notice">看看里面有什么好玩的事情吧～～</p>
                    </li>
                </ul>
            </div>
        </div>
        <div class="space-main">
        	<div class="family">
				 我的问答
            </div>
            <a id="newQuestion" href="NewQuestion.jsp">发新问题</a>
            <div id="fgdiv">
            </div>
            
            <c:if test="${empty asks }">
	            <center hidden="hidden">
	                <div id="nothing" style="height:308px; line-height:308px; font-size:18px; color:#ccc;">
	                    <p>暂无任何回答</p>
	                </div>
	            </center>
            </c:if>
            
            <c:if test="${not empty asks }">
	            <div style="padding-bottom: 60px" class="myspace-courselist">
	            	<ul class="myspace-courselist-ul">
	            		<c:forEach items="${asks }" var="item">
	                		<li>
								<p><a class="myAsk" href="javascript:gotoQuestion(${item.askno })">${item.asktitle }</a></p>
								<span class="askTime">${item.askTimes }</span>
								<span class="label">${item.cdirname }</span>
								<div class="answer">
									<span>${item.total }</span>
									<span>回答</span>
								</div>
	                   		</li>
	                	</c:forEach>
	                </ul>
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