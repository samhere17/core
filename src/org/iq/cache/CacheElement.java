package org.iq.cache;

import java.util.Date;


/**
 * @author Sam
 *
 */
public class CacheElement {

  private Date creationTime = new Date();
  private Date lastAccessTime = new Date();
  private Object value = null;
  private Boolean cleanable=false;
  
  /**
   * @return the cleanable
   */
  public Boolean isCleanable() {
    return cleanable;
  }

  /**
   * @param cleanable
   *          the cleanable to set
   */
  public void setCleanable(Boolean cleanable) {
    this.cleanable = cleanable;
  }

  /**
   * @return the value
   */
  
  public Object getValue() {
    return value;
  }

  /**
   * @param value
   *          the value to set
   */
  public void setValue(Object value) {
    this.value = value;
  }

  /**
   * @return the creationTime
   */
  public Date getCreationTime() {
    return creationTime;
  }

/*  *//**
   * @param creationTime
   *          the creationTime to set
   *//*
  public void setCreationTime(Date creationTime) {
    this.creationTime = creationTime;
  }*/

  /**
   * @return the lastAccessTime
   */
  public Date getLastAccessTime() {
    return lastAccessTime;
  }

  /**
   * @param lastAccessTime
   *          the lastAccessTime to set
   */
  public void setLastAccessTime(Date lastAccessTime) {
    this.lastAccessTime = lastAccessTime;
  }
}
