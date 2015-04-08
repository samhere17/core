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
		String header = "Search Role";
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
					<form method="post" action="${pageContext.request.contextPath}/adapter">
						<input type="hidden" name="serviceName" value="SearchRole" />
						<div class="form-header">
							<img src="${pageContext.request.contextPath}/__sys/img/role-search-16-16.png" alt="Search Role" title="Search Role" />
							<h3>Search Role</h3>
						</div>
						<div class="form-content">
							<div class="fields-row">
								<div class="field-col">
									<label for="orgId">Role Id</label>
									<input type="text" id="org-id" name="roleId" value=""  />
								</div>
								<div class="field-col">
									<label for="name">Role Name</label>
									<input type="text" id="org-name" name="roleName" value="" />
								</div>
							</div>
							<div class="clear"></div>
						</div>
						<div class="form-actions">
							<input type="submit" id="role-search" value="Search" />
						</div>
					</form>
				</div>


				<c:if test="${searchDone}">
					<div id="searchResult" class="form-container">
						<div class="form-header">
							<img
								src="${pageContext.request.contextPath}/__sys/img/search-result-16-16.png"
								alt="Search Result" title="Search Result" />
							<h3>Search Result</h3>
						</div>
						<div class="form-content">
							<table id="list-table" class="table-sorter">
								<thead>
									<tr>
										<th>Id</th>
										<th>Name</th>
										<th>Description</th>
										<th style="width: 9px;"></th>
									</tr>
								</thead>
								<tbody>
									<c:choose>
										<c:when test="${not empty rolesList}">
											<c:forEach items="${rolesList}" var="current">
												<tr>
													<td>${current.roleId}</td>
													<td>${current.roleName}</td>
													<td>${current.roleDescription}</td>
													<td>
														<form method="post"
															action="${pageContext.request.contextPath}/adapter">
															<input type="hidden" name="serviceName" value="GetRole" />
															<input type="hidden" name="roleId" value="${current.roleId}" />
															<input
																type="image"
																src="${pageContext.request.contextPath}/__sys/img/details-16-16.png"
																alt="Details" title="Details" class="icon" />
														</form>
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
			</div>
		</div>
		<%@include file="/__sys/cmn/footer.jsp"%>
	</div>
</body>
</html>