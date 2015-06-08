<%@page import="org.iq.ums.helper.UmsHelper"%>
<%
	UmsHelper umsHelper = new UmsHelper();
	if (umsHelper.isAdminUserConfigured()) {
		response.sendRedirect(request.getContextPath()
				+ "/ums/login.jsp");
	} else {
		response.sendRedirect(request.getContextPath()
				+ "/ums/register.jsp");
	}
%>