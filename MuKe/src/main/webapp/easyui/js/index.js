$(function(){
	$('#index_content').tabs('add',{
		title: '慕课信息',
		selected:true,
		closeable:false,
		href:"muke.html"
	});
	
	$("#menu-tree").tree({
		onClick:function(node){
			var obj=$('#index_content');
			if(node.id=="admin_manager"){
				//判断管理员信息管理界面是否打开
				if(obj.tabs("exists","管理员信息管理")){
					obj.tabs("select","管理员信息管理");
				}else{
					obj.tabs('add',{
						title:"管理员信息管理",
						closable:true,
						fit:true,
						href:'admin.html'
					});
				}
			}else if(node.id=="update_adminPwd"){
				//判断新闻类型管理界面是否打开
				if(obj.tabs("exists","修改管理员密码")){
					obj.tabs("select","修改管理员密码");
				}else{
					obj.tabs('add',{
						title:"修改管理员密码",
						closable:true,
						fit:true,
						href:'password.jsp'
					});
				}
			}else if(node.id=="update_position"){
				if(obj.tabs("exists","修改会员职位")){
					obj.tabs("select","修改会员职位");
				}else{
					obj.tabs('add',{
						title:"修改会员职位",
						closable:true,
						fit:true,
						href:'positions.html'
					});
				}
			}else if(node.id=="users_manager"){
				if(obj.tabs("exists","会员信息管理")){
					obj.tabs("select","会员信息管理");
				}else{
					obj.tabs('add',{
						title:"会员信息管理",
						closable:true,
						fit:true,
						href:'user.html'
					});
				}
			}else if(node.id=="userCourse_info"){
				//判断会员信息管理界面是否打开
				if(obj.tabs("exists","用户课程信息管理")){
					obj.tabs("select","用户课程信息管理");
				}else{
					obj.tabs('add',{
						title:"用户课程信息管理",
						closable:true,
						fit:true,
						href:'ucourse.html'
					});
				}
			}else if(node.id=="chapter_info"){
				//判断修改管理员密码界面是否打开
				if(obj.tabs("exists","章节信息管理")){
					obj.tabs("select","章节信息管理");
				}else{
					obj.tabs('add',{
						title:"章节信息管理",
						closable:true,
						fit:true,
						href:'chapter.html'
					});
				}
			}else if(node.id=="course_easydegree"){
				//判断修改管理员密码界面是否打开
				if(obj.tabs("exists","课程难易信息管理")){
					obj.tabs("select","课程难易信息管理");
				}else{
					obj.tabs('add',{
						title:"课程难易信息管理",
						closable:true,
						fit:true,
						href:'course_easy.html'
					});
				}
			}else if(node.id=="course_ctype"){
				//判断修改管理员密码界面是否打开
				if(obj.tabs("exists","课程类别信息管理")){
					obj.tabs("select","课程类别信息管理");
				}else{
					obj.tabs('add',{
						title:"课程类别信息管理",
						closable:true,
						fit:true,
						href:'course_type.html'
					});
				}
			}else if(node.id=="course_info"){
				//判断修改管理员密码界面是否打开
				if(obj.tabs("exists","课程信息管理")){
					obj.tabs("select","课程信息管理");
				}else{
					obj.tabs('add',{
						title:"课程信息管理",
						closable:true,
						fit:true,
						href:'Course.html'
					});
				}
			}else if(node.id=="course_comments"){
				//判断修改管理员密码界面是否打开
				if(obj.tabs("exists","评论管理")){
					obj.tabs("select","评论管理");
				}else{
					obj.tabs('add',{
						title:"评论管理",
						closable:true,
						fit:true,
						href:'Comments.html'
					});
				}
			}else if(node.id=="ask_manager"){
				//判断修改管理员密码界面是否打开
				if(obj.tabs("exists","问答管理")){
					obj.tabs("select","问答管理");
				}else{
					obj.tabs('add',{
						title:"问答管理",
						closable:true,
						fit:true,
						href:'ask.html'
					});
				}
			}
		}
	});
	
	showTime();
	setInterval("showTime()",1000);
	
});

function showTime(){
	var obj=$("#currentTime");
	obj.text("当前时间："+dateFormat(new Date()));
}

function dateFormat(time){
	var data;
	var month=time.getMonth()+1;
	var min;
	var second;
	var hours;
	
	if(time.getHours()<10){
		hours="0"+time.getHours();
	}else{
		hours=""+time.getHours();
	}
	
	if(time.getMinutes()<10){
		min="0"+time.getMinutes();
	}else{
		min=""+time.getMinutes();
	}
	
	if(time.getSeconds()<10){
		second="0"+time.getSeconds();
	}else{
		second=""+time.getSeconds();
	}
	data=time.getFullYear()+"/"+month+"/"+time.getDate()+" "+hours+":"+min+":"+second;
	return data;
}

function outLogin(){
	$.post("../adminServlet?d="+new Date(),{op:"outLogin"},function(data){
		if(parseInt($.trim(data))==1){
			$.messager.show({title:'成功提示',msg:'退出成功....',timeout:2000,showType:'slide'});
			location.replace("../backlogin/backlogin.html");
		}else{
			$.messager.alert('失败提示','退出失败....','error');
		}
	});
}