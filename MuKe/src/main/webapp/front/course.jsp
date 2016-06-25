<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>课程</title>
<link rel="shortcut icon" href="../images/1.png" type="image/x-icon"/>
<link href="css/coursein.css" type="text/css" rel="stylesheet"/>
<link rel="stylesheet" href="css/footer.css" type="text/css" />
<link rel="stylesheet" href="css/header.css" type="text/css" />
<script type="text/javascript" src="js/coursein.js"></script>
<script type="text/javascript" src="js/jquery-1.11.3.min.js"></script>
<script type="text/javascript" src="js/header.js"></script>
<script type="text/javascript" src="js/ShowCourse.js"></script>

</head>
<script type="text/javascript">
	//根据课程方向查找出信息
	function showCourseByCdirname(a){
		$.post("cType_findCourseByCdirname.action",{ctDirname:a},function(data){
	    	var obj=$("#ByCdirname");
	    	var opt="";
	    	console.info(data);
	    	$.each(data,function(index,item){
	    		opt+="<li class='course-one'><a target='_blank' href='courses_showCoursesByCno.action?cNo="+item.cNo+"'> "+
	             "<div class='course-list-img'><img alt="+ item.cName+ " src='../../upload/"+item.cPic+"' height='135' width='240'></div>"+
	              " <h5><span>"+item.cName+" </span></h5>"
	              " <div class='tips'><p class='text-ellipsis'>"+item.cProfiles+ "</p><span class='l update-latest'>更新至5-1</span></div>"+       
	              " <span class='time-label'>35分钟 | 高级</span><b class='follow-label'>跟我学</b></a></li>";
	    	});
	    	obj.html(opt);
	    },"json");
	}
	//根据课程类型名查找信息
	function showCourseByCtypename(a){
		$.post("cType_showCourseByCtypename.action",{ctName:a},function(data){
	    	var obj=$("#ByCdirname");
	    	var opt="";
	    	console.info(data);
	    	$.each(data,function(index,item){
	    		opt+="<li class='course-one'><a target='_blank' href='courses_showCoursesByCno.action?cNo="+item.cNo+"'> "+
	             "<div class='course-list-img'><img alt="+ item.cName+ " src='../../upload/"+item.cPic+"' height='135' width='240'></div>"+
	              " <h5><span>"+item.cName+" </span></h5>"+
	              " <div class='tips'><p class='text-ellipsis'>"+item.cProfiles+ "</p><span class='l update-latest'>更新至5-1</span></div>"+       
	              " <span class='time-label'>35分钟 | 高级</span><b class='follow-label'>跟我学</b></a></li>";
	    	});
	    	obj.html(opt);
	    },"json");
	}
	//根据课程难易程度查找课程信息
	function showCourseByDname(a){
		$.post("deeply_showCourseByDname.action",{dName:a},function(data){
	    	var obj=$("#ByCdirname");
	    	var opt="";
	    	console.info(data);
	    	$.each(data,function(index,item){
	    		opt+="<li class='course-one'><a target='_blank' href='courses_showCoursesByCno.action?cNo="+item.cNo+"'> "+
	             "<div class='course-list-img'><img alt="+ item.cName+ " src='../../upload/"+item.cPic+"' height='135' width='240'></div>"+
	              " <h5><span>"+item.cName+" </span></h5>"+
	              " <div class='tips'><p class='text-ellipsis'>"+item.cProfiles+ "</p><span class='l update-latest'>更新至5-1</span></div>"+       
	              " <span class='time-label'>35分钟 | 高级</span><b class='follow-label'>跟我学</b></a></li>";
	    	});
	    	obj.html(opt);
	    },"json");
	}
</script>
<body>
<%@ include file="header.jsp" %>

<div id="main">
	<div class="container">
    	<div class="course-content">
            	<div class="course-nav-box">
                	<div class="course-nav-hd">
                    	<b>全部课程</b>
                         <a href="aboutUs.html" class="for-teacher hide-text" title="应聘讲师" target="_blank"></a>
                    </div>
                    <div class="course-nav-row clearfix">
                    	<div class="hdd">
                        	<p class="hd">方向:</p>
                        </div>
                        <div class="bd">
                        	<ul >
                        		<li class="course-nav-item"><a href="courses_findAllTypes.action">全部</a></li>
                        		<c:forEach items="${allDir}" var="a">
                        			<li class="course-nav-item"><a target="_self" href="javascript:showCourseByCdirname('${a.ctDirname }')">${a.ctDirname }</a></li>
                        		</c:forEach>		
                            </ul>
                        </div>
                        
					</div>
                    <div class="course-nav-row clearfix">
                    	<div class="hdd">
                        	<p class="hd">分类:</p>
                        </div>
                    	
                        <div class="bd">
                        	<ul id="abc">
                        		<li class="course-nav-item "><a href="courses_findAllTypes.action">全部</a></li>
                       				<c:forEach items="${cTypeInfo}" var="b" >
                               			<li class="course-nav-item " id="ctypenames">
                               				<a href="javascript:showCourseByCtypename('${b.ctName }')">${b.ctName }</a>
                               			</li>
                               		</c:forEach>
                            </ul>
                        </div>
                    </div>
                    <div class="course-nav-row clearfix">
                    	<div class="hdd">
                    	<p class="hd">难度:</p>
                        </div>
                        <div class="bd">
                        	 <ul class="">
                        	 	<li class="course-nav-item " id="ctypename"><a href="courses_findAllTypes.action" >全部</a></li>
                        	 	<c:forEach items="${deeplyInfo}" var="a">
                        			<li class="course-nav-item ">
                                		<a href="javascript:showCourseByDname('${a.dName}')">${a.dName }</a>
                            		</li>
                               	</c:forEach>
                        	</ul>
                        </div>
                    </div>
                </div>
                
                <div class="course-tool-bar">
                	<div class="l">
                    	<span class="tool-item" style="display: none;">
                        	<a class="follow-learn tool-chk" >跟我学</a>
                    	</span>
                	</div>
                	
                	<div class="tool-right r">
                    	<span class="tool-item total-num">
                        	共<b>433</b>个课程
                    	</span>
                	</div>
           		</div>
                <div class="course-list">
                	<div class="js-course-lists">
						<ul id="ByCdirname">
							<c:forEach items="${courseInfo}" var="a">
								<li class="course-one">
									 <a target="_blank" href="courses_showCoursesByCno.action?cNo=${a.cNo }" target="_blank" >
	                                    <div class="course-list-img">
	                                    	
	                                        <img alt="${a.cName }" src="../../upload/${a.cPic }" height="135" width="240">
	                                    </div>
	                                    <h5>
	                                        <span>${a.cName }</span>
	                                    </h5>
	                                    <div class="tips">
	                                        <p class="text-ellipsis">${a.cProfiles }</p>
	                                        <span class="l update-latest">更新至5-1</span>                             

	                                    </div>
	                                    <span class="time-label">
	                                        35分钟 | 高级
	                                    </span>
	                                    <b class="follow-label">跟我学</b>
	            					</a>
                            	</li>
							</c:forEach>
						    
                     		
						</ul>
        
        			</div>
                  	<div class="page">
                        <span class="disabled_page">首页</span>
                        <span class="disabled_page">上一页</span>
                        <a href="javascript:void(0)" class="active">1</a>
                        <a href="javascript:void(0)">2</a>
                        <a href="javascript:void(0)">3</a>
                        <a href="javascript:void(0)">4</a>
                        <a href="javascript:void(0)">5</a>
                        <a href="javascript:void(0)">6</a>
                        <a href="javascript:void(0)">7</a>
                        <a href="javascript:void(0)">下一页</a>
                        <a href="javascript:void(0)">尾页</a>
                	</div>
            	</div>
    		</div>
		</div>
	</div>
</div>
<div id="footer">
    <div class="footer_intro l">
        <div class="footer_link">
            <ul>
                <li><a href="#" target="_blank">网站首页</a></li>
                <li><a href="#" target="_blank">人才招聘</a></li>
                <li><a href="#" target="_blank">联系我们</a></li>
                <li><a href="#" target="_blank">高校联盟</a></li>
                <li><a href="#" target="_blank">关于我们</a></li>
                <li><a href="#" target="_blank">讲师招募</a></li>
                <li><a href="#" target="_blank">意见反馈</a></li>
                <li><a href="#" target="_blank">友情链接</a></li>
            </ul>
        </div><!--footer_link结束-->
        <br/>
        <p>
        	<span style="color:#999">Copyright  2015 imooc.com All Rights Reserved | 京ICP备 13046642号-2</span>
        </p>
    </div><!--footer_intro l结束-->
</div><!--footer结束-->
</body>
</html>
