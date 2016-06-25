<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<center>
	<div id="bg" hidden="hidden">
	</div>
	<div id="div"  hidden="hidden">
		<div id="div_header">
			<span class="btn active1" id="lo" onclick="showLogin()">登录</span>
			<span class="btn" id="re" onclick="showReg()">注册</span>
			<div id="imgs" onclick="closes()">
				<img src="images/x.png" />
			</div>
		</div>
		<div id="cont">
			<form id="loginform" action="" method="post" >
				<input type="text" style="width:300px;height:40px;color:#C8CDD2;" onBlur="if (value ==''){value='请输入登陆邮箱'}" id="uname"  onFocus="if (value =='请输入登陆邮箱'){value =''}" value="请输入登陆邮箱" name="uname"><br/><br/>
				<input type="password" style="width:300px;height:40px;color:#C8CDD2;" onBlur="if (value ==''){value='请输入密码'}" id="pwd" onFocus="if (value =='请输入密码'){value =''}" value="请输入密码" name="pwd"><br/><br/>
				<input type="checkbox" name="autologin" style="margin-left:15px;">两周内自动登录<br/><br/>
				<p id="tishi" hidden="hidden" style="color:red;">用户名或密码错误</p>
				<input type="submit"  style="background-color:red;width:300px;height:50px;font-size:20px;color:white;border:none;" value="登录"/>
			</form>
			<script type="text/javascript">
				var strUrl=window.location.href;
				var arrUrl=strUrl.split("/");
				var strPage=arrUrl[arrUrl.length-1];
				var obj=$("#loginform");
				$(function(){
					obj.attr("action","../userServlet?op=userLogin&addr="+strPage);
				})
			</script>
			<form hidden="hidden" id="regform" action="../userServlet?op=addUsreInfo" method="post"return false;target="_blank";>
				<input style="width:300px;height:40px;color:#C8CDD2;" onBlur="if (value ==''){value='请输入电子邮箱地址'}" id=""  onFocus="if (value =='请输入电子邮箱地址'){value =''}" value="请输入电子邮箱地址" name="youxiang"><br/><br/>
				<input style="width:300px;height:40px;color:#C8CDD2;" onBlur="if (value ==''){value='6-16位密码，区分大小写，不能用空格'}" id="m" onFocus="if (value =='6-16位密码，区分大小写，不能用空格'){value =''}" value="6-16位密码，区分大小写，不能用空格" name="q"><br/><br/>
				<input style="width:300px;height:40px;color:#C8CDD2;" onBlur="if (value ==''){value='昵称为2-18位，中英文，数字及下划线'}" id="n" onFocus="if (value =='昵称为2-18位，中英文，数字及下划线'){value =''}" value="昵称为2-18位，中英文，数字及下划线" name="n"><br/><br/>
				<input style="width:150px;height:40px;color:#C8CDD2;" onBlur="if (value ==''){value='请输入验证码'}" id="y" onFocus="if (value =='请输入验证码'){value =''}" value="请输入验证码" name="y"><br/><br/>
				<input value="注册" type="submit" name="sou" style="background-color:red;width:300px;height:50px;font-size:20px;color:white;border:none;">
			</form>
		</div>
	</div>
</center>