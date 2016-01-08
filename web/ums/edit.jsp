<%@ include file="../../cmn/head.jsp" %>
	<div class="panel panel-default">
		<div class="panel-heading">
			<div class="panel-title">
				Login Credentials
			</div>
		</div>

		<div class="panel-body">
			<div class="row">
				<div class="col-md-5 form-group">
					<label class="control-label">Username</label>
					<input class="form-control" type="text" value="${user.username}" readonly>
				</div>
				<div class="col-md-5 form-group">
					<label class="control-label">Password</label>
					<input class="form-control" type="password" id="hidden-password" value="${user.decryptedPassword}">
				</div>
			</div>
		</div>
	</div>

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
					<input class="form-control" type="text" value="${user.userId}" readonly>
				</div>
				<div class="col-md-3 form-group">
					<label class="control-label">First Name</label>
					<input class="form-control" type="text" value="${userDetails.userFirstName}">
				</div>
				<div class="col-md-3 form-group">
					<label class="control-label">Last Name</label>
					<input class="form-control" type="text" value="${userDetails.userLastName}">
				</div>
				<div class="col-md-3 orm-group">
					<label class="control-label">Alias (Nickname)</label>
					<input class="form-control" type="text" value="${userDetails.userAlias}">
				</div>
			</div>

			<div class="row">
				<div class="col-md-6 form-group">
					<label class="control-label">Address</label>
					<textarea class="form-control">${userDetails.address}</textarea>
				</div>
			</div>

			<div class="row">
				<div class="col-md-3 form-group">
					<label class="control-label">Phone</label>
					<input class="form-control" type="text" value="${userDetails.primaryPhone}">
				</div>
				<div class="col-md-3 form-group">
					<label class="control-label">Alternate Phone</label>
					<input class="form-control" type="text" value="${userDetails.alternatePhone}">
				</div>
				<div class="col-md-3 form-group">
					<label class="control-label">Email</label>
					<input class="form-control" type="text" value="${userDetails.primaryEmail}">
				</div>
				<div class="col-md-3 form-group">
					<label class="control-label">Alternate Email</label>
					<input class="form-control" type="text" value="${userDetails.alternateEmail}">
				</div>
			</div>

			<div class="row">
				<div class="col-md-4 form-group">
					<label class="control-label" for="gender">Gender</label>
					<br>
					<div class="btn-group" data-toggle="buttons" required>
						<label class="btn btn-default <c:if test='${userDetails.gender == "MALE"}'> active </c:if>">
							<input class="form-control" type="radio" name="gender" value="0" required> Male
						</label>

						<label class="btn btn-default <c:if test='${userDetails.gender == "FEMALE"}'> active </c:if>">
							<input class="form-control" type="radio" name="gender" value="1" required> Female
						</label>

						<label class="btn btn-default <c:if test='${userDetails.gender == "UNKNOWN"}'> active </c:if>">
							<input class="form-control" type="radio" name="gender" value="2" required> Other
						</label>
					</div>
				</div>
				<div class="col-md-4 form-group">
					<label class="control-label">Birthday</label>
					<input class="form-control" type="date" value='<fmt:formatDate pattern="yyyy-MM-dd" value="${userDetails.dateOfBirth}" />'>
				</div>
				<div class="col-md-4 form-group">
					<label class="control-label">Anniversary</label>
					<input class="form-control" type="date" value='<fmt:formatDate pattern="yyyy-MM-dd" value="${userDetails.anniversary}" />'>
				</div>
			</div>
		</div>
	</div>

	<%-- <div class="panel panel-default">
		<div class="panel-heading">
			<div class="panel-title">
				Role Information
			</div>
		</div>

		<div class="panel-body">
			<div class="row has-inline-button">
				<div class="col-md-6 form-group">
					<label class="control-label" for="name">Role ID</label>
					<input class="form-control" type="text" value="${userRole.roleId}" readonly>
				</div>
				<div class="col-md-6 form-group">
					<label class="control-label" for="name">Role Name</label>
					<input class="form-control" type="text" value="${userRole.roleName}" readonly>
				</div>
			</div>
		</div>
	</div> --%>


	<div class="row">
		<div class="col-md-12">
			<input class="btn btn-md btn-primary" type="submit" value="Update">
		</div>
	</div>
	<br>
<%@ include file="../../cmn/tail.jsp" %>
