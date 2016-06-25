<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>慕课网-问答</title>
<link rel="shortcut icon" href="../images/1.png" type="image/x-icon"/>
<link rel="stylesheet" href="css/Community.css" />
<link rel="stylesheet" href="css/header.css" type="text/css" />
<link rel="stylesheet" href="css/footer.css" type="text/css" />
<link rel="stylesheet" href="css/Question.css" />

<link rel="stylesheet" href="css/trumbowyg.css">

<script type="text/javascript" src="js/jquery-2.1.1.js"></script>
<script type="text/javascript" src="js/Community.js"></script>
<script type="text/javascript" src="js/header.js"></script>
<script src="js/trumbowyg.js"></script>


<script type="text/javascript">
	var uno="${loginUser.uNo}";
</script>
<script type="text/javascript" src="js/Question.js"></script>
</head>

<body>
<%@include file="header.jsp" %>

<div id="main">

<div class="wenda clearfix">
	<div class="js-layout-change">
		<div class="wenda-main">
        	<div class="qu-class">
            	<a href="javascript:void(0)">全部回答</a>
                <span>></span>
                <a href="javascript:void(0)">课程回答</a>
            </div>
            
            <div class="qu-person">
            	<a id="qu-person">
                    <img src="../../upload/${questionInfo.user.uPic}" />
                    <span>${questionInfo.user.uName }</span>
                </a>
            </div>
            
            <div class="qu-body">
            	<div class="qu-body-title">
            		<h4>${questionInfo.ask.aTitle}</h4>
                </div>
                <div class="qu-body-body">
                	<p>${questionInfo.ask.aContent}</p>
                </div>
                <c:if test="${not empty questionInfo.ask.aPic}">
	                <div class="qu-body-img">
	                	<img onclick="openMask(1,'../../upload/${questionInfo.ask.aPic}')" src="../../upload/${questionInfo.ask.aPic}" >
	                </div>
                </c:if>
                <div class="qu-body-label">
                	<span class="qu-time">${questionInfo.ask.aTime}</span>
                    <a class="qu-label" href="javascript:void(0)">${questionInfo.cTname}</a>
                    <span class="an"><span class="hd-num">${questionInfo.answerNum}</span>回答</span>
                </div>
            </div>
            
           	<!-- 遮罩 -->
			<div onclick="closeMask()" id="mask" class="mask">
			</div>
			<div id="bigimg">
				<img width="600px" height="338px" src="">
			</div>
			<div id="bigimgYulan">
				<img onclick="openfile()" width="600px" height="338px" src="">
			</div>
            
            <!-- 回答列表 -->
            <div id="answerlist">
            	<ul id="answerul">
            		<c:forEach items="${questionAnswers }" var="item">
            			<li>
            				<div>
            					<img class='userImg' src="../../upload/${item.user.uPic}" />${item.anContent}
            					<br/><br/>
            					<c:if test="${not empty item.anPic }">
            					<img onclick="openMask(1,'../../upload/${item.anPic }')" src="../../upload/${item.anPic }">
            					</c:if>
            				</div>
            				<div id="answerTime">
            					<span>${item.anTime}</span>
            				</div>
            			</li>
            		</c:forEach>
            	</ul>
            </div>
            
            <div class="answer">
            	<form action="ask_addAnswer?aNo=${questionInfo.ask.aNo }&uNo=${loginUser.uNo}" method="post" enctype="multipart/form-data">
					<textarea name="anContent" id="myeditor"></textarea>
					<script>
						$('#myeditor').trumbowyg();
						$(function(){
							$("#yulan").hide();
						})
					</script>
					<div style="float: right;">
						<span id="uploadImg" onclick="openfile()">上传图片</span>
						<input onchange="showYulan()" type="file" hidden="hidden" id="answerImg" name="answerImg" />
		                <span id="yulan" hidden="hidden" onclick="openMask(2,null)">查看预览</span>
		                <input type="submit" id="submitButton" value="回答"/>
	                </div>
                </form>
            </div>
        </div>


  		<div class="r wenda-slider">
			<div class="newques-container">
  				<a href="NewQuestion.jsp" class="newques-btn" id="js-newques" target="_blank">发新问题</a>
			</div>
			<%@include file="userInfo.jsp" %>
      		<div class="panel recomment">
      			<div class="panel-heading">
        			<span class="panel-title">相关课程</span>
      			</div>
      			<div class="panel-body">
      				<c:if test="${empty questionCourse}">
	        			<p id="zanwu">暂无课程信息</p>
	        		</c:if>
        			<ol class="recom-list common-unit">
	        			<c:if test="${not empty questionCourse}">
	        				<c:forEach items="${questionCourse }" var="item">
		                    	<li>
		                  			<div class="recom-ihd clearfix">
		                    			<a href="../courseServlet?op=showCoursesByCno&cno=${item.cno }" class="tag-img l" target="_blank">
		                      				<img src=${item.cpic } title=${item.cname } width="32px" hight="32px">
		                    			</a>
		                    			<div class="tag-detail l">
		                      				<a href="../courseServlet?op=showCoursesByCno&cno=${item.cno }" target="_blank">${item.cname }</a>
		                      				<i>关注：${item.attNum }</i>
		                    			</div>
		                            </div>
		                  			<div class="recom-ibd">
		                    			<p title="${item.cintro }">${item.cintro }</p>
		                  			</div>
		                		</li>
	                		</c:forEach>
	                	</c:if>
                    </ol>
      			</div>
    		</div>
    		
            <div class="question-like">
                <div class="panel-heading">
        			<span class="panel-title">相关问题</span>
      			</div>
                <div class="like-div2">
                	<ul id="likeAsk">
                    </ul>
                </div>
            </div>
            
    	</div>
  	</div>
</div>

<div id="bgImg">
</div>
<div id="show">
	<img id="yulian" onclick="hidediv()" src="" />
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

