<%@page import="org.iq.util.version.Version"%>
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
		String header = "Client Information";
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
								src="${pageContext.request.contextPath}/__sys/img/client-info-16-16.png"
								alt="Client Information" title="Client Information" />
							<h3>Client Information</h3>
						</div>
						<div class="form-content">
							<%UserAgent userAgent = new UserAgent(request.getHeader("user-agent"));%>
							<p>
								Remote Host:
								<%=request.getRemoteHost()%><br>
								Remote Addr:
								<%=request.getRemoteAddr()%><br>
								Remote Port:
								<%=request.getRemotePort()%><br>
								Remote User:
								<%=request.getRemoteUser()%><br>

								Gateway:
								<%=request.getHeader("VIA")%><br>
								Actual IP address:
								<%=request.getHeader("X-FORWARDED-FOR")%>
							</p>
							<p>Client user-agent is<br><%=request.getHeader("user-agent")%></p>
							<p>
								Device Type:
								<%=userAgent.getOperatingSystem().getDeviceType().getName()%><br><br>
								OS Name:
								<%=userAgent.getOperatingSystem().getName()%><br>
								OS Manufacturer:
								<%=userAgent.getOperatingSystem().getManufacturer().getName()%><br><br>
								Browser:
								<%=userAgent.getBrowser().getName()%><br>
								Browser Version:
								<%=userAgent.getBrowserVersion()%><br>
								Browser Manufacturer:
								<%=userAgent.getBrowser().getManufacturer().getName()%><br>
								Browser Type:
								<%=userAgent.getBrowser().getBrowserType().getName()%><br>
								Browser Rendering Engine:
								<%=userAgent.getBrowser().getRenderingEngine()%>
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