					<div class="field-col">
						<label for="<%=thisDataField.getHtmlId()%>"><%=thisDataField.getLabel()%></label>
<%						
						MultiValuedField multiValuedField = (MultiValuedField)thisDataField;
						String[] values = multiValuedField.getValues();
						if((InputType.RADIO.equals(fieldType)) || (InputType.CHECKBOX.equals(fieldType))){
							for (int i = 0; i < values.length; i++) {
%>
								<input type="<%=fieldType%>" id="<%=thisDataField.getHtmlId()%>" name="<%=thisDataField.getName()%>" value="<%=values[i]%>" <%if(thisDataField.isDisabled()){%> disabled<%}if(thisDataField.isReadonly()){%> readonly<%}if(thisDataField.isRequired()){%> required<%}%>/>	
<%
							}
					}else if(InputType.SELECT.equals(fieldType)){
%>
					<select id="<%=thisDataField.getHtmlId()%>" name="<%=thisDataField.getName()%>">
<%
						for (int i = 0; i < values.length; i++) {
%>
							<option value="<%=values[i]%>"><%=values[i]%></option>
<%
						}
%>					
					</select>					
<%					
						}
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