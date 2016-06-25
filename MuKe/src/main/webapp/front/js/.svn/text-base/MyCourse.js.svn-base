var maxPage; //TODO 记录最大页数

$(function(){
	attention();
});

function attention(){ //点击关注
	active(0);
	loadHTMLAttention(1,0,1,'全部');

	//全部下拉框那里的赋值(已关注)
	$.post("../courseServlet",{op:"getUserCourseDir",uno:uno,attention:1},function(data){
		var obj=$("#js-columbd"); //下拉框
		var opt='<li><a data-id="0" href="javascript:loadHTMLAttention(1,0,1,\'全部\')">全部</a></li>';
		obj.html('');
		obj.append($(opt));
		$.each(data.types,function(index,item){
			opt='<li><a data-id='+item.ctypeno+' href="javascript:loadHTMLAttention(1,'+item.ctypeno+',1,\''+item.ctypename+'\')">'+item.ctypename+'</a></li>';
			obj.append($(opt));
		});
	},"json");
}
function loadHTMLAttention(nowPage,ctypeNo,attention,ctypename){ //nowPage要查询的页面 ctypeNo所要获取的课程的种类
	var list=$("#myAttentionCourseList");
	var total=$("#mytotal");
	var opt;
	var update=$(".span-new");
	$("#js-columall").children("span").html(ctypename);
	$.post("../userCourseServlet",{op:"getUserCourse",uno:uno,nowPage:nowPage,ctypeNo:ctypeNo,attention:attention},function(data){
		if(data.mytotal!=0 && data.ucourses!=null){
			total.html(data.mytotal);
			list.html('');
			open_ul();
			$('#js-columbd').css('display','none');
			$.each(data.ucourses,function(index,item){
				update.html('');
				opt='<div class="follow-list">';
				opt+='<div class="box-left">';
				opt+='<a href="javascript:gotoCourse('+item.cno+','+item.uno+','+item.nowChapterNum+')" title='+item.cname+' target="_blank">'; //去往课程学习界面
				opt+='<div class="course-list-img">';
				opt+='<img src='+item.cpic+' width="220" height="123" alt='+item.cname+'>';
				opt+='</div></a></div>';
				opt+='<div class="box-right"><h4 class="box-hd">';
				opt+='<span>'+item.cname+'</span>';
				opt+='<span data-id='+item.cno+' class="span-new">'+item.updatetimes+'更新至第'+item.maxChapter+'章</span></h4>';
				opt+='<div class="study-points">';
				opt+='<span class="span-left span-common">已学习至：第'+item.nowChapterNum+'章</span></div>';
				opt+='<div class="study-btm">'
				opt+='<a href="javascript:gotoCourse('+item.cno+','+item.uno+','+item.nowChapterNum+')" class="beginstudy" target="_blank">开始学习</a></div></div></div>';
				list.append($(opt));
			});
		} else{
			$("#ifempty").show();
		}
	},"json");
}


function study(){ //点击学习
	active(1);
	loadHTMLStudy(1,1,0,'全部');
	
	//全部下拉框那里的赋值(已学习)
	$.post("../courseServlet",{op:"getUserCourseDir",uno:uno,learnstatus:1},function(data){
		var obj=$("#js-columbd"); //下拉框
		var opt='<li><a data-id="0" href="javascript:loadHTMLStudy(1,1,0,\'全部\')">全部</a></li>';
		obj.html('');
		obj.append($(opt));
		$.each(data.types,function(index,item){
			opt='<li><a data-id='+item.ctypeno+' href="javascript:loadHTMLStudy(1,1,'+item.ctypeno+',\''+item.ctypename+'\')">'+item.ctypename+'</a></li>';
			obj.append($(opt));
		});
	},"json");
}
function loadHTMLStudy(nowPage,learnstatus,ctypeNo,ctypename){
	var list=$("#myAttentionCourseList");
	var total=$("#mytotal");
	$("#js-columall").children("span").html(ctypename);
	$('#js-columbd').css('display','none');
	$.post("../userCourseServlet",{op:"getUserCourse",uno:uno,nowPage:nowPage,learnstatus:learnstatus,ctypeNo:ctypeNo},function(data){
		if(data.mytotal!=0 && data.ucourses!=null){
			total.html(data.mytotal);
			list.html('');
			var opt='<ul class="studyClass">';;
			$.each(data.ucourses,function(index,item){
				opt+='<li onmouseover="showSpan(this)" onmouseout="hideSpan()" class="studyClassLi" data-id="461"><a href="javascript:gotoCourse('+item.cno+','+item.uno+','+item.nowChapterNum+')">'; //去用户当前学的章节
				opt+='<div class="course-list-img"><img width="240" height="135" src='+item.cpic+'></div>';
				opt+='<h5 id="title-name"><span>'+item.cname+'</span></h5>';
				opt+='<div class="tips"><p class="text-ellipsis">'+item.yuliu+'这里写简介</p><span class="dateandnum ">'+item.updatetimes+'更新</span></div>';
				opt+='<span class="time-label">已更新至:第'+item.maxChapter+'章</span></a></li>';
			});
			opt+='</ul>';
			list.append($(opt));
		} else{
			$("#ifempty").show();
		}
	},"json");
}


function studyOver(){
	active(2);
	loadHTMLStudy(1,0,0,'全部');
	
	//全部下拉框那里的赋值(已学习)
	$.post("../courseServlet",{op:"getUserCourseDir",uno:uno,learnstatus:0},function(data){
		var obj=$("#js-columbd"); //下拉框
		var opt='<li><a data-id="0" href="javascript:loadHTMLStudy(1,0,0,\'全部\')">全部</a></li>';
		obj.html('');
		obj.append($(opt));
		$.each(data.types,function(index,item){
			opt='<li><a data-id='+item.ctypeno+' href="javascript:loadHTMLStudy(1,0,'+item.ctypeno+',\''+item.ctypename+'\')">'+item.ctypename+'</a></li>';
			obj.append($(opt));
		});
	},"json");
}


function active(i){ //改变关注 学习 已学完的样式
	var obj=$(".sort-item");
	for(var n=0;n<3;n++){
		if(n==i){
			$(obj[n]).attr("class","active sort-item");
		}else{
			$(obj[n]).attr("class","sort-item");
		}
	}
}

//过渡time-label span 
function showSpan(th){
	var span=$(th).children("a").children("span");
	span.css('-moz-animation','move 0.3s ease-in 1 normal');
	span.css('-webkit-animation','move 0.3s ease-in 1 normal');
	span.css('display','block'); 
}
function hideSpan(){
	var span=$(".studyClassLi").children("a").children("span");
	span.css('-moz-animation','move 0.3s ease-in 1 normal');
	span.css('-webkit-animation','move 0.3s ease-in 1 normal');
	span.css('display','none');
}


//设置签名
function setDesc(){ //打开编辑
	var p=$('#signed');
	var area=$('#js-sign-editor');
	var info=$('#signed span');

	area.val(info.text());
	p.hide();
	area.show();
}
function setDesc2(){ //编辑框的失焦事件，即完成编辑
	var p=$('#signed');
	var area=$('#js-sign-editor');
	var info=$('#signed span');
	$.post("../userServlet",{op:"updateUser",usign:area.val(),uno:uno},function(data){
		if(parseInt(data)==1){
			info.text(area.val());
			alert("信息修改成功");
		}else{
			alert("信息修改失败");
		}
	});
	p.show();
	area.hide();
}

//打开筛选
function open_ul(){
	var ico=$('#tool-item-ico');
	var ul=$('#js-columbd');
	if(ul.css('display')=='none'){
		ul.css('display','block');
		ico.attr('src','images/arrow2.jpg');
	}else{
		ul.css('display','none');
		ico.attr('src','images/arrow1.jpg');
	}
}

//上一页和下一页的hover
$(function(){
	//经验
	var a=$('.mp-atag');
	var jy1=$('.mp-clearfix .mp-item .mp-num');
	var jy2=$('.mp-clearfix .mp-item .mp-title');
	a.mouseover(function(){
        jy1.css('color','red');
		jy2.css('color','red');
    });	
	a.mouseout(function(){
        jy1.css('color','black');
		jy2.css('color','black');
    });
	
	//nav
});

function changeUpOver(_this){
	_this.src='images/up_over.jpg';
}
function changeUpOut(_this){
	_this.src='images/up_out.jpg';
}

function changeNextOver(_this){
	_this.src='images/next_over.jpg';
}
function changeNextOut(_this){
	_this.src='images/next_out.jpg';
}

/*删除*/
$(function(){
	$('#delimg').mouseover(function(){
		$(this).attr('src','images/del_over.jpg');
	});	
	$('#delimg').mouseout(function(){
		$(this).attr('src','images/del_out.jpg');
	});
	$('#delimg').click(function(){
		$(this).hide();
		$('#delspan').show();
		
		$('.del').show();
	});
	
	$('#delspan').mouseover(function(){
		$(this).css('background','#000');
	});
	$('#delspan').mouseout(function(){
		$(this).css('background','#999');
	});
	$('#delspan').click(function(){
		$(this).hide();
		$('#delimg').show();
		
		$('.del').hide();
	});
});

/*我的课程，我的计划...的hover*/
$(function(){
	var str=pageName().toString();
	switch(str.split('-')[0]){
		case 'MyCourse':
			planOp();
			noteOp();
			codeOp();
			break;
		case 'MyNote':
			planOp();
			courseOp();
			codeOp();
			break;
		case 'MyPlan':
			noteOp();
			courseOp();
			codeOp();
			break;
		case 'MyCode':
			planOp();
			courseOp();
			noteOp();
			break;
		default: break;
	}
});
function courseOp(){
	$('.js-count-course').mouseover(function(){
		$(this).children('i').css('background','url(images/myCourse-red.jpg) no-repeat left center');
		$(this).css('color','red');
	});
	$('.js-count-course').mouseout(function(){
		$(this).children('i').css('background','url(images/myCourse-gray.jpg) no-repeat left center');
		$(this).css('color','black');
	});	
}
function planOp(){
	$('.js-count-plan').mouseover(function(){
		$(this).children('i').css('background','url(images/myPlan-red.jpg) no-repeat left center');
		$(this).css('color','red');
	});
	$('.js-count-plan').mouseout(function(){
		$(this).children('i').css('background','url(images/myPlan-gray.jpg) no-repeat left center');
		$(this).css('color','black');
	});
}
function noteOp(){
	$('.js-count-note').mouseover(function(){
		$(this).children('i').css('background','url(images/myNote-red.jpg) no-repeat left center');
		$(this).css('color','red');
	});
	$('.js-count-note').mouseout(function(){
		$(this).children('i').css('background','url(images/myNote-gray.jpg) no-repeat left center');
		$(this).css('color','black');
	});
}
function codeOp(){
	$('.js-count-code').mouseover(function(){
		$(this).children('i').css('background','url(images/myCode-red.jpg) no-repeat left center');
		$(this).css('color','red');
	});
	$('.js-count-code').mouseout(function(){
		$(this).children('i').css('background','url(images/myCode-gray.jpg) no-repeat left center');
		$(this).css('color','black');
	});	
}

/*获取页面名字*/
function pageName(){
	var a = location.href;
	var b = a.split("/");
	var c = b.slice(b.length-1, b.length).toString(String).split(".");
	return c.slice(0,1);
}

function gotoQuestion(askno){
	$.post("../questionServlet",{op:"gotoQuestionHTML",askno:askno},function(data){
		data=parseInt(data);
		if(data==1){
			location.href="Question.jsp";
		}
	});
}

function gotoCourse(cno,uno,nowChapterNum){
	$.post("../courseServlet",{op:"gotoChapter",cno:cno,uno:uno,nowChapterNum:nowChapterNum},function(data){
		data=parseInt(data);
		if(data==1){
			location.href="shipin.jsp";
		}
	});
}