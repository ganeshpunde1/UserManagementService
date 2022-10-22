
package com.gp.common;

import java.util.Vector;

public final class VectorTools implements java.io.Serializable {

    private static final long serialVersionUID = 1L;
    // private static final Logger LOG = LoggerFactory.getLogger ( VectorTools.class
    // ) ;

    private VectorTools() {
    }

    public static <E> Vector<E> checkVectorForNull(final Vector<E> myvector) {
	Vector<E> tmp = myvector;
	if (tmp == null) {
	    tmp = new Vector<>();
	}
	return tmp;
    }

    public static void removeAllElementsFromVector(final Vector<?> vector) {
	if (vector != null) {
	    // Object obj = null ;
	    while (!vector.isEmpty()) {
		// obj = list.get ( 0 ) ;
		// obj = null ;
		vector.remove(0);
	    }
	}
    }
}
