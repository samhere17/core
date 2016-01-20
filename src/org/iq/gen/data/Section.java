package org.iq.gen.data;

import java.util.List;

public class Section extends BaseData {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7777016435316692277L;

	/**
	 * This is the title for the section
	 */
	private String title;

	/**
	 * 
	 */
	private String description;
	
	private List<Field> fields;
	
	private List<Section> childSections;

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
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
	 * @return the fields
	 */
	public List<Field> getFields() {
		return fields;
	}

	/**
	 * @param fields the fields to set
	 */
	public void setFields(List<Field> fields) {
		this.fields = fields;
	}

	/**
	 * @return the childSections
	 */
	public List<Section> getChildSections() {
		return childSections;
	}

	/**
	 * @param childSections the childSections to set
	 */
	public void setChildSections(List<Section> childSections) {
		this.childSections = childSections;
	}

	
}