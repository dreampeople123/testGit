<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<center>
	<div id="bg" hidden="hidden">
	</div>
	<div id="div" hidden="hidden">
		<div id="div_header">
			<span class="btn active1" id="lo" onclick="showLogin()">登录</span>
			<span class="btn" id="re" onclick="showReg()">注册</span>
			<div id="imgs" onclick="closes()">
				<img src="images/x.png" />
			</div>
		</div>
		<div id="cont">
			<form id="loginform"  method="post" >
				<input type="text" style="width:300px;height:40px;color:#C8CDD2;"    placeholder="请输入用户名" id="luname"  onclick="ludian()"  name="uName"><br/><br/>
				<input type="password" style="width:300px;height:40px;color:#C8CDD2;"   placeholder="请输入密码" id="lupwd" onclick="ludian()" name="uPwd"><br/><br/>
				<input type="checkbox" name="autologin" style="margin-left:15px;">两周内自动登录<br/><br/>
				<p id="tishi" hidden="hidden"  style="color:red;">用户名或密码错误</p>
				<input type="button" onclick="UserLogin()"  style="background-color:red;width:300px;height:50px;font-size:20px;color:white;border:none;" value="登录"/>
			</form>
			<script type="text/javascript">
				var strUrl=window.location.href;
				var arrUrl=strUrl.split("/");
				var strPage=arrUrl[arrUrl.length-1];
				var obj=$("#loginform");
				var as=0;
				$(function(){
					/* obj.attr("action","../userServlet?op=userLogin&addr="+strPage); */
				})
				/* 点击发送验证码之后按钮处特效 */
				function faso(){
					if(as<10){
					$("#fas").val((10-as)+"秒后重新发送");
					as++;
					setTimeout("faso()", 1000);
					}else{
						$("#fas").val("发送验证码");
						as=0;
					}
				}
				/* 点击改变验证码 */
				function changeCode(obj){
					obj.src="valiCodeImg.jsp?d="+new Date();
				}
				/* 失去焦点验证验证码 */
				function checkCode(){
					var ycode=$("#yzz").val();
					$.post("user_checkCode",{ycode:ycode},function(data){
						if(parseInt($.trim(data))){ //验证码正确
							$("#yztishi").html("验证码正确...").css("color", "#0F0");
							$("#yztishi").hide();
							$("#zhuc").attr("disabled",false);
						}else{
							$("#yztishi").html("验证码错误...").css("color", "#F00");
							$("#yztishi").show();
							$("#zhuc").attr("disabled",true);
						}
					});
				}
			</script>
			<form hidden="hidden" id="regform"  method="post"return false;target="_blank";>
				<input style="width:300px;height:40px;color:#000000;"  type="text" placeholder="请输入正确的电话号码" name="uTel" id="zctel" onblur="ch_tel()"><br/>
			 	<label id="ditishi" hidden="hidden" style="color:red;margin-left: 0px; font-size: 12px;">电话号码已存在</label><br/>
				<input style="width:300px;height:40px;color:#000000;"  type="password" placeholder="密码：6-16位密码区分大小写不能用空格" id="zcpwd" onblur="ch_pwd()" name="uPwd"><br/>
				<label id="pwtishi" hidden="hidden" style="color: red;margin-left: 0px; font-size: 12px;">密码不规范</label><br/>
				<input style="width:300px;height:40px;color:#000000;"    type="text" placeholder="昵称：为2-18位中英文数字及下划线"  id="zcname" onblur="ch_name()" name="uName"><br/>
				<label id="natishi" hidden="hidden" style="color:red;margin-left: 0px; font-size: 12px;">昵称已存在</label><br/>
				<!-- <div style=" display: inline-block; width: 100px;height: 40px;margin-right: 10px;margin-top: 18px;"> -->
<img src="valiCodeImg.jsp" onclick="changeCode(this)"  style="width: 100px;height: 40px;margin-right: 10px;margin-bottom: -14px;"/>
<!-- </div> -->
				<!-- <input id="fas" value="发送验证码" onclick="javascript:faso()" type="button" name="fasong" style="background-color:red;width:100px;height:40px;font-size:14px;color:white;border:none; margin-right: 10px;"> -->
				<input style="width:150px;height:40px;color:#000000;" placeholder="请输入验证码" onblur="checkCode()" id="yzz"   name="yzz"><br/>
				
				<label id="yztishi" hidden="hidden" style="color: red;margin-left: 0px; font-size: 12px;">验证码错误</label><br/>
				<input value="注册"  onclick="user_addUsreInfo()" id="zhuc" type="button" name="sou" style="background-color:red;width:300px;height:50px;font-size:20px;color:white;border:none;">
			</form>
		</div>
	</div>
</center>
