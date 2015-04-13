package org.iq.cache;

import java.util.Set;

import org.iq.cache.regions.CacheRegion;
import org.iq.exception.CacheException;

/**
 * @author Sam
 * 
 */
public class CacheHelper {

	/**
	 * @param regionName
	 * @param description
	 * @param evictionAllowed
	 * @param userClearRegionAllowed
	 * @param userClearElementAllowed
	 * @param cleaningRequired
	 * @throws CacheException
	 */
	public void addRegion(String regionName, String description,
			boolean evictionAllowed, boolean userClearRegionAllowed,
			boolean userClearElementAllowed, boolean cleaningRequired)
			throws CacheException {
		CacheRegion cacheRegion = new CacheRegion(regionName, description,
				evictionAllowed, userClearRegionAllowed,
				userClearElementAllowed, cleaningRequired);
		addRegion(regionName, cacheRegion);
	}
	
	/**
	 * @param regionName
	 * @param description
	 * @throws CacheException
	 */
	public void addRegion(String regionName,
			String description) throws CacheException {
		CacheRegion cacheRegion = new CacheRegion(regionName, 
				description, false, false, false, false);
		addRegion(regionName, cacheRegion);
	}
	
	/**
	 * @param regionName
	 * @param cacheRegion
	 * @throws CacheException
	 */
	private void addRegion(String regionName, CacheRegion cacheRegion)
			throws CacheException {

		synchronized (Cache.class) {
			Cache cache = Cache.getInstance();
			cache.put(regionName, cacheRegion);
		}
	}

	/**
	 * @param regionName
	 * @return boolean
	 */
	public boolean isRegionExists(String regionName) {
		Cache cache = Cache.getInstance();
		return cache.containsKey(regionName);
	}

	/**
	 * @param regionName
	 * @param key
	 * @param value
	 * @throws CacheException
	 */
	public void addElement(String regionName, String key,
			Object value) throws CacheException {
		Cache cache = Cache.getInstance();
		CacheRegion cacheRegion = cache.get(regionName);
		if (cacheRegion == null) {
			/* throw new CacheException("Not a valid cacheHelper region"); */
			cacheRegion = new CacheRegion(regionName, "", false,
					false, false, false);
			cacheRegion.addElement(key, value);
			cache.put(regionName, cacheRegion);
		}
		cacheRegion.addElement(key, value);
	}

	/**
	 * @param regionName
	 * @param key
	 * @return
	 */
	public boolean isKeyExists(String regionName, String key) {
		Cache cache = Cache.getInstance();
		CacheRegion region = cache.get(regionName);
		if (region == null) {
			return false;
		} else {
			return region.isKeyExists(key);
		}
	}

	/**
	 * @param regionName
	 * @return
	 */
	public Set<String> getKeySet(String regionName) {
		Cache cache = Cache.getInstance();
		CacheRegion region = cache.get(regionName);
		return region.getKeySet();
	}

	/**
	 * fetches the Region associated with the regionName and finds the value
	 * from the Region which is associated with provided key If no Region found
	 * in CacheHelper against the regionName then <code>CacheException</code> will be
	 * thrown
	 * 
	 * @param regionName
	 *            name by which the CacheHelper Region is associated
	 * @param key
	 *            the value stored in the Region is associated with this key
	 * @return value fetched from the Region which is stored against provided
	 *         key
	 * @throws CacheException
	 */
	public Object getElement(String regionName, String key)
			throws CacheException {
		Cache cache = Cache.getInstance();
		CacheRegion cacheRegion = cache.get(regionName);
		if (cacheRegion == null) {
			throw new CacheException("Not a valid cacheHelper region");
		}
		Object value = cacheRegion.getElement(key);
		return value;
	}

	/**
	 * @return Set
	 * @throws CacheException
	 */
	public Set<String> getAllUserRegionNames() throws CacheException {
		Cache cache = Cache.getInstance();
		return cache.keySet();
	}

	/**
	 * 
	 * @param regionKey
	 * @return CacheRegion
	 * @throws CacheException
	 */
	public CacheRegion getUserRegion(String regionKey) throws CacheException {
		Cache cache = Cache.getInstance();
		CacheRegion cacheRegion = cache.get(regionKey);
		if (cacheRegion == null) {
			System.out
					.println("No region found with Region Name::" + regionKey);
			throw new CacheException("No region found with Region Name::"
					+ regionKey);
		}
		return cacheRegion;
	}

	/**
	 * regionKey is a combination of region type and regionName separated by a '~'
	 * @param regionKey
	 * @param key
	 * @throws CacheException
	 */
	public void removeElement(String regionKey, Object key)
			throws CacheException {
		Cache cache = Cache.getInstance();
		CacheRegion cacheRegion = cache.get(regionKey);
		if (cacheRegion == null) {
			throw new CacheException("Not a valid cacheHelper region.");
		}
		cacheRegion.deleteElement(key);
	}

	
	/**
	 * @param regionName
	 * @throws CacheException
	 */
	public void removeAllElement(String regionName)
			throws CacheException {
		Cache cache = Cache.getInstance();
		CacheRegion cacheRegion = cache.get(regionName);
		if (cacheRegion == null) {
			throw new CacheException("Not a valid cacheHelper region.");
		}
		cacheRegion.deleteAllElement();
	}
	
	/**
	 * @param regionName
	 * @param evictionAllowed
	 * @throws CacheException
	 */
	public void setEvictionAllowed(String regionName,
			boolean evictionAllowed) throws CacheException {
		Cache cache = Cache.getInstance();
		CacheRegion cacheRegion = cache.get(regionName);
		if (cacheRegion == null) {
			throw new CacheException("Not a valid cacheHelper region.");
		} else {
			cacheRegion.setEvictionAllowed(evictionAllowed);
		}
	}
	
	/**
	 * @param regionName
	 * @param userClearRegionAllowed
	 * @throws CacheException
	 */
	public void setUserClearRegionAllowed(String regionName,
			boolean userClearRegionAllowed) throws CacheException {
		Cache cache = Cache.getInstance();
		CacheRegion cacheRegion = cache.get(regionName);
		if (cacheRegion == null) {
			throw new CacheException("Not a valid cacheHelper region.");
		} else {
			cacheRegion.setUserClearRegionAllowed(userClearRegionAllowed);
		}
	}
	
	/**
	 * @param regionName
	 * @param userClearElementAllowed
	 * @throws CacheException
	 */
	public void setUserClearElementAllowed(String regionName,
			boolean userClearElementAllowed) throws CacheException {
		Cache cache = Cache.getInstance();
		CacheRegion cacheRegion = cache.get(regionName);
		if (cacheRegion == null) {
			throw new CacheException("Not a valid cacheHelper region.");
		} else {
			cacheRegion.setUserClearElementAllowed(userClearElementAllowed);
		}
	}
	
	/**
	 * @param regionName
	 * @param cleaningRequired
	 * @throws CacheException
	 */
	public void setCleaningRequired(String regionName,
			boolean cleaningRequired) throws CacheException {
		Cache cache = Cache.getInstance();
		CacheRegion cacheRegion = cache.get(regionName);
		if (cacheRegion == null) {
			throw new CacheException("Not a valid cacheHelper region.");
		} else {
			cacheRegion.setCleaningRequired(cleaningRequired);
		}
	}
}
