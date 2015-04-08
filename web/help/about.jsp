<%@page import="org.iq.util.version.Version"%>

<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<jsp:useBean id="aboutNow" class="java.util.Date" />
<fmt:formatDate var="aboutCurrentYear" value="${aboutNow}"
	pattern="yyyy" />

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<title>OMS::iquesters</title>
<%@include file="/__sys/cmn/scripts.jsp"%>
<%@include file="/__sys/cmn/styles.jsp"%>
<style type="text/css">
div.about-box {
	background: #8df;
	border: 1px solid #057;
	border-radius: 5px;
	padding: 20px 20px 12px 20px;
	width: 490px;
	margin: 10px auto;
}

div.about-box>div.about-logo {
	border: 1px solid #057;
	float: left;
	padding: 5px;
}

div.about-box>div.about-logo>img {
	height: 100px;
	width: 100px;
}

div.about-box>div.about-text {
	float: right;
	width: 350px;
	padding: 0 10px 10px 10px;
	/* height: 110px; */
}

div.about-header {
	font-size: 20px;
	font-weight: bold;
}

div.about-sub-header {
	text-align: right;
	margin: 5px 0;
	font-weight: bold;
}

div.about-content {
	padding: 5px 0;
}

div.about-copyright {
	float: right;
	font-size: 10px;
}

div.about-copyright>a {
	color: #666;
	font-size: 10px;
	text-decoration: none;
}

div.about-copyright>a:hover {
	color: #666;
	font-size: 10px;
	text-decoration: underline;
}
</style>
<script type="text/javascript">
	
</script>
</head>
<body>
	<%
		String header = "About";
	%>
	<div class="wrapper">
		<%@include file="/__sys/cmn/header.jsp"%>
		<%@include file="/__sys/cmn/menu.jsp"%>
		<%-- <%@include file="/__sys/cmn/toolbar.jsp"%> --%>

		<div class="bodycontent">
			<div class="toolboxarea">
				<%@include file="/__sys/cmn/toolbox.jsp"%>
			</div>
			<div class="workarea">

				<div class="form-container">
					<div class="form-header">
						<img
							src="${pageContext.request.contextPath}/__sys/img/about-16-16.png"
							alt="About" title="About" />
						<h3>About</h3>
					</div>
					<div class="form-content">
						<div class="about-box">
							<div class="about-logo">
								<img
									src="${pageContext.request.contextPath}/__sys/img/oms-128-128.png"
									alt="Operation Management System" />
							</div>
							<div class="about-text">
								<div class="about-header">Operation Management System</div>
								<div class="about-sub-header">An application known for
									simplicity and usability</div>
								<div class="about-content">
									Some text should go here... Some text should go here... Some
									text should go here... Some text should go here...<br> <br>
									<br>License Details<br> License information should go
									here...<br> <br>
									<br>Version Details<br>
									&nbsp;&nbsp;&nbsp;&nbsp;Running version:
									<%=Version.versionNumber%><br>
									&nbsp;&nbsp;&nbsp;&nbsp;Development version:
									<%=Version.devVersionNumber%><br>
									&nbsp;&nbsp;&nbsp;&nbsp;Core version:
									<%=Version.coreVersionNumber%><br>
									&nbsp;&nbsp;&nbsp;&nbsp;Core Development version:
									<%=Version.coreDevVersionNumber%>
								</div>
							</div>
							<div class="about-copyright">
								Copyright&nbsp;&copy;&nbsp;2012-${aboutCurrentYear}&nbsp;<a
									href="http://www.iquesters.com"
									title="Click to visit official site of iquester [Alt+I]"
									accesskey="I">iquesters</a>.&nbsp;All rights reserved.
							</div>
							<div class="clear"></div>
						</div>
						<div class="clear"></div>
					</div>
					<div class="form-actions"></div>
				</div>
			</div>
		</div>
		<%@include file="/__sys/cmn/footer.jsp"%>
	</div>
</body>
</html>