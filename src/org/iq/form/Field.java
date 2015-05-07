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
	private String label;
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