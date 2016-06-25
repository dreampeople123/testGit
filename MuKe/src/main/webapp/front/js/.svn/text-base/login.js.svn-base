

var flag;

function showDiv(){
	$("#div").show();
	$("#bg").show();
}

function showLogin(){
	$("#loginform").show();
	$("#regform").hide();
	$("#div").css("height","360px");
	$("#bg").css("height","360px");
	$("#lo").attr("class","btn active1");
	$("#re").attr("class","btn");
}

function showReg(){
	$("#loginform").hide();
	$("#regform").show();
	$("#div").css("height","450px");
	$("#bg").css("height","450px");
	$("#lo").attr("class","btn");
	$("#re").attr("class","btn active1");
}

function closes(){
	$("#div").hide();
	$("#bg").hide();
}



//注册
function userzc(){
	if(flag){
		var emails = $("#zcaddr").val();
		var pwdss = $("#zcpwd").val();
		var unames = $("#zcuname").val();
		$.post("../UserServlet?d="+new Date(),{op:"addUsreInfo",uname:unames,pwd:pwdss,email:emails},function(data){
			if(data==1){
				var text = $("#div").val();
				$("#div").hide();
				alert("注册成功");
				
			}else{
				alert('失败提示','注册失败....','error');
			}
		});
		
	}
}