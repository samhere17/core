<%@ include file="../../cmn/head.jsp" %>
<c:if test="${not empty optionsList}">
<form method="post" action="${pageContext.request.contextPath}/adapter">
	<input type="hidden" name="requested-action" value="ReorderOptions">
	<div class="panel-group" id="accordion-outer">
		<c:forEach items="${optionsList}" var="currentParent">
			<c:if test="${currentParent.optionType == 'MENU'}">
				<div class="panel panel-info">
					<div class="panel-heading">
						<div class="panel-title">
							<div class="row">
								<div class="col-xs-8  col-sm-6  col-md-7"><span style="display: inline-block; min-width: 30px;" <c:if test="${not empty currentParent.optionIcon}">class="fa fa-${currentParent.optionIcon} fa-fw"</c:if>></span>${currentParent.optionName}</div>
								<div class="hidden-xs col-sm-3  col-md-3" role="button" data-toggle="collapse" href="#collapse-div-${currentParent.optionId}" aria-expanded="true" aria-controls="collapse-div-${currentParent.optionId}">View ${fn:length(currentParent.childOptions)} sub items</div>
								<div class="col-xs-4  col-sm-3  col-md-2"><input id="${currentParent.optionId}" class="form-control input-sm" type="number" name="optId-${currentParent.optionId}" value="${currentParent.optionOrder}"></div>
								<div class="col-xs-12 hidden-sm hidden-md hidden-lg" role="button" data-toggle="collapse" href="#collapse-div-${currentParent.optionId}" aria-expanded="true" aria-controls="collapse-div-${currentParent.optionId}">View ${fn:length(currentParent.childOptions)} sub items</div>
							</div>
						</div>
					</div>

					<div id="collapse-div-${currentParent.optionId}" class="panel-collapse collapse" role="tabpanel" aria-labelledby="billing-heading">
						<div class="panel-body">
							<div class="row">
								<div class="col-md-12">
									<c:if test="${not empty currentParent.childOptions}">
										<table class="table table-bordered">
											<c:forEach items="${currentParent.childOptions}" var="currentChild">
												<c:choose>
													<c:when test="${currentChild.optionType == 'MENU_ITEM'}">
														<tr>
															<td>
																<div class="row">
																	<div class="col-xs-8 col-sm-9 col-md-10"><span style="display: inline-block; min-width: 30px;" <c:if test="${not empty currentChild.optionIcon}">class="fa fa-${currentChild.optionIcon} fa-fw"</c:if>></span>${currentChild.optionName}</div>
																	<div class="col-xs-4 col-sm-3 col-md-2"><input id="${currentChild.optionId}" class="form-control input-sm" type="number" name="optId-${currentChild.optionId}" value="${currentChild.optionOrder}"></div>
																</div>
															</td>
														</tr>
													</c:when>

													<c:when test="${currentChild.optionType == 'SEPERATOR'}">
														<tr>
															<td>
																<div class="row">
																	<div class="col-xs-8 col-sm-9 col-md-10"><strong>SEPERATOR</strong></div>
																	<div class="col-xs-4 col-sm-3 col-md-2"><input id="${currentChild.optionId}" class="form-control input-sm" type="number" name="optId-${currentChild.optionId}" value="${currentChild.optionOrder}"></div>
																</div>
															</td>
														</tr>
													</c:when>
												</c:choose>
											</c:forEach>
										</table>
									</c:if>
								</div>
							</div>
						</div>
					</div>
				</div>
			</c:if>
		</c:forEach>
	</div>
	<div class="row">
		<div class="col-md-12">
			<input class="btn btn-md btn-primary" type="submit" value="Save">
		</div>
	</div>
</form>
</c:if>

	<%-- <form method="post" action="${pageContext.request.contextPath}/adapter" class="form-horizontal">
		<input type="hidden" name="requested-action" value="ReorderOptions">

		<c:if test="${not empty optionsList}">
			<c:forEach items="${optionsList}" var="currentParent">
				<div class="row">
					<div class="col-md-12">
						<c:if test="${currentParent.optionType == 'MENU'}">
							<div class="panel panel-info">
								<div class="panel-heading">
									<h1 class="panel-title">
										<div class="form-group">
											<div class="col-md-3">
												<input id="${currentParent.optionId}" class="form-control input-sm" type="number" name="optId-${currentParent.optionId}" value="${currentParent.optionOrder}">
											</div>
								<div class="col-sm-7"><span style="display: inline-block; min-width: 30px;" <c:if test="${not empty currentParent.optionIcon}">class="fa fa-${currentParent.optionIcon} fa-fw"</c:if>></span>${currentParent.optionName}</div>

											<label class="control-label col-md-9" for="${currentParent.optionId}">
												<c:if test="${not empty currentParent.optionIcon}">
													<span class="fa fa-${currentParent.optionIcon} fa-fw"></span>
												</c:if>

												${currentParent.optionName}
											</label>
										</div>
									</h1>
								</div>

								<div class="panel-body">
									<c:if test="${not empty currentParent.childOptions}">
										<ul class="list-group">
											<c:forEach items="${currentParent.childOptions}" var="currentChild">
												<c:choose>
													<c:when test="${currentChild.optionType == 'MENU_ITEM'}">
														<li class="list-group-item">
															<div class="form-group">
																<div class="col-md-3">
																	<input id="${currentChild.optionId}" class="form-control input-sm" type="number" min="1" name="optId-${currentChild.optionId}" value="${currentChild.optionOrder}">
																</div>
																<div class="col-sm-8"><span style="display: inline-block; min-width: 30px;" <c:if test="${not empty currentChild.optionIcon}">class="fa fa-${currentChild.optionIcon} fa-fw"</c:if>></span> ${currentChild.optionName}</div>

																<label class="control-label col-md-9" for="${currentChild.optionId}">${currentChild.optionName}</label>
															</div>
														</li>
													</c:when>

													<c:when test="${currentChild.optionType == 'SEPERATOR'}">
														<li class="list-group-item">
															<div class="form-group">
																<div class="col-md-3">
																	<input id="${currentChild.optionId}" class="form-control input-sm" type="number" min="1" name="optId-${currentChild.optionId}" value="${currentChild.optionOrder}">
																</div>

																<label class="control-label col-md-9" for="${currentChild.optionId}">
																	<strong>SEPERATOR</strong>
																</label>
															</div>
														</li>
													</c:when>
												</c:choose>
											</c:forEach>
										</ul>
									</c:if>
								</div>
							</div>
						</c:if>
					</div>
				</div>
			</c:forEach>
		</c:if>

		<div class="row">
			<div class="col-md-12">
				<input class="btn btn-md btn-primary" type="submit" value="Save">
			</div>
		</div>
		<br>
	</form> --%>
<%@ include file="../../cmn/tail.jsp" %>
