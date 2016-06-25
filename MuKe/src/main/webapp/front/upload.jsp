<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html >
<html>
<head>
<meta content="text/html; charset=UTF-8" http-equiv="Content-Type">
<meta charset="utf-8">
<title>视频上传</title>
<link href="css/header.css" type="text/css" rel="stylesheet" />
<link href="css/upload.css" rel="stylesheet">

<script type="text/javascript" src="js/jquery-2.1.1.js"></script>
<script type="text/javascript" src="js/header.js"></script>
<script type="text/javascript">
	var uno="${loginUser.uNo}";
</script>
<script type="text/javascript" src="js/upload.js"></script>
</head>

<body>
<%@include file="header.jsp" %>

	<!-- 遮罩 -->
	<div id="mask" class="mask">
	</div>
	<div id="loading">
		<div id="wating">
			<img alt="loading" width="85px" height="81px" src="images/loading.gif">
			<p>正在上传...</p>
		</div>

		<div hidden="hidden" id="success">
			<img alt="success" width="85px" height="81px" src="images/success.jpg">
			<p>上传成功</p>
		</div>
		
		<div hidden="hidden" id="failed">
			<img alt="failed" width="85px" height="81px" src="images/failed.jpg">
			<p>上传失败</p>
		</div>
	</div>

	<div id="main">
		<div id="content">
			<p style="margin-left: 10px; margin-top: 8px; font-size: 16px;">
				<span onclick="changeUpload(0)" class="title active">新课程上传</span>
				<span onclick="changeUpload(1)" class="title" style="margin-left: 10px;">视频上传</span>
			</p>
			<hr style="color: #EDEFF0; margin-top: 10px;" /><br /><br />
			
			<form hidden="hidden" id="maintain" action="" method="post" enctype="multipart/form-data">
				<input hidden="hidden" name="uno" type="text" value="${loginUser.uNo}" />
				<!-- 修改uno -->
				<span style="margin-left: 150px;">请选择所要上传视频的课程:</span>
				<select name="cno" id="myCourse" style="width: 250px; height: 40px; font-size: 14px;">
				</select>
				
				<span style="margin-left: 150px;display: inline-block;margin-top: 40px;">请输入上传视频的章节名:</span>
				<input name="chName" type="text" placeholder="请填写章节名" style="width: 250px; height: 40px; margin-left: 14px;"/>
				
				<span style="margin-left: 150px;display: inline-block;margin-top: 40px;">请选择所要上传的视频:</span>
				<input type="button" value="选择视频" onclick="openFile()" style="width: 100px; height: 40px; border: 0px; color: white; cursor: pointer; background: #00B33B;margin-left: 80px;"/>
				<input onchange="showVideo()" id="video" type="file" name="video" hidden="hidden"/><br/><br/>
				<div style="text-align: center;">
					<div id="showtishi" style="width: 400px; height: 225px; background: #737373; line-height: 225px; color: white;">暂无上传的视频</div>
					<video hidden="hidden" id="show" src="" width="400px" height="225px" controls="ture" autoplay="autoplay">浏览器不支持</video>
				</div>
							
				<input type="button" onclick="chapterUpload()" value="上传" style="width: 100px; height: 40px; border: 0px; color: white; cursor: pointer; background: #00B33B;margin:30px 0 40px 340px; "/>
			</form>
		
			<form id="newCourse" action="teacherUpload_uploadCourse" method="post" enctype="multipart/form-data">
				<input hidden="hidden" name="uno" type="text" value="${loginUser.uNo}" />
				<!-- 修改uno -->
				
				<span style="margin-left: 100px;"><span class="star">*&nbsp;</span>请选择上传课程所属的方向：</span>
				<select id="dir" name="dir" onchange="findTypeByDir()" style="width: 250px; height: 40px;">
					<option>--请选择课程方向--</option>
				</select> <br /><br /><br />
				 
				<span style="margin-left: 100px;"><span class="star">*&nbsp;</span>请选择上传课程所属的分类：</span>
				<select id="type" name="ctNo" style="width: 250px; height: 40px;">
					<option>--请选择课程分类--</option>
				</select> <br /><br /> 
				
				<span style="margin-left: 100px;"><span class="star">*&nbsp;</span>请选择上传课程难易度类别：</span>
				<select id="deeply" name="dNo" style="width: 250px; height: 40px;">
					<option>--请选择难易度--</option>
				</select> <br /><br /> 
				
				<span style="margin-left: 192px;"><span class="star">*&nbsp;</span>课程视频上传：</span>
				<input name="video" id="chooseVedio" type="file" style="width: 140px; height: 40px;" /> <br /><br /> 
				
				<span style="margin-left: 190px;"><span class="star">*&nbsp;</span>课程图片上传：</span>
				<input name="cPic" id="choosePicture" type="file" style="width: 140px; height: 40px;" /> <br /><br /> 
				
				<span style="margin-left: 144px;"><span class="star">*&nbsp;</span>请输入你的课程名称：</span>
				<input id="cName" name="cName" type="text" style="width: 250px; height: 40px;" placeholder="请输入课程名称" /><br />
				<input type="text" id="chName" name="chName" hidden="hidden"/>
				 
				<span style="margin-left: 317px; color: #999;">
				<span class="star">*</span>此处必填</span> <br /><br /> 
				
				<span style="margin-left: 220px;"><span class="star">*&nbsp;</span>课程简介：</span>
				<textarea name="cProfiles" placeholder="请输入内容" style="width: 250px; min-height: 40px;"></textarea><br /> 
				
				<input onclick="newCourseUpload()" type="button" value="提  交" style="width: 100px; height: 40px; border: 0px; color: white; cursor: pointer; background-color: #00B33B; margin-left: 350px; margin-top: 30px; margin-bottom: 10px; font-size: 15px;" />
			</form>
		</div>

		<div class="right">
			<!-- 应聘讲师 -->
			<div class="hire shadow">
				<img src="images/hire_img.jpg" alt="" class="hire_img">
				<p class="hire-reason">如果你对本课程领域擅长、能按照自己或者本求课的描述分享你的知识给互联网用户，就来应聘吧</p>
				<p class="hire-reason">你的课程会在慕课网及我们的合作渠道中展示和推广，你就是未来的行业大牛</p>
				<p class="hire-reason">慕课网还会为你支付课程公益津贴，让你得到既实际又实惠的回报</p>
			</div>
		</div>
	</div>

	<div class="footer">
		<div class="footer_intro l">
			<div class="footer_link">
				<ul>
					<li><a href="#" target="_blank">网站首页</a></li>
					<li><a href="#" target="_blank">人才招聘</a></li>
					<li><a href="#" target="_blank">联系我们</a></li>
					<li><a href="#" target="_blank">高校联盟</a></li>
					<li><a href="aboutUs.html" target="_blank">关于我们</a></li>
					<li><a href="#" target="_blank">讲师招募</a></li>
					<li><a href="#" target="_blank">意见反馈</a></li>
					<li><a href="#" target="_blank">友情链接</a></li>
				</ul>
			</div>
			<br />
			<p>
				<span style="color: #999">Copyright 2015 imooc.com All Rights Reserved | 京ICP备 13046642号-2</span>
			</p>
		</div>
	</div>
</body>
</html>
