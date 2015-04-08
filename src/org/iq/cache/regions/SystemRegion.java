package org.iq.cache.regions;


public class SystemRegion extends Region {

  /**
   * 
   */
  private static final long serialVersionUID = -904994584422184298L;
  
  private static SystemRegion systemRegion = null;
  
  /**
   * @param regionName
   * @param description
   */
  protected SystemRegion(String regionName, String description) {
    super(regionName, "System", description);
  }

  public static SystemRegion getInstance() {
    if (systemRegion == null) {
      systemRegion = new SystemRegion("SystemRegion", "systemRegion TODO");
    }
    return systemRegion;
  }
}
