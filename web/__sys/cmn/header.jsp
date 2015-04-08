<%@page import="org.iq.valueobject.ums.UmsSession"%>
<%@page import="org.iq.util.StringUtil"%>
<div class="header">
	<div class="left">Operations Management System<%=StringUtil.isEmpty(header)?"":" - "+header%></div>

	<%
	if(request.getSession().getAttribute("umsSession")!=null) {
		UmsSession umsSession = (UmsSession) request.getSession().getAttribute("umsSession");
		if (umsSession != null && umsSession.isSessionValid()) {
	%>
	<div class="right">User: <%=(StringUtil.isEmpty(umsSession.getUserDetails().getUserAlias())==false)?umsSession.getUserDetails().getUserAlias():umsSession.getUserDetails().getUserFirstName()%> 
	<!-- <a href="index.jsp" title="Logs you out of the application [Alt+O]" accesskey="O">Logout</a> -->
		<form method="post" action="${pageContext.request.contextPath}/adapter" style="display: inline;">
			<input type="hidden" name="serviceName" value="Logout" />
			<input type="hidden" name="jSessionId" value="${pageContext.session.id}" />
			<input type="image" src="${pageContext.request.contextPath}/__sys/img/logout-16-16.png" title="Logout" style="float: none; margin-bottom: 4px; width: 16px; height: 16px;"/>
		</form>
	</div>
	<%
		} else {
			response.sendRedirect(request.getContextPath()+"/index.jsp");
		}
	} else {
		response.sendRedirect(request.getContextPath()+"/index.jsp");
	}
	%>
</div>

<style media="screen" type="text/css">
.header {
	background: #8df;
	/*box-shadow: 0px 0px 15px #057 inset;*/
	height: 30px;
}

.header > .left {
	float: left;
	font-size: 14px;
	padding: 8px 0px 0px 7px;
}

.header > .right {
	border-bottom: 1px solid #057;
	border-right: 1px solid #057;
	border-left: 1px solid #057;
	border-bottom-left-radius: 5px;
	border-bottom-right-radius: 5px;
	background-color: #fff;
	padding: 0 5px 0 5px;
	margin-right: 3px;
	float: right;
	font-size: 14px;
}
</style>