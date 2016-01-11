<%@page import="org.iq.version.Version"%>
<%@page import="org.iq.ui.useragents.UserAgent"%>

<%@include file="../../cmn/head.jsp"%>

	<div class="panel panel-danger">
		<div class="panel-heading">
			<h1 class="panel-title">Server Information</h1>
		</div>

		<div class="panel-body">
			<h2>
				<strong>
					Core Application server is up and running
				</strong>
				<br>
				<strong>
					Running version: <%=Version.versionNumber%>
				</strong>
			</h2>

			<div class="row">
				<div class="col-md-6">
					<ul class="list-group">
						<li class="list-group-item">
							<strong>Deploy Location:</strong>
							<%=getServletContext().getRealPath("/")%>
						</li>
						<li class="list-group-item">
							<strong>
								Server Details:
							</strong> <%=getServletContext().getServerInfo()%>
						</li>
						<li class="list-group-item">
							<strong>
								Server Name:
							</strong> <%=request.getServerName()%>
						</li>
						<li class="list-group-item">
							<strong>
								Server Port:
							</strong> <%=request.getServerPort()%>
						</li>
						<li class="list-group-item">
							<strong>
								Local Name:
							</strong> <%=request.getLocalName()%>
						</li>
						<li class="list-group-item">
							<strong>
								Local Addr:
							</strong> <%=request.getLocalAddr()%>
						</li>
						<li class="list-group-item">
							<strong>
								Local Port:
							</strong> <%=request.getLocalPort()%>
						</li>
					</ul>
				</div>
			</div>
		</div>
	</div>
<%@include file="../../cmn/tail.jsp"%>
