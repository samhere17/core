<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<title>OMS::iquesters</title>
<%@include file="/__sys/cmn/styles.jsp"%>
<%@include file="/__sys/cmn/scripts.jsp"%>
</head>
<body>
	<%
		String header = "Option Details";
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
					<form>
						<div class="form-header">
							<img src="${pageContext.request.contextPath}/img/opt-edit-16-16.png" alt="Edit Option" title="Edit Option" />
							<h3>Option Details</h3>
						</div>
						<div class="form-content">
						<div class="-iq-warning"><b>If new option is added, remember to add role mapping, else it will always be disabled.</b></div>
						<div class="-iq-warning"><b>If option is edited, remember to check option list to confirm order.</b></div>
							<div class="fields-row">
								<div class="multi-row-col">
									<div class="field-col">
										<label>Option Type</label>
										<input type="text" value="${option.optionType}" readonly />
									</div>
									<div class="field-col">
										<label>Option Status</label>
										<input type="text" value="${option.optionStatus}" readonly />
									</div>
								</div>
								<div class="multi-row-col">
									<div class="field-col">
										<label>Option Name</label>
										<input type="text" value="${option.optionName}" readonly />
									</div>
									<div class="field-col">
										<label>Toolbox Item</label>
										<input type="text" value="${option.enableToolbox}" readonly />
									</div>
								</div>
								<div class="field-col">
									<label>Option Description</label>
									<textarea readonly>${option.optionDescription}</textarea>
								</div>
								<div class="field-col">
									<label>Option Order</label> <input type="text"
										value="${option.optionOrder}" readonly
										style="text-align: right;" />
								</div>
							</div>
							<div class="fields-row">
								<div class="field-col">
									<label>Option Link</label> <input type="text"
										value="${pageContext.request.contextPath}/" readonly />
								</div>
								<div class="field-col">
									<label>&nbsp;</label>
									<input type="text" value="${option.optionLink}" readonly class="input-width-double" />
								</div>
							</div>
							<div class="fields-row">
								<div class="field-col">
									<label>Option Image Link</label>
									<input type="text" value="${pageContext.request.contextPath}/" readonly />
								</div>
								<div class="field-col">
									<label>&nbsp;</label>
									<input type="text" value="${option.optionImageLink}" readonly class="input-width-double" />
								</div>
								<div class="field-col">
									<label>Option Image Alt</label>
									<input type="text" value="${option.optionImageAlt}" readonly />
								</div>
							</div>
							<div class="fields-row">
								<div class="field-col">
									<label>Object Reference</label>
									<input type="text" value="${option.objectReferenceKey}" readonly />
								</div>
							</div>
							<div class="fields-row">
								<div class="field-col">
									<label>Parent Option Id</label>
									<input type="text" value="${option.parentOptionId}" readonly style="text-align: right;" />
								</div>
							</div>
							<div class="clear"></div>
						</div>
						<div class="form-actions"></div>
					</form>
				</div>
			</div>
		</div>
		<%@include file="/__sys/cmn/footer.jsp"%>
	</div>
</body>
</html>