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

var flag;
var chTelRe=false; //检查电话号码的标志
var chPwdRe=false;//检查密码格式的标志
var chNamRe=false;//检查名字的标志
//显示登陆注册界面
function showDiv(ad){
	$("#div").show();
	$("#bg").show();
	if(ad==1){
		showLogin();
	}else{
		showReg();
	}
}
//显示登陆的块
function showLogin(){
	$("#loginform").show();
	$("#regform").hide();
	$("#div").css("height","360px");
	$("#bg").css("height","360px");
	$("#lo").attr("class","btn active1");
	$("#re").attr("class","btn");
}
//显示注册的块
function showReg(){
	$("#loginform").hide();
	$("#regform").show();
	$("#div").css("height","450px");
	$("#bg").css("height","450px");
	$("#lo").attr("class","btn");
	$("#re").attr("class","btn active1");
}
//关闭登陆注册界面
function closes(){
	$("#div").hide();
	$("#bg").hide();
}
//登陆的函数
function UserLogin(){
	var uname=$("#luname").val();
	var upwd=$("#lupwd").val();
	$.post("user_loginUser",{uName:uname,uPwd:upwd},function(data){
		if(data==1){
			location.href="zhuye.jsp";
		}else{
			$("#tishi").show();
		}
	});
}
//点击登陆界面输入框
function ludian(){
	$("#tishi").hide();
}
//检查电话号码的函数
function ch_tel(){
	var chtel=$("#zctel").val();
	var reg=/^1[3-8]\d{9}$/; //验证电话号码的正则表达式
	if(reg.test(chtel)){
		$.post("user_chTel",{uTel:chtel},function(data){
			if(data==1){
				chTelRe=true;
				$("#ditishi").hide();
			}else{
				chTelRe=false;
				$("#ditishi").html("电话已存在");
				$("#ditishi").show();
			}
		});
	}else{
		chTelRe=false;
		$("#ditishi").html("电话格式不正确");
		$("#ditishi").show();
	}
}
//检查密码格式的函数
function ch_pwd(){
	var upwd=$("#zcpwd").val();
	var reg=/^\S{6,16}$/;//验证密码的正则表达式
	if(!reg.test(upwd)){
		chPwdRe=false;
		$("#pwtishi").html("密码格式不正确");
		$("#pwtishi").show();
	}else{
		chPwdRe=true;
		$("#pwtishi").hide();
	}
}
//检查name的函数
function ch_name(){
	var chnam=$("#zcname").val();
	var reg=/^\S{2,18}$/; //验证电话号码的正则表达式
	if(reg.test(chnam)){
		$.post("user_chName",{uName:chnam},function(data){
			if(data==1){
				chNamRe=true;
				$("#natishi").hide();
			}else{
				chNamRe=false;
				$("#natishi").html("名字已存在");
				$("#natishi").show();
			}
		});
	}else{
		chNamRe=false;
		$("#natishi").html("名字格式不正确");
		$("#natishi").show();
	}
}
//注册
function user_addUsreInfo(){
	ch_tel();
	ch_name();
	ch_pwd();
	if(chTelRe&&chNamRe&&chPwdRe){
		var chtel=$("#zctel").val();
		var upwd=$("#zcpwd").val();
		var chnam=$("#zcname").val();
		$.post("user_addUsreInfo",{uName:chnam,uPwd:upwd,uTel:chtel},function(data){
			if(data==1){ 
				location.href="zhuye.jsp";
			}else{
				alert('失败提示','注册失败....','error');
			}
		});
	}
}
