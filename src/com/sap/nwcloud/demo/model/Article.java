package com.sap.nwcloud.demo.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 
 * 
 * @author Matthias Steiner
 * @version 0.1
 */
@XmlRootElement(name = "article")
@XmlAccessorType(XmlAccessType.FIELD)
public class Article extends FeedEntry implements Serializable
{
  /**
   * The <code>serialVersionUID</code> of the {@link Article} class.
   */
  private static final long serialVersionUID = 1L;

  private String htmlContent = null;
  
  private String plainText = null;   
  
  private List<String> links = new ArrayList<String>();
  
  private List<String> images = new ArrayList<String>();

  public String getHtmlContent()
  {
    return htmlContent;
  }

  public void setHtmlContent(String htmlContent)
  {
    this.htmlContent = htmlContent;
  }

  public String getPlainText()
  {
    return plainText;
  }

  public void setPlainText(String plainText)
  {
    this.plainText = plainText;
  }

  public List<String> getLinks()
  {
    return links;
  }

  public void setLinks(List<String> links)
  {
    this.links = links;
  }

  public List<String> getImages()
  {
    return images;
  }

  public void setImages(List<String> images)
  {
    this.images = images;
  }
}
