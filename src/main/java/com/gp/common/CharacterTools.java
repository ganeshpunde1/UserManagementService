
package com.gp.common;

public final class CharacterTools implements java.io.Serializable {

    private static final long serialVersionUID = 1L;

    private CharacterTools() {
    }

    public static void swap(final char[] a, final int i, final int j) {
	final char c = a[i];
	a[i] = a[j];
	a[j] = c;
    }

    public static boolean isCharInArray(final char ch, final char[] charAry) {
	boolean rtn = false;
	if (charAry != null) {
	    for (final char ch2 : charAry) {
		if (ch2 == ch) {
		    rtn = true;
		}
	    }
	}
	return rtn;
    }
}
