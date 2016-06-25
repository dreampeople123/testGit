<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
  <head>
    <base href="<%=basePath%>">
    <meta charset="utf-8">
    <title>My JSP 'updateLoginUser.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script src="js/jquery-1.11.3.min.js" charset="utf-8"></script>
	
	
  </head>
  
  

  <body>
   <div id="update_loginUser_pwd" style="float:left;width:100px;height:200px;padding-top:30px;padding-left:30px;">
		<form action="" style="padding-top:50px float:left;display:inline-block;">
			<label>管理员编号：</label><input type="text" id="admin_aid" name="admin_aid" class="myinput" readonly="readonly" value="${adminLoginInfo.aid }"/><br/><br/>
			<label>管理员姓名:</label><input type="text" name="admin_aname" id="admin_aname" class="myinput" readonly="readonly" value="${adminLoginInfo.aname}"/><br/><br/>
			<label>管理员密码:</label><input type="password" id="admin_pwd" name="pwd" value="${adminLoginInfo.pwd}"/><br/><br/>
		</form>
		
		<button id="updateAP" onClick="updateAdminPwd()" value="保存修改">保存修改</button>
	</div>
  </body>
  
  

</html>
