// JavaScript Document
function change2White(_this){
	var text=_this; //输入搜索内容的文本框
	var btn=$('#search_btn_out'); //搜索按钮
	var div=$('#search_out'); //搜索所在的div
	
	div.attr('id','search_over');
	btn.attr('id','search_btn_over');
	text.id='search-input-over';
}

function change2Gray(_this){
	var text=_this; //输入搜索内容的文本框
	var btn=$('#search_btn_over'); //搜索按钮
	var div=$('#search_over'); //搜索所在的div
	
	div.attr('id','search_out');
	btn.attr('id','search_btn_out');
	text.id='search-input-out';
}

function changeSearchFocus(){
	var inptu=$('.search-tags-ipt');
	inptu.css('border-color','#999');
	inptu.css('color','black');
}

function changeSearchBlur(){
	$('.search-tags-ipt').css('border-color','#CCC');
}

function AttentionCourse(uno,cno){
	$.post("../userCourseServlet",{op:"attentionCourse",uno:uno,cno:cno},function(data){
		data=parseInt(data);
		if(data==1){
			location.href="Middle.jsp?op=community";
		}
	});
}

function gotoQuestion(askno){
	$.post("../questionServlet",{op:"gotoQuestionHTML",askno:askno},function(data){
		data=parseInt(data);
		if(data==1){
			location.href="Question.jsp";
		}
	});
}