<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!-- 中转用的jsp -->
<script type="text/javascript" src="js/jquery-2.1.1.js"></script>
<script>
var uno="${loginUser.uNo}";
var nowPage="${param.nowPage}";
var op="${param.op}";
var coNo="${param.coNo}";
$(function(){
	if(nowPage==null || nowPage==""){
		nowPage=1;
	}
	
	if(op=="ask"){
		loadHTMLAsk(nowPage);
	} else if(op=="community"){
		loadHTMLCommunity(nowPage);
	} else if(op=="showCourseDetail"){
		loadJSPCourse(nowPage);
	} else if(op=="showCourseDirDetail"){
		loadJSPCdir(nowPage);
	} else if(op=="showCourseTypeDetail"){
		loadJSPCtype(nowPage);
	} else if(op=="showCourseEasydegreeDetail"){
		loadJSPCeasydegree(nowPage);
	} else if(op=="newQuestion"){
		loadHTMLNewQuestion();
	}  else if(op=="currentCourse"){//在主页的课程显示
		currentCourse();
	}  else if(op=="comment"){//在我的课程界面点击我的评论
		loadHTMLComment(nowPage);
	} else if(op="delCom"){
		delCom();//在我的评论界面删除评论
	}
});
/**
 * 在我的评论界面删除评论
 */
function delCom(){
	console.info("要删除的com"+coNo);
	$.post("comment_delComments",{coNos:coNo},function(data){
		if(data==1){
			nowPage=1;
			loadHTMLComment(nowPage);
		}
	});
}
/**
 * 在主页的课程显示
 */
function currentCourse(){
	$.post("../commentsServlet",{op:"getCommentByUno",uno:uno,nowPage:nowPage,ctypno:'0'},function(data){
		data=parseInt(data);
		if(data==1){
			location.href="MyComment.jsp";
		}
	});
}

function loadMyComment(nowPage){
	$.post("../commentsServlet",{op:"getCommentByUno",uno:uno,nowPage:nowPage,ctypno:'0'},function(data){
		data=parseInt(data);
		if(data==1){
			location.href="MyComment.jsp";
		}
	});
}

function loadHTMLNewQuestion(){
	$.post("../questionServlet",{op:"getHTMLInfo"},function(data){
		if(data==1){
			location.href="NewQuestion.jsp";
		}
	});
}

/**
 * 在我的课程界面点击我的评论
 */
function loadHTMLComment(now){ //nowPage要查询的页面
	console.info("dang当前页"+now);
	$.post("comment_getCommentByUno",{page:now},function(data){
		if(data==1){
			location.href="MyComment.jsp";
		}
	});
}

function loadHTMLAsk(now){
	$.post("ask_getMyAsk",{page:now},function(data){
		if(data==1){
			location.href="MyAsk.jsp";
		}
	});
}

function loadHTMLCommunity(now){
	$.post("../communityServlet",{op:"getCommunityAskByTime",nowPage:now},function(data){
		if(data>0){
			location.href="Community.jsp";
		}
	});
}

function loadJSPCourse(now){
	$.post("../courseServlet",{op:"showCourseDetail",nowPage:now},function(data){
		if(data==1){
			location.href="course.jsp";
		}
	});
}

</script>
<body>
	<center>
		<img style="margin-top: 100px;" src="../images/loading.gif" />
	</center>
</body>