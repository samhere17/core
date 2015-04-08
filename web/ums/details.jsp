<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<title>OMS::iquesters</title>
<%@include file="/__sys/cmn/styles.jsp"%>
<%@include file="/__sys/cmn/scripts.jsp"%>
</head>
<body>
	<%
		String header = "User Details";
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
					<div class="form-header">
						<img
							src="${pageContext.request.contextPath}/__sys/img/user-16-16.png"
							alt="User Details" title="User Details" />
						<h3>User Details</h3>
					</div>
					<div class="form-content">

						<c:if test="${umsSession.roleId == 1}">
							<fieldset class="first">
								<legend>Organization Details</legend>
								<div class="fields-row">
									<div class="field-col">
										<label for="name">Organization Id</label> <input type="text"
											id="org-id" name="selectedOrgId" style="text-align: right;"
											readonly />
									</div>
									<div class="field-col">
										<label for="name">Organization Name</label> <input type="text"
											id="org-name" class="input-width-double" readonly />
									</div>
								</div>
							</fieldset>
						</c:if>

						<fieldset
							<c:if test="${umsSession.roleId != 1}">class="first"</c:if>>
							<legend>User Information</legend>
							<div class="fields-row">
								<div class="field-col">
									<label>User Id</label> <input type="text"
										value="${user.userId}" readonly />
								</div>
								<div class="field-col">
									<label>User Access Key</label> <input type="text"
										value="${user.userAccessKey}" class="input-width-double"
										readonly />
								</div>
								<div class="field-col">
									<label for="orgId">Status</label> <input type="text"
										value="${user.userStatus }" readonly />
								</div>
							</div>
							<div class="fields-row">
								<div class="field-col">
									<label>Username</label> <input type="text"
										value="${user.username}" readonly />
								</div>
								<div class="field-col">
									<label>Password</label> <input type="password"
										id="hidden-password" value="${user.decryptedPassword}"
										readonly /> <input type="text" id="visible-password"
										value="${user.decryptedPassword}" style="display: none;"
										readonly />
								</div>
								<div class="field-col">
									<label for="name">&nbsp;</label> <input type="button"
										id="btn-show-pass" value="Show Password" />
								</div>
								<script type="text/javascript">
									$(document).ready(function() {
										$('#btn-show-pass').click(function() {
											$('#hidden-password').toggle();
											$('#visible-password').toggle();
											if ($.trim($(this).val()) === 'Show Password') {
											    $(this).val('Hide Password');
											} else {
											    $(this).val('Show Password');        
											}
										});
									});
									</script>
							</div>

							<div class="fields-row">
								<div class="field-col">
									<label for="creationTime">Creation Date Time</label> <input
										type="text"
										value="<fmt:formatDate type="date" value="${user.userCreationTime}"/> <fmt:formatDate type="time" value="${user.userCreationTime}"/>"
										readonly />
								</div>
								<div class="field-col">
									<label for="userId">Created By</label> <input type="text"
										value="${org.userCreatedBy}" readonly />
								</div>
								<div class="field-col">
									<label for="creationTime">Last Updated Date Time</label> <input
										type="text"
										value="<fmt:formatDate type="date" value="${user.userUpdatedTime}"/> <fmt:formatDate type="time" value="${user.userUpdatedTime}"/>"
										readonly />
								</div>
								<div class="field-col">
									<label for="userId">Last Updated By</label> <input type="text"
										value="${user.userUpdatedBy}" readonly />
								</div>
							</div>
						</fieldset>

						<fieldset>
							<legend>User Details</legend>
							<div class="fields-row">
								<div class="field-col">
									<label>First Name</label> <input type="text"
										value="${userDetails.userFirstName}" readonly />
								</div>
								<div class="field-col">
									<label>Last Name</label> <input type="text"
										value="${userDetails.userLastName}" readonly />
								</div>
								<div class="field-col">
									<label>Alias (Nickname)</label> <input type="text"
										value="${userDetails.userAlias}" readonly />
								</div>
							</div>
							<div class="fields-row">
								<div class="field-col">
									<label>Address</label>
									<textarea readonly>${userDetails.address}</textarea>
								</div>
								<div class="multi-row-col">
									<div class="field-col">
										<label>Phone</label> <input type="text"
											value="${userDetails.primaryPhone}" readonly />
									</div>
									<div class="field-col">
										<label>Alternate Phone</label> <input type="text"
											value="${userDetails.alternatePhone}" readonly />
									</div>
								</div>
								<div class="multi-row-col">
									<div class="field-col">
										<label>Email</label> <input type="text"
											value="${userDetails.primaryEmail}" readonly />
									</div>
									<div class="field-col">
										<label>Alternate Email</label> <input type="text"
											value="${userDetails.alternateEmail}" readonly />
									</div>
								</div>
							</div>
							<div class="fields-row">
								<div class="field-col">
									<label>Gender</label> <input type="text"
										value="${userDetails.gender}" readonly />
								</div>
								<div class="field-col">
									<label>Birthday</label> <input type="text"
										value="<fmt:formatDate type="date" value="${userDetails.dateOfBirth}"/>"
										readonly />
								</div>
								<div class="field-col">
									<label>Anniversary</label> <input type="text"
										value="<fmt:formatDate type="date" value="${userDetails.anniversary}"/>"
										readonly />
								</div>
							</div>
						</fieldset>

						<fieldset>
							<legend>Role Information</legend>
							<div class="fields-row">
								<div class="field-col">
									<label for="name">Role Id</label> <input type="text"
										style="text-align: right;" value="${userRole.roleId}" readonly />
								</div>
								<div class="field-col">
									<label for="name">Role Name</label> <input type="text"
										value="${userRole.roleName}" readonly />
								</div>
								<div class="field-col">
									<label for="name">Role Description</label> <input type="text"
										value="${userRole.roleDescription}" class="input-width-double"
										readonly />
								</div>
							</div>
						</fieldset>
						<div class="clear"></div>
					</div>
				</div>

			</div>
		</div>
		<%@include file="/__sys/cmn/footer.jsp"%>
	</div>
</body>
</html>