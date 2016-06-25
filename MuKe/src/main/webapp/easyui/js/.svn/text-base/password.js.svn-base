$(function(){
	var newPwd=$("#newPwd");
	var newPwd2=$("#newPwd2");
	var btn=$("#pwdBtn");
	
	newPwd.blur(function(){ //新密码框的失焦事件
		var pwd=newPwd.val();
		if((pwd.length<6 || pwd.length>20) && pwd.length>0){
			$("#newp1").text("密码长度不符合规则!!!").css("color","red");
			newPwd.val("");
		} else if(pwd=="" || pwd==null){
			$("#newp1").text("")
		} else{
			$("#newp1").text("密码符合!!!").css("color","green");
		}
	});
	
	newPwd2.blur(function(){ //新密码确认框的失焦事件
		var pwd=newPwd.val();
		var pwd2=newPwd2.val();
		if(pwd2!=pwd){
			$("#newp2").text("密码不相同，请重新输入!!!").css("color","red");
			newPwd2.val("");
			btn.attr("disabled",true);
		} else if(pwd2=="" || pwd2==null){
			$("#newp2").text("");
		} else{
			$("#newp2").text("密码符合!!!").css("color","green");
			btn.attr("disabled",false);
		} 
	});
});

function updateAdminPwd(){
	alert('密码修改');
}
