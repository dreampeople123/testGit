// JavaScript Document
var r=1;//转换截图效果变量以及是否截图的标志 1：不截图2：截图
var r1=1;//转换截图效果变
var chang;//用户固定窗口的变量
var hong=0;
var commentno=new Array();//判断是否点过赞
var guanzhu=false;//是否关注的标志
//一进页面查信息
//var uno="1044";
//var chapterno="1000";
//var cno="1000";

var  maxstrlen=1000;//评论出输入字数的最大数
var dancanvas;//确定好的图片

//$.post("../courseServlet?d="+new Date(),{op:"getshipinDataInfo",uno:uno,cno:cno,chapterno:chapterno},function(data){
//		if(parseInt($.trim(data))==1){
//		}else{
//			console.info("errorasdf");
//		}
//});

//点击章节是互相跳转
function tiaozhuan(tchapterno){
	chapterno=tchapterno;
	location.href="VideoMiddle.jsp?d="+new Date()+"&op=tiaozhuanVideo&chapterno="+chapterno;
	
}
//模拟一个请求
var xmlHttp;
function createXMLHttpRequest(){
	if(window.XMLHttpRequest){        
		xmlHttp = new XMLHttpRequest();    
	}else if(window.ActiveXObject){        
		xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");    
	}
}
//点击精华查询信息
function jinhua(){
//	location.href="VideoHref.jsp?op=getJinhuaAskInfo&cno="+cno;
	$.post("../courseServlet?d="+new Date(),{op:"getJinhuaAskInfo"},function(data){
		if(parseInt($.trim(data))==1){
			console.info("asdfasdf");
		}else{
			console.info("error");
		}
		});
	setTimeout("clearWord()", 500);
	document.getElementById("quanbu").className="quealltab";
	document.getElementById("jinhua").className="quealltab onactive";
}
//刷新问答处页面
function clearWord(){
	createXMLHttpRequest();    
	xmlHttp.onreadystatechange = handleStateChange;   
	xmlHttp.open("GET", "VideoAsk.jsp");   
	xmlHttp.send(null);
	
}
//加载页面
function handleStateChange() {   
	if(xmlHttp.readyState == 4) {       
		if(xmlHttp.status == 200) {           
			document.getElementById("qiehuanjin").innerHTML=xmlHttp.responseText;
		}    
	}
}
//点击全部查询问答信息
function quanbu(){
	$.post("../courseServlet?d="+new Date(),{op:"getAllAskInfo"},function(data){
		if(parseInt($.trim(data))==1){
			console.info("asdfasdf");
		}else{
			console.info("error");
		}
		});
	setTimeout("clearWord()", 100);
	document.getElementById("quanbu").className="quealltab onactive";
	document.getElementById("jinhua").className="quealltab";
}
//点击最新查询评论信息
function zuixin(){
	$.post("../courseServlet?d="+new Date(),{op:"getLastComInfo"},function(data){
		if(parseInt($.trim(data))==1){
			console.info("asdfasdf");
		}else{
			console.info("error");
		}
		});
	setTimeout("clearWords()", 100);
	document.getElementById("zuixin").className="sort-item active";
	document.getElementById("danzan").className="sort-item";
}
//刷新问答处页面
function clearWords(){
	createXMLHttpRequest();    
	xmlHttp.onreadystatechange = handleStateChanges;   
	xmlHttp.open("GET", "VideoCom.jsp");   
	xmlHttp.send(null);
	
}
//加载页面
function handleStateChanges() {   
	if(xmlHttp.readyState == 4) {       
		if(xmlHttp.status == 200) {           
			document.getElementById("pinlun").innerHTML=xmlHttp.responseText;
		}    
	}
}
//点击点赞查询评论信息
function ddian(){
	$.post("../courseServlet?d="+new Date(),{op:"getComInfoBydian"},function(data){
		if(parseInt($.trim(data))==1){
			console.info("asdfasdf");
		}else{
			console.info("error");
		}
		});
	setTimeout("clearWords()", 100);
	document.getElementById("zuixin").className="sort-item";
	document.getElementById("danzan").className="sort-item active";
}
//切换问答评论
function qie(name){
	//document.getElementById("plMenu").className="";
	document.getElementById("qaMenu").className="";
	document.getElementById("noteMenu").className="";
	//document.getElementById("pl-content").style.display="none";
	document.getElementById("qa-content").style.display="none";
	document.getElementById("note-content").style.display="none";
	document.getElementById(name).className="active";
	var na=name.substr(0,(name.indexOf("M")))+"-content";
	document.getElementById(na).style.display="block";
}
//点击章节处的特效
function zhang(){
	var wid=document.getElementById("js-box-wrap").style.width;
	if(wid=="989px"){
		document.getElementById("js-box-wrap").style.width="100%";
		document.getElementById("section-list").style.marginRight="-360px";
		document.getElementById("light").style.background="#363C40";
	}else{
		document.getElementById("js-box-wrap").style.width="989px";
		document.getElementById("section-list").style.marginRight="0px";
		document.getElementById("light").style.background="#F01400";
		
		}
	}
/*打开评论内容*/
function zhangno(){
	document.getElementById("media").pause();
	$("#bg").css("display","block");
	document.getElementById("note-publist").style.display="block";
	document.getElementById("note-publist").style.top=document.documentElement.scrollTop+'px';

							
	window.onscroll=move;
	
	}
//看截图
function showpics(pic){
	document.getElementById("media").pause();
	$("#bg").css("display","block");
	chang=document.documentElement.scrollTop; 
	document.getElementById("showphoto").src="../../"+pic;
	document.getElementById("showpics").style.display="block";
	document.getElementById("showpics").style.top=document.documentElement.scrollTop+'px';
	window.onscroll=move2;
}

/*截图处的特效*/
function jie(){
	if(r==1){
		document.getElementById("screen-btnbi").className="js-shot-video screen-btn on";
		r=2;
		}else{
			r=1;
			document.getElementById("screen-btnbi").className="js-shot-video screen-btn";}
	
	}
function jie1(){
	if(r1==1){
		document.getElementById("screen-btnbi1").className="js-shot-video screen-btn on";
		r1=2;
		}else{
			r1=1;
			document.getElementById("screen-btnbi1").className="js-shot-video screen-btn";}
	
	}
/*问题评论界面的关闭*/
function noclose(imgeid){
	document.getElementById("media").play();
	document.getElementById(imgeid).style.display="none";
	$("#bg").css("display","none");
	document.getElementById("js-note-textarea").value="";
	document.getElementById("js-qa-title").value="";
	ue.setContent("");
	if(r==2){
		jie();
	}
	}
	
/*评论窗口的固定相对位置*/
function move(){
	
		if(document.body.scrollTop<=0){
			document.getElementById("note-publist").style.top=document.documentElement.scrollTop+'px';
		}else{
			document.getElementById('note-publist').style.top=document.body.scrollTop-chang+'px';
			}
		
	}
//问答处的固定相对位置
function move1(){
	
		if(document.body.scrollTop<=0){
			document.getElementById("discus-publish").style.top=document.documentElement.scrollTop+'px';
		}else{
			document.getElementById('discus-publish').style.top=document.body.scrollTop-chang+'px';
			}
		
	}
//查看图片处的固定相对位置
function move2(){
		
		if(document.body.scrollTop<=0){
			document.getElementById("showpics").style.top=document.documentElement.scrollTop+'px';
		}else{
			document.getElementById('showpics').style.top=document.body.scrollTop-chang+'px';
			}
	}
/*打开问答界面*/
function zhangqa(){
	document.getElementById("media").pause();
	$("#bg").css("display","block");
	chang=document.documentElement.scrollTop; 
	var r=document.getElementById("discus-publish");
	console.info(r);
	document.getElementById("discus-publish").style.display="block";
	document.getElementById("discus-publish").style.top=document.documentElement.scrollTop+'px';
	window.onscroll=move1;
	}
//点击关注图标变化
function guanzhuci(name){
	var Str=document.getElementById(name).className;
	var sstr="js-btn-follow course-follow guan";
	var att=0;
	if(Str==sstr){
		document.getElementById(name).className="js-btn-follow course-follow";
		att=0;
	}else{
		document.getElementById(name).className="js-btn-follow course-follow guan";
		att=1;
	}
	$.post("../userCourseServlet",{op:"isguan",attention:att},function(data){
		data=parseInt(data);
		if(data>0){
			console.info("succes");
		}else{
			console.info("error");
		}
	});
}
//点赞
function dianzan(nama){
	commentno[0]="zddd";
	var lin=nama.split("_");
	var isdian=false;
	for(var i=0;i<commentno.length;i++){
		if(lin[0]==commentno[i]){
			isdian=false;
		}else{
			isdian=true;
		}
	}
	if(isdian){
		commentno.push(lin[0]);
		$("#"+lin[0]).html($("<p id="+lin[0]+"shouz style='color:#F01400'>"+(Number(lin[1])+1)+"</p>"));
		$("#"+lin[0]+"shouz").css("background","url(images/2016-01-12_190038.png) no-repeat center center");
		$.post("../commentsServlet",{op:"dianzan",commentno:lin[0]},function(data){
			data=parseInt(data);
			if(data>0){
				console.info("succes");
			}else{
				console.info("error");
			}
		});
	}
}
//点击评论输入框出现的特效
function checkWord(c){
	document.getElementById("js-note-input-fake").className="textarea-wrap ipt-fake-focus space-fake-focus";
	len=maxstrlen;
	var str =c.value;
	console.info(str);
	myLen=getStrleng(str);
	if(myLen>len*2){
		c.value=str.substring(0,i+1);
	}else{
		document.getElementById("js-note-limit").innerHTML =1000-Math.floor((len*2-myLen)/2);
	}
}
//计算出当前输入文字的字数
function getStrleng(str){
	myLen =0;
	i=0;
	for(;(i<str.length)&&(myLen<=maxstrlen*2);i++){
		if(str.charCodeAt(i)>0&&str.charCodeAt(i)<128)
		myLen++;
		else
		myLen+=2;
	}
	return myLen;
	}
//文本输入框失去焦点时
function note_shiqu(){
	document.getElementById("js-note-input-fake").className="textarea-wrap";
}

//保存评论
function savePin(){
	var video = document.getElementById("media");
    var canvas = document.querySelectorAll('canvas')[0];
    var ctx = canvas.getContext('2d');
    var width = 480;
    var height = 270;
    canvas.width = width;
    canvas.height = height;
    var commentcontent=document.getElementById("js-note-textarea").value;
	if(r==2){
		ctx.drawImage(video, 0, 0, width, height);
		 var images = canvas.toDataURL('image/png');
	      $.post("../courseServlet?d="+new Date(),{op:"shengcheng",images:images,commentcontent:commentcontent},function(data){
									if(parseInt($.trim(data))==1){
										zuixin();
										noclose("note-publist");
									}else{
										console.info("error2");
									}
								});
		}else{
			 $.post("../courseServlet?d="+new Date(),{op:"shengcheng",commentcontent:commentcontent},function(data){
				 if(parseInt($.trim(data))==1){
					 zuixin();
						noclose("note-publist");
					}else{
						console.info("error2");
					}
				});
		}
}
//点击保存问题
function submitQuestion(){
	var title=$('#js-qa-title').val();
	var content=ue.getContent();
	var ctypeno = '<%=session.getAttribute("dancourse.cname")%>';
	$.post("../askServlet",{op:"addAsks",title:title,content:content,ctypeno:ctypeno},function(data){
		data=parseInt(data);
		if(data>0){
			quanbu();
			noclose("discus-publish");
			
		}
	});
}
