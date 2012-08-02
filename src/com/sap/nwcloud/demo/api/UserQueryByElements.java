package com.sap.nwcloud.demo.api;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement 
@XmlAccessorType(XmlAccessType.FIELD)
public class UserQueryByElements
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
