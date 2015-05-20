<%@page import="org.iq.form.FormBuilder"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<title>FORM GEN TEST</title>
<%@include file="/__sys/cmn/styles.jsp"%>
<%@include file="/__sys/cmn/scripts.jsp"%>
</head>
<body>
	<%
	String header = "FORM GEN TEST";
	%>
	<div class="wrapper">
		<%@include file="/__sys/cmn/header.jsp"%>
		<%@include file="/__sys/cmn/menu.jsp"%>
		<div class="bodycontent">
			<div class="toolboxarea">
				<%@include file="/__sys/cmn/toolbox.jsp"%>
			</div>
			<div class="workarea">
			
			<%=new FormBuilder().getFormHtml(0)%>
			
			</div>
		</div>
		<%@include file="/__sys/cmn/footer.jsp"%>
	</div>
</body>
</html>