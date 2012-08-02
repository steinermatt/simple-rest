package com.sap.nwcloud.demo.dao;

import com.sap.nwcloud.demo.model.LogRecord;
import com.sap.nwcloud.demo.model.ObjectFactory;
import com.sap.nwcloud.demo.utils.StringUtils;


public class DAOException extends RuntimeException
{

  /**
   * 
   */
  private static final long serialVersionUID = 1L;
  
  private LogRecord log = new ObjectFactory().createLog();

  public LogRecord getLog()
  {
    return log;
  }

  public DAOException()
  {
    super();    
    this.log.setErrorCode(500);
  }

  public DAOException(String message)
  {
    super(message);
    this.log.setMsg(message);
    this.log.setErrorCode(500);
  }

  public DAOException(Throwable cause)
  {
    super(cause);
    this.log.setDetails(StringUtils.getStackTrace(cause));
    this.log.setErrorCode(500);
  }

  public DAOException(String message, Throwable cause)
  {
    super(message, cause);
    this.log.setMsg(message);    
    this.log.setDetails(StringUtils.getStackTrace(cause));
    this.log.setErrorCode(500);
  }
  
  public DAOException(LogRecord log)
  {
    super(log.getMsg());
    this.log = log;
  }
  
  public DAOException(int status, String message)
  {
    super(message);
    this.log.setMsg(message);
    this.log.setErrorCode(status);
  }

}
