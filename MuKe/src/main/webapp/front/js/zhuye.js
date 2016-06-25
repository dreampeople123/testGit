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
//图片轮播效果
var img_index=1;//当前索引值
var img_total=0;//图片总数
var img_time;
var img_change_time=3000;
//判断是否跳转课程信息，
$(function(){
	var currentCourse="${currentCourseDetail}";
	if(currentCourse==null || currentCourse==""){
		location.href="Middle.jsp?op=currentCourse"
	}else{
	}
	
	img_total=$('#g-banner-img li').length;//所有的图片
	img_time=window.setInterval('showPic()',img_change_time);//设置定时器
	//对右边按键设置click监听
	$('#right').click(function(){
		clearInterval(img_time);
		if(img_index<img_total){
			$('#g-banner-img li').css('display','none');
			$('#g-banner-img li').eq(img_index).css('display','block');
		}else{
			img_index=0;
			$('#g-banner-img li').css('display','none');
			$('#g-banner-img li').eq(img_index).css('display','block');	
		}
		img_index++;
		console.info(img_index);
		img_time=window.setInterval('showPic()',img_change_time);//设置定时器
	});
	//对左边按键设置click监听
	$('#left').click(function(){
		clearInterval(img_time);
		if(img_index<img_total){
			$('#g-banner-img li').css('display','none');
			$('#g-banner-img li').eq(img_index).css('display','block');
		}else{
			img_index=1;
			$('#g-banner-img li').css('display','none');
			$('#g-banner-img li').eq(img_index).css('display','block');	
		}
		img_index++;
		console.info(img_index);
		img_time=window.setInterval('showPic()',img_change_time);//设置定时器
	});
	
	
	/*给课程的鼠标移动事件*/
		$(".icourse-course-li").mouseover(function(){
			var obj=this;
			var title=$(this).children("a").children(".title");
			var introduce=$(this).children("a").children(".introduce");
			var img=$(this).children("a").children(".icourse-img").children("img");
			introduce.show();
			title.hide();
			img.css('-moz-animation','move 0.3s ease-in 1 normal');
			img.css('-webkit-animation','move 0.3s ease-in 1 normal');
			img.attr("width","350px");
			img.attr("height","200px");
		});
		$(".icourse-course-li").mouseout(function(){
			var title=$(this).children("a").children(".title");
			var introduce=$(this).children("a").children(".introduce");
			var img=$(this).children("a").children(".icourse-img").children("img");
			title.show();
			introduce.hide();
			img.css('-moz-animation','move2 0.3s ease-in 1 normal');
			img.css('-webkit-animation','move2 0.3s ease-in 1 normal');
			img.attr("width","280px");
			img.attr("height","160px");
		})
});

function showPic(){
	img_total=$('#g-banner-img li').length;//所有的图片
	$('#g-banner-img li').css('display','none');
	$('#g-banner-img li').eq(img_index).css('display','block');
	img_index++;
	if(img_index>img_total-1){
		img_index=0;
	}
	
}

