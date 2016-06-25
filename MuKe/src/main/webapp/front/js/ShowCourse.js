function findCourseByCnameTwo(){
	var cName=$.trim($("#showCname").val());
	var urls="courses_findCourseByCname.action";
	console.info(cName);
	if(cName==null||cName==""){
		location.reload(true);
	}else{
		$.post(urls,{cName:cName},function(data){
			if(data==1){
				location.reload(true);
			}else{
				location.reload(true);
			}
		});
	}
}	

