<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
<meta charset="utf-8">
<title>慕课网-发问题</title>
<link rel="shortcut icon" href="../images/1.png" type="image/x-icon"/>
<link rel="stylesheet" href="css/header.css" type="text/css" />
<link rel="stylesheet" href="css/footer.css" type="text/css" />
<link rel="stylesheet" href="css/NewQuestion.css" type="text/css" />

<link rel="stylesheet" href="css/trumbowyg.css">

<script type="text/javascript" src="js/jquery-2.1.1.js"></script>
<script type="text/javascript" src="js/header.js"></script>
<script type="text/ecmascript" src="js/NewQuestion.js"></script>

<script src="js/trumbowyg.js"></script>

<script type="text/javascript">
	var uno="${loginUser.uNo}";
</script>
</head>

<body>
<!-- 获取所有的类型 -->
<s:action name="cType_findAllCourseType" namespace="/" ></s:action>

<%@include file="header.jsp" %>
<div id="main">
	<div class="container">
    	<div class="container-left">
            <div class="new-title">
                <h4>发问题</h4>
            </div>
            <div class="question-body">
            	<form action="ask_addAsk" method="post" enctype="multipart/form-data" onsubmit="return checkForm()">
	                <ul class="bodyul">
	                    <li class="bodyli">分类：<span class="question-class">技术问答</span></li>
	                    <li class="bodyli"> <!--js-->
	                    	标题：<input type="text" name="aTitle" class="question-text" id="question-title" placeholder="请输入问题的标题"/>
	                    	<span hidden="hidden" class="question-title-hint" id="question-title-hint">
	                    		<img src="images/prompt.jpg" />标题不能少于5个字符
	                    	</span>
	                    </li>
	                    <li class="bodyli" id="special">
	                        <span class="neirong">内容：</span>
	                        <div class="question-mainbody">
								<textarea name="aContent" id="myeditor"></textarea>
								<script>
									$('#myeditor').trumbowyg();
									
									$(function(){
										$(".trumbowyg-editor").blur(function(){
											var content=$("#myeditor").val();
											if(content.length<5){
												$('#bodytext-hint').show();	
											}
										});
										
										$(".trumbowyg-editor").focus(function(){
											$('#bodytext-hint').hide();	
										});
									})
								</script>
	                        </div>
	                        
	                        <p hidden="hidden" class="question-title-hint" id="bodytext-hint">
	                        	<img src="images/prompt.jpg" />正文不能少于5个字符
	                        </p>
	                    </li>
	                    <li class="bodyli">
	                    	方向：<input type="text" disabled="disabled" id="question-text" class="question-text" placeholder="您须从下列标签选择一个呦!">
	                        <input hidden="hidden" name="typeNo" id="typeNo" type="text"/>
	                        <input hidden="hidden" name="uNo" type="text" value="${loginUser.uNo }" />
	                        <div class="question-lable">
							</div>
	                    </li>
	                    <li class="bodyli">
	                    	<span id="openFile" hidden="hidden" class="issue" onclick="openFile()">上传图片</span>
	                    	<span id="Yulan" hidden="hidden" onclick="openMask()">查看预览</span>
	                    	<input hidden="hidden" type="file" id="askImg" name="askImg" onchange="showYulan()" />
	                    	<input type="submit" class="issue" value="发布" />
	                    </li>
	                </ul>
                </form>
                
                <!-- 遮罩 -->
				<div onclick="closeMask()" id="mask" class="mask">
				</div>
				<div id="bigimgYulan">
					<img onclick="openFile()" width="600px" height="338px" src="">
				</div>
            </div>
        </div>
        <div class="container-right">
        	<h4 class="newquestions"><img src="images/light.jpg" /><span>您想发问题，还是发问题还是发问题？<span></h4>
            <dl>
                <dt>上面没有写错，是您看错啦。</dt>
                <dd>1、您是来解决问题？请先搜索是否已经有同类问题吧。这样您就省心少打字。</dd>
                <dd>2、没找到是么？就在发问题时精确描述你的问题，不要写与问题无关的内容哟；</dd>
                <dd>3、慕课讨论更热衷于解达您想要的答案。能引起思考和讨论的知识性问题；</dd>
                <dt>问答禁止这些提问</dt>
                <dd>1、禁止发布求职、交易、推广、广告类与问答无关信息将一律清理。</dd>
                <dd>2、尽可能详细描述您的问题，如标题与内容不符，或与问答无关的信息将被关闭。</dd>
                <dd>3、问答刷屏用户一律冻结帐号</dd>
          	</dl>
            <div class="hotlabel">
            	<h4>热门标签</h4>
                <div class="labels-div">
                	<c:forEach items="${alltypes }" var="item">
                		<a href="javascript:void(0)" title="${item.ctName }" class="labels">${item.ctName }</a>
                	</c:forEach>
                </div>
            </div>
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