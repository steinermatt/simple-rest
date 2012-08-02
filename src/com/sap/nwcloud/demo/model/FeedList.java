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
@XmlRootElement(name = "feedList")
@XmlAccessorType(XmlAccessType.FIELD)
public class FeedList
{
  @XmlElement(name="feeds")
  private List<Feed> feeds = null;
  
  public List<Feed> getFeeds()
  {
    return feeds;
  }


  public void setFeeds(List<Feed> feeds)
  {
    this.feeds = feeds;
  }
}
