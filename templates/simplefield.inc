<%if((fieldType == InputType.TEXT.toString()) || (fieldType==InputType.PASSWORD.toString()) || 
						(fieldType==InputType.EMAIL.toString())  || (fieldType==InputType.DATETIME_LOCAL.toString())  || 
						(fieldType==InputType.TIME.toString()) || (fieldType==InputType.NUMBER.toString()) || 
						(fieldType==InputType.DATE.toString())){%>
						<label for="<%=fieldName%>"><%=thisDataField.getLabel()%></label>
						<input type="<%=fieldType%>" id="<%=fieldName%>" name="<%=fieldName%>" value="field-value" required />
						<%}
						if (thisDataField.getInfo() != null && thisDataField.getInfo().length() > 0){%>
						<div class="field-info-container">
							<div class="field-info">
								<div class="info-content"><%=thisDataField.getInfo()%></div>
							</div>
						</div>
						<%}%>
						<div id="field-id-error" class="-iq-error">This is field validation error</div>