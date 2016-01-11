<%@ include file="../../cmn/head.jsp"%>
	<form method="post" action="${pageContext.request.contextPath}/adapter">
		<input class="form-control" type="hidden" name="serviceName" value="UpdateOption">
		<div class="panel panel-default">
			<div class="panel-heading">
				<div class="panel-title">Edit Option</div>
			</div>

			<div class="panel-body">
				<div class="row">
					<div class="col-md-4 form-group">
						<label class="control-label">Option ID</label>
						<input class="form-control" type="text" name="optId" value="${option.optionId}" readonly>
					</div>

					<div class="col-md-4 form-group">
						<label class="control-label">Parent Option ID</label>
						<input class="form-control" type="text" id="parent-opt-id" name="optParentId" value="${option.parentOptionId}" readonly>
					</div>

					<div class="col-md-4 form-group">
						<label class="control-label">Object Reference</label>
						<input class="form-control" type="text" name="objRef" value="${option.objectReferenceKey}">
					</div>
				</div>

				<div class="row">
					<div class="col-md-3 form-group">
						<label class="control-label">Option Type</label>
						<select class="form-control" name="optType" required>
							<option value="0" <c:if test="${option.optionType eq 'MENU'}">selected</c:if>>
								Menu
							</option>

							<option value="1" <c:if test="${option.optionType eq 'MENU_ITEM'}">selected</c:if>>
								Menu Item
							</option>

							<option value="2" <c:if test="${option.optionType eq 'SEPERATOR'}">selected</c:if>>
								Separator
							</option>
						</select>
					</div>

					<div class="col-md-3 form-group">
						<label class="control-label">Option Status</label>
						<select class="form-control" name="optStatus">
							<option value="0" <c:if test="${option.optionStatus eq 'INACTIVE'}">selected</c:if>>
								Inactive
							</option>

							<option value="1" <c:if test="${option.optionStatus eq 'ACTIVE'}">selected</c:if>>
								Active
							</option>

							<option value="2" <c:if test="${option.optionStatus eq 'DELETED'}">selected</c:if>>
								Deleted
							</option>
						</select>
					</div>

					<div class="col-md-3 form-group">
						<label class="control-label">Option Name</label>
						<input class="form-control" type="text" name="optName" value="${option.optionName}" />
					</div>

					<div class="col-md-3 form-group">
						<label class="control-label">Toolbox Item</label>
						<select class="form-control" name="optEnableToolbox">
							<option value="false" <c:if test="${not option.enableToolbox}">selected</c:if>> Disabled</option>
							<option value="true" <c:if test="${option.enableToolbox}">selected</c:if> >Enabled</option>
						</select>
					</div>
				</div>

				<div class="row">
					<div class="col-md-3 form-group">
						<label class="control-label">Option Order</label>
						<input class="form-control" type="text" name="optOrder" value="${option.optionOrder}">
					</div>

					<div class="col-md-3 form-group">
						<label class="control-label">Option Icon</label>
						<input class="form-control" type="text" name="optIcon" value="${option.optionIcon}">
					</div>

					<div class="col-md-6 form-group">
						<label class="control-label">Option Description</label>
						<textarea class="form-control" name="optDesc">${option.optionDescription}</textarea>
					</div>
				</div>

				<div class="row">
					<div class="col-md-3 form-group">
						<label class="control-label">Option Link</label>
						<input class="form-control" type="text" value="${pageContext.request.contextPath}/" readonly>
					</div>

					<div class="col-md-3 form-group">
						<label class="control-label">&nbsp;</label>
						<input class="form-control" type="text" name="optLink" value="${option.optionLink}">
					</div>
				</div>

				<%-- <div class="row">
					<div class="col-md-4 form-group">
						<label class="control-label">Option Image Link</label>
						<input class="form-control" type="text" value="${pageContext.request.contextPath}/" readonly>
					</div>
					<div class="col-md-4 form-group">
						<label class="control-label">&nbsp;</label> <input
							class="form-control" type="text" name="optImgLink"
							value="${option.optionImageLink}" class="input-width-double" />
					</div>
					<div class="col-md-4 form-group">
						<label class="control-label">Option Image Alt</label>
						<input class="form-control" type="text" name="optImgAlt" value="${option.optionImageAlt}">
					</div>
				</div> --%>

				<div class="row">
					<div class="col-md-12">
						<input class="btn btn-md btn-primary" type="submit" value="Save Option">
					</div>
				</div>
			</div>
		</div>
	</form>
<%@ include file="../../cmn/tail.jsp"%>
