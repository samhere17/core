<%@page import="org.iq.ums.UmsConstants.OptionStatus"%>
<%@page import="org.iq.ums.UmsConstants.OptionType"%>
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
		String header = "Edit Options";
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
						<input type="hidden" name="serviceName" value="UpdateOption" />
						<div class="form-header">
							<img
								src="${pageContext.request.contextPath}/img/opt-edit-16-16.png"
								alt="Edit Option" title="Edit Option" />
							<h3>Edit Option</h3>
							<a href=""><img
								src="${pageContext.request.contextPath}/img/help.png" alt="Help"
								title="Help" /></a>
						</div>
						<div class="form-content">
								<div class="fields-row">
									<div class="field-col">
										<label>Option Id</label>
										<input type="text" name="optId" value="${option.optionId}" readonly />
									</div>
								</div>
								<div class="fields-row">
									<div class="multi-row-col">
										<div class="field-col">
											<label>Option Type</label> <select name="optType" required>
												<option value="0" <c:if test="${option.optionType eq 'MENU'}">selected</c:if>>Menu</option>
												<option value="1" <c:if test="${option.optionType eq 'MENU_ITEM'}">selected</c:if>>Menu Item</option>
												<option value="2" <c:if test="${option.optionType eq 'SEPERATOR'}">selected</c:if>>Separator</option>
											</select>
										</div>
										<div class="field-col">
											<label>Option Status</label> <select name="optStatus">
												<option value="0" <c:if test="${option.optionStatus eq 'INACTIVE'}">selected</c:if>>Inactive</option>
												<option value="1" <c:if test="${option.optionStatus eq 'ACTIVE'}">selected</c:if>>Active</option>
												<option value="2" <c:if test="${option.optionStatus eq 'DELETED'}">selected</c:if>>Deleted</option>
											</select>
										</div>
									</div>
									<div class="multi-row-col">
										<div class="field-col">
											<label>Option Name</label> <input type="text" name="optName" value="${option.optionName}"/>
										</div>
										<div class="field-col">
											<label>Toolbox Item</label> <select name="optEnableToolbox">
												<option value="false" <c:if test="${not option.enableToolbox}">selected</c:if>>Disabled</option>
												<option value="true" <c:if test="${option.enableToolbox}">selected</c:if>>Enabled</option>
											</select>
										</div>
									</div>
									<div class="field-col">
										<label>Option Description</label>
										<textarea name="optDesc">${option.optionDescription}</textarea>
									</div>
									<div class="field-col">
										<label>Option Order</label>
										<input type="text" name="optOrder" value="${option.optionOrder}" style="text-align: right;" />
									</div>
								</div>
								<div class="fields-row">
									<div class="field-col">
										<label>Option Link</label>
										<input type="text" value="${pageContext.request.contextPath}/" readonly />
									</div>
									<div class="field-col">
										<label>&nbsp;</label>
										<input type="text" name="optLink" value="${option.optionLink}" class="input-width-double" />
									</div>
								</div>
								<div class="fields-row">
									<div class="field-col">
										<label>Option Image Link</label>
										<input type="text" value="${pageContext.request.contextPath}/" readonly />
									</div>
									<div class="field-col">
										<label>&nbsp;</label>
										<input type="text" name="optImgLink" value="${option.optionImageLink}" class="input-width-double" />
									</div>
									<div class="field-col">
										<label>Option Image Alt</label>
										<input type="text" name="optImgAlt" value="${option.optionImageAlt}" />
									</div>
								</div>
								<div class="fields-row">
									<div class="field-col">
										<label>Object Reference</label> <input type="text"
											name="objRef" value="${option.objectReferenceKey}" />
									</div>
								</div>
								<div class="fields-row">
									<div class="field-col">
										<label>Parent Option Id</label> <input type="text"
											id="parent-opt-id" name="optParentId" value="${option.parentOptionId}" readonly
											style="text-align: right;" />
									</div>
									<!-- <div class="field-col">
										<label>Parent Option Name</label> <input type="text"
											id="parent-opt-name" readonly />
									</div> -->
									<div class="field-col">
										<label>&nbsp;</label> <input type="button" id="btnLookup"
											value="Lookup" />
									</div>
								</div>
							<div class="clear"></div>
						</div>
						<div class="form-actions">
							<input type="submit" value="Save" />
						</div>
					</form>
				</div>


			</div>
		</div>
		<%@include file="/__sys/cmn/footer.jsp"%>
	</div>

	<script type="text/javascript">
		$(document)
				.ready(
						function() {
							$('#btnLookup').click(function() {
								showDialog("parent-options", false);
							});

							$("#close-dialog").click(function(e) {
								hideDialog("parent-options");
								e.preventDefault();
							});

							$("#select-parent")
									.click(
											function() {
												var parentOption = $(
														'input[name=parentOptionRadio]:checked')
														.val();
												var arr = parentOption
														.split(':');
												$("#parent-opt-id").val(arr[0]);
												$("#parent-opt-name").val(
														arr[1]);
												hideDialog("parent-options");
											});
						});
	</script>

	<div id="overlay" class="dialog-overlay"></div>
	<div id="parent-options" class="dialog-window">
		<div class="dialog-header">
			<%-- <img src="<%=rootLink%>/img/user-add-26.png" alt="New User" title="New User"/> --%>
			<h3>Parent Options</h3>
			<a href="#" id="close-dialog"><img
				src="${pageContext.request.contextPath}/__sys/img/delete-16-16.png"
				alt="Close" title="Close" /></a>
		</div>
		<div class="dialog-content"></div>
		<div class="dialog-actions">
			<input type="button" id="select-parent" value="Select" />
		</div>
	</div>
</body>
</html>