function findCourseByCnameTwo(){
	//alert("俺进来了。。。。。。。");
	var cname=$.trim($("#showCname").val());
	console.info(cname);
	if(cname==null||cname==""){
		location.reload(true);
	}else{
		$.post("../courseServlet?d="+new Date(),{op:"findCourseInfoByCnames",cname:cname},function(data){
			if(data==1){
				location.reload(true);
			}else{
				location.reload(true);
				//alert("给老子滚出来。。。。。。");
			}
		});
	}
}	

