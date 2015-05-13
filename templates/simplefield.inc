					<div class="field-col">
						<label for="<%=thisDataField.getHtmlId()%>"><%=thisDataField.getLabel()%></label>
						<input type="<%=fieldType%>" id="<%=thisDataField.getHtmlId()%>" name="<%=thisDataField.getName()%>" value="field-value" <%if(thisDataField.getMaxLength()!=null && thisDataField.getMaxLength().length()>0){%> maxlength="<%=thisDataField.getMaxLength()%>"<%}if(thisDataField.isDisabled()){%> disabled<%}if(thisDataField.isReadonly()){%> readonly<%}if(thisDataField.isRequired()){%> required<%}%>/>
<%
						if (StringUtil.isEmpty(thisDataField.getFieldInfo()) == false) {
%>
						<div class="field-info-container">
							<div class="field-info">
								<div class="info-content"><%=thisDataField.getFieldInfo()%></div>
							</div>
						</div>
<%
						}
%>
						<div id="field-id-error" class="-iq-error"></div>
					</div>