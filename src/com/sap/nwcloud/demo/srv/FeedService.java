package com.sap.nwcloud.demo.srv;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;

import org.apache.cxf.jaxrs.ext.MessageContext;

import com.sap.nwcloud.demo.api.FeedQueryByElements;
import com.sap.nwcloud.demo.dao.DAOFactory;
import com.sap.nwcloud.demo.dao.FeedDAO;
import com.sap.nwcloud.demo.model.Feed;
import com.sap.nwcloud.demo.model.FeedList;
import com.sap.nwcloud.demo.model.ObjectFactory;

/**
 * {@link FeedService}
 * 
 * @author Matthias Steiner
 * @version 0.1
 */
@Path("/feeds")
@Produces({ "application/json" })
public class FeedService extends BaseService
{

	@GET
	@Path("/")
	public FeedList getFeeds(@PathParam("") FeedQueryByElements query)
	{
		
		FeedList list = new ObjectFactory().createFeedList();

		Collection<Feed> feeds = new ArrayList<Feed>(1);
		
		// dirty hardcoded string ;)
		final String url = "http://scn.sap.com/community/feeds/blogs";
		FeedDAO dao = DAOFactory.getInstance().getDAO();
		
		Feed feed = dao.findFeedByURL(url);
		
		feeds.add(feed);

		List<Feed> feedList = new ArrayList<Feed>(feeds.size());
		feedList.addAll(feeds);

		list.setFeeds(feedList);

		return list;
	}
}
