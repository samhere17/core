<%@page import="java.util.Date"%>
<%@page import="org.iq.util.DateUtil.DateFormat"%>
<%@page import="org.iq.util.DateUtil"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:set var="browserURL" value="${pageContext.request.requestURI}" scope="session"></c:set>

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
				<div class="form-container">
					<form method="post" action="${pageContext.request.contextPath}/adapter">
						<input type="hidden" name="serviceName" value="InsertOrganization" />
						<div class="form-header">
							<img src="${pageContext.request.contextPath}/__sys/img/org-16-16.png" alt="New Organization" title="New Organization" />
							<h3>New Organization</h3>
							<a href=""><img src="${pageContext.request.contextPath}/__sys/img/help.png" alt="Help" title="Help"/></a>
						</div>
						<div class="form-content">
							<fieldset class="first">
								<legend>Organization Details</legend>
								<%-- <div class="fields-row">
									<div class="field-col">
										<label for="orgId">Organization ID</label>
										<input type="text" value="" readonly/>
									</div>
									<div class="field-col">
										<label for="creationTime">Creation Date</label>
										<input type="text" id="creationTime" name="creationTime" value="<%=DateUtil.dateToString(new Date(), DateFormat.MMM_dd_yyyy)%>" readonly/>
									</div>
									<div class="field-col">
										<label for="creationTime">Creation Time</label>
										<input type="text" id="creationTime" name="creationTime" value="<%=DateUtil.dateToString(new Date(), DateFormat.HH_mm_ss_SSS)%>" readonly/>
									</div>
									<div class="field-col">
										<label for="userId">Created By</label>
										<input type="text" id="userId" name="userId" value="" readonly/>
									</div>
								</div> --%>
								<div class="fields-row">
									<div class="field-col">
										<label for="name">Organization Name</label>
										<input type="text" id="org-name" name="orgName" value="" required class="input-width-double" />
										<div class="field-info-container">
											<div class="field-info">
												<div class="info-content">This is generally a Company or Organization name.</div>
											</div>
										</div>
									</div>
									<div class="field-col">
										<label for="alias">Organization Alias</label>
										<input type="text" id="org-alias" name="orgAlias"  value="" />
									</div>
								</div>
								<div class="fields-row">
									<div class="field-col">
										<label for="address1">Address Line 1</label>
										<input type="text" id="org-address1" name="orgAddress1"  value="" required class="input-width-double"/>
									</div>
								</div>
								<div class="fields-row">
									<div class="field-col">
										<label for="address2">Address Line 2</label>
										<input type="text" id="org-address2" name="orgAddress2" value="" class="input-width-double"/>
									</div>
									<div class="field-col">
										<label for="phone">Primary Phone</label>
										<input type="text" id="org-phone" name="orgPhone" value="" required/>
									</div>
									<div class="field-col">
										<label for="alterPhone">Alternate Phone</label>
										<input type="text" id="org-alt-phone" name="orgAltPhone" value="" />
									</div>
								</div>
								<div class="fields-row">
									<div class="field-col">
										<label>City</label>
										<input type="text" id="org-city" name="orgCity" value="" />
									</div>
									<div class="field-col">
										<label>District</label>
										<input type="text" id="org-district" name="orgDistrict" value="" />
									</div>
									<div class="field-col">
										<label>Primary Fax</label>
										<input type="text" id="org-fax" name="orgFax" value="" />
									</div>
									<div class="field-col">
										<label for="alterFax">Alternate Fax</label>
										<input type="text" id="org-alt-fax" name="orgAltFax" value="" />
									</div>
								</div>
								<div class="fields-row">
									<div class="field-col">
										<label for="state">State</label>
										<input type="text" id="org-state" name="orgState" value="" required/>
									</div>
									<div class="field-col">
										<label for="country">Country</label>
										<input type="text" id="org-country" name="orgCountry" value="" />
									</div>
									<div class="field-col">
										<label for="email">Primary Email</label>
										<input type="text" id="org-email" name="orgEmail" value="" required/>
									</div>
									<div class="field-col">
										<label for="alterEmail">Alternate Email</label>
										<input type="text" id="org-alt-email" name="orgAltEmail" value="" />
									</div>
								</div>
								<div class="fields-row">
									<div class="field-col">
										<label for="pin">PIN</label>
										<input type="text" id="org-pin" name="orgPin" value="" maxlength="6" required/>
									</div>
								</div>
							</fieldset>

							<!-- <fieldset>
								<legend>Contact Details</legend>
								<div class="fields-row">
									<div class="field-col">
										<label for="name">Contact Title</label>
										<select id="gender" name="gender" class="-iq-gender-input" >
											<option value="-1">--select--</option>
											<option value="0">Mr</option>
											<option value="1">Ms</option>
											<option value="2">Mrs</option>
										</select>
									</div>
									<div class="field-col">
										<label for="name">Contact First Name</label>
										<input type="text" value="" required/>
									</div>
									<div class="field-col">
										<label for="name">Contact Middle Name</label>
										<input type="text" value="" />
									</div>
									<div class="field-col">
										<label for="name">Contact Last Name</label>
										<input type="text" value="" required/>
									</div>
								</div>
								<div class="fields-row">
									<div class="field-col">
										<label for="name">Contact Preferred Name</label>
										<input type="text" value="" />
									</div>
								</div>
								<div class="fields-row">
									<div class="field-col">
										<label for="name">Address Line 1</label>
										<input type="text" value="" required class="input-width-double"/>
									</div>
								</div>
								<div class="fields-row">
									<div class="field-col">
										<label for="name">Address Line 2</label>
										<input type="text" value="" class="input-width-double"/>
									</div>
									<div class="field-col">
										<label for="name">Contact Phone</label>
										<input type="text" value="" required/>
									</div>
									<div class="field-col">
										<label for="name">Contact Alternate Phone</label>
										<input type="text" value="" />
									</div>
								</div>
								<div class="fields-row">
									<div class="field-col">
										<label for="name">City</label>
										<input type="text" value="" />
									</div>
									<div class="field-col">
										<label for="name">District</label>
										<input type="text" value="" />
									</div>
								</div>
								<div class="fields-row">
									<div class="field-col">
										<label for="name">State</label>
										<input type="text" value="" required/>
									</div>
									<div class="field-col">
										<label for="name">Country</label>
										<input type="text" value="" />
									</div>
									<div class="field-col">
										<label for="name">Contact Email</label>
										<input type="text" value="" required/>
									</div>
									<div class="field-col">
										<label for="name">Contact Alternate Email</label>
										<input type="text" value="" />
									</div>
								</div>
								<div class="fields-row">
									<div class="field-col">
										<label for="name">PIN</label>
										<input type="text" value="" required/>
									</div>
								</div>
							</fieldset> -->
								
							<div class="clear"></div>
						</div>
						<div class="form-actions">
							<input type="submit" id="" value="Save Organization" />
						</div>
					</form>
				</div>
				
			</div>
		</div>
		<%@include file="/__sys/cmn/footer.jsp"%>
	</div>
</body>
</html>