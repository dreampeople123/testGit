// JavaScript Document
function AttentionCourse(uno,cno){ //添加关注
	$.post("../userCourseServlet",{op:"attentionCourse",uno:uno,cno:cno},function(data){
		data=parseInt(data);
		if(data==1){
			location.href="Middle.jsp?op=community";
		}
	});
}