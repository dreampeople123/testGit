// JavaScript Document
//header部分
function change2White(_this){
	var text=_this; //输入搜索内容的文本框
	var btn=$('#search_btn_out'); //搜索按钮
	var div=$('#search_out'); //搜索所在的div
	
	div.attr('id','search_over');
	btn.attr('id','search_btn_over');
	text.id='search-input-over';
}

function change2Gray(_this){
	var text=_this; //输入搜索内容的文本框
	var btn=$('#search_btn_over'); //搜索按钮
	var div=$('#search_over'); //搜索所在的div
	
	div.attr('id','search_out');
	btn.attr('id','search_btn_out');
	text.id='search-input-out';
}

function changeSearchFocus(){
	var inptu=$('.search-tags-ipt');
	inptu.css('border-color','#999');
	inptu.css('color','black');
}

function changeSearchBlur(){
	$('.search-tags-ipt').css('border-color','#CCC');
}

//切换每一个功能
function change(_this,num){
		document.getElementById("learnOn").className="";
		document.getElementById("commentOn").className="";
		document.getElementById("1").style.display="none";
		document.getElementById("2").style.display="none";
		document.getElementById(num).style.display='block';
		document.getElementById(_this).className="active";
}
				
	
//级联
function show(_this){
	var chap=_this;
	chap.id='chapS';
	
	$("#_this").attr('class','active');
	
	
	var bbb=$('#chapterCon li');
	console.info(bbb);
	
	if($("#_this").attr('active',true)){
		if(bbb.css('display')=='none'){
			//alert("出来。。。。");
			bbb.css('display','block');	
		}else{
			//alert("快滚出来。。。。");
			bbb.css('display','none');	
		}
	}else{
		bbb.css('display','none');
	}
	
	
}

function close(){
	for(var i=5;i<=7;i++){
		var ul=document.getElementById(i);
		if(ul.style.display='display'){
			ul.style.display='none';	
		}	
	}	
}

function savePin(){
    var commentcontent=document.getElementById("js-note-textarea").value;
	if(commentcontent!=null&&commentcontent!=""){
	      $.post("../courseServlet?d="+new Date(),{op:"shengcheng",uno:uno,chapterno:chapterno,commentcontent:commentcontent},function(data){
									if(parseInt($.trim(data))==1){
										zuixin();
										noclose("note-publist");
									}else{
										console.info("error2");
									}
								});
		}else{
			 $.post("../courseServlet?d="+new Date(),{op:"shengcheng",uno:uno,chapterno:chapterno,commentcontent:commentcontent},function(data){
				 if(parseInt($.trim(data))==1){
					 zuixin();
						noclose("note-publist");
					}else{
						console.info("error2");
					}
				});
		}
}


function jumpToShiPin(a,b,c){
	console.info("说的"+a+b+c);
	$.post("courses_getshipinDataInfo",{cno:a,chapterno:b,uno:c},function(data){
		if(data==1){
			location.href="shipin.jsp";
		}
	});
}


//	function jumpToShiPin(a,b){
//		alert("进来了");
//		$.post("../courseServlet",{op:'showVideoByCno',cno:a,chapterno:b},function(data){
//			console.info(data+"试试");
//			if(parseInt(data)==1){
//				location.href="shipin.jsp";
//			}else{
//				
//			}
//		});
//	}


/**
 * 关注课程
 * @param uno
 * @param cno
 */
function AttentionCourse(uno,cno){
	$.post("../userCourseServlet",{op:"attentionCourse",uno:uno,cno:cno},function(data){
		data=parseInt(data);
		if(data==1){
			location.href="Middle.jsp?op=community";
		} else{
			alert("关注失败或已关注");
		}
	});
}

function jumpFirst(){
	var path=$("#firstA").attr("href");
	jumpToShiPin(path.substring(25,29),path.substring(32,36),path.substring(39,43));
}
