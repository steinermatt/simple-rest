package com.sap.nwcloud.demo.dao;


public class DAOFactory
{
  private static DAOFactory instance = new DAOFactory();
  
  private DAOFactory()
  {
    // private constructor, to ensure singleton pattern
  }
  
  public static DAOFactory getInstance()
  {
    return instance;
  }
  
  public FeedDAO getDAO()
  {
    
        return ((FeedDAO) new FeedDAOSyndImpl());        
      
  }
  
  
}
