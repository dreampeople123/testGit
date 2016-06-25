<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:choose>
	<c:when test="${not empty comments}">
		<c:forEach items="${comments}" var="item">
		<li>
			<div class="notelist_headpic">
				<a target="_blank" href="javascript:void(0)">
					<img width="40" height="40" src="../../${item.pic}">
				</a>
			</div>
			<div class="notelist_content">
				<div class="u_name">
					<a target="_blank" href="javascript:void(0)">${item.uname}</a>
				</div>
				<div class="js-notelist-content notelist-content mynote">
					<p>${item.commentcontent}</p>
					<div class="notelist-content-more">
						<a class="js-toggle-content" href="javascript:;"></a>
					</div>
				</div>
				<div class="clearfix">
					<!--  <a class="sava_btn" href="javascript:void(0);" style="diplay:none;">保存</a>-->
				</div>
				<div class="answercon notelist">
					<c:if test="${not empty item.yuliu1}">
					<div class="js-toggle-notelist answerImg">
						<img width="156" height="88" data-src="" src="../../${item.yuliu1}">
						<!--  <i class="had-ptime">00:44</i>-->
						  <div class="hover-area">
							<!--  <a class="js-catch-pic slider-door catch-pic" href="javascript:;"">
								<span>看截图</span>
							</a>-->
							<a class="slider-door catch-video" target="_blank" onclick="showpics('${item.yuliu1}')">
								<span>看截图</span>
							</a>
						</div>
					</div>
					</c:if>
				</div>
				<div class="notelist-bottom clearfix">
					<span class="l timeago" title="1447731431">${item.commenttime}</span>
					<div class="notelist-actions">
						<!--  <textarea style="display:none;">视频课程好</textarea>-->
						<!--<a class="Jcollect list-praise on" data-id="599080|105648" href="javascript:;" title="已采集">
							<span class="icon-star-revert on"></span>
							<i>已采集</i>
							<em>1</em>
						</a>-->
						<a class="Jpraise list-praise" data-id="599080" id="${item.commentno}" href="javascript:dianzan('${item.commentno}_${item.dianzannum}');" title="赞">
							<p>${item.dianzannum}</p>
						</a>
					</div>
				</div>
			</div>
		</li>
		</c:forEach>
		<!--<div class="page discuss-list-page">
							<c:choose>
                    				<c:when test="${pageUtil.pageNo eq 1}">
                    					<span class="disabled_page">首页</span>
										<span class="disabled_page">上一页</span>
                    				</c:when>
	                    			<c:otherwise>
	                    				<a href="javascript:void(0)">首页</a>
										<a href="javascript:void(0)">上一页</a>
	                    			</c:otherwise>
	                    		</c:choose>	
	                    		<c:forEach  begin="1" end="${pageUtil.totalSize}" var="item" >
            					</c:forEach>
            					<span class="disabled_page">首页</span>
										<span class="disabled_page">上一页</span>
							<a class="active" href="javascript:void(0)">1</a>
							<a href="javascript:void(0)">2</a>
							<a href="javascript:void(0)">3</a>
							<a href="javascript:void(0)">4</a>
							<a href="javascript:void(0)">5</a>
							<a href="javascript:void(0)">6</a>
							<a href="javascript:void(0)">7</a>
							<a href="javascript:void(0)">下一页</a>
							<a href="javascript:void(0)">尾页</a>
						</div>-->
             	</c:when>
          		<c:otherwise>
          			<p class="unquestion">
			        	<span class="icon-ques"></span>
			            	此节暂无同学的评论
		         	</p>
          		</c:otherwise>
             </c:choose>  