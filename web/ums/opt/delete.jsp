<%@ include file="../../cmn/head.jsp" %>
	<form method="post" action="${pageContext.request.contextPath}/adapter">
		<input class="form-control" type="hidden" name="requested-action" value="DeleteOption">
        <div class="panel panel-default">
    		<div class="panel-heading">
    			<div class="panel-title">
					You are about to delete the below option.
    			</div>
    		</div>

    		<div class="panel-body">
                <div class="row">
        			<div class="col-md-3 form-group">
        				<label class="control-label">Option ID</label>
        				<input class="form-control" class="form-control" type="text" name="optId" value="${option.optionId}" readonly>
        			</div>
        		</div>

        		<div class="row">
    				<div class="col-md-3 form-group">
    					<label class="control-label">Option Type</label>
    					<input class="form-control" type="text" value="${option.optionType}" readonly>
    				</div>
    				<div class="col-md-3 form-group">
    					<label class="control-label">Option Status</label>
    					<input class="form-control" type="text" value="${option.optionStatus}" readonly>
    				</div>
    				<div class="col-md-3 form-group">
    					<label class="control-label">Option Name</label>
    					<input class="form-control" class="form-control" type="text" value="${option.optionName}" readonly>
    				</div>
    				<div class="col-md-3 form-group">
    					<label class="control-label">Toolbox Item</label>
    					<input class="form-control" class="form-control" type="text" value="${option.enableToolbox}" readonly>
    				</div>
                </div>

                <div class="row">
        			<div class="col-md-6 form-group">
        				<label class="control-label">Option Description</label>
        				<textarea class="form-control" readonly>${option.optionDescription}</textarea>
        			</div>
        			<div class="col-md-6 form-group">
        				<label class="control-label">Option Order</label>
                        <input class="form-control" type="text" value="${option.optionOrder}" readonly>
        			</div>
        		</div>

        		<div class="row">
        			<div class="col-md-6 form-group">
        				<label class="control-label">Option Link</label>
                        <input class="form-control" type="text" value="${pageContext.request.contextPath}/" readonly>
        			</div>
        			<div class="col-md-6 form-group">
        				<label class="control-label">&nbsp;</label>
        				<input class="form-control" type="text" value="${option.optionLink}" readonly class="input-width-double" />
        			</div>
        		</div>

        		<div class="row">
        			<div class="col-md-6 form-group">
        				<label class="control-label">Object Reference</label>
        				<input class="form-control" type="text" value="${option.objectReferenceKey}" readonly>
        			</div>
					<div class="col-md-6 form-group">
						<label class="control-label">Parent Option Id</label>
						<input class="form-control" type="text" value="${option.parentOptionId}" readonly style="text-align: right;" />
					</div>
        		</div>

				<div class="row">
					<div class="col-md-12">
						<input class="btn btn-md btn-primary" type="submit" value="Delete Option">
					</div>
				</div>
    		</div>
    	</div>
	</form>
<%@ include file="../../cmn/tail.jsp" %>
