package org.iq.startup.actions;

import org.iq.cache.CacheEvictor;
import org.iq.exception.CoreException;

/**
 * @author Sam
 */
public class CacheStartupAction extends StartupAction {

	private CacheEvictor cacheEvictor = null;
	
	@Override
	public void init() throws CoreException {
		System.out.println("STARTING CACHE...");

		cacheEvictor = CacheEvictor.getEvictorInstance();
		cacheEvictor.startCacheEvictor();
		
		System.out.println("CACHE STARTED SUCCESSFULLY");
	}

	@Override
	public void destroy() {
		System.out.println("STOPING CACHE...");

		cacheEvictor.stopCacheEvictor();
		
		System.out.println("CACHE STOPPED SUCCESSFULLY");
	}
}