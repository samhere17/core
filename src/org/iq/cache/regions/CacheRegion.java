package org.iq.cache.regions;

import java.util.Date;

public class CacheRegion extends Region {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7936994247951131886L;
	protected boolean evictionAllowed;
	protected boolean userClearRegionAllowed;
	protected boolean userClearElementAllowed;
	protected boolean cleaningRequired;
	protected Date lastAccessTime = new Date();
	protected int evictionInterval = 0;


	/**
	 * @param regionName
	 * @param description
	 * @param evictionAllowed
	 * @param userClearRegionAllowed
	 * @param userClearElementAllowed
	 * @param cleaningRequired
	 */
	public CacheRegion(String regionName,
			String description, boolean evictionAllowed,
			boolean userClearRegionAllowed, boolean userClearElementAllowed,
			boolean cleaningRequired) {
		super(regionName, description);
		this.evictionAllowed = evictionAllowed;
		this.userClearRegionAllowed = userClearRegionAllowed;
		this.userClearElementAllowed = userClearElementAllowed;
		this.cleaningRequired = cleaningRequired;
	}

	/**
	 * @param evictionAllowed
	 */
	public void setEvictionAllowed(boolean evictionAllowed) {
		this.evictionAllowed = evictionAllowed;
	}

	/**
	 * @param userClearRegionAllowed
	 */
	public void setUserClearRegionAllowed(boolean userClearRegionAllowed) {
		this.userClearRegionAllowed = userClearRegionAllowed;
	}

	/**
	 * @param userClearElementAllowed
	 */
	public void setUserClearElementAllowed(boolean userClearElementAllowed) {
		this.userClearElementAllowed = userClearElementAllowed;
	}

	/**
	 * @param key
	 */
	public synchronized void deleteElement(Object key) {
		if (evictionAllowed) {
			regionCache.remove(key);
		}
	}

	/**
	 * 
	 */
	public synchronized void deleteAllElement() {
		if (evictionAllowed) {
			regionCache.clear();
		}
	}


	/**
	 * 
	 */
	public synchronized void clean() {
		if (evictionAllowed) {
			regionCache.clear();
		}
	}

	/**
	 * @return the toBeDeleted
	 */
	public boolean isEvictionAllowed() {
		return evictionAllowed;
	}

	/**
	 * @return the userClearAllowed
	 */
	public boolean isUserClearRegionAllowed() {
		return userClearRegionAllowed;
	}

	/**
	 * @return the userClearAllowed
	 */
	public boolean isUserClearElementAllowed() {
		return userClearElementAllowed;
	}

	/**
	 * @return the cleaningRequired
	 */
	public boolean isCleaningRequired() {
		return cleaningRequired;
	}

	/**
	 * @param cleaningRequired
	 *          the cleaningRequired to set
	 */
	public void setCleaningRequired(boolean cleaningRequired) {
		this.cleaningRequired = cleaningRequired;
	}

	/**
	 * @return int
	 */
	public int getEvictionInterval() {
		return evictionInterval;
	}

	/**
	 * @param evictionInterval
	 */
	public void setEvictionInterval(int evictionInterval) {
		this.evictionInterval = evictionInterval;
	}

}
