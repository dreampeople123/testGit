$.post("../askServlet",{op:"getAskAnswer",askno:askno},function(data){
	var obj=$("#answerul");
	var opt="";
	$.each(data.answers,function(index,item){
		opt="<li><img class='userImg' src="+item.pic+" />"+item.answercontent+"<span>"+item.answertime+"</span></li>";
		obj.append($(opt));
	});
},"json");

function getLikeCoutse(){
	$.post("../questionServlet",{op:"likeQuestion",ctypeno:ctypeno},function(data){
		var obj=$("#likeAsk");
		var opt="";
		$.each(data.asks,function(index,item){
			opt="<li><a href='javascript:gotoQuestion("+item.askno+")'>"+item.asktitle+"</a></li>";
			obj.append($(opt));
		});
	},"json");
}

setTimeout("getLikeCoutse()",800);

function submitAnswer(){
	var content=ue.getContent();
	console.info(uno);
	if(uno=="" || uno==null || uno.length<1){
		alert("请先登录!!!");
	} else{
		$.post("../answerServlet",{op:"addAnswer",uno:uno,askno:askno,content:content},function(data){
			data=parseInt(data);
			if(data==1){
				location.reload(true);   
			}else{
				alert("内容不能为空!!!");
			}
		});
	}
	
}

function gotoQuestion(askno){
	$.post("../questionServlet",{op:"gotoQuestionHTML",askno:askno},function(data){
		data=parseInt(data);
		if(data==1){
			location.href="Question.jsp";
		}
	});
}

function hidediv() {
    document.getElementById("bgImg").style.display ='none';
    document.getElementById("show").style.display ='none';
}

setTimeout("add()",100);

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


