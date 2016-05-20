<aside class="col-md-3 hidden-xs hidden-sm">
	<%-- <div class="panel panel-info">
		<div class="panel-heading">
			<div class="panel-title">
				<span class="fa fa-users fa-fw"></span> Community <c:if test="${true}"><span class="fa fa-asterisk fa-fw pull-right"></span></c:if>
			</div>
		</div>
		<div class="panel-body">
	<c:choose>
		<c:when test="${not empty organization}">
			<table style="width: 100%;">
				<tr>
					<td colspan="2"><b>${organization.organizationName}</b></td>
				</tr>
				<tr>
					<td>${organization.organizationId}</td>
					<td>${organization.organizationStatus}</td>
				</tr>
				<tr></tr>
				<!-- DO NOT DELETE this tr tag, this is for eliminating the white row -->
				<tr>
					<td colspan="2"><c:if
							test="${not empty organization.organizationPrimaryPhone}">
							<img alt="Phone"
								src="${pageContext.request.contextPath}/__sys/img/phone-16-16.png">${organization.organizationPrimaryPhone}<br>
						</c:if> <c:if test="${not empty organization.organizationPrimaryFax}">
							<img alt="Phone"
								src="${pageContext.request.contextPath}/__sys/img/fax-16-16.png">${organization.organizationPrimaryFax}<br>
						</c:if> <c:if test="${not empty organization.organizationPrimaryEmail}">
							<img alt="Phone"
								src="${pageContext.request.contextPath}/__sys/img/mail-16-16.png">${organization.organizationPrimaryEmail}<br>
						</c:if></td>
				</tr>
			</table>
		</c:when>
		<c:otherwise>No community in context</c:otherwise>
	</c:choose>
		</div>
	</div>

	<div class="panel panel-default">
		<div class="panel-heading">
			<div class="panel-title">Warnings</div>
		</div>
		<div class="panel-body">
			Payment Due<br /> Next due date: 11/5/2014
		</div>
	</div>
	
	<div class="panel panel-primary">
		<div class="panel-heading">
			<div class="panel-title">Toolbox Name</div>
		</div>
		<div class="panel-body">
			Information
		</div>
	</div>

	<div class="panel panel-success">
		<div class="panel-heading">
			<div class="panel-title">Toolbox Name</div>
		</div>
		<div class="panel-body">
			Information
		</div>
	</div>

	<div class="panel panel-info">
		<div class="panel-heading">
			<div class="panel-title">Toolbox Name</div>
		</div>
		<div class="panel-body">
			Information
		</div>
	</div>

	<div class="panel panel-warning">
		<div class="panel-heading">
			<div class="panel-title">Toolbox Name</div>
		</div>
		<div class="panel-body">
			Information
		</div>
	</div> --%>

	<div class="panel panel-danger">
		<div class="panel-heading">
			<div class="panel-title">Dangerous Alert</div>
		</div>
		<div class="panel-body">
			Dangerous stuff occurred!!!
		</div>
	</div>
</aside>
