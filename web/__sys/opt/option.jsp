<%@page import="org.iq.ums.vo.UmsOption"%>
<%@page import="java.util.List"%>
<%@page import="org.iq.ums.helper.UmsOptionHelper"%>
<%@page import="org.iq.util.DateUtil.DateFormat"%>
<%@page import="org.iq.util.DateUtil"%>
<%@page import="java.util.Date"%>
<%@page import="org.iq.util.version.Version"%>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
		<title>OMS::iquesters</title>
		<%@include file="/__sys/cmn/scripts.jsp"%>
		<%@include file="/__sys/cmn/styles.jsp"%>
		<style type="text/css">
		
		</style>
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
			<%
			UmsOptionHelper optionHelper = new UmsOptionHelper();
			UmsOption umsOption = null;
			List<UmsOption> umsOptions = null;
			boolean listParent = false;
//			boolean enableEntrySeletion = false;
//			boolean enableListAction = false;
			boolean showVal = false;
			
			String action = request.getParameter("action");
/*			if ("new".equals(action)) {
				showVal = false;
				umsOptions = optionHelper.getOptionsList(UmsOptionHelper.ALL_OPTIONS);
//				enableEntrySeletion = false;
//				enableListAction = true;
				
			} else if ("edit".equals(action)) {
				showVal = true;
				umsOption = optionHelper.getOptionById(request.getParameter("optionId"));
			}*/
			%>
				<div class="form-container">
					<form method="post" action="<%=rootLink%>/adapter">
						<input type="hidden" name="ServiceName" value="UpdateOption" />
						<input type="hidden" name="errorUrl" value="/error.jsp" />
						<input type="hidden" name="successUrl" value="/su/options.jsp?action=new" />
						<div class="form-header">
						<%if(showVal) {%>
							<input type="hidden" name="action" value="edit" />
							<input type="hidden" name="opt-id" value="<%=request.getParameter("optionId")%>" />
							<img src="<%=rootLink%>/img/opt-edit-16-16.png" alt="Edit Option" title="Edit Option"/>
							<h3>Edit Option</h3>
						<%} else {%>
							<input type="hidden" name="action" value="new" />
							<img src="<%=rootLink%>/img/opt-new-16-16.png" alt="New Option" title="New Option"/>
							<h3>New Option</h3>
						<%}%>
							<a href=""><img src="<%=rootLink%>/img/help.png" alt="Help" title="Help"/></a>
						</div>
						<div class="form-content">
							<fieldset class="first">
								<legend>Option Details</legend>
								<div class="fields-row">
									<div class="field-col">
										<label>Option Name</label>
										<input type="text" id="opt-name" name="opt-name" value="<%=(showVal?umsOption.getOptionName():"")%>" required/>
									</div>
									<div class="field-col">
										<label>Option Status</label>
										<select id="opt-status" name="opt-status" required>
											<option value="1" <%=(showVal?(umsOption.getOptionStatusValue()==1)?"selected":"":"")%>>Valid</option>
											<option value="0" <%=(showVal?(umsOption.getOptionStatusValue()==0)?"selected":"":"")%>>Invalid</option>
										</select>
									</div>
									<div class="field-col">
										<label>Option Order</label>
										<input type="text" id="opt-order" name="opt-order" value="<%=(showVal?umsOption.getOptionOrder():"0")%>" style="text-align:right;"/>
									</div>
								</div>
								<div class="fields-row">
									<div class="field-col">
										<label>Option Link</label>
										<input type="text" value="<%=rootLink%>/" readonly class="input-width-double" style="float:left;"/>
										<input type="text" id="opt-link" name="opt-link" value="<%=(showVal?umsOption.getOptionLink():"")%>" class="input-width-double" style="float:left;"/>
									</div>
								</div>
								<div class="fields-row">
									<div class="field-col">
										<label>Option Image Link</label>
										<input type="text" value="<%=rootLink%>/" readonly class="input-width-double" style="float:left;"/>
										<input type="text" id="opt-img-link" name="opt-img-link" value="<%=(showVal?umsOption.getOptionImageLink():"")%>" class="input-width-double" style="float:left;"/>
									</div>
								</div>
								<div class="fields-row">
									<div class="field-col">
										<label>Parent Option Id</label>
										<input type="text" id="parent-opt-id" name="parent-opt-id" value="<%=(showVal?umsOption.getParentOptionId():"0")%>" readonly required style="text-align:right;"/>
									</div>
									<div class="field-col">
										<label>Parent Option Name</label>
										<input type="text" id="parent-opt-name" name="parent-opt-name" value="" readonly required/>
									</div>
									<div class="field-col">
										<label>&nbsp;</label>
										<input type="button" id="btnLookup" value="Lookup"/>
									</div>
								</div>
							</fieldset>
							<div class="clear"></div>
						</div>
						<div class="form-actions">
						<%if(showVal) {%>
							<input type="submit" id="" value="Update" />
						<%} else {%>
							<input type="submit" id="" value="Save" />
						<%}%>
						</div>
					</form>
				</div>
				<%if(showVal==false){%>
					<%@include file="/__sys/opt/list.jsp"%>
				<%}%>
			</div>
		</div>
		<%@include file="/__sys/cmn/footer.jsp"%>
	</div>

	<div id="overlay" class="dialog-overlay"></div>
	<div id="parent-options" class="dialog-window">
		<div class="dialog-header">
			<%-- <img src="<%=rootLink%>/img/user-add-26.png" alt="New User" title="New User"/> --%>
			<h3>Parent Options</h3>
			<a href="#" id="close-dialog"><img src="<%=rootLink%>/img/delete-16-16.png" alt="Close" title="Close"/></a>
		</div>
		<div class="dialog-content">
			<%
				umsOptions = optionHelper.getOptionsList(UmsOptionHelper.PARENT_OPTIONS);
				listParent = true;
			%>
			<%@include file="/__sys/opt/list.jsp"%>
		</div>
		<div class="dialog-actions">
			<input type="button" id="select-parent" value="Select" />
		</div>
	</div>
</body>
</html>