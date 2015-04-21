<%@page import="org.iq.cache.regions.CacheRegion"%>
<%@page import="java.util.Set"%>
<%@page import="org.iq.cache.CacheHelper"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<title>OMS::iquesters</title>
<%@include file="/__sys/cmn/styles.jsp"%>
<%@include file="/__sys/cmn/scripts.jsp"%>
<style media="screen" type="text/css">
table#permissions div.child-contents {
	margin: 4px 4px;
	float: left;
}

table#permissions img {
	width: 16px;
	height: 16px;
	float: left;
	border: 1px solid #aaa;
	padding: 2px;
}
</style>
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
			<table id="list-table" class="table-sorter">
				<thead>
					<tr>
						<th>Cache Region Name</th>
						<th>Cache Element Key</th>
						<th>Cache Element Value</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${RegionDataList}" var="current">
						<c:forEach items="${current.cacheRegionDataVOs}" var="currentElement">
						<tr>
							<td>${current.regionName}</td>
							<td>${currentElement.key}</td>
							<td>${currentElement.value}</td>
						</tr>
						</c:forEach>
					</c:forEach>
				</tbody>
			</table>
		</div>
		<%@include file="/__sys/cmn/footer.jsp"%>
	</div>
</body>
</html>