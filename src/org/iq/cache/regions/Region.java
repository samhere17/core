package org.iq.cache.regions;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Set;

import org.iq.cache.CacheElement;
import org.iq.exception.CacheException;

public abstract class Region implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1564521261284602413L;
	protected String regionName;
	protected HashMap<String, CacheElement> regionCache;
	protected String description;

	/**
	 * 
	 */
	protected Region() {
	}

	/**
	 * @param regionName
	 * @param description
	 */
	public Region(String regionName, String description) {
		this.regionName = regionName;
		this.regionCache = new HashMap<String, CacheElement>();
		this.description = description;
	}

	/**
	 * 
	 * @param key
	 * @param value
	 * @throws CacheException
	 */
	public synchronized void addElement(String key, Object value)
			throws CacheException {
		CacheElement cacheElement = new CacheElement();
		cacheElement.setValue(value);
		regionCache.put(key, cacheElement);
	}

	/**
	 * @param key
	 * @return Object
	 * @throws CacheException
	 */
	public Object getElement(String key) throws CacheException {
		Object value = null;
		if (key == null) {
			throw new CacheException("Key is null");
		}
		else {
			CacheElement cacheElement = regionCache.get(key);
			if (cacheElement != null) {
				if (cacheElement.isCleanable()) {
					cacheElement.setCleanable(false);
				}
				cacheElement.setLastAccessTime(new Date());
				value = cacheElement.getValue();
			}
		}
		return value;
	}

	/**
	 * @return Set
	 */
	public final Set<String> getKeySet() {
		return regionCache.keySet();
	}

	/**
	 * @param key
	 * @return boolean
	 */
	public boolean isKeyExists(String key) {
		return regionCache.containsKey(key);
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
	 * @return the regionName
	 */
	public String getRegionName() {
		return regionName;
	}

	/**
	 * @param regionName the regionName to set
	 */
	public void setRegionName(String regionName) {
		this.regionName = regionName;
	}

	/**
	 * @return HashMap
	 */
	public HashMap<String, CacheElement> getRegionCache() {
		return regionCache;
	}
}