<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml"><head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
<title>瑞尚程序员</title>
<link href="${pageContext.request.contextPath}/css/common.css" rel="stylesheet" type="text/css">
<link href="${pageContext.request.contextPath}/css/product.css" rel="stylesheet" type="text/css">
<script>
function saveCart(){
	 document.getElementById("cartForm").submit();
	
}
</script>

</head>
<body>

<div class="container header">
	<%-- <div class="span5">
		<div class="logo">
			<a>
				<img src="${pageContext.request.contextPath}/image/r___________renleipic_01/logo.gif" alt="筛宝商城">
			</a>
		</div>
	</div>
	<div class="span9">
<div class="headerAd">
					<img src="image\r___________renleipic_01/header.jpg" alt="正品保障" title="正品保障" height="50" width="320">
</div>	</div> --%>

<%@ include file="menu.jsp" %>

</div><div class="container productContent">
		<div class="span6">
			<div class="hotProductCategory">
			<s:iterator var="c" value="#session.cList">
						<dl>
							<dt>
								<a href="${pageContext.request.contextPath}/product_findByCid.action?cid=<s:property value="#c.cid"/>&page=1"><s:property value="#c.cname"/></a>
							</dt>
									<s:iterator var="cs" value="#c.categorySeconds">
									<dd>
										<a href="${pageContext.request.contextPath}/product_findByCsid.action?csid=<s:property value="#cs.csid" />&page=1"><s:property value="#cs.csname"/></a>
									</dd>
									</s:iterator>
						</dl>
				</s:iterator>
			</div>
			

		</div>
		<div class="span18 last">
			
			<div class="productImage">
					<a title="" style="outline-style: none; text-decoration: none;" id="zoom" href="http://image/r___________renleipic_01/bigPic1ea8f1c9-8b8e-4262-8ca9-690912434692.jpg" rel="gallery">
						<div class="zoomPad"><img style="opacity: 1;" title="" class="medium" src="${ pageContext.request.contextPath }/<s:property value="model.image"/>"><div style="display: block; top: 0px; left: 162px; width: 0px; height: 0px; position: absolute; border-width: 1px;" class="zoomPup"></div><div style="position: absolute; z-index: 5001; left: 312px; top: 0px; display: block;" class="zoomWindow"><div style="width: 368px;" class="zoomWrapper"><div style="width: 100%; position: absolute; display: none;" class="zoomWrapperTitle"></div><div style="width: 0%; height: 0px;" class="zoomWrapperImage"><img src="%E5%B0%9A%E9%83%BD%E6%AF%94%E6%8B%89%E5%A5%B3%E8%A3%852013%E5%A4%8F%E8%A3%85%E6%96%B0%E6%AC%BE%E8%95%BE%E4%B8%9D%E8%BF%9E%E8%A1%A3%E8%A3%99%20%E9%9F%A9%E7%89%88%E4%BF%AE%E8%BA%AB%E9%9B%AA%E7%BA%BA%E6%89%93%E5%BA%95%E8%A3%99%E5%AD%90%20%E6%98%A5%E6%AC%BE%20-%20Powered%20By%20Mango%20Team_files/6d53c211-2325-41ed-8696-d8fbceb1c199-large.jpg" style="position: absolute; border: 0px none; display: block; left: -432px; top: 0px;"></div></div></div><div style="visibility: hidden; top: 129.5px; left: 106px; position: absolute;" class="zoomPreload">Loading zoom</div></div>
					</a>
				
			</div>
			<%-- <div class="name"><s:property value="model.pname"/></div> --%>
			<%-- <div class="sn">
				<div>编号：<s:property value="model.pid"/></div>
			</div>
			<div class="info">
				<dl>
					<dt>商城价:</dt>
					<dd>
						<strong>￥：<s:property value="model.shop_price"/>元</strong>
							参 考 价：
							<del>￥<s:property value="model.market_price"/>元</del>
					</dd>
				</dl>
					<dl>
						<dt>促销:</dt>
						<dd>
								<a target="_blank" title="限时抢购 (2018-4-10 ~ 2019-01-01)">限时抢购</a>
						</dd>
					</dl>
					<dl>
						<dt>    </dt>
						<dd>
							<span>    </span>
						</dd>
					</dl>
			</div> --%>
			<form id="cartForm" action="<s:property value="model.url"/>" method="post" target="_blank">
				<input type="hidden" name="pid" value="<s:property value="model.pid"/>"/>
				<div class="action">
					<div>&nbsp;</div>
					<div>&nbsp;</div>
					<div>&nbsp;</div>
					<div>&nbsp;</div>
					<div align="center" class="name"><s:property value="model.pname"/>:&nbsp;&nbsp;&nbsp;<a href="${pageContext.request.contextPath}/product_updateDownloadNum.action?downloadnum=<s:property value="model.downloadnum"/>&pid=<s:property value="model.pid"/>&url=<s:property value="model.url"/>"/><font color="blue">百度云盘下载</font></a></div>
					<%-- <div align="center" class="name"><s:property value="model.pname"/>:&nbsp;&nbsp;&nbsp;<a href=<s:property value="model.url"/> target="_blank"><font color="blue">百度云盘下载</font></a></div> --%>
					<div>&nbsp;</div>
					<div>&nbsp;</div>
					<div>&nbsp;</div>
					<div>&nbsp;</div>
				</div>
			</form>
			<div  id="bar" class="bar">
				<ul>
						<li  id="introductionTab">
							<a href="#introduction">教程详情</a>
						</li>
						
				</ul>
			</div>
				<!-- <div align="center" id="introduction" name="introduction" class="introduction"> -->
				<div align="center" id="introduction" name="introduction" class="introduction">
					<%-- <div class="title">
						<strong><font color="blue"><pre><s:property value="model.pdesc"/></pre></font></strong>
					</div> --%>
					<%-- <p><s:property value="model.pdesc"/></p> --%>
					
					<textarea style="overflow:auto" disabled="disabled" class="boxes" name="pdesc" rows="94" cols="102"><s:property value="model.pdesc"/></textarea>
					
					<%-- <strong><s:property value="model.pdesc"/></strong>
					<p><s:property value="model.pdesc"/></p>
					<pre> <font color="grey" size="5"> <s:property value="model.pdesc"/></font></pre> --%>
					<%-- <div align="center">
						<img src="${pageContext.request.contextPath }/<s:property value="model.image"/>">
					</div> --%>
				</div>
				
				
				
		</div>
	</div>
<div class="container footer">
	<div class="span24">
		<div class="footerAd">
					<img src="image\r___________renleipic_01/footer.jpg" alt="我们的优势" title="我们的优势" height="52" width="950">
</div>
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