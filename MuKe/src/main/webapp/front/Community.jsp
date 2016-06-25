<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>慕课网-社区</title>
<link rel="shortcut icon" href="../images/1.png" type="image/x-icon"/>
<link rel="stylesheet" href="css/Community.css" />
<link rel="stylesheet" href="css/header.css" type="text/css" />
<link rel="stylesheet" href="css/footer.css" type="text/css" />
<link rel="stylesheet" href="css/login.css" type="text/css" />

<script type="text/javascript" src="js/jquery-2.1.1.js"></script>
<script type="text/javascript" src="js/header.js"></script>
<script type="text/javascript" src="js/login.js"></script>

<script type="text/javascript">
	var uNo="${loginUser.uNo}";
</script>
<script type="text/javascript" src="js/Community.js"></script>
</head>
	
<body>
<%@include file="header.jsp" %>

<div id="main">
<!-- 进入页面后获取需要的信息 -->
<s:action name="ask_findCommunityInfo" namespace="/" >
	<s:param name="page">1</s:param>
</s:action>

<div class="wenda clearfix">
	<div class="js-layout-change">
  		<div class="l wenda-sidebar">
            <div class="wenda-main">
                <div class="wenda-nav" data-hadtag="0">
                    <a href="javascript:void(0)" class="quealltab onactive">社区问答</a>
                </div>
                
                <!-- 问题的列表 -->
                <div class="wenda-list">
					<c:forEach items="${communityAsks }" var="item">              	
	                    <div class="wenda-listcon clearfix">
	                        <div class="headslider">
	                            <img src="../../upload/${item.user.uPic }" alt="暂无图片" width="40" height="40">
	                            <span class="wenda-nickname">${item.user.uName }</span>
	                        </div>
	                        <div class="wendaslider">
	                            <a href="javascript:void(0)" class="replynumber hasanswernum" target="_blank">
	                                <div class="ys">
	                                    <div class="number">
	                                        <span>${item.answerNum }</span>
	                                    </div>
	                                    <div>回答</div> 
	                                </div>
	                            </a>
	                            <h4 class="wendaquetitle">
	                                <i class="icon-ad"><img src="images/mu_2.jpg" style="float:left; padding-right:10px;"></i>
	                                <div class="wendatitlecon">
	                                    <a href="ask_gotoQuestion.action?askNos=${item.ask.aNo }" class="wendatitle">${item.ask.aTitle }</a>
	                                </div>
	                            </h4>
	                            <div class="replycont clearfix">
	                                <i class="icon-msg-revert" style="position:absolute; margin-top:5px;"><img src="images/answer.jpg"></i>
	                                <div class="l replydes">
	                                    <span class="replysign praise">[最新回答]</span>
	                                    <c:if test="${not empty item.answer.anContent }">
	                                    	<span class="replydet">${item.answer.anContent }</span>
	                                    </c:if>
	                                    <c:if test="${empty item.answer.anContent }">
	                                    	<span class="replydet">暂无回答</span>
	                                    </c:if>
	                                </div>
	                            </div>
	                            <div class="replymegfooter clearfix">
	                                <div class="wenda-time l">提问时间：${item.ask.aTime }</div>
	                                <div class="keyword-list l">
	                                  <a class="list-tag">${item.cTname }</a>
	                                </div>
	                            </div>
	                        </div>
	                    </div>
                    </c:forEach>  
                </div>
                
                <!-- 页面的跳转 -->                 
                <div class="page">
                    <span class="disabled_page">首页</span>
                    <span class="disabled_page">上一页</span>
                    <a href="" class="page_next" style="width:50px;">下一页</a>
                    <a href="" class="page_next" style="width:40px;">尾页</a>
                </div>
            </div>
      	</div>
    
  		<div class="r wenda-slider">
			<div class="newques-container">
  				<a href="NewQuestion.jsp" class="newques-btn" id="js-newques" target="_blank">发新问题</a>
			</div>
			<!-- 用户信息 -->
			<%@include file="userInfo.jsp" %>
			
      		<div class="panel recomment">
      			<div class="panel-heading">
        			<span class="panel-title">为你推荐</span>
      			</div>
      			<!-- 关注度最高的课程 -->
      			<div class="panel-body">
        			<ol class="recom-list common-unit">
        				<c:forEach items="${communityHotCourse }" var="item">
	                    	<li>
	                  			<div class="recom-ihd clearfix">
	                    			<a href="../courseServlet?op=showCoursesByCno&cno=${item.course.cNo }" class="tag-img l" target="_blank">
	                      				<img src="../../upload/${item.course.cPic }" title="${item.course.cName }" alt="图片暂无" width="32px" height="32px">
	                    			</a>
	                    			<div class="tag-detail l">
	                      				<a href="../courseServlet?op=showCoursesByCno&cno=${item.course.cNo }" target="_blank">${item.course.cName }</a>
	                      				<i>关注：${item.attNum }</i>
	                    			</div>
	                            	<a class="tag-will-fol at-tag" href="courses_showCoursesByCno.action?cNo=${item.course.cNo }">学习</a>
	                            </div>
	                  			<div class="recom-ibd">
	                    			<p>${item.course.cProfiles }</p>
	                  			</div>
	                		</li>
                		</c:forEach>
                    </ol>
      			</div>
    		</div>
    		
      		<div class="panel hot"><!-- hot questiones -->
      			<div class="panel-heading">
        			<span class="panel-title">热门问答</span>
      			</div>
      			<!-- 根据回答的人数降序排列 -->
      			<div class="panel-body clearfix">
                    <ul class="weekly-hot">
                    	<c:forEach items="${communityHotAsk }" var="item" begin="0" varStatus="status">
	                        <li class="padtop">
	                            <em class="hoticon hot${status.index}">热</em>
	                            <a href="ask_gotoQuestion.action?askNos=${item.ask.aNo }" target="_blank" class="hottalk">${item.ask.aTitle }</a>
	                            <div class="hot-bd">
	                                <a href="javascript:void(0)" target="_blank" class="list-tag">${item.cTname }</a>
	                                <div class="answer-follow r">
	                                    <span class="hot-answer">${item.answerNum} 回答</span>
	                                </div>
	                            </div>
	                        </li>
                        </c:forEach>
                    </ul>
            	</div>
    		</div>
<!--ques relations -->
<!-- relevant tag -->
<!-- reply rank -->
    		<div class="panel weekly-rank">
    			<div class="panel-heading">
      				<span class="panel-title">回答雷锋榜 </span>
    			</div>
    			<!-- 根据回答问题数排列的用户 -->
    			<div class="wenda-mkclasscon clearfix">
        			<ul>
        				<c:forEach items="${communityHotUser }" var="item">
	                   		<li class="padtop">
	            				<a href="javascript:void(0)" class="l roll-head" target="_blank" title="${item.user.uName }">
	            					<img src="../../upload/${item.user.uPic }">
	            				</a>
	            				<a href="javascript:void(0)" target="_blank" title="${item.user.uName }" class="rankingnickname">${item.user.uName }</a>
	            				<em class="archieve">${item.user.uUsign }</em>
	            				<i class="adopt rankingnum">${item.answerNum }<br>回答</i>
	         				</li>
         				</c:forEach>
                 	</ul>
    			</div>
  			</div>
<!-- course relations -->
    	</div>
  	</div>
</div>

<!--这里是隐藏的div-->
<div class="custom-layout js-custom-layout" hidden="hidden"><!--注意这里-->
    <div class="custom-content">
      <p>选择我喜欢的问答类型，专注我最懂的类别。请点击下方选择感兴趣的标签。（支持多选）</p>
            <div class="custom-tags clearfix js-keyword-list">
                  <!-- <a href="javascript:void(0)" data-id="0" class="hot-label js-all-keyword">全部问答</a> -->                                                                                                                                                                                                      <a href="javascript:void(0)" data-id="40" class="hot-label js-keyword">ZBrush</a>
                        </div>
      <div class="btnbox">
        <a href="javascript:void(0)" class="btn btn-green js-custom-save">保存</a>
        <a href="javascript:void(0)" class="btn btn-white js-custom-cancel">取消</a>
      </div>
      <script>
        //页面载入时，选中的定制标签
        var initHotLabel='29,25,17,15,14,5,3';
      </script>
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
