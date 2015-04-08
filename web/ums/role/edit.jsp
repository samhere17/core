<%@page import="java.util.Date"%>
<%@page import="org.iq.util.DateUtil.DateFormat"%>
<%@page import="org.iq.util.DateUtil"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<%-- <c:set var="browserURL" value="${pageContext.request.requestURI}" scope="session"></c:set> --%>

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
		String header = "Edit Role";
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
					<form method="post" action="${pageContext.request.contextPath}/adapter">
						<input type="hidden" name="serviceName" value="UpdateRole" />
						<input type="hidden" name="roleId" value="${role.roleId}" />
						<div class="form-header">
							<img
								src="${pageContext.request.contextPath}/__sys/img/role-edit-16-16.png"
								alt="Edit Role" title="Edit Role" />
							<h3>Edit Role</h3>
						</div>
						<div class="form-content">
							<div class="fields-row">
								<div class="field-col">
									<label for="name">Role Name</label> <input type="text" name="roleName" value="${role.roleName}" required/>
									<div class="field-info-container">
										<div class="field-info">
											<div class="info-content">Name for this role.</div>
										</div>
									</div>
								</div>
								<div class="field-col">
									<label for="name">Role Description</label>
									<textarea name="roleDesc">${role.roleDescription}</textarea>
								</div>
							</div>
							<fieldset>
								<legend>Permissions</legend>
								<div class="fields-row">
									<c:if test="${not empty optionsList}">
										<c:set var="loopCount" value="1" />
										<c:forEach items="${optionsList}" var="currentParent">
											<div class="field-col">
												<c:if test="${not empty currentParent.childOptions}">
													<table id="permissions" class="input-width-double" style="margin: 2px;">
														<thead>
															<tr>
																<script type="text/javascript">
																	$(document).ready(function() {
																		$('#select-all-${currentParent.optionId}').click(function(event) { //on click
																			//alert("${currentParent.optionId} - ${currentParent.optionName}");
																			if (this.checked) { // check select status
																				$('.check-${currentParent.optionId}').each(function() { //loop through each checkbox
																					this.checked = true; //select all checkboxes with class "checkbox1"
																				});
																			} else {
																				$('.check-${currentParent.optionId}').each(function() { //loop through each checkbox
																					this.checked = false; //deselect all checkboxes with class "checkbox1"
																				});
																			}
																		});
																	});
																</script>

																<th style="width: 20px;"><input id="select-all-${currentParent.optionId}" name="option-${currentParent.optionId}" type="checkbox" <c:if test="${currentParent.menuItemEnabled}">checked</c:if>></th>
																<th><b>${currentParent.optionName} Menu</b></th>
															</tr>
														</thead>
														<tbody>
															<c:forEach items="${currentParent.childOptions}"
																var="currentChild">
																<c:if test="${currentChild.optionType == 'MENU_ITEM'}">
																	<tr>
																		<td><input class="check-${currentParent.optionId}" name="option-${currentChild.optionId}" type="checkbox" <c:if test="${currentChild.menuItemEnabled}">checked</c:if>></td>
																		<td><img
																			src="${pageContext.request.contextPath}/${currentChild.optionImageLink}"
																			alt="${currentChild.optionImageAlt}" />
																			<div class="child-contents">${currentChild.optionName}</div>
																		</td>
																	</tr>
																</c:if>
															</c:forEach>
														</tbody>
													</table>
												</c:if>
											</div>
											<c:if test="${loopCount%2 eq 0}">
												<div class="clear"></div>
											</c:if>
											<c:set var="loopCount" value="${loopCount+1}" />
										</c:forEach>
									</c:if>
								</div>
							</fieldset>
							<div class="clear"></div>
						</div>
						<div class="form-actions">
							<input type="submit" id="" value="Update Role" />
						</div>
					</form>
				</div>
			</div>
		</div>
		<%@include file="/__sys/cmn/footer.jsp"%>
	</div>
</body>
</html>