package com.sap.nwcloud.demo.api;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import com.sap.nwcloud.demo.model.User;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class BaseRequest
{
  private User currentUser = null;

  public User getCurrentUser()
  {
    return currentUser;
  }

  public void setCurrentUser(User currentUser)
  {
    this.currentUser = currentUser;
  }
}
