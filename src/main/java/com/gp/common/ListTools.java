
package com.gp.common;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public final class ListTools implements java.io.Serializable {

    private static final long serialVersionUID = 1L;

    private ListTools() {
    }

    public static void removeAllElementsFromList(final List<?> list) {
	if (list != null) {
	    // Object obj = null ;
	    while (!list.isEmpty()) {
		// obj = list.get ( 0 ) ;
		// obj = null ;
		list.remove(0);
	    }
	}
    }

    public static <E> void swap(final List<E> a, final int i, final int j) {
	final E tmp = a.get(i);
	a.set(i, a.get(j));
	a.set(j, tmp);
    }

    public static boolean isListEmpty(final List<?> lst) {
	boolean rtn = false;
	if (lst == null) {
	    rtn = true;
	} else if (lst.size() < 1) {
	    rtn = true;
	}
	return rtn;
    }

    public static boolean isListNotEmpty(final List<?> lst) {
	return !ListTools.isListEmpty(lst);
    }

    public static <E> List<E> checkListForNull(final List<E> mylist) {
	return ListTools.checkListForNullCreateLinkedList(mylist);
    }

    public static <E> List<E> checkListForNullCreateLinkedList(final List<E> mylist) {
	List<E> tmp = mylist;
	if (tmp == null) {
	    tmp = new LinkedList<>();
	}
	return tmp;
    }

    public static <E> List<E> checkListForNullCreateArrayList(final List<E> mylist) {
	List<E> tmp = mylist;
	if (tmp == null) {
	    tmp = new ArrayList<>();
	}
	return tmp;
    }

    public static void clearList(final List<?> mylist) {
	try {
	    if (mylist != null) {
		mylist.clear();
	    }
	} catch (final Exception e) {
	    // catch exception
	}
    }

    public static <T> List<T> copyStringList(final List<T> in) {
	final List<T> rtn = new LinkedList<>();
	for (int i = 0; i < in.size(); i++) {
	    rtn.add(in.get(i));
	}
	return rtn;
    }

    public static <T> List<T> copyStringListSkipFirst(final int numberToSkip, final List<T> in) {
	final List<T> rtn = new LinkedList<>();
	for (int i = numberToSkip; i < in.size(); i++) {
	    rtn.add(in.get(i));
	}
	return rtn;
    }

    protected static <T> List<T> merge(final List<T> listOne, final List<T> listTwo) {
	final List<T> rtn = new LinkedList<>();
	if (listOne != null) {
	    for (final T item : listOne) {
		rtn.add(item);
	    }
	}
	if (listTwo != null) {
	    for (final T item : listTwo) {
		rtn.add(item);
	    }
	}
	return rtn;
    }

    public static boolean isInList(final List<Long> mylist, final long item) {
	boolean rtn = false;
	if (mylist != null) {
	    for (final Long temp : mylist) {
		if (temp.longValue() == item) {
		    rtn = true;
		}
	    }
	}
	return rtn;
    }

    public static boolean isInList(final List<Integer> mylist, final int item) {
	boolean rtn = false;
	if (mylist != null) {
	    for (final Integer temp : mylist) {
		if (temp.intValue() == item) {
		    rtn = true;
		}
	    }
	}
	return rtn;
    }

    public static boolean isInList(final List<Float> mylist, final float item) {
	boolean rtn = false;
	if (mylist != null) {
	    for (final Float temp : mylist) {
		if (temp.floatValue() == item) {
		    rtn = true;
		}
	    }
	}
	return rtn;
    }

    public static boolean isInList(final List<Double> mylist, final double item) {
	boolean rtn = false;
	if (mylist != null) {
	    for (final Double temp : mylist) {
		if (temp.doubleValue() == item) {
		    rtn = true;
		}
	    }
	}
	return rtn;
    }

    public static boolean isInList(final List<Character> mylist, final char item) {
	boolean rtn = false;
	if (mylist != null) {
	    for (final Character temp : mylist) {
		if (temp.charValue() == item) {
		    rtn = true;
		}
	    }
	}
	return rtn;
    }

    public static boolean isInList(final List<String> mylist, final String item) {
	boolean rtn = false;
	if (mylist != null) {
	    for (final String temp : mylist) {
		if (temp.equals(item)) {
		    rtn = true;
		}
	    }
	}
	return rtn;
    }

    public static boolean isInListIgnoreCase(final List<String> mylist, final String item) {
	boolean rtn = false;
	if (mylist != null) {
	    for (final String temp : mylist) {
		if (temp.equals(item)) {
		    rtn = true;
		}
	    }
	}
	return rtn;
    }

    public static boolean areAllElementsInLongList(final List<Long> listOne, final List<Long> listTwo) {
	boolean rtn = true;
	if ((listOne == null) && (listTwo != null)) {
	    rtn = false;
	} else if ((listOne != null) && (listTwo == null)) {
	    rtn = true;
	} else if ((listOne != null) && (listTwo != null)) {
	    for (final Long temp : listTwo) {
		if (!ListTools.isInList(listOne, temp.longValue())) {
		    rtn = false;
		    break;
		}
	    }
	}
	return rtn;
    }

    public static boolean areAllElementsInIntegerList(final List<Integer> listOne, final List<Integer> listTwo) {
	boolean rtn = true;
	if ((listOne == null) && (listTwo != null)) {
	    rtn = false;
	} else if ((listOne != null) && (listTwo == null)) {
	    rtn = true;
	} else if ((listOne != null) && (listTwo != null)) {
	    for (final Integer temp : listTwo) {
		if (!ListTools.isInList(listOne, temp.intValue())) {
		    rtn = false;
		    break;
		}
	    }
	}
	return rtn;
    }

    public static boolean areAllElementsInFloatList(final List<Float> listOne, final List<Float> listTwo) {
	boolean rtn = true;
	if ((listOne == null) && (listTwo != null)) {
	    rtn = false;
	} else if ((listOne != null) && (listTwo == null)) {
	    rtn = true;
	} else if ((listOne != null) && (listTwo != null)) {
	    for (final Float temp : listTwo) {
		if (!ListTools.isInList(listOne, temp.floatValue())) {
		    rtn = false;
		    break;
		}
	    }
	}
	return rtn;
    }

    public static boolean areAllElementsInDoubleList(final List<Double> listOne, final List<Double> listTwo) {
	boolean rtn = true;
	if ((listOne == null) && (listTwo != null)) {
	    rtn = false;
	} else if ((listOne != null) && (listTwo == null)) {
	    rtn = true;
	} else if ((listOne != null) && (listTwo != null)) {
	    for (final Double temp : listTwo) {
		if (!ListTools.isInList(listOne, temp.doubleValue())) {
		    rtn = false;
		    break;
		}
	    }
	}
	return rtn;
    }

    public static boolean areAllElementsInCharacterList(final List<Character> listOne, final List<Character> listTwo) {
	boolean rtn = true;
	if ((listOne == null) && (listTwo != null)) {
	    rtn = false;
	} else if ((listOne != null) && (listTwo == null)) {
	    rtn = true;
	} else if ((listOne != null) && (listTwo != null)) {
	    for (final Character temp : listTwo) {
		if (!ListTools.isInList(listOne, temp.charValue())) {
		    rtn = false;
		    break;
		}
	    }
	}
	return rtn;
    }

    public static boolean areAllElementsInStringList(final List<String> listOne, final List<String> listTwo) {
	boolean rtn = true;
	if ((listOne == null) && (listTwo != null)) {
	    rtn = false;
	} else if ((listOne != null) && (listTwo == null)) {
	    rtn = true;
	} else if ((listOne != null) && (listTwo != null)) {
	    for (final String temp : listTwo) {
		if (!ListTools.isInList(listOne, temp)) {
		    rtn = false;
		    break;
		}
	    }
	}
	return rtn;
    }
}
