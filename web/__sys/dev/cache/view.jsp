<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<title>OMS::iquesters</title>
<%@include file="/__sys/cmn/styles.jsp"%>
<%@include file="/__sys/cmn/scripts.jsp"%>
</head>
<body>
	<%
		String header = "Cache Details";
	%>
	<div class="wrapper">
		<%@include file="/__sys/cmn/header.jsp"%>
		<%@include file="/__sys/cmn/menu.jsp"%>

		<div class="bodycontent">
			<div class="toolboxarea">
				<%@include file="/__sys/cmn/toolbox.jsp"%>
			</div>
			<div class="workarea">
				<div class="form-container">
					<div class="form-header">
						<img
							src="${pageContext.request.contextPath}/__sys/img/server-info-16-16.png"
							alt="Server Information" title="Server Information" />
						<h3>Cache Details</h3>
					</div>
					<div class="form-content">
						<table id="cache-details" class="table-sorter">
							<thead>
								<tr>
									<th>Region Name</th>
									<th>Element Key</th>
									<th>Element Value</th>
									<th style="width: 9px;"></th>
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
													<td></td>
												</tr>
											</c:forEach>
										</c:forEach>
										<script type="text/javascript">
										$(document).ready(function() {
											$("#cache-details").tablesorter({
												// pass the headers argument and assing a object
												headers: {
													// assign the first column (we start counting zero)
													2: {
														// disable it by setting the property sorter to false
														sorter: false
													},
													// assign the first column (we start counting zero)
													3: {
														// disable it by setting the property sorter to false
														sorter: false
													}
												},
												// sort on the second column(1), order asc(0) and first column(0), order asc(0)
												sortList: [[0,0],[1,0]]
											});
										});
										</script>
									</c:when>
									<c:otherwise>
										<tr>
											<td colspan="6" style="text-align: center;">No cache
												item found.</td>
										</tr>
									</c:otherwise>
								</c:choose>
							</tbody>
						</table>
						<div class="clear"></div>
					</div>
					<!-- <div class="form-actions"></div> -->
				</div>
			</div>
		</div>
		<%@include file="/__sys/cmn/footer.jsp"%>
	</div>
</body>
</html>