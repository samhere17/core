<%@ include file="../../cmn/head.jsp" %>
<form method="post" action="${pageContext.request.contextPath}/adapter">
	<input type="hidden" name="requested-action" value="DeleteRole">
	<input type="hidden" name="roleId" value="${role.roleId}">

	<div class="alert alert-danger">
		You are about to delete the following role
	</div>

	<div class="panel panel-default">
		<div class="panel-heading">
			<div class="panel-title">
				Role Details
			</div>
		</div>
		<div class="panel-body">
			<div class="row">
				<div class="col-md-2 form-group">
					<label class="control-label" for="name">Role ID</label>
					<input class="form-control" type="text" value="${role.roleId}" readonly />
				</div>
				<div class="col-md-4 form-group">
					<label class="control-label" for="name">Role Area</label>
					<input class="form-control" type="text" value="${role.roleArea}" readonly />
				</div>
				<div class="col-md-4 form-group">
					<label class="control-label" for="name">Role Status</label>
					<input class="form-control" type="text" value="${role.roleStatus}" readonly />
				</div>
				<div class="col-md-2 form-group">
					<label class="control-label" for="name">Additional ID</label>
					<input class="form-control" type="text" value="${role.additionalId}" readonly />
				</div>
			</div>
			<div class="row">
				<div class="col-md-6 form-group">
					<label class="control-label" for="name">Role Name</label>
					<input class="form-control" type="text" value="${role.roleName}" readonly />
				</div>
				<div class="col-md-6 form-group">
					<label class="control-label" for="name">Role Description</label>
					<textarea class="form-control" readonly>${role.roleDescription}</textarea>
				</div>
			</div>
		</div>
	</div>

	<div class="panel panel-default">
		<div class="panel-heading">
			<div class="panel-title">
				Permissions
			</div>
		</div>
		<div class="panel-body">

			<c:if test="${not empty optionsList}">
				<c:set var="loopCount" value="0" />
				<c:set var="optionsListSize" value="${fn:length(optionsList)}" />
				<c:forEach items="${optionsList}" var="currentParent">
					<c:if test="${loopCount%2 eq 0}"><div class="row"></c:if>

					<div class="col-md-6">
						<c:if test="${not empty currentParent.childOptions}">
							<div class="panel panel-default">
								<div class="panel-heading">
									<input type="checkbox" class="select-all" <c:if test="${currentParent.menuItemEnabled}">checked</c:if> disabled>
									<b>${currentParent.optionName} Menu</b>
								</div>
								<div class="panel-body">
									<c:forEach items="${currentParent.childOptions}" var="currentChild">
										<c:if test="${currentChild.optionType == 'MENU_ITEM'}">
											<div>
												<input type="checkbox" <c:if test="${currentChild.menuItemEnabled}">checked</c:if> disabled>
												${currentChild.optionName}
											</div>
										</c:if>
									</c:forEach>
								</div>
							</div>
						</c:if>
					</div>

					<c:set var="loopCount" value="${loopCount+1}" />
					<c:if test="${loopCount%2 eq 0 or loopCount eq optionsListSize}"></div></c:if>
				</c:forEach>
			</c:if>
		</div>
	</div>


	<div class="row">
		<div class="col-md-12">
			<input class="btn btn-md btn-primary" type="submit" value="Delete">
		</div>
	</div>
	<br>

</form>

<c:if test="${umsSession.roleId == 1}">
	<div class="panel panel-danger">
		<div class="panel-heading">
			<h1 class="panel-title">Super Admin Area</h1>
		</div>
		<div class="panel-body">
			<div class="row">
				<div class="col-md-3 form-group">
					<label class="control-label" for="creation-date">Creation Date</label>
					<input class="form-control" id="creation-date" type="text" value='<fmt:formatDate type="date" value="${role.roleCreation}" />' readonly>
				</div>
				<div class="col-md-3 form-group">
					<label  class="control-label" for="creation-time">Creation Time</label>
					<input class="form-control" id="creation-time" type="text" value='<fmt:formatDate type="time" value="${role.roleCreation}" />' readonly>
				</div>
				<div class="col-md-2 form-group">
					<label class="control-label" for="created-by">Created By</label>
					<input class="form-control" id="created-by" type="text" value="${role.roleCreatedBy}" readonly>
				</div>
			</div>
			<div class="row">
				<div class="col-md-3 form-group">
					<label for="last-updated-date">Last Updated Date</label>
					<input class="form-control" id="last-updated-date" type="text" value='<fmt:formatDate type="date" value="${role.roleUpdated}" />' readonly>
				</div>
				<div class="col-md-3 form-group">
					<label class="control-label" for="last-updated-time">Last Updated Time</label>
					<input class="form-control" id="last-updated-time" type="text" value='<fmt:formatDate type="time" value="${role.roleUpdated}" />' readonly>
				</div>
				<div class="col-md-2 form-group">
					<label class="control-label" for="last-update-by">Last Updated By</label>
					<input class="form-control" id="last-update-by" type="text" value="${role.roleUpdatedBy}" readonly>
				</div>
			</div>
		</div>
	</div>
</c:if>
<%@ include file="../../cmn/tail.jsp" %>
