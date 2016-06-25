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
<meta charset="utf-8">
<title>查看课程</title>
<link rel="shortcut icon" href="../images/1.png" type="image/x-icon"/>
<link href="css/shipin.css" type="text/css" rel="stylesheet"/>
<link rel="stylesheet" href="css/footer.css" type="text/css" />
<script type="text/javascript" src="js/jquery-1.11.3.min.js"></script>
<script type="text/javascript" src="js/shipin.js"></script>

<script type="text/javascript" src="editor/ueditor.config.js"></script>
<script type="text/javascript" src="editor/ueditor.all.js"></script>
<script type="text/javascript" src="editor/lang/zh-cn/zh-cn.js"></script>
</head>

<body>
	<!-- 灰色背景 -->
	<div id="bg" class="bg" style="display:none;"></div>
	<div id="header" class="course-detail-header">
    	<div class="cd-inner ">
        	<ul class="l">
            	<li class="nv nv-goback">
                	<a class="revert l" href="javascript:history.go(-1)">
						<p class="head_turn_left ad"></p>
					</a>
                </li>
                <li class="nv nv-menu">
                	<a class="chaptername J-chaptername" style="cursor:text;" href="javascript:void(0);">
                		<span>${dancourse.cname}</span>
						<p>${danchapter.chaptername}</p>
					</a>
                </li>
            </ul>
          
        </div>
	</div>
	<div id="studyMain"> 
		<div id="bgarea" class="video-con">
    		<div style="width:100%; height: 526px;" class="js-box-wrap" id="js-box-wrap">
	    		<!-- <c:forEach items="${chapters}" var="itemsd"> 
	               		<c:if test="${itemsd.chapterno eq '1000'}"></c:if>
		        </c:forEach> -->

	            <video id="media" src="../../${danchapter.chaptercontent}" controls="ture" loop="loop"  preload="preload" height="100%" width="100%" autoplay="autoplay">视频走丢了。。</video>
	            <canvas style="display:none"></canvas>	
    		</div>
	    <!--此处结构为侧栏-->
			<div class="section-list" id="section-list" style="margin-right:-360px;">
	    		<div class="operator">
	        		<div class="op chapter " id="light" onClick="zhang()"><em class="icon-menu"></em>章节</div>
	        		 <div class="op notes"  onClick="zhangno()"><em class="icon-note"></em>评论</div>
	        		 <div class="op question" onClick="zhangqa()"><em class="icon-addques"></em>提问</div>
	    		</div>
	    		<div class="nano has-scrollbar">
	        		<div style="right: -17px;" tabindex="0" class="nano-content">
	            		<h3>${dancourse.cname}</h3>
	                   	<ul>
	                   		<c:forEach items="${chapters}" var="item">
		                   		<li data-id="10220">
		                        	<a href="javascript:tiaozhuan(${item.chapterno})"><em class="icon-video"></em>${item.chaptername}</a>
		                    		<c:if test="${item.chapterno eq danchapter.chapterno}">
	            						<i class="">正在学</i>
	            					</c:if>
	                    		</li>
            				</c:forEach>
	            		</ul>
	        		</div>
	    		<div style="display: none;" class="nano-pane"><div style="height: 512px; transform: translate(0px, 0px);" class="nano-slider"></div></div></div>
			</div>
			
		</div>

	<div class="maybe-wenda" id="maybe-wenda" style="display: none;">
	    <i class="icon-chat"></i>
	    <p class="text">你发的评论可能会是问题？<br>是否将他发到问答中</p>
	    <input class="btn ok" value="好的" id="wenda-ok" type="button">
	    <input class="btn no" value="不用" id="wenda-no" type="button">
	</div>
</div>

<div class="course-subcontainer clearfix">
  <div class="course-left clearfix">
      <ul  class="course-menu course-video-menu clearfix js-course-menu" data-ower="all" data-sort="last">
	  <!-- <li class="course-menu-item"><a class="active" href="javascript:qie('plMenu')" id="plMenu">评论</a></li>-->
	    <li class="course-menu-item"><a href="javascript:qie('qaMenu')" class="active" id="qaMenu">问答</a></li>
	    <li class="course-menu-item"><a href="javascript:qie('noteMenu')" id="noteMenu">评论</a></li>
  
       </ul>
	<div id="disArea" class="lists-container list-wrap">
	    <div id="qa-content" class="list-tab-con" style="display:block">
	        <div id="qaLoadListData">
	        	<div class="sortlist">
	        		<div class="ordertab">
	        			<a href="javascript:quanbu()" id="quanbu" class="quealltab onactive">全部</a>				
	        			<a href="javascript:jinhua()" id="jinhua" class="quealltab">精华</a>			
	        		</div>		
	        	</div>
	        	<div id="qiehuanjin" class="answertabcon clearfix">
	        		<%@ include file="VideoAsk.jsp" %>
	        	</div>
	       
	        
	    	</div>
	    </div>
	    <div id="note-content" class="list-tab-con" style="display:none">
	        <div id="noteLoadListData">
		        <div class="course-tool-bar clearfix js-select-state">			
		        	<div class="tool-left js-all-state">		        
			        	<a href="javascript:zuixin();" id="zuixin" class="sort-item active" data-sort="last">最新</a>		        
			        	<a href="javascript:ddian();" id="danzan" class="sort-item" data-sort="sugg">点赞</a>		        
			        	<!--  <a href="javascript:;" class="sort-item" data-sort="coll">采集</a>-->	        
		        	</div>	        
		        	<div class="tool-right r">		        
			        	<span class="tool-item">		        	
			        		<!--  <a href="javascript:;" class="js-ower hide-learned tool-chk" data-sort="last">只看我的</a>-->		        
			        	</span>		    
		        	</div>		
		        </div>
	        	<div id="course_note" class="course_note">
	        		<ul id="pinlun">
	        			<%@ include file="VideoCom.jsp" %> 
					</ul>
	        	</div>
	        	<div class="page note-list-page">
	        	</div>
	        </div>
	    </div>
	</div>
	</div>
<div class="course-right clearfix">
	<div class="classmate fl">
		<h3>你的同学<span>${counu}人</span></h3>
		<div class="users_wrap">
			<div id="js-class-mate" class="users clearfix">
				<c:forEach items="${tongxue}" var="item">
					<a class="mate-avator" href="javascript:tongxu(${item.uno})" target="_blank">
						<img src="${item.pic}" title="${item.uname}">
					</a>
				</c:forEach>
			</div>
		</div>
	</div>
</div>
</div>

<div class="course-about">
    <div class="course-about-tit clearfix">
        <h3>学过该课的人还学过</h3>
                <span class="on">课程</span>
                    </div>
        <ul style="display: block;" class="con-wrap clearfix">
        	 <c:forEach items="${sameUcourse}" var="item">
		          	<li>
			            <a href="javascript:void(0)" class="img-box" target="_blank">
			                <img src="${item.cpic}" alt="${item.cname}">
			                <p>${item.cname}</p>
			            </a>
	        		</li>
          	</c:forEach>
              
            </ul>
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
<!--弹出框-->
<div class="publish clearfix note-pop" id="note-publist" style="display:none">
    <div class="publish-wrap publish-wrap-note video-publish-note pop-con">
        <div class="pop-title">
            <h3>评论</h3>
            <a onClick="noclose('note-publist')"><img src="images/2015-11-24_200720.gif"/></a>
        </div>
        <div id="js-note-input-fake" class="textarea-wrap">
            <textarea  id="js-note-textarea" class="js-placeholder" name="content" onKeyUp="checkWord(this);" onMouseDown="javascript:checkWord(this);" onblur="javascript:note_shiqu()" placeholder="请输入评论内容..."></textarea>
            <p class="note-text-counter"><span id="js-note-limit">0</span>/1000</p>
        </div>
        <div class="publish-note-btns input-btm clearfix pop-footer">
            <div class="verify-code clearfix"></div>
                                            <div title="截图" class="js-shot-video screen-btn" id="screen-btnbi" data-type="note">
                    <span onClick="jie()">截图</span>
                </div>
             <input title="发表" value="保存" id="js-note-submit" class="course-btn r" type="button" onclick="savePin()">                          
           <!--   <label for="js-isshare" class="label-checked r"><input checked="checked" id="js-isshare" class="checked" type="checkbox"> 公开</label>-->
        </div>
    </div>
</div>
<!--查看截图时的块  -->
<div class="publish clearfix note-pop" id="showpics" style="display:none">
    <div class="publish-wrap publish-wrap-note video-publish-note pop-con">
        <img width=100% height=100% alt="" id="showphoto" src="images/2015-12-09_194819.gif">     
    </div>
        <div class="pop-title guanbi">images/x.png
            <a onClick="noclose('showpics')"><img src="images/x.png" width="40px" height="40px"/></a>
        </div>   
</div>

<!--问答弹出框 通用-->
<div style="display:none" class="publish clearfix qa-pop" id="discus-publish">
    <div style="" id="publish-wraps" class="publish-wrap publish-wrap-disucss video-publish-qa pop-con">
        <div class="pop-title">
            <h3>提问</h3>
            <a onClick="noclose('discus-publish')"><img src="images/2015-11-24_200720.gif"/></a>
        </div>
        <div class="qa-control-wrap clearfix">
            <div class="question-area">
                <div class="qa-control qa-ipt-title">
                    <input id="js-qa-title" maxlength="255" class=" js-placeholder autocomplete" placeholder="请输入问题标题" type="text">
                </div>
                <a class="another-meth" target="_blank" href="">
					如何更好
					<br>
					的提问？
				</a>
                <dl class="send-area-result">
                </dl>
            </div>
        </div>
        <div style="" class="qa-control-wraps clearfix">
            <div style="" class="qa-control">
                <div style="" class="rich-text-editor">
                    <div style="" class="edui-imooc" id="discuss-editor">
                    	<div class="edui-editor">
                        
			<script type="text/javascript">
			var ue = UE.getEditor("verify-code-ipt",{
				autoHeightEnabled: false,
				toolbars:[['insertcode', //代码语言
						'bold', //加粗
				           'italic', //斜体
				           'underline', //下划线
				          'undo', //撤销
				           'redo', //重做
				           'simpleupload', //单图上传
				           'blockquote',
				           'insertorderedlist', //有序列表
				           'insertunorderedlist', //无序列表
				           ]]
			});
			</script>
			<textarea id="verify-code-ipt"  placeholder="请输入讨论内容..." style="height:116px;" name="content">
			</textarea>
                        </div>
                   	</div>
                    
                </div>
            </div>
        </div>
        <div id="js-discuss-btm" class="discuss-bottom input-btm clearfix pop-footer">
		    <div class="verify-code clearfix">
		            	<input maxlength="4" class="verify-code-ipt" placeholder="请输入验证码" type="text">
		                <img class="img-code" src="images/2015-12-09_194819.gif">
		                <span class="verify-code-around">
		                	看不清<br><p>换一换</p>
		                </span>
		                <span class="errtip"></span>
		         	</div>
		           <!--  <div title="截图" class="js-shot-video screen-btn"  id="screen-btnbi1" data-type="qa">
		            	<span onClick="jie1()">截图</span>
		            </div> -->
		            <input id="js-discuss-submit" class="r course-btn" onclick="submitQuestion()" value="发布" type="button">
		 </div>
        <div id="use-credit-tip" class="use-credit-tip">
            <span class="credit-info">本次提问将花费2个积分</span>
            <a class="credit-rule" href="http://www.imooc.com/myclub/rule" target="_blank">为什么扣积分？</a>
        </div>
    </div>
</div>