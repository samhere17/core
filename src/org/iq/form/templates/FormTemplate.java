package org.iq.form.templates;

import java.util.HashSet;
import java.util.Properties;
import java.util.Set;
import org.iq.form.Field;
import org.iq.form.Fieldset;
import org.iq.form.Form;
import org.iq.form.FormConstants.InputType;
import org.iq.util.StringUtil;
import org.iq.form.MultiValuedField;

public class FormTemplate {

  protected static String nl;
  public static synchronized FormTemplate create(String lineSeparator)
  {
    nl = lineSeparator;
    FormTemplate result = new FormTemplate();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "<div class=\"gf-container\">" + NL + "\t<form method=\"";
  protected final String TEXT_2 = "\" action=\"${pageContext.request.contextPath}/";
  protected final String TEXT_3 = "\">" + NL + "\t\t<div class=\"gf-header\">";
  protected final String TEXT_4 = NL + "\t\t\t<img class=\"gf-header-img\" src=\"${pageContext.request.contextPath}/";
  protected final String TEXT_5 = "\" alt=\"";
  protected final String TEXT_6 = "\" title=\"";
  protected final String TEXT_7 = "\" />";
  protected final String TEXT_8 = NL + "\t\t\t<h3 class=\"gf-header-text\">";
  protected final String TEXT_9 = "</h3>";
  protected final String TEXT_10 = NL + "\t\t\t<a href=\"${pageContext.request.contextPath}/";
  protected final String TEXT_11 = "\"><img class=\"gf-header-help\" src=\"${pageContext.request.contextPath}/__sys/img/help.png\" alt=\"Help\" title=\"Help\"/></a>";
  protected final String TEXT_12 = NL + "\t\t</div>" + NL + "\t\t<div class=\"gf-content\">";
  protected final String TEXT_13 = NL + "\t\t\t<fieldset>" + NL + "\t\t\t\t<legend>";
  protected final String TEXT_14 = "</legend>" + NL + "\t\t\t</fieldset>";
  protected final String TEXT_15 = NL + "\t\t</div>" + NL + "\t\t<div class=\"gf-actions\">" + NL + "\t\t</div>" + NL + "\t</form>" + NL + "</div>";
  protected final String TEXT_16 = NL;
  protected final String TEXT_17 = NL + "<style type=\"text/css\" media=\"screen\">";
  protected final String TEXT_18 = NL;
  protected final String TEXT_19 = " {";
  protected final String TEXT_20 = "}";
  protected final String TEXT_21 = NL + "</style>";
  protected final String TEXT_22 = NL + NL + NL + NL + NL + NL + NL + "<div class=\"form-container\">" + NL + "\t<form method=\"";
  protected final String TEXT_23 = "\" action=\"${pageContext.request.contextPath}/";
  protected final String TEXT_24 = "\">" + NL + "\t\t<input type=\"hidden\" name=\"serviceName\" value=\"InsertOrganization\" />" + NL + "\t\t<div class=\"form-header\">";
  protected final String TEXT_25 = NL + "\t\t\t<img src=\"${pageContext.request.contextPath}/";
  protected final String TEXT_26 = "\" alt=\"";
  protected final String TEXT_27 = "\" title=\"";
  protected final String TEXT_28 = "\" />";
  protected final String TEXT_29 = NL + "\t\t\t<h3>";
  protected final String TEXT_30 = "</h3>";
  protected final String TEXT_31 = NL + "\t\t\t<a href=\"${pageContext.request.contextPath}/";
  protected final String TEXT_32 = "\"><img src=\"${pageContext.request.contextPath}/__sys/img/help.png\" alt=\"Help\" title=\"Help\"/></a>";
  protected final String TEXT_33 = NL + "\t\t</div>" + NL + "\t\t<div class=\"form-content\">";
  protected final String TEXT_34 = NL + "\t\t\t<fieldset>" + NL + "\t\t\t\t<legend>";
  protected final String TEXT_35 = "</legend>" + NL + "\t\t\t\t<div class=\"fields-row\">";
  protected final String TEXT_36 = NL;
  protected final String TEXT_37 = "\t\t\t\t\t<div class=\"field-col\">" + NL + "\t\t\t\t\t\t<label for=\"";
  protected final String TEXT_38 = "\">";
  protected final String TEXT_39 = "</label>" + NL + "\t\t\t\t\t\t<input type=\"";
  protected final String TEXT_40 = "\" id=\"";
  protected final String TEXT_41 = "\" name=\"";
  protected final String TEXT_42 = "\" value=\"field-value\" ";
  protected final String TEXT_43 = " maxlength=\"";
  protected final String TEXT_44 = "\"";
  protected final String TEXT_45 = " disabled";
  protected final String TEXT_46 = " readonly";
  protected final String TEXT_47 = " required";
  protected final String TEXT_48 = "/>";
  protected final String TEXT_49 = NL + "\t\t\t\t\t\t<div class=\"field-info-container\">" + NL + "\t\t\t\t\t\t\t<div class=\"field-info\">" + NL + "\t\t\t\t\t\t\t\t<div class=\"info-content\">";
  protected final String TEXT_50 = "</div>" + NL + "\t\t\t\t\t\t\t</div>" + NL + "\t\t\t\t\t\t</div>";
  protected final String TEXT_51 = NL + "\t\t\t\t\t\t<div id=\"field-id-error\" class=\"-iq-error\"></div>" + NL + "\t\t\t\t\t</div>";
  protected final String TEXT_52 = NL;
  protected final String TEXT_53 = "\t\t\t\t\t<div class=\"field-col\">" + NL + "\t\t\t\t\t\t<label for=\"";
  protected final String TEXT_54 = "\">";
  protected final String TEXT_55 = "</label>";
  protected final String TEXT_56 = NL + "\t\t\t\t\t\t\t\t<input type=\"";
  protected final String TEXT_57 = "\" id=\"";
  protected final String TEXT_58 = "\" name=\"";
  protected final String TEXT_59 = "\" value=\"";
  protected final String TEXT_60 = "\" ";
  protected final String TEXT_61 = " disabled";
  protected final String TEXT_62 = " readonly";
  protected final String TEXT_63 = " required";
  protected final String TEXT_64 = "/>\t";
  protected final String TEXT_65 = NL + "\t\t\t\t\t<select id=\"";
  protected final String TEXT_66 = "\" name=\"";
  protected final String TEXT_67 = "\">";
  protected final String TEXT_68 = NL + "\t\t\t\t\t\t\t<option value=\"";
  protected final String TEXT_69 = "\">";
  protected final String TEXT_70 = "</option>";
  protected final String TEXT_71 = "\t\t\t\t\t" + NL + "\t\t\t\t\t</select>\t\t\t\t\t";
  protected final String TEXT_72 = NL + "\t\t\t\t\t\t<div class=\"field-info-container\">" + NL + "\t\t\t\t\t\t\t<div class=\"field-info\">" + NL + "\t\t\t\t\t\t\t\t<div class=\"info-content\">";
  protected final String TEXT_73 = "</div>" + NL + "\t\t\t\t\t\t\t</div>" + NL + "\t\t\t\t\t\t</div>";
  protected final String TEXT_74 = NL + "\t\t\t\t\t\t<div id=\"field-id-error\" class=\"-iq-error\"></div>" + NL + "\t\t\t\t\t</div>";
  protected final String TEXT_75 = NL + "\t\t\t\t</div>" + NL + "\t\t\t</fieldset>";
  protected final String TEXT_76 = NL + "\t\t\t<div class=\"clear\"></div>" + NL + "\t\t</div>" + NL + "\t\t<div class=\"form-actions\">" + NL + "\t\t\t<input type=\"submit\" id=\"field-id\" value=\"action    fld label\" />" + NL + "\t\t</div>" + NL + "\t</form>" + NL + "</div>";

	public String generate(Form form, Properties cssProps)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
	Set<String> reqCssClassNames = new HashSet<String>();
	
	if (form != null) {
		reqCssClassNames.add(".gf-container");
		reqCssClassNames.add(".gf-header");
		reqCssClassNames.add(".gf-content");
		reqCssClassNames.add(".gf-actions");

    stringBuffer.append(TEXT_1);
    stringBuffer.append(form.getMethod().toString());
    stringBuffer.append(TEXT_2);
    stringBuffer.append(form.getAction());
    stringBuffer.append(TEXT_3);
    
	if(StringUtil.isEmpty(form.getHeaderImage()) == false) {
		reqCssClassNames.add(".gf-header-img");

    stringBuffer.append(TEXT_4);
    stringBuffer.append(form.getHeaderImage());
    stringBuffer.append(TEXT_5);
    stringBuffer.append(form.getHeader());
    stringBuffer.append(TEXT_6);
    stringBuffer.append(form.getHeader());
    stringBuffer.append(TEXT_7);
    
	}
	reqCssClassNames.add(".gf-header-text");

    stringBuffer.append(TEXT_8);
    stringBuffer.append(form.getHeader());
    stringBuffer.append(TEXT_9);
    
	if(StringUtil.isEmpty(form.getHelpLink()) == false) {
		reqCssClassNames.add("a>.gf-header-help");
		reqCssClassNames.add("a:hover>.gf-header-help");

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
    
			}
		}

    stringBuffer.append(TEXT_15);
    
	}

    stringBuffer.append(TEXT_16);
    
	if (reqCssClassNames.isEmpty() == false) {

    stringBuffer.append(TEXT_17);
    
		for (String cssClassName : reqCssClassNames) {
			String cssString = (String)cssProps.get(cssClassName);

    stringBuffer.append(TEXT_18);
    stringBuffer.append(cssClassName);
    stringBuffer.append(TEXT_19);
    stringBuffer.append(StringUtil.isEmpty(cssString) ? "" : cssString);
    stringBuffer.append(TEXT_20);
    			
		}

    stringBuffer.append(TEXT_21);
    
	}

    stringBuffer.append(TEXT_22);
    stringBuffer.append(form.getMethod().toString());
    stringBuffer.append(TEXT_23);
    stringBuffer.append(form.getAction());
    stringBuffer.append(TEXT_24);
    
	if(StringUtil.isEmpty(form.getHeaderImage()) == false) {

    stringBuffer.append(TEXT_25);
    stringBuffer.append(form.getHeaderImage());
    stringBuffer.append(TEXT_26);
    stringBuffer.append(form.getHeader());
    stringBuffer.append(TEXT_27);
    stringBuffer.append(form.getHeader());
    stringBuffer.append(TEXT_28);
    
	}

    stringBuffer.append(TEXT_29);
    stringBuffer.append(form.getHeader());
    stringBuffer.append(TEXT_30);
    
	if(StringUtil.isEmpty(form.getHelpLink()) == false) {

    stringBuffer.append(TEXT_31);
    stringBuffer.append(form.getHelpLink());
    stringBuffer.append(TEXT_32);
    
	}

    stringBuffer.append(TEXT_33);
    
	if(form.getFieldsets() != null && form.getFieldsets().size() > 0) {
		for (Fieldset thisFieldset : form.getFieldsets()) {

    stringBuffer.append(TEXT_34);
    stringBuffer.append(thisFieldset.getLegend());
    stringBuffer.append(TEXT_35);
    
			if(thisFieldset.getFields() != null && thisFieldset.getFields().size() > 0) {
				for (Field thisDataField : thisFieldset.getFields()) {
					InputType fieldType = thisDataField.getInputType();
					//Checking if field is simple type
						if ((InputType.COLOR.equals(fieldType))
								|| (InputType.DATE.equals(fieldType))
								|| (InputType.DATETIME_LOCAL.equals(fieldType))
								|| (InputType.EMAIL.equals(fieldType))
								|| (InputType.MONTH.equals(fieldType))
								|| (InputType.NUMBER.equals(fieldType))
								|| (InputType.PASSWORD.equals(fieldType))
								|| (InputType.RANGE.equals(fieldType))
								|| (InputType.SEARCH.equals(fieldType))
								|| (InputType.TEXT.equals(fieldType))
								|| (InputType.TIME.equals(fieldType))
								|| (InputType.URL.equals(fieldType))
								|| (InputType.WEEK.equals(fieldType))) {

    stringBuffer.append(TEXT_36);
    stringBuffer.append(TEXT_37);
    stringBuffer.append(thisDataField.getHtmlId());
    stringBuffer.append(TEXT_38);
    stringBuffer.append(thisDataField.getLabel());
    stringBuffer.append(TEXT_39);
    stringBuffer.append(fieldType);
    stringBuffer.append(TEXT_40);
    stringBuffer.append(thisDataField.getHtmlId());
    stringBuffer.append(TEXT_41);
    stringBuffer.append(thisDataField.getName());
    stringBuffer.append(TEXT_42);
    if(thisDataField.getMaxLength()!=null && thisDataField.getMaxLength().length()>0){
    stringBuffer.append(TEXT_43);
    stringBuffer.append(thisDataField.getMaxLength());
    stringBuffer.append(TEXT_44);
    }if(thisDataField.isDisabled()){
    stringBuffer.append(TEXT_45);
    }if(thisDataField.isReadonly()){
    stringBuffer.append(TEXT_46);
    }if(thisDataField.isRequired()){
    stringBuffer.append(TEXT_47);
    }
    stringBuffer.append(TEXT_48);
    
						if (StringUtil.isEmpty(thisDataField.getFieldInfo()) == false) {

    stringBuffer.append(TEXT_49);
    stringBuffer.append(thisDataField.getFieldInfo());
    stringBuffer.append(TEXT_50);
    
						}

    stringBuffer.append(TEXT_51);
    
					}else if((InputType.SELECT.equals(fieldType)) || (InputType.RADIO.equals(fieldType)) || (InputType.CHECKBOX.equals(fieldType))){

    stringBuffer.append(TEXT_52);
    stringBuffer.append(TEXT_53);
    stringBuffer.append(thisDataField.getHtmlId());
    stringBuffer.append(TEXT_54);
    stringBuffer.append(thisDataField.getLabel());
    stringBuffer.append(TEXT_55);
    						
						MultiValuedField multiValuedField = (MultiValuedField)thisDataField;
						String[] values = multiValuedField.getValues();
						if((InputType.RADIO.equals(fieldType)) || (InputType.CHECKBOX.equals(fieldType))){
							for (int i = 0; i < values.length; i++) {

    stringBuffer.append(TEXT_56);
    stringBuffer.append(fieldType);
    stringBuffer.append(TEXT_57);
    stringBuffer.append(thisDataField.getHtmlId());
    stringBuffer.append(TEXT_58);
    stringBuffer.append(thisDataField.getName());
    stringBuffer.append(TEXT_59);
    stringBuffer.append(values[i]);
    stringBuffer.append(TEXT_60);
    if(thisDataField.isDisabled()){
    stringBuffer.append(TEXT_61);
    }if(thisDataField.isReadonly()){
    stringBuffer.append(TEXT_62);
    }if(thisDataField.isRequired()){
    stringBuffer.append(TEXT_63);
    }
    stringBuffer.append(TEXT_64);
    
							}
					}else if(InputType.SELECT.equals(fieldType)){

    stringBuffer.append(TEXT_65);
    stringBuffer.append(thisDataField.getHtmlId());
    stringBuffer.append(TEXT_66);
    stringBuffer.append(thisDataField.getName());
    stringBuffer.append(TEXT_67);
    
						for (int i = 0; i < values.length; i++) {

    stringBuffer.append(TEXT_68);
    stringBuffer.append(values[i]);
    stringBuffer.append(TEXT_69);
    stringBuffer.append(values[i]);
    stringBuffer.append(TEXT_70);
    
						}

    stringBuffer.append(TEXT_71);
    					
						}
						if (StringUtil.isEmpty(thisDataField.getFieldInfo()) == false) {

    stringBuffer.append(TEXT_72);
    stringBuffer.append(thisDataField.getFieldInfo());
    stringBuffer.append(TEXT_73);
    
						}

    stringBuffer.append(TEXT_74);
    					
					}
				}
			}

    stringBuffer.append(TEXT_75);
    
		}
	}

    stringBuffer.append(TEXT_76);
    return stringBuffer.toString();
  }
}