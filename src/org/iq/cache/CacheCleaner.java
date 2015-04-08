package org.iq.cache;

import java.util.HashMap;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.iq.cache.regions.UserRegion;
import org.iq.exception.CacheException;


/**
 * @author Sam
 * 
 */
public class CacheCleaner implements Runnable {
  private static final int DEFAULT_INTERVAL = 5;
  private static final int SECOND_TO_MILLIS = 1000;

  private static CacheCleaner cacheCleanerInstance;
  private Thread runner;
  private boolean runnerFlag;

  private Logger logger = Logger.getLogger(CacheCleaner.class.getName());

  /**
   * 
   */
  private CacheCleaner() {
    runner = new Thread(this, "Cache Cleaner Thread");
    runnerFlag = true;
//    logProcessor = new LogProcessor();
//    logProcessor.setClassInstance(this.getClass());
    runner.start();
  }

  public static CacheCleaner getCacheCleanerInstance() {
    if (cacheCleanerInstance == null) {
      cacheCleanerInstance = new CacheCleaner();
    }
    return cacheCleanerInstance;
  }

  /*
   * (non-Javadoc)
   * 
   * @see java.lang.Runnable#run()
   */
  public void run() {
   Cache cacheUtil = new Cache();
    // setting default interval value.
    int sleepTime = DEFAULT_INTERVAL * SECOND_TO_MILLIS;

    try {
      // getting interval value from cache.
      int intervalMin = getCacheCleanerInterval();
      sleepTime = intervalMin * SECOND_TO_MILLIS;
    }
    catch (NumberFormatException e) {
      logger.log(Level.SEVERE,e.getMessage(),e);
    }


    while (runnerFlag == true) {
      try {
        Thread.sleep(sleepTime);
      }
      catch (InterruptedException e) {
        logger.log(Level.SEVERE,e.getMessage(),e);
      }

      try {
        Iterator iterator = cacheUtil.getAllUserRegionIds().iterator();
        while (iterator.hasNext()) {
          String regionName = (String)iterator.next();
          UserRegion userRegion = cacheUtil.getUserRegion(regionName);
          if (userRegion.isCleaningRequired()) {
            new CleanerThread(userRegion);
          }
        }
      }
      catch (CacheException e) {
        logger.log(Level.SEVERE,e.getMessage(),e);
      }
    }
  }

  /**
   * @return
   */
  private int getCacheCleanerInterval() {
    // TODO Auto-generated method stub
    return 0;
  }

  /**
   * 
   */
  public void stopCacheElementCleaner() {
    runnerFlag = false;
  }

  private class CleanerThread extends Thread {

    private UserRegion userRegion;
    private String regionName;

    /**
     * 
     */
    public CleanerThread(UserRegion userRegion) {
      this.userRegion = userRegion;
      this.regionName = userRegion.getRegionName();
      this.setName(regionName + " CleanerThread");
      this.setDaemon(true);
      this.start();
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Thread#run()
     */
    @Override
    public void run() {
      HashMap regionCache = userRegion.getRegionCache();
      Iterator iterator =
        ((HashMap)regionCache.clone()).keySet().iterator();
      while (iterator.hasNext()) {
        String curKey = (String)iterator.next();
        CacheElement cacheElement = (CacheElement)regionCache.get(curKey);
        if (cacheElement.isCleanable()) {
          Cache cacheUtil = new Cache();
          try {
            cacheUtil.removeElement(userRegion.getRegionName(), curKey);
          }
          catch (CacheException e) {
            logger.log(Level.SEVERE,e.getMessage(),e);
          }
//          regionCache.remove(curKey);
          logger.log(Level.INFO, "Evicted an element : Region = "
              + regionName + ", Key = " + curKey + ", Last Access = "
              + cacheElement.getLastAccessTime());
        }
      }
      userRegion.setCleaningRequired(false);
    }
  }
}
