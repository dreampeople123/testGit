var isnew1=false;//判定newPwd是否符合规范
var isnew2=false;//判定newPwd2是否和newPwd一致
var oldpwds=$("#pwdhid").html();
$(function(){
	var newPwd=$("#newPwd");
	var newPwd2=$("#newPwd2");
	var btn=$("#pwdBtn");
	
	newPwd.blur(function(){ //新密码框的失焦事件
		var pwd=newPwd.val();
		if((pwd.length<6 || pwd.length>20) && pwd.length>0){
			$("#newp1").text("密码长度不符合规则!!!").css("color","red");
			newPwd.val("");
			 isnew1=false;
		} else if(pwd=="" || pwd==null){
			$("#newp1").text("");
			 isnew1=false;
		} else{
			$("#newp1").text("密码符合!!!").css("color","green");
			 isnew1=true;
		}
	});
	
	newPwd2.blur(function(){ //新密码确认框的失焦事件
		var pwd=newPwd.val();
		var pwd2=newPwd2.val();
		if(pwd2!=pwd){
			$("#newp2").text("密码不相同，请重新输入!!!").css("color","red");
			newPwd2.val("");
			btn.attr("disabled",true);
			isnew2=false;
		} else if(pwd2=="" || pwd2==null){
			$("#newp2").text("");
			isnew2=false;
		} else{
			$("#newp2").text("密码符合!!!").css("color","green");
			btn.attr("disabled",false);
			isnew2=true;
		} 
	});
});

function updateAdminPwd(){
	var yuanPwd=$("#yuanPwd").val();
	if(yuanPwd!=oldpwds){
		$("#oldp").text("原密码错误，请重新输入!!!").css("color","red");
	}else if(isnew1&&isnew2){
		$.messager.confirm('信息确认','您确定要修改密码吗 ？',function(r){
			if(r){
				var nePwd=$("#newPwd").val();
				var adNo=$("#aidhid").html();
				$.post("admin_updatepwd",{aPwd:nePwd,aId:adNo},function(data){
					data=parseInt($.trim(data));
					if(data>0){
						$.messager.show({
							title:'修改提示',
							msg:'管理员密码修改成功....',
							timeout:2000,
							showType:'slide'
						});
						/*location.href="index.jsp";*/
						 location.reload(true); 
					}else{
						$.messager.alert('失败提示','管理员密码修改失败....','error');
					}
				});
			}
		});
	}
}
