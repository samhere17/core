/**
 * 
 */
package org.iq.action;

import java.io.Serializable;
import java.util.UUID;

/**
 * @author Sam
 *
 */
public abstract class BaseAction implements Serializable, Cloneable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5936157222059047864L;

	private final String id = UUID.randomUUID().toString();
	private String name;
	private boolean sessionRequired = true;

	/**
	 * @return the id
	 */
	public final String getId() {
		return id;
	}

	/**
	 * @return the name
	 */
	public final String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	protected final void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the sessionRequired
	 */
	public final boolean isSessionRequired() {
		return sessionRequired;
	}

	/**
	 * The sessionRequired to set to false
	 */
	protected final void setSessionNotRequired() {
		sessionRequired = false;
	}
}