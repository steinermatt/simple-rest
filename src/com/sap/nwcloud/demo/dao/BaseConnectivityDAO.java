package com.sap.nwcloud.demo.dao;

import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.URL;
import java.net.URLConnection;




/**
 * Base class for all Data Access Objects (DAO) of type connectivity. 
 * 
 * @author Matthias Steiner
 * @version 0.1
 */
public class BaseConnectivityDAO
{

  /**
   * Opens and returns a {@link UrlConnection} to the specified url. 
   * 
   * All communication- and security-relevant considerations are encapsulated in this method. (TBD)
   * 
   * @param url The url to connect to
   * @return The {@link UrlConnection}
   */
  public final URLConnection getURLConnection(String url)
  {
    
    URLConnection retVal = null;
    
    try
    {
      
      boolean useProxy = true;  // TODO MS - how to be location aware?
      
      if (useProxy)
      {
        // set proxy
        Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress("proxy", 8080)); // TODO MS hard-coded proxy     
        retVal =  new URL(url).openConnection(proxy);
      }
      else
      {
        retVal =  new URL(url).openConnection();
      }            
    }
    catch (Exception ex)
    {
      ex.printStackTrace();
    }    
    
    return retVal;
  }    
  
}
