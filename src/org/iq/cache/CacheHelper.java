package org.iq.cache;

import java.util.Set;

import org.iq.exception.CacheException;

/**
 * @author Sam
 * 
 */
public class CacheHelper {

	/*
	 * REGION RELATED CODE
	 */

	/**
	 * @param cacheRegion
	 * @throws CacheException
	 */
	public void addRegion(CacheRegion cacheRegion) throws CacheException {
		if (cacheRegion == null) {
			throw new CacheException("Cache Region is null");
		}
		if (cacheRegion.getRegionName() == null) {
			throw new CacheException("Region Name is null");
		}

		synchronized (Cache.class) {
			Cache cache = Cache.getInstance();
			cache.put(cacheRegion.getRegionName(), cacheRegion);
		}
	}

	/**
	 * @param regionName
	 * @throws CacheException
	 */
	public void addRegion(String regionName) throws CacheException {
		CacheRegion cacheRegion = new CacheRegion(regionName);
		addRegion(cacheRegion);
	}

	/**
	 * @param regionName
	 * @param description
	 * @throws CacheException
	 */
	public void addRegion(String regionName, String description)
			throws CacheException {
		CacheRegion cacheRegion = new CacheRegion(regionName, description);
		addRegion(cacheRegion);
	}

	/**
	 * @param regionName
	 * @param description
	 * @param evictionAllowed
	 * @throws CacheException
	 */
	public void addRegion(String regionName, String description,
			boolean evictionAllowed) throws CacheException {
		CacheRegion cacheRegion = new CacheRegion(regionName, description,
				evictionAllowed);
		addRegion(cacheRegion);
	}

	/**
	 * @param regionName
	 * @param description
	 * @param evictionAllowed
	 * @param userClearRegionAllowed
	 * @param userClearElementAllowed
	 * @throws CacheException
	 */
	public void addRegion(String regionName, String description,
			boolean evictionAllowed, boolean userClearRegionAllowed,
			boolean userClearElementAllowed) throws CacheException {
		CacheRegion cacheRegion = new CacheRegion(regionName, description,
				evictionAllowed, userClearRegionAllowed,
				userClearElementAllowed);
		addRegion(cacheRegion);
	}

	/**
	 * @param regionName
	 * @return boolean
	 * @throws CacheException
	 */
	public boolean isRegionExists(String regionName) throws CacheException {
		if (regionName == null) {
			throw new CacheException("Region Name is null");
		}

		Cache cache = Cache.getInstance();
		return cache.containsKey(regionName);
	}

	/**
	 * @return Set<String>
	 */
	public Set<String> getRegionKeySet() {
		Cache cache = Cache.getInstance();
		return cache.keySet();
	}

	/**
	 * @param regionName
	 * @return CacheRegion
	 * @throws CacheException
	 */
	private CacheRegion getRegion(String regionName) throws CacheException {
		if (regionName == null) {
			throw new CacheException("Region Name is null");
		}

		Cache cache = Cache.getInstance();
		CacheRegion cacheRegion = cache.get(regionName);
		if (cacheRegion == null) {
			throw new CacheException("Region: " + regionName + " not found.");
		}
		return cacheRegion;
	}

	public boolean isEvictionAllowed(String regionName) throws CacheException {
		CacheRegion cacheRegion = getRegion(regionName);
		return cacheRegion.evictionAllowed;
	}
	
	
	/*
	 * ELEMENT RELATED CODE
	 */

	/**
	 * @param regionName
	 * @param key
	 * @param value
	 * @throws CacheException
	 */
	public void addElement(String regionName, String key, Object value)
			throws CacheException {
		CacheRegion cacheRegion = getRegion(regionName);
		cacheRegion.putData(key, value);
	}

	/**
	 * @param regionName
	 * @param key
	 * @return boolean
	 * @throws CacheException
	 */
	public boolean isKeyExists(String regionName, String key)
			throws CacheException {
		CacheRegion cacheRegion = getRegion(regionName);
		if (key == null) {
			throw new CacheException("Key is null");
		}
		return cacheRegion.containsKey(key);
	}

	/**
	 * @param regionName
	 * @return Set<String>
	 * @throws CacheException
	 */
	public Set<String> getKeySet(String regionName) throws CacheException {
		CacheRegion cacheRegion = getRegion(regionName);
		return cacheRegion.keySet();
	}

	/**
	 * fetches the Region associated with the regionName and finds the value
	 * from the Region which is associated with provided key If no Region found
	 * in cache against the regionName then <code>CacheException</code> will be
	 * thrown
	 * 
	 * @param regionName
	 *            name by which the cache Region is associated
	 * @param key
	 *            the value stored in the Region is associated with this key
	 * @return value fetched from the Region which is stored against provided
	 *         key
	 * @throws CacheException
	 */
	public Object getElement(String regionName, String key)
			throws CacheException {
		CacheRegion cacheRegion = getRegion(regionName);
		return cacheRegion.getData(key);
	}

	/**
	 * 
	 * @param regionName
	 * @param key
	 * @throws CacheException
	 */
	public void removeElement(String regionName, String key)
			throws CacheException {
		CacheRegion cacheRegion = getRegion(regionName);
		cacheRegion.remove(key);
	}

	/**
	 * @param regionName
	 * @throws CacheException
	 */
	public void removeAllElement(String regionName) throws CacheException {
		CacheRegion cacheRegion = getRegion(regionName);
		cacheRegion.clear();
	}

	/**
	 * @param regionName
	 * @throws CacheException
	 */
	/*public void setCleaningRequired(String regionName) throws CacheException {
		CacheRegion cacheRegion = getRegion(regionName);
		cacheRegion.setCleaningRequired(true);
	}*/
}