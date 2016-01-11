<%@include file="../../cmn/head.jsp"%>
	<form method="post" action="${pageContext.request.contextPath}/adapter">
		<input class="form-control" type="hidden" name="serviceName" value="InsertOption">

		<div class="panel panel-info">
			<div class="panel-heading">
				<div class="panel-title">
					Add New Option
				</div>
			</div>

			<div class="panel-body">
				<div class="row">
					<div class="col-md-3">
						<div class="form-group">
							<label class="control-label">Option Id</label>
							<input class="form-control" type="text" value="Will be generated" readonly />
						</div>
					</div>
					<div class="col-md-3">
						<div class="form-group">
							<label class="control-label">Option Type</label>
							<select class="form-control" name="optType" required>
								<option value="0">Menu</option>
								<option value="1">Menu Item</option>
								<option value="2">Separator</option>
							</select>
						</div>
					</div>
					<div class="col-md-3">
						<div class="form-group">
							<label class="control-label">Option Area</label>
							<select class="form-control" name="optArea" required>
								<option value="0">System</option>
								<option value="1">Application</option>
							</select>
						</div>
					</div>
					<div class="col-md-3">
						<div class="form-group">
							<label class="control-label">Option Status</label>
							<select class="form-control" name="optStatus" required>
								<option value="0">Inactive</option>
								<option value="1">Active</option>
								<option value="2">Deleted</option>
							</select>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-md-3">
						<div class="form-group has-feedback">
							<label class="control-label">Option Order</label>
							<input class="form-control" type="text" name="optOrder" value="0" required>

							<span class="glyphicon glyphicon-ok form-control-feedback hidden"></span>
							<span class="glyphicon glyphicon-remove form-control-feedback hidden"></span>

							<%-- Validation error message --%>
							<p class="error-msg text-danger small hidden">
								<strong>Enter name for the option</strong>
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
							<label class="control-label">Option Name</label>
							<input class="form-control" type="text" name="optName" required>

							<span class="glyphicon glyphicon-ok form-control-feedback hidden"></span>
							<span class="glyphicon glyphicon-remove form-control-feedback hidden"></span>

							<%-- Validation error message --%>
							<p class="error-msg text-danger small hidden">
								<strong>Enter name for the option</strong>
							</p>

							<%-- Error message from server --%>
							<c:if test="${hasError}">
								<p class="error-msg-from-svr text-danger small">
									<strong>${hasError.message}</strong>
								</p>
							</c:if>
						</div>
					</div>
					<div class="col-md-6 form-group">
						<div class="form-group">
							<label class="control-label">Option Description</label>
							<textarea class="form-control" name="optDesc"></textarea>
						</div>
					</div>
				</div>

				<div class="row">
					<div class="col-md-12">
						<div class="form-group has-feedback">
							<label class="control-label">Option Link</label>
							<input class="form-control" type="text" name="optLink" required>

							<span class="glyphicon glyphicon-ok form-control-feedback hidden"></span>
							<span class="glyphicon glyphicon-remove form-control-feedback hidden"></span>

							<%-- Validation error message --%>
							<p class="error-msg text-danger small hidden">
								<strong>Enter link URL for the option</strong>
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
						<div class="form-group">
							<label class="control-label">Option Icon</label>
							<input class="form-control" type="text" name="optIcon">
						</div>
					</div>
					<div class="col-md-3">
						<div class="form-group text-center">
							<span class="fa fa-5x fa-user"></span>
						</div>
					</div>
					<div class="col-md-3">
						<div class="form-group">
							<label class="control-label">Object Reference</label>
							<input class="form-control" type="text" name="objRef">
						</div>
					</div>
				</div>

				<hr>

				<div class="row has-inline-button">
					<div class="col-md-3">
						<div class="form-group">
							<label class="control-label">Parent Option ID</label>
							<input class="form-control" type="text" id="opt-id" name="optParentId" readonly />
						</div>
					</div>

					<div class="col-md-6">
						<div class="form-group">
							<label class="control-label">Parent Option Name</label>
							<input class="form-control" type="text" id="opt-name" readonly >
						</div>
					</div>

					<div class="col-md-3 form-group inline-button-container">
						<button type="button" class="btn btn-md btn-primary" data-toggle="modal" data-target="#option-modal">
							Lookup
						</button>
					</div>
				</div>
			</div>
		</div>

		<div class="row">
			<div class="col-md-12">
				<button class="btn btn-primary" type="submit">
					<span class="fa fa-floppy-o"></span> Save
				</button>
			</div>
		</div>

		<div class="modal fade" role="dialog" id="option-modal" tabindex="-1">
			<div class="modal-dialog" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal" aria-hidden="true">x</button>
						<h4 class="modal-title">Choose A Parent ID</h4>
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

							<tbody id="option-table">
								<c:choose>
									<c:when test="${not empty parentOptionsList}">
										<c:forEach items="${parentOptionsList}" var="current">
											<tr class="ui-widget-content">
												<td>${current.optionId}</td>
												<td>${current.optionName}</td>
												<td>${current.optionDescription}</td>
											</tr>
										</c:forEach>
									</c:when>
									<c:otherwise>
										<tr>
											<td colspan="3">No options found.</td>
										</tr>
									</c:otherwise>
								</c:choose>
							</tbody>
						</table>
					</div>

					<div class="modal-footer">
						<button type="button" class="btn btn-primary" id="option-select-btn">Select</button>
						<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
					</div>
				</div>
			</div>
		</div>
	</form>
<%@include file="../../cmn/tail.jsp"%>
