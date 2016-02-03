<%@include file="../cmn/head.jsp" %>
<c:choose>
	<c:when test="${not empty param.page}">
		<c:set var="pageurl" value="../gen/${param.page}.jsp"></c:set>
		<jsp:include page="${pageurl}"/>
	</c:when>
	<c:otherwise>
		page parameter not passed
	</c:otherwise>
</c:choose>
<%@include file="../cmn/tail.jsp" %>