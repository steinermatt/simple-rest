package com.sap.nwcloud.demo.utils.cxf;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.ext.Provider;

import org.apache.cxf.jaxrs.provider.json.JSONProvider;

/**
 * To avoid issues with collections having only 1 entry we set
 * 'serializeAsArray' and 'arrayKeys'
 * 
 * 
 * @see http://good-good-study.appspot.com/blog/posts/6004
 * @see http://www.mail-archive.com/users@cxf.apache.org/msg22252.html
 * @see http
 *      ://dhruba.name/2008/12/08/rest-service-example-using-cxf-22-jax-rs-10
 *      -jaxb-and-spring/
 */
@SuppressWarnings("rawtypes")
@Provider
public class CustomJSONProvider extends JSONProvider
{
	@SuppressWarnings("unchecked")
	public CustomJSONProvider()
	{
		//super();
//		setIgnoreNamespaces(true);
//		setSerializeAsArray(true);
//		setDropCollectionWrapperElement(false);
//		setDropRootElement(true);
//
//		List<String> arrayKeys = new ArrayList<String>();
//		arrayKeys.add("subscriptions");
//		arrayKeys.add("feeds");
//		arrayKeys.add("feedEntries");
//		setArrayKeys(arrayKeys);
	}
}
