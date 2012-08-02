package com.sap.nwcloud.demo.model;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Model object representing a list of {@link Feed}s.
 * 
 * @author Matthias Steiner
 * @version 0.1
 */
@XmlRootElement(name = "subscriptionList")
@XmlAccessorType(XmlAccessType.FIELD)
public class SubscriptionList
{
  @XmlElement(name = "subscriptions")
  private List<Subscription> subscriptions = null;
  
  
  public List<Subscription> getSubscriptions()
  {
    return subscriptions;
  }


  public void setSubscriptions(List<Subscription> subscriptions)
  {
    this.subscriptions = subscriptions;
  }
}




