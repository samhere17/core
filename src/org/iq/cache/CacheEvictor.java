package org.iq.cache;

import java.util.Iterator;
import java.util.Set;

import org.iq.exception.CacheException;

/**
 * @author Sam
 * 
 */
public class CacheEvictor implements Runnable {

	private static final int DEFAULT_INTERVAL = 5;
	private static final int MINUTE_TO_MILLIS = 1000 * 60;

	private static CacheEvictor evictorInstance;
	private Thread runner;
	private boolean flag;

	/**
	 * 
	 */
	private CacheEvictor() {
		runner = new Thread(this, "Cache Evictor Thread");
		runner.setDaemon(true);
	}

	/**
	 * @return CacheEvictor
	 */
	public static CacheEvictor getEvictorInstance() {
		if (evictorInstance == null) {
			evictorInstance = new CacheEvictor();
		}
		return evictorInstance;
	}

	/**
	 * 
	 */
	public void startCacheEvictor() {
		flag = true;
		runner.start();
	}

	/**
	 * 
	 */
	public void stopCacheEvictor() {
		flag = false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Runnable#run()
	 */
	public void run() {

		// setting default interval value.
		int intervalMin = DEFAULT_INTERVAL;

		while (flag == true) {
			try {
				System.out.println("[" + runner.getName() + "] "
						+ "Sleeping for " + intervalMin + " minutes...");
				Thread.sleep(intervalMin * MINUTE_TO_MILLIS);
				System.out.println("[" + runner.getName() + "] " + "Sleep for "
						+ intervalMin + " minutes over.");
			} catch (InterruptedException e) {
				System.err.println(e.getMessage());
			}

			Cache cache = Cache.getInstance();
			Set<String> regionNamesSet = cache.keySet();

			System.out.println("Cache has got " + regionNamesSet.size()
					+ " regions.");

			Iterator<String> regionNamesIterator = regionNamesSet.iterator();
			while (regionNamesIterator.hasNext()) {
				String regionName = regionNamesIterator.next();
				CacheRegion cacheRegion = cache.get(regionName);
				if (cacheRegion.evictionAllowed) {
					EvictionMarker evictionMarker = new EvictionMarker(
							regionName);
					evictionMarker.start();
				}
			}
		}
	}

	/**
	 * @author Sam
	 * 
	 */
	private class EvictionMarker extends Thread {

		private String regionName;

		/**
		 * @param cacheRegion
		 */
		private EvictionMarker(String regionName) {
			this.regionName = regionName;
			this.setName(regionName + " Eviction Marker Thread");
			this.setDaemon(true);
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see java.lang.Thread#run()
		 */
		public void run() {

			int intervalMin = DEFAULT_INTERVAL;
			int markedCount = 0;

			Cache cache = Cache.getInstance();
			CacheRegion cacheRegion = cache.get(regionName);
			Set<String> elementKeysSet = cacheRegion.keySet();
			Iterator<String> elementKeysIterator = elementKeysSet.iterator();
			while (elementKeysIterator.hasNext()) {
				String currKey = elementKeysIterator.next();
				CacheElement cacheElement = cacheRegion.get(currKey);

				long lastAccessTime = cacheElement.getLastAccessTime()
						.getTime();
				long presentTime = System.currentTimeMillis();

				if ((presentTime - lastAccessTime) > intervalMin
						* MINUTE_TO_MILLIS) {
					cacheElement.setCleanable(true);
					markedCount++;
				}
			}

			if (markedCount > 0) {
				System.out.println("Marked " + markedCount + " elements in "
						+ regionName + " region.");
				startCleanerThread(regionName);
			}
		}
	}

	/**
	 * @author Sam
	 * 
	 */
	private class CleanerThread extends Thread {

		private String regionName;

		/**
		 * 
		 */
		public CleanerThread(String regionName) {
			this.regionName = regionName;
			this.setName(regionName + " Cleaner Thread");
			this.setDaemon(true);
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see java.lang.Thread#run()
		 */
		@Override
		public void run() {
			Cache cache = Cache.getInstance();
			CacheRegion cacheRegion = cache.get(regionName);
			Set<String> elementKeysSet = cacheRegion.keySet();
			Iterator<String> elementKeysIterator = elementKeysSet.iterator();
			while (elementKeysIterator.hasNext()) {
				String currKey = elementKeysIterator.next();
				CacheElement cacheElement = cacheRegion.get(currKey);
				if (cacheElement.isCleanable()) {
					CacheHelper cacheHelper = new CacheHelper();
					try {
						cacheHelper.removeElement(regionName, currKey);
					} catch (CacheException e) {
						System.err.println(e.getMessage());
					}
					System.out.println("Evicted an element : Region = "
							+ regionName + ", Key = " + currKey
							+ ", Last Access = "
							+ cacheElement.getLastAccessTime());
				}
			}
		}
	}

	/**
	 * 
	 */
	private void startCleanerThread(String regionName) {
		CleanerThread cleanerThread = new CleanerThread(regionName);
		cleanerThread.start();
	}
}