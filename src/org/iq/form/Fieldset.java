package org.iq.form;

import java.util.List;

import org.iq.valueobject.BaseVO;

public class Fieldset extends BaseVO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7777016435316692277L;

	private int id = 0;
	private String legend;
	private List<DataField> dataFields;
	private List<Fieldset> childFieldset;

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
	 * @return the legend
	 */
	public String getLegend() {
		return legend;
	}

	/**
	 * @param legend
	 *            the legend to set
	 */
	public void setLegend(String legend) {
		this.legend = legend;
	}

	/**
	 * @return the dataFields
	 */
	public List<DataField> getFields() {
		return dataFields;
	}

	/**
	 * @param dataFields
	 *            the dataFields to set
	 */
	public void setFields(List<DataField> dataFields) {
		this.dataFields = dataFields;
	}

	/**
	 * @return the childFieldset
	 */
	public List<Fieldset> getChildFieldset() {
		return childFieldset;
	}

	/**
	 * @param childFieldset
	 *            the childFieldset to set
	 */
	public void setChildFieldset(List<Fieldset> childFieldset) {
		this.childFieldset = childFieldset;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return null;
	}
}