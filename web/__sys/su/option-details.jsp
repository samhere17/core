<%@page import="org.iq.valueobject.ums.UmsOption"%>
<%
UmsOption umsOptionEdit = null;
boolean showVal = false;
	if ("new".equals(action)) {

	} else {
		String optId = request.getParameter("optId");
		umsOptionEdit = optionHelper.getOptionById(optId);
		showVal = true;
	}
%>
<div class="form-container">
	<form method="post" action="<%=rootLink%>/adapter">
		<input type="hidden" name="ServiceName" value="UpdateOption" />
		<input type="hidden" name="errorUrl" value="/error.jsp" />
		<input type="hidden" name="successUrl" value="/su/options.jsp?action=new" />
		<div class="form-header">
		<%
		if(showVal){
		%>
			<img src="<%=rootLink%>/img/opt-edit-16-16.png" alt="Edit Option" title="Edit Option"/>
			<h3>Edit Option</h3>
		<%
		} else {
		%>
			<img src="<%=rootLink%>/img/opt-new-16-16.png" alt="New Option" title="New Option"/>
			<h3>New Option</h3>
		<%
		}
		%>
			<a href=""><img src="<%=rootLink%>/img/help.png" alt="Help" title="Help"/></a>
		</div>
						<div class="form-content">
							<fieldset class="first">
								<legend>Option Details</legend>
								<div class="fields-row">
									<div class="field-col">
										<label>Option Name</label>
										<input type="text" id="opt-name" name="opt-name" value="<%=(showVal?umsOptionEdit.getOptionName():"")%>" required/>
									</div>
									<div class="field-col">
										<label>Option Status</label>
										<select id="opt-status" name="opt-status" required>
											<option value="1">Valid</option>
											<option value="0">Invalid</option>
										</select>
									</div>
									<div class="field-col">
										<label>Option Order</label>
										<input type="text" id="opt-order" name="opt-order" value="0" style="text-align:right;"/>
									</div>
								</div>
								<div class="fields-row">
									<div class="field-col">
										<label>Option Link</label>
										<input type="text" value="<%=rootLink%>/" readonly class="input-width-double" style="float:left;"/>
										<input type="text" id="opt-link" name="opt-link" value="" class="input-width-double" style="float:left;"/>
									</div>
								</div>
								<div class="fields-row">
									<div class="field-col">
										<label>Option Image Link</label>
										<input type="text" value="<%=rootLink%>/" readonly class="input-width-double" style="float:left;"/>
										<input type="text" id="opt-img-link" name="opt-img-link" value="" class="input-width-double" style="float:left;"/>
									</div>
								</div>
								<div class="fields-row">
									<div class="field-col">
										<label>Parent Option Id</label>
										<input type="text" id="parent-opt-id" name="parent-opt-id" value="0" readonly required style="text-align:right;"/>
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
							<input type="submit" id="" value="Save" />
						</div>
					</form>
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
		<a href="#" id="close-dialog"><img src="<%=rootLink%>/img/delete-16-16.png" alt="Close" title="Close"/></a>
	</div>
	<div class="dialog-content">
		<%
			umsOptions = optionHelper.getOptionsList(UmsOptionHelper.PARENT_OPTIONS);
			enableEntrySeletion = true;
			enableListAction = false;
		%>
		<%@include file="/su/option-list.jsp"%>
	</div>
	<div class="dialog-actions">
		<input type="button" id="select-parent" value="Select" />
	</div>
</div>