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

function gotoCha(chNo,cNo,uNo){
	$.post("courses_gotoCha",{cno:cNo,uno:uNo,chapterno:chNo},function(data){
		data=parseInt(data);
		if(data==1){
			window.open("shipin.jsp");
		}
	});
	
}