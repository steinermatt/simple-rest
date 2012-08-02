package com.sap.nwcloud.demo.dao;

import java.io.IOException;
import java.net.URLConnection;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.ws.rs.core.Response.Status;

import net.htmlparser.jericho.Source;

import com.cybozu.labs.langdetect.Detector;
import com.cybozu.labs.langdetect.DetectorFactory;
import com.sap.nwcloud.demo.model.Feed;
import com.sap.nwcloud.demo.model.FeedEntry;
import com.sap.nwcloud.demo.model.LogRecord;
import com.sap.nwcloud.demo.model.ObjectFactory;
import com.sap.nwcloud.demo.utils.StringUtils;
import com.sun.syndication.feed.module.DCModule;
import com.sun.syndication.feed.module.DCSubject;
import com.sun.syndication.feed.synd.SyndEntry;
import com.sun.syndication.feed.synd.SyndFeed;
import com.sun.syndication.io.SyndFeedInput;
import com.sun.syndication.io.XmlReader;

/**
 * DAO implementation to read feeds (e.g. RSS or Atom).
 * 
 * This implementation is tailor-fitted to meet SCN content!
 * 
 * @see com.sun.syndication.feed.*
 * 
 * @author Matthias Steiner
 * @version 0.1
 */
public class FeedDAOSyndImpl extends BaseConnectivityDAO implements FeedDAO
{

	/**
	 * Returns a syndication feed for the given url.
	 * 
	 * @param url
	 *            The url of the feed to be returned
	 * @return The {@link Feed} or <code>null</code> if no feed could be
	 *         returned for the provided URL
	 * @throws DAOException
	 *             In case of an error
	 */
	public Feed findFeedByURL(String url)
	{

		Feed retVal = null;

		XmlReader reader = null;

		try
		{
			URLConnection httpcon = this.getURLConnection(url);
			reader = new XmlReader(httpcon);

			SyndFeedInput feedInput = new SyndFeedInput();
			SyndFeed syndFeed = feedInput.build(reader);

			retVal = new ObjectFactory().createFeed();
			retVal.setUrl(url);

			mapToModel(syndFeed, retVal);

		}
		catch (Exception ex)
		{

			LogRecord log = new LogRecord();
			log.setErrorCode(Status.BAD_REQUEST.getStatusCode());
			log.setMsg(MessageFormat.format("[BAD REQUEST] Are you sure this is URL refers to a feed? {0}", url));
			log.setDetails(StringUtils.getStackTrace(ex));
			throw new DAOException();
		}
		finally
		{
			if (reader != null)
			{
				try
				{
					reader.close();
				}
				catch (IOException e)
				{
				} // looking forward to Java7 (..)
			}
		}

		return retVal;

	}

	/**
	 * Maps the {@link SyndFeed} to our domain model representation:
	 * {@link Feed}
	 * 
	 * Showcase: "Very defensive & ugly programming!" :)
	 * 
	 * @param syndFeed
	 *            The {@link SyndFeed} to be used as source
	 * @param feed
	 *            The {@link Feed} to be populated
	 */
	protected static void mapToModel(SyndFeed syndFeed, Feed feed)
	{

		// author
		try
		{
			feed.setAuthor(syndFeed.getAuthor());
		}
		catch (Exception ex)
		{
			String msg = MessageFormat.format("Proplem mapping the feed attribute {0}", new Object[] { "author" });
		}

		// feed description
		try
		{
			feed.setDescription(syndFeed.getDescription());
		}
		catch (Exception ex)
		{
			String msg = MessageFormat.format("Proplem mapping the feed attribute {0}", new Object[] { "description" });
		}

		// feed encoding
		try
		{
			feed.setEncoding(syndFeed.getEncoding());
		}
		catch (Exception ex)
		{
			String msg = MessageFormat.format("Proplem mapping the feed attribute {0}", new Object[] { "encoding" });
		}

		// publishing date
		try
		{
			feed.setPublishedAt(syndFeed.getPublishedDate());
		}
		catch (Exception ex)
		{
			String msg = MessageFormat.format("Proplem mapping the feed attribute {0}", new Object[] { "publishedAt" });
		}

		// title
		try
		{
			feed.setTitle(syndFeed.getTitle());

		}
		catch (Exception ex)
		{
			String msg = MessageFormat.format("Proplem mapping the feed attribute {0}", new Object[] { "title" });
		}

		// target type
		try
		{
			feed.setTargetType(syndFeed.getFeedType());
		}
		catch (Exception ex)
		{
			String msg = MessageFormat.format("Proplem mapping the feed attribute {0}", new Object[] { "targetType" });
		}

		// URI (HTML format of the Feed)
		try
		{
			feed.setUri(syndFeed.getUri());
		}
		catch (Exception ex)
		{
			String msg = MessageFormat.format("Proplem mapping the feed attribute {0}", new Object[] { "uri" });
		}

		// image url
		try
		{
			feed.setImage(syndFeed.getImage().getUrl());
		}
		catch (Exception ex)
		{
			String msg = MessageFormat.format("Proplem mapping the feed attribute {0}", new Object[] { "image" });
		}

		/*
		 * loop over feed entries
		 */
		List<FeedEntry> feedEntries = new ArrayList<FeedEntry>();

		for (Iterator<?> i = syndFeed.getEntries().iterator(); i.hasNext();)
		{
			SyndEntry entry = (SyndEntry) i.next();

			FeedEntry feedEntry = new ObjectFactory().createFeedEntry();

			/*
			 * cross-reference feed and feed entry
			 */

			feedEntry.setFeed(feed);
			feedEntries.add(feedEntry);

			feedEntry = mapFeedEntry(entry, feedEntry);

		} // feed entries

		// set feed entries
		feed.setFeedEntries(feedEntries);

	}

	public static FeedEntry mapFeedEntry(SyndEntry entry, FeedEntry feedEntry)
	{
		// description
		try
		{
			if (entry.getDescription() != null)
			{
				Source source = new Source(entry.getDescription().getValue());
				String description = source.getTextExtractor().toString();

				// TODO MS reflect on JPA annotation of objects to properly trim
				// input
				if (description.length() > 254)
				{
					description = description.substring(0, 254);
				}

				int index = description.indexOf('<'); // left overs

				if (index != -1)
				{
					description = description.substring(0, (index - 1));
				}

				feedEntry.setDescription(description);
			}

		}
		catch (Exception ex)
		{
			String msg = MessageFormat.format("Proplem mapping the feedentry attribute {0}",
			        new Object[] { "description" });
		}

		// author
		try
		{
			feedEntry.setAuthor(entry.getAuthor());
		}
		catch (Exception ex)
		{
			String msg = MessageFormat.format("Proplem mapping the feedentry attribute {0}", new Object[] { "author" });
		}

		// description type
		try
		{
			if (entry.getDescription() != null)
			{
				feedEntry.setDescriptionType(entry.getDescription().getType());
			}
		}
		catch (Exception ex)
		{
			String msg = MessageFormat.format("Proplem mapping the feedentry attribute {0}",
			        new Object[] { "descriptionType" });
		}

		// description type
		try
		{
			feedEntry.setPublishedAt(entry.getPublishedDate());
		}
		catch (Exception ex)
		{
			String msg = MessageFormat.format("Proplem mapping the feedentry attribute {0}",
			        new Object[] { "publishedAt" });

			// set creation date as fail-safe backup
			feedEntry.setPublishedAt(new Date());
		}

		// title
		try
		{
			feedEntry.setTitle(entry.getTitle());
		}
		catch (Exception ex)
		{
			String msg = MessageFormat.format("Proplem mapping the feedentry attribute {0}", new Object[] { "title" });
		}

		// URI
		try
		{
			feedEntry.setUri(entry.getUri());
		}
		catch (Exception ex)
		{
			String msg = MessageFormat.format("Proplem mapping the feedentry attribute {0}", new Object[] { "uri" });
		}

		// URL
		try
		{
			feedEntry.setUrl(entry.getLink());
		}
		catch (Exception ex)
		{
			String msg = MessageFormat.format("Proplem mapping the feedentry attribute {0}", new Object[] { "url" });
		}

		/*
		 * DC Modules for SCN categories "http://purl.org/dc/elements/1.1/"
		 */
		DCModule dcModule = (DCModule) entry.getModule(DCModule.URI);

		if (dcModule != null && dcModule.getSubjects() != null && !(dcModule.getSubjects().isEmpty()))
		{
			DCSubject dcSubject = (DCSubject) dcModule.getSubjects().get(0);
			String subjectLine = dcSubject.getValue();
			feedEntry.setSubject(subjectLine);

			// language
			String lang = dcModule.getLanguage();
			feedEntry.setLocale(lang);

			// rights - future functionality
			@SuppressWarnings("unused")
			String rights = dcModule.getRights();

			// publisher - future functionality
			@SuppressWarnings("unused")
			String publisher = dcModule.getPublisher();

			// also available :)
			dcModule.getCreator();
			dcModule.getDate();
			dcModule.getFormat();

		}

		return feedEntry;
	}

}
