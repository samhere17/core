package org.iq;

import java.io.Serializable;

public class BasicSearchInput implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -519123684723396097L;

	private String id = null;
	private String name = null;
	private String alias = null;
	private String primaryPhone = null;
	private String primaryFax = null;
	private String primaryEmail = null;

	
	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
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
	 * @return the alias
	 */
	public String getAlias() {
		return alias;
	}

	/**
	 * @param alias
	 *            the alias to set
	 */
	public void setAlias(String alias) {
		this.alias = alias;
	}

	/**
	 * @return the primaryPhone
	 */
	public String getPrimaryPhone() {
		return primaryPhone;
	}

	/**
	 * @param primaryPhone
	 *            the primaryPhone to set
	 */
	public void setPrimaryPhone(String primaryPhone) {
		this.primaryPhone = primaryPhone;
	}

	/**
	 * @return the primaryFax
	 */
	public String getPrimaryFax() {
		return primaryFax;
	}

	/**
	 * @param primaryFax
	 *            the primaryFax to set
	 */
	public void setPrimaryFax(String primaryFax) {
		this.primaryFax = primaryFax;
	}

	/**
	 * @return the primaryEmail
	 */
	public String getPrimaryEmail() {
		return primaryEmail;
	}

	/**
	 * @param primaryEmail
	 *            the primaryEmail to set
	 */
	public void setPrimaryEmail(String primaryEmail) {
		this.primaryEmail = primaryEmail;
	}
}