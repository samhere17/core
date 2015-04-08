/**
 * Copyright (c) 2009, Amdocs. -- All Rights Reserved
 * 
 */

package org.iq.cache;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.iq.cache.regions.SystemRegion;
import org.iq.cache.regions.UserRegion;
import org.iq.exception.CacheException;

/**
 * @author Sam
 * 
 */
public class CacheEvictorHelper {

  private static final int DEFAULT_INTERVAL = 5;
  private static final int MINUTE_TO_MILLIS = 60 * 1000;
  private Logger logger =
      Logger.getLogger(CacheEvictorHelper.class.getName());


  /**
   * @param cacheElement
   * @param regionType
   * @param regionName
   * @return boolean
   */
  public boolean markElement(CacheElement cacheElement, String regionType,
      String regionName) {
    boolean cleanable = false;
    long lastAccessTime = cacheElement.getLastAccessTime().getTime();
    long presentTime = System.currentTimeMillis();

    int intervalMin = DEFAULT_INTERVAL;
    try {
      intervalMin = getCacheEvictionInterval(regionType);
    }
    catch (NumberFormatException e) {
      logger.log(Level.SEVERE, e.getMessage(), e);
    }

    if ((presentTime - lastAccessTime) > intervalMin * MINUTE_TO_MILLIS) {
      cleanable = true;
      logger.log(Level.INFO, "Marked Cache Element in region : "
          + regionName);
    }
    return cleanable;
  }

  /**
   * @return
   */
  private int getCacheEvictionInterval(String regionType) {
    int interval = 0;
    SystemCache systemCache = SystemCache.getInstance();
    if (systemCache != null) {
      SystemRegion systemRegion = systemCache.get(regionType);
      if (systemRegion != null && systemRegion.isKeyExists(regionType)) {
        try {
          UserRegion userRegion =
              (UserRegion)systemRegion.getElement(regionType);
          interval = userRegion.getEvictionInterval();
        }
        catch (CacheException e) {
          logger.log(Level.SEVERE, e.getMessage(), e);
        }
      }
    }
    return interval;
  }
}