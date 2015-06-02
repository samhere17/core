package org.iq.cache;

import java.io.Serializable;
import java.util.Date;

/**
 * @author Sam
 * 
 */
public class CacheElement implements Cloneable, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2341735123648098135L;
	
	private Date creationTime = new Date();
	private Date lastAccessTime = new Date();
	private Object value = null;
	private Boolean cleanable = false;
	
	public CacheElement() {
		
	}

	public CacheElement(Object value) {
		this.value = value;
	}

	/**
	 * @return the lastAccessTime
	 */
	public Date getLastAccessTime() {
		return lastAccessTime;
	}

	/**
	 * @param lastAccessTime
	 *            the lastAccessTime to set
	 */
	public void setLastAccessTime(Date lastAccessTime) {
		this.lastAccessTime = lastAccessTime;
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
	 * @return the cleanable
	 */
	public Boolean isCleanable() {
		return cleanable;
	}

	/**
	 * @param cleanable
	 *            the cleanable to set
	 */
	public void setCleanable(Boolean cleanable) {
		this.cleanable = cleanable;
	}

	/**
	 * @return the creationTime
	 */
	public Date getCreationTime() {
		return creationTime;
	}
}