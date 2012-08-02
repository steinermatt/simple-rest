package com.sap.nwcloud.demo.model;

import java.io.Serializable;
import java.io.StringWriter;
import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Model object representing a user.
 * 
 * @author Matthias Steiner
 * @version 0.1
 */

@XmlRootElement(name = "user")
@XmlAccessorType(XmlAccessType.FIELD)
public class User extends BaseObject implements Serializable
{
  /**
   * The <code>serialVersionUID</code> of the {@link User} class.
   */
  private static final long serialVersionUID = 1L;
  
 
  private String username = null;   
  

  private String fullname = null;   
  

  private String email = null;   
    

  private String image = null;
     

  private String uri = null; 
  

  private String twitter = null;  
  
  public String getTwitter()
  {
    return twitter;
  }

  public void setTwitter(String twitter)
  {
    this.twitter = twitter;
  }


  
  private String locale = null;      

  private List<Subscription> subscriptions = null;  
  
   
  public String getImage()
  {
    return image;
  }

  public void setImage(String image)
  {
    this.image = image;
  }

  public String getUri()
  {
    return uri;
  }

  public void setUri(String uri)
  {
    this.uri = uri;
  }

  public String getLocale()
  {
    return locale;
  }

  public void setLocale(String locale)
  {
    this.locale = locale;
  }

  public String toString()
  {
    StringWriter str = new StringWriter();

    str.append('[');
    str.append(this.getClass().getSimpleName());
    str.append(']');
    str.append(" @");
    str.append(Integer.toHexString(System.identityHashCode(this)));
    str.append(this.key);     
    
    return str.toString();
  }
  
  /**
   * 
   * @return - The {@link Date} of the creation time of this entity object
   */
  public Date getCreatedAt()
  {
    Date date = super.getCreatedAt();
        
    return date;
  }

  /**
   * 
   * @param createdAt - The {@link Date} of the creation time of this entity object
   */
  public void setCreatedAt(Date createdAt)
  {
    super.setCreatedAt(createdAt);    
       
  }


  public String getUsername()
  {
    return username;
  }

  public void setUsername(String username)
  {
    this.username = username;
  }


  public String getFullname()
  {
    return fullname;
  }

  public void setFullname(String fullname)
  {
    this.fullname = fullname;
  }

  public String getEmail()
  {
    return email;
  }

  public void setEmail(String email)
  {
    this.email = email;
  }


  public List<Subscription> getSubscriptions()
  {
    return subscriptions;
  }

  public void setSubscriptions(List<Subscription> subscriptions)
  {
    this.subscriptions = subscriptions;
  } 
}
