<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>瑞尚程序员</title>
<link href="${pageContext.request.contextPath}/css/slider.css"
	rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath}/css/common.css"
	rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath}/css/index.css"
	rel="stylesheet" type="text/css" />

</head>
<body>

	<div class="container header">
		<%@ include file="menu.jsp"%> 
	</div>

	<div class="container index">
		<div class="span24">
			<div id="hotProduct" class="hotProduct clearfix">
				<div class="title">
					<strong>热门教程</strong>
					<!-- <a  target="_blank"></a> -->
				</div>
				<ul class="tab">
					<li class="current"><a href="#"
						target="_blank"></a></li>
					<li><a target="_blank"></a></li>
					<li><a target="_blank"></a></li>
				</ul>
				<ul class="tabContent" style="display: block;">
					<s:iterator var="product" value="hList">
						<li><a href="${pageContext.request.contextPath}/product_findByPid.action?pid=<s:property value="#product.pid"/>" target="_blank"><img
								src="${pageContext.request.contextPath}/<s:property value="#product.image"/>"
								data-original="http://storage.shopxx.net/demo-image/3.0/201301/0ff130db-0a1b-4b8d-a918-ed9016317009-thumbnail.jpg"
								style="display: block;"></a>
								&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<font color="red"><s:property value="#product.downloadnum"/>人学习过</font>
						</li>
					</s:iterator>
				</ul>
			</div>
		</div>
		<div class="span24">
			<div id="newProduct" class="newProduct clearfix">
				<div class="title">
					<strong>最新教程</strong> <a target="_blank"></a>
				</div>
				<ul class="tab">
					<li class="current"><a href=""
						target="_blank"></a></li>
					<li><a target="_blank"></a></li>
					<li><a target="_blank"></a></li>
				</ul>
				<!-- 					<div class="newProductAd">
									<img src="${pageContext.request.contextPath}/image/q.jpg" width="260" height="343" alt="最新商品" title="最新商品">
						</div>
						 -->
				<ul class="tabContent" style="display: block;">
					<s:iterator var="product" value="nList">
					<li>	
						<a href="${pageContext.request.contextPath}/product_findByPid.action?pid=<s:property value="#product.pid"/>" target="_blank"><img src="${pageContext.request.contextPath}/<s:property value="#product.image"/>" data-original="http://storage.shopxx.net/demo-image/3.0/201301/4a51167a-89d5-4710-aca2-7c76edc355b8-thumbnail.jpg" style="display: block;"></a>
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<font color="red"><s:property value="#product.downloadnum"/>人学习过</font>
					</li>
					</s:iterator>
				</ul>
			</div>
		</div>
		<div class="span24">
			<div class="friendLink">
				<dl>
					<dt>新手指南</dt>
					<!-- <dd>
						<a target="_blank">支付方式</a> |
					</dd> -->
				<!-- 	<dd>
						<a target="_blank">配送方式</a> |
					</dd> -->
					<!-- <dd>
						<a target="_blank">售后服务</a> |
					</dd> -->
				<!-- 	<dd>
						<a target="_blank">购物帮助</a> |
					</dd> -->
					<dd>
						<a target="_blank">礼品卡</a> |
					</dd>
					<!-- <dd>
						<a target="_blank">银联卡</a> |
					</dd> -->
					<dd class="more">
						<a>更多</a>
					</dd>
				</dl>
			</div>
		</div>
	</div>
	<div class="container footer">
		<%-- <div class="span24">
			<div class="footerAd">
				<img src="${pageContext.request.contextPath}/image/footer.jpg"
					width="950" height="52" alt="我们的优势" title="我们的优势">
			</div>
		</div> --%>
		<div class="span24">
			<ul class="bottomNav">
				<li>
						<a href="https://github.com/chenjibao">关于我们</a>
						|
					</li>
					<li>
						<a href="#" alt="17327364980@163.com">联系我们</a>
						|
					</li>
					<li>
						<a href="#">诚聘英才</a>
						|
					</li>
					<li>
						<a href="#">法律声明</a>
						|
					</li>
					<li>
						<a>友情链接</a>
						|
					</li>
					<!-- <li>
						<a target="_blank">支付方式</a>
						|
					</li> -->
					<!-- <li>
						<a target="_blank">配送方式</a>
						|
					</li> -->
					<li>
						<a href="http://www.cumt.edu.cn/">矿大官网</a>
						|
					</li>
					<li>
						<a href="https://bbs.csdn.net/home">CSDN论坛</a>
						
					</li>
			</ul>
		</div>
		<div class="span24">
			<div class="copyright">Copyright ©  2018  chenjibao 版权所有</div>
		</div>
	</div>
</body>
</html>