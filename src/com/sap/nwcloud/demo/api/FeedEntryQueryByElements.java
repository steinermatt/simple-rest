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
public class FeedEntryQueryByElements
{
  private String id = null; 

  public String getId()
  {
    return id;
  }

  public void setId(String id)
  {
    this.id = id;
  }
}
