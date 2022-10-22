
package com.gp.common;

import java.io.PrintWriter;
import java.io.StringWriter;

public final class ExceptionTools {

    private ExceptionTools() {
    }

    public static String getStackTrace(final Exception e) {
	final StringWriter stringWritter = new StringWriter();
	final PrintWriter printWritter = new PrintWriter(stringWritter, true);
	e.printStackTrace(printWritter);
	printWritter.flush();
	stringWritter.flush();
	return stringWritter.toString();
    }

    public static String getStackTrace(final Throwable t) {
	final StringWriter stringWritter = new StringWriter();
	final PrintWriter printWritter = new PrintWriter(stringWritter, true);
	t.printStackTrace(printWritter);
	printWritter.flush();
	stringWritter.flush();
	return stringWritter.toString();
    }

    public static String getMethodName(final StackTraceElement[] stackTraceElement) {
	String rtn = "";
	boolean donext = false;
	try {
	    for (final StackTraceElement s : stackTraceElement) {
		if (!donext) {
		    donext = s.getMethodName().equals(Constants.GET_STACK_TRACE);
		} else if (donext) {
		    rtn = s.getClassName() + Constants.PERIOD + s.getMethodName();
		    break;
		}
	    }
	} catch (final Exception e) {
	    rtn = "";
	}
	return rtn;
    }

    public static String getLineNumber(final Exception exception) {
	String rtn;
	try {
	    rtn = "" + exception.getStackTrace()[0].getLineNumber();
	} catch (final Exception e) {
	    rtn = "";
	}
	return rtn;
    }

    public static String getLineNumber(final StackTraceElement[] stackTraceElement) {
	String rtn = "";
	boolean donext = false;
	try {
	    for (final StackTraceElement s : stackTraceElement) {
		if (!donext) {
		    donext = s.getMethodName().equals(Constants.GET_STACK_TRACE);
		} else if (donext) {
		    rtn = "" + s.getLineNumber();
		    break;
		}
	    }
	} catch (final Exception e) {
	    rtn = "";
	}
	return rtn;
    }

    public static String getMethodName(final Exception exception) {
	String rtn;
	try {
	    rtn = exception.getStackTrace()[0].getClassName() + Constants.PERIOD
		    + exception.getStackTrace()[0].getMethodName();
	} catch (final Exception e) {
	    rtn = "";
	}
	return rtn;
    }
}
