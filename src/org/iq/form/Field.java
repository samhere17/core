package org.iq.form;

import org.iq.form.FormConstants.InputType;
import org.iq.valueobject.BaseVO;

public class Field extends BaseVO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 438365728861221847L;
	/**
	 * 
	 */
	private int id = 0;
	private String htmlId;
	private String label;
	private String name;
	private String fieldInfo;
	private InputType inputType;
	
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	
	/**
	 * @return the htmlId
	 */
	public String getHtmlId() {
		return htmlId;
	}

	/**
	 * @param htmlId the htmlId to set
	 */
	public void setHtmlId(String htmlId) {
		this.htmlId = htmlId;
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
	 * @param fieldInfo the fieldInfo to set
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
	public void setInputType(int inputTypeValue) {
		this.inputType = InputType.getInputType(inputTypeValue);
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return null;
	}
}