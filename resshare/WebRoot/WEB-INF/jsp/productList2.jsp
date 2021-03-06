<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<!-- saved from url=(0048)http://localhost:8080/mango/product/list/1.jhtml -->
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="My Play Responsive web template, Bootstrap Web Templates, Flat Web Templates, Andriod Compatible web template, 
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyErricsson, Motorola web design" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<!-- bootstrap -->
<link href="css/bootstrap.min.css" rel='stylesheet' type='text/css' media="all" />
<!-- //bootstrap -->
<link href="css/dashboard.css" rel="stylesheet">
<!-- Custom Theme files -->
<link href="css/style.css" rel='stylesheet' type='text/css' media="all" />
<script src="js/jquery-1.11.1.min.js"></script>
<!--start-smoth-scrolling-->
<!-- fonts -->
<!-- <link href='http://fonts.useso.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800' rel='stylesheet' type='text/css'>
<link href='http://fonts.useso.com/css?family=Poiret+One' rel='stylesheet' type='text/css'> -->
<!-- //fonts -->
<title>瑞尚程序员</title>
<link href="${pageContext.request.contextPath}/css/common.css"
	rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath}/css/product.css"
	rel="stylesheet" type="text/css" />

</head>
<body>
	<div class="container header">
		<%-- <div class="span5">
			<div class="logo">
				<a href="http://localhost:8080/mango/"> <img
					src="${pageContext.request.contextPath}/image/r___________renleipic_01/logo.gif"
					alt="筛宝商城">
				</a>
			</div>
		</div>
		<div class="span9">
			<div class="headerAd">
				<img src="${pageContext.request.contextPath}/image/header.jpg"
					width="320" height="50" alt="正品保障" title="正品保障">
			</div>
		</div> --%>

		<%@ include file="menu.jsp"%>

	</div>
	<div class="container productList">
	
		<div class="span6">
			<div class="hotProductCategory">
				<s:iterator var="c" value="#session.cList">
					<dl>
						<dt>
							<a
								href="${pageContext.request.contextPath}/product_findByCid.action?cid=<s:property value="#c.cid"/>&page=1"><s:property
									value="#c.cname" /></a>
						</dt>
						<s:iterator var="cs" value="#c.categorySeconds">
							<dd>
								<a href="${pageContext.request.contextPath}/product_findByCsid.action?csid=<s:property value="#cs.csid" />&page=1"><s:property value="#cs.csname" /></a>
							</dd>
						</s:iterator>
					</dl>
				</s:iterator>
			</div>
		</div>
		
		
		
		
		<div class="span18 last">

			<form id="productForm"
				action=""
				method="get">

				<div id="result" class="result table clearfix">
					<ul>
					<s:iterator var="p" value="pageBean.List">
						<li><a href="${pageContext.request.contextPath}/product_findByPid.action?pid=<s:property value="#p.pid"/>"> <img
								src="${pageContext.request.contextPath}/<s:property value="#p.image"/>"
								width="170" height="170" style="display: inline-block;"> <span
								style='color:green'><font size="3" color="blue"><s:property value="#p.pname"/></font></span> <span class="price">
								&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<s:property value="#p.downloadnum"/>人学习过</span>
						</a></li>
					</s:iterator>
					</ul>
				</div>
				<div class="pagination">
					<span>第 <s:property value="pageBean.page"/>/<s:property value="pageBean.totalPage"/> 页</span>
					
		<s:if test="cid != null">
			<s:if test="pageBean.page != 1">
				<a href="${ pageContext.request.contextPath }/product_findByCid.action?cid=<s:property value="cid"/>&page=1" class="firstPage">&nbsp;</a>
				<a href="${ pageContext.request.contextPath }/product_findByCid.action?cid=<s:property value="cid"/>&page=<s:property value="pageBean.page-1"/>" class="previousPage">&nbsp;</a>
			</s:if>
			
			<s:iterator var="i" begin="1" end="pageBean.totalPage">
				<s:if test="pageBean.page != #i">
					<a href="${ pageContext.request.contextPath }/product_findByCid.action?cid=<s:property value="cid"/>&page=<s:property value="#i"/>"><s:property value="#i"/></a>
				</s:if>
				<s:else>
					<span class="currentPage"><s:property value="#i"/></span>
				</s:else>
			</s:iterator>
			
			<s:if test="pageBean.page != pageBean.totalPage">	
				<a class="nextPage" href="${ pageContext.request.contextPath }/product_findByCid.action?cid=<s:property value="cid"/>&page=<s:property value="pageBean.page+1"/>">&nbsp;</a>
				<a class="lastPage" href="${ pageContext.request.contextPath }/product_findByCid.action?cid=<s:property value="cid"/>&page=<s:property value="pageBean.totalPage"/>">&nbsp;</a>
			</s:if>
		</s:if>	
		
		
		
	 <s:if test="csid != null"> 
			<s:if test="pageBean.page != 1">
				<a href="${ pageContext.request.contextPath }/product_findByCsid.action?csid=<s:property value="csid"/>&page=1" class="firstPage">&nbsp;</a>
				<a href="${ pageContext.request.contextPath }/product_findByCsid.action?csid=<s:property value="csid"/>&page=<s:property value="pageBean.page-1"/>" class="previousPage">&nbsp;</a>
			</s:if>
			
			<s:iterator var="i" begin="1" end="pageBean.totalPage">
				<s:if test="pageBean.page != #i">
					<a href="${ pageContext.request.contextPath }/product_findByCsid.action?csid=<s:property value="csid"/>&page=<s:property value="#i"/>"><s:property value="#i"/></a>
				</s:if>
				<s:else>
					<span class="currentPage"><s:property value="#i"/></span>
				</s:else>
			</s:iterator>
			
			<s:if test="pageBean.page != pageBean.totalPage">	
				<a class="nextPage" href="${ pageContext.request.contextPath }/product_findByCsid.action?csid=<s:property value="csid"/>&page=<s:property value="pageBean.page+1"/>">&nbsp;</a>
				<a class="lastPage" href="${ pageContext.request.contextPath }/product_findByCsid.action?csid=<s:property value="csid"/>&page=<s:property value="pageBean.totalPage"/>">&nbsp;</a>
			</s:if>
		 </s:if>	
		
		<s:if test="searchkey!=null">
			<s:if test="pageBean.page != 1">
				<a href="${ pageContext.request.contextPath }/product_findByProductPartName.action?searchkey=<s:property value="searchkey"/>&page=1" class="firstPage">&nbsp;</a>
				<a href="${ pageContext.request.contextPath }/product_findByProductPartName.action?searchkey=<s:property value="searchkey"/>&page=<s:property value="pageBean.page-1"/>" class="previousPage">&nbsp;</a>
			</s:if>
			
			<s:iterator var="i" begin="1" end="pageBean.totalPage">
				<s:if test="pageBean.page != #i">
					<a href="${ pageContext.request.contextPath }/product_findByProductPartName.action?searchkey=<s:property value="searchkey"/>&page=<s:property value="#i"/>"><s:property value="#i"/></a>
				</s:if>
				<s:else>
					<span class="currentPage"><s:property value="#i"/></span>
				</s:else>
			</s:iterator>
			
			<s:if test="pageBean.page != pageBean.totalPage">	
				<a class="nextPage" href="${ pageContext.request.contextPath }/product_findByProductPartName.action?searchkey=<s:property value="searchkey"/>&page=<s:property value="pageBean.page+1"/>">&nbsp;</a>
				<a class="lastPage" href="${ pageContext.request.contextPath }/product_findByProductPartName.action?searchkey=<s:property value="searchkey"/>&page=<s:property value="pageBean.totalPage"/>">&nbsp;</a>
			</s:if>
		</s:if>
		
				</div>
			</form>
		</div>
	</div>
	
	
	<div class="container footer">
	<!--  -->
	
		<!--  -->
		<div class="span24">
			<%-- <div class="footerAd">
				<img src="${pageContext.request.contextPath}/image/footer.jpg"
					width="950" height="52" alt="我们的优势" title="我们的优势">
			</div> --%>
		</div>
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
					</li>
					<li>
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