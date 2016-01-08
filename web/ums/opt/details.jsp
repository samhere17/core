<%@ include file="../../cmn/head.jsp" %>
	<form>
		<div class="panel panel-info">
			<div class="panel-heading">
				<div class="panel-title">
					Option Details
				</div>
			</div>

			<div class="panel-body">
				<div class="alert alert-warning alert-dismissible" role="alert">
					<button type="button" class="close" data-dismiss="alert" aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<strong>Warning!</strong> If new option is added, remember to add role mapping, else it will always be disabled.
				</div>

				<div class="alert alert-warning alert-dismissible" role="alert">
					<button type="button" class="close" data-dismiss="alert" aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<strong>Warning!</strong> If option is edited, remember to check option list to confirm order.
				</div>

				<div class="row">
					<div class="col-md-3 form-group">
						<label class="control-label">Option Id</label>
						<input class="form-control" type="text" value="${option.optionId}" readonly>
					</div>

					<div class="col-md-3 form-group">
						<label class="control-label">Option Type</label>
						<input class="form-control" type="text" value="${option.optionType}" readonly>
					</div>

					<div class="col-md-3 form-group">
						<label class="control-label">Option Area</label>
						<input class="form-control" type="text" value="${option.optionArea}" readonly>
					</div>

					<div class="col-md-3 form-group">
						<label class="control-label">Option Status</label>
						<input class="form-control" type="text" value="${option.optionStatus}" readonly>
					</div>
				</div>

				<div class="row">
					<div class="col-md-3 form-group">
						<label class="control-label">Option Order</label>
						<input class="form-control" type="text" value="${option.optionOrder}" readonly />
					</div>
					<div class="col-md-3 form-group">
						<label class="control-label">Option Name</label>
						<input class="form-control" type="text" value="${option.optionName}" readonly />
					</div>
					<div class="col-md-6 form-group">
						<label class="control-label">Option Description</label>
						<textarea class="form-control" readonly>${option.optionDescription}</textarea>
					</div>
				</div>
				<div class="row">
					<div class="col-md-12 form-group">
						<label class="control-label">Option Link</label>
						<input class="form-control" type="text" value="${option.optionLink}" readonly />
					</div>
				</div>
				<div class="row">
					<div class="col-md-3 form-group">
						<label class="control-label">Option Icon</label>
						<input class="form-control" type="text" value="${option.optionIcon}" readonly />
					</div>
					<div class="col-md-3 form-group text-center">
						<span class="fa fa-5x fa-user"></span>
					</div>
					<div class="col-md-3 form-group">
						<label class="control-label">Parent Option Id</label>
						<input class="form-control" type="text" value="${option.parentOptionId}" readonly />
					</div>
					<div class="col-md-3 form-group">
						<label class="control-label">Object Reference</label>
						<input class="form-control" type="text" value="${option.objectReferenceKey}" readonly />
					</div>
				</div>
			</div>
		</div>
	</form>
<%@ include file="../../cmn/tail.jsp" %>
