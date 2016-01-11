<form method="post" action="${pageContext.request.contextPath}/adapter">
	<input type="hidden" name="serviceName" value="Registration">
	<input type="hidden" name="remote_addr" value="<%=request.getRemoteAddr()%>">
	<div class="panel panel-info">
		<div class="panel-heading">
			<div class="panel-title">Register</div>
		</div>

		<div class="panel-body">
			<div class="row">
				<div class="col-md-4">
					<div class="form-group has-feedback">
						<label class="control-label" for="first-name">First Name</label>
						<input class="form-control input-sm" type="text" id="first-name" name="firstname" required data-toggle="tooltip" data-placement="auto" title="">

						<span class="glyphicon glyphicon-ok form-control-feedback hidden"></span>
						<span class="glyphicon glyphicon-remove form-control-feedback hidden"></span>

						<%-- Validation error message --%>
						<p class="error-msg text-danger small hidden">
							<strong>Enter your first name</strong>
						</p>

						<%-- Error message from server --%>
						<c:if test="${not registrationResult.registrationSuccess}">
							<p class="error-msg-from-svr text-danger small">
								<strong>${registrationResult.firstnameValidationError}</strong>
							</p>
						</c:if>
					</div>
				</div>

				<div class="col-md-4">
					<div class="form-group has-feedback">
						<label class="control-label" for="last-name">Last Name</label>
						<input class="form-control input-sm" type="text" id="last-name" name="lastname" required data-toggle="tooltip" data-placement="auto" title="">

						<span class="glyphicon glyphicon-ok form-control-feedback hidden"></span>
						<span class="glyphicon glyphicon-remove form-control-feedback hidden"></span>

						<%-- Validation error message --%>
						<p class="error-msg text-danger small hidden">
							<strong>Enter your last name</strong>
						</p>

						<%-- Error message from server --%>
						<c:if test="${not registrationResult.registrationSuccess}">
							<p class="error-msg-from-svr text-danger small">
								<strong>${registrationResult.lastnameValidationError}</strong>
							</p>
						</c:if>
					</div>
				</div>


				<div class="col-md-4">
					<div class="form-group has-feedback">
						<label class="control-label" for="gender">Gender</label>
						<br>
						<div class="btn-group" data-toggle="buttons">
							<label class="btn btn-default btn-sm">
								<input class="form-control" type="radio" name="gender" required value="0"> Male
							</label>

							<label class="btn btn-default btn-sm">
								<input class="form-control" type="radio" name="gender" required value="1"> Female
							</label>

							<label class="btn btn-default btn-sm">
								<input class="form-control" type="radio" name="gender" required value="2"> Other
							</label>
						</div>
					</div>
				</div>
			</div>

			<div class="row">
				<div class="col-md-4">
					<div class="form-group has-feedback">
						<label class="control-label" for="user-name">Username</label>
						<input class="form-control input-sm" type="text" id="user-name" name="username" required>

						<span class="glyphicon glyphicon-ok form-control-feedback hidden"></span>
						<span class="glyphicon glyphicon-remove form-control-feedback hidden"></span>

						<%-- Validation error message --%>
						<p class="error-msg text-danger small hidden">
							<strong>Choose a username</strong>
						</p>

						<%-- Error message from server --%>
						<c:if test="${not registrationResult.registrationSuccess}">
							<p class="error-msg-from-svr text-danger small">
								<strong>${registrationResult.usernameValidationError}</strong>
							</p>
						</c:if>
					</div>
				</div>

				<div class="col-md-4">
					<div class="form-group has-feedback">
						<label class="control-label" for="password">Password</label>
						<input class="form-control input-sm" type="password" id="password" name="password" required>

						<span class="glyphicon glyphicon-ok form-control-feedback hidden"></span>
						<span class="glyphicon glyphicon-remove form-control-feedback hidden"></span>

						<%-- Validation error message --%>
						<p class="error-msg text-danger small hidden">
							<strong>Enter your super secret password ;)</strong>
						</p>

						<%-- Error message from server --%>
						<c:if test="${not registrationResult.registrationSuccess}">
							<p class="error-msg-from-svr text-danger small">
								<strong>${hasError.message}</strong>
							</p>
						</c:if>
					</div>
				</div>

				<div class="col-md-4">
					<div class="form-group has-feedback">
						<label class="control-label" for="cpassword">Confirm Password</label>
						<input class="form-control input-sm" type="password" id="cpassword" name="cpassword" required>

						<span class="glyphicon glyphicon-ok form-control-feedback hidden"></span>
						<span class="glyphicon glyphicon-remove form-control-feedback hidden"></span>

						<%-- Validation error message --%>
						<p class="error-msg text-danger small hidden">
							<strong>Enter your password again</strong>
						</p>

						<%-- Error message from server --%>
						<c:if test="${not registrationResult.registrationSuccess}">
							<p class="error-msg-from-svr text-danger small">
								<strong>${registrationResult.confirmPasswordValidationError}</strong>
							</p>
						</c:if>
					</div>
				</div>
			</div>

			<div class="row">
				<div class="col-md-4">
					<div class="form-group has-feedback">
						<label class="control-label" for="phone">Phone</label>
						<input class="form-control input-sm" type="tel" id="phone" name="phone" required maxlength="14">

						<span class="glyphicon glyphicon-ok form-control-feedback hidden"></span>
						<span class="glyphicon glyphicon-remove form-control-feedback hidden"></span>

						<%-- Validation error message --%>
						<p class="error-msg text-danger small hidden">
							<strong>Enter your phone number</strong>
						</p>

						<%-- Error message from server --%>
						<c:if test="${not registrationResult.registrationSuccess}">
							<p class="error-msg-from-svr text-danger small">
								<strong>${registrationResult.phoneValidationError}</strong>
							</p>
						</c:if>
					</div>
				</div>

				<div class="col-md-4">
					<div class="form-group has-feedback">
						<label class="control-label" for="email">Email</label>
						<input class="form-control input-sm" type="text" name="email" required>

						<span class="glyphicon glyphicon-ok form-control-feedback hidden"></span>
						<span class="glyphicon glyphicon-remove form-control-feedback hidden"></span>

						<%-- Validation error message --%>
						<p class="error-msg text-danger small hidden">
							<strong>Enter your email address</strong>
						</p>

						<%-- Error message from server --%>
						<c:if test="${not registrationResult.registrationSuccess}">
							<p class="error-msg-from-svr text-danger small">
								<strong>${registrationResult.emailValidationError}</strong>
							</p>
						</c:if>
					</div>
				</div>

				<div class="col-md-4">
					<div class="form-group has-feedback">
						<label class="control-label" class="control-label" for="birth-day">Birthday</label>
						<input class="form-control input-sm" type="date" id="birth-day" name="birthday" required>

						<span class="glyphicon glyphicon-ok form-control-feedback hidden"></span>
						<span class="glyphicon glyphicon-remove form-control-feedback hidden"></span>

						<%-- Validation error message --%>
						<p class="error-msg text-danger small hidden">
							<strong>Enter your birthday</strong>
						</p>

						<%-- Error message from server --%>
						<c:if test="${not registrationResult.registrationSuccess}">
							<p class="error-msg-from-svr text-danger small">
								<strong>${registrationResult.dateOfBirthValidationError}</strong>
							</p>
						</c:if>
					</div>
				</div>
			</div>

			<%-- Start of Captcha --%>
			<div class="row">
				<div id="recaptcha_widget" style="display: none">
					<div class="col-sm-8">
						<script>
							var RecaptchaOptions = {
								theme: 'custom',
								custom_theme_widget: 'recaptcha_widget'
							}
						</script>

						<div class="form-group">
							<label class="control-label recaptcha_only_if_image">Enter what you see:</label>
							<label class="control-label recaptcha_only_if_audio">Enter what you hear:</label>

							<div style="background-color: #eee; padding: 10px;">
								<div>
									<div style="display: inline-block;" id="recaptcha_image" class="recaptcha_image">

									</div>

									<div style="display: inline-block">
										<div>
											<a href="javascript:Recaptcha.reload()" title="Try another">
												<span class="fa fa-refresh fa-fw"></span>
											</a>
										</div>

										<div class="recaptcha_only_if_image">
											<a href="javascript:Recaptcha.switch_type('audio')" title="Hear">
												<span class="fa fa-headphones fa-fw"></span>
											</a>
										</div>

										<div class="recaptcha_only_if_audio">
											<a href="javascript:Recaptcha.switch_type('image')" title="See">
												<span class="fa fa-picture-o fa-fw"></span>
											</a>
										</div>

										<div>
											<a href="javascript:Recaptcha.showhelp()" title="Help">
												<span class="fa fa-question fa-fw"></span>
											</a>
										</div>
									</div>
								</div>
								<input class="form-control input-sm" type="text" id="recaptcha_response_field" name="recaptcha_response_field" required>
							</div>
						</div>

						<div class="recaptcha_only_if_incorrect_sol" style="color:red">Incorrect please try again</div>


						<%-- <div class="small">Captcha powered by&nbsp;<a href="http://www.google.com/recaptcha/intro/index.html">reCaptcha</a></div> --%>

						<script src="http://www.google.com/recaptcha/api/challenge?k=6LdqJ_oSAAAAAAFxkVuPZAOOmSQ6kqo5zsIeV5FN"></script>

						<noscript>
							<iframe src="http://www.google.com/recaptcha/api/noscript?k=6LdqJ_oSAAAAAAFxkVuPZAOOmSQ6kqo5zsIeV5FN" height="300" width="500" frameborder="0"></iframe><br>
							<textarea name="recaptcha_challenge_field" rows="3" cols="40"></textarea>
							<input type="hidden" name="recaptcha_response_field" value="manual_challenge">
						</noscript>
					</div>
				</div>
			</div>

			<div class="row">
				<div class="col-md-4">
					<button class="btn btn-sm btn-primary" type="submit">
						<span class="fa fa-user-plus"></span>
						Register
					</button>
				</div>

				<div class="col-md-8">
					<p class="text-right small">
						By clicking register you agree to our
						<a target="_blank" href="${pageContext.request.contextPath}/ums/terms.html">Terms & Conditions</a>
						and
						<a target="_blank" href="${pageContext.request.contextPath}/ums/policy.html">Policy</a>.
					</p>
				</div>
			</div>
		</div>
	</div>
</form>
