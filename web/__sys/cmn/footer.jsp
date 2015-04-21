<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<jsp:useBean id="now" class="java.util.Date" />
<fmt:formatDate var="currentYear" value="${now}" pattern="yyyy" />

<style media="screen" type="text/css">
.footer {
	background-color: #cef;
	border-top: 1px solid #057;
	height: 16px;
	font-size: 10px;
	position: absolute;
	bottom: 0;
	width: 100%;
}

.footer a {color: #666; font-size: 10px; text-decoration: none;}
.footer a:hover {color: #666; font-size: 10px; text-decoration: underline;}
</style>

<div class="footer">
	<div style="width: 49%; float: left; text-align: left; padding: 2px;">
		This application runs best at 1024 X 768 screen resolution on <a
			href="https://www.google.com/intl/en/chrome/browser/"
			title="Get Google Chrome here..." accesskey="">Chrome</a> browser.
	</div>
	<div style="width: 50%; float: left; text-align: right; padding: 2px;">
		Copyright&nbsp;&copy;&nbsp;2012-${currentYear}&nbsp;<a href="http://www.iquesters.com" title="Click to visit official site of iquester [Alt+I]" accesskey="I">iquesters</a>.&nbsp;All rights reserved.
	</div>
</div>

