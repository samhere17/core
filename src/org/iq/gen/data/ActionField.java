package org.iq.gen.data;

public class ActionField extends Field {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5576368772477696185L;

	private String actionMethod;
	private String targetUrl;
	private String encryptionType;

	/**
	 * @return the actionMethod
	 */
	public String getActionMethod() {
		return actionMethod;
	}

	/**
	 * @param actionMethod
	 *            the actionMethod to set
	 */
	public void setActionMethod(String actionMethod) {
		this.actionMethod = actionMethod;
	}

	/**
	 * @return the targetUrl
	 */
	public String getTargetUrl() {
		return targetUrl;
	}

	/**
	 * @param targetUrl
	 *            the targetUrl to set
	 */
	public void setTargetUrl(String targetUrl) {
		this.targetUrl = targetUrl;
	}

	/**
	 * @return the encryptionType
	 */
	public String getEncryptionType() {
		return encryptionType;
	}

	/**
	 * @param encryptionType
	 *            the encryptionType to set
	 */
	public void setEncryptionType(String encryptionType) {
		this.encryptionType = encryptionType;
	}
}