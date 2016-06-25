<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:choose>
             	<c:when test="${not empty asks}">
             		<c:forEach items="${asks}" var="item">
						<div class="wenda-listcon">
							<div class="headslider">
								<a class="wenda-head" title="${item.uname}" target="_blank" href="">
						        	<img width="40" height="40" alt="${item.uname}" src="${item.pic}">
								</a>
										<a class="wenda-nickname" title="${item.uname}" target="_blank" href="">${item.uname}</a>
									</div>
									<div class="wendaslider">
										<a class="replynumber hasanswernum" target="_blank" href="">
											<c:forEach items="${countAnswers}" var="itesem">
						                    			<c:if test="${itesem.askno eq item.askno}">
					                    					<div class="ys">
																<div class="number padAjust">
																	<b class="numShow">${itesem.counAnswer}</b>
																</div>
																<div class="number">回答</div>
															</div>
					                    				</c:if>
			            					</c:forEach>
										</a>
										<h2 class="wendaquetitle">
											<i class="icon-ques-revert"></i>
											<div class="wendatitlecon">
												<a class="wendatitle" target="_blank" href="">
													<p>${item.askcontent} </p>
												</a>
											</div>
										</h2>
										<div class="replycont clearfix">
											<i class="icon-msg-revert"></i>
											<div class="fl replydes">
												<c:forEach items="${answers}" var="iteem">
						                    		<c:if test="${iteem.askno eq item.askno}">
						                    			<span class="replysign praise">[最新回答]</span>
					            						<a class="replyuserhead" title="${iteem.uname}" target="_blank" href="">
															<img width="20" height="20" alt="${iteem.uname}" src="${iteem.pic}">
														</a>
														<a class="nickname" title="${iteem.uname}" target="_blank" href="">${iteem.uname}: </a>
														<span class="replydet">${iteem.answercontent}</span>
					            					</c:if>
			            						</c:forEach>
											</div>
										</div>
										<div class="replymegfooter">
											<div class="wenda-time">
												<em>时间：${item.askTimes}</em>
											</div>
										</div>
									</div>
								</div>
						</c:forEach>
						<div class="page discuss-list-page">
						<!--	<c:choose>
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
							<a href="javascript:void(0)">尾页</a>-->
						</div>
             	</c:when>
          		<c:otherwise>
          			<p class="unquestion">
			        	<span class="icon-ques"></span>
			            	此节暂无同学的问答
		         	</p>
          		</c:otherwise>
             </c:choose>  