<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:set var="browserURL" value="${pageContext.request.requestURI}" scope="session"></c:set>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<title>OMS::iquesters</title>
<%@include file="/__sys/cmn/scripts.jsp"%>
<%@include file="/__sys/cmn/styles.jsp"%>
<style type="text/css">
</style>
<script type="text/javascript">
		
		</script>
</head>
<body>
	<%
	String header = "Admin Dashboard";
	%>
	<div class="wrapper">
		<%@include file="/__sys/cmn/header.jsp"%>
		<%@include file="/__sys/cmn/menu.jsp"%>
		<%-- <%@include file="/__sys/cmn/toolbar.jsp"%> --%>

		<div class="bodycontent">
			<div class="toolboxarea">
				<%@include file="/__sys/cmn/toolbox.jsp"%>
			</div>
			<div class="workarea"><div style="font-size: 20px; font-weight: bold; text-align: center; margin-top: 100px;">Welcome to Operations Management System</div></div>
		</div>
		<%@include file="/__sys/cmn/footer.jsp"%>
	</div>
</body>
</html>