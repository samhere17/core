<%@ include file="../../cmn/head.jsp" %>
<form method="post" action="${pageContext.request.contextPath}/adapter">
	<input type="hidden" name="serviceName" value="DeleteUser">
	<div class="alert alert-danger">
		You are about to delete the following user
	</div>

	<c:if test="${umsSession.roleId == 1}">
		<div class="panel panel-default">
			<div class="panel-heading">
				<div class="panel-title">
					Additional Information
				</div>
			</div>
			<div class="panel-body">
				<div class="row">
					<div class="col-md-6 form-group">
						<label class="control-label" for="name">Additional ID</label>
						<input class="form-control" type="text" id="org-id" name="selectedOrgId"  value="${user.additionalId}" readonly>
					</div>
					<div class="col-md-6 form-group">
						<label class="control-label" for="name">Additional Details</label>
						<input class="form-control" type="text" id="org-name" class="input-width-double" readonly>
					</div>
				</div>
			</div>
		</div>
	</c:if>

	<div class="panel panel-default">
		<div class="panel-heading">
			<div class="panel-title">
				User Details
			</div>
		</div>
		<div class="panel-body">
			<div class="row">
				<div class="col-md-3 form-group">
					<label class="control-label">User ID</label>
					<input class="form-control" name="userId" type="text" value="${user.userId}" readonly>
				</div>
				<div class="col-md-3 form-group">
					<label class="control-label">First Name</label>
					<input class="form-control" type="text" value="${userDetails.userFirstName}" readonly>
				</div>
				<div class="col-md-3 form-group">
					<label class="control-label">Last Name</label>
					<input class="form-control" type="text" value="${userDetails.userLastName}" readonly>
				</div>
				<div class="col-md-3 form-group">
					<label class="control-label">Alias (Nickname)</label>
					<input class="form-control" type="text" value="${userDetails.userAlias}" readonly>
				</div>
			</div>

			<div class="row">
				<div class="col-md-6 form-group">
					<label class="control-label">Address</label>
					<textarea class="form-control" readonly>${userDetails.address}</textarea>
				</div>
			</div>

			<div class="row">
				<div class="col-md-3 form-group">
					<label class="control-label">Phone</label>
					<input class="form-control" type="text" value="${userDetails.primaryPhone}" readonly>
				</div>
				<div class="col-md-3 form-group">
					<label class="control-label">Alternate Phone</label>
					<input class="form-control" type="text" value="${userDetails.alternatePhone}" readonly>
				</div>
				<div class="col-md-3 form-group">
					<label class="control-label">Email</label>
					<input class="form-control" type="text" value="${userDetails.primaryEmail}" readonly>
				</div>
				<div class="col-md-3 form-group">
					<label class="control-label">Alternate Email</label>
					<input class="form-control" type="text" value="${userDetails.alternateEmail}" readonly>
				</div>
			</div>

			<div class="row">
				<div class="col-md-4 form-group">
					<label class="control-label">Gender</label>
					<input class="form-control" type="text" value="${userDetails.gender}" readonly>
				</div>
				<div class="col-md-4 form-group">
					<label class="control-label">Birthday</label>
					<input class="form-control" type="text" value='<fmt:formatDate type="date" value="${userDetails.dateOfBirth}"/>' readonly>
				</div>
				<div class="col-md-4 form-group">
					<label class="control-label">Anniversary</label>
					<input class="form-control" type="text" value='<fmt:formatDate type="date" value="${userDetails.anniversary}"/>' readonly>
				</div>
			</div>
		</div>
	</div>

	<div class="panel panel-default">
		<div class="panel-heading">
			<div class="panel-title">
				Login Credentials
			</div>
		</div>

		<div class="panel-body">
			<div class="row has-inline-button">
				<div class="col-md-3 form-group">
					<label class="control-label">Username</label>
					<input class="form-control" type="text" value="${user.username}" readonly>
				</div>
				<div class="col-md-3 form-group">
					<label class="control-label">Password</label>
					<input class="form-control" type="password" id="hidden-password" value="${user.decryptedPassword}" readonly>
				</div>
				<div class="col-md-3">
					<button id="show-pass-btn" type="button" class="btn btn-primary">Show Password</button>
				</div>
			</div>
		</div>
	</div>

	<div class="panel panel-default">
		<div class="panel-heading">
			<div class="panel-title">
				Role Information
			</div>
		</div>
		<div class="panel-body">
			<div class="row">
				<div class="col-md-4 form-group">
					<label class="control-label" for="name">Role ID</label>
					<input class="form-control" type="text" value="${userRole.roleId}" readonly>
				</div>
				<div class="col-md-4 form-group">
					<label class="control-label" for="name">Role Name</label>
					<input class="form-control" type="text" value="${userRole.roleName}" readonly>
				</div>
				<div class="col-md-4 form-group">
					<label class="control-label" for="name">Role Description</label>
					<input class="form-control" type="text" value="${userRole.roleDescription}" class="input-width-double" readonly>
				</div>
			</div>
		</div>
	</div>

	<c:if test="${umsSession.roleId == 1}">
		<div class="panel panel-danger">
			<div class="panel-heading">
				<div class="panel-title">
					Super User Area
				</div>
			</div>

			<div class="panel-body">
				<div class="row">
					<div class="col-md-3 form-group">
						<label class="control-label" for="creationTime">Creation Date</label>
						<input class="form-control" type="text" value='<fmt:formatDate type="time" value="${user.userCreationTime}"/>' readonly>
					</div>
					<div class="col-md-3 form-group">
						<label class="control-label" for="creationTime">Creation Time</label>
						<input class="form-control" type="text" value='<fmt:formatDate type="date" value="${user.userCreationTime}"/>' readonly>
					</div>
					<div class="col-md-3 form-group">
						<label class="control-label">Created By</label>
						<input class="form-control" type="text" value="${org.userCreatedBy}" readonly>
					</div>
					<div class="col-md-3 form-group">
						<label class="control-label" for="orgId">Status</label>
						<input class="form-control" type="text" value="${user.userStatus }" readonly>
					</div>
				</div>

				<div class="row">
					<div class="col-md-3 form-group">
						<label class="control-label" for="creationTime">Last Updated Date</label>
						<input class="form-control" type="text" value='<fmt:formatDate type="date" value="${user.userUpdatedTime}"/>' readonly>
					</div>

					<div class="col-md-3 form-group">
						<label class="control-label" for="creationTime">Last Updated Time</label>
						<input class="form-control" type="text" value='<fmt:formatDate type="time" value="${user.userUpdatedTime}"/>' readonly>
					</div>

					<div class="col-md-3 form-group">
						<label class="control-label">Last Updated By</label>
						<input class="form-control" type="text" value="${user.userUpdatedBy}" readonly>
					</div>
					<div class="col-md-3 form-group">
						<label class="control-label">User Access Key</label>
						<input class="form-control" name="userAccessKey" type="text" value="${user.userAccessKey}" readonly>
					</div>
				</div>
			</div>
		</div>
	</c:if>
	<div class="row">
		<div class="col-md-12">
			<input class="btn btn-md btn-primary" type="submit" value="Delete">
		</div>
	</div>
	<br>

</form>
<%@ include file="../../cmn/tail.jsp" %>
