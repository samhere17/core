<%@page import="org.iq.ums.vo.UmsOption"%>
<%@page import="java.util.List"%>
<%@page import="org.iq.ums.helper.UmsOptionHelper"%>
<%@page import="org.iq.util.DateUtil.DateFormat"%>
<%@page import="org.iq.util.DateUtil"%>
<%@page import="java.util.Date"%>
<%@page import="org.iq.version.Version"%>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
		<title>OMS::iquesters</title>
		<%@include file="/__sys/cmn/scripts.jsp"%>
		<%@include file="/__sys/cmn/styles.jsp"%>
	</head>
	<body>
	<%
	String header = "Organizations";
	%>
		<div class="wrapper">
			<%@include file="/__sys/cmn/header.jsp"%>
			<%@include file="/__sys/cmn/menu.jsp"%>
	
		<div class="bodycontent">
			<div class="toolboxarea">
				<%@include file="/__sys/cmn/toolbox.jsp"%>
			</div>
			<div class="workarea">
			<%
			String action = request.getParameter("action");
			if("new".equals(action)) {
			%>
				<%@include file="/__sys/org/new.jsp"%>
			<%
			}
			else if("list".equals(action)) {
			%>
				<%@include file="/__sys/org/list.jsp"%>
			<%
			}
			%>
			</div>
		</div>
		<%@include file="/__sys/cmn/footer.jsp"%>
	</div>
</body>
</html>