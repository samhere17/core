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
		String header = "Search User";
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
						<input type="hidden" name="serviceName" value="SearchUser" />
						<div class="form-header">
							<img
								src="${pageContext.request.contextPath}/__sys/img/user-search-16-16.png"
								alt="Search User" title="Search User" />
							<h3>Search User</h3>
						</div>
						<div class="form-content">

							<c:if test="${umsSession.roleId == 1}">
								<fieldset class="first">
									<legend>Organization Selection</legend>
									<div class="fields-row">
										<div class="field-col">
											<label for="name">Organization Id</label> <input type="text"
												id="org-id" name="selectedOrgId" style="text-align: right;"
												readonly />
										</div>
										<div class="field-col">
											<label for="name">Organization Name</label> <input
												type="text" id="org-name" class="input-width-double"
												readonly />
										</div>
										<div class="field-col">
											<label for="name">&nbsp;</label> <input type="button"
												id="btn-org-lookup" value="Lookup" />
										</div>
									</div>
								</fieldset>
								<script type="text/javascript">
								$(document).ready(function() {
									$('#btn-org-lookup').click(function(){
										showDialog("orgs-dialog",false);
									});
									
									$("#close-org-dialog").click(function (e) {
										hideDialog("orgs-dialog");
										e.preventDefault();
									});
									
									$("#select-org").click(function(){
										var org = $('input[name=orgRadio]:checked').val();
										var arr = org.split(':');
										$("#org-id").val(arr[0]);
										$("#org-name").val(arr[1]);
										hideDialog("orgs-dialog");
									});
									
									$("#org-list-table").tablesorter({
										// pass the headers argument and assing a object 
										headers: {
											// assign the first column (we start counting zero)
											0: {
												// disable it by setting the property sorter to false
												sorter: false
											}
										},
										// sort on the second column(1), order asc(0) and first column(0), order asc(0)
										sortList: [[1,0]]
									});
								});
								</script>
								<div id="overlay" class="dialog-overlay"></div>
								<div id="orgs-dialog" class="dialog-window">
									<div class="dialog-header">
										<img
											src="${pageContext.request.contextPath}/__sys/img/org-16-16.png"
											alt="Organizations" />
										<h3>Organizations</h3>
										<a href="#" id="close-org-dialog"><img
											src="${pageContext.request.contextPath}/__sys/img/delete-16-16.png"
											alt="Close" title="Close" /></a>
									</div>
									<div class="dialog-content">
										<table id="org-list-table" class="table-sorter">
											<thead>
												<tr>
													<th style="width: 50px;">Select</th>
													<th style="width: 50px;">Id</th>
													<th>Name</th>
													<th style="width: 100px;">Status</th>
												</tr>
											</thead>
											<tbody>
												<c:choose>
													<c:when test="${not empty orgsListForLookup}">
														<c:forEach items="${orgsListForLookup}" var="curOrg">
															<tr>
																<td style="text-align: center;"><input type="radio"
																	name="orgRadio"
																	value="${curOrg.organizationId}:${curOrg.organizationName}" /></td>
																<td style="text-align: right;">${curOrg.organizationId}</td>
																<td>${curOrg.organizationName}</td>
																<td style="text-align: center;">${curOrg.organizationStatus}</td>
															</tr>
														</c:forEach>
													</c:when>
													<c:otherwise>
														<tr>
															<td colspan="4" style="text-align: center;">No
																organizations configured.</td>
														</tr>
													</c:otherwise>
												</c:choose>
											</tbody>
										</table>
									</div>
									<div class="dialog-actions">
										<input type="button" id="select-org" value="Select" />
									</div>
								</div>
							</c:if>

							<fieldset
								<c:if test="${umsSession.roleId != 1}">class="first"</c:if>>
								<legend>User Details</legend>
								<div class="fields-row">
									<div class="field-col">
										<label for="username">User Id</label> <input type="text"
											id="" name="userId" value="" />
									</div>
									<div class="field-col">
										<label for="username">Username</label> <input type="text"
											id="username" name="username" value="" />
									</div>
								</div>
								<div class="fields-row">
									<div class="field-col">
										<label for="firstname">First Name</label> <input type="text"
											id="firstname" name="firstname" value="" />
									</div>
									<div class="field-col">
										<label for="lastname">Last Name</label> <input type="text"
											id="lastname" name="lastname" value="" />
									</div>
									<div class="field-col">
										<label for="phone">Phone</label> <input type="text"
											name="phone" value="" />
									</div>
									<div class="field-col">
										<label for="email">Email</label> <input type="text"
											name="email" value="" />
										<c:if test="${not empty validation.emailError}">
											<div class="${validation.emailError.level}">${validation.emailError.message}</div>
										</c:if>
									</div>
								</div>
							</fieldset>
							<fieldset>
								<legend>Role Selection</legend>
								<div class="fields-row">
									<div class="field-col">
										<label for="name">Role Id</label> <input type="text"
											id="role-id" name="selectedRoleId" style="text-align: right;"
											readonly />
									</div>
									<div class="field-col">
										<label for="name">Role Name</label> <input type="text"
											id="role-name" readonly />
									</div>
									<div class="field-col">
										<label for="name">&nbsp;</label> <input type="button"
											id="btnLookup" value="Lookup" />
									</div>
								</div>
							</fieldset>
							<script type="text/javascript">
$(document).ready(function() {
	$('#btnLookup').click(function(){
		showDialog("roles-dialog",false);
	});
	
	$("#close-dialog").click(function (e) {
		hideDialog("roles-dialog");
		e.preventDefault();
	});
	
	$("#select-role").click(function(){
		var role = $('input[name=roleRadio]:checked').val();
		var arr = role.split(':');
		$("#role-id").val(arr[0]);
		$("#role-name").val(arr[1]);
		hideDialog("roles-dialog");
	});
	$("#role-list-table").tablesorter({
		// pass the headers argument and assing a object 
		headers: {
			// assign the first column (we start counting zero)
			0: {
				// disable it by setting the property sorter to false
				sorter: false
			}
		},
		// sort on the second column(1), order asc(0) and first column(0), order asc(0)
		sortList: [[1,0]]
	});
});
</script>

							<div id="overlay" class="dialog-overlay"></div>
							<div id="roles-dialog" class="dialog-window">
								<div class="dialog-header">
									<img
										src="${pageContext.request.contextPath}/__sys/img/role-16-16.gif"
										alt="Roles" />
									<h3>Roles</h3>
									<a href="#" id="close-dialog"><img
										src="${pageContext.request.contextPath}/__sys/img/delete-16-16.png"
										alt="Close" title="Close" /></a>
								</div>
								<div class="dialog-content">
									<table id="role-list-table" class="table-sorter">
										<thead>
											<tr>
												<th style="width: 50px;">Select</th>
												<th style="width: 50px;">Id</th>
												<th>Name</th>
												<th style="width: 100px;">Status</th>
											</tr>
										</thead>
										<tbody>
											<c:choose>
												<c:when test="${not empty rolesListForLookup}">
													<c:forEach items="${rolesListForLookup}" var="currentRole">
														<tr>
															<td style="text-align: center;"><input type="radio"
																name="roleRadio"
																value="${currentRole.roleId}:${currentRole.roleName}" /></td>
															<td style="text-align: right;">${currentRole.roleId}</td>
															<td>${currentRole.roleName}</td>
															<td style="text-align: center;">${currentRole.roleStatus}</td>
														</tr>
													</c:forEach>
												</c:when>
												<c:otherwise>
													<tr>
														<td colspan="10" style="text-align: center;">No roles
															configured.</td>
													</tr>
												</c:otherwise>
											</c:choose>
										</tbody>
									</table>
								</div>
								<div class="dialog-actions">
									<input type="button" id="select-role" value="Select" />
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
										<th>Address</th>
										<th>Contact</th>
										<th style="width: 9px;"></th>
									</tr>
								</thead>
								<tbody>
									<c:choose>
										<c:when test="${not empty usersList}">
											<c:forEach items="${usersList}" var="current">
												<tr>
													<td>${current.userId}</td>
													<td>${current.userFirstName} ${current.userLastName} <c:if test="${not empty current.userAlias}"> (${current.userAlias})</c:if></td>
													<td>${current.address}</td>
													<td>
														<c:if test="${not empty current.primaryPhone}">
															<img alt="Phone" src="${pageContext.request.contextPath}/__sys/img/phone-16-16.png">${current.primaryPhone}<br>
														</c:if>
														<c:if test="${not empty current.alternatePhone}">
															<img alt="Phone" src="${pageContext.request.contextPath}/__sys/img/phone-16-16.png">${current.alternatePhone}<br>
														</c:if>
														<c:if test="${not empty current.primaryEmail}">
															<img alt="Phone" src="${pageContext.request.contextPath}/__sys/img/mail-16-16.png">${current.primaryEmail}<br>
														</c:if>
														<c:if test="${not empty current.alternateEmail}">
															<img alt="Phone" src="${pageContext.request.contextPath}/__sys/img/mail-16-16.png">${current.alternateEmail}
														</c:if>
													</td>
													<td>
														<form method="post"
															action="${pageContext.request.contextPath}/adapter">
															<input type="hidden" name="serviceName" value="GetUser" />
															<input type="hidden" name="userId"
																value="${current.userId}" /> <input type="image"
																src="${pageContext.request.contextPath}/__sys/img/details-16-16.png"
																alt="Details" title="Details" class="icon" />
														</form>
													</td>
												</tr>
											</c:forEach>
										</c:when>
										<c:otherwise>
											<tr>
												<td colspan="5" style="text-align: center;">No users found.</td>
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