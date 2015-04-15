<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<!--TOOLBOX STARTS-->

<!--TOOLBOX SELECTION STARTS-->
<div class="toolbox-selection">
	<ul>
		<li><img class="launch" id="launch-org-in-context" src="${pageContext.request.contextPath}/__sys/img/org-16-16.png" /></li>
		<li><img class="launch" id="launch-cust-in-context" src="${pageContext.request.contextPath}/img/cust-16-16.png" /></li>
		<li><img class="launch" id="launch-role-in-context" src="${pageContext.request.contextPath}/__sys/img/role-16-16.png" /></li>
		<li><img src="${pageContext.request.contextPath}/__sys/img/refresh-context-16-16.png" /></li>
		<li><img id="minimize-all" src="${pageContext.request.contextPath}/__sys/img/arrow-up-double-16-16.png" /></li>
		<li><img id="maximize-all" src="${pageContext.request.contextPath}/__sys/img/arrow-down-double-16-16.png" /></li>
		<%-- <li class="more-toolbox"><img src="${pageContext.request.contextPath}/__sys/img/arrow-up-16-16.png" /></li> --%>
	</ul>
</div>
<!--TOOLBOX SELECTION ENDS-->

<!--TOOLBOX HOLDER STARTS-->
<div class="toolbox-holder">
		<div id="org-in-context" class="toolbox">
			<div class="toolbox-header">
				<img
					src="${pageContext.request.contextPath}/__sys/img/org-16-16.png"
					alt="Organization" />
				<h3>Organization</h3>
				<span>
					<img class="maximize" src="${pageContext.request.contextPath}/__sys/img/arrow-down-16-16.png" alt="Maximize" title="Maximize" />
					<img class="minimize" src="${pageContext.request.contextPath}/__sys/img/arrow-up-16-16.png" alt="Minimize" title="Minimize" />
				</span>
			</div>
			<div class="toolbox-content">
			<c:choose>
			<c:when test="${not empty organization}">
				<table style="width: 100%;">
					<tr>
						<td colspan="2"><b>${organization.organizationName}</b></td>
					</tr>
					<tr>
						<td>${organization.organizationId}</td>
						<td>${organization.organizationStatus}</td>
					</tr>
					<tr></tr>
					<!-- DO NOT DELETE this tr tag, this is for eliminating the white row -->
					<tr>
						<td colspan="2"><c:if
								test="${not empty organization.organizationPrimaryPhone}">
								<img alt="Phone"
									src="${pageContext.request.contextPath}/__sys/img/phone-16-16.png">${organization.organizationPrimaryPhone}<br>
							</c:if> <c:if test="${not empty organization.organizationPrimaryFax}">
								<img alt="Phone"
									src="${pageContext.request.contextPath}/__sys/img/fax-16-16.png">${organization.organizationPrimaryFax}<br>
							</c:if> <c:if test="${not empty organization.organizationPrimaryEmail}">
								<img alt="Phone"
									src="${pageContext.request.contextPath}/__sys/img/mail-16-16.png">${organization.organizationPrimaryEmail}<br>
							</c:if></td>
					</tr>
				</table>
			</c:when>
			<c:otherwise>No organization in context</c:otherwise>
			</c:choose>
			</div>
		</div>


		<div id="cust-in-context" class="toolbox">
			<div class="toolbox-header">
				<img src="${pageContext.request.contextPath}/img/cust-16-16.png"
					alt="Customer" />
				<h3>Customer</h3>
				<span>
					<img class="maximize" src="${pageContext.request.contextPath}/__sys/img/arrow-down-16-16.png" alt="Maximize" title="Maximize" />
					<img class="minimize" src="${pageContext.request.contextPath}/__sys/img/arrow-up-16-16.png" alt="Minimize" title="Minimize" />
				</span>
			</div>
			<div class="toolbox-content">
			<c:choose>
			<c:when test="${not empty customer}">
				<table style="width: 100%;">
					<tr>
						<td colspan="3"><b>${customer.customerName}</b></td>
					</tr>
					<tr>
						<td>${customer.customerId}</td>
						<td>${customer.customerStatus}</td>
						<td colspan="2">${fn:length(customer.contactDetailsIOList)}
							contact(s)</td>
					</tr>
					<tr></tr>
					<!-- DO NOT DELETE this tr tag, this is for eliminating the white row -->
					<tr>
						<td colspan="3"><c:if
								test="${not empty customer.customerPrimaryPhone}">
								<img alt="Phone"
									src="${pageContext.request.contextPath}/__sys/img/phone-16-16.png">${customer.customerPrimaryPhone}<br>
							</c:if> <c:if test="${not empty customer.customerPrimaryFax}">
								<img alt="Phone"
									src="${pageContext.request.contextPath}/__sys/img/fax-16-16.png">${customer.customerPrimaryFax}<br>
							</c:if> <c:if test="${not empty customer.customerPrimaryEmail}">
								<img alt="Phone"
									src="${pageContext.request.contextPath}/__sys/img/mail-16-16.png">${customer.customerPrimaryEmail}<br>
							</c:if></td>
					</tr>
				</table>			</c:when>
			<c:otherwise>No customer in context</c:otherwise>
			</c:choose>
			</div>
		</div>


		<div id="role-in-context" class="toolbox">
			<div class="toolbox-header">
				<img
					src="${pageContext.request.contextPath}/__sys/img/role-16-16.png"
					alt="Role" />
				<h3>Role</h3>
				<span>
					<img class="maximize" src="${pageContext.request.contextPath}/__sys/img/arrow-down-16-16.png" alt="Maximize" title="Maximize" />
					<img class="minimize" src="${pageContext.request.contextPath}/__sys/img/arrow-up-16-16.png" alt="Minimize" title="Minimize" />
				</span>
			</div>
			<div class="toolbox-content">
			<c:choose>
			<c:when test="${not empty role}">
				<table style="width: 100%;">
					<tr>
						<td colspan="2"><b>${role.roleName}</b></td>
					</tr>
					<tr>
						<td colspan="2">${role.roleDescription}</td>
					</tr>
					<tr></tr>
					<tr>
						<td>${role.roleId}</td>
						<td>${role.roleStatus}</td>
					</tr>
				</table>
			</c:when>
			<c:otherwise>No role in context</c:otherwise>
			</c:choose>
			</div>
		</div>


	<c:if test="false">
		<div id="order-in-context" class="toolbox">
			<div class="toolbox-header">
				<img src="${pageContext.request.contextPath}/img/order-16-16.png"
					alt="Account Information" title="Account Information" />
				<h3>Order Information</h3>
				<span>
					<img class="maximize" src="${pageContext.request.contextPath}/__sys/img/arrow-down-16-16.png" alt="Maximize" title="Maximize" />
					<img class="minimize" src="${pageContext.request.contextPath}/__sys/img/arrow-up-16-16.png" alt="Minimize" title="Minimize" />
				</span>
			</div>
			<div class="toolbox-content">
				<div style="float: left; width: 100px;">Order Id</div>
				<div style="">O/2015/0001</div>
				<div style="float: left; width: 100px;">Job Id</div>
				<div style="">J/2015/0001</div>
				<div style="float: left; width: 100px;">Status</div>
				<div style="">50% completion</div>
				<div style="float: left; width: 100px;">Running Execution Step</div>
				<div style="">4</div>
			</div>
		</div>

		<div id="trx-in-context" class="toolbox">
			<div class="toolbox-header">
				<img src="../images/trans-hist.png" alt="Transaction History"
					title="Transaction History" />
				<h3>Transaction History</h3>
				<span>
					<img class="maximize" src="${pageContext.request.contextPath}/__sys/img/arrow-down-16-16.png" alt="Maximize" title="Maximize" />
					<img class="minimize" src="${pageContext.request.contextPath}/__sys/img/arrow-up-16-16.png" alt="Minimize" title="Minimize" />
				</span>
			</div>
			<div class="toolbox-content">
				<div style="float: left; width: 105px;">Current Balance</div>
				<div style="float: left; width: 105px;">-130000.00</div>
				<br />
				<table style="width: 100%">
					<thead>
						<tr>
							<td>Date</td>
							<td>Particulars</td>
							<td>Amount</td>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td>Nov 5 2014</td>
							<td>Invoice May'14</td>
							<td>-65000.00</td>
						</tr>
						<tr>
							<td>Nov 5 2014</td>
							<td>Cheque Payment</td>
							<td>+65000.00</td>
						</tr>
						<tr>
							<td>Nov 5 2014</td>
							<td>Invoice Jun'14</td>
							<td>-65000.00</td>
						</tr>
						<tr>
							<td>Nov 5 2014</td>
							<td>Invoice May'14</td>
							<td>-65000.00</td>
						</tr>
						<tr>
							<td>Nov 5 2014</td>
							<td>Cheque Payment</td>
							<td>+65000.00</td>
						</tr>
						<tr>
							<td>Nov 5 2014</td>
							<td>Invoice Jun'14</td>
							<td>-65000.00</td>
						</tr>
						<tr>
							<td>Nov 5 2014</td>
							<td>Invoice May'14</td>
							<td>-65000.00</td>
						</tr>
						<tr>
							<td>Nov 5 2014</td>
							<td>Cheque Payment</td>
							<td>+65000.00</td>
						</tr>
						<tr>
							<td>Nov 5 2014</td>
							<td>Invoice Jun'14</td>
							<td>-65000.00</td>
						</tr>
					</tbody>
				</table>
			</div>
		</div>

		<div id="warn-in-context" class="toolbox">
			<div class="toolbox-header">
				<img src="../images/warning.png" alt="Warnings" title="Warnings" />
				<h3>Warnings</h3>
				<span>
					<img class="maximize" src="${pageContext.request.contextPath}/__sys/img/arrow-down-16-16.png" alt="Maximize" title="Maximize" />
					<img class="minimize" src="${pageContext.request.contextPath}/__sys/img/arrow-up-16-16.png" alt="Minimize" title="Minimize" />
				</span>
			</div>
			<div class="toolbox-content">
				Payment Due<br /> Next due date: 11/5/2014
			</div>
		</div>
	</c:if>
</div>
<!--TOOLBOX HOLDER ENDS-->


<style media="screen" type="text/css">
.toolbox-holder {
	overflow-x: hidden;
	overflow-y: scroll;
	width: 275px;
	height: 522px;
	position: absolute;
	bottom: 0;
}

.toolbox-selection {
	background-color: #8df;
	border-bottom: 1px solid #057;
	padding: 1px 1px;
	width: 273px;
	height: 25px;
	position: absolute;
	top: 0;
}

.toolbox-selection>ul {
	float: right;
}

.toolbox-selection>ul>li {
	display: inline;
}

.toolbox-selection>ul>li>img {
	height: 16px;
	width: 16px;
	padding: 4px;
}

.toolbox-selection>ul>li>img:hover {
	border: 1px solid #057;
	border-radius: 3px;
	box-shadow: 0px 0px 5px #057 inset;
	padding: 3px;
}

.more-toolbox {
	
}

.more-toolbox>img {
	padding-left: 1px !important;
	padding-right: 1px !important;
}

.more-toolbox>img:hover {
	padding-left: 0px !important;
	padding-right: 0px !important;
}

.toolbox {
	border: 1px solid #057;
	margin: 1px; /* height: 145px; */
}

.toolbox>div.toolbox-header {
	background: #8df;
	padding: 5px;
}

.toolbox>div.toolbox-header>img {
	float: left;
	width: 16px;
	height: 16px;
}

.toolbox>div.toolbox-header>h3 {
	font-weight: normal;
	margin: 0 20px;
	line-height: 16px;
}

.toolbox>div.toolbox-header>span>img {
	padding: 4px;
	float: right;
	margin: -20px -4px;
	width: 16px;
	height: 16px;
}

.toolbox>div.toolbox-header>span>img:hover {
	border: 1px solid #057;
	border-radius: 3px;
	box-shadow: 0px 0px 5px #057 inset;
	padding: 3px;
}

/* .toolbox > div.toolbox-header > span {padding: 4px; float: right; margin: -20px -4px; width: 16px; height: 16px;}
.toolbox > div.toolbox-header > span:hover {border: 1px solid #057; border-radius: 3px; box-shadow: 0px 0px 5px #057 inset; padding: 3px;}

.toolbox > div.toolbox-header > span.minimize {background-image: url("${pageContext.request.contextPath}/__sys/img/arrow-up-16-16.png"); background-repeat: no-repeat; background-position: 4px;}
.toolbox > div.toolbox-header > span.maximize {background-image: url("${pageContext.request.contextPath}/__sys/img/arrow-down-16-16.png"); background-repeat: no-repeat; background-position: 4px;}
 */
.toolbox>div.toolbox-content {
	display: none;
	border-top: 1px solid #057;
	max-height: 200px;
	overflow-x: hidden;
	overflow-y: auto;
	padding: 4px;
	line-height: 15px;
}
</style>


<script type="text/javascript">
$(document).ready(function() {
	$(".toolbox").each(function(index) {
		if(localStorage.getItem($(this).attr('id'))=="true") {
			expand($(this));
		}
		else {
			collapse($(this));
		}
	});

	$('#minimize-all').click(function() {
		collapseAll();
	});
	
	$('#maximize-all').click(function() {
		expandAll();
	});
	
	$('.minimize').click(function() {
		collapse($(this).parent().parent().parent());
	});
	
	$('.maximize').click(function() {
		expand($(this).parent().parent().parent());
	});
	
	$('.launch').click(function() {
		var toExpand = $('#'+$(this).attr('id').substring(7));
		$(".toolbox").each(function(index) {
			if($(this).is(toExpand)) {
				expand($(this));
			}
			else {
				collapse($(this));
			}
		});
	});
});

function expand(toolbox) {
	$(toolbox).find("div.toolbox-content").slideDown(200);
	localStorage.setItem($(toolbox).attr('id'),true);
	$(toolbox).find("img.minimize").show();
	$(toolbox).find("img.maximize").hide();
}

function collapse(toolbox) {
	$(toolbox).find("div.toolbox-content").slideUp(200);
	localStorage.setItem($(toolbox).attr('id'),false);
	$(toolbox).find("img.minimize").hide();
	$(toolbox).find("img.maximize").show();
}

function expandAll() {
	$(".toolbox").each(function(index) {
		$(this).find("div.toolbox-content").slideDown(200);
		localStorage.setItem($(this).attr('id'),true);
	});
	$(".minimize").each(function(index) {
		$(this).show();
	});
	$(".maximize").each(function(index) {
		$(this).hide();
	});
}

function collapseAll() {
	$(".toolbox").each(function(index) {
		$(this).find("div.toolbox-content").slideUp(200);
		localStorage.setItem($(this).attr('id'),false);
	});
	$(".minimize").each(function(index) {
		$(this).hide();
	});
	$(".maximize").each(function(index) {
		$(this).show();
	});
}
</script>
<!--TOOLBOX ENDS-->