//根据课程名模糊查询
function findCourseByCnameOne(){
	var cname=$.trim($("#search-input-out").val());
	console.info(cname);
	if(cname==null||cname==""){
		location.reload(true);
	}else{
		$.post("../courseServlet?d="+new Date(),{op:"findCourseInfoByCname",cname:cname},function(data){
			if(data==1){
				$("#showCname").val=cname;
				location.href="ShowCourse.jsp";
			}else{
				location.href="ShowCourse.jsp";
			}
		});
	}
}	

//点击顶部的搜索框时改变为白底
function change2White(_this){ 
	var text=_this; //输入搜索内容的文本框
	var btn=$('#search_btn_out'); //搜索按钮
	var div=$('#search_out'); //搜索所在的div
	
	div.attr('id','search_over');
	btn.attr('id','search_btn_over');
	text.id='search-input-over';
}
//离开顶部的搜索框时改变为灰底
function change2Gray(_this){ 
	var text=_this; //输入搜索内容的文本框
	var btn=$('#search_btn_over'); //搜索按钮
	var div=$('#search_over'); //搜索所在的div
	
	div.attr('id','search_out');
	btn.attr('id','search_btn_out');
	text.id='search-input-out';
}

//鼠标移到顶部头像时显示self_card div
$(function(){
	$('#login').mouseenter(function(){
		$('#self_card').show();	
	});
	
	$('#self_card').mouseleave(function(){
		$('#self_card').hide();	
	});
});

//登出
function exit(){
	$.post("../userServlet",{op:"loginOut"},function(data){
		data=parseInt(data);
		if(data==1){
			//location.href="zhuye.jsp";
			location.reload(true);
		}
	});
}
