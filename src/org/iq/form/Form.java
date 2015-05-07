package org.iq.form;

import java.util.List;

import org.iq.form.FormConstants.Method;
import org.iq.valueobject.BaseVO;

public class Form extends BaseVO {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4830954819661388514L;
	private int id = 0;
	private String name;
	private String action;
	private Method method;
	private List<Fieldset> fieldsets;
	private List<ActionField> actionFields;

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
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the action
	 */
	public String getAction() {
		return action;
	}

	/**
	 * @param action
	 *            the action to set
	 */
	public void setAction(String action) {
		this.action = action;
	}

	/**
	 * @return the method
	 */
	public Method getMethod() {
		return method;
	}

	/**
	 * @param method
	 *            the method to set
	 */
	public void setMethod(Method method) {
		this.method = method;
	}

	/**
	 * @return the fieldsets
	 */
	public List<Fieldset> getFieldsets() {
		return fieldsets;
	}

	/**
	 * @param fieldsets
	 *            the fieldsets to set
	 */
	public void setFieldsets(List<Fieldset> fieldsets) {
		this.fieldsets = fieldsets;
	}

	/**
	 * @return the actionFields
	 */
	public List<ActionField> getActionFields() {
		return actionFields;
	}

	/**
	 * @param actionFields
	 *            the actionFields to set
	 */
	public void setActionFields(List<ActionField> actionFields) {
		this.actionFields = actionFields;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return null;
	}
}