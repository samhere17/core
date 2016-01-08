<%@ include file="../../cmn/head.jsp" %>
	<c:if test="${not empty optionsList}">
		<div class="row">
			<div class="col-md-12">
				<button type="button" class="expand-all btn btn-sm btn-primary">
					<span class="fa fa-plus-circle fa-fw"></span>
					Expand All
				</button>
				<button type="button" class="collapse-all btn btn-sm btn-primary">
					<span class="fa fa-minus-circle fa-fw"></span>
					Collapse All
				</button>
			</div>
		</div>
		<br>

		<div class="panel-group" id="accordion-outer">
			<c:forEach items="${optionsList}" var="currentParent">
				<c:if test="${currentParent.optionType == 'MENU'}">
					<div class="panel panel-info">
						<div class="panel-heading" role="button" data-toggle="collapse" href="#${currentParent.optionId}" aria-expanded="true" aria-controls="${currentParent.optionId}">
							<div class="panel-title">
								<div class="row">
									<div class="col-xs-2 col-sm-1">${currentParent.optionOrder}</div>
									<div class="col-sm-8"><span style="display: inline-block; min-width: 30px;" <c:if test="${not empty currentParent.optionIcon}">class="fa fa-${currentParent.optionIcon} fa-fw"</c:if>></span>${currentParent.optionName}</div>
									<div class="col-sm-3 text-right small">${fn:length(currentParent.childOptions)} sub items</div>
								</div>
							</div>
						</div>

						<div id="${currentParent.optionId}" class="panel-collapse collapse" role="tabpanel" aria-labelledby="billing-heading">
							<div class="panel-body">
								<div class="row">
									<div class="col-md-3 form-group">
										<label class="control-label">Option Id</label>
										<input class="form-control" type="text" value="${currentParent.optionId}" readonly />
									</div>
									<div class="col-md-3 form-group">
										<label class="control-label">Option Type</label>
										<input class="form-control" type="text" value="${currentParent.optionType}" readonly />
									</div>
									<div class="col-md-3 form-group">
										<label class="control-label">Option Area</label>
										<input class="form-control" type="text" value="${currentParent.optionArea}" readonly />
									</div>
									<div class="col-md-3 form-group">
										<label class="control-label">Option Status</label>
										<input class="form-control" type="text" value="${currentParent.optionStatus}" readonly />
									</div>
								</div>
								<div class="row">
									<div class="col-md-6 form-group">
										<label class="control-label">Option Description</label>
										<textarea class="form-control" style="height: 120px;" readonly>${currentParent.optionDescription}</textarea>
									</div>
									<div class="col-md-3 form-group">
										<label class="control-label">Option Icon</label>
										<input class="form-control" type="text" value="${currentParent.optionIcon}" readonly />
									</div>
									<div class="col-md-3 form-group">
										<label class="control-label">Option Order</label>
										<input class="form-control" type="text" value="${currentParent.optionOrder}" readonly />
									</div>
									<div class="col-md-3 form-group">
										<label class="control-label">Parent Option Id</label>
										<input class="form-control" type="text" value="${currentParent.parentOptionId}" readonly />
									</div>
									<div class="col-md-3 form-group">
										<label class="control-label">Object Reference</label>
										<input class="form-control" type="text" value="${currentParent.objectReferenceKey}" readonly />
									</div>
								</div>
								<div class="row">
									<div class="col-md-12 form-group">
										<label class="control-label">Option Link</label>
										<input class="form-control" type="text" value="${currentParent.optionLink}" readonly />
									</div>
								</div>
								<div class="row">
									<div class="col-md-12 form-group">
										<form method="get"
											action="${pageContext.request.contextPath}/adapter" style="display: inline-block;">
											<input type="hidden" name="serviceName" value="GetOption" />
											<input type="hidden" name="path" value="ums/opt/edit" /> <input
												type="hidden" name="optId" value="${currentParent.optionId}" />
											<button class="btn btn-warning" type="submit">
												<span class="fa fa-pencil"></span> Edit
											</button>
										</form>

										<c:set var="displayDelete" value="true" />
										<c:forEach items="${currentParent.childOptions}"
											var="currentChild">
											<c:if test="${currentChild.optionStatus != 'DELETED'}">
												<c:set var="displayDelete" value="false" />
											</c:if>
										</c:forEach>

										<c:if
											test="${displayDelete and currentParent.optionStatus != 'DELETED'}">
											<form method="get"
												action="${pageContext.request.contextPath}/adapter" style="display: inline-block;">
												<input type="hidden" name="serviceName" value="GetOption" />
												<input type="hidden" name="path" value="ums/opt/delete" />
												<input type="hidden" name="optId"
													value="${currentParent.optionId}" />
												<button class="btn btn-danger" type="submit">
													<span class="fa fa-trash"></span> Delete
												</button>
											</form>
										</c:if>
									</div>
								</div>

								<div class="row">
									<div class="col-md-12">
										<c:if test="${not empty currentParent.childOptions}">
											${fn:length(currentParent.childOptions)} sub items
											<div class="panel-group accordion" id="accordion-inner-${currentParent.optionId}">
												<c:forEach items="${currentParent.childOptions}" var="currentChild">
													<c:choose>
														<c:when test="${currentChild.optionType == 'MENU_ITEM'}">
															<div class="panel panel-info">
																<div class="panel-heading" role="button" data-toggle="collapse" href="#${currentChild.optionId}" aria-expanded="true" aria-controls="${currentChild.optionId}">
																	<div class="panel-title">
																		<div class="row">
																			<div class="col-xs-2 col-sm-1">${currentChild.optionOrder}</div>
																			<div class="col-sm-8"><span style="display: inline-block; min-width: 30px;" <c:if test="${not empty currentChild.optionIcon}">class="fa fa-${currentChild.optionIcon} fa-fw"</c:if>></span> ${currentChild.optionName}</div>
																		</div>
																	</div>
																</div>

																<div id="${currentChild.optionId}" class="panel-collapse collapse" role="tabpanel" aria-labelledby="billing-heading">
																	<div class="panel-body">
																		<div class="row">
																			<div class="col-md-3 form-group">
																				<label class="control-label">Option Id</label>
																				<input class="form-control" type="text" value="${currentChild.optionId}" readonly />
																			</div>
																			<div class="col-md-3 form-group">
																				<label class="control-label">Option Area</label>
																				<input class="form-control" type="text" value="${currentChild.optionArea}" readonly />
																			</div>
																			<div class="col-md-3 form-group">
																				<label class="control-label">Option Type</label>
																				<input class="form-control" type="text" value="${currentChild.optionType}" readonly />
																			</div>
																			<div class="col-md-3 form-group">
																				<label class="control-label">Option Status</label>
																				<input class="form-control" type="text" value="${currentChild.optionStatus}" readonly />
																			</div>
																		</div>
																		<div class="row">
																			<div class="col-md-6 form-group">
																				<label class="control-label">Option Description</label>
																				<textarea class="form-control" style="height: 120px;" readonly>${currentChild.optionDescription}</textarea>
																			</div>
																			<div class="col-md-3 form-group">
																				<label class="control-label">Option Icon</label>
																				<input class="form-control" type="text" value="${currentChild.optionIcon}" readonly />
																			</div>
																			<div class="col-md-3 form-group">
																				<label class="control-label">Option Order</label>
																				<input class="form-control" type="text" value="${currentChild.optionOrder}" readonly />
																			</div>
																			<div class="col-md-3 form-group">
																				<label class="control-label">Parent Option Id</label>
																				<input class="form-control" type="text" value="${currentChild.parentOptionId}" readonly />
																			</div>
																			<div class="col-md-3 form-group">
																				<label class="control-label">Object Reference</label>
																				<input class="form-control" type="text" value="${currentChild.objectReferenceKey}" readonly />
																			</div>
																		</div>
																		<div class="row">
																			<div class="col-md-12 form-group">
																				<label class="control-label">Option Link</label>
																				<input class="form-control" type="text" value="${currentChild.optionLink}" readonly />
																			</div>
																		</div>
																		<div class="row">
																			<div class="col-md-12 form-group">
																				<form method="get"
																					action="${pageContext.request.contextPath}/adapter" style="display: inline-block;">
																					<input type="hidden" name="serviceName" value="GetOption" />
																					<input type="hidden" name="path" value="ums/opt/edit" /> <input
																						type="hidden" name="optId" value="${currentChild.optionId}" />
																					<button class="btn btn-warning" type="submit">
																						<span class="fa fa-pencil"></span> Edit
																					</button>
																				</form>

																				<c:if
																					test="${currentChild.optionStatus != 'DELETED'}">
																					<form method="get"
																						action="${pageContext.request.contextPath}/adapter" style="display: inline-block;">
																						<input type="hidden" name="serviceName" value="GetOption" />
																						<input type="hidden" name="path" value="ums/opt/delete" />
																						<input type="hidden" name="optId"
																							value="${currentChild.optionId}" />
																						<button class="btn btn-danger" type="submit">
																							<span class="fa fa-trash"></span> Delete
																						</button>
																					</form>
																				</c:if>
																			</div>
																		</div>
																	</div>
																</div>
															</div>
														</c:when>

														<c:when test="${currentChild.optionType == 'SEPERATOR'}">
															<div class="panel panel-info">
																<div class="panel-heading" role="button" data-toggle="collapse" href="#${currentChild.optionId}" aria-expanded="true" aria-controls="${currentChild.optionId}">
																	<div class="panel-title">
																		<div class="row">
																			<div class="col-xs-2 col-sm-1">${currentChild.optionOrder}</div>
																			<div class="col-sm-8">Separator</div>
																		</div>
																	</div>
																</div>

																<div id="${currentChild.optionId}" class="panel-collapse collapse" role="tabpanel" aria-labelledby="billing-heading">
																	<div class="panel-body">
																		<div class="row">
																			<div class="col-md-3 form-group">
																				<label class="control-label">Option Id</label>
																				<input class="form-control" type="text" value="${currentChild.optionId}" readonly />
																			</div>
																			<div class="col-md-3 form-group">
																				<label class="control-label">Option Area</label>
																				<input class="form-control" type="text" value="${currentChild.optionArea}" readonly />
																			</div>
																			<div class="col-md-3 form-group">
																				<label class="control-label">Option Type</label>
																				<input class="form-control" type="text" value="${currentChild.optionType}" readonly />
																			</div>
																			<div class="col-md-3 form-group">
																				<label class="control-label">Option Status</label>
																				<input class="form-control" type="text" value="${currentChild.optionStatus}" readonly />
																			</div>
																		</div>
																		<div class="row">
																			<div class="col-md-3 form-group">
																				<label class="control-label">Parent Option Id</label>
																				<input class="form-control" type="text" value="${currentChild.parentOptionId}" readonly />
																			</div>
																		</div>
																		<div class="row">
																			<div class="col-md-12 form-group">
																				<form method="get"
																					action="${pageContext.request.contextPath}/adapter" style="display: inline-block;">
																					<input type="hidden" name="serviceName" value="GetOption" />
																					<input type="hidden" name="path" value="ums/opt/edit" /> <input
																						type="hidden" name="optId" value="${currentChild.optionId}" />
																					<button class="btn btn-warning" type="submit">
																						<span class="fa fa-pencil"></span> Edit
																					</button>
																				</form>

																				<c:if
																					test="${currentChild.optionStatus != 'DELETED'}">
																					<form method="get"
																						action="${pageContext.request.contextPath}/adapter" style="display: inline-block;">
																						<input type="hidden" name="serviceName" value="GetOption" />
																						<input type="hidden" name="path" value="ums/opt/delete" />
																						<input type="hidden" name="optId"
																							value="${currentChild.optionId}" />
																						<button class="btn btn-danger" type="submit">
																							<span class="fa fa-trash"></span> Delete
																						</button>
																					</form>
																				</c:if>
																			</div>
																		</div>
																	</div>
																</div>
															</div>
														</c:when>
													</c:choose>
												</c:forEach>
											</div>
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
				<button type="button" class="expand-all btn btn-sm btn-primary">
					<span class="fa fa-plus-circle fa-fw"></span>
					Expand All
				</button>
				<button type="button" class="collapse-all btn btn-sm btn-primary">
					<span class="fa fa-minus-circle fa-fw"></span>
					Collapse All
				</button>
			</div>
		</div>
		<br>
	</c:if>
<%@include file="../../cmn/tail.jsp" %>
