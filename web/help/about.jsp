<%@page import="org.iq.version.Version"%>
<%@include file="../cmn/head.jsp"%>

<div class="panel panel-info">
	<div class="panel-heading">
		<div class="panel-title"><span class="fa fa-info fa-fw"></span> About</div>
	</div>
	<div class="panel-body">
		<div class="row">
			<div class="col-md-2">
				<span class="fa-stack fa-3x">
					<i class="fa fa-building fa-stack-2x fa-fw text-info"></i>
					<i class="fa fa-cogs fa-stack-1x fa-fw"></i>
				</span>
			</div>
			<div class="col-md-10">
				Apartment Management System<br><small>An application known for simplicity and usability</small>
			</div>
		</div>
		<hr>
		<div class="row">
			<div class="col-md-12">
				License Information
			</div>
			<div class="col-md-12">
				<textarea class="form-control" name="" rows="4" readonly>License information should go here... License information should go here... License information should go here... License information should go here...License information should go here... License information should go here... License information should go here... License information should go here...License information should go here... License information should go here... License information should go here... License information should go here...License information should go here... License information should go here... License information should go here... License information should go here...License information should go here... License information should go here... License information should go here... License information should go here...</textarea>
				<small><a href="#" title="" accesskey="">Download a license copy here.</a></small>
			</div>
		</div>
		<hr>
		<div class="row">
			<div class="col-md-12">
				Version Details
			</div>
		</div>
		<div class="row">
			<div class="col-md-4">
				<small>Application Version: <%=Version.versionNumber%></small>
			</div>
			<div class="">
				<small>Application Development Version: <%=Version.devVersionNumber%></small>
			</div>
		</div>
		<div class="row">
			<div class="col-md-4">
				<small>Core Version: <%=Version.coreVersionNumber%></small>
			</div>
			<div class="">
				<small>Core Development Version: <%=Version.coreDevVersionNumber%></small>
			</div>
		</div>
		<hr>
		<div class="row">
			<div class="col-md-12">
				<small>Copyright&nbsp;&copy;&nbsp;<a href="http://www.iquesters.com" title="Click to visit official site of iquester [Alt+I]" accesskey="I">iquesters</a>.&nbsp;All rights reserved.</small>
			</div>
		</div>
	</div>
</div>
<%@include file="../cmn/tail.jsp"%>