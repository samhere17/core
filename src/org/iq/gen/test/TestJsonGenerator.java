package org.iq.gen.test;

import java.util.ArrayList;
import java.util.List;

import org.iq.gen.GeneratorUtil;
import org.iq.gen.constants.InputType;
import org.iq.gen.data.DataField;
import org.iq.gen.data.Field;
import org.iq.gen.data.Form;
import org.iq.gen.data.Module;
import org.iq.gen.data.Section;
import org.iq.gen.data.action.RedirectActionData;

public class TestJsonGenerator {
	
	public static void main(String[] args) throws Exception {
		System.out.println(GeneratorUtil.getPrettyJson(getApartmentModule()));
	}
	
	public static Module getApartmentModule() {
		Module module = new Module();
		
		module.setName("Apartment");
		module.setDescription("This module deal with Apartment operations");
		
		List<Form> forms = new ArrayList<Form>();
		forms.add(getApartmentDetailsForm());
		module.setForms(forms);
		
		List<RedirectActionData> redirectActions = new ArrayList<RedirectActionData>();
		redirectActions.addAll(getApartmentRedirectActions());
		module.setRedirectActions(redirectActions);
		
		return module;
	}
	
	private static List<RedirectActionData> getApartmentRedirectActions() {
		List<RedirectActionData> actions = new ArrayList<RedirectActionData>();
		
		RedirectActionData redirectAction = new RedirectActionData();
		redirectAction.setName("ApartmentNew");
		redirectAction.setRedirectUrl("new.jsp");
		actions.add(redirectAction);
		
		return actions;
	}

	private static Form getApartmentDetailsForm() {
		Form form = new Form();
		
		form.setName("ApartmentDetails");
		form.setDescription("This form contains Apartment Details");
		form.setMethod(null);
		form.setAction("Authentication");
		form.setEnctype(null);
		
		List<Section> sections = new ArrayList<>();

		Section section = new Section();
		
		section.setTitle("Basic Information");
		section.setDescription("This is Basic Information section");
		section.setDescription("This is Basic Information section");

		List<Field> fields = new ArrayList<Field>();

		fields.add(getDataField("apt-prefix-1", "Apartment Number Prefix 1", "${apartment.apartmentNumberPrefix1}",
				"This is a Text field for Apartment Number Prefix 1", InputType.TEXT, true, false, false, null));
		fields.add(getDataField("apt-prefix-2", "Apartment Number Prefix 2", "${apartment.apartmentNumberPrefix2}",
				"This is a Text field for Apartment Number Prefix 2", InputType.TEXT, true, false, false, null));

		fields.add(getDataField("apt-number", "Apartment Number", "${apartment.apartmentNumber}",
				"This is a Text field for Apartment Number", InputType.TEXT, true, false, false, null));

		fields.add(getDataField("apt-suffix-1", "Apartment Number Suffix 1", "${apartment.apartmentNumberSuffix1}",
				"This is a Text field for Apartment Number Suffix 1", InputType.TEXT, true, false, false, null));
		fields.add(getDataField("apt-suffix-2", "Apartment Number Suffix 2", "${apartment.apartmentNumberSuffix2}",
				"This is a Text field for Apartment Number Suffix 2", InputType.TEXT, true, false, false, null));
		
		section.setFields(fields);

		sections.add(section);

		form.setSections(sections);
		
//		List<ActionField> actionFields = new ArrayList<ActionField>();
//
//		ActionField actionField = new ActionField();
//		actionField.setName("submit");
//		actionField.setLabel("submit");
//		actionField.setInputType(InputType.SUBMIT);
//		actionField.setActionMethod("post");
//		actionField.setTargetUrl("www.google.com");
//		
//		actionFields.add(actionField);

//		form.setActionFields(actionFields);
		
		return form;
	}

	public static List<Field> prepareDataFields() {
		List<Field> fields = new ArrayList<Field>();
		
		// Normal fields
//		fields.add(getDataField("Color", InputType.COLOR, "This is a Color field", false, false, false, 10));
//		fields.add(getDataField("Date", InputType.DATE, "This is a Date field", false, false, false, 10));
//		fields.add(getDataField("DateTimeLocal", InputType.DATETIME_LOCAL, "This is a DateTimeLocal field", false, false, false, 10));
//		fields.add(getDataField("Email", InputType.EMAIL, "This is a Email field", false, false, false, 10));
//		fields.add(getDataField("Month", InputType.MONTH, "This is a Month field", false, false, false, 10));
//		fields.add(getDataField("Number", InputType.NUMBER, "This is a Number field", false, false, false, 10));
//		fields.add(getDataField("Password", InputType.PASSWORD, "This is a Password field", false, false, false, 10));
//		fields.add(getDataField("Range", InputType.RANGE, "This is a Range field", false, false, false, 10));
//		fields.add(getDataField("Search", InputType.SEARCH, "This is a Search field", false, false, false, 10));
//		fields.add(getDataField("Text", InputType.TEXT, "This is a Text field", false, false, false, 10));
//		fields.add(getDataField("Time", InputType.TIME, "This is a Time field", false, false, false, 10));
//		fields.add(getDataField("URL", InputType.URL, "This is a URL field", false, false, false, 10));
//		fields.add(getDataField("Week", InputType.WEEK, "This is a Week field", false, false, false, 10));
		
		// Disabled fields
//		fields.add(getDataField("Color Disabled", InputType.COLOR, "This is a Disabled Color field", true, false, false, 10));
//		fields.add(getDataField("Date Disabled", InputType.DATE, "This is a Disabled Date field", true, false, false, 10));
//		fields.add(getDataField("DateTimeLocal Disabled", InputType.DATETIME_LOCAL, "This is a Disabled DateTimeLocal field", true, false, false, 10));
//		fields.add(getDataField("Email Disabled", InputType.EMAIL, "This is a Disabled Email field", true, false, false, 10));
//		fields.add(getDataField("Month Disabled", InputType.MONTH, "This is a Disabled Month field", true, false, false, 10));
//		fields.add(getDataField("Number Disabled", InputType.NUMBER, "This is a Disabled Number field", true, false, false, 10));
//		fields.add(getDataField("Password Disabled", InputType.PASSWORD, "This is a Disabled Password field", true, false, false, 10));
//		fields.add(getDataField("Range Disabled", InputType.RANGE, "This is a Disabled Range field", true, false, false, 10));
//		fields.add(getDataField("Search Disabled", InputType.SEARCH, "This is a Disabled Search field", true, false, false, 10));
//		fields.add(getDataField("Text Disabled", InputType.TEXT, "This is a Disabled Text field", true, false, false, 10));
//		fields.add(getDataField("Time Disabled", InputType.TIME, "This is a Disabled Time field", true, false, false, 10));
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
	 * @param name
	 * @param label
	 * @param value
	 * @param fieldInfo
	 * @param inputType
	 * @param readonly
	 * @param required
	 * @param disabled
	 * @param maxLength
	 * @return DataField
	 */
	private static DataField getDataField(String name, String label, String value, String fieldInfo,
			InputType inputType, boolean readonly, boolean required, boolean disabled, String maxLength) {
		DataField dataField = new DataField();

		dataField.setName(name);
		dataField.setLabel(label);
		dataField.setValue(value);
		dataField.setFieldInfo(fieldInfo);
		dataField.setInputType(inputType);

		dataField.setReadonly(readonly);
		dataField.setRequired(required);
		dataField.setDisabled(disabled);
		dataField.setMaxLength(maxLength);

		return dataField;
	}
}
