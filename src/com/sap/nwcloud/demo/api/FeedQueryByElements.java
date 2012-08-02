package com.sap.nwcloud.demo.api;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 
 * @see https://cwiki.apache.org/WINK/jax-rs-parameters.html
 *
 */
@XmlRootElement 
@XmlAccessorType(XmlAccessType.FIELD)
public class FeedQueryByElements
{
  private String id = null; 
  
  private String userId = null;

  public String getUserId()
  {
    return userId;
  }

  public void setUserId(String userId)
  {
    this.userId = userId;
  }

  public String getId()
  {
    return id;
  }

  public void setId(String id)
  {
    this.id = id;
  }
}
