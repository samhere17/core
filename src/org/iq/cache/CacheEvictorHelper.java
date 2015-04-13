/**
 * Copyright (c) 2009, Amdocs. -- All Rights Reserved
 * 
 */

package org.iq.cache;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.iq.cache.regions.CacheRegion;


/**
 * @author Sam
 * 
 */
public class CacheEvictorHelper {

	private static final int DEFAULT_INTERVAL = 5;
	private static final int MINUTE_TO_MILLIS = 60 * 1000;
	private Logger logger = Logger
			.getLogger(CacheEvictorHelper.class.getName());

	/**
	 * @param cacheElement
	 * @param regionName
	 * @return boolean
	 */
	public boolean markElement(CacheElement cacheElement, String regionName) {
		boolean cleanable = false;
		long lastAccessTime = cacheElement.getLastAccessTime().getTime();
		long presentTime = System.currentTimeMillis();

		int intervalMin = DEFAULT_INTERVAL;
		try {
			intervalMin = getCacheEvictionInterval(regionName);
		} catch (NumberFormatException e) {
			logger.log(Level.SEVERE, e.getMessage(), e);
		}

		if ((presentTime - lastAccessTime) > intervalMin * MINUTE_TO_MILLIS) {
			cleanable = true;
			logger.log(Level.INFO, "Marked CacheHelper Element in region : "
					+ regionName);
		}
		return cleanable;
	}

	
	/**
	 * @param regionName
	 * @return int
	 */
	private int getCacheEvictionInterval(String regionName) {
		int interval = 0;
		Cache cache = Cache.getInstance();
		if (cache != null && cache.containsKey(regionName)) {
			CacheRegion cacheRegion = (CacheRegion) cache.get(regionName);
			interval = cacheRegion.getEvictionInterval();
		}
		return interval;
	}
}