package org.iq.cache;

import java.util.HashMap;

import org.iq.cache.regions.UserRegion;

public class UserCache extends HashMap<String, UserRegion> {

  /**
   * 
   */
  private static final long serialVersionUID = 52671797556234937L;
  private static UserCache userCache = null;

  public static UserCache getInstance() {
    if (userCache == null) {
      userCache = new UserCache();
    }
    return userCache;
  }
}
