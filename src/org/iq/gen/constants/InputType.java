package org.iq.gen.constants;
/**
 * @author Sam
 *
 */
public enum InputType {
	BUTTON(1),
	CHECKBOX(2),
	COLOR(3),
	DATE(4),
	/*DATETIME(5),*/	/*The input type datetime is removed from the HTML standard. Use datetime-local instead.*/
	DATETIME_LOCAL(6),
	EMAIL(7),
	IMAGE(8),
	MONTH(9),
	NUMBER(10),
	PASSWORD(11),
	RADIO(12),
	RANGE(13),
	SEARCH(14),
	SUBMIT(15),
	/*TEL(16),*/	/*Not supported by Chrome*/
	TEXT(17),
	TIME(18),
	URL(19),
	WEEK(20),
	SELECT(21);

	private final int inputType;

	InputType(int inputType) {
		this.inputType = inputType;
	}

	/**
	 * @return int
	 */
	public int getInputTypeValue() {
		return inputType;
	}

	/**
	 * @param inputTypeValue
	 * @return InputType
	 */
	public static InputType getInputType(int inputTypeValue) {
		InputType inputType = null;
		for (InputType type : InputType.values()) {
			if (type.getInputTypeValue() == inputTypeValue) {
				inputType = type;
				break;
			}
		}
		return inputType;
	}

	@Override
	public String toString() {
		switch (this) {
		case BUTTON:
			return "button";
		case CHECKBOX:
			return "checkbox";
		case COLOR:
			return "color";
		case DATE:
			return "date";
		/*case DATETIME:
			return "datetime";*/	/*The input type datetime is removed from the HTML standard. Use datetime-local instead.*/
		case DATETIME_LOCAL:
			return "datetime-local";
		case EMAIL:
			return "email";
		case MONTH:
			return "month";
		case NUMBER:
			return "number";
		case PASSWORD:
			return "password";
		case RADIO:
			return "radio";
		case RANGE:
			return "range";
		case SEARCH:
			return "search";
		case SUBMIT:
			return "submit";
		/*case TEL:
			return "tel";*/		/*Not supported by Chrome*/
		case TEXT:
			return "text";
		case TIME:
			return "time";
		case URL:
			return "url";
		case WEEK:
			return "week";
		default:
			return "text";
		}
	}
}