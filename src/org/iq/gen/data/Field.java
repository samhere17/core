package org.iq.gen.data;

import java.util.UUID;

import org.iq.gen.constants.InputType;

public class Field extends BaseData {

	/**
	 * 
	 */
	private static final long serialVersionUID = 438365728861221847L;
	/**
	 * 
	 */
	private String htmlId = Long.toHexString(UUID.randomUUID().getMostSignificantBits());
	private String name;
	private String label;
	private String value;
	private String fieldInfo;
	private InputType inputType;
	
	private boolean readonly;
	private boolean required;
	private boolean disabled;
	private String maxLength;
	
	/**
	 * @return the htmlId
	 */
	public String getHtmlId() {
		return htmlId;
	}

	/**
	 * @return the label
	 */
	public String getLabel() {
		return label;
	}

	/**
	 * @param label
	 *            the label to set
	 */
	public void setLabel(String label) {
		this.label = label;
	}

	/**
	 * @return the value
	 */
	public String getValue() {
		return value;
	}

	/**
	 * @param value the value to set
	 */
	public void setValue(String value) {
		this.value = value;
	}

	/**
	 * @return
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the fieldInfo
	 */
	public String getFieldInfo() {
		return fieldInfo;
	}

	/**
	 * @param fieldInfo
	 *            the fieldInfo to set
	 */
	public void setFieldInfo(String fieldInfo) {
		this.fieldInfo = fieldInfo;
	}

	/**
	 * @return the inputType
	 */
	public InputType getInputType() {
		return inputType;
	}

	/**
	 * @param inputType
	 *            the inputType to set
	 */
	public void setInputType(InputType inputType) {
		this.inputType = inputType;
	}

	/**
	 * @param inputType
	 *            the inputType to set
	 */
	/*
	 * public void setInputType(int inputTypeValue) { this.inputType =
	 * InputType.getInputType(inputTypeValue); }
	 */

	/**
	 * @return
	 */
	public boolean isReadonly() {
		return readonly;
	}

	/**
	 * @param readonly
	 */
	public void setReadonly(boolean readonly) {
		this.readonly = readonly;
	}

	/**
	 * @return
	 */
	public boolean isRequired() {
		return required;
	}

	/**
	 * @param required
	 */
	public void setRequired(boolean required) {
		this.required = required;
	}

	/**
	 * @return
	 */
	public boolean isDisabled() {
		return disabled;
	}

	/**
	 * @param disabled
	 */
	public void setDisabled(boolean disabled) {
		this.disabled = disabled;
	}

	/**
	 * @return
	 */
	public String getMaxLength() {
		return maxLength;
	}

	/**
	 * @param maxLength
	 */
	public void setMaxLength(String maxLength) {
		this.maxLength = maxLength;
	}
}