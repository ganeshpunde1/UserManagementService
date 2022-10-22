
package com.gp.common;

import java.util.HashMap;
import java.util.Map;

public final class HashMapTools implements java.io.Serializable {

    private static final long serialVersionUID = 1L;

    private HashMapTools() {
    }

    public static void clearHashMap(final HashMap<?, ?> mymap) {
	try {
	    if (mymap != null) {
		mymap.clear();
	    }
	} catch (final Exception e) {
	    // catch exception
	}
    }

    public static void clearMap(final Map<?, ?> mymap) {
	try {
	    if (mymap != null) {
		mymap.clear();
	    }
	} catch (final Exception e) {
	    // catch exception
	}
    }
}
