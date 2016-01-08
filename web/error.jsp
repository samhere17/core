<%@include file="cmn/head.jsp" %>
<form class="" action="" method="post">
	<input type="hidden" name="serviceName" value="">
	<input type="hidden" name="roleId" value="${umsSession.roleId}">
	<input type="hidden" name="userId" value="${umsSession.userId}">
	<input type="hidden" name="errorMessage" value="${errorMessage}">
	<%-- <input type="hidden" name="stackTrace" value="${stackTrace}"> --%>
	<div class="panel panel-danger">
		<div class="panel-heading">
			<div class="panel-title">An error has occurred!</div>
		</div>
		<div class="panel-body">
			<div class="row">
				<div class="col-md-12 form-group">
					<label class="control-label" for="name">Error Message</label>
					<div class="alert alert-danger">${errorMessage}</div>
				</div>
				<div class="col-md-12 form-group">
					<label for="" class="control-label">Enter some additional details (Optional)</label>
					<textarea class="form-control" rows="10" cols="50" placeholder="What were you trying to do when the error occured?"></textarea>
				</div>
			</div>
			<div class="row">
				<div class="col-md-12">
					<input class="btn btn-danger" type="submit" value="Submit Error Report">
				</div>
			</div>
		</div>
	</div>
</form>
<c:if test="${umsSession.roleId == 1}">
	<div class="panel panel-danger">
		<div class="panel-heading">
			<div class="panel-title">Super Admin Area</div>
		</div>
		<div class="panel-body">
			<div class="row">
				<div class="well" id="stack-trace">${stackTrace}</div>
			</div>
		</div>
	</div>
</c:if>
<%@include file="cmn/tail.jsp" %>
