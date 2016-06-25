<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
<script type="text/javascript" src="js/jquery-2.1.1.js"></script>
<script type="text/javascript" src="js/header.js"></script>
<script type="text/ecmascript" src="js/NewQuestion.js"></script>

<script type="text/javascript" src="editor/ueditor.config.js"></script>
<script type="text/javascript" src="editor/ueditor.all.js"></script>
<script type="text/javascript" src="editor/lang/zh-cn/zh-cn.js"></script>
<script type="text/javascript" src="js/editor.js" ></script>

<script type="text/javascript">
	var uno="${loginUser.uno}";
	$(function(){
		var label="${label}";
		if(label!=null && label!="" ){
			//console.info("${label}"); 
		} else{
			location.href="Middle.jsp?op=newQuestion";
		}
	});
</script>
</head>

<body>
<%@include file="header.jsp" %>
<div id="main">
	<div class="container">
    	<div class="container-left">
            <div class="new-title">
                <h4>发问题</h4>
            </div>
            <div class="question-body">
                <ul>
                    <li>分类：<span class="question-class">技术问答</span></li>
                    <li> <!--js-->
                    	标题：<input type="text" class="question-text" id="question-title" placeholder="请输入问题的标题"/>
                    	<p hidden class="question-title-hint" id="question-title-hint"><img src="images/prompt.jpg" />标题不能少于5个字符</p>
                    </li>
                    <li id="special">
                        <span class="neirong">内容：</span>
                        <div class="question-mainbody">
                 			<textarea style="line-height: 0px;" id="content" name="content" >
  							</textarea>
                        </div>
                        <p hidden class="question-title-hint" id="bodytext-hint"><img src="images/prompt.jpg" />正文不能少于5个字符</p>
                    </li>
                    <li>
                    	方向：<input type="text" disabled="disabled" id="question-text" class="question-text" placeholder="您须从下列标签选择一个呦!">
                        <div class="question-lable">
                        	<c:forEach items="${label }" var="item">
                        		<span data-id="${item.ctypeno }" onclick="addLabel(this)" class="labels">${item.cdirname }</span>
                        	</c:forEach>
                        </div>
                    </li>

                    <li><a href="javascript:submitQuestion()" class="issue">发布</a></li>
                </ul>
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
                	<c:forEach items="${label }" var="item">
                		<a href="javascript:void(0)" title="${item.cdirname }" class="labels">${item.cdirname }</a>
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