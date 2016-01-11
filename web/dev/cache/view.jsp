<%@include file="../../cmn/head.jsp"%>
	<div class="panel panel-danger">
		<div class="panel-heading">
			<h1 class="panel-title">Cache Details</h1>
		</div>
		<table class="table table-bordered">
			<thead>
				<tr>
					<th>Region Name</th>
					<th>Element Key</th>
					<th>Element Value</th>
				</tr>
			</thead>

			<tbody>
				<c:choose>
					<c:when test="${not empty RegionDataList}">
						<c:forEach items="${RegionDataList}" var="current">
							<c:forEach items="${current.cacheRegionDataVOs}"
								var="currentElement">
								<tr>
									<td>${current.regionName}</td>
									<td>${currentElement.key}</td>
									<td>${currentElement.value}</td>
								</tr>
							</c:forEach>
						</c:forEach>
					</c:when>

					<c:otherwise>
						<tr>
							<td>No cache item found.</td>
						</tr>
					</c:otherwise>
				</c:choose>
			</tbody>
		</table>
	</div>
<%@include file="../../cmn/tail.jsp"%>
