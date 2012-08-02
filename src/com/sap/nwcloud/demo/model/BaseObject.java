package com.sap.nwcloud.demo.model;

import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)
abstract public class BaseObject
{
	  /**
	   * See {@link #getKey()}
	   */
	  protected String key = null;

	  /**
	   * See {@link #getCreatedBy()}
	   */
	  protected String createdBy = null;

	  /**
	   * See {@link #getCreatedAt()}
	   */
	  protected Date createdAt = null;

	  /**
	   * See {@link #getModifiedAt()}
	   */
	  protected Date modifiedAt = null;

	  /**
	   * See {@link #getModifiedBy()}
	   */
	  protected String modifiedBy = null;


	  /**
	   * @return - The GUID of this entity
	   */
	  public String getKey()
	  {
	    return this.key;
	  }

	  /**
	   * @param key - The GUID of this entity
	   */
	  public void setKey(String key)
	  {
	    if (key != null && key.trim().length() == 0)
	    {
	      this.key = null;
	    }
	    else
	    {
	      this.key = key;
	    }
	  }

	  /**
	   * @return - The username of the user who created the entity object
	   */
	  public String getCreatedBy()
	  {
	    return this.createdBy;
	  }

	  /**
	   * @param createdBy - The username of the user who created the entity object
	   */
	  public void setCreatedBy(String createdBy)
	  {
	    if (createdBy != null && createdBy.trim().length() == 0)
	    {
	      this.createdBy = null;
	    }
	    else
	    {
	      this.createdBy = createdBy;
	    }
	  }

	  /**
	   * 
	   * @return - The {@link Date} of the creation time of this entity object
	   */
	  public Date getCreatedAt()
	  {
	    return this.createdAt;
	  }

	  /**
	   * 
	   * @param createdAt - The {@link Date} of the creation time of this entity object
	   */
	  public void setCreatedAt(Date createdAt)
	  {
	    this.createdAt = createdAt;
	  }

	  /**
	   * 
	   * @return - The {@link Date} of the last change of this object
	   */
	  public Date getModifiedAt()
	  {
	    return this.modifiedAt;
	  }

	  /**
	   * 
	   * @param modifiedAt - Set the {@link Date} of the last change of this object
	   */
	  public void setModifiedAt(Date modifiedAt)
	  {
	    this.modifiedAt = modifiedAt;
	  }

	  /**
	   * 
	   * @return - The user name of the last modifier
	   */
	  public String getModifiedBy()
	  {
	    return this.modifiedBy;
	  }

	  /**
	   * 
	   * @param modifiedBy - The user name of the last modifier
	   */
	  public void setModifiedBy(String modifiedBy)
	  {
	    if (modifiedBy != null && modifiedBy.trim().length() == 0)
	    {
	      this.modifiedBy = null;
	    }
	    else
	    {
	      this.modifiedBy = modifiedBy;
	    }
	  }

	  /**
	   * Clears all attributes of the {@link BaseEntity}
	   */
	  public final void clearBaseValues()
	  {
	    createdAt = null;
	    createdBy = null;
	    key = null;
	    modifiedAt = null;
	    modifiedBy = null;
	  }
}
