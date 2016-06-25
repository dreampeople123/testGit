<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!-- 中转用的jsp -->
<script type="text/javascript" src="js/jquery-2.1.1.js"></script>
<script>
var uno="${loginUser.uno}";
var nowPage="${param.nowPage}";
var op="${param.op}";
$(function(){
	if(nowPage==null || nowPage==""){
		nowPage=1;
	}
	
	if(op=="ask"){
		loadHTMLAsk();
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
	} else{
		loadHTMLComment(nowPage);
	} 
});

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


function loadHTMLComment(now){ //nowPage要查询的页面
	$.post("../commentsServlet",{op:"getCommentByUno",uno:uno,nowPage:now},function(data){
		if(data==1){
			location.href="MyComment.jsp";
		}
	});
}

function loadHTMLAsk(){
	$.post("../communityServlet",{op:"getMyAsk",uno:uno},function(data){
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