package com.sap.nwcloud.demo.model;

import javax.xml.bind.annotation.XmlRegistry;

@XmlRegistry
public class ObjectFactory 
{  
  public ObjectFactory() 
  {
  }  
  
  public Feed createFeed()
  {
    return new Feed();
  }
  
  public FeedList createFeedList()
  {
    return new FeedList();
  }
  
  public FeedEntry createFeedEntry()
  {
    return new FeedEntry();
  }
  
  public LogRecord createLog()
  {
    return new LogRecord();
  }
  
  public Article createArticle()
  {
    return new Article();
  }
  
  public User createUser()
  {
    return new User();
  }
  
  public SubscriptionList createSubscritpionList()
  {
    return new SubscriptionList();
  }
  
}
