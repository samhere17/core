<%@page import="org.iq.version.Version"%>
<%@page import="org.iq.ui.useragents.UserAgent"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<title>OMS::iquesters</title>
<%@include file="/__sys/cmn/styles.jsp"%>
<%@include file="/__sys/cmn/scripts.jsp"%>
</head>
<body>
	<%
		String header = "Server Information";
	%>
	<div class="wrapper">
		<%@include file="/__sys/cmn/header.jsp"%>
		<%@include file="/__sys/cmn/menu.jsp"%>

		<div class="bodycontent">
			<div class="toolboxarea">
				<%@include file="/__sys/cmn/toolbox.jsp"%>
			</div>
			<div class="workarea">
				<div class="form-container">
					<form method="post"
						action="${pageContext.request.contextPath}/adapter">
						<input type="hidden" name="serviceName" value="" />
						<div class="form-header">
							<img
								src="${pageContext.request.contextPath}/__sys/img/server-info-16-16.png"
								alt="Server Information" title="Server Information" />
							<h3>Server Information</h3>
						</div>
						<div class="form-content">
							<p><b>Core Application server is up and running</b></p>
							<p><b>Running version: <%=Version.versionNumber%></b></p>
							<p>
								Deploy Location:
								<%=getServletContext().getRealPath("/")%><br>
								Server Details:
								<%=getServletContext().getServerInfo()%><br><br>

								Server Name:
								<%=request.getServerName()%><br>
								Server Port:
								<%=request.getServerPort()%><br>
								Local Name:
								<%=request.getLocalName()%><br>
								Local Addr:
								<%=request.getLocalAddr()%><br>
								Local Port:
								<%=request.getLocalPort()%><br>
							</p>
							<div class="clear"></div>
						</div>
						<div class="form-actions"></div>
					</form>
				</div>
			</div>
		</div>
		<%@include file="/__sys/cmn/footer.jsp"%>
	</div>
</body>
</html>