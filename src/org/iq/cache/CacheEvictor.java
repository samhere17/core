package org.iq.cache;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @author Sam
 * @author Tapas
 * 
 */
public enum CacheEvictor {
	INSTANCE;

	private final ScheduledExecutorService cacheEvictorService;
	private final CacheEvictorWorker cacheEvictorWorker;
	
	private CacheEvictor() {
		cacheEvictorService = Executors.newSingleThreadScheduledExecutor();
		cacheEvictorWorker = new CacheEvictorWorker();
	}

	public static CacheEvictor getEvictorInstance() {
		return CacheEvictor.INSTANCE;
	}

	public void startCacheEvictor() {		
		cacheEvictorService.scheduleAtFixedRate(cacheEvictorWorker, 5, 5, TimeUnit.MINUTES);
	}

	public void stopCacheEvictor() {		
		cacheEvictorWorker.stopWork();
		cacheEvictorService.shutdown();

		while (!cacheEvictorService.isTerminated()) {}
	}
}