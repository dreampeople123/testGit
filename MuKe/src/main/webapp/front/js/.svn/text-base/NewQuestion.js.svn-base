// JavaScript Document
$(function(){
	/*标题*/
	$('#question-title').blur(function(){
		var input=$(this).val();
		if(input.length<5){
			$('#question-title-hint').show();
		}
	});
	$('#question-title').focus(function(){
		$('#question-title-hint').hide();
	});
	
	/*正文*/
	ue.addListener("blur", function (type, event) {
								var text=ue.getContent();
								if(text.length<17){
									$('#bodytext-hint').show();	
								}
					});
	ue.addListener("focus", function (type, event) {
								$('#bodytext-hint').hide();	
	});
});

var labelid; //方向编号
function addLabel(my){ //选择方向
	var label=$(my).text();
	$("#question-text").val(label);
	labelid=$(my).attr("data-id");
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
