<%@page import="com.iq.valueobject.organization.Organization"%>
<%@page import="java.util.List"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:set var="browserURL" value="${pageContext.request.requestURI}" scope="session"></c:set>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<title>OMS::iquesters</title>
<%@include file="/__sys/cmn/styles.jsp"%>
<%@include file="/__sys/cmn/scripts.jsp"%>

<script type="text/javascript">
$(document).ready(function() {
	$("#list-table").tablesorter({
		// pass the headers argument and assing a object 
		headers: {
		// assign the fourth column (we start counting zero)
		3: {
			// disable it by setting the property sorter to false
			sorter: false
		},
		// assign the fifth column (we start counting zero)
		4: {
			// disable it by setting the property sorter to false
			sorter: false
		},
		// assign the sixth column (we start counting zero)
		5: {
			// disable it by setting the property sorter to false
			sorter: false
		}
	},
	// sort on the second column(1), order asc(0) and first column(0), order asc(0)
	sortList: [[0,0]] 
});
}); 
</script>

</head>
<body>
	<%
		String header = "Organization List";
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
						<img src="${pageContext.request.contextPath}/__sys/img/org-16-16.png" alt="New Organization" title="New Organization" />
						<h3>Organization List</h3>
					</div>
					<div class="form-content">
						<table id="list-table" class="table-sorter">
					<thead>
						<tr>
							<th>Id</th>
							<th>Name</th>
							<th>Status</th>
							<th>Address</th>
							<th>Contact</th>
							<th></th>
						</tr>
					</thead>
					<tbody>

						<c:forEach items="${organizationList}" var="current">
							<tr>
								<td>${current.organizationId}</td>
								<td>${current.organizationName}</td>
								<td>${current.organizationStatus}</td>
								<td>
									${current.organizationAddress1}<br>
									${current.organizationAddress2}<br>
									${current.organizationCity} ${current.organizationDistrict}<br>
									${current.organizationState} ${current.organizationCountry}<br>
									PIN - ${current.organizationPin}
								</td>
								<td>
									<c:if test="${not empty current.organizationPrimaryPhone}">
										<img alt="Phone" src="${pageContext.request.contextPath}/__sys/img/phone-16-16.png">${current.organizationPrimaryPhone}<br>
									</c:if>
									<c:if test="${not empty current.organizationAlternatePhone}">
										<img alt="Phone" src="${pageContext.request.contextPath}/__sys/img/phone-16-16.png">${current.organizationAlternatePhone}<br>
									</c:if>
									<c:if test="${not empty current.organizationPrimaryFax}">
										<img alt="Phone" src="${pageContext.request.contextPath}/__sys/img/fax-16-16.png">${current.organizationPrimaryFax}<br>
									</c:if>
									<c:if test="${not empty current.organizationAlternateFax}">
										<img alt="Phone" src="${pageContext.request.contextPath}/__sys/img/fax-16-16.png">${current.organizationAlternateFax}<br>
									</c:if>
									<c:if test="${not empty current.organizationPrimaryEmail}">
										<img alt="Phone" src="${pageContext.request.contextPath}/__sys/img/mail-16-16.png">${current.organizationPrimaryEmail}<br>
									</c:if>
									<c:if test="${not empty current.organizationAlternateEmail}">
										<img alt="Phone" src="${pageContext.request.contextPath}/__sys/img/mail-16-16.png">${current.organizationAlternateEmail}
									</c:if>
								</td>
								<td>
									<form method="post"
										action="${pageContext.request.contextPath}/adapter">
										<input type="hidden" name="serviceName" value="GetOrganization" />
										<input type="hidden" name="opt-id" value="${current.organizationId}" />
										<input type="image" src="${pageContext.request.contextPath}/__sys/img/details-16-16.png" alt="Details" title="Details" class="icon" />
									</form>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
					</div>
				</div>
			</div>
		</div>
		<%@include file="/__sys/cmn/footer.jsp"%>
	</div>
</body>
</html>