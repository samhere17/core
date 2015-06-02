package org.iq.cache;

import java.util.Date;
import java.util.concurrent.ConcurrentHashMap;

import org.iq.exception.CacheException;

public class CacheRegion extends ConcurrentHashMap<String, CacheElement> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7936994247951131886L;
	
	protected String regionName;
	protected String description;
	protected boolean evictionAllowed;
	protected boolean userClearRegionAllowed;
	protected boolean userClearElementAllowed;
//	protected boolean cleaningRequired;
	protected Date creationTime = new Date();
	protected Date lastAccessTime = new Date();
	protected int evictionInterval = 0;
	
	/**
	 * @param regionName
	 */
	public CacheRegion(String regionName) {
		this(regionName, null, false, false, false);
	}

	/**
	 * @param regionName
	 * @param description
	 */
	public CacheRegion(String regionName, String description) {
		this(regionName, description, false, false, false);
	}

	/**
	 * @param regionName
	 * @param description
	 * @param evictionAllowed
	 */
	public CacheRegion(String regionName, String description,
			boolean evictionAllowed) {
		this(regionName, description, evictionAllowed, false, false);
	}

	/**
	 * @param regionName
	 * @param description
	 * @param evictionAllowed
	 * @param userClearRegionAllowed
	 * @param userClearElementAllowed
	 */
	public CacheRegion(String regionName, String description,
			boolean evictionAllowed, boolean userClearRegionAllowed,
			boolean userClearElementAllowed) {
		this.regionName = regionName;
		this.description = description;
		this.evictionAllowed = evictionAllowed;
		this.userClearRegionAllowed = userClearRegionAllowed;
		this.userClearElementAllowed = userClearElementAllowed;
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
	 * @return the evictionAllowed
	 */
	public boolean isEvictionAllowed() {
		return evictionAllowed;
	}

	/**
	 * @param evictionAllowed the evictionAllowed to set
	 */
	public void setEvictionAllowed(boolean evictionAllowed) {
		this.evictionAllowed = evictionAllowed;
	}

	/**
	 * @return the userClearRegionAllowed
	 */
	public boolean isUserClearRegionAllowed() {
		return userClearRegionAllowed;
	}

	/**
	 * @param userClearRegionAllowed the userClearRegionAllowed to set
	 */
	public void setUserClearRegionAllowed(boolean userClearRegionAllowed) {
		this.userClearRegionAllowed = userClearRegionAllowed;
	}

	/**
	 * @return the userClearElementAllowed
	 */
	public boolean isUserClearElementAllowed() {
		return userClearElementAllowed;
	}

	/**
	 * @param userClearElementAllowed the userClearElementAllowed to set
	 */
	public void setUserClearElementAllowed(boolean userClearElementAllowed) {
		this.userClearElementAllowed = userClearElementAllowed;
	}

	/**
	 * @return the cleaningRequired
	 */
	/*public boolean isCleaningRequired() {
		return cleaningRequired;
	}*/

	/**
	 * @param cleaningRequired the cleaningRequired to set
	 */
	/*public void setCleaningRequired(boolean cleaningRequired) {
		this.cleaningRequired = cleaningRequired;
	}*/

	/**
	 * @return the lastAccessTime
	 */
	public Date getLastAccessTime() {
		return lastAccessTime;
	}

	/**
	 * @param lastAccessTime the lastAccessTime to set
	 */
	public void setLastAccessTime(Date lastAccessTime) {
		this.lastAccessTime = lastAccessTime;
	}

	/**
	 * @return the evictionInterval
	 */
	public int getEvictionInterval() {
		return evictionInterval;
	}

	/**
	 * @param evictionInterval the evictionInterval to set
	 */
	public void setEvictionInterval(int evictionInterval) {
		this.evictionInterval = evictionInterval;
	}

	/**
	 * @return the creationTime
	 */
	public Date getCreationTime() {
		return creationTime;
	}
	
	@Override
	public void clear() {
		if (evictionAllowed) {
			super.clear();
		}
	}
	
	public Object getData(String elementKey) throws CacheException {
		Object value = null;
		if (elementKey == null) {
			throw new CacheException("Key is null");
		} else {
			CacheElement cacheElement = get(elementKey);
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
	 * @param key
	 * @param value
	 * @throws CacheException
	 */
	public void putData(String key, Object value) throws CacheException {
		if (key == null) {
			throw new CacheException("Key is null");
		} else if (value == null) {
			throw new CacheException("Value is null");
		} else {
			CacheElement cacheElement = new CacheElement(value);
			put(key, cacheElement);
		}
	}
	
	@Override
	public CacheElement remove(Object key) {
		if (evictionAllowed) {
			return super.remove(key);
		}
		return null;
	}
}