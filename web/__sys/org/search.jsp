<%@page import="org.iq.Constants.OrganizationStatus"%>
<%@page import="java.util.Date"%>
<%@page import="org.iq.util.DateUtil.DateFormat"%>
<%@page import="org.iq.util.DateUtil"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:set var="browserURL" value="${pageContext.request.requestURI}"
	scope="session"></c:set>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<title>OMS::iquesters</title>
<%@include file="/__sys/cmn/scripts.jsp"%>
<%@include file="/__sys/cmn/styles.jsp"%>
</head>
<body>
	<%
		String header = "Search Organization";
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
						<input type="hidden" name="serviceName" value="SearchOrganization" />
						<div class="form-header">
							<img src="${pageContext.request.contextPath}/__sys/img/org-16-16.png" alt="New Organization" title="New Organization" />
							<h3>Search Organization</h3>
							<a href=""><img src="${pageContext.request.contextPath}/__sys/img/help.png" alt="Help" title="Help" /></a>
						</div>
						<div class="form-content">
							<div class="fields-row">
								<div class="field-col">
									<label for="orgId">Organization ID</label>
									<input type="text" id="org-id" name="orgId" value=""  />
								</div>
								<div class="field-col">
									<label>Status</label>
									<select id="org-status" name="orgStatus">
										<option value="-9999">--select--</option>
										<%
											for (OrganizationStatus organizationStatus : OrganizationStatus
													.values()) {
										%>
										<option
											value="<%=organizationStatus.getOrganizationStatusValue()%>"><%=organizationStatus.toString()%></option>
										<%
											}
										%>
									</select>
								</div>
							</div>
							<div class="fields-row">
								<div class="field-col">
									<label for="name">Organization Name</label>
									<input type="text" id="org-name" name="orgName" value="" class="input-width-double" />
								</div>
								<div class="field-col">
									<label for="alias">Organization Alias</label>
									<input type="text" id="org-alias" name="orgAlias" value="" />
								</div>
							</div>
							<div class="fields-row">
								<div class="field-col">
									<label for="phone">Primary Phone</label>
									<input type="text" id="org-phone" name="orgPhone" value="" />
								</div>
								<div class="field-col">
									<label>Primary Fax</label>
									<input type="text" id="org-fax"	name="orgFax" value="" />
								</div>
								<div class="field-col">
									<label for="email">Primary Email</label>
									<input type="text" id="org-email" name="orgEmail" value="" />
								</div>
							</div>
							<div class="clear"></div>
						</div>
						<div class="form-actions">
							<input type="submit" id="" value="Search" />
						</div>
					</form>
				</div>
				
				
				<c:if test="${not empty organizationList}">
					<div class="form-container">
						<div class="form-header">
							<img src="${pageContext.request.contextPath}/__sys/img/org-16-16.png" alt="New Organization" title="New Organization" />
							<h3>Search Result</h3>
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
												<input type="hidden" name="orgId" value="${current.organizationId}" />
												<input type="image" src="${pageContext.request.contextPath}/__sys/img/details-16-16.png" alt="Details" title="Details" class="icon" />
											</form>
										</td>
									</tr>
								</c:forEach>
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