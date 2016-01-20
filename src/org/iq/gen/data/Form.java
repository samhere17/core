package org.iq.gen.data;

import java.util.List;

import org.iq.gen.constants.Method;

public class Form extends BaseData {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4830954819661388514L;
	
	/**
	 * This will convert to the jsp filename
	 */
	private String name;
	
	/**
	 * 
	 */
	private String description;
	
	/**
	 * 
	 */
	private Method method;

	private String action;
	
	/**
	 * The enctype for the form
	 * example: multipart/form-data
	 */
	private String enctype;

	private List<Section> sections;
	private List<ActionField> actionFields;

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	/**
	 * @return the method
	 */
	public Method getMethod() {
		return method;
	}
	/**
	 * @param method the method to set
	 */
	public void setMethod(Method method) {
		this.method = method;
	}
	/**
	 * @return the action
	 */
	public String getAction() {
		return action;
	}
	/**
	 * @param action the action to set
	 */
	public void setAction(String action) {
		this.action = action;
	}
	/**
	 * @return the enctype
	 */
	public String getEnctype() {
		return enctype;
	}
	/**
	 * @param enctype the enctype to set
	 */
	public void setEnctype(String enctype) {
		this.enctype = enctype;
	}
	/**
	 * @return the sections
	 */
	public List<Section> getSections() {
		return sections;
	}
	/**
	 * @param sections the sections to set
	 */
	public void setSections(List<Section> sections) {
		this.sections = sections;
	}
	/**
	 * @return the actionFields
	 */
	public List<ActionField> getActionFields() {
		return actionFields;
	}
	/**
	 * @param actionFields the actionFields to set
	 */
	public void setActionFields(List<ActionField> actionFields) {
		this.actionFields = actionFields;
	}
}