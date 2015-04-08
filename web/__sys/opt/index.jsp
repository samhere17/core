<%
	String action = request.getParameter("action");
	if("new".equals(action)) {
		response.sendRedirect("new.jsp");
	}
	else if("list".equals(action)) {
		response.sendRedirect("list.jsp");
	}
%>