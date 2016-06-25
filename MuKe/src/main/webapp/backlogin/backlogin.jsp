<!-- 后台管理员登录 -->
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" contentType="text/html; charset=utf-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML>
<html>
<head>
    <title>后台登陆界面</title>
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="this is my page">
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" type="text/css" href="css/backlogin.css">
	<meta charset="utf-8">
  </head>
  
  <body>
    <div id="test">
    </div>
    <div id="login">
    	<form action="admin_adminLogin" method="post" id="myform">
            <div id="a">
            	<label for="aName">用户名:</label><input type="text" name="aName" id="uname" class="myinput" placeholder="请输入用户名" />
            </div>
            <div id="b">
            	<label for="aPwd">密　码:</label><input type="password" name="aPwd" id="pwd" class="myinput" placeholder="请输入密码" />
            </div>
            <input type="submit" id="mysub" value="登录" />
        </form>
    </div>
  </body>
</html>
