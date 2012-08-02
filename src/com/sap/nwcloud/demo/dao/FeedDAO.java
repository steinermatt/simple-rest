package com.sap.nwcloud.demo.dao;

import com.sap.nwcloud.demo.model.Feed;

public interface FeedDAO
{

  public Feed findFeedByURL(String url);
}
