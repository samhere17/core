<%@include file="../cmn/head.jsp" %>
<form class="" action="" method="post">
	<input type="hidden" name="requested-action" value="">
	<div class="panel panel-info">
		<div class="panel-heading">
			<div class="panel-title">Contact AMS Support</div>
		</div>
		<div class="panel-body">
			<div class="row">
				<div class="col-md-12 form-group">
					<p>Need help? Save time by sending your support request online. We'll connect you to an expert.</p>
				</div>
			</div>
			<div class="row">
				<div class="col-md-4">
					<div class="row">
						<div class="col-md-12 form-group">
							<label for="" class="control-label">Name</label>
							<input class="form-control" id="comm-name" type="text" value="${umsSession.userDetails.userFirstName} ${umsSession.userDetails.userLastName}" readonly>
						</div>
					</div>
					<div class="row">
						<div class="col-md-12 form-group">
							<label for="" class="control-label">Primary Email</label>
							<input class="form-control" id="comm-name" type="text" value="${umsSession.userDetails.primaryEmail}" readonly>
						</div>
					</div>
					<div class="row">
						<div class="col-md-12 form-group">
							<label for="" class="control-label">Secondary Email</label>
							<input class="form-control" id="comm-name" type="text" value="${umsSession.userDetails.alternateEmail}" readonly>
						</div>
					</div>
					<div class="row">
						<div class="col-md-6 form-group">
							<label for="" class="control-label">Primary Phone</label>
							<input class="form-control" id="comm-name" type="text" value="${umsSession.userDetails.primaryPhone}" readonly>
						</div>
						<div class="col-md-6 form-group">
							<label for="" class="control-label">Secondary Phone</label>
							<input class="form-control" id="comm-name" type="text" value="${umsSession.userDetails.alternatePhone}" readonly>
						</div>
					</div>
				</div>
				<div class="col-md-8">
					<div class="row">
						<div class="col-md-12 form-group">
							<label for="" class="control-label">Subject</label>
							<input class="form-control" id="comm-name" type="text" required>
						</div>
					</div>
					<div class="row">
						<div class="col-md-12 form-group">
							<label for="" class="control-label">Message</label>
							<textarea class="form-control" rows="9" required></textarea>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<div class="row">
		<div class="col-md-12">
			<button class="btn btn-primary" type="submit">
				<span class="fa fa-send-o"></span> Send
			</button>
		</div>
	</div>
</form>
<%@include file="../cmn/tail.jsp" %>