<form class="" method="post" action="${pageContext.request.contextPath}/adapter">
	<input type="hidden" name="requested-action" value="Authentication">
	<input type="hidden" name="jSessionId" value="${pageContext.session.id}">
	<input type="hidden" name="accessIP" value="<%=request.getRemoteAddr()%>">
	<input type="hidden" name="accessPort" value="<%=request.getRemotePort()%>">
	<input type="hidden" name="accessGateway" value="<%=request.getHeader("VIA")%>">
	<input type="hidden" name="actualAccessIP" value="<%=request.getHeader("X-FORWARDED-FOR")%>">
	<input type="hidden" name="userAgent" value="<%=request.getHeader("user-agent")%>">

	<div class="panel panel-info">
		<div class="panel-heading">
			<div class="panel-title">Login</div>
		</div>

		<div class="panel-body">
			<div class="row">
				<div class="col-md-12">
					<div class="form-group has-feedback">
						<label class="control-label" for="username">Username</label>
						<input type="text" class="form-control" id="username" name="username" placeholder="Enter your username" required>

						<span class="glyphicon glyphicon-ok form-control-feedback hidden"></span>
						<span class="glyphicon glyphicon-remove form-control-feedback hidden"></span>

						<p class="error-msg text-danger small hidden">
							<strong>Enter username</strong>
						</p>

						<%-- Error message from server --%>
						<c:if test="${not registrationResult.registrationSuccess}">
							<p class="error-msg-from-svr text-danger small">
								<strong>${registrationResult.firstnameValidationError}</strong>
							</p>
						</c:if>
					</div>
				</div>
			</div>

			<div class="row">
				<div class="col-md-12">
					<div class="form-group has-feedback">
						<label class="control-label" for="password">Password</label>
						<input type="password" class="form-control" id="password" name="password" placeholder="Enter your password" required>

						<span class="glyphicon glyphicon-ok form-control-feedback hidden"></span>
						<span class="glyphicon glyphicon-remove form-control-feedback hidden"></span>

						<p class="error-msg text-danger small hidden">
							<strong>Enter password</strong>
						</p>
					</div>
				</div>
			</div>

			<div class="row">
				<div class="col-md-3">
					<button class="btn btn-sm btn-primary" type="submit">
						<span class="fa fa-sign-in"></span>
						Login
					</button>
				</div>

				<div class="col-md-9">
					<div class="pull-right">
						<a class="btn btn-default btn-sm" href="${pageContext.request.contextPath}/register.jsp">Register</a>
						<a class="btn btn-default btn-sm" href="${pageContext.request.contextPath}/forgot.jsp">Forgot Password?</a>
					</div>
				</div>
			</div>
		</div>
	</div>
</form>
