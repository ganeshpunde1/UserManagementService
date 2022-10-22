
package com.gp.common;

import java.util.HashSet;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

public final class SetTools implements java.io.Serializable {

    private static final long serialVersionUID = 1L;

    private SetTools() {
    }

    public static boolean isSetEmpty(final Set<?> lst) {
	boolean rtn = false;
	if (lst == null) {
	    rtn = true;
	} else if (lst.size() < 1) {
	    rtn = true;
	}
	return rtn;
    }

    public static boolean isSetNotEmpty(final Set<?> lst) {
	return !SetTools.isSetEmpty(lst);
    }

    public static <E> Set<E> checkSetForNull(final Set<E> mySet) {
	return SetTools.checkSetForNullCreateHashSet(mySet);
    }

    public static <E> SortedSet<E> checkSortedSetForNull(final SortedSet<E> mySet) {
	SortedSet<E> tmp = mySet;
	if (tmp == null) {
	    tmp = new TreeSet<>();
	}
	return tmp;
    }

    public static <E> Set<E> checkSetForNullCreateHashSet(final Set<E> mySet) {
	Set<E> tmp = mySet;
	if (tmp == null) {
	    tmp = new HashSet<>();
	}
	return tmp;
    }

    public static void clearSet(final Set<?> mySet) {
	try {
	    if (mySet != null) {
		mySet.clear();
	    }
	} catch (final Exception e) {
	    // catch exception
	}
    }

    protected static <T> Set<T> merge(final Set<T> setOne, final Set<T> setTwo) {
	final Set<T> rtn = new HashSet<>();
	if (setOne != null) {
	    for (final T item : setOne) {
		rtn.add(item);
	    }
	}
	if (setTwo != null) {
	    for (final T item : setTwo) {
		rtn.add(item);
	    }
	}
	return rtn;
    }

    public static boolean isInSet(final Set<Long> mySet, final long item) {
	boolean rtn = false;
	if (mySet != null) {
	    for (final Long temp : mySet) {
		if (temp.longValue() == item) {
		    rtn = true;
		}
	    }
	}
	return rtn;
    }

    public static boolean isInSet(final Set<Integer> mySet, final int item) {
	boolean rtn = false;
	if (mySet != null) {
	    for (final Integer temp : mySet) {
		if (temp.intValue() == item) {
		    rtn = true;
		}
	    }
	}
	return rtn;
    }

    public static boolean isInSet(final Set<Float> mySet, final float item) {
	boolean rtn = false;
	if (mySet != null) {
	    for (final Float temp : mySet) {
		if (temp.floatValue() == item) {
		    rtn = true;
		}
	    }
	}
	return rtn;
    }

    public static boolean isInSet(final Set<Double> mySet, final double item) {
	boolean rtn = false;
	if (mySet != null) {
	    for (final Double temp : mySet) {
		if (temp.doubleValue() == item) {
		    rtn = true;
		}
	    }
	}
	return rtn;
    }

    public static boolean isInSet(final Set<Character> mySet, final char item) {
	boolean rtn = false;
	if (mySet != null) {
	    for (final Character temp : mySet) {
		if (temp.charValue() == item) {
		    rtn = true;
		}
	    }
	}
	return rtn;
    }

    public static boolean isInSet(final Set<String> mySet, final String item) {
	boolean rtn = false;
	if (mySet != null) {
	    for (final String temp : mySet) {
		if (temp.equals(item)) {
		    rtn = true;
		}
	    }
	}
	return rtn;
    }

    public static boolean isInSetIgnoreCase(final Set<String> mySet, final String item) {
	boolean rtn = false;
	if (mySet != null) {
	    for (final String temp : mySet) {
		if (temp.equalsIgnoreCase(item)) {
		    rtn = true;
		}
	    }
	}
	return rtn;
    }

    public static boolean areAllElementsInLongSet(final Set<Long> SetOne, final Set<Long> SetTwo) {
	boolean rtn = true;
	if ((SetOne == null) && (SetTwo != null)) {
	    rtn = false;
	} else if ((SetOne != null) && (SetTwo == null)) {
	    rtn = true;
	} else if ((SetOne != null) && (SetTwo != null)) {
	    for (final Long temp : SetTwo) {
		if (!SetTools.isInSet(SetOne, temp.longValue())) {
		    rtn = false;
		    break;
		}
	    }
	}
	return rtn;
    }

    public static boolean areAllElementsInIntegerSet(final Set<Integer> SetOne, final Set<Integer> SetTwo) {
	boolean rtn = true;
	if ((SetOne == null) && (SetTwo != null)) {
	    rtn = false;
	} else if ((SetOne != null) && (SetTwo == null)) {
	    rtn = true;
	} else if ((SetOne != null) && (SetTwo != null)) {
	    for (final Integer temp : SetTwo) {
		if (!SetTools.isInSet(SetOne, temp.intValue())) {
		    rtn = false;
		    break;
		}
	    }
	}
	return rtn;
    }

    public static boolean areAllElementsInFloatSet(final Set<Float> SetOne, final Set<Float> SetTwo) {
	boolean rtn = true;
	if ((SetOne == null) && (SetTwo != null)) {
	    rtn = false;
	} else if ((SetOne != null) && (SetTwo == null)) {
	    rtn = true;
	} else if ((SetOne != null) && (SetTwo != null)) {
	    for (final Float temp : SetTwo) {
		if (!SetTools.isInSet(SetOne, temp.floatValue())) {
		    rtn = false;
		    break;
		}
	    }
	}
	return rtn;
    }

    public static boolean areAllElementsInDoubleSet(final Set<Double> SetOne, final Set<Double> SetTwo) {
	boolean rtn = true;
	if ((SetOne == null) && (SetTwo != null)) {
	    rtn = false;
	} else if ((SetOne != null) && (SetTwo == null)) {
	    rtn = true;
	} else if ((SetOne != null) && (SetTwo != null)) {
	    for (final Double temp : SetTwo) {
		if (!SetTools.isInSet(SetOne, temp.doubleValue())) {
		    rtn = false;
		    break;
		}
	    }
	}
	return rtn;
    }

    public static boolean areAllElementsInCharacterSet(final Set<Character> SetOne, final Set<Character> SetTwo) {
	boolean rtn = true;
	if ((SetOne == null) && (SetTwo != null)) {
	    rtn = false;
	} else if ((SetOne != null) && (SetTwo == null)) {
	    rtn = true;
	} else if ((SetOne != null) && (SetTwo != null)) {
	    for (final Character temp : SetTwo) {
		if (!SetTools.isInSet(SetOne, temp.charValue())) {
		    rtn = false;
		    break;
		}
	    }
	}
	return rtn;
    }

    public static boolean areAllElementsInStringSet(final Set<String> SetOne, final Set<String> SetTwo) {
	boolean rtn = true;
	if ((SetOne == null) && (SetTwo != null)) {
	    rtn = false;
	} else if ((SetOne != null) && (SetTwo == null)) {
	    rtn = true;
	} else if ((SetOne != null) && (SetTwo != null)) {
	    for (final String temp : SetTwo) {
		if (!SetTools.isInSet(SetOne, temp)) {
		    rtn = false;
		    break;
		}
	    }
	}
	return rtn;
    }
}
