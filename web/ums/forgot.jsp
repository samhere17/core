<form>
	<div class="panel panel-info">
		<div class="panel-heading">
			<h4 class="panel-title">
				Forgot Password
			</h4>
		</div>

		<div class="panel-body">
			<div class="row">
				<div class="col-md-12">
					<div class="form-group has-feedback">
						<label class="control-label" for="email">Registered Email</label>
						<input id="email" class="form-control" type="email" name="email" required>

						<span class="glyphicon glyphicon-ok form-control-feedback hidden"></span>
						<span class="glyphicon glyphicon-remove form-control-feedback hidden"></span>

						<p class="error-msg text-danger small hidden">
							<strong>Enter registered email address</strong>
						</p>
					</div>
				</div>
			</div>

			<div class="row">
				<div class="col-md-12">
					<button class="btn btn-primary btn-sm" type="submit">
						Reset Password
					</button>
				</div>
			</div>
		</div>
	</div>
</form>
