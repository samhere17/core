<%@ include file="../../cmn/head.jsp" %>
<form method="post" action="${pageContext.request.contextPath}/adapter">
	<input type="hidden" name="serviceName" value="InsertRole">
	<div class="panel panel-default">
		<div class="panel-heading">
			<div class="panel-title">
				New Role
			</div>
		</div>
		<div class="panel-body">
			<div class="row">
				<div class="col-md-6 form-group">
					<label class="control-label" for="name">Role Name</label>
					<input class="form-control" type="text" name="roleName" maxlength="50" required/>
				</div>
				<div class="col-md-6 form-group">
					<label class="control-label" for="name">Role Description</label>
					<textarea class="form-control" name="roleDesc" maxlength="500"></textarea>
				</div>
			</div>
		</div>
	</div>

	<div class="panel panel-default">
		<div class="panel-heading">
			<div class="panel-title">
				Permissions
			</div>
		</div>

		<div class="panel-body">
			<c:if test="${not empty optionsList}">
				<c:set var="loopCount" value="0" />
				<c:set var="optionsListSize" value="${fn:length(optionsList)}" />
				<c:forEach items="${optionsList}" var="currentParent">
					<c:if test="${loopCount%2 eq 0}"><div class="row"></c:if>

					<div class="col-md-6">
						<c:if test="${not empty currentParent.childOptions}">
							<div class="panel panel-default">
								<div class="panel-heading">
									<input type="checkbox" class="select-all" id="option-${currentParent.optionId}" name="option-${currentParent.optionId}">
									<label for="option-${currentParent.optionId}"><b>${currentParent.optionName} Menu</b></label>
								</div>
								<div class="panel-body">
									<c:forEach items="${currentParent.childOptions}" var="currentChild">
										<c:if test="${currentChild.optionType == 'MENU_ITEM'}">
											<div>
												<input type="checkbox" id="option-${currentChild.optionId}" name="option-${currentChild.optionId}">
												<label for="option-${currentChild.optionId}">${currentChild.optionName}</label>
											</div>
										</c:if>
									</c:forEach>
								</div>
							</div>
						</c:if>
					</div>

					<c:set var="loopCount" value="${loopCount+1}" />
					<c:if test="${loopCount%2 eq 0 or loopCount eq optionsListSize}"></div></c:if>
				</c:forEach>
			</c:if>
		</div>
	</div>
	<div class="row">
		<div class="col-md-12">
			<input class="btn btn-md btn-primary" type="submit" value="Save">
		</div>
	</div>
	<br>
</form>
<%@ include file="../../cmn/tail.jsp" %>
