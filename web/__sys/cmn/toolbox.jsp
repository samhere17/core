<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<!--TOOLBOX STARTS-->
<c:if test="${not empty organization}">
	<div class="toolbox">
		<div class="toolbox-header">
			<img src="${pageContext.request.contextPath}/__sys/img/org-16-16.png" alt="Organization" />
			<h3>Organization In Context</h3>
		</div>
		<div class="toolbox-content">
			<table style="width: 100%;">
				<tr><td colspan="2"><b>${organization.organizationName}</b></td></tr>
				<tr>
					<td>${organization.organizationId}</td>
					<td>${organization.organizationStatus}</td>
				</tr>
				<tr></tr><!-- DO NOT DELETE this tr tag, this is for eliminating the white row -->
				<tr><td colspan="2">
					<c:if test="${not empty organization.organizationPrimaryPhone}">
						<img alt="Phone" src="${pageContext.request.contextPath}/__sys/img/phone-16-16.png">${organization.organizationPrimaryPhone}<br>
					</c:if>
					<c:if test="${not empty organization.organizationPrimaryFax}">
						<img alt="Phone" src="${pageContext.request.contextPath}/__sys/img/fax-16-16.png">${organization.organizationPrimaryFax}<br>
					</c:if>
					<c:if test="${not empty organization.organizationPrimaryEmail}">
						<img alt="Phone" src="${pageContext.request.contextPath}/__sys/img/mail-16-16.png">${organization.organizationPrimaryEmail}<br>
					</c:if>
				</td></tr>
			</table>
		</div>
	</div>
</c:if>


<c:if test="${not empty customer}">
	<div class="toolbox">
		<div class="toolbox-header">
			<img src="${pageContext.request.contextPath}/img/cust-16-16.png" alt="Customer" />
			<h3>Customer In Context</h3>
		</div>
		<div class="toolbox-content">
			<table style="width: 100%;">
				<tr><td colspan="3"><b>${customer.customerName}</b></td></tr>
				<tr>
					<td>${customer.customerId}</td>
					<td>${customer.customerStatus}</td>
					<td colspan="2">${fn:length(customer.contactDetailsIOList)} contact(s)</td>
				</tr>
				<tr></tr><!-- DO NOT DELETE this tr tag, this is for eliminating the white row -->
				<tr><td colspan="3">
					<c:if test="${not empty customer.customerPrimaryPhone}">
						<img alt="Phone" src="${pageContext.request.contextPath}/__sys/img/phone-16-16.png">${customer.customerPrimaryPhone}<br>
					</c:if>
					<c:if test="${not empty customer.customerPrimaryFax}">
						<img alt="Phone" src="${pageContext.request.contextPath}/__sys/img/fax-16-16.png">${customer.customerPrimaryFax}<br>
					</c:if>
					<c:if test="${not empty customer.customerPrimaryEmail}">
						<img alt="Phone" src="${pageContext.request.contextPath}/__sys/img/mail-16-16.png">${customer.customerPrimaryEmail}<br>
					</c:if>
				</td></tr>
			</table>
		</div>
	</div>
</c:if>


<c:if test="${not empty role}">
	<div class="toolbox">
		<div class="toolbox-header">
			<img src="${pageContext.request.contextPath}/__sys/img/role-16-16.png" alt="Role" />
			<h3>Role In Context</h3>
		</div>
		<div class="toolbox-content">
			<table style="width: 100%;">
				<tr><td colspan="2"><b>${role.roleName}</b></td></tr>
				<tr><td colspan="2">${role.roleDescription}</td></tr>
				<tr></tr>
				<tr>
					<td>${role.roleId}</td>
					<td>${role.roleStatus}</td>
				</tr>
			</table>
		</div>
	</div>
</c:if>

<c:if test="${false}">
<div class="toolbox">
	<div class="toolbox-header">
		<img src="${pageContext.request.contextPath}/img/order-16-16.png" alt="Account Information" title="Account Information"/>
		<h3>Order Information</h3>
		<a href=""><img src="../images/edit.png" alt="Edit" title="Edit"/></a>
	</div>
	<div class="toolbox-content">
		<div style="float:left; width:100px;">Order Id</div><div style="">O/2015/0001</div>
		<div style="float:left; width:100px;">Job Id</div><div style="">J/2015/0001</div>
		<div style="float:left; width:100px;">Status</div><div style="">50% completion</div>
		<div style="float:left; width:100px;">Running Execution Step</div><div style="">4</div>
	</div>
</div>

<div class="toolbox">
	<div class="toolbox-header">
		<img src="../images/trans-hist.png" alt="Transaction History" title="Transaction History" />
		<h3>Transaction History</h3>
		<!--a href=""><img src="../images/edit.png" alt="Edit" title="Edit"/></a-->
	</div>
	<div class="toolbox-content">
		<div style="float:left; width:105px;">Current Balance</div><div style="float:left; width:105px;">-130000.00</div>
		<br/>
		<table style="width:100%">
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

<div class="toolbox">
	<div class="toolbox-header">
		<img src="../images/warning.png" alt="Warnings" title="Warnings"/>
		<h3>Warnings</h3>
		<!--a href=""><img src="../images/edit.png" alt="Edit" title="Edit"/></a-->
	</div>
	<div class="toolbox-content">
		Payment Due<br/>
		Next due date: 11/5/2014
	</div>
</div>
</c:if>


<style media="screen" type="text/css">
.toolbox {border: 1px solid #057; margin: 1px; height: 145px;}

.toolbox > div.toolbox-header {background: #8df; /* box-shadow: 0px 0px 15px #057 inset; */ border-bottom: 1px solid #057; padding: 5px;}
.toolbox > div.toolbox-header > img {float: left; width: 16px; height: 16px;}
.toolbox > div.toolbox-header > h3 {font-weight: normal; margin: 0 20px; line-height: 16px;}
.toolbox > div.toolbox-header > a > img {padding: 4px; float: right; margin: -20px -1px; width: 16px; height: 16px;}
.toolbox > div.toolbox-header > a:hover > img {border: 1px solid #057; border-radius: 3px; /* box-shadow: 0px 0px 5px #057 inset; */ padding: 3px;}

.toolbox > div.toolbox-content {height: 110px; overflow-x: hidden; overflow-y: scroll; padding: 4px; line-height: 15px;}

/* .toolbox > div.toolbox-content > table, th, td {
	border: 1px solid #999;
	border-collapse: collapse;
}

.toolbox > div.toolbox-content > table > thead {
	background-color: #aaa;
}

.toolbox > div.toolbox-content > table > thead > tr {
	text-align: center;
}

.toolbox > div.toolbox-content > table > tbody > tr:nth-child(odd) {
	background-color: #fff;
}

.toolbox > div.toolbox-content > table > tbody > tr:nth-child(even) {
	background-color: #eee;
}
 */

</style>
<!--TOOLBOX ENDS-->