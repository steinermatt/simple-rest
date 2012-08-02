package com.sap.nwcloud.demo.utils;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;

public class StringUtils
{

	/**
	 * The OS-dependent representation of a new line {@link String}.
	 */
	public static final String NEW_LINE_SEPARATOR = System.getProperty("line.separator");

	public static String getStackTrace(Throwable throwable)
	{
		if (throwable == null)
		{
			return null;
		}

		final Writer result = new StringWriter();

		final PrintWriter printWriter = new PrintWriter(result);

		throwable.printStackTrace(printWriter);

		return result.toString();
	}
}
