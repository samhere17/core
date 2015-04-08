<%@page import="org.iq.util.StringUtil"%>
<%@page import="org.iq.valueobject.ums.UmsRegistrationResult"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:set var="browserURL" value="${pageContext.request.requestURI}" scope="session"></c:set>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
		<title>Core Application::iquesters</title>
		<%@include file="/__sys/cmn/scripts.jsp"%>
		<%@include file="/__sys/cmn/styles.jsp"%>
	</head>
	<body> <!-- style="background: none;" -->
	<%
		UmsRegistrationResult umsRegistrationResult = (UmsRegistrationResult) request
				.getAttribute("umsRegistrationResult");
		boolean showError = false;
		if (umsRegistrationResult != null) {
			showError = true;
		}
	%>

	<div class="form-container" style="width: 535px; margin: 10px auto;">
			<form method="post" action="${pageContext.request.contextPath}/adapter">
				<input type="hidden" name="serviceName" value="Registration" />
				<!-- <input type="hidden" name="error-url" value="ums/register.jsp" />
				<input type="hidden" name="success-url" value="index.jsp" /> -->
				<input type="hidden" name="registrationType" value="system" />
				<div class="form-header">
					<img src="${pageContext.request.contextPath}/__sys/img/register-16-16.png" alt="Registration" title="Registration"/>
					<h3>Administrator Registration</h3>
				</div>
				<div class="form-content">
					<fieldset class="first">
						<legend>Admin Details</legend>
						<div class="fields-row">
							<div class="field-col">
								<label for="firstname">First Name</label>
								<input type="text" id="firstname" name="firstname" value="" required />
								<%if(showError && StringUtil.isEmpty(umsRegistrationResult.getFirstnameValidationError())==false) {%>
								<div class="-iq-error"><%=umsRegistrationResult.getFirstnameValidationError()%></div>
								<%}%>
							</div>
							<div class="field-col">
								<label for="lastname">Last Name</label>
								<input type="text" id="lastname" name="lastname" value="" required />
								<%if(showError && StringUtil.isEmpty(umsRegistrationResult.getLastnameValidationError())==false) {%>
								<div class="-iq-error"><%=umsRegistrationResult.getLastnameValidationError()%></div>
								<%}%>
							</div>
							<div class="field-col">
								<label for="alias">Alias (Nickname)</label>
								<input type="text" id="alias" name="alias" value="" />
							</div>
						</div>
						<div class="fields-row">
							<div class="field-col">
								<label for="address">Address</label>
								<textarea name="address"></textarea>
							</div>
							<div class="multi-row-col">
								<div class="field-col">
									<label for="phone">Phone</label>
									<input type="text" name="phone" value="" required/>
									<%if(showError && StringUtil.isEmpty(umsRegistrationResult.getPhoneValidationError())==false) {%>
									<div class="-iq-error"><%=umsRegistrationResult.getPhoneValidationError()%></div>
									<%}%>
								</div>
								<div class="field-col">
									<label for="alt-phone">Alternate Phone</label>
									<input type="text" name="altPhone" value="" />
								</div>
							</div>
							<div class="multi-row-col">
								<div class="field-col">
									<label for="email">Email</label>
									<input type="text" name="email" value="" required/>
									<%if(showError && StringUtil.isEmpty(umsRegistrationResult.getEmailValidationError())==false) {%>
									<div class="-iq-error"><%=umsRegistrationResult.getEmailValidationError()%></div>
									<%}%>
								</div>
								<div class="field-col">
									<label for="alt-email">Alternate Email</label>
									<input type="text" name="altEmail" value="" />
								</div>
							</div>
						</div>
						<div class="fields-row">
							<div class="field-col">
								<label for="gender">Gender</label>
								<select id="gender" name="gender" class="-iq-gender-input" >
									<option value="-1">--select--</option>
									<option value="0">Male</option>
									<option value="1">Female</option>
									<option value="2">Other</option>
								</select>
							</div>
							<div class="field-col">
								<label for="birth-day">Birthday</label>
								<input type="date" id="birth-day" name="birthday" value="" />
							</div>
							<div class="field-col">
								<label for="anniversary">Anniversary</label>
								<input type="date" id="anniversary" name="anniversary" value="" />
							</div>
						</div>
						</fieldset>
						<fieldset>
							<legend>Login Credentials</legend>
							<div class="fields-row">
								<div class="field-col">
									<label for="username">Username</label>
									<input type="text" id="username" name="username" value="" required />
									<%if(showError && StringUtil.isEmpty(umsRegistrationResult.getUsernameValidationError())==false) {%>
									<div class="-iq-error"><%=umsRegistrationResult.getUsernameValidationError()%></div>
									<%}%>
								</div>
								<div class="field-col">
									<label for="password">Password</label>
									<input type="password" id="password" name="password" value="" required />
								</div>
								<div class="field-col">
									<label for="cpassword">Confirm Password</label>
									<input type="password" id="cpassword" name="cpassword" value="" required />
								</div>
							</div>
						</fieldset>
					<div class="clear"></div>
				</div>
				<div class="form-actions">
					<input type="submit" id="" value="Register Admin" />
				</div>
			</form>
		</div>
	</body>
</html>