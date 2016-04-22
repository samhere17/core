<c:choose>
	<c:when test="${not empty umsSession}">
		<c:choose>
			<c:when test="${umsSession.sessionValid}">
				<nav class="navbar navbar-inverse">
					<div class="container-fluid">
						<div class="navbar-header">
							<ul class="nav navbar-nav navbar-right hidden-sm hidden-md hidden-lg">
								<li class="dropdown" id="logged-in-user-on-header">
									<a href="#" class="dropdown-toggle text-center" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">
										<img id="user-thumbnail" class="img-circle center-block" src="https://placehold.it/30x30">
										<%-- <div class="hidden-sm hidden-xs">${umsSession.username}</div> --%>
									</a>

									<ul class="dropdown-menu">
										<li class="container-fluid">
											<div class="row">
												<div class="col-md-4 col-xs-5">
													<img class="img-rounded center-block" src="https://placehold.it/100x100">
												</div>

												<div class="col-md-8 col-xs-7 text-left">

													<span id="logged-in-user-name">
														${umsSession.userDetails.userFirstName} ${umsSession.userDetails.userLastName}
														<br>
													</span>

													<span id="logged-in-user-contact-info">
														${umsSession.userDetails.primaryEmail}
														<br>
														${umsSession.userDetails.primaryPhone}
														<br>
													</span>
												</div>
											</div>
										</li>

										<li role="separator" class="divider"></li>

										<li class="container-fluid">
											<div class="row">
												<div class="col-md-3 col-xs-3">
													<form method="post" action="${pageContext.request.contextPath}/adapter">
														<input type="hidden" name="serviceName" value="GetUser">
														<input class="btn btn-sm btn-primary" type="submit" value="View Profile">
													</form>
												</div>

												<div class="col-md-3 col-xs-3 col-md-offset-1 col-xs-offset-2">
													<form method="post" action="${pageContext.request.contextPath}/adapter">
														<input type="hidden" name="serviceName" value="Logout">
														<input type="hidden" name="jSessionId" value="${pageContext.session.id}">
														<input class="btn btn-sm btn-primary" type="submit" value="Logout">
													</form>
												</div>
											</div>
										</li>

										<li class="container-fluid">
											<div class="row">
												<div class="col-md-12 text-left">
													<span id="last-login">
														Last successful login:
														<fmt:formatDate type="date" value="${umsSession.lastLoginDetails.loginTime}" />
														<fmt:formatDate type="time" value="${umsSession.lastLoginDetails.loginTime}" />
													</span>
												</div>
											</div>
										</li>
									</ul>
								</li>
							</ul>

							<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#menubar" aria-expanded="false">
								<span class="sr-only">Toggle navigation</span>
								<span class="icon-bar"></span>
								<span class="icon-bar"></span>
								<span class="icon-bar"></span>
							</button>

							<a href="${pageContext.request.contextPath}/${umsConfig.validSessionContextRoot}" class="navbar-brand hidden-xs hidden-sm">${systemConfig.applicationName}</a>
							<a href="${pageContext.request.contextPath}/${umsConfig.validSessionContextRoot}" class="navbar-brand hidden-md hidden-lg">${systemConfig.applicationAlias}</a>
						</div>

						<div class="collapse navbar-collapse" id="menubar">
							<%-- Include the menu --%>
							<%@ include file="menu.jsp"%>

							<ul class="nav navbar-nav navbar-right hidden-xs">
								<li class="dropdown" id="logged-in-user">
									<a href="#" class="dropdown-toggle text-center" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">
										<img id="user-thumbnail" class="img-circle center-block" src="https://placehold.it/30x30">
										<div class="hidden-sm">${umsSession.username}</div>
									</a>

									<ul class="dropdown-menu">
										<li class="container-fluid">
											<div class="row">
												<div class="col-md-4 col-xs-5">
													<img class="img-rounded center-block" src="https://placehold.it/100x100">
												</div>

												<div class="col-md-8 col-xs-7 text-left">

													<span id="logged-in-user-name">
														${umsSession.userDetails.userFirstName} ${umsSession.userDetails.userLastName}
														<br>
													</span>

													<span id="logged-in-user-contact-info">
														${umsSession.userDetails.primaryEmail}
														<br>
														${umsSession.userDetails.primaryPhone}
														<br>
													</span>
												</div>
											</div>
										</li>

										<li role="separator" class="divider"></li>

										<li class="container-fluid">
											<div class="row">
												<div class="col-sm-3">
													<form method="post" action="${pageContext.request.contextPath}/adapter">
														<input type="hidden" name="serviceName" value="GetUser">
														<input class="btn btn-sm btn-primary" type="submit" value="View Profile">
													</form>
												</div>

												<div class="col-sm-3 col-sm-offset-1">
													<form method="post" action="${pageContext.request.contextPath}/adapter">
														<input type="hidden" name="serviceName" value="Logout">
														<input type="hidden" name="jSessionId" value="${pageContext.session.id}">
														<input class="btn btn-sm btn-primary" type="submit" value="Logout">
													</form>
												</div>
											</div>
										</li>

										<%-- <li role="separator" class="divider"></li> --%>

										<li class="container-fluid">
											<div class="row">
												<div class="col-md-12 text-left">
													<span id="last-login">
														Last successful login:
														<fmt:formatDate type="date" value="${umsSession.lastLoginDetails.loginTime}" />
														<fmt:formatDate type="time" value="${umsSession.lastLoginDetails.loginTime}" />
													</span>
												</div>
											</div>
										</li>
									</ul>
								</li>
							</ul>
						</div>
					</div>
				</nav>
			</c:when>

			<c:otherwise>
				<c:if test="${pageContext.request.servletPath ne '/error.jsp'}">
					<c:redirect url="/${systemConfig.webContextRoot}" context="${pageContext.request.contextPath}"></c:redirect>
				</c:if>
			</c:otherwise>
		</c:choose>
	</c:when>

	<c:otherwise>
		<c:if test="${pageContext.request.servletPath ne '/error.jsp'}">
			<c:redirect url="/${systemConfig.webContextRoot}" context="${pageContext.request.contextPath}"></c:redirect>
		</c:if>
	</c:otherwise>
</c:choose>
