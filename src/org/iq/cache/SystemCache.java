package org.iq.cache;

import java.util.HashMap;

import org.iq.cache.regions.SystemRegion;

public class SystemCache extends HashMap<String, SystemRegion>{

  /**
   * 
   */
  private static final long serialVersionUID = -1384876216155523812L;
  private static SystemCache systemCache = null;
  private static boolean initialized = false; 

  /**
   * @return
   */
  public static SystemCache getInstance() {
    if (systemCache == null) {
      systemCache = new SystemCache();
    }
    return systemCache;
  }
  
  /**
   * 
   */
  public static void initialize() {
    SystemCache.getInstance();
    systemCache.put(CacheConstants.REGION_TYPES_REGION, SystemRegion.getInstance());
    setInitialized();
  }

  /**
   * @return the initialized
   */
  public static boolean isInitialized() {
    return initialized;
  }

  /**
   * @param initialized the initialized to set
   */
  private static void setInitialized() {
    SystemCache.initialized = true;
  }
}