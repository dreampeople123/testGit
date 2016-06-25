// JavaScript Document

$(function(){
	//鼠标移动到li时过渡span(2小时0分 | 高级)
	$('.course-one').mouseover(function(e){ 
	 	if(checkHover(e,this)){ 
			var span=$(this).children("a").children("span");
			span.css('-moz-animation','move 0.3s ease-in 1 normal');
			span.css('-webkit-animation','move 0.3s ease-in 1 normal');
			span.css('display','block'); 
		}
	});
	 
	
	$('.course-one').mouseleave(function(e){
		if(checkHover(e,this)){ 
			var span=$(this).children("a").children("span");
			span.css('-moz-animation','move 0.3s ease-in 1 normal');
			span.css('-webkit-animation','move 0.3s ease-in 1 normal');
			span.css('display','none');
		}
	});
	
	//li下的删除图标的hover
	$('.del').mouseover(function(){
		var img=$(this).children('img');
		img.attr('src','images/删除-红.png');
	});
	$('.del').mouseout(function(){
		var img=$(this).children('img');
		img.attr('src','images/删除-黑.png');
	});
	
	//li下的删除的点击事件
});

/** 
 * 下面是一些基础函数，解决mouseover与mouserout事件不停切换的问题（问题不是由冒泡产生的） 
 */  
function checkHover(e, target) {  
    if (getEvent(e).type == "mouseover") {  
        return !contains(target, getEvent(e).relatedTarget  
                || getEvent(e).fromElement)  
                && !((getEvent(e).relatedTarget || getEvent(e).fromElement) === target);  
    } else {  
        return !contains(target, getEvent(e).relatedTarget  
                || getEvent(e).toElement)  
                && !((getEvent(e).relatedTarget || getEvent(e).toElement) === target);  
    }  
}  
  
function contains(parentNode, childNode) {  
    if (parentNode.contains) {  
        return parentNode != childNode && parentNode.contains(childNode);  
    } else {  
        return !!(parentNode.compareDocumentPosition(childNode) & 16);  
    } 
}  
//取得当前window对象的事件  
function getEvent(e) {  
    return e || window.event;  
}  
