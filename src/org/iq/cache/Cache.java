package org.iq.cache;

import java.util.concurrent.ConcurrentHashMap;

public class Cache extends ConcurrentHashMap<String, CacheRegion> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 52671797556234937L;
	
	private static Cache cache = null;

	public static Cache getInstance() {
		if (cache == null) {
			cache = new Cache();
		}
		return cache;
	}
}