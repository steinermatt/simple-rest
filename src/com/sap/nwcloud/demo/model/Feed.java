package com.sap.nwcloud.demo.model;

import java.io.Serializable;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import com.sap.nwcloud.demo.utils.StringUtils;



/**
 * Model object representing a single {@link Feed} instance.
 * 
 * @author Matthias Steiner
 * @version 0.1
 */
@XmlRootElement(name = "feed")
@XmlAccessorType(XmlAccessType.FIELD)
public class Feed extends BaseObject implements Serializable
{
  /**
   * The <code>serialVersionUID</code> of the {@link Feed} class.
   */
  private static final long serialVersionUID = 1L;
  
 
  private String title = null;
  

  private String description = null;
  

  private String url = null;
  

  private String author = null;
  

  private Date publishedAt = null;
  

  private String encoding = null;
  

  private String image = null;
  

  private String targetType = null;  
  

  private String uri = null;
  

  private List<FeedEntry> feedEntries = null;  
  
  public Feed() {} // public default no-arg constructor 
  
  public Feed(String url)
  {
    this(url, null, null);
  }
  
  public Feed(String url, String title)
  {
    this(url, title, null);
  }
  
  public Feed(String url, String title, String image)
  {
    this.url = url;
    this.title = title;
    this.image = image;
  }
  
  public List<FeedEntry> getFeedEntries()
  {
    if (this.feedEntries == null)
    {
      this.feedEntries = new ArrayList<FeedEntry>();
    }
    
    return feedEntries;
  }

  public void setFeedEntries(List<FeedEntry> feedEntries)
  {
    this.feedEntries = feedEntries;
  }

  public String getTitle()
  {
    return title;
  }

  public void setTitle(String title)
  {
    this.title = title;
  }

  public String getDescription()
  {
    return description;
  }

  public void setDescription(String description)
  {
    this.description = description;
  }

  public String getUrl()
  {
    return url;
  }

  public void setUrl(String url)
  {
    this.url = url;
  }

  public String getAuthor()
  {
    return author;
  }

  public void setAuthor(String author)
  {
    this.author = author;
  }

  public Date getPublishedAt()
  {
    return publishedAt;
  }

  public void setPublishedAt(Date publishedAt)
  {
    this.publishedAt = publishedAt;
  }

  public String getEncoding()
  {
    return encoding;
  }

  public void setEncoding(String encoding)
  {
    this.encoding = encoding;
  }

  public String getImage()
  {
    return image;
  }

  public void setImage(String image)
  {
    this.image = image;
  }
  
  public String getTargetType()
  {
    return targetType;
  }

  public void setTargetType(String targetType)
  {
    this.targetType = targetType;
  }

  public String getUri()
  {
    return uri;
  }

  public void setUri(String uri)
  {
    this.uri = uri;
  }  
  
  public String toString()
  {
    StringWriter str = new StringWriter();

    str.append('[');
    str.append(this.getClass().getSimpleName());
    str.append(']');
    str.append(" @");
    str.append(Integer.toHexString(System.identityHashCode(this)));
    str.append(StringUtils.NEW_LINE_SEPARATOR);
    str.append("Title: ");
    str.append(this.getTitle());
    str.append("; URL: ");
    str.append(this.getUrl());
    
    return str.toString();
  }
}