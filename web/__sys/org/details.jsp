<%@page import="java.util.Date"%>
<%@page import="org.iq.util.DateUtil.DateFormat"%>
<%@page import="org.iq.util.DateUtil"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="browserURL" value="${pageContext.request.requestURI}"
	scope="session"></c:set>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<title>OMS::iquesters</title>
<%@include file="/__sys/cmn/styles.jsp"%>
<%@include file="/__sys/cmn/scripts.jsp"%>
</head>
<body>
	<%
		String header = "New Organization";
	%>
	<div class="wrapper">
		<%@include file="/__sys/cmn/header.jsp"%>
		<%@include file="/__sys/cmn/menu.jsp"%>

		<div class="bodycontent">
			<div class="toolboxarea">
				<%@include file="/__sys/cmn/toolbox.jsp"%>
			</div>
			<div class="workarea">
				<c:if test="${not empty organization}">
				</c:if>

				<div class="form-container">
						<div class="form-header">
							<img src="${pageContext.request.contextPath}/__sys/img/org-16-16.png" alt="New Organization" title="New Organization" />
							<h3>Organization Details</h3>
						</div>
						<div class="form-content">
								<div class="fields-row">
									<div class="field-col">
										<label for="orgId">Organization ID</label>
										<input type="text" value="${organization.organizationId}" readonly />
									</div>
									<div class="field-col">
										<label for="creationTime">Creation Date</label>
										<input type="text" value="<fmt:formatDate type="date" value="${organization.organizationCreation}" />" readonly />
									</div>
									<div class="field-col">
										<label for="creationTime">Creation Time</label>
										<input type="text" value="<fmt:formatDate type="time" value="${organization.organizationCreation}" />" readonly />
									</div>
									<div class="field-col">
										<label for="userId">Created By</label>
										<input type="text" value="${organization.organizationCreatedBy}" readonly />
									</div>
								</div>
								<div class="fields-row">
									<div class="field-col">
										<label for="orgId">Status</label>
										<input type="text" value="${organization.organizationStatus}" readonly />
									</div>
									<div class="field-col">
										<label for="creationTime">Last Updated Date</label>
										<input type="text" value="<fmt:formatDate type="date" value="${organization.organizationUpdated}" />" readonly />
									</div>
									<div class="field-col">
										<label for="creationTime">Last Updated Time</label>
										<input type="text" value="<fmt:formatDate type="time" value="${organization.organizationUpdated}" />" readonly />
									</div>
									<div class="field-col">
										<label for="userId">Last Updated By</label>
										<input type="text" value="${organization.organizationUpdatedBy}" readonly />
									</div>
								</div>
								<div class="fields-row">
									<div class="field-col">
										<label for="name">Organization Name</label>
										<input type="text" value="${organization.organizationName}" readonly class="input-width-double" />
									</div>
									<div class="field-col">
										<label for="alias">Organization Alias</label>
										<input type="text" value="${organization.organizationAlias}" readonly />
									</div>
								</div>
								<div class="fields-row">
									<div class="field-col">
										<label for="address1">Address Line 1</label>
										<input type="text" value="${organization.organizationAddress1}" readonly class="input-width-double" />
									</div>
								</div>
								<div class="fields-row">
									<div class="field-col">
										<label for="address2">Address Line 2</label>
										<input type="text" value="${organization.organizationAddress2}" readonly class="input-width-double" />
									</div>
									<div class="field-col">
										<label for="phone">Primary Phone</label>
										<input type="text" value="${organization.organizationPrimaryPhone}" readonly />
									</div>
									<div class="field-col">
										<label for="alterPhone">Alternate Phone</label>
										<input type="text" value="${organization.organizationAlternatePhone}" readonly />
									</div>
								</div>
								<div class="fields-row">
									<div class="field-col">
										<label>City</label>
										<input type="text" value="${organization.organizationCity}" readonly />
									</div>
									<div class="field-col">
										<label>District</label>
										<input type="text" value="${organization.organizationDistrict}" readonly />
									</div>
									<div class="field-col">
										<label>Primary Fax</label>
										<input type="text" value="${organization.organizationPrimaryFax}" readonly />
									</div>
									<div class="field-col">
										<label>Alternate Fax</label>
										<input type="text" value="${organization.organizationAlternateFax}" readonly />
									</div>
								</div>
								<div class="fields-row">
									<div class="field-col">
										<label>State</label>
										<input type="text" value="${organization.organizationState}" readonly />
									</div>
									<div class="field-col">
										<label>Country</label>
										<input type="text" value="${organization.organizationCountry}" readonly />
									</div>
									<div class="field-col">
										<label>Primary Email</label>
										<input type="text" value="${organization.organizationPrimaryEmail}" readonly />
									</div>
									<div class="field-col">
										<label>Alternate Email</label>
										<input type="text" value="${organization.organizationAlternateEmail}" readonly />
									</div>
								</div>
								<div class="fields-row">
									<div class="field-col">
										<label>PIN</label>
										<input type="text" value="${organization.organizationPin}" readonly />
									</div>
								</div>
							<div class="clear"></div>
						</div>
						<div class="form-actions">
						</div>
				</div>

			</div>
		</div>
		<%@include file="/__sys/cmn/footer.jsp"%>
	</div>
</body>
</html>