<c:if test="${not empty menuOptions}">
	<ul class="nav navbar-nav navbar-left">
		<c:forEach var="currentParent" items="${menuOptions}" varStatus="loop">
		
				<c:if test="${loop.index eq 6}">
					<c:set var="moreCloseRequired" value="true"/>
					<li class="dropdown">
						<!-- More Dropdown Link -->
						<a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">
							<span class="fa fa-fw fa-th"></span> More
						</a>
						<!-- More Dropdown Items -->
						<ul class="dropdown-menu dropdown-menu-right">
				</c:if>
			<c:choose>
				<c:when test="${loop.index < 6}">
					<c:if test="${not empty currentParent.childOptions}">
						<li class="dropdown">
							<a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">
								<span <c:if test="${not empty currentParent.optionIcon}">class="fa fa-${currentParent.optionIcon} fa-fw"</c:if>></span> ${currentParent.optionName}
							</a>
							<ul class="dropdown-menu dropdown-menu-left">
								<c:forEach items="${currentParent.childOptions}" var="currentChild">
									<c:choose>
										<c:when test="${currentChild.menuItemSeparator}">
											<li class="divider"></li>
										</c:when>
										<c:otherwise>
											<c:choose>
												<c:when test="${currentChild.menuItemEnabled}">
													<li>
														<a href="${pageContext.request.contextPath}/adapter?path=${currentChild.optionLink}">
															<span <c:if test="${not empty currentChild.optionIcon}">class="fa fa-${currentChild.optionIcon} fa-fw"</c:if>></span> ${currentChild.optionName}
														</a>
													</li>
												</c:when>
												<c:otherwise>
													<li class="disabled">
														<a href="">
															<span <c:if test="${not empty currentChild.optionIcon}">class="fa fa-${currentChild.optionIcon} fa-fw"</c:if>></span> ${currentChild.optionName}
														</a>
													</li>
												</c:otherwise>
											</c:choose>
										</c:otherwise>
									</c:choose>
								</c:forEach>
							</ul>
						</li>
					</c:if>
				</c:when>
				<c:otherwise>
					<c:if test="${not empty currentParent.childOptions}">
						<li class="dropdown sub-dropdown">
							<a href="#" class="dropdown-toggle" data-toggle="dropdown" role="menu" aria-haspopup="true" aria-expanded="false">
								<span <c:if test="${not empty currentParent.optionIcon}">class="fa fa-${currentParent.optionIcon} fa-fw"</c:if>></span> ${currentParent.optionName}
							</a>
							<ul class="dropdown-menu sub-dropdown-menu">
								<c:forEach items="${currentParent.childOptions}" var="currentChild">
									<c:choose>
										<c:when test="${currentChild.menuItemSeparator}">
											<li class="divider"></li>
										</c:when>
										<c:otherwise>
											<c:choose>
												<c:when test="${currentChild.menuItemEnabled}">
													<li>
														<a href="${pageContext.request.contextPath}/adapter?path=${currentChild.optionLink}">
															<span <c:if test="${not empty currentChild.optionIcon}">class="fa fa-${currentChild.optionIcon} fa-fw"</c:if>></span> ${currentChild.optionName}
														</a>
													</li>
												</c:when>
												<c:otherwise>
													<li class="disabled">
														<a href="">
															<span <c:if test="${not empty currentChild.optionIcon}">class="fa fa-${currentChild.optionIcon} fa-fw"</c:if>></span> ${currentChild.optionName}
														</a>
													</li>
												</c:otherwise>
											</c:choose>
										</c:otherwise>
									</c:choose>
								</c:forEach>
							</ul>
						</li>
					</c:if>
				</c:otherwise>
			</c:choose>
		</c:forEach>
		

			<c:if test="${moreCloseRequired eq true}">
						</ul>
					</li>
			</c:if>

<%-- <li class="dropdown">
		<!-- Main Dropdown Link -->
		<a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">
			<span class="fa fa-fw fa-th"></span> More
		</a>

		<!-- Main Dropdown Items -->
		<ul class="dropdown-menu dropdown-menu-right">
			<li>
				<a class="" href="${pageContext.request.contextPath}/adapter?path=settings&serviceName=GetSettings">
					<span class="fa fa-cog fa-fw"></span> Settings
				</a>
			</li>

			<li>
				<a class="" href="${pageContext.request.contextPath}/support.jsp">
					<span class="fa fa-question fa-fw"></span>	Support
				</a>
			</li>
			<!-- 1st Main Item -->
			<li class="dropdown sub-dropdown">
				<!-- 1st Sub Dropdown Link -->
				<a href="#" class="dropdown-toggle" data-toggle="dropdown" role="menu" aria-haspopup="true" aria-expanded="false">
					<span class="fa fa-th fa-fw"></span>
					1st Main Dropdown Item
				</a>

				<!-- 1st Sub Dropdown Items -->
				<ul class="dropdown-menu sub-dropdown-menu">
					<!-- 1st Sub Item -->
					<li>
						<a href="${pageContext.request.contextPath}/my-apartment.jsp">
							<span></span>
							1st's 1st Sub Menu Item
						</a>
					</li>

					<li>
						<a href="${pageContext.request.contextPath}/my-apartment.jsp">
							<span class="fa fa-th fa-fw"></span>
							1st's 2nd Sub Menu
						</a>
					</li>
				</ul>
			</li>

			<li class="dropdown sub-dropdown">
				<!-- 2nd Sub Dropdown Link -->
				<a href="#" class="dropdown-toggle" data-toggle="dropdown" role="menu" aria-haspopup="true" aria-expanded="false">
					<span class="fa fa-th fa-fw"></span>
					2nd Main Dropdown Item
				</a>

				<!-- 2nd Sub Dropdown Items -->
				<ul class="dropdown-menu sub-dropdown-menu">
					<!-- 1st Sub Item -->
					<li>
						<a href="${pageContext.request.contextPath}/my-apartment.jsp">
							<span class="fa fa-th fa-fw"></span>
							2nd's 1st Sub Menu Item
						</a>
					</li>

					<li>
						<a href="${pageContext.request.contextPath}/my-apartment.jsp">
							<span class="fa fa-th fa-fw"></span>
							2nd's 2nd Sub Menu Item
						</a>
					</li>
				</ul>
			</li>
		</ul>
	</li> --%>
	</ul>
</c:if>

<%-- <ul class="nav navbar-nav navbar-left">
	<li class="dropdown">
		<a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">
			<span class="fa fa-building fa-fw"></span> Apartment
		</a>
		<ul class="dropdown-menu dropdown-menu-left">
			<li>
				<a href="${pageContext.request.contextPath}/my-apartment.jsp">
					<span class="fa fa-home fa-fw"></span> My Apartment
				</a>
			</li>
			<li>
				<a href="${pageContext.request.contextPath}/adapter?path=apartment/new&serviceName=ListCommunity">
					<span></span> Add New Apartment
				</a>
			</li>
			<li>
				<a href="${pageContext.request.contextPath}/adapter?path=apartment/newmultiple&serviceName=ListCommunity">
					<span></span> Add Multiple Apartments
				</a>
			</li>
			<li>
				<a href="#">
					<span class="fa fa-search fa-fw"></span> Search Apartment
				</a>
			</li>
			<li>
				<a href="#">
					<span></span> Edit Apartment
				</a>
			</li>
		</ul>
	</li>

	<li class="dropdown">
		<a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">
			<span class="fa fa-envelope fa-fw"></span>
			Communication
		</a>
		<ul class="dropdown-menu dropdown-menu-left multi-level" role="menu" aria-labelledby="dropdownMenu">
			<li>
				<a href="#">
					<span class="fa fa-star fa-fw"></span> New SMS
				</a>
			</li>
			<li>
				<a href="#">
					<span class="fa fa-wifi fa-fw"></span> Broadcast SMS
				</a>
			</li>
			<li>
				<a href="#"><span></span> New Email</a>
			</li>
			<li>
				<a href="#"><span></span> Broadcast Email</a>
			</li>
			<li>
				<a href="#"><span class="fa fa-history fa-fw"></span> Message History</a>
			</li>
		</ul>
	</li>
	<li class="dropdown">
		<a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">
			<span class="fa fa-user fa-fw"></span> User
		</a>
		<ul class="dropdown-menu dropdown-menu-left">
			<li>
				<a href="${pageContext.request.contextPath}/adapter?path=ums/new&serviceName=GetNewUser"><span></span> Add New User</a>
			</li>

			<li>
				<a href="${pageContext.request.contextPath}/adapter?path=ums/search&serviceName=GetNewUser"><span></span> Search User</a>
			</li>
		</ul>
	</li>

	<li class="dropdown">
		<a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">
			<span class="fa fa-th-list fa-fw"></span> Role
		</a>
		<ul class="dropdown-menu dropdown-menu-left">
			<li>
				<a href="${pageContext.request.contextPath}/adapter?path=ums/role/new&serviceName=ListPermissions"><span></span> Add Role</a>
			</li>

			<li>
				<a href="${pageContext.request.contextPath}/adapter?path=ums/role/search"><span></span> Search Role</a>
			</li>
		</ul>
	</li>

	<li class="dropdown">
		<a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">
			<span class="fa fa-pencil fa-fw"></span> Options
		</a>
		<ul class="dropdown-menu dropdown-menu-left">
			<li>
				<a href="${pageContext.request.contextPath}/adapter?path=ums/opt/new"><span></span> Add New Option</a>
			</li>

			<li>
				<a href="${pageContext.request.contextPath}/adapter?path=ums/opt/list&serviceName=ListOptions"><span></span> List Options</a>
			</li>
		</ul>
	</li>

	<li class="dropdown">
		<a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">
			<span class="fa fa-users fa-fw"></span> Community
		</a>
		<ul class="dropdown-menu dropdown-menu-left">
			<li>
				<a href="${pageContext.request.contextPath}/adapter?path=community/details&serviceName=GetCommunity&commu-id=1"><span></span> My Community</a>
			</li>

			<li>
				<a href="${pageContext.request.contextPath}/adapter?path=community/edit&serviceName=GetCommunity&commu-id=1"><span></span> Edit Community</a>
			</li>

			<li>
				<a href="${pageContext.request.contextPath}/adapter?path=community/new"><span></span> New Community</a>
			</li>
		</ul>
	</li>


	<li>
		<a class="" href="${pageContext.request.contextPath}/adapter?path=settings&serviceName=GetSettings">
			<span class="fa fa-cog fa-fw"></span> Settings
		</a>
	</li>

	<li>
		<a class="" href="support.jsp">
			<span class="fa fa-question fa-fw"></span>	Support
		</a>
	</li>

	<li class="dropdown">
		Main Dropdown Link
		<a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">
			<span class="fa fa-fw fa-th"></span> More
		</a>

		Main Dropdown Items
		<ul class="dropdown-menu dropdown-menu-right">
			<li>
				<a class="" href="${pageContext.request.contextPath}/adapter?path=settings&serviceName=GetSettings">
					<span class="fa fa-cog fa-fw"></span> Settings
				</a>
			</li>

			<li>
				<a class="" href="${pageContext.request.contextPath}/support.jsp">
					<span class="fa fa-question fa-fw"></span>	Support
				</a>
			</li>
			1st Main Item
			<li class="dropdown sub-dropdown">
				1st Sub Dropdown Link
				<a href="#" class="dropdown-toggle" data-toggle="dropdown" role="menu" aria-haspopup="true" aria-expanded="false">
					<span class="fa fa-th fa-fw"></span>
					1st Main Dropdown Item
				</a>

				1st Sub Dropdown Items
				<ul class="dropdown-menu sub-dropdown-menu">
					1st Sub Item
					<li>
						<a href="${pageContext.request.contextPath}/my-apartment.jsp">
							<span></span>
							1st's 1st Sub Menu Item
						</a>
					</li>

					<li>
						<a href="${pageContext.request.contextPath}/my-apartment.jsp">
							<span class="fa fa-th fa-fw"></span>
							1st's 2nd Sub Menu
						</a>
					</li>
				</ul>
			</li>

			<li class="dropdown sub-dropdown">
				2nd Sub Dropdown Link
				<a href="#" class="dropdown-toggle" data-toggle="dropdown" role="menu" aria-haspopup="true" aria-expanded="false">
					<span class="fa fa-th fa-fw"></span>
					2nd Main Dropdown Item
				</a>

				2nd Sub Dropdown Items
				<ul class="dropdown-menu sub-dropdown-menu">
					1st Sub Item
					<li>
						<a href="${pageContext.request.contextPath}/my-apartment.jsp">
							<span class="fa fa-th fa-fw"></span>
							2nd's 1st Sub Menu Item
						</a>
					</li>

					<li>
						<a href="${pageContext.request.contextPath}/my-apartment.jsp">
							<span class="fa fa-th fa-fw"></span>
							2nd's 2nd Sub Menu Item
						</a>
					</li>
				</ul>
			</li>

			<li class="dropdown sub-dropdown">
				3rd Sub Dropdown Link
				<a href="#" class="dropdown-toggle" data-toggle="dropdown" role="menu" aria-haspopup="true" aria-expanded="false">
					<span class="fa fa-th fa-fw"></span> 3rd Main Dropdown Item
				</a>

				3rd Sub Dropdown Items
				<ul class="dropdown-menu sub-dropdown-menu">
					1st Sub Item
					<li>
						<a href="${pageContext.request.contextPath}/my-apartment.jsp">
							<span class="fa fa-th fa-fw"></span> 3rd's 1st Sub Menu Item
						</a>
					</li>

					<li>
						<a href="${pageContext.request.contextPath}/my-apartment.jsp">
							<span></span>
							3rd's 2nd Sub Menu Item
						</a>
					</li>

					<li>
						<a href="${pageContext.request.contextPath}/my-apartment.jsp">
							<span></span>
							3rd's 3rd Sub Menu Item
						</a>
					</li>
				</ul>
			</li>
		</ul>
	</li>
</ul>
 --%>