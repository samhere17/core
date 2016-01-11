<%@include file="../cmn/head.jsp" %>
<c:choose>
	<c:when test="${not empty param.mypage}">
		<c:set var="mypageurl" value="../gen/${param.mypage}.jsp"></c:set>
		<jsp:include page="${mypageurl}"/>
	</c:when>
	<c:otherwise>
		mypage parameter not passed
	</c:otherwise>
</c:choose>
<%@include file="../cmn/tail.jsp" %>