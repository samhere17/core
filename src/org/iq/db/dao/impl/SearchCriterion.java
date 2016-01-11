package org.iq.db.dao.impl;

import org.iq.valueobject.BaseVO;

final public class SearchCriterion extends BaseVO {

	/**
	 * 
	 */
	private static final long serialVersionUID = -519123684723396097L;

	private String coloumnName = null;
	private Object value = null;
	private SearchType searchType = SearchType.CONTAINS;
	
	public SearchCriterion(String coloumnName, Object value, SearchType searchType) {
		this.coloumnName = coloumnName;
		this.value = value;
		this.searchType = searchType;
	}

	/**
	 * @return the coloumnName
	 */
	public String getColoumnName() {
		return coloumnName;
	}

	/**
	 * @param coloumnName
	 *            the coloumnName to set
	 */
	public void setColoumnName(String coloumnName) {
		this.coloumnName = coloumnName;
	}

	/**
	 * @return the value
	 */
	public Object getValue() {
		return value;
	}

	/**
	 * @param value
	 *            the value to set
	 */
	public void setValue(Object value) {
		this.value = value;
	}

	/**
	 * @return the searchType
	 */
	public SearchType getSearchType() {
		return searchType;
	}

	/**
	 * @param searchType
	 *            the searchType to set
	 */
	public void setSearchType(SearchType searchType) {
		this.searchType = searchType;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return null;
	}
}