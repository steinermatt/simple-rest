package com.sap.nwcloud.demo.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "log")
@XmlAccessorType(XmlAccessType.FIELD)
public class LogRecord
{
  private int errorCode = 500;
  
  private String msg = null;
  
  private String details = null;
  
  public int getErrorCode()
  {
    return errorCode;
  }

  public void setErrorCode(int errorCode)
  {
    this.errorCode = errorCode;
  }

  public String getMsg()
  {
    return msg;
  }

  public void setMsg(String msg)
  {
    this.msg = msg;
  }

  public String getDetails()
  {
    return details;
  }

  public void setDetails(String details)
  {
    this.details = details;
  }  
}
