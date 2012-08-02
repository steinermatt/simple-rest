package com.sap.nwcloud.demo.model;

import java.io.Serializable;
import java.io.StringWriter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import com.sap.nwcloud.demo.utils.StringUtils;





/**
 * Model object representing a user.
 * 
 * @author Matthias Steiner
 * @version 0.1
 */
@XmlRootElement(name = "subscription")
@XmlAccessorType(XmlAccessType.FIELD)
public class Subscription extends BaseObject implements Serializable
{
  /**
   * The <code>serialVersionUID</code> of the {@link Subscription} class.
   */
  private static final long serialVersionUID = 1L;  

  private Feed feed = null;

  @XmlTransient  
  private User user = null;
  

  private String title = null;
  
  private String image = null;
  
  public Feed getFeed()
  {
    return feed;
  }

  public void setFeed(Feed feed)
  {
    this.feed = feed;
    
    if (feed != null) // inherit the attributes of the feed as defaults
    {
      if (this.title == null)
      {
        this.title = feed.getTitle();
      }
      
      if (this.image == null)
      {
        this.image = feed.getImage();
      }
    }
  }

  public User getUser()
  {
    return user;
  }

  public void setUser(User user)
  {
    this.user = user;
  }

  public String getTitle()
  {
    return title;
  }

  public void setTitle(String title)
  {
    this.title = title;
  }

  public String getImage()
  {
    return image;
  }

  public void setImage(String image)
  {
    this.image = image;
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
     
    
    return str.toString();
  } 
}
