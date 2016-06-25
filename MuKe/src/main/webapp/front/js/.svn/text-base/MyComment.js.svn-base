// JavaScript Document
//删除元素
$(function(){
	$('.discuss').mouseover(function(){
		var showDiv=$(this).children('.editordel');
		showDiv.show();
		
		showDiv.mouseover(function(){
			showDiv.children('a').children('i').children('img').attr('src','images/del-blue.jpg');
			showDiv.children('a').children('em').css('color','black');
		});
		showDiv.mouseout(function(){
			showDiv.children('a').children('i').children('img').attr('src','images/del-gray.jpg');
			showDiv.children('a').children('em').css('color','#999');
		});
	});
	
	$('.discuss').mouseout(function(){
		var showDiv=$(this).children('.editordel');
		showDiv.hide();
	});
	

});

function gotoCha(no){
	$.post("../courseServlet",{op:"gotoCha",chapterno:no,uno:uno},function(data){
		if(data==1){
			location.href="shipin.jsp";
		}
	});
}