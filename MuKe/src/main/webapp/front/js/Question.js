function hidediv() {
    document.getElementById("bgImg").style.display ='none';
    document.getElementById("show").style.display ='none';
}

//setTimeout("add()",100);

function add(){
	var obj=$("#yulian");
	var src;
	$("#answerul").children("li").children("p").children("img").click(function(){
		src=$(this).attr("src");
		obj.attr("src",src);
	    document.getElementById("bgImg").style.display ="block";
	    document.getElementById("show").style.display ="block";
	});
	
	$(".qu-body-body").children("p").children("img").click(function(){
		src=$(this).attr("src");
		obj.attr("src",src);
	    document.getElementById("bgImg").style.display ="block";
	    document.getElementById("show").style.display ="block";
	});
}

//遮罩的js
function openMask(op,path){ //显示遮罩
	$("#mask").css({
		"height":$(document).height(),
		"width":$(document).width()
	}).show(); 
	
	if(op==1){
		$("#bigimg").show();
		$($("#bigimg").children()[0]).attr("src",path);
	} else if(op==2){
		$("#bigimgYulan").show();
	}
	
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

function openfile(){ //打开文件上传
	$("#answerImg").click();
}

function showYulan(){ //显示预览
	$("#uploadImg").hide();
	$("#yulan").show();
	
	//并且换显示图片的路径
    var img = document.getElementById('answerImg');
    var imgSrc = URL.createObjectURL(img.files[0]);
    $($("#bigimgYulan").children()[0]).attr("src",imgSrc);
}


