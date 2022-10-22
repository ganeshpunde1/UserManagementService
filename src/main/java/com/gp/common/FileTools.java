
package com.gp.common;

import java.io.File;
import java.util.LinkedList;
import java.util.Locale;
import java.util.Objects;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FileTools implements java.io.Serializable {

    private static final long serialVersionUID = 1L;

    private static final Logger LOG = LoggerFactory.getLogger(FileTools.class);

    public static LinkedList<String> getFileNamesInPath(final String path) {
	final LinkedList<String> rtn = new LinkedList<>();
	final File dir = new File(path);
	final String[] children = dir.list();
	if (children != null) {
	    for (final String fileName : children) {
		FileTools.LOG.debug("found existing file on disk [" + path + "] = " + fileName);
		rtn.add(fileName);
	    }
	}
	return rtn;
    }

    public static LinkedList<String> getFileNamesInPath(final String path, final String textFilter) {
	final LinkedList<String> rtn = new LinkedList<>();
	final File dir = new File(path);
	final String[] children = dir.list();
	if (children != null) {
	    for (final String element : children) {
		// Get filename of file or directory
		final String fileName = java.util.Objects.toString(element, "");
		FileTools.LOG.debug("found existing file on disk [" + path + "] = " + fileName);
		if (fileName.toUpperCase().indexOf(Objects.toString(textFilter, "").toUpperCase(Locale.US)) >= 0) {
		    rtn.add(fileName);
		}
	    }
	}
	return rtn;
    }

    public static void createDirectory(final String path) {
	final File file = new File(path);
	file.mkdir();
    }

    public static boolean deleteDirectory(final String path) {
	return FileTools.deleteDirectory(new File(path));
    }

    public static boolean deleteDirectory(final File path) {
	if (path.exists()) {
	    final File[] files = path.listFiles();
	    for (final File file : files) {
		if (file.isDirectory()) {
		    FileTools.deleteDirectory(file);
		} else {
		    file.delete();
		}
	    }
	}
	return (path.delete());
    }

    public static String getExtension(final String f) {
	String ext = "";
	final int i = f.lastIndexOf('.');
	if ((i > 0) && (i < (f.length() - 1))) {
	    ext = f.substring(i + 1);
	}
	return ext;
    }

    public static String getFileName(final String f) {
	String fname = "";
	final int i = f.lastIndexOf('.');
	if ((i > 0) && (i < (f.length() - 1))) {
	    fname = f.substring(0, i);
	}
	return fname;
    }
}
