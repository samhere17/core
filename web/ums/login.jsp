<%@page import="org.iq.valueobject.ums.UmsSession"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:set var="browserURL" value="${pageContext.request.requestURI}" scope="session"></c:set>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
		<title>OMS::iquesters</title>
		<%@include file="/__sys/cmn/styles.jsp"%>
		<%@include file="/__sys/cmn/scripts.jsp"%>
	</head>
	<body> <!-- style="background: none;" -->
	<%
	UmsSession umsSession = (UmsSession)session.getAttribute("umsSession");
	boolean showErrMsh = false;
	if(umsSession!=null && umsSession.isSessionValid()==false){
		showErrMsh = true;
	}
	%>

		<div class="form-container" style="width: 356px; margin: 10px auto;">
			<form method="post" action="${pageContext.request.contextPath}/adapter">
				<input type="hidden" name="serviceName" value="Authentication" />
				<input type="hidden" name="jSessionId" value="${pageContext.session.id}" />
				<input type="hidden" name="accessIP" value="<%=request.getRemoteAddr()%>" />
				<input type="hidden" name="accessPort" value="<%=request.getRemotePort()%>" />
				<input type="hidden" name="accessGateway" value="<%=request.getHeader("VIA")%>" />
				<input type="hidden" name="actualAccessIP" value="<%=request.getHeader("X-FORWARDED-FOR")%>" />
				<input type="hidden" name="userAgent" value="<%=request.getHeader("user-agent")%>" />
				<div class="form-header">
					<img src="${pageContext.request.contextPath}/__sys/img/login-16-16.png" alt="Login" title="Login"/>
					<h3>Login</h3>
				</div>
				<div class="form-content">
				<%if(showErrMsh){%>
				<div class="-iq-error">Credentials were incorrect</div>
				<%}%>
					<div class="fields-row">
						<div class="field-col">
							<label for="username">Username</label>
							<input type="text" id="username" name="username" value="" placeholder="Username" required />
						</div>
						<div class="field-col">
							<label for="password">Password</label>
							<input type="password" id="password" name="password" value="" placeholder="Password" required />
						</div>
					</div>
					<div class="clear"></div>
				</div>
				<div class="form-actions">
					<input type="submit" value="Login" />
				</div>
			</form>
		</div>
	</body>
</html>