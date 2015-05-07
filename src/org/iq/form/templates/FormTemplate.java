package org.iq.form.templates;

import org.iq.form.Form;

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
  protected final String TEXT_2 = "\" action=\"${pageContext.request.contextPath}/adapter\">" + NL + "\t\t<input type=\"hidden\" name=\"serviceName\" value=\"InsertOrganization\" />" + NL + "\t\t<div class=\"form-header\">" + NL + "\t\t\t<img src=\"${pageContext.request.contextPath}/__sys/img/org-16-16.png\" alt=\"New Organization\" title=\"New Organization\" />" + NL + "\t\t\t<h3>Form Header</h3>" + NL + "\t\t\t<a href=\"\"><img src=\"${pageContext.request.contextPath}/__sys/img/help.png\" alt=\"Help\" title=\"Help\"/></a>" + NL + "\t\t</div>" + NL + "\t\t<div class=\"form-content\">" + NL + "\t\t\t<fieldset>" + NL + "\t\t\t\t<legend>fieldset legend</legend>" + NL + "\t\t\t\t<div class=\"fields-row\">" + NL + "\t\t\t\t\t<div class=\"field-col\">" + NL + "\t\t\t\t\t\t<label for=\"name\">data fld label</label>" + NL + "\t\t\t\t\t\t<input type=\"text\" id=\"field-id\" name=\"field-name\" value=\"field-value\" required />" + NL + "\t\t\t\t\t\t<div class=\"field-info-container\">" + NL + "\t\t\t\t\t\t\t<div class=\"field-info\">" + NL + "\t\t\t\t\t\t\t\t<div class=\"info-content\">This is field information</div>" + NL + "\t\t\t\t\t\t\t</div>" + NL + "\t\t\t\t\t\t</div>" + NL + "\t\t\t\t\t\t<div id=\"field-id-error\" class=\"-iq-error\">This is field validation error</div>" + NL + "\t\t\t\t\t</div>" + NL + "\t\t\t\t</div>" + NL + "\t\t\t</fieldset>" + NL + "\t\t\t<div class=\"clear\"></div>" + NL + "\t\t</div>" + NL + "\t\t<div class=\"form-actions\">" + NL + "\t\t\t<input type=\"submit\" id=\"field-id\" value=\"action fld label\" />" + NL + "\t\t</div>" + NL + "\t</form>" + NL + "</div>";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
	Form form = (Form)argument;

    stringBuffer.append(TEXT_1);
    stringBuffer.append(form.getMethod().toString());
    stringBuffer.append(TEXT_2);
    return stringBuffer.toString();
  }
}
