<%@ include file="../cmn/head.jsp" %>
	<div class="panel-group" id="accordion" role="tablist" aria-multiselectable="true">
		<div class="panel panel-info">
			<div id="criteria-heading" class="panel-heading" role="button" data-toggle="collapse" href="#criteria" aria-expanded="true" aria-controls="criteria">
				<h1 class="panel-title">
					Search Criteria
				</h1>
			</div>

			<div id="criteria" class="panel-collapse collapse <c:if test="${!searchDone}">in</c:if>" role="tabpanel" aria-labelledby="criteria-heading">
				<div class="panel-body">
					<form method="post" action="${pageContext.request.contextPath}/adapter">
						<input type="hidden" name="serviceName" value="SearchUser">
						<h4>
							<strong>User Details</strong>
						</h4>

						<div class="row">
							<div class="col-md-6 form-group">
								<label class="control-label" for="id">ID</label>
								<input class="form-control" type="text" id="id" name="userId">
							</div>
							<div class="col-md-6 form-group">
								<label class="control-label" for="username">Username</label>
								<input class="form-control"type="text" id="username" name="username">
							</div>
						</div>

						<div class="row">
							<div class="col-md-3 form-group">
								<label class="control-label" for="firstname">First Name</label>
								<input class="form-control"type="text" id="firstname" name="firstname">
							</div>
							<div class="col-md-3 form-group">
								<label class="control-label" for="lastname">Last Name</label>
								<input class="form-control" type="text" id="lastname" name="lastname">
							</div>
							<div class="col-md-3 form-group">
								<label class="control-label" for="phone">Phone</label>
								<input class="form-control"type="text" name="phone">
							</div>
							<div class="col-md-3 form-group">
								<label class="control-label" for="email">Email</label>
								<input class="form-control" type="text" name="email">

								<c:if test="${not empty validation.emailError}">
									<div class="${validation.emailError.level}">${validation.emailError.message}</div>
								</c:if>
							</div>
						</div>
						<hr>

						<h4>
							<strong>Role Selection</strong>
						</h4>

						<div class="row has-inline-button">
							<div class="col-md-4 form-group">
								<label class="control-label" for="name">Role ID</label>
								<input class="form-control" type="text" id="role-id" name="selectedRoleId" readonly required />
							</div>

							<div class="col-md-4 form-group">
								<label class="control-label" for="name">Role Name</label>
								<input class="form-control" type="text" id="role-name" readonly required>
							</div>

							<div class="col-md-4 form-group inline-button-container">
								<button type="button" class="btn btn-md btn-primary pull-right" data-toggle="modal" data-target="#role-modal">
									Lookup Role
								</button>
							</div>
						</div>

						<div class="modal fade" role="dialog" id="role-modal" tabindex="-1">
							<div class="modal-dialog" role="document">
								<div class="modal-content">
									<div class="modal-header">
										<button type="button" class="close" data-dismiss="modal" aria-hidden="true">x</button>
										<h4 class="modal-title">Choose A Role</h4>
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
															<td colspan="3">No users found.</td>
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
						<hr>

						<c:if test="${umsSession.roleId == 1}">
							<h4 class="text-danger">
								<strong>Additional ID Selection - Super Admin Area</strong>
							</h4>

							<div class="row has-inline-button">
								<div class="col-md-4 form-group">
									<label class="control-label" for="commu-id">Additional ID</label>
									<input class="form-control" type="text" id="commu-id" name="selectedOrgId" readonly>
								</div>

								<div class="col-md-4 form-group">
									<label class="control-label" for="name">Additional Name</label>
									<input class="form-control" type="text" id="commu-name" readonly>
								</div>

								<div class="col-md-4 form-group inline-button-container">
									<button type="button" class="btn btn-md btn-primary pull-right" data-toggle="modal" data-target="#commu-modal">
										Lookup Additional Info
									</button>
								</div>
							</div>

							<div class="modal" role="dialog" id="commu-modal" tabindex="-1">
								<div class="modal-dialog" role="document">
									<div class="modal-content">
										<div class="modal-header">
											<button type="button" class="close" data-dismiss="modal" aria-hidden="true">x</button>
											<h4 class="modal-title">Choose Addtional ID</h4>
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
																<td colspan="3">No addtional information found.</td>
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
						</c:if>

						<div class="row">
							<div class="col-md-12">
								<button class="btn btn-md btn-primary" type="submit">
									<span class="fa fa-search"></span>
									Search
								</button>
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>

		<div class="panel panel-info">
			<div id="results-heading" class="panel-heading collapsed" role="button" data-toggle="collapse" href="#results" aria-expanded="false" aria-controls="results">
				<h1 class="panel-title">
					Search Results
				</h1>
			</div>

			<div id="results" class="panel-collapse collapse <c:if test="${searchDone}">in</c:if>" role="tabpanel" aria-labelledby="results-heading">
				<div class="panel-body">
					<table class="table" id="role-search-result-table">
						<thead>
							<tr>
								<th style="width: 5%;">ID</th>
								<th style="width: 20%;">Name</th>
								<th>Alias</th>
								<th style="width: 30%;" class="text-right">Action</th>
							</tr>
						</thead>

						<tbody>
							<c:choose>
								<c:when test="${not empty usersList}">
									<c:forEach items="${usersList}" var="current">
										<tr>
											<td>${current["userId"]}</td>
											<td>${current["userFirstName"]} ${current["userLastName"]}</td>
											<td>${current["userAlias"]}</td>

											<td class="text-right">
												<form method="get" action="${pageContext.request.contextPath}/adapter">
													<input type="hidden" name="serviceName" value="GetUser">
													<input type="hidden" name="path" value="ums/details">
													<input type="hidden" name="userId" value="${current.userId}">
													<button class="btn btn-xs btn-warning" type="submit" title="Details">
														<span class="glyphicon glyphicon-th-list"></span>
													</button>
												</form>

												<form method="get" action="${pageContext.request.contextPath}/adapter">
													<input type="hidden" name="serviceName" value="GetUser">
													<input type="hidden" name="path" value="ums/edit">
													<input type="hidden" name="userId" value="${current.userId}">
													<button class="btn btn-xs btn-warning" type="submit" title="Edit">
														<span class="glyphicon glyphicon-pencil"></span>
													</button>
												</form>

												<%-- Always displaying the delete button. This form is only for internal use --%>
												<form method="get" action="${pageContext.request.contextPath}/adapter">
													<input type="hidden" name="serviceName" value="GetUser">
													<input type="hidden" name="path" value="ums/delete">
													<input type="hidden" name="userId" value="${current.userId}">
													<button class="btn btn-xs btn-warning" type="submit" title="Delete">
														<span class="glyphicon glyphicon-remove"></span>
													</button>
												</form>
											</td>
										</tr>
									</c:forEach>
								</c:when>

								<c:otherwise>
									<tr>
										<td colspan="4">No user found.</td>
									</tr>
								</c:otherwise>
							</c:choose>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</div>
<%@ include file="../cmn/tail.jsp" %>
