<%@page import="org.iq.version.Version"%>
<%@include file="../cmn/head.jsp"%>

<div class="panel panel-default">
	<div class="panel-heading">
		<div class="panel-title"><span class="fa fa-info-circle fa-fw"></span> About</div>
	</div>
	<div class="panel-body">
		<div class="row">
			<div class="col-sm-2 text-center">
				<span class="fa-stack fa-2x">
					<i class="fa fa-fw fa-cloud fa-stack-2x text-info"></i>
					<i class="fa fa-fw fa-server fa-stack-1x"></i>
				</span>
			</div>
			<div class="col-sm-10">
				<div>${systemConfig.applicationName}</div>
				<div><small>${systemConfig.applicationDesc}</small></div>
				<!-- Apartment Management System<br><small>An application known for simplicity and usability</small> -->
			</div>
		</div>
		<hr>
		<div class="row">
			<div class="col-sm-12">
				License Information
			</div>
			<div class="col-sm-12">
				<textarea class="form-control" name="" rows="4" readonly>License information should go here... License information should go here... License information should go here... License information should go here...License information should go here... License information should go here... License information should go here... License information should go here...License information should go here... License information should go here... License information should go here... License information should go here...License information should go here... License information should go here... License information should go here... License information should go here...License information should go here... License information should go here... License information should go here... License information should go here...</textarea>
				<small><a href="#" title="" accesskey="">Download a license copy here.</a></small>
			</div>
		</div>
		<hr>
		<div class="row">
			<div class="col-xs-12">
				Version Details
			</div>
		</div>
		<div class="row">
			<div class="col-sm-6">
				<small>Application Version: <%=Version.versionNumber%></small>
			</div>
			<div class="col-sm-6">
				<small>Application Development Version: <%=Version.devVersionNumber%></small>
			</div>
		</div>
		<div class="row">
			<div class="col-sm-6">
				<small>Core Version: <%=Version.coreVersionNumber%></small>
			</div>
			<div class="col-sm-6">
				<small>Core Development Version: <%=Version.coreDevVersionNumber%></small>
			</div>
		</div>
		<!-- <hr>
		<div class="row">
			<div class="col-md-12">
				<small>Copyright&nbsp;&copy;&nbsp;<a href="http://www.iquesters.com" title="Click to visit official site of iquester [Alt+I]" accesskey="I">iquesters</a>.&nbsp;All rights reserved.</small>
			</div>
		</div> -->
	</div>
</div>
<%@include file="../cmn/tail.jsp"%>