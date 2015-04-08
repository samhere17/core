/**
 * Copyright (c) 2009, Amdocs. -- All Rights Reserved
 * 
 */

package org.iq.cache;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.iq.cache.regions.UserRegion;
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
  
  private Logger logger = Logger.getLogger(CacheEvictor.class.getName());

  /**
   * 
   */
  private CacheEvictor() {
    runner = new Thread(this, "Cache Evictor Thread");
    flag = true;
    runner.start();
  }

  /**
   * @return CacheManager
   */
  public static CacheEvictor getEvictorInstance() {
    if (evictorInstance == null) {
      evictorInstance = new CacheEvictor();
    }
    return evictorInstance;
  }

  /*
   * (non-Javadoc)
   * 
   * @see java.lang.Runnable#run()
   */
  public void run() {
    Set regionKeySet = null;
    Cache cacheUtil = new Cache();
    UserRegion userRegion = null;

    // setting default interval value.
    int intervalMin = DEFAULT_INTERVAL;

    // getting interval value from cache.
    try {
      intervalMin =  getDefaultCacheEvictionInterval();
    }
    catch (NumberFormatException e) {
      logger.log(Level.SEVERE,e.getMessage(),e);
    }

    while (flag == true) {
      try {
        logger.log(Level.INFO, "interval::" + intervalMin);
        logger.log(Level.INFO, "Before sleep");
        Thread.sleep(intervalMin * MINUTE_TO_MILLIS);
        logger.log(Level.INFO, "After sleep");
      }
      catch (InterruptedException e) {
        logger.log(Level.SEVERE,e.getMessage(),e);
      }

      try {
        // getting all regions in the cache.
        regionKeySet = cacheUtil.getAllUserRegionIds();
        logger.log(Level.INFO, "Cache has got " + regionKeySet.size()+ " regions.");
      }
      catch (CacheException e) {
        logger.log(Level.SEVERE,e.getMessage(),e);
      }

      Iterator it = regionKeySet.iterator();
      while (it.hasNext()) {
        String regionId = (String)it.next();
        try {
          userRegion = cacheUtil.getUserRegion(regionId);
        }
        catch (CacheException e) {
          logger.log(Level.SEVERE,e.getMessage(),e);
        }
        startEviction(userRegion);
      }
    }
  }

  /**
   * @return
   */
  private int getDefaultCacheEvictionInterval() {
    // TODO Auto-generated method stub
    return 0;
  }

  private void startEviction(UserRegion userRegion) {
    // code to check if the region itself needs to be removed
    if (userRegion.getKeySet().isEmpty()) {

    }
    else {
      logger.log(Level.INFO, "Eviction Value : " + userRegion.isEvictionAllowed());
      if (userRegion.isEvictionAllowed()) {
        EvictionMarker marker = new EvictionMarker(userRegion);
        marker.start();
        logger.log(Level.INFO, "Eviction marker started for "
            + userRegion.getRegionName() + " region.");
      }
      else {
        logger.log(Level.INFO, "Eviction not allowed for "
            + userRegion.getRegionName() + " region.");
      }
    }
  }

  /**
   * 
   */
  public void stopCacheEvictor() {
    flag = false;
  }

  private class EvictionMarker extends Thread {

    private UserRegion userRegion;

    /**
     * @param userRegion
     */
    private EvictionMarker(UserRegion userRegion) {
      this.userRegion = userRegion;
      this.setName(userRegion.getRegionName() + " Eviction Marker Thread");
      this.setDaemon(true);
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Thread#run()
     */
    public void run() {
      markEvictable(userRegion.getRegionName(), userRegion.getRegionType(),
          userRegion.getRegionCache());
      logger.log(Level.INFO, this.getName() + " started...");
    }

    public void markEvictable(String regionName, String regionType,
        HashMap regionCache) {
      boolean markedAny = false;
      Iterator cacheEleKeySetIterator =
        ((HashMap)regionCache.clone()).keySet().iterator();
      while (cacheEleKeySetIterator.hasNext()) {
        Object currKey = cacheEleKeySetIterator.next();
        CacheElement cacheElement = (CacheElement)regionCache.get(currKey);
        if (new CacheEvictorHelper().markElement(cacheElement, regionType,
            regionName)) {
          cacheElement.setCleanable(true);
          logger.log(Level.INFO, "Marked Cache Element in region : " + regionName);
          markedAny = true;
        }
      }

      if (markedAny) {
        userRegion.setCleaningRequired(true);
      }
    }
  }
}