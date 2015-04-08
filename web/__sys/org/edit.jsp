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
		String header = "Edit Organization";
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
				<input type="hidden" name="serviceName" value="UpdateOrganization" />
						<div class="form-header">
							<img src="${pageContext.request.contextPath}/__sys/img/org-16-16.png" alt="Edit Organization" title="Edit Organization" />
							<h3>Organization Details</h3>
						</div>
						<div class="form-content">
								<div class="fields-row">
									<div class="field-col">
										<label for="orgId">Organization ID</label>
										<input type="text" id="org-id" name="orgId" value="${organization.organizationId}" readonly />
									</div>
									<%-- <div class="field-col">
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
									</div> --%>
								</div>
								<div class="fields-row">
									<div class="field-col">
										<label for="orgStatus">Status</label>
										<input type="text" id="org-status" name="orgStatus" value="${organization.organizationStatus}" readonly />
									</div>
									<%-- <div class="field-col">
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
									</div> --%>
								</div>
								<div class="fields-row">
									<div class="field-col">
										<label for="orgName">Organization Name</label>
										<input type="text" id="orgName" name="orgName" value="${organization.organizationName}" class="input-width-double" />
									</div>
									<div class="field-col">
										<label for="alias">Organization Alias</label>
										<input type="text" id="alias" name="orgAlias" value="${organization.organizationAlias}" />
									</div>
								</div>
								<div class="fields-row">
									<div class="field-col">
										<label for="orgAddress1">Address Line 1</label>
										<input type="text" id="orgAddress1" name="orgAddress1" value="${organization.organizationAddress1}" class="input-width-double" />
									</div>
								</div>
								<div class="fields-row">
									<div class="field-col">
										<label for="address2">Address Line 2</label>
										<input type="text" id="address2" name="orgAddress2" value="${organization.organizationAddress2}" class="input-width-double" />
									</div>
									<div class="field-col">
										<label for="phone">Primary Phone</label>
										<input type="text" id="phone" name="orgPhone" value="${organization.organizationPrimaryPhone}" />
									</div>
									<div class="field-col">
										<label for="alterPhone">Alternate Phone</label>
										<input type="text" id="alterPhone" name="orgAltPhone" value="${organization.organizationAlternatePhone}"  />
									</div>
								</div>
								<div class="fields-row">
									<div class="field-col">
										<label>City</label>
										<input type="text" id="org-city" name="orgCity" value="${organization.organizationCity}"  />
									</div>
									<div class="field-col">
										<label>District</label>
										<input type="text" id="org-district" name="orgDistrict" value="${organization.organizationDistrict}"  />
									</div>
									<div class="field-col">
										<label>Primary Fax</label>
										<input type="text" id="org-fax" name="orgFax" value="${organization.organizationPrimaryFax}"  />
									</div>
									<div class="field-col">
										<label>Alternate Fax</label>
										<input type="text" id="org-alt-fax" name="orgAltFax" value="${organization.organizationAlternateFax}"  />
									</div>
								</div>
								<div class="fields-row">
									<div class="field-col">
										<label>State</label>
										<input type="text" id="org-state" name="orgState"  value="${organization.organizationState}"  />
									</div>
									<div class="field-col">
										<label>Country</label>
										<input type="text" id="org-country" name="orgCountry" value="${organization.organizationCountry}"  />
									</div>
									<div class="field-col">
										<label>Primary Email</label>
										<input type="text" id="org-email" name="orgEmail" value="${organization.organizationPrimaryEmail}"  />
									</div>
									<div class="field-col">
										<label>Alternate Email</label>
										<input type="text" id="org-alt-email" name="orgAltEmail" value="${organization.organizationAlternateEmail}"  />
									</div>
								</div>
								<div class="fields-row">
									<div class="field-col">
										<label>PIN</label>
										<input type="text" id="org-pin" name="orgPin" value="${organization.organizationPin}"  />
									</div>
								</div>
							<div class="clear"></div>
						</div>
						<div class="form-actions">
							<input type="submit" id="" value="Update Organization" />
						</div>
					</form>
				</div>

			</div>
		</div>
		<%@include file="/__sys/cmn/footer.jsp"%>
	</div>
</body>
</html>