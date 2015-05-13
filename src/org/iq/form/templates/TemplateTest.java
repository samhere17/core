package org.iq.form.templates;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.iq.form.DataField;
import org.iq.form.Field;
import org.iq.form.Fieldset;
import org.iq.form.Form;
import org.iq.form.FormConstants.InputType;
import org.iq.form.FormConstants.Method;
import org.iq.form.MultiValuedField;

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

	private static List<org.iq.form.Field> prepareDataFields() {
		List<Field> dataFields = new ArrayList<Field>();
		
		DataField dataField = new DataField();
		dataField.setId(1);
		dataField.setHtmlId(Long.toHexString(UUID.randomUUID().getMostSignificantBits()));
		dataField.setLabel("Field #1");
		dataField.setName("Field #1");
		dataField.setDisabled(true);
		dataField.setReadonly(true);
		dataField.setMaxLength("10");
		dataField.setFieldInfo("This is field #1 information");
		dataField.setInputType(InputType.TEXT);
		
		dataFields.add(dataField);
		
		MultiValuedField multiValuedField = new MultiValuedField();
		multiValuedField.setId(2);
		multiValuedField.setHtmlId(Long.toHexString(UUID.randomUUID().getMostSignificantBits()));
		multiValuedField.setLabel("Field #2");
		multiValuedField.setName("Field #2");
		multiValuedField.setRequired(true);
		multiValuedField.setInputType(InputType.RADIO);
		String[] s = {"Male","Female"};
		multiValuedField.setValues(s);
		
		dataFields.add(multiValuedField);
		
		multiValuedField = new MultiValuedField();
		multiValuedField.setId(2);
		multiValuedField.setHtmlId(Long.toHexString(UUID.randomUUID().getMostSignificantBits()));
		multiValuedField.setLabel("Field #3");
		multiValuedField.setName("Field #3");
		multiValuedField.setRequired(true);
		multiValuedField.setInputType(InputType.CHECKBOX);
		String[] s1 = {"Maths","Science","Social"};
		multiValuedField.setValues(s1);
		
		dataFields.add(multiValuedField);
		
		multiValuedField = new MultiValuedField();
		multiValuedField.setId(2);
		multiValuedField.setHtmlId(Long.toHexString(UUID.randomUUID().getMostSignificantBits()));
		multiValuedField.setLabel("Field #4");
		multiValuedField.setName("Field #4");
		multiValuedField.setRequired(true);
		multiValuedField.setInputType(InputType.SELECT);
		String[] s2 = {"Male","Female"};
		multiValuedField.setValues(s2);
		
		dataFields.add(multiValuedField);
		
		return dataFields;
	}
}
