package com.sap.nwcloud.demo.model;

import java.io.Serializable;
import java.io.StringWriter;
import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import com.sap.nwcloud.demo.utils.StringUtils;


/**
 * Model object representing a single {@link Feed} instance.
 * 
 * @author Matthias Steiner
 * @version 0.1
 */
@XmlRootElement(name = "feedEntry")
@XmlAccessorType(XmlAccessType.FIELD)
public class FeedEntry extends BaseObject implements Serializable
{
  /**
   * The <code>serialVersionUID</code> of the {@link FeedEntry} class.
   */
  private static final long serialVersionUID = 1L;
  
  @XmlTransient
  private Feed feed = null;
  
  private String title = null;

  private String description = null;

  private String descriptionType = null;
  
  private String url = null;

  private String author = null;
  
  private Date publishedAt = null;

  private String encoding = null;

  private String image = null;

  private String targetType = null;  

  private String uri = null;
 
  private String subject = null;

  private String locale = null;     

  private long timestamp = 0;
  
  private String originFeedId = null;
  
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

  public String getDescriptionType()
  {
    return descriptionType;
  }

  public void setDescriptionType(String descriptionType)
  {
    this.descriptionType = descriptionType;
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

  public String getSubject()
  {
    return subject;
  }

  public void setSubject(String subject)
  {
    this.subject = subject;
  }

  public String getLocale()
  {
    return locale;
  }

  public void setLocale(String locale)
  {
    this.locale = locale;
  }

  public Feed getFeed()
  {
    return feed;
  }

  public void setFeed(Feed feed)
  {
    this.feed = feed;
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
  
  public long getTimestamp()
  {
    return this.timestamp;
  }
  
  public void setTimestamp(long s)
  {
    this.timestamp = s;
  }
  
  /**
   * 
   * @return - The {@link Date} of the creation time of this entity object
   */
  public Date getCreatedAt()
  {
    Date date = super.getCreatedAt();
    
    if (date != null)
    {
      this.setTimestamp(date.getTime());
    }
    
    return date;
  }

  /**
   * 
   * @param createdAt - The {@link Date} of the creation time of this entity object
   */
  public void setCreatedAt(Date createdAt)
  {
    super.setCreatedAt(createdAt);    
    
    if (createdAt != null)
    {
      this.setTimestamp(createdAt.getTime());
    }    
  }


  public String getOriginFeedId()
  {
    return originFeedId;
  }

  public void setOriginFeedId(String originFeedId)
  {
    this.originFeedId = originFeedId;
  }



}
