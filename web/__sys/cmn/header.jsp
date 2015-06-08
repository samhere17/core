<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@page import="org.iq.ums.vo.UmsSession"%>
<%@page import="org.iq.util.StringUtil"%>
<div class="header">Operations Management System<%=StringUtil.isEmpty(header)?"":" - "+header%></div>

<c:choose>
	<c:when test="${not empty umsSession}">
		<c:choose>
			<c:when test="${umsSession.sessionValid}">
				<div class="user-info">
				<div class="user-info-header">${umsSession.userDetails.userFirstName} ${umsSession.userDetails.userLastName}</div>
					<div class="user-info-details">
						Last login: 
							<fmt:formatDate type="date"
								value="${umsSession.lastLoginDetails.loginTime}" />, <fmt:formatDate type="time"
								value="${umsSession.lastLoginDetails.loginTime}" /><br><br>
						<form method="post"
							action="${pageContext.request.contextPath}/adapter"
							style="display: inline;">
							<input type="hidden" name="serviceName" value="Logout" /> <input
								type="hidden" name="jSessionId"
								value="${pageContext.session.id}" />
								<input type="submit" id="btn-logout" value="Logout" style="margin: 0" />
						</form>
					</div>
				</div>
			</c:when>
			<c:otherwise>
				<c:redirect url="/index.jsp"></c:redirect>
			</c:otherwise>
		</c:choose>
	</c:when>
	<c:otherwise>
		<c:redirect url="/index.jsp"></c:redirect>
	</c:otherwise>
</c:choose>


<div id="overlay" class="dialog-overlay"></div>
<div id="loading-div" class="loading-window">
	<img src="${pageContext.request.contextPath}/__sys/img/loading.gif" />
	<div>Please wait, system is processing...</div>
</div>

<style media="screen" type="text/css">
.header {
	background: #8df;
	box-shadow: 0px 5px 20px #057 inset;
	font-size: 14px;
	height: 15px;
	padding: 5px;
}

.user-info {
	background-color: #fff;
	border: 1px solid #057;
	border-top: none;
	position: absolute;
	top: 0; right: 3px;
	text-align: right;
	z-index: 1;
}

.user-info-header {
	cursor: pointer;
	padding: 10px;
}

.user-info-details {
	border-top: 1px solid #057;
	display: none;
	margin-top: 10px;
	padding: 10px;
	text-align: left;
	width: 250px;
}

.user-info-details > fieldset {
	padding: 5px;
}

.loading-window {
	display: none;
	position: fixed;
	width: 256px;
	top: 50%;
	left: 50%;
	margin-left: -128px;
	margin-top: -16px;
	background-color: #ffffff;
	border: 1px solid #057;
	z-index: 102;
	padding: 20px;
}

.loading-window>img {
	float: left;
}

.loading-window>div {
	float: left;
	padding-left: 15px;
	line-height: 32px;
}
</style>
<script type="text/javascript">
$('html').click(function() {
	if($('.user-info-details').is(':visible')){
		$('.user-info-details').slideToggle(200);
	}
});

$(document)
	.ajaxStart(function () {
		$("#overlay").fadeIn(200);
		$('#loading-div').fadeIn(200);
	})
	.ajaxStop(function () {
		$("#overlay").fadeOut(200);
		$('#loading-div').fadeOut(200);
	})
	.ready(function() {
		$('.user-info').click(function(event) {
			event.stopPropagation();
			$('.user-info-details').slideToggle(200);
		});
		
		$('.user-info-details').click(function(event) {
			event.stopPropagation();
		});
		
		$('#btn-logout').click(function() {
			localStorage.clear();
		});
	});
</script>