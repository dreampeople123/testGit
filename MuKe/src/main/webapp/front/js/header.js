//根据课程名模糊查询
function findCourseByCnameOne(){
	var cName=$.trim($("#search-input-out").val());
	var urls="courses_findCourseByCname.action";
	console.info(cName);
	if(cName==null||cName==""){
		location.reload(true);
	}else{
		$.post(urls,{cName:cName},function(data){
			if(data==1){
				$("#showCname").val=cName;
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
	$.post("user_loginOut",function(data){
		data=parseInt(data);
		if(data==1){
			location.href="zhuye.jsp";
		}
	});
}
