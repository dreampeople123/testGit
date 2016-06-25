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
<title>继续学习</title>
<link rel="shortcut icon" href="../images/1.png" type="image/x-icon"/>
<link rel="stylesheet" href="css/keeplearning.css" type="text/css"/>
<link rel="stylesheet" href="css/footer.css" type="text/css" />
<link rel="stylesheet" href="css/header.css" type="text/css" />
<script type="text/javascript" src="js/jquery-1.11.3.min.js"></script>
<script type="text/javascript" src="js/keeplearning.js"></script>
<script type="text/javascript" src="js/header.js"></script>
</head>

	
<body>
<%@ include file="header.jsp" %>

<div id="main">
	<div class="course-infos">
		<c:forEach items="${currentCourse1 }" var="i" begin="0" end="0">
    		
    	<div class="w">
    		
        	<div class="path">
            <p>
            	<a href="course.jsp">课程</a>
                <i class="path-split">\</i>
                <a href="#">${ i.cdirname}</a>
                <i class="path-split">\</i>
                <a href="#">${i.ctypename}</a>
                <i class="path-split">\</i>
                <a href="#">${i.cname}</a>
            </p>
            </div><!--path结束-->
            	<h2 class="l">${i.cname}</h2>
            <div class="static">
            	<div class="static-item">
                	<span class="meta-value"><strong>${i.easydegreename }</strong></span>
                    <span class="meta">难度</span>
                    <em></em>
                </div><!--static-item结束-->
                <div class="static-item static-time">
                    <span class="meta-value"><strong>${i.updatetime }</strong></span>
                    <span class="meta">更新时间</span>
                    <em></em>
     		    </div><!--static-item static-time结束-->
     		    <!-- 
                 <div class="static-item">
                    <span class="meta-value"><strong>317</strong></span>
                    <span class="meta">学习人数</span>
        			<em></em>
      			</div><!--static-item结束-->
      			 -->
      			 
      			 <div class="static-item">
      			 	<img >
      			 </div>
      			
            </div><!--static结束-->
        </div><!--w结束-->
	 	</c:forEach>
    	
    </div><!--course-infos结束-->
    
    <div class="course-info-main">
    	<div class="info-bar">
        <p>
        	<a href="#" target="_blank" class="btn-red">开始学习</a>
        </p>
        </div><!--info-bar结束-->
		<div class="content-warp">
        	<div class="content">
        	<div class="mod-tab-menu">
            	<ul class="course-menu clearfix">
                    <li ><a class="active" id="learnOn"  href="javascript:change('learnOn',1)"><span>章节</span></a></li>
                    <li ><a id="commentOn" class="" href="javascript:change('commentOn',2)"><span>评论</span></a></li>
                   <!--   <li ><a id="qaOn" class="" href="javascript:change('qaOn',3)"><span>问答</span></a></li>-->
                        <!-- <li ><a id="noteOn" class="" href="javascript:change('noteOn',4)"><span>笔记</span></a></li>-->
                </ul>
            </div><!--mod-tab-menu结束-->
            <div class="mod-chapters">
            <!--  测试
            <a target="_blank" onclick="jumpToShiPin('1000','1000')" class="studyvideo" id="color">跳转<i class="study-state"></i></a>
            -->
             
            	<div class="chapter-active" id="1" style="display:block">
            		<c:forEach items="${currentCourse1}" var="CourContent">
            		
            		<script>
            			console.info("${CourContent.chapterno}");
            		</script>
            			<h3 id="chapS"  onClick="show(this)" class="active">
	                    	<span class="icon-sub"></span>
	                        <strong onMouseOut="close()"><i class="state-expand"></i>${CourContent.chaptername }</strong>
                    	</h3>
	                    <ul style="display:block" id="chapterCon">
	                    	<li id="con"  style="display:block">
	                            <em class="laststudy"></em>
	                            <a target="_blank" href="javascript:jumpToShiPin('${CourContent.cno}','${CourContent.chapterno }')" class="studyvideo" id="color">>_${CourContent.chaptername }<i class="study-state"></i></a>
	                        </li>
	                    </ul><br>
            		</c:forEach>
                	
                </div><!--chapter-active结束-->
                <div class="chapter-active" id="2" style="display:none">
                	 <div class="comment" id="comment" style="display:none">
                           <textarea id="comment_tucao" class="comment_tucao" placeholder="扯淡、吐槽、表扬、鼓励……想说啥就说啥！"></textarea>-->
                           <span class="count_limit"><span id="count_limit">0</span>/300</span>
 			   		 </div><!--comment结束-->
                     <div id="pub-btm" class="pub-btm" style="display:none">
                     	<div class="verify-box" style="display:none">
                        	<input type="text" class="ipt 1" placeholder="请输入验证码">
                            <a href="jaascript:;" class="js-verify-refresh"><img data-src="" class="verify-media 1"/></a>
                            <span class="verify-help 1">
                            	看不清
                                <a href="javascript:;" class="verify-refresh js-verify-refresh">换一换</a>
                            </span>
                        </div><!--verify-box结束-->
                        <input type="button" id="js-p1-submit" class="pub-btn r" data-cid="541" onclick="savePin()" value="发表言论">
                        <span class="errorip r" style="display:none">您还没填写内容</span>
                     </div><!--pub-btm结束-->
                     <div id="course_note">
                     	<ul class="mod-post" id="comment-list">
                     	
                     	<c:forEach items="${courcomments}" var="item">
                        	<li class="post-row">
                            	<div class="media">
                                	<a href="#" target="_blank">
                                    	<img src="../../${item.pic}" width="40" height="40">
                                    </a>
                                </div><!--media结束-->
                                <div class="bd">
                                	<div class="tit">
                                    	<a href="#" target="_blank">${item.uname}</a>
                                    </div><!--tit结束-->
                                    <p class="cnt">${item.commentcontent}</p>
	                                    <c:if test="${not empty item.yuliu1}">
	                                    	<img width="136" height="78" src="../../${item.yuliu1}" data-src="">
	                                    </c:if>
                                    <div class="footer">
                                    	<sapn title="创建时间" class="1 timeage">${item.commenttime}</span>
                                        <a href="javascript:void(0)" class="form">源自：<p style="display:inline-block;">${item.chaptername}</p></a>
                                        <div class="actions r">
                                        	<a title="赞" href="javascript:;" class="js-pl-parse list-raise post-action" data-id="13156"></a>
                                        </div>
                                    </div>
                                </div>
                            </li>
                            </c:forEach>
                        </ul>
                     </div><!--course_note结束-->
                </div><!--chapter-active结束-->
                <div class="chapter-active" id="3" style="display:none">
                	<div class="quesdetail mbottom" id="issuequestitle">
                    	<span class="ques-label">标题：</span>
                        <div class="question-area form-ctrl">
                        	<input type="text" id="ques-title" style="width:650px; height:40px;" name="title" placeholder="请输入问题标题" class="autocomplete wge-ipt block" value=""/>
                            <p class="errortip" style="display:none">您还没写标题</p>
                            <dl class="send-area-result"></dl>
                        </div><!--question-area结束-->
                    </div><!--quesdetail结束-->
                    <div class="quesdetail" style="overflow:hidden;padding-top:10px;">
                    	<span class="ques-label">内容：</span>
                        <div id="editor-wrap" class="editor form-ctrl clearfix">
                        	<div class="textarea-unlogin">
                            	<textarea name="" cols="30" rows="10" id="pub-editor" class="block block-editor" placeholder="请输入回答内容..." style="display:none"></textarea>
                            </div><!--textarea-unlogin结束-->
                            <div class="text-area">
                            	<input type="text" class="text-area-write" style="width:650px ; height:81px" />
                            </div><!--text-area结束-->
                            
                            
                        </div><!--editor-wrap结束-->
                        <p class="errortip" style="display:none">您还没填写内容！</p>
                    </div><!--quesdetail结束-->
                    <div id="pub-btm" class="pub-btm clearfix">
                    	<div class="verify-box 1 js-verify-box" style="display:none">
                        	<input type="text" class="ipt 1" placeholder="请输入验证码">
                            <a href="javascript:;" class="js-verigy-refresh"><img data-src="" class="verify-media 1"/></a>
                            <span class="verify-help 1">
                            	看不清
                                <a href="javascript:;" class="verigy-refresh js-verify-refresh">换一换</a>
                            </span>
                        </div><!--verify-box结束-->
                        <input type="button" id="js-pub-btn" class="pub-btn r" data-cid="541" value="发布">
                    </div><!--pub-btm结束-->
                    
                    <div class="comp-filter-bar">
                       <a href="/qa/541/t/1" class="bar-item  active" >全部</a>
                       <a href="/qa/541/t/2" class="bar-item " >精华</a>
                    </div><!--comp-filter-bar结束-->
                    <div class="answertabcon">
                        <p class="unquestion" style="display:none">
                         <span></span>
                         此课程暂无同学的回答
                       </p>
                    </div><!--answertabcon结束-->
                </div><!--charpter-active3结束-->
                <div class="chapter-active" id="4" style="display:none">
                	<div class="course-tool-bar">
                    	<div class="tool-left l">
                        	<a href="#" class="sort-item active">最新</a>
                            <a href="#" class="sort-item active">点赞</a>
                            <a href="#" class="sort-item active">采集</a>
                        </div><!--tool-left结束-->
                        <div class="tool-right r"> 
                        	<span class="tool-item">
                            	<a href="#" class="hide-learned tool-chk">只看我的</a>
                            </span>
                        </div><!--tool-right结束-->
                    </div><!--course-tool-bar结束-->
                    <ul id="js-note-container" class="mod-post">
                    	<li id="597367" class="post-row js-find-txt" courseid="541" noteid="597367">
                        	<div class="media">
                            	<a href="#" target="_blank">
                                	<img src="images/xkengogogo.jpg" width="40" height="40">
                                </a>
                            </div><!--media结束-->
                            <div class="bd">
                            	<div class="tit">
                                	<a id="tit_name" href="#" target="_blank">xkengogogo</a>
                                </div><!--tit结束-->
                                <div class="js-notelist-content notelist-content mynote">
                                	<p class="autowrap">挺好</p>
                                    <div class="notelist-content-more">
                                    	<a href="javascript:;" class="js-toggle-content" style="display:none">[查看全文]</a>
                                    </div><!--notelist-content-more结束-->
                                </div><!--mynote结束-->
                                <div class="clearfix">
                                	<a href="javascript:void(0);" class="sava_btn" style="display:none">保存</a>
                                </div><!--clearfix结束-->
                                <div class="footer clearfix">
                                	<span title="1天前" class="1 timego">时间：1天前</span>
                                    <a href="#" class="from l">源自：1-1 学习指南</a>
                                    <div class="actions r">
                                    	<textarea style="display:none;">挺好</textarea>
                                        <a title="采集" href="javascript:;" class="Jcollect post-action" data-mid="10399|2577945"></a>
                                        <a title="赞" href="javascirpt:;" class="Jcollect post-action" data-mid="10399"></a>
                                    </div><!--actions r结束-->
                                </div><!--footer clearfix结束-->
                            </div><!--bd结束-->
                        </li>
                    </ul>
                </div><!--character-active4结束-->
            </div><!--mod-chapters结束-->
        </div><!--content结束-->
        </div><!--content-wrap结束-->
        
        <div class="aside">
        	<div class="bd">
            	<div class="boxmb">
                	<h4>讲师提示</h4>
                    <div class="teacher-info">
             
                    	<a href="#" target="_blank" id="t1">
                        	<img src="images/teacher.jpg" width="80" height="80">
                        </a>
               
                        <span class="tit">
                        	<a href="#" target="_blank">Frank666<i class="icon-imooc"></i></a>
                        </span>
                        <span class="job">移动开发工程师</span>
                        
                    </div><!--teacher-info结束-->
                    	<div class="course-info-tip">
                    	<c:forEach items="${currentCourse1 }" var="j" begin="0" end="0">
                    	
                        	<dl class="first">
                            <dt>课程简介</dt>
                            
                            	<dd class="autowrap">${j.cintro }</dd>
                           
                            </dl>
                        </div><!--course-info-tip结束-->
                         </c:forEach>
                </div><!--boxmb结束-->
                
            </div><!--bd结束-->
        </div><!--aside结束-->
    </div><!--course-info-main结束-->
</div><!--main结束-->
<div id="learner">
	<div class="cp-header clearfix">
    	<h2 class="cp-tit 1">学过该课的人还学过</h2>
    	<ul class="cp-tabs 1">
        	<li class="1">
            	<a class="on js-comp-tab-item" data-pannel="course" href="course.jsp;">课程</a>
            </li>
        </ul>
    </div><!--cp-header结束-->
    <div class="cp-body">
    	<div class="cp-tab-pannel js-comp-tab-pannel" style="display:block" data-pannel="course">
        	<ul class="other-list">
        		<c:forEach items="${sameUcourse}" var="item">
	            	<li class="img1">
	                	<a target="_blank" href="#">
	                    	<img alt="${item.cname}" src="../../${item.cpic}" >
	                        <span class="name autowrap">HTML+CSS基础课程</span>
	                    </a>
	                </li>
                </c:forEach>
               <!--   <li class="img2">
                	<a target="_blank" href="#">
                    	<img alt="HTML+CSS基础课程" src="images/learned1.jpg" >
                        <span class="name autowrap">HTML+CSS基础课程</span>
                    </a>
                </li>
                <li class="img3">
                	<a target="_blank" href="#">
                    	<img alt="HTML+CSS基础课程" src="images/learned1.jpg" >
                        <span class="name autowrap">HTML+CSS基础课程</span>
                    </a>
                </li>
                 <li class="img4">
                	<a target="_blank" href="#">
                    	<img alt="HTML+CSS基础课程" src="images/learned1.jpg" >
                        <span class="name autowrap">HTML+CSS基础课程</span>
                    </a>
                </li>
                <li class="img5">
                	<a target="_blank" href="#">
                    	<img alt="HTML+CSS基础课程" src="images/learned1.jpg" >
                        <span class="name autowrap">HTML+CSS基础课程</span>
                    </a>
                </li>-->
            </ul>
        </div><!--cp-tab-pannel结束-->
    </div><!--cp-body结束-->
</div><!--learner结束-->
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
