<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<title>OMS::iquesters</title>
<%@include file="/__sys/cmn/styles.jsp"%>
<%@include file="/__sys/cmn/scripts.jsp"%>
<style media="screen" type="text/css">
div.configured-options {
	/* width: 350px;
	overflow-y: auto; */
	
}

div.configured-options>ul {
	
}

div.configured-options>ul>li {
	border: 1px solid #057;
	margin-bottom: 2px;
	padding: 4px;
}

div.configured-options>ul>li>div>div.contents {
	float: left;
	/* width: 280px; */
	text-align: left;
}

div.configured-options>ul>li>div>div.actions {
	float: right;
}

div.configured-options>ul>li>div>div.actions>a {
	float: left;
}

div.configured-options>ul>li>div>div.actions>form {
	display: inline-block;
}

div.configured-options>ul>li>div>ul {
	border-top: 1px solid #ddd;
	margin-top: 5px;
}

div.configured-options>ul>li>div>ul>li {
	border-bottom: 1px solid #ddd;
	padding: 4px;
	margin-left: 15px;
}

div.configured-options>ul>li>div>ul>li>div {
	
}

div.configured-options>ul>li>div>ul>li>div>img {
	width: 16px;
	height: 16px;
	float: left;
	border: 1px solid #aaa;
	padding: 2px;
}

div.configured-options>ul>li>div>ul>li>div>div.contents {
	margin-left: 5px;
	float: left;
	/* width: 215px; */
	text-align: left;
}

div.configured-options>ul>li>div>ul>li>div>div.actions {
	float: right;
}

div.configured-options>ul>li>div>ul>li>div>div.actions>a {
	float: left;
}

div.configured-options>ul>li>div>ul>li>div>div.actions>form {
	display: inline-block;
}

div.configured-options div.contents span {
	
}

div.configured-options div.contents span.main {
	display: block;
}

div.configured-options div.contents span.sub {
	font-size: 10px;
}
</style>

</head>
<body>
	<%
		String header = "Options";
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
							src="${pageContext.request.contextPath}/img/opt-new-16-16.png"
							alt="New Option" title="New Option" />
						<h3>Configured Options</h3>
					</div>
					<div class="form-content">


						<div class="configured-options">
							<c:if test="${not empty optionsList}">
								<ul>
									<c:forEach items="${optionsList}" var="currentParent">
										<c:if test="${currentParent.optionType == 'MENU'}">
											<c:choose>
												<c:when test="${currentParent.optionStatus == 'ACTIVE'}"><li style="background: #cfc;"></c:when>
												<c:when test="${currentParent.optionStatus == 'INACTIVE'}"><li style="background: #eee;"></c:when>
												<c:when test="${currentParent.optionStatus == 'DELETED'}"><li style="background: #fcc;"></c:when>
												<c:otherwise><li></c:otherwise>
											</c:choose>
											<div>
												<div class="contents">
													<span class="main"><b>${currentParent.optionName}</b><span class="sub"> Option ID : <b>${currentParent.optionId}</b>, Status : <b>${currentParent.optionStatus}</b>, Option Order : <b>${currentParent.optionOrder}</b></span></span>
													<span class="main"><span class="sub">${currentParent.optionDescription}</span></span>
													<span class="main"><span class="sub">Child Options Count : ${fn:length(currentParent.childOptions)}</span></span>
												</div>
												<div class="actions">
													<form method="get" action="${pageContext.request.contextPath}/adapter">
														<input type="hidden" name="serviceName" value="GetOption" />
														<input type="hidden" name="path" value="__sys/opt/edit" />
														<input type="hidden" name="optId" value="${currentParent.optionId}" />
														<input type="image" src="${pageContext.request.contextPath}/__sys/img/edit-16-16.png" alt="Edit" title="Edit" class="icon" />
													</form>
													<c:if test="${currentChild.optionStatus != 'DELETED' and fn:length(currentParent.childOptions) eq 0}">
														<form method="post" action="${pageContext.request.contextPath}/adapter">
															<input type="hidden" name="serviceName" value="GetOption" />
															<input type="hidden" name="path" value="__sys/opt/delete" />
															<input type="hidden" name="optId" value="${currentParent.optionId}" />
															<input type="image"	src="${pageContext.request.contextPath}/__sys/img/delete-16-16.png" alt="Delete" title="Delete" class="icon" />
														</form>
													</c:if>
												</div>
												<div class="clear"></div>

												<c:if test="${not empty currentParent.childOptions}">
													<ul>
														<c:forEach items="${currentParent.childOptions}"
															var="currentChild">
															<c:choose>
																<c:when test="${currentChild.optionStatus == 'ACTIVE'}"><li style="background: #cfc;"></c:when>
																<c:when test="${currentChild.optionStatus == 'INACTIVE'}"><li style="background: #eee;"></c:when>
																<c:when test="${currentChild.optionStatus == 'DELETED'}"><li style="background: #fcc;"></c:when>
																<c:otherwise><li></c:otherwise>
															</c:choose>
																<div>
																	<c:choose>
																		<c:when
																			test="${currentChild.optionType == 'MENU_ITEM'}">
																			<img
																				src="${pageContext.request.contextPath}/${currentChild.optionImageLink}"
																				alt="${currentChild.optionImageAlt}" />
																			<div class="contents">
																				<span class="main"><b>${currentChild.optionName}</b><span
																					class="sub"> Option ID : <b>${currentChild.optionId}</b>,
																						Status : <b>${currentChild.optionStatus}</b>,
																						Option Order : <b>${currentChild.optionOrder}</b></span></span>
																				<span class="main"><span class="sub">${currentChild.optionDescription}</span></span>
																				<span class="main"><span class="sub">Link
																						: <b>${currentChild.optionLink}</b>
																				</span></span> <span class="main"><span class="sub">Image
																						Link : <b>${currentChild.optionImageLink}</b>,
																						Image Alt : <b>${currentChild.optionImageAlt}</b>
																				</span></span> <span class="main"><span class="sub">Toolbox
																						Item : <b>${currentChild.enableToolbox}</b>,
																						Object Referenc Key : <b>${currentChild.objectReferenceKey}</b>
																				</span></span>
																			</div>
																		</c:when>
																		<c:when test="${currentChild.optionType == 'SEPERATOR'}">
																			<div class="contents">
																				<span class="main"><b>Separator</b><span
																					class="sub"> Option ID : <b>${currentChild.optionId}</b>,
																						Status : <b>${currentChild.optionStatus}</b>,
																						Option Order : <b>${currentChild.optionOrder}</b></span></span>
																			</div>
																		</c:when>
																		<c:otherwise>
																		</c:otherwise>
																	</c:choose>

																	<div class="actions">
																		<form method="get" action="${pageContext.request.contextPath}/adapter">
																			<input type="hidden" name="serviceName" value="GetOption" />
																			<input type="hidden" name="path" value="__sys/opt/edit" />
																			<input type="hidden" name="optId" value="${currentChild.optionId}" />
																			<input type="image" src="${pageContext.request.contextPath}/__sys/img/edit-16-16.png" alt="Edit" title="Edit" class="icon" />
																		</form>
																		<c:if test="${currentChild.optionStatus != 'DELETED'}">
																			<form method="get" action="${pageContext.request.contextPath}/adapter">
																				<input type="hidden" name="serviceName" value="GetOption" />
																				<input type="hidden" name="path" value="__sys/opt/delete" />
																				<input type="hidden" name="optId" value="${currentChild.optionId}" />
																				<input type="image"	src="${pageContext.request.contextPath}/__sys/img/delete-16-16.png" alt="Delete" title="Delete" class="icon" />
																			</form>
																		</c:if>
																	</div>
																	<div class="clear"></div>
																</div>
															</li>
														</c:forEach>
													</ul>
												</c:if>
											</div>
										</li>
										</c:if>
									</c:forEach>
								</ul>
							</c:if>
						</div>
					</div>
					<div class="form-actions">
						<!-- <input type="submit" value="Save" /> -->
					</div>
				</div>
			</div>
		</div>
		<%@include file="/__sys/cmn/footer.jsp"%>
	</div>
</body>
</html>