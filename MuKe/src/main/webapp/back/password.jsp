<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<table id="update_adminPwd" data-options="fit:true"></table>
<center style="margin-top:50px;">
	<p id="pwdhid" style="display: none;">${loginAdmin.aPwd}</p><!-- 隐藏的密码 -->
	<p id="aidhid" style="display: none;">${loginAdmin.aId}</p><!-- 隐藏的管理员编号 -->
	<div>请输入原密码：
		<input type="password" maxlength="20" style="width:180px;height:25px;" id="yuanPwd" name="oldPwd"/>
		<span id="oldp" style="position:absolute;"></span>
	</div><br/>
	<div>请输入新密码：
		<input id="newPwd" type="password" maxlength="20" style="width:180px;height:25px;" placeholder="6-20大小写英文字母,数字或符号" name="newPwd"  />
		<span id="newp1" style="position:absolute; margin: 5px 0 0 10px;"></span>
	</div><br/>
	<div>确 认 新 密 码：
		<input id="newPwd2" type="password" maxlength="20" style="width:180px;height:25px;" placeholder="请再次输入密码" name="newPwd2"  />
		<span id="newp2" style="position:absolute; margin: 5px 0 0 10px;"></span>
	</div><br>
	<input id="pwdBtn" type="button" disabled="disabled" value="修改" onclick="updateAdminPwd()">
</center>
<script src="../easyui/js/password.js"></script>