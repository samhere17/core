<%@include file="../cmn/head.jsp"%>
				<div class="form-container">
					<form method="post"
						action="${pageContext.request.contextPath}/adapter">
						<input type="hidden" name="serviceName" value="" />
						<div class="form-header">
							<img
								src="${pageContext.request.contextPath}/__sys/img/help-16-16.png"
								alt="Help Contents" title="Help Contents" />
							<h3>Help Contents</h3>
						</div>
						<div class="form-content">
							<div class="fields-row">
								<div class="field-col">
									<label for="name">Search</label>
									<input type="text" name="from" class="input-width-double" />
								</div>
							</div>
							<div class="clear"></div>
						</div>
						<div class="form-actions"></div>
					</form>
				</div>
<%@include file="../cmn/tail.jsp"%>