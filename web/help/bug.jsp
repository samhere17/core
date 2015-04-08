<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<title>OMS::iquesters</title>
<%@include file="/__sys/cmn/styles.jsp"%>
<%@include file="/__sys/cmn/scripts.jsp"%>
</head>
<body>
	<%
		String header = "Report Bug";
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
								src="${pageContext.request.contextPath}/__sys/img/bug-16-16.png"
								alt="Report Bug" title="Report Bug" />
							<h3>Report Bug</h3>
						</div>
						<div class="form-content">
							<div class="fields-row">
								<div class="field-col">
									<label for="name">Title</label> <input type="text" name="title"
										style="width: 684px !important;" />
								</div>
							</div>
							<div class="fields-row">
								<div class="field-col">
									<label for="name">Details</label>
									<textarea name="message"
										style="height: 400px; width: 684px !important;"></textarea>
								</div>
							</div>
							<div class="clear"></div>
						</div>
						<div class="form-actions">
							<input type="submit" id="" value="Report" />
						</div>
					</form>
				</div>
			</div>
		</div>
		<%@include file="/__sys/cmn/footer.jsp"%>
	</div>
</body>
</html>