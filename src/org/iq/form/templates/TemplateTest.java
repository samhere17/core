package org.iq.form.templates;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.iq.form.DataField;
import org.iq.form.Field;
import org.iq.form.Fieldset;
import org.iq.form.Form;
import org.iq.form.FormBuilder;
import org.iq.form.FormConstants.InputType;
import org.iq.form.FormConstants.Method;

public class TemplateTest {
	
	public static void main(String[] args) {
		
		System.out.println(new FormTemplate().generate(getDummyForm(),FormBuilder.cssProps));
	}
	
	public static Form getDummyForm() {
		Form form = new Form();

		form.setId(1);
		form.setMethod(Method.POST);
		form.setAction("formhandler");

		form.setHeaderImage("__sys/img/home-16-16.png");
		form.setHeader("Dummy Form's Header");
		form.setHelpLink("__sys/img/help-16-16.png");

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

		return form;
	}

	private static List<Field> prepareDataFields() {
		List<Field> fields = new ArrayList<Field>();
		
		// Normal fields
//		fields.add(getDataField("Color", InputType.COLOR, "This is a Color field", false, false, false, 10));
		fields.add(getDataField("Date", InputType.DATE, "This is a Date field", false, false, false, 10));
		fields.add(getDataField("DateTimeLocal", InputType.DATETIME_LOCAL, "This is a DateTimeLocal field", false, false, false, 10));
		fields.add(getDataField("Email", InputType.EMAIL, "This is a Email field", false, false, false, 10));
//		fields.add(getDataField("Month", InputType.MONTH, "This is a Month field", false, false, false, 10));
//		fields.add(getDataField("Number", InputType.NUMBER, "This is a Number field", false, false, false, 10));
		fields.add(getDataField("Password", InputType.PASSWORD, "This is a Password field", false, false, false, 10));
//		fields.add(getDataField("Range", InputType.RANGE, "This is a Range field", false, false, false, 10));
//		fields.add(getDataField("Search", InputType.SEARCH, "This is a Search field", false, false, false, 10));
		fields.add(getDataField("Text", InputType.TEXT, "This is a Text field", false, false, false, 10));
		fields.add(getDataField("Time", InputType.TIME, "This is a Time field", false, false, false, 10));
//		fields.add(getDataField("URL", InputType.URL, "This is a URL field", false, false, false, 10));
//		fields.add(getDataField("Week", InputType.WEEK, "This is a Week field", false, false, false, 10));
		
		// Disabled fields
//		fields.add(getDataField("Color Disabled", InputType.COLOR, "This is a Disabled Color field", true, false, false, 10));
		fields.add(getDataField("Date Disabled", InputType.DATE, "This is a Disabled Date field", true, false, false, 10));
		fields.add(getDataField("DateTimeLocal Disabled", InputType.DATETIME_LOCAL, "This is a Disabled DateTimeLocal field", true, false, false, 10));
		fields.add(getDataField("Email Disabled", InputType.EMAIL, "This is a Disabled Email field", true, false, false, 10));
//		fields.add(getDataField("Month Disabled", InputType.MONTH, "This is a Disabled Month field", true, false, false, 10));
//		fields.add(getDataField("Number Disabled", InputType.NUMBER, "This is a Disabled Number field", true, false, false, 10));
		fields.add(getDataField("Password Disabled", InputType.PASSWORD, "This is a Disabled Password field", true, false, false, 10));
//		fields.add(getDataField("Range Disabled", InputType.RANGE, "This is a Disabled Range field", true, false, false, 10));
//		fields.add(getDataField("Search Disabled", InputType.SEARCH, "This is a Disabled Search field", true, false, false, 10));
		fields.add(getDataField("Text Disabled", InputType.TEXT, "This is a Disabled Text field", true, false, false, 10));
		fields.add(getDataField("Time Disabled", InputType.TIME, "This is a Disabled Time field", true, false, false, 10));
//		fields.add(getDataField("URL Disabled", InputType.URL, "This is a Disabled URL field", true, false, false, 10));
//		fields.add(getDataField("Week Disabled", InputType.WEEK, "This is a Disabled Week field", true, false, false, 10));
		
		// Readonly fields
//		fields.add(getDataField("Color Readonly", InputType.COLOR, "This is a Readonly Color field", false, true, false, 10));
//		fields.add(getDataField("Date Readonly", InputType.DATE, "This is a Readonly Date field", false, true, false, 10));
//		fields.add(getDataField("DateTimeLocal Readonly", InputType.DATETIME_LOCAL, "This is a Readonly DateTimeLocal field", false, true, false, 10));
//		fields.add(getDataField("Email Readonly", InputType.EMAIL, "This is a Readonly Email field", false, true, false, 10));
//		fields.add(getDataField("Month Readonly", InputType.MONTH, "This is a Readonly Month field", false, true, false, 10));
//		fields.add(getDataField("Number Readonly", InputType.NUMBER, "This is a Readonly Number field", false, true, false, 10));
//		fields.add(getDataField("Password Readonly", InputType.PASSWORD, "This is a Readonly Password field", false, true, false, 10));
//		fields.add(getDataField("Range Readonly", InputType.RANGE, "This is a Readonly Range field", false, true, false, 10));
//		fields.add(getDataField("Search Readonly", InputType.SEARCH, "This is a Readonly Search field", false, true, false, 10));
//		fields.add(getDataField("Text Readonly", InputType.TEXT, "This is a Readonly Text field", false, true, false, 10));
//		fields.add(getDataField("Time Readonly", InputType.TIME, "This is a Readonly Time field", false, true, false, 10));
//		fields.add(getDataField("URL Readonly", InputType.URL, "This is a Readonly URL field", false, true, false, 10));
//		fields.add(getDataField("Week Readonly", InputType.WEEK, "This is a Readonly Week field", false, true, false, 10));
		
		// Required fields
//		fields.add(getDataField("Color Required", InputType.COLOR, "This is a Required Color field", false, false, true, 10));
//		fields.add(getDataField("Date Required", InputType.DATE, "This is a Required Date field", false, false, true, 10));
//		fields.add(getDataField("DateTimeLocal Required", InputType.DATETIME_LOCAL, "This is a Required DateTimeLocal field", false, false, true, 10));
//		fields.add(getDataField("Email Required", InputType.EMAIL, "This is a Required Email field", false, false, true, 10));
//		fields.add(getDataField("Month Required", InputType.MONTH, "This is a Required Month field", false, false, true, 10));
//		fields.add(getDataField("Number Required", InputType.NUMBER, "This is a Required Number field", false, false, true, 10));
//		fields.add(getDataField("Password Required", InputType.PASSWORD, "This is a Required Password field", false, false, true, 10));
//		fields.add(getDataField("Range Required", InputType.RANGE, "This is a Required Range field", false, false, true, 10));
//		fields.add(getDataField("Search Required", InputType.SEARCH, "This is a Required Search field", false, false, true, 10));
//		fields.add(getDataField("Text Required", InputType.TEXT, "This is a Required Text field", false, false, true, 10));
//		fields.add(getDataField("Time Required", InputType.TIME, "This is a Required Time field", false, false, true, 10));
//		fields.add(getDataField("URL Required", InputType.URL, "This is a Required URL field", false, false, true, 10));
//		fields.add(getDataField("Week Required", InputType.WEEK, "This is a Required Week field", false, false, true, 10));
		

		/*MultiValuedField multiValuedField = new MultiValuedField();
		multiValuedField.setId(2);
		multiValuedField.setHtmlId(Long.toHexString(UUID.randomUUID().getMostSignificantBits()));
		multiValuedField.setLabel("Field #2");
		multiValuedField.setName("Field #2");
		multiValuedField.setRequired(true);
		multiValuedField.setInputType(InputType.RADIO);
		String[] s = {"Male","Female"};
		multiValuedField.setValues(s);
		
		fields.add(multiValuedField);
		
		multiValuedField = new MultiValuedField();
		multiValuedField.setId(2);
		multiValuedField.setHtmlId(Long.toHexString(UUID.randomUUID().getMostSignificantBits()));
		multiValuedField.setLabel("Field #3");
		multiValuedField.setName("Field #3");
		multiValuedField.setRequired(true);
		multiValuedField.setInputType(InputType.CHECKBOX);
		String[] s1 = {"Maths","Science","Social"};
		multiValuedField.setValues(s1);
		
		fields.add(multiValuedField);
		
		multiValuedField = new MultiValuedField();
		multiValuedField.setId(2);
		multiValuedField.setHtmlId(Long.toHexString(UUID.randomUUID().getMostSignificantBits()));
		multiValuedField.setLabel("Field #4");
		multiValuedField.setName("Field #4");
		multiValuedField.setRequired(true);
		multiValuedField.setInputType(InputType.SELECT);
		String[] s2 = {"Male","Female"};
		multiValuedField.setValues(s2);
		
		fields.add(multiValuedField);*/
		
		return fields;
	}
	
	/**
	 * @param label
	 * @param inputType
	 * @param fieldInfo
	 * @param disabled
	 * @param readonly
	 * @param required
	 * @return DataField
	 */
	private static DataField getDataField(String label, InputType inputType,
			String fieldInfo, boolean disabled, boolean readonly,
			boolean required, int maxLength) {
		DataField dataField = new DataField();

		dataField.setId(1);
		dataField.setLabel(label);
		dataField.setInputType(inputType);
		dataField.setFieldInfo(fieldInfo);

		dataField.setDisabled(disabled);
		dataField.setReadonly(readonly);
		dataField.setRequired(required);
		dataField.setMaxLength("10");

		dataField.setHtmlId(Long.toHexString(UUID.randomUUID()
				.getMostSignificantBits()));
		dataField.setName("Field #1");
		return dataField;
	}
}
