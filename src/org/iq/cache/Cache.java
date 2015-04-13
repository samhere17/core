package org.iq.cache;

import java.util.HashMap;

import org.iq.cache.regions.CacheRegion;

public class Cache extends HashMap<String, CacheRegion> {

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
