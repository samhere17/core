<%@page import="org.iq.helper.ums.UmsHelper"%>
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