// JavaScript Document
$(function(){
	$('#question-title').blur(function(){
		var input=$(this).val();
		if(input.length<5){
			$('#question-title-hint').show();
		}
	});
	$('#question-title').focus(function(){
		$('#question-title-hint').hide();
	});
	
	$.post("cType_findAllCourseType",function(data){ //获取所有的课程类型
		var obj=$(".question-lable");
		var opt;
		$.each(data,function(index,item){
			opt='<span data-id="'+item.ctNo+'" onclick="addLabel(this)" class="labels">'+item.ctName+'</span>';
			$(obj).append($(opt));
		});
	});
});

var labelid; //方向编号
function addLabel(my){ //选择方向
	var label=$(my).text();
	$("#question-text").val(label);
	labelid=$(my).attr("data-id");
	
	
	$("#typeNo").val(labelid);
}

function submitQuestion(){ //发布问题
	var title=$('#question-title').val();
	var content=ue.getContent();
	
	if(uno=="" || uno==null || uno.length<1){
		alert("请先登录!!!");
	} else if(title.length<5 || content.length<17 || labelid==undefined){
		
	}else{
		$.post("../askServlet",{op:"addAsk",uno:uno,title:title,content:content,ctypeno:labelid},function(data){
			data=parseInt(data);
			if(data>0){
				location.href="Middle.jsp?op=community";
			} else{
				alert("发布问题失败!!!");
			}
		});
	}
}

function checkForm(){ //校验表单
	var title=$("#question-title").val();
	var content=$("#myeditor").val();
	
	if(title.length<5){
		$('#question-title-hint').show();
		return false;
	} else if(content.length<5){
		$('#bodytext-hint').show();
		return false;
	}
	
	return true;
}

//遮罩的js
function openMask(path){ //显示遮罩
	$("#mask").css({
		"height":$(document).height(),
		"width":$(document).width()
	}).show(); 
	
	$("#bigimgYulan").show();
	
	$(document.body).css({ //禁用滚动条
		"overflow-x":"hidden",
		"overflow-y":"hidden"
	});
}

function closeMask(){ //隐藏遮罩
	$("#bigimgYulan").hide();
	$("#bigimg").hide(); 
	$("#mask").hide(); 
	
	$(document.body).css({ //启动滚动条
		"overflow-x":"auto",
		"overflow-y":"auto"
	});
}

function showYulan(){ //显示预览
	$("#openFile").attr("class","");
	$("#Yulan").attr("class","issue");
	
    var img = document.getElementById('askImg');
    var imgSrc = URL.createObjectURL(img.files[0]);
	$($("#bigimgYulan").children()[0]).attr("src",imgSrc);
}

function openFile(){ //打开文件
	$("#askImg").click();
}