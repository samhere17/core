<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="org.iq.ums.UmsConstants.OptionType"%>
<%@page import="org.iq.ums.UmsConstants.OptionStatus"%>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
		<title>OMS::iquesters</title>
		<%@include file="/__sys/cmn/styles.jsp"%>
		<%@include file="/__sys/cmn/scripts.jsp"%>
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
	<form method="post" action="${pageContext.request.contextPath}/adapter">
		<input type="hidden" name="serviceName" value="InsertOption" />
		<div class="form-header">
			<img src="${pageContext.request.contextPath}/img/opt-new-16-16.png" alt="New Option" title="New Option"/>
			<h3>New Option</h3>
			<a href=""><img src="${pageContext.request.contextPath}/img/help.png" alt="Help" title="Help"/></a>
		</div>
						<div class="form-content">
								<div class="fields-row">
									<div class="multi-row-col">
										<div class="field-col">
											<label>Option Type</label>
											<select name="optType" required>
											<%
											for (OptionType thisOptionType : OptionType.values()) {
											%>
												<option value="<%=thisOptionType.getOptionTypeValue()%>"><%=thisOptionType.toString()%></option>
											<%
											}
											%>
											</select>
										</div>
										<div class="field-col">
											<label>Option Status</label>
											<select name="optStatus">
											<%
											for (OptionStatus thisOptionStat : OptionStatus.values()) {
											%>
												<option value="<%=thisOptionStat.getOptionStatusValue()%>"><%=thisOptionStat.toString()%></option>
											<%
											}
											%>
											</select>
										</div>
									</div>
									<div class="multi-row-col">
										<div class="field-col">
											<label>Option Name</label>
											<input type="text" name="optName" />
										</div>
										<div class="field-col">
											<label>Toolbox Item</label>
											<select name="optEnableToolbox">
												<option value="false">Disabled</option>
												<option value="true">Enabled</option>
											</select>
										</div>
									</div>
									<div class="field-col">
										<label>Option Description</label>
										<textarea name="optDesc"></textarea>
									</div>
									<div class="field-col">
										<label>Option Order</label>
										<input type="text" name="optOrder" value="0" style="text-align:right;"/>
									</div>
								</div>
								<div class="fields-row">
									<div class="field-col">
										<label>Option Link</label>
										<input type="text" value="${pageContext.request.contextPath}/" readonly />
									</div>
									<div class="field-col">
										<label>&nbsp;</label>
										<input type="text" name="optLink" class="input-width-double" />
									</div>
								</div>
								<div class="fields-row">
									<div class="field-col">
										<label>Option Image Link</label>
										<input type="text" value="${pageContext.request.contextPath}/" readonly style="float:left;"/>
									</div>
									<div class="field-col">
										<label>&nbsp;</label>
										<input type="text" name="optImgLink" class="input-width-double" />
									</div>
									<div class="field-col">
										<label>Option Image Alt</label>
										<input type="text" name="optImgAlt" />
									</div>
								</div>
								<div class="fields-row">
									<div class="field-col">
										<label>Object Reference</label>
										<input type="text" name="objRef" />
									</div>
								</div>
								<div class="fields-row">
									<div class="field-col">
										<label>Parent Option Id</label>
										<input type="text" id="parent-opt-id" name="optParentId" value="0" readonly style="text-align:right;"/>
									</div>
									<div class="field-col">
										<label>Parent Option Name</label>
										<input type="text" id="parent-opt-name" readonly/>
									</div>
									<div class="field-col">
										<label>&nbsp;</label>
										<input type="button" id="btnLookup" value="Lookup"/>
									</div>
								</div>
							<div class="clear"></div>
						</div>
						<div class="form-actions">
							<input type="submit" value="Save" />
						</div>
					</form>
				</div>
	
			
			</div>
		</div>
		<%@include file="/__sys/cmn/footer.jsp"%>
	</div>
	
	<script type="text/javascript">
$(document).ready(function() {
	$('#btnLookup').click(function(){
		showDialog("parent-options",false);
	});
	
	$("#close-dialog").click(function (e) {
		hideDialog("parent-options");
		e.preventDefault();
	});
	
	$("#select-parent").click(function(){
		var parentOption = $('input[name=parentOptionRadio]:checked').val();
		var arr = parentOption.split(':');
		$("#parent-opt-id").val(arr[0]);
		$("#parent-opt-name").val(arr[1]);
		hideDialog("parent-options");
	});
});
</script>

<div id="overlay" class="dialog-overlay"></div>
<div id="parent-options" class="dialog-window">
	<div class="dialog-header">
		<%-- <img src="<%=rootLink%>/img/user-add-26.png" alt="New User" title="New User"/> --%>
		<h3>Parent Options</h3>
		<a href="#" id="close-dialog"><img src="${pageContext.request.contextPath}/__sys/img/delete-16-16.png" alt="Close" title="Close"/></a>
	</div>
	<div class="dialog-content">
	<table id="tablesTable" class="tablesorter">
		<thead>
			<tr>
				<th style="width: 50px;">Select</th>
				<th style="width: 50px;">Id</th>
				<th>Name</th>
				<th style="width: 100px;">Status</th>
			</tr>
		</thead>
		<tbody>
			<c:choose>
				<c:when test="${not empty parentOptionsList}">
					<c:forEach items="${parentOptionsList}" var="currentParent">
						<tr>
							<td style="text-align: center;"><input type="radio" name="parentOptionRadio" value="${currentParent.optionId}:${currentParent.optionName}"/></td>
							<td style="text-align: right;">${currentParent.optionId}</td>
							<td>${currentParent.optionName}</td>
							<td style="text-align: center;">${currentParent.optionStatus}</td>
						</tr>
					</c:forEach>
				</c:when>
				<c:otherwise>
				<tr><td colspan="10" style="text-align: center;">No options configured.</td></tr>
				</c:otherwise>
			</c:choose>
		</tbody>
		</table>
	</div>
	<div class="dialog-actions">
		<input type="button" id="select-parent" value="Select" />
	</div>
</div>
</body>
</html>