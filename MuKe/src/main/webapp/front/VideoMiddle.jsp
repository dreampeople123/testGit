<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page import="java.net.URLEncoder"%>
<script type="text/javascript" src="js/jquery-2.1.1.js"></script>
<script>
var op="${param.op}";

var chapterno="${param.chapterno}";
$(function start(){
		console.info(op);
		if("tiaozhuanVideo"==op){
			tiaozhuanVideo();
		}
	});
	
	function tiaozhuanVideo(){
		console.info("看chapterno"+chapterno)//courses_getshipinDataInfo
		$.post("courses_getshipinBychapter",{chapterno:chapterno},function(data){
		if(parseInt($.trim(data))==1){
			location.href="shipin.jsp";
		}else{
			console.info("errorasdf");
		}
});
	}
</script>

