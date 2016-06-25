// JavaScript Document
//header部分
var biao=0;//点击隐藏时标记
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

function setDesc(_this){
	var p=_this;
	var area=$('#rlf-tip-wrap');
	p.hidden='hidden';
}

//点击隐藏已学时
function yinchang(yinchan){
	if(biao==0){
		$('.'+yinchan).css('background','url(images/2016-01-12_002601.png) no-repeat center left');
		biao=1;
	}else if(biao==1){
		$('.'+yinchan).css('background','url(images/2016-01-12_002538.png) no-repeat center left');
		biao=0;
	}
}