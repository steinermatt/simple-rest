package com.sap.nwcloud.demo.api;

import javax.xml.bind.annotation.XmlRegistry;

@XmlRegistry
public class ObjectFactory 
{  
  public ObjectFactory() 
  {
  }  
  
  public FeedEntryQueryByElements createFeedEntryQueryByElements()
  {
    return new FeedEntryQueryByElements();
  }
  
}
