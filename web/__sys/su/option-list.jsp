<%@page import="org.iq.util.StringUtil"%>
<%@page import="org.iq.ums.vo.UmsOption"%>

<style media="screen" type="text/css">
div.configured-options {height: 300px; width: 350px; overflow-y: scroll;}
div.configured-options>ul{}
div.configured-options>ul>li{border: 1px solid #057; margin: 2px; padding: 4px;}

div.configured-options>ul>li>div>div.contents {float: left; width: 280px; text-align: left;}

div.configured-options>ul>li>div>div.actions {float: right;}
div.configured-options>ul>li>div>div.actions>a {float: left;}
div.configured-options>ul>li>div>div.actions>form {display: inline-block;}


div.configured-options>ul>li>div>ul {border-top: 1px solid #ddd; margin-top: 5px;}
div.configured-options>ul>li>div>ul>li {border-bottom: 1px solid #ddd; padding: 4px 0; margin-left: 15px;}

div.configured-options>ul>li>div>ul>li>div {}
div.configured-options>ul>li>div>ul>li>div>img {width: 32px;
height: 32px;
float: left;
border: 1px solid #aaa;
padding: 2px;}

div.configured-options>ul>li>div>ul>li>div>div.contents {margin-left: 5px;float: left;width: 215px; text-align: left;}

div.configured-options>ul>li>div>ul>li>div>div.actions {float: right;}
div.configured-options>ul>li>div>ul>li>div>div.actions>a {float: left;}
div.configured-options>ul>li>div>ul>li>div>div.actions>form {display: inline-block;}

div.configured-options div.contents span {display: block;}
div.configured-options div.contents span.main {/* color:red; */}
div.configured-options div.contents span.sub {font-size: 10px; /* color:blue; */}


</style>

<fieldset>
	<legend>Configured <%if(listParent){%>Parent <%}%>Options</legend>
	
	<div class="configured-options">
		<ul>
			<li>
				<div>
					<div class="contents">
						<span class="main">Order</span>
						<span class="sub">Status : <span style="color:red;display: inline;">Inactive</span>; Sub Options Count : 15 </span>
					</div>
					<div class="actions">
						<a href="<%=rootLink%>/su/options.jsp?action=edit&optionId=1"><img src="<%=rootLink%>/img/edit-16-16.png" alt="Edit" title="Edit" class="icon"/></a>
						<form method="post" action="<%=rootLink%>/adapter">
							<input type="hidden" name="ServiceName" value="UpdateOption" />
							<input type="hidden" name="action" value="delete" />
							<input type="hidden" name="opt-id" value="1" />
							<input type="image" src="<%=rootLink%>/img/delete-16-16.png" alt="Delete" title="Delete" class="icon"/>
						</form>
					</div>
					<div class="clear"></div>
					<ul>
						<li>
							<div>
								<img src="<%=rootLink%>/img/user-add-26.png" alt="" />
								<div class="contents">
									<span class="main">New Order</span>
									<span class="sub">Status : <span style="color:green;display: inline;">Active</span>; Order : 15</span>
									<span class="sub">Link : options/options.jsp?action=newoptions/options.jsp?action=new</span>
								</div>
								<div class="actions">
									<a href="<%=rootLink%>/su/options.jsp?action=edit&optionId=1"><img src="<%=rootLink%>/img/edit-16-16.png" alt="Edit" title="Edit" class="icon"/></a>
									<form method="post" action="<%=rootLink%>/adapter">
										<input type="hidden" name="ServiceName" value="UpdateOption" />
										<input type="hidden" name="action" value="delete" />
										<input type="hidden" name="opt-id" value="1" />
										<input type="image" src="<%=rootLink%>/img/delete-16-16.png" alt="Delete" title="Delete" class="icon"/>
									</form>
								</div>
								<div class="clear"></div>
							</div>
						</li>
						<li>
							<div>
								<img src="<%=rootLink%>/img/user-add-26.png" alt="" />
								<div class="contents">
									<span class="main">New Order</span>
									<span class="sub">Status : Inactive; Order : 15</span>
									<span class="sub">Link : options/options.jsp?action=new</span>
								</div>
								<div class="actions">
									<a href="<%=rootLink%>/su/options.jsp?action=edit&optionId=1"><img src="<%=rootLink%>/img/edit-16-16.png" alt="Edit" title="Edit" class="icon"/></a>
									<form method="post" action="<%=rootLink%>/adapter">
										<input type="hidden" name="ServiceName" value="UpdateOption" />
										<input type="hidden" name="action" value="delete" />
										<input type="hidden" name="opt-id" value="1" />
										<input type="image" src="<%=rootLink%>/img/delete-16-16.png" alt="Delete" title="Delete" class="icon"/>
									</form>
								</div>
								<div class="clear"></div>
							</div>
						</li>
					</ul>
					<div class="clear"></div>
				</div>
			</li>
			<li>
				<div>
					<div class="contents">
						<span class="main">Customer</span>
						<span class="sub">Status : Inactive; Sub Options Count : 15 </span>
					</div>
					<div class="actions">
						<a href="<%=rootLink%>/su/options.jsp?action=edit&optionId=1"><img src="<%=rootLink%>/img/edit-16-16.png" alt="Edit" title="Edit" class="icon"/></a>
						<form method="post" action="<%=rootLink%>/adapter">
							<input type="hidden" name="ServiceName" value="UpdateOption" />
							<input type="hidden" name="action" value="delete" />
							<input type="hidden" name="opt-id" value="1" />
							<input type="image" src="<%=rootLink%>/img/delete-16-16.png" alt="Delete" title="Delete" class="icon"/>
						</form>
					</div>
					<div class="clear"></div>
					<ul>
						<li>
							<div>
								<img src="<%=rootLink%>/img/user-add-26.png" alt="" />
								<div class="contents">
									<span class="main">New Order</span>
									<span class="sub">Status : Inactive; Order : 15</span>
									<span class="sub">Link : options/options.jsp?action=newoptions/options.jsp?action=new</span>
								</div>
								<div class="actions">
									<a href="<%=rootLink%>/su/options.jsp?action=edit&optionId=1"><img src="<%=rootLink%>/img/edit-16-16.png" alt="Edit" title="Edit" class="icon"/></a>
									<form method="post" action="<%=rootLink%>/adapter">
										<input type="hidden" name="ServiceName" value="UpdateOption" />
										<input type="hidden" name="action" value="delete" />
										<input type="hidden" name="opt-id" value="1" />
										<input type="image" src="<%=rootLink%>/img/delete-16-16.png" alt="Delete" title="Delete" class="icon"/>
									</form>
								</div>
								<div class="clear"></div>
							</div>
						</li>
						<li>
							<div>
								<img src="<%=rootLink%>/img/user-add-26.png" alt="" />
								<div class="contents">
									<span class="main">New Order</span>
									<span class="sub">Status : Inactive; Order : 15</span>
									<span class="sub">Link : options/options.jsp?action=new</span>
								</div>
								<div class="actions">
									<a href="<%=rootLink%>/su/options.jsp?action=edit&optionId=1"><img src="<%=rootLink%>/img/edit-16-16.png" alt="Edit" title="Edit" class="icon"/></a>
									<form method="post" action="<%=rootLink%>/adapter">
										<input type="hidden" name="ServiceName" value="UpdateOption" />
										<input type="hidden" name="action" value="delete" />
										<input type="hidden" name="opt-id" value="1" />
										<input type="image" src="<%=rootLink%>/img/delete-16-16.png" alt="Delete" title="Delete" class="icon"/>
									</form>
								</div>
								<div class="clear"></div>
							</div>
						</li>
					</ul>
					<div class="clear"></div>
				</div>
			</li>
		</ul>
	</div>
	
	<table id="tablesTable" class="tablesorter">
		<thead>
			<tr>
				<%if(listParent){%>
				<th>Select</th>
				<%}%>
				<th>Id</th>
				<th>Name</th>
				<%if(!listParent){%>
				<th>Link</th>
				<th>Image</th>
				<%}%>
				<th>Status</th>
				<%if(!listParent){%>
				<th>Parent ID</th>
				<th>Order</th>
				<th>Actions</th>
				<%}%>
			</tr>
		</thead>
		<tbody>
<%
if (umsOptions != null && umsOptions.size() > 0) {
	for (UmsOption thisUmsOption : umsOptions) {
%>
			<tr>
				<%if(listParent){%><td><input type="radio" name="parentOptionRadio" value="<%=thisUmsOption.getOptionId()%>:<%=thisUmsOption.getOptionName()%>"/></td><%}%>
				<td><%=thisUmsOption.getOptionId()%></td>
				<td><%=thisUmsOption.getOptionName()%></td>
				<%if(!listParent){%>
				<td><%=thisUmsOption.getOptionLink()%></td>
				<td><%if(StringUtil.isEmpty(thisUmsOption.getOptionImageLink())==false){%><img alt="" src="<%=rootLink%>/<%=thisUmsOption.getOptionImageLink()%>" class="icon"/><%}%></td>
				<%}%>
				<td><%=thisUmsOption.getOptionStatus()%></td>
				<%if(!listParent){%>
				<td><%=thisUmsOption.getParentOptionId()%></td>
				<td><%=thisUmsOption.getOptionOrder()%></td>
				<td>
					<a href="<%=rootLink%>/su/options.jsp?action=edit&optionId=<%=thisUmsOption.getOptionId()%>" style="float: left;"><img src="<%=rootLink%>/img/edit-16-16.png" alt="Edit" title="Edit" class="icon"/></a>
					<form method="post" action="<%=rootLink%>/adapter">
						<input type="hidden" name="ServiceName" value="UpdateOption" />
						<input type="hidden" name="action" value="delete" />
						<input type="hidden" name="opt-id" value="<%=thisUmsOption.getOptionId()%>" />
						<input type="image" src="<%=rootLink%>/img/delete-16-16.png" alt="Delete" title="Delete" class="icon"/>
					</form>
				</td>
				<%}%>
			</tr>
<%
	}
} else {
%>
			<tr><td colspan="10" style="text-align: center;">No options configured.</td></tr>
<%
}
%>
		</tbody>
	</table>
</fieldset>
