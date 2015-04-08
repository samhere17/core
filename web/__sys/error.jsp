<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<title>OMS::iquesters</title>
<%@include file="/__sys/cmn/styles.jsp"%>
<%@include file="/__sys/cmn/scripts.jsp"%>
<style type="text/css">
.-iq-error-message {
	background: #fcc;
	border: 1px solid #f00;
	border-radius: 2px;
	padding: 10px;
}

.-iq-stack-trace {
	border: 1px solid #f00;
	border-radius: 2px;
	margin-top: 5px;
	padding: 10px;
	font-family: monospace;
	color: #f00;
	padding: 10px;
}
</style>
<script type="text/javascript">
	
</script>
</head>
<body>
	<%
		String header = "Error";
	%>
	<div class="wrapper">
		<%@include file="/__sys/cmn/header.jsp"%>
		<%@include file="/__sys/cmn/menu.jsp"%>

		<div class="bodycontent">
			<div class="workarea">
				<div class="form-container">
					<form method="post" action="">
						<div class="form-header">
							<img
								src="${pageContext.request.contextPath}/__sys/img/error-16-16.png"
								alt="Error" title="Error" />
							<h3>Error</h3>
						</div>
						<div class="form-content">
							<div class="-iq-error-message">${sessionScope["errorMessage"]}</div>
							<div class="-iq-stack-trace">${sessionScope["stackTrace"]}
							</div>
						</div>
						<div class="form-actions">
							<input type="submit" id="" value="Send Error Report" disabled />
						</div>
					</form>
				</div>
			</div>
		</div>
		<%@include file="/__sys/cmn/footer.jsp"%>
	</div>
</body>
</html>