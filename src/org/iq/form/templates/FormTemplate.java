package org.iq.form.templates;

import org.iq.form.DataField;
import org.iq.form.Fieldset;
import org.iq.form.Form;
import org.iq.util.StringUtil;
import org.iq.form.FormConstants.InputType;

public class FormTemplate
{
  protected static String nl;
  public static synchronized FormTemplate create(String lineSeparator)
  {
    nl = lineSeparator;
    FormTemplate result = new FormTemplate();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "<div class=\"form-container\">" + NL + "\t<form method=\"";
  protected final String TEXT_2 = "\" action=\"${pageContext.request.contextPath}/";
  protected final String TEXT_3 = "\">" + NL + "\t\t<input type=\"hidden\" name=\"serviceName\" value=\"InsertOrganization\" />" + NL + "\t\t<div class=\"form-header\">";
  protected final String TEXT_4 = NL + "\t\t\t<img src=\"${pageContext.request.contextPath}/";
  protected final String TEXT_5 = "\" alt=\"";
  protected final String TEXT_6 = "\" title=\"";
  protected final String TEXT_7 = "\" />";
  protected final String TEXT_8 = NL + "\t\t\t<h3>";
  protected final String TEXT_9 = "</h3>";
  protected final String TEXT_10 = NL + "\t\t\t<a href=\"${pageContext.request.contextPath}/";
  protected final String TEXT_11 = "\"><img src=\"${pageContext.request.contextPath}/__sys/img/help.png\" alt=\"Help\" title=\"Help\"/></a>";
  protected final String TEXT_12 = NL + "\t\t</div>" + NL + "\t\t<div class=\"form-content\">";
  protected final String TEXT_13 = NL + "\t\t\t<fieldset>" + NL + "\t\t\t\t<legend>";
  protected final String TEXT_14 = "</legend>" + NL + "\t\t\t\t<div class=\"fields-row\">";
  protected final String TEXT_15 = NL + "\t\t\t\t\t<div class=\"field-col\">" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_16 = NL + "\t\t\t\t\t\t<label for=\"";
  protected final String TEXT_17 = "\">";
  protected final String TEXT_18 = "</label>" + NL + "\t\t\t\t\t\t<input type=\"";
  protected final String TEXT_19 = "\" id=\"";
  protected final String TEXT_20 = "\" name=\"";
  protected final String TEXT_21 = "\" value=\"field-value\" required />" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_22 = NL + "\t\t\t\t\t\t<div class=\"field-info-container\">" + NL + "\t\t\t\t\t\t\t<div class=\"field-info\">" + NL + "\t\t\t\t\t\t\t\t<div class=\"info-content\">";
  protected final String TEXT_23 = "</div>" + NL + "\t\t\t\t\t\t\t</div>" + NL + "\t\t\t\t\t\t</div>" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_24 = NL + "\t\t\t\t\t\t<div id=\"field-id-error\" class=\"-iq-error\">This is field validation error</div>" + NL + "\t\t\t\t\t</div>";
  protected final String TEXT_25 = NL + "\t\t\t\t</div>" + NL + "\t\t\t</fieldset>";
  protected final String TEXT_26 = NL + "\t\t\t<div class=\"clear\"></div>" + NL + "\t\t</div>" + NL + "\t\t<div class=\"form-actions\">" + NL + "\t\t\t<input type=\"submit\" id=\"field-id\" value=\"action fld label\" />" + NL + "\t\t</div>" + NL + "\t</form>" + NL + "</div>";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
	Form form = (Form)argument;

    stringBuffer.append(TEXT_1);
    stringBuffer.append(form.getMethod().toString());
    stringBuffer.append(TEXT_2);
    stringBuffer.append(form.getAction());
    stringBuffer.append(TEXT_3);
    
	if(StringUtil.isEmpty(form.getHeaderImage()) == false) {

    stringBuffer.append(TEXT_4);
    stringBuffer.append(form.getHeaderImage());
    stringBuffer.append(TEXT_5);
    stringBuffer.append(form.getHeader());
    stringBuffer.append(TEXT_6);
    stringBuffer.append(form.getHeader());
    stringBuffer.append(TEXT_7);
    
	}

    stringBuffer.append(TEXT_8);
    stringBuffer.append(form.getHeader());
    stringBuffer.append(TEXT_9);
    
	if(StringUtil.isEmpty(form.getHelpLink()) == false) {

    stringBuffer.append(TEXT_10);
    stringBuffer.append(form.getHelpLink());
    stringBuffer.append(TEXT_11);
    
	}

    stringBuffer.append(TEXT_12);
    
	if(form.getFieldsets() != null && form.getFieldsets().size() > 0) {
		for (Fieldset thisFieldset : form.getFieldsets()) {

    stringBuffer.append(TEXT_13);
    stringBuffer.append(thisFieldset.getLegend());
    stringBuffer.append(TEXT_14);
    
	if(thisFieldset.getFields() != null && thisFieldset.getFields().size() > 0) {
		for (DataField thisDataField : thisFieldset.getFields()) {
			String fieldType = thisDataField.getInputType().toString();
			String fieldName = thisDataField.getName();

    stringBuffer.append(TEXT_15);
    if((fieldType == InputType.TEXT.toString()) || (fieldType==InputType.PASSWORD.toString()) || 
						(fieldType==InputType.EMAIL.toString())  || (fieldType==InputType.DATETIME_LOCAL.toString())  || 
						(fieldType==InputType.TIME.toString()) || (fieldType==InputType.NUMBER.toString()) || 
						(fieldType==InputType.DATE.toString())){
    stringBuffer.append(TEXT_16);
    stringBuffer.append(fieldName);
    stringBuffer.append(TEXT_17);
    stringBuffer.append(thisDataField.getLabel());
    stringBuffer.append(TEXT_18);
    stringBuffer.append(fieldType);
    stringBuffer.append(TEXT_19);
    stringBuffer.append(fieldName);
    stringBuffer.append(TEXT_20);
    stringBuffer.append(fieldName);
    stringBuffer.append(TEXT_21);
    }
						if (thisDataField.getInfo() != null && thisDataField.getInfo().length() > 0){
    stringBuffer.append(TEXT_22);
    stringBuffer.append(thisDataField.getInfo());
    stringBuffer.append(TEXT_23);
    }
    stringBuffer.append(TEXT_24);
    
		}
	}

    stringBuffer.append(TEXT_25);
    
		}
	}

    stringBuffer.append(TEXT_26);
    return stringBuffer.toString();
  }
}
