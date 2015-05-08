package org.iq.form.templates;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.iq.form.DataField;
import org.iq.form.Fieldset;
import org.iq.form.Form;
import org.iq.form.FormConstants.InputType;
import org.iq.form.FormConstants.Method;

public class TemplateTest {
	
	public static void main(String[] args) {
		Form form = new Form();
		
		form.setId(1);
		form.setMethod(Method.POST);
		form.setAction("formhandler");

		form.setHeaderImage("headerImage");
		form.setHeader("form header");
		form.setHelpLink("helpLink");
		
		List<Fieldset> fieldsets = new ArrayList<Fieldset>();
		
		Fieldset fieldset = new Fieldset();
		fieldset.setId(1);
		fieldset.setLegend("Fieldset #1");
		fieldset.setFields(prepareDataFields());
		
		fieldsets.add(fieldset);
		
		fieldset = new Fieldset();
		fieldset.setId(1);
		fieldset.setLegend("Fieldset #2");
		fieldset.setFields(prepareDataFields());
		
		fieldsets.add(fieldset);
		
		form.setFieldsets(fieldsets);
		
		System.out.println(new FormTemplate().generate(form));
	}

	private static List<DataField> prepareDataFields() {
		List<DataField> dataFields = new ArrayList<DataField>();
		
		DataField dataField = new DataField();
		dataField.setId(1);
		dataField.setHtmlId(Long.toHexString(UUID.randomUUID().getMostSignificantBits()));
		dataField.setLabel("Field #1");
		dataField.setName("Field #1");
		dataField.setFieldInfo("This is field #1 information");
		dataField.setInputType(InputType.TEXT);
		
		dataFields.add(dataField);
		
		dataField = new DataField();
		dataField.setId(2);
		dataField.setHtmlId(Long.toHexString(UUID.randomUUID().getMostSignificantBits()));
		dataField.setLabel("Field #2");
		dataField.setName("Field #2");
		dataField.setInputType(InputType.PASSWORD);
		
		dataFields.add(dataField);
		
		return dataFields;
	}
}
