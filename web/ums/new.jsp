<%@include file="../cmn/head.jsp"%>
	<form method="post" action="${pageContext.request.contextPath}/adapter">
		<input type="hidden" name="requested-action" value="InsertUser">

		<%-- Additional ID selection for Super Admin --%>
		<c:if test="${umsSession.roleId == 1}">
			<div class="panel panel-danger">
				<div class="panel-heading">
					<div class="panel-title">
						Additional ID Selection - Super User Area
					</div>
				</div>

				<div class="panel-body">
					<div class="row has-inline-button">
						<div class="col-md-3">
							<div class="form-group">
								<label class="control-label" for="name">Additional ID</label>
								<input class="form-control" type="text" id="commu-id" name="selectedOrgId" readonly>
							</div>
						</div>

						<div class="col-md-6">
							<div class="form-group">
								<label class="control-label" for="name">Additional Name</label>
								<input class="form-control" type="text" id="commu-name" readonly>
							</div>
						</div>

						<div class="col-md-3 inline-button-container">
							<div class="form-group">
								<button type="button" class="btn btn-md btn-primary" data-toggle="modal" data-target="#commu-modal">
									Lookup
								</button>
							</div>
						</div>
					</div>

					<div class="modal" role="dialog" id="commu-modal" tabindex="-1">
						<div class="modal-dialog" role="document">
							<div class="modal-content">
								<div class="modal-header">
									<button type="button" class="close" data-dismiss="modal" aria-hidden="true">x</button>
									<h4 class="modal-title">Choose A Community for the New User</h4>
								</div>
								<div class="modal-body">
									<table class="table table-hover">
										<thead>
											<tr>
												<th>ID</th>
												<th>Name</th>
												<th>Primary Phone Number</th>
											</tr>
										</thead>

										<tbody id="commu-table">
											<c:choose>
												<c:when test="${not empty orgsListForLookup}">
													<c:forEach items="${orgsListForLookup}" var="current">
														<tr class="ui-widget-content">
															<td>${current.key}</td>
															<td>${current.value["commu-name"]}</td>
															<td>${current.value["commu-primary-phone"]}</td>
														</tr>
													</c:forEach>
												</c:when>

												<c:otherwise>
													<tr>
														<td colspan="3">No community found.</td>
													</tr>
												</c:otherwise>
											</c:choose>
										</tbody>
									</table>
								</div>

								<div class="modal-footer">
									<button type="button" class="btn btn-primary" id="commu-select-btn">Select</button>
									<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</c:if>

		<%-- User Details --%>
		<div class="panel panel-info">
			<div class="panel-heading">
				<div class="panel-title">User Details</div>
			</div>

			<div class="panel-body">
				<div class="row">
					<div class="col-md-3">
						<div class="form-group has-feedback">
							<label class="control-label" for="firstname">First Name</label>
							<input class="form-control" type="text" id="firstname" name="firstname" required data-toggle="tooltip" data-placement="auto" title="">

							<span class="glyphicon glyphicon-ok form-control-feedback hidden"></span>
							<span class="glyphicon glyphicon-remove form-control-feedback hidden"></span>

							<%-- Validation error message --%>
							<p class="error-msg text-danger small hidden">
								<strong>Enter the user's first name</strong>
							</p>

							<%-- Error message from server --%>
							<c:if test="${hasError}">
								<p class="error-msg-from-svr text-danger small">
									<strong>${hasError.message}</strong>
								</p>
							</c:if>
						</div>
					</div>

					<div class="col-md-3">
						<div class="form-group has-feedback">
							<label class="control-label" for="firstname">Last Name</label>
							<input class="form-control" type="text" id="firstname" name="firstname" required data-toggle="tooltip" data-placement="auto" title="">

							<span class="glyphicon glyphicon-ok form-control-feedback hidden"></span>
							<span class="glyphicon glyphicon-remove form-control-feedback hidden"></span>

							<%-- Validation error message --%>
							<p class="error-msg text-danger small hidden">
								<strong>Enter the user's last name</strong>
							</p>

							<%-- Error message from server --%>
							<c:if test="${hasError}">
								<p class="error-msg-from-svr text-danger small">
									<strong>${hasError.message}</strong>
								</p>
							</c:if>
						</div>
					</div>

					<div class="col-md-3">
						<div class="form-group has-feedback">
							<label class="control-label" for="alias">Alias (Nickname)</label>
							<input class="form-control" type="text" id="alias" name="alias">

							<span class="glyphicon glyphicon-ok form-control-feedback hidden"></span>
							<span class="glyphicon glyphicon-remove form-control-feedback hidden"></span>

							<%-- Validation error message --%>
							<p class="error-msg text-danger small hidden">
								<strong>Enter an alias for the user</strong>
							</p>

							<%-- Error message from server --%>
							<c:if test="${hasError}">
								<p class="error-msg-from-svr text-danger small">
									<strong>${hasError.message}</strong>
								</p>
							</c:if>
						</div>
					</div>

					<div class="col-md-3">
						<label class="control-label" for="gender">Gender</label>
						<br>
						<div class="form-group has-feedback">
							<div class="btn-group" data-toggle="buttons">
								<label class="btn btn-default">
									<input class="form-control" type="radio" name="gender" value="0" required> Male
								</label>

								<label class="btn btn-default">
									<input class="form-control" type="radio" name="gender" value="1" required> Female
								</label>

								<label class="btn btn-default">
									<input class="form-control" type="radio" name="gender" value="2" required> Other
								</label>
							</div>
						</div>
					</div>
				</div>

				<div class="row">
					<div class="col-md-6">
						<div class="form-group has-feedback">
							<label class="control-label" class="control-label" for="address">Address</label>
							<textarea class="form-control" name="address" required></textarea>

							<span class="glyphicon glyphicon-ok form-control-feedback hidden"></span>
							<span class="glyphicon glyphicon-remove form-control-feedback hidden"></span>

							<%-- Validation error message --%>
							<p class="error-msg text-danger small hidden">
								<strong>Enter user's address</strong>
							</p>

							<%-- Error message from server --%>
							<c:if test="${hasError}">
								<p class="error-msg-from-svr text-danger small">
									<strong>${hasError.message}</strong>
								</p>
							</c:if>
						</div>
					</div>

					<div class="col-md-3 form-group">
						<div class="form-group has-feedback">
							<label class="control-label" for="phone">Phone</label>
							<input class="form-control" type="tel" name="phone" required maxlength="14">

							<span class="glyphicon glyphicon-ok form-control-feedback hidden"></span>
							<span class="glyphicon glyphicon-remove form-control-feedback hidden"></span>

							<%-- Validation error message --%>
							<p class="error-msg text-danger small hidden">
								<strong>Enter user's phone number</strong>
							</p>

							<%-- Error message from server --%>
							<c:if test="${hasError}">
								<p class="error-msg-from-svr text-danger small">
									<strong>${hasError.message}</strong>
								</p>
							</c:if>
						</div>
					</div>

					<div class="col-md-3">
						<div class="form-group has-feedback">
							<label class="control-label" for="alt-phone">Alternate Phone</label>
							<input class="form-control" type="tel" name="altPhone" maxlength="14" placeholder="Optional field">

							<span class="glyphicon glyphicon-ok form-control-feedback hidden"></span>
							<span class="glyphicon glyphicon-remove form-control-feedback hidden"></span>

							<%-- Error message from server --%>
							<c:if test="${hasError}">
								<p class="error-msg-from-svr text-danger small">
									<strong>${hasError.message}</strong>
								</p>
							</c:if>
						</div>
					</div>
				</div>

				<div class="row">
					<div class="col-md-6">
						<div class="form-group has-feedback">
							<label class="control-label" for="email">Email</label>
							<input class="form-control" type="text" name="email" required>

							<span class="glyphicon glyphicon-ok form-control-feedback hidden"></span>
							<span class="glyphicon glyphicon-remove form-control-feedback hidden"></span>

							<%-- Validation error message --%>
							<p class="error-msg text-danger small hidden">
								<strong>Enter user's email address</strong>
							</p>

							<%-- Error message from server --%>
							<c:if test="${hasError}">
								<p class="error-msg-from-svr text-danger small">
									<strong>${hasError.message}</strong>
								</p>
							</c:if>
						</div>
					</div>

					<div class="col-md-6">
						<div class="form-group has-feedback">
							<label class="control-label" for="alt-email">Alternate Email</label>
							<input class="form-control" type="text" name="altEmail" placeholder="Optional field">

							<span class="glyphicon glyphicon-ok form-control-feedback hidden"></span>
							<span class="glyphicon glyphicon-remove form-control-feedback hidden"></span>

							<%-- Validation error message --%>
							<p class="error-msg text-danger small hidden">
								<strong>Enter the name of your community</strong>
							</p>

							<%-- Error message from server --%>
							<c:if test="${hasError}">
								<p class="error-msg-from-svr text-danger small">
									<strong>${hasError.message}</strong>
								</p>
							</c:if>
						</div>
					</div>
				</div>

				<div class="row">
					<div class="col-md-3">
						<div class="form-group has-feedback">
							<label class="control-label" class="control-label" for="birth-day">Birthday</label>
							<input class="form-control" type="date" id="birth-day" name="birthday" required>

							<span class="glyphicon glyphicon-ok form-control-feedback hidden"></span>
							<span class="glyphicon glyphicon-remove form-control-feedback hidden"></span>

							<%-- Validation error message --%>
							<p class="error-msg text-danger small hidden">
								<strong>Enter user's birthday</strong>
							</p>

							<%-- Error message from server --%>
							<c:if test="${hasError}">
								<p class="error-msg-from-svr text-danger small">
									<strong>${hasError.message}</strong>
								</p>
							</c:if>
						</div>
					</div>

					<div class="col-md-3">
						<div class="form-group has-feedback">
							<label class="control-label" for="anniversary">Anniversary</label>
							<input class="form-control" type="date" id="anniversary" name="anniversary">

							<span class="glyphicon glyphicon-ok form-control-feedback hidden"></span>
							<span class="glyphicon glyphicon-remove form-control-feedback hidden"></span>

							<%-- Error message from server --%>
							<c:if test="${hasError}">
								<p class="error-msg-from-svr text-danger small">
									<strong>${hasError.message}</strong>
								</p>
							</c:if>
						</div>
					</div>
				</div>
			</div>
		</div>

		<%-- Login Details --%>
		<div class="panel panel-info">
			<div class="panel-heading">
				<div class="panel-title">
					Login Credentials
				</div>
			</div>

			<div class="panel-body">
				<div class="row">
					<div class="col-md-3">
						<div class="form-group has-feedback">
							<label class="control-label" for="username">Username</label>
							<input class="form-control" type="text" id="username" name="username" required>

							<span class="glyphicon glyphicon-ok form-control-feedback hidden"></span>
							<span class="glyphicon glyphicon-remove form-control-feedback hidden"></span>

							<%-- Validation error message --%>
							<p class="error-msg text-danger small hidden">
								<strong>Choose a username</strong>
							</p>

							<%-- Error message from server --%>
							<c:if test="${hasError}">
								<p class="error-msg-from-svr text-danger small">
									<strong>${hasError.message}</strong>
								</p>
							</c:if>
						</div>
					</div>

					<div class="col-md-3">
						<div class="form-group has-feedback">
							<label class="control-label" for="password">Password</label>
							<input class="form-control" type="password" id="password" name="password" required>

							<span class="glyphicon glyphicon-ok form-control-feedback hidden"></span>
							<span class="glyphicon glyphicon-remove form-control-feedback hidden"></span>

							<%-- Validation error message --%>
							<p class="error-msg text-danger small hidden">
								<strong>Super secret password ;)</strong>
							</p>

							<%-- Error message from server --%>
							<c:if test="${hasError}">
								<p class="error-msg-from-svr text-danger small">
									<strong>${hasError.message}</strong>
								</p>
							</c:if>
						</div>
					</div>

					<div class="col-md-3">
						<div class="form-group has-feedback">
							<label class="control-label" for="cpassword">Confirm Password</label>
							<input class="form-control" type="password" id="cpassword" name="cpassword" required>

							<span class="glyphicon glyphicon-ok form-control-feedback hidden"></span>
							<span class="glyphicon glyphicon-remove form-control-feedback hidden"></span>

							<%-- Validation error message --%>
							<p class="error-msg text-danger small hidden">
								<strong>Repeat the password</strong>
							</p>

							<%-- Error message from server --%>
							<c:if test="${hasError}">
								<p class="error-msg-from-svr text-danger small">
									<strong>${hasError.message}</strong>
								</p>
							</c:if>
						</div>
					</div>
				</div>
			</div>
		</div>

		<div class="panel panel-info">
			<div class="panel-heading">
				<div class="panel-title">
					Role Selection
				</div>
			</div>

			<div class="panel-body">
				<div class="row has-inline-button">
					<div class="col-md-3">
						<div class="form-group">
							<label class="control-label">Role ID</label>
							<input class="form-control" type="text" id="role-id" name="selectedRoleId" readonly>
						</div>
					</div>

					<div class="col-md-6">
						<div class="form-group">
							<label class="control-label" >Role Name</label>
							<input class="form-control" type="text" id="role-name" readonly>
						</div>
					</div>

					<div class="col-md-3 inline-button-container">
						<div class="form-group">
							<button type="button" class="btn btn-md btn-primary" data-toggle="modal" data-target="#role-modal">
								Lookup
							</button>
						</div>
					</div>
				</div>

				<div class="modal" role="dialog" id="role-modal" tabindex="-1">
					<div class="modal-dialog" role="document">
						<div class="modal-content">
							<div class="modal-header">
								<button type="button" class="close" data-dismiss="modal" aria-hidden="true">x</button>
								<h4 class="modal-title">Choose A Role for the New User</h4>
							</div>

							<div class="modal-body">
								<table class="table table-hover">
									<thead>
										<tr>
											<th>ID</th>
											<th>Name</th>
											<th>Description</th>
										</tr>
									</thead>

									<tbody id="roles-table">
										<c:choose>
											<c:when test="${not empty rolesListForLookup}">
												<c:forEach items="${rolesListForLookup}" var="current">
													<tr class="ui-widget-content">
														<td>${current.roleId}</td>
														<td>${current.roleName}</td>
														<td>${current.roleDescription}</td>
													</tr>
												</c:forEach>
											</c:when>

											<c:otherwise>
												<tr>
													<td colspan="3">No roles found.</td>
												</tr>
											</c:otherwise>
										</c:choose>
									</tbody>
								</table>
							</div>

							<div class="modal-footer">
								<button type="button" class="btn btn-primary" id="role-select-btn">Select</button>
								<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>

		<div class="row">
			<div class="col-md-12">
				<input class="btn btn-md btn-primary" type="submit" value="Save">
			</div>
		</div>
		<br>
	</form>

<%@include file="../cmn/tail.jsp"%>
