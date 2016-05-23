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
														<a href="${pageContext.request.contextPath}/adapter?path=${currentChild.optionLink}" data-launch-action="${currentChild.optionLink}">
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
														<a href="${pageContext.request.contextPath}/adapter?path=${currentChild.optionLink}" data-launch-action="${currentChild.optionLink}">
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
	</ul>
</c:if>