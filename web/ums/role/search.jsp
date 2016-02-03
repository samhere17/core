<%@ include file="../../cmn/head.jsp"%>
<form method="post" action="${pageContext.request.contextPath}/adapter">
	<input type="hidden" name="requested-action" value="SearchRole" />

	<div class="panel panel-default">
		<div class="panel-heading">
			<div class="panel-title">Search Role</div>
		</div>
		<div class="panel-body">
			<div class="row">
				<div class="col-md-3 form-group">
					<label class="control-label" for="roleId">Role ID</label>
					<input class="form-control" type="text" id="roleId" name="roleId">
				</div>
				<div class="col-md-6 form-group">
					<label class="control-label" for="roleName">Role Name</label>
					<input class="form-control" type="text" id="roleName" name="roleName">
				</div>
			</div>
			<div class="row">
				<div class="col-md-12">
					<input class="btn btn-md btn-primary" type="submit" value="Search">
				</div>
			</div>
		</div>
	</div>
</form>

<c:if test="${searchDone}">
	<div class="panel panel-default">
		<div class="panel-heading">
			<div class="panel-title">Search Result</div>
		</div>
		<div class="panel-body">
			<table class="table" id="role-search-result-table">
				<thead>
					<tr>
						<th>ID</th>
						<th>Name</th>
						<th>Description</th>
						<th>Status</th>
						<th style="width: 120px;">Action</th>
					</tr>
				</thead>
				<tbody>
					<c:choose>
						<c:when test="${not empty rolesList}">
							<c:forEach items="${rolesList}" var="current">
								<tr>
									<td>${current.roleId}</td>
									<td title="Hello">${current.roleName}</td>
									<td>${current.roleDescription}</td>
									<td>${current.roleStatus}</td>
									<td>
										<form method="get" action="${pageContext.request.contextPath}/adapter">
											<input type="hidden" name="requested-action" value="GetRole">
											<input type="hidden" name="path" value="ums/role/details">
											<input type="hidden" name="roleId" value="${current.roleId}">
											<button class="btn btn-xs btn-warning" type="submit" title="Details">
												<span class="glyphicon glyphicon-th-list"></span>
											</button>
										</form>
										<form method="get" action="${pageContext.request.contextPath}/adapter">
											<input type="hidden" name="requested-action" value="GetRole">
												<input type="hidden" name="path" value="ums/role/edit">
												<input type="hidden" name="roleId" value="${current.roleId}">
											<button class="btn btn-xs btn-warning" type="submit" title="Edit">
												<span class="glyphicon glyphicon-pencil"></span>
											</button>
										</form>
										<c:if test="${current.roleStatus != 'DELETED'}">
											<form method="get" action="${pageContext.request.contextPath}/adapter">
												<input type="hidden" name="requested-action" value="GetRole">
												<input type="hidden" name="path" value="ums/role/delete">
												<input type="hidden" name="roleId" value="${current.roleId}">
												<button class="btn btn-xs btn-warning" type="submit" title="Delete">
													<span class="glyphicon glyphicon-remove"></span>
												</button>
											</form>
										</c:if>
									</td>
								</tr>
							</c:forEach>
						</c:when>
						<c:otherwise>
							<tr>
								<td colspan="4">No roles found.</td>
							</tr>
						</c:otherwise>
					</c:choose>
				</tbody>
			</table>
		</div>
	</div>
</c:if>
<%@ include file="../../cmn/tail.jsp"%>
