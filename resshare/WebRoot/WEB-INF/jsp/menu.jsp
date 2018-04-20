<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

	<div class="span5">
			<div class="logo">
				<a href="${pageContext.request.contextPath}/index.action"> <img
					src="${pageContext.request.contextPath}/image/r___________renleipic_01/logo.png"
					alt="瑞尚程序员" />
				</a>
			</div>
			
		</div>
	<div class="span5"> 
			&nbsp;			
	</div> 
	<div class="span10 last">
		<div class="topNav clearfix">
		
			<ul>
 			<li id="headerRegister" class="headerRegister">
 				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			</li>
			
			<s:if test="#session.existUser == null">
				<li id="headerLogin" class="headerLogin" style="display: list-item;">
					<a href="${ pageContext.request.contextPath }/user_loginPage.action">登录</a>|</li>
				<li id="headerRegister" class="headerRegister"
					style="display: list-item;"><a href="${ pageContext.request.contextPath }/user_registPage.action">注册</a>|
				</li>
			</s:if>
			<s:else>
				<li id="headerLogin" class="headerLogin" style="display: list-item;">
					<s:property value="#session.existUser.name"/>
					|</li>
				<%-- <li id="headerLogin" class="headerLogin" style="display: list-item;">
					<a href="${ pageContext.request.contextPath }/order_findByUid.action?page=1">我的订单</a>
				|</li> --%>
				<li id="headerRegister" class="headerRegister"
					style="display: list-item;"><a href="${ pageContext.request.contextPath }/user_quit.action">退出</a>|
				</li>
			</s:else>
						<li>
							<a>会员中心</a>|
						</li>
						<li>
							<a href="">学习指南</a>|
						</li>
						<li>
							<a href="https://github.com/chenjibao">关于我们</a>
						</li>
			</ul>
		</div>
		<div class="top-search"> 
				 <form action="${pageContext.request.contextPath}/product_findByProductPartName.action?page=1" class="navbar-form navbar-right">
					<input name="searchkey" type="text" class="form-control" placeholder="Search...">
					<input type="submit" value="搜索">
				</form>
		 </div> 
	</div>
	
	<div class="span24">
		<ul class="mainNav">
					<li>
						<a href="${ pageContext.request.contextPath }/index.action">首页</a>
					</li>
					<s:iterator var="category" value="#session.cList">
						<li>
							<a href="${pageContext.request.contextPath}/product_findByCid.action?cid=<s:property value="#category.cid"/>&page=1"><s:property value="#category.cname"/></a>
						</li>
					</s:iterator>
		</ul>
	</div>
