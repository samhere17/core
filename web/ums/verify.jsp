<form method="post" action="${pageContext.request.contextPath}/adapter">
	<input type="hidden" name="serviceName" value="VerifyUser">

	<c:if test="${not empty umsSession}">
		<input type="hidden" name="userId" value="${umsSession.userId}">
	</c:if>

	<c:if test="${registrationResult.registrationSuccess}">
		<input type="hidden" name="userId" value="${registrationResult.umsUserDetails.userId}">
	</c:if>

	<div class="panel panel-info">
		<div class="panel-heading">
			<div class="panel-title">Verify email address</div>
		</div>

		<div class="panel-body">
			<div class="row">
				<div class="col-md-4">
					<div class="form-group has-feedback">
						<label class="control-label" for="first-name">Verification code</label>
						<input class="form-control input-sm" type="text" name="verificationCode" required data-toggle="tooltip" data-placement="auto" title="Verification code">

						<span class="glyphicon glyphicon-ok form-control-feedback hidden"></span>
						<span class="glyphicon glyphicon-remove form-control-feedback hidden"></span>

						<%-- Validation error message --%>
						<p class="error-msg text-danger small hidden">
							<strong>Enter the verification code sent to you</strong>
						</p>

						<%-- Error message from server --%>
						<%-- <c:if test="${}">
							<p class="error-msg-from-svr text-danger small">
								<strong>${}</strong>
							</p>
						</c:if> --%>
					</div>
				</div>
			</div>

			<div class="row">
				<div class="col-md-4">
					<button class="btn btn-sm btn-primary" type="submit">
						<span class="fa"></span>
						Verify
					</button>
				</div>
			</div>
		</div>
	</div>
</form>
