<%@page import="org.iq.version.Version"%>
<%@page import="org.iq.ui.useragents.UserAgent"%>

<%@include file="../../cmn/head.jsp"%>
	<div class="panel panel-danger">
		<div class="panel-heading">
			<h1 class="panel-title">Client Information</h1>
		</div>

		<div class="panel-body">
			<div class="row">
				<div class="col-md-4">
					<ul class="list-group">
						<h2>Client Information</h2>

						<%UserAgent userAgent = new UserAgent(request.getHeader("user-agent")); %>
						<li class="list-group-item">
							<strong>Remote Host:</strong>
							<%=request.getRemoteHost()%>
						</li>
						<li class="list-group-item">
							<strong>Remote Addr:</strong>
							<%=request.getRemoteAddr()%>
						</li>
						<li class="list-group-item">
							<strong>Remote Port:</strong>
							<%=request.getRemotePort()%>
						</li>
						<li class="list-group-item">
							<strong>Remote User:</strong>
							<%=request.getRemoteUser()%>
						</li>

						<li class="list-group-item">
							<strong>Gateway:</strong>
							<%=request.getHeader("VIA")%>
						</li>
						<li class="list-group-item">
							<strong>Actual IP address:</strong>
							<%=request.getHeader("X-FORWARDED-FOR")%>
						</li>
					</ul>
				</div>

				<div class="col-md-8">
					<ul class="list-group">
						<h2>User Agent Information</h2>

						<li class="list-group-item">
							<strong>User Agent:</strong> <%=request.getHeader("user-agent")%>
						</li>
						<li class="list-group-item">
							<strong>Device Type:</strong> <%=userAgent.getOperatingSystem().getDeviceType().getName()%>
						</li>
						<li class="list-group-item">
							<strong>OS Name:</strong> <%=userAgent.getOperatingSystem().getName()%>
						</li>
						<li class="list-group-item">
							<strong>OS Manufacturer:</strong> <%=userAgent.getOperatingSystem().getManufacturer().getName()%>
						</li>
						<li class="list-group-item">
							<strong>Browser:</strong> <%=userAgent.getBrowser().getName()%>
						</li>
						<li class="list-group-item">
							<strong>Browser Version:</strong> <%=userAgent.getBrowserVersion()%>
						</li>
						<li class="list-group-item">
							<strong>Browser Manufacturer:</strong> <%=userAgent.getBrowser().getManufacturer().getName()%>
						</li>
						<li class="list-group-item">
							<strong>Browser Type:</strong> <%=userAgent.getBrowser().getBrowserType().getName()%>
						</li>
						<li class="list-group-item">
							<strong>Browser Rendering Engine:</strong> <%=userAgent.getBrowser().getRenderingEngine()%>
						</li>
					</ul>
				</div>
			</div>
		</div>
	</div>
<%@include file="../../cmn/tail.jsp"%>
