package org.iq.cache;

import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import org.apache.commons.collections4.CollectionUtils;
import org.iq.exception.CacheException;

public class CacheEvictorWorker implements Runnable {

	private final Lock lock;
	private final ExecutorService cacheCleanerService;
	private final CacheHelper cacheHelper;

	public CacheEvictorWorker() {
		lock = new ReentrantLock();
		cacheCleanerService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
		cacheHelper = new CacheHelper();
	}

	@Override
	public void run() {
		lock.lock();
		System.out.println("Executing Cache Evictor Worker.");
		
		try {
			Cache cache = Cache.getInstance();
			Set<Entry<String, CacheRegion>> regionEntrySet = cache.entrySet();

			if (CollectionUtils.isNotEmpty(regionEntrySet)) {
				System.out.println("Cache has got " + regionEntrySet.size() + " regions.");

				List<Future<Object>> workers = new ArrayList<>();
				
				for (Entry<String, CacheRegion> entry : regionEntrySet) {
					String regionName = entry.getKey();
					CacheRegion cacheRegion = entry.getValue();

					if (cacheRegion.evictionAllowed) {
						CacheCleaner cacheCleaner = new CacheCleaner(regionName, cacheRegion);
						Future<Object> worker = cacheCleanerService.submit(cacheCleaner);
						workers.add(worker);
					}
				}
				
				for(Future<Object> worker : workers) {
					try {
						worker.get();
					} catch (InterruptedException | ExecutionException cause) {
						cause.printStackTrace();
					}
				}
			}
		} finally {
			lock.unlock();
		}
		
		System.out.println("Cache Evictor Worker Executed.");
	}
	
	public void stopWork() {
		cacheCleanerService.shutdown();
		
		while(!cacheCleanerService.isTerminated()) {			
		}
	}

	private class CacheCleaner implements Callable<Object> {

		private String regionName;
		private CacheRegion cacheRegion;

		public CacheCleaner(String regionName, CacheRegion cacheRegion) {
			this.regionName = regionName;
			this.cacheRegion = cacheRegion;
		}

		@Override
		public Object call() {
			long currentTime = System.currentTimeMillis();

			for (Entry<String, CacheElement> entry : cacheRegion.entrySet()) {
				String key = entry.getKey();
				CacheElement cacheElement = entry.getValue();

				long lastAccessTime = cacheElement.getLastAccessTime().getTime();
				boolean cleaningNeeded = (currentTime - lastAccessTime) > TimeUnit.MINUTES.toMillis(5);

				if (cleaningNeeded) {
					cacheElement.setCleanable(true);

					try {
						cacheHelper.removeElement(regionName, key);
					} catch (CacheException cause) {
						cause.printStackTrace();
					}

					System.out.println("Evicted an element : Region = " + regionName + ", Key = " + key + ", Last Access = " + cacheElement.getLastAccessTime());
				}
			}
			
			return null;
		}
	}
}