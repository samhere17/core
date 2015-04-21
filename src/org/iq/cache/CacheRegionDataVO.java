package org.iq.cache;

import org.iq.valueobject.BaseVO;

public class CacheRegionDataVO extends BaseVO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8129478577613237018L;

	/**
	 * 
	 */
	private String key = null;
	
	/**
	 * 
	 */
	private String value = null;
	
	/**
	 * @return
	 */
	public String getKey() {
		return key;
	}

	/**
	 * @param key
	 */
	public void setKey(String key) {
		this.key = key;
	}

	/**
	 * @return
	 */
	public String getValue() {
		return value;
	}

	/**
	 * @param value
	 */
	public void setValue(String value) {
		this.value = value;
	}



	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return null;
	}
}
