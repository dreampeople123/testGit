$(function(){
	$.post("cType_findAllDir",function(data){
		var obj=$("#dir");
		var opt;
		$.each(data,function(index,item){
			opt="<option value='"+item.ctDirname+"'>"+item.ctDirname+"</option>";
			obj.append($(opt));
		});
	},"json");
	
	setTimeout("getDeeply()",1000);
});

function getDeeply(){ //获取课程难易度信息
	$.post("deeply_getDeeply",function(data){
		var obj=$("#deeply");
		var opt;
		$.each(data.deeply,function(index,item){
			opt="<option value='"+item.dNo+"'>"+item.dName+"</option>";
			obj.append($(opt));
		});
	},"json");
}

function findTypeByDir(){ //获取课程的类别
	var key=$('#dir option:selected').val();
	$.post("cType_findTypeByDir",{key:key},function(data){
		var obj=$("#type");
		var opt;
		obj.html("");
		$.each(data,function(index,item){
			opt="<option value='"+item.ctNo+"'>"+item.ctName+"</option>";
			obj.append($(opt));
		});
	},"json");
}

function openFile(){//点击打开上传文件
	$("#video").click();
}

function showVideo(){ //显示上传的视频
    var img = document.getElementById('video');
    var videoSrc = URL.createObjectURL(img.files[0]);
    $("#showtishi").hide();
    $("#show").show();
    $("#show").attr("src",videoSrc);
}


function changeUpload(num){ //点击切换上传的内容
	var obj=$(".title");
	var newCourse=$("#newCourse");
	var newVideo=$("#maintain");
	if(num==0){
		$(obj[1]).attr("class","title");
		$(obj[0]).attr("class","title active");
		newVideo.hide();
		newCourse.show();
	} else if(num==1){
		$(obj[0]).attr("class","title");
		$(obj[1]).attr("class","title active");
		newCourse.hide();
		newVideo.show();
		
		$.post("user_getTeacherCourse",{uNo:uno},function(data){ //获取该教师维护的课程
			var obj=$("#myCourse");
			var opt="<option>--请选择课程--</option>";
			obj.html($(opt));
			$.each(data.infos,function(index,item){
				opt="<option value='"+item.cNo+"'>"+item.cName+"</option>";
				obj.append($(opt));
			});
		},"json");
	}
}

//遮罩的js
function openMask(){ //显示遮罩
	$("#mask").css({
		"height":$(document).height(),
		"width":$(document).width()
	}).show(); 
	
	$("#loading").show();
	
	$(document.body).css({ //禁用滚动条
		"overflow-x":"hidden",
		"overflow-y":"hidden"
	});
}

function showUploadWating(){ //显示等待
	$("#wating").show();
	$("#success").hide();
	$("#failed").hide();
}

function showUploadSuccess(){ //显示成功
	$("#wating").hide();
	$("#success").show();
	$("#failed").hide();
}

function showUploadFailed(){ //显示失败
	$("#wating").hide();
	$("#success").hide();
	$("#failed").show();
}

function closeMask(){ //隐藏遮罩
	$("#loading").hide(); 
	$("#mask").hide(); 
	
	$(document.body).css({ //启动滚动条
		"overflow-x":"auto",
		"overflow-y":"auto"
	});
}

function newCourseUpload(){ //上传新的课程
	showUploadWating();
	openMask();
	$("#chName").val($("#cName").val()+"第一章");
	var course=new FormData($("#newCourse")[0]);
	$.ajax({
		type:"post",
		url:"teacherUpload_uploadCourse",
		data:course,
		async:false,
		cache:false,
		contentType:false,
		processData:false,
		success:function(data){
			if(data==1){
				showUploadSuccess();
			} else{
				showUploadFailed();
			}
		}
	});
	
	setTimeout("closeMask()",3000);
}

function chapterUpload(){ //上传新的章节
	showUploadWating();
	openMask();
	var chapter=new FormData($("#maintain")[0]);
	console.info(chapter);
	$.ajax({
		type:"post",
		url:"teacherUpload_uploadChapter",
		data:chapter,
		async:false,
		cache:false,
		contentType:false,
		processData:false,
		success:function(data){
			if(data==1){
				showUploadSuccess();
			} else{
				showUploadFailed();
			}
		}
	});
 
	setTimeout("closeMask()",3000);
}

