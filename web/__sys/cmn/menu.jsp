<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<style media="screen" type="text/css">
.menubar {
	background-color: #ddd;
	border-top: 1px solid #057;
	border-bottom: 1px solid #057;
	height: 28px;
	/* color: #222;
	font-size: 12px; */
	padding: 0px 2px;
}

.menubar > .left {float: left;}
.menubar > .right {float: right; /* padding: 6px 3px 0px 0px; */}

nav {}
nav > ul{}
nav > ul > li{display: inline-block; position: relative;}
nav > ul > li > a {border:1px solid #dddddd; color:#000; float:left; padding: 6px 3px; text-decoration:none;}
nav > ul > li > a:hover {background-color: #eee;border:1px solid #aaa;}
nav>ul>li>ul {background-color: #dddddd; border:1px solid #aaa; display:none; position:absolute; top:24px; z-index:9999; max-height:400px; min-width: 250px; overflow-x: hidden; overflow-y: auto; overflow-wrap: normal;}
nav>ul>li:hover>ul {display:block;}
nav>ul>li>ul>hr {background-color: #eee; margin: 0px 0px;}
nav>ul>li>ul>li {border:1px solid #dddddd;;height:15px; padding: 4px 4px 4px 4px;position:relative;}
nav>ul>li>ul>li:hover {background-color: #eee;border:1px solid #aaa;}
nav>ul>li>ul>li>img {width:16px; height:16px;}
nav>ul>li>ul>li>a {color: #000; display: block; font-size: 12px; position: absolute; top: 0px; left: 19px; text-decoration: none; width: 90%; padding: 5px;}
nav>ul>li>ul>li>a:hover, nav>ul>li>ul>li>a.selected {}
nav>ul>li>ul>li>div {color: #999; display: block; font-size: 12px; position: absolute; top: 0px; left: 19px; padding: 5px;}

nav>ul>li>ul>li>span {float: right; font-size: 10px; /*font-weight: bold;*/ margin: 2px 0 0 0;}
nav>ul>li>ul>li>span.executive:after {color: #090; content:"Executive";}
nav>ul>li>ul>li>span.manager:after {color: #c50; content:"Manager";}
nav>ul>li>ul>li>span.admin:after {color: #f00; content:"Admin";}
nav>ul>li>ul>li>span.super-admin:after {color: #f00; content:"Super Admin";}

/* div.menubar > div.right > div#role-selector > select {margin: -4px 0 0 0;} */

.toolbar {background-color: #ddd; border-bottom: 1px solid #057; display: table; padding: 1px 0px; width: 100%;}
.toolbar > ul {border-right: 1px solid #057; display: inline-table; padding: 0 1px;}
.toolbar > ul > li {display: inline-table;}
.toolbar > ul > li > a {}
.toolbar > ul > li > a:hover {}
.toolbar > ul > li > img {height: 16px; width: 16px; padding: 4px; -webkit-filter: grayscale(100%);}
.toolbar > ul > li > a > img {height: 16px; width: 16px; padding: 4px;}
.toolbar > ul > li > a:hover > img {border: 1px solid #057; border-radius: 3px; box-shadow: 0px 0px 5px #057 inset; padding: 3px;}

</style>

<script type="text/javascript">
$(document).ready(function(){
	$('div.toolbar img').error(function () {
		$(this).unbind("error").attr("src", "${pageContext.request.contextPath}/__sys/img/no-icon-found-16-16.png");
	});
});
</script>

<!--MENUBAR STARTS-->
<div class="menubar">
	<c:if test="${not empty menuOptions}">
	<div class="left">
		<nav>
			<ul>
				<c:forEach items="${menuOptions}" var="currentParent">
					<li>
						<a href="#">${currentParent.optionName}</a>
						<c:if test="${not empty currentParent.childOptions}">
							<ul>
								<c:forEach items="${currentParent.childOptions}" var="currentChild">
									<c:choose>
										<c:when test="${currentChild.menuItemSeparator}">
											<hr>
										</c:when>
										<c:otherwise>
											<li>
												<c:choose>
													<c:when test="${currentChild.menuItemEnabled}">
														<img src="${pageContext.request.contextPath}/<c:choose><c:when test="${not empty currentChild.optionImageLink}">${currentChild.optionImageLink}</c:when><c:otherwise>__sys/img/no-icon-16-16.png</c:otherwise></c:choose>" alt="${currentChild.optionImageAlt}" />
														<a href="${pageContext.request.contextPath}/adapter?path=${currentChild.optionLink}" <%-- title="${currentChild.optionDescription}" --%> accesskey="">${currentChild.optionName}</a>
													</c:when>
													<c:otherwise>
														<img src="${pageContext.request.contextPath}/<c:choose><c:when test="${not empty currentChild.optionImageLink}">${currentChild.optionImageLink}</c:when><c:otherwise>__sys/img/no-icon-16-16.png</c:otherwise></c:choose>" alt="${currentChild.optionImageAlt}" style="-webkit-filter: grayscale(100%);"/>
														<div>${currentChild.optionName}</div>
													</c:otherwise>
												</c:choose>
												<span></span>
											</li>
										</c:otherwise>
									</c:choose>
								</c:forEach>
							</ul>
						</c:if>
					</li>
				</c:forEach>
			</ul>
		</nav>
	</div>
	</c:if>
</div>
<!--MENUBAR ENDS-->

<!--TOOLBAR STARTS-->
<div class="toolbar">
<c:choose>
<c:when test="${umsSession.roleId == 1}">
	<ul><li><a href="${pageContext.request.contextPath}/adapter?path=__sys/home" title="Home" acceskey=""><img src="${pageContext.request.contextPath}/__sys/img/home-16-16.png" alt="Home" title="Home" /></a></li></ul>
</c:when>
<c:otherwise>
	<ul><li><a href="${pageContext.request.contextPath}/adapter?path=home" title="Home" acceskey=""><img src="${pageContext.request.contextPath}/__sys/img/home-16-16.png" alt="Home" title="Home" /></a></li></ul>
</c:otherwise>
</c:choose>
	<c:if test="${not empty menuOptions}">
		<c:forEach items="${menuOptions}" var="currentParent">
			<c:if test="${not empty currentParent.childOptions}">
				<ul>
					<c:forEach items="${currentParent.childOptions}" var="currentChild">
						<c:if test="${currentChild.menuItemToolItem}">
							<c:choose>
								<c:when test="${currentChild.menuItemEnabled}">
									<li><a href="${pageContext.request.contextPath}/adapter?path=${currentChild.optionLink}" title="${currentChild.optionName}" acceskey=""><img src="${pageContext.request.contextPath}/${currentChild.optionImageLink}" alt="${currentChild.optionImageAlt}" /></a></li>
								</c:when>
								<c:otherwise>
									<li><img src="${pageContext.request.contextPath}/${currentChild.optionImageLink}" alt="${currentChild.optionImageAlt}" title="${currentChild.optionName}"/></li>
								</c:otherwise>
							</c:choose>
						</c:if>
					</c:forEach>
				</ul>
			</c:if>
		</c:forEach>
	</c:if>
</div>
<!--TOOLBAR ENDS-->