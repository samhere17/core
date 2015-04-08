<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<title>OMS::iquesters</title>
<%@include file="/__sys/cmn/styles.jsp"%>
<%@include file="/__sys/cmn/scripts.jsp"%>
</head>
<body>
	<%
		String header = "Contact Support";
	%>
	<div class="wrapper">
		<%@include file="/__sys/cmn/header.jsp"%>
		<%@include file="/__sys/cmn/menu.jsp"%>

		<div class="bodycontent">
			<div class="toolboxarea">
				<%@include file="/__sys/cmn/toolbox.jsp"%>
			</div>
			<div class="workarea">
				<div class="form-container">
					<form method="post"
						action="${pageContext.request.contextPath}/adapter">
						<input type="hidden" name="serviceName" value="" />
						<div class="form-header">
							<img
								src="${pageContext.request.contextPath}/__sys/img/support-16-16.png"
								alt="Contact Support" title="Contact Support" />
							<h3>Contact Support</h3>
						</div>
						<div class="form-content">
							<div class="fields-row">
								<div class="field-col">
									<label for="name">From</label> <input type="text" name="from"
										class="input-width-double" readonly
										value="${umsSession.username}" />
								</div>
								<div class="field-col">
								<label for="name">&nbsp;</label>
								</div>
								<div class="field-col">
								<label for="name">&nbsp;</label>
									<input type="checkbox" name="roleName" style="float: left;" /><label
										for="name">Copy Admin</label>
								</div>
							</div>
							<div class="fields-row">
								<div class="field-col">
									<label for="name">Detailed Message</label>
									<textarea name="message"
										style="height: 400px; width: 684px !important;"></textarea>
								</div>
							</div>
							<div class="clear"></div>
						</div>
						<div class="form-actions">
							<input type="submit" id="" value="Send" />
						</div>
					</form>
				</div>
			</div>
		</div>
		<%@include file="/__sys/cmn/footer.jsp"%>
	</div>
</body>
</html>