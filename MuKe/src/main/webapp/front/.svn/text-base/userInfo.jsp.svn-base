<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<c:if test="${not empty loginUser }">
	<div class="wenda-my">
		<div class="user-info">
					<a class="user-img" href="">
  					<img id="myimg" src="${loginUser.pic }" alt="${loginUser.uname }">
					</a>
					<p class="username">${loginUser.uname }</p>
					<a class="credit-count">${loginUser.usign }</a>
		</div>
		<ul class="user-about">
					<li><a href="javascript:void(0)">${loginUser.address_prov } </a></li>
					<li class="repl"><a href="javascript:void(0)">${loginUser.address_city }</a></li>
					<li><a href="javascript:void(0)" id="user_last">${loginUser.address_county } </a></li>
		</ul>
	</div>
</c:if>
<c:if test="${empty loginUser }">
	<div class="wenda-my">
		<div class="user-info">
					<a class="user-img" href="">
  					<img width="40px" height="40px" src="images/youke.jpg" alt="${loginUser.uname }">
					</a>
					<p style="color: #ccc" class="username">须登录才能获取权限</p>
		</div>
		<ul class="user-about">
					<li><a href="javascript:void(0)">省 </a></li>
					<li class="repl"><a href="javascript:void(0)">市</a></li>
					<li><a href="javascript:void(0)" id="user_last">县 </a></li>
		</ul>
	</div>
</c:if>