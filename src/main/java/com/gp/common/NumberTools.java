
package com.gp.common;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.DecimalFormatSymbols;

public final class NumberTools implements java.io.Serializable {

    private static final long serialVersionUID = 1L;

    private NumberTools() {
    }

    public static boolean isStringNumeric(final String str) {
	boolean rtn = false;
	final DecimalFormatSymbols currentLocaleSymbols = DecimalFormatSymbols.getInstance();
	final char localeMinusSign = currentLocaleSymbols.getMinusSign();
	if (!StringTools.doesStringHaveData(str)) {
	    rtn = false;
	} else if (!Character.isDigit(str.charAt(0)) && (str.charAt(0) != localeMinusSign)) {
	    rtn = false;
	} else {
	    boolean isDecimalSeparatorFound = false;
	    final char localeDecimalSeparator = currentLocaleSymbols.getDecimalSeparator();
	    for (final char c : str.substring(1).toCharArray()) {
		if (!Character.isDigit(c)) {
		    if ((c == localeDecimalSeparator) && !isDecimalSeparatorFound) {
			isDecimalSeparatorFound = true;
			continue;
		    }
		    rtn = false;
		}
	    }
	    rtn = true;
	}
	return rtn;
    }

    public static long getLong(final BigDecimal bigInt) {
	long rtn = 0;
	if (bigInt != null) {
	    try {
		rtn = bigInt.longValue();
	    } catch (final Exception e) {
		rtn = 0;
	    }
	}
	return rtn;
    }

    public static long getLong(final BigInteger bigInt) {
	long rtn = 0;
	if (bigInt != null) {
	    try {
		rtn = bigInt.longValue();
	    } catch (final Exception e) {
		rtn = 0;
	    }
	}
	return rtn;
    }

    public static int getIntFromString(final String input) {
	int rtn = -999999;
	if (StringTools.containsNumber(input)) {
	try {
	    rtn = Integer.parseInt(input);
	} catch (final Exception e) {
	    rtn = -999999;
	}

	}
	return rtn;
    }

    public static long getLongFromString(final String input) {
	long rtn = -999999;
	if (StringTools.containsNumber(input)) {
	try {
	    rtn = Long.parseLong(input);
	} catch (final Exception e) {
	    rtn = -999999;
	}
	}
	return rtn;
    }

    public static int addIntegers(final int... list) {
	int rtn = 0;
	for (final int i : list) {
	    rtn += i;
	}
	return rtn;
    }

    public static long addLongs(final int... list) {
	long rtn = 0;
	for (final int i : list) {
	    rtn += i;
	}
	return rtn;
    }

    public static int getIntFromString(final String convertMe, final int defaultValue) {
	int rtn = defaultValue;
	if (StringTools.containsNumber(convertMe)) {
	try {
	    rtn = Integer.parseInt(convertMe);
	} catch (final Exception e) {
	}
	}
	return rtn;
    }
}
