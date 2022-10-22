
package com.gp.common;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Objects;
import java.util.StringTokenizer;

import javax.servlet.ServletInputStream;

public final class StringTools implements java.io.Serializable {

    private static final long serialVersionUID = 1L;
    // private static final Logger LOG = LoggerFactory.getLogger ( StringTools.class
    // ) ;

    private StringTools() {
    }
    
    public static String removeNonAsciiCharacters( final String input )
    {
        String rtn = input.replaceAll("[^\\p{ASCII}]", "");
        return rtn;
    }  

    public static String removeNonUtf8Characters( final String input )
    {
	//public static final String NON_UTF8_REGEXP_CHARACTERS = "[^\\x20-\\x7e]";
        return Objects.toString(input, "").replaceAll(Constants.NON_UTF8_REGEXP_CHARACTERS, "");
    }      
public static void main(String[] args) {
	System.out.println(StringTools.isEmpty(""));
}
    public static boolean isEmpty(final String s) {
	boolean rtn = false;
	if (s == null || s.length() < 1) {
	    rtn = true;
	}
	return rtn;
    }

    public static String addQuotes(final String item) {
	return "\'" + item + "\'";
    }

    public static String removeLineBreaks(final String input) {
	final String in = java.util.Objects.toString(input, "");
	return in.replaceAll("(\\r|\\n)", "");
    }

    public static String replaceAllSpaces(final String input, final String replacement) {
	String rtn = input;
	if (rtn != null) {
	    rtn = rtn.replaceAll(Constants.REG_EXP_SPACES, replacement);
	}
	return rtn;
    }

    public static String removeAllSpaces(final String input) {
	String rtn = input;
	if (rtn != null) {
	    rtn = rtn.replaceAll(Constants.REG_EXP_SPACES, "");
	}
	return rtn;
    }

    public static boolean isStringInArray(final String[] haystack, final String needle) {
	boolean rtn = false;
	if (haystack != null) {
	    for (final String element : haystack) {
		if (element != null && element.equals(needle)) {
		    rtn = true;
		    break;
		}
	    }
	}
	return rtn;
    }

    public static boolean isStringInArrayIgnoreCase(final String[] haystack, final String needle) {
	boolean rtn = false;
	if (haystack != null) {
	    for (final String element : haystack) {
		if (element != null && element.equalsIgnoreCase(needle)) {
		    rtn = true;
		    break;
		}
	    }
	}
	return rtn;
    }

    public static boolean isStringValid(final String item, final String[] validItems) {
	boolean rtn = false;
	final String temp = java.util.Objects.toString(item, "");
	if (validItems == null) {
	    rtn = false;
	} else {
	    for (final String element : validItems) {
		if (java.util.Objects.toString(element, "").equals(temp)) {
		    rtn = true;
		}
	    }
	}
	return rtn;
    }

    public static String getTwoDigitNumber(final int number) {
	final StringBuilder rtn = new StringBuilder();
	if (number < 10) {
	    rtn.append(Constants.ZERO);
	    rtn.append(number);
	} else if (number < 100) {
	    rtn.append(number);
	} else {
	    rtn.append("99");
	}
	return rtn.toString();
    }

    public static String addPrecedingCharacters(final String stringIn, final String preceding_char,
	    final int desired_length) {
	StringBuilder rtn;
	final String in_str = java.util.Objects.toString(stringIn, "");
	if (Objects.toString(preceding_char, "").equals("") || Objects.toString(stringIn, "").equals("")
		|| desired_length < 0) {
	    rtn = new StringBuilder(in_str);
	} else if (in_str.length() >= desired_length) {
	    rtn = new StringBuilder(in_str);
	} else {
	    final int difference = desired_length - stringIn.length();
	    rtn = new StringBuilder();
	    for (int i = 0; i < difference; i++) {
		rtn.append(preceding_char);
	    }
	    rtn.append(in_str);
	}
	return rtn.toString();
    }

    public static String addTrailingCharacters(final String in, final String trailing_char, final int desired_length) {
	StringBuilder rtn = new StringBuilder();
	final String in_str = java.util.Objects.toString(in, "");
	if (Objects.toString(trailing_char, "").equals("") || Objects.toString(in, "").equals("")
		|| desired_length < 0) {
	    rtn = new StringBuilder(in_str);
	} else if (in_str.length() >= desired_length) {
	    rtn = new StringBuilder(in_str);
	} else {
	    final int difference = desired_length - in.length();
	    rtn = new StringBuilder(in_str);
	    for (int i = 0; i < difference; i++) {
		rtn.append(trailing_char);
	    }
	}
	return rtn.toString();
    }

//    public static String formatDecimal(final double in, final int prepad, final int numberOfDecimals) {
//	StringBuilder rtn = new StringBuilder();
//	final String in_str = Double.toString(in);
//	final int decimal_index = in_str.indexOf(Constants.PERIOD);
//	if (decimal_index < 0) {
//	    rtn = new StringBuilder(in_str);
//	} else if (decimal_index == 0) {
//	    rtn.append(StringTools.padInt(0, prepad));
//	    rtn.append(".");
//	    String decimals = in_str.substring(decimal_index, in_str.length());
//	    if (decimals.length() > numberOfDecimals) {
//		decimals = decimals.substring(0, numberOfDecimals);
//	    } else {
//		decimals = StringTools.addTrailingCharacters(decimals, Character.toString(Constants.ZERO),
//			numberOfDecimals);
//	    }
//	} else
//	// (decimal_index>0)
//	{
//	    String numbers = in_str.substring(0, decimal_index);
//	    if (numbers.length() > prepad) {
//		numbers = numbers.substring(0, prepad);
//	    } else {
//		numbers = StringTools.addPrecedingCharacters(numbers, Character.toString(Constants.ZERO), prepad);
//	    }
//	    rtn.append(numbers);
//	    rtn.append(".");
//	    String decimals = in_str.substring(decimal_index + 1, in_str.length());
//	    if (decimals.length() > numberOfDecimals) {
//		decimals = decimals.substring(0, numberOfDecimals);
//	    } else {
//		decimals = StringTools.addTrailingCharacters(decimals, Character.toString(Constants.ZERO),
//			numberOfDecimals);
//	    }
//	    rtn.append(decimals);
//	}
//	return rtn.toString();
//    }

    public static String getFirstLetterUpperString(final String s) {
	return StringTools.getStringFirstLetterUpper(s);
    }

    public static String getStringFirstLetterUpper(final String s) {
	String rtn = "";
	if (s == null || s.length() < 1) {
	    rtn = "";
	} else {
	    rtn = s.substring(0, 1).toUpperCase() + s.substring(1, s.length()).toLowerCase();
	}
	return rtn;
    }

    public static String getStringFirstLetterLowerCase(final String s) {
	String rtn = "";
	if (s == null || s.length() < 1) {
	    rtn = "";
	} else {
	    rtn = s.substring(0, 1).toLowerCase() + s.substring(1, s.length());
	}
	return rtn;
    }

    public static String getStringFirstLetterUpperCase(final String s) {
	String rtn = "";
	if (s == null || s.length() < 1) {
	    rtn = "";
	} else {
	    rtn = s.substring(0, 1).toUpperCase() + s.substring(1, s.length());
	}
	return rtn;
    }

    // returns 1 if a is larger 2 if b is larger and 0 if equal
    public static int largerString(final String a, final String b) {
	int count = 0;
	int answer = -2;
	if (a == null || b == null) {
	    answer = 0;
	} else {
	    boolean done = false;
	    final String c = a.toLowerCase(Constants.DEFAULT_LOCALE);
	    final String d = b.toLowerCase(Constants.DEFAULT_LOCALE);
	    final int lengthC = c.length();
	    final int lengthD = d.length();
	    while (!done && count < lengthC && count < lengthD) {
		if (c.charAt(count) > d.charAt(count)) {
		    answer = 1;
		    done = true;
		} else if (c.charAt(count) < d.charAt(count)) {
		    answer = 2;
		    done = true;
		}
		count++;
	    }
	    if (!done) {
		if (lengthC > lengthD) {
		    answer = 1;
		} else if (lengthC < lengthD) {
		    answer = 2;
		} else {
		    answer = 0;
		}
	    }
	}
	return answer;
    }

    public static String padInt(final long num, final int pad) {
	long j = num;
	final boolean negative = num < 0 ? true : false;
	if (num < 0) {
	    j = j * -1;
	}
	final StringBuilder rtn = new StringBuilder();
	final String temp = String.valueOf(j);
	for (int i = temp.length(); i < pad; i++) {
	    rtn.append(Constants.ZERO);
	}
	rtn.append(temp);
	return negative ? "-" + rtn.toString() : rtn.toString();
    }

    public static String padInt(final int num, final int pad) {
	int j = num;
	final boolean negative = num < 0 ? true : false;
	if (num < 0) {
	    j = j * -1;
	}
	final StringBuilder rtn = new StringBuilder();
	final String temp = String.valueOf(j);
	for (int i = temp.length(); i < pad; i++) {
	    rtn.append(Constants.ZERO);
	}
	rtn.append(temp);
	return negative ? "-" + rtn.toString() : rtn.toString();
    }  

    public static String padlong(final long num, final int pad) {
	long j = num;
	final boolean negative = num < 0 ? true : false;
	if (num < 0) {
	    j = j * -1;
	}
	final StringBuilder rtn = new StringBuilder();
	final String temp = String.valueOf(j);
	for (int i = temp.length(); i < pad; i++) {
	    rtn.append(Constants.ZERO);
	}
	rtn.append(temp);
	return negative ? "-" + rtn.toString() : rtn.toString();
    }

    public static String padStringWithZerosDouble(final Integer str) {
	return StringTools.padString(String.valueOf(str), 2, String.valueOf(Constants.ZERO));
    }

    public static String padStringWithZerosTriple(final Integer str) {
	return StringTools.padString(String.valueOf(str), 3, String.valueOf(Constants.ZERO));
    }

    public static String padStringWithZerosTriple(final Long str) {
	return StringTools.padString(String.valueOf(str), 3, String.valueOf(Constants.ZERO));
    }

    public static String padStringWithZerosDouble(final int str) {
	return StringTools.padString(String.valueOf(str), 2, String.valueOf(Constants.ZERO));
    }

    public static String padStringWithZerosDouble(final Long str) {
	return StringTools.padString(String.valueOf(str), 2, String.valueOf(Constants.ZERO));
    }

    public static String padStringWithZerosTriple(final int str) {
	return StringTools.padString(String.valueOf(str), 3, String.valueOf(Constants.ZERO));
    }

    public static String padStringWithZerosDouble(final String str) {
	return StringTools.padString(str, 2, String.valueOf(Constants.ZERO));
    }

    public static String padStringWithZerosTriple(final String str) {
	return StringTools.padString(str, 3, String.valueOf(Constants.ZERO));
    }

    public static String postPadString(final String str, final int pad, final String pad_str) {
	final StringBuilder temp = new StringBuilder(java.util.Objects.toString(str, ""));
	final int to_go = pad - temp.length();
	if (to_go > 0) {
	    for (int i = 0; i < to_go; i++) {
		temp.insert(temp.length(), pad_str);
		// temp = pad_str + temp ;
	    }
	}
	return temp.toString();
    }

    public static String postPadStringWithZeros(final String str, final int pad) {
	return StringTools.postPadString(str, pad, String.valueOf(Constants.ZERO));
    }

    public static String padStringWithZeros(final String str, final int pad) {
	return StringTools.padString(str, pad, String.valueOf(Constants.ZERO));
    }

    public static String padString(final String str, final int pad, final String pad_str) {
	final StringBuilder temp = new StringBuilder(java.util.Objects.toString(str, ""));
	final int to_go = pad - temp.length();
	if (to_go > 0) {
	    for (int i = 0; i < to_go; i++) {
		temp.insert(0, pad_str);
		// temp = pad_str + temp ;
	    }
	}
	return temp.toString();
    }

    public static String removeNonHexCharacters(final String in) {
	final String temp = java.util.Objects.toString(in, "");
	final StringBuilder temp2 = new StringBuilder();
	boolean found = false;
	for (int i = 0; i < temp.length(); i++) {
	    found = false;
	    for (final char ch : Constants.HEX_CHARACTERS.toCharArray()) {
		if (ch == temp.charAt(i)) {
		    found = true;
		    break;
		}
	    }
	    if (found) {
		temp2.append(temp.charAt(i));
	    }
	}
	return temp2.toString();
    }

    public static int countOfCharacterInString(final char ch, final String s) {
	int rtn = 0;
	if (s!=null) 
	{
    	  for (int i = 0; i < s.length(); i++) 
    	  {
    	    if (s.charAt(i) == ch) 
    	    {
    		  rtn++;
    	    }
    	  }
	}
	return rtn;
    }

    public static String arrayToString(final String s[], final String sep) {
	int k;
	StringBuilder result = new StringBuilder();
	k = s.length;
	if (k > 0) {
	    result = new StringBuilder(s[0]);
	    for (int i = 1; i < k; i++) {
		result.append(sep);
		result.append(s[i]);
	    }
	}
	return result.toString();
    }

    public static String twoDimensionalStringArrayToString(final String[][] in, final String newline) {
	final StringBuilder rtn = new StringBuilder();
	if (in != null) {
	    final int size = in.length;
	    for (int i = 0; i < size; i++) {
		final int sub_size = in[i].length;
		for (int j = 0; j < sub_size; j++) {
		    rtn.append("[" + i + "][" + j + "] = " + in[i][j] + newline);
		}
	    }
	}
	return rtn.toString();
    }

    public static String truncateString(final String truncateThis, final int maxLength) {
	String rtn = java.util.Objects.toString(truncateThis, "");
	if (truncateThis.length() > maxLength) {
	    rtn = truncateThis.substring(0, maxLength);
	}
	return rtn;
    }

    public static boolean doesStringHaveData(final String s) {
	boolean rtn = false;
	if (s != null && s.length() > 0 && !s.equalsIgnoreCase("null")) {
	    rtn = true;
	}
	return rtn;
    }

    public static boolean isEmptyOrNull(final String s) {
	return !StringTools.doesStringHaveData(s);
    }

    public static int countAppearances(final String line, final char item) {
	int count = 0;
	final String temp = java.util.Objects.toString(line, "");
	for (int i = 0; i < temp.length(); i++) {
	    if (temp.charAt(i) == item) {
		count++;
	    }
	}
	return count;
    }

    public static String removeFromString(final String input, final char[] removals) {
	final StringBuilder rtn = new StringBuilder();
	final String temp = java.util.Objects.toString(input, "");
	for (int i = 0; i < input.length(); i++) {
	    if (!CharacterTools.isCharInArray(temp.charAt(i), removals)) {
		rtn.append(temp.charAt(i));
	    }
	}
	return rtn.toString();
    }

    public static String trimStringToLength(final String input, final int length) {
	String rtn = java.util.Objects.toString(input, "");
	if (input.length() > length) {
	    rtn = rtn.substring(0, length);
	}
	return rtn;
    }

    public static String trimStringToLengthUpper(final String input, final int length) {
	String rtn = java.util.Objects.toString(input, "");
	if (input.length() > length) {
	    rtn = rtn.substring(0, length);
	}
	return rtn.toUpperCase(Constants.DEFAULT_LOCALE);
    }

    public static String trimStringToLengthLower(final String input, final int length) {
	String rtn = java.util.Objects.toString(input, "");
	if (input.length() > length) {
	    rtn = rtn.substring(0, length);
	}
	return rtn.toLowerCase(Constants.DEFAULT_LOCALE);
    }

    public static void appendListToStringBuilder(final StringBuilder sb, final List<?> list, final String separator) {
	if (list == null) {
	    sb.append("null");
	    return;
	}
	boolean first = true;
	for (final Object o : list) {
	    if (first) {
		first = false;
	    } else {
		sb.append(separator);
	    }
	    sb.append(o);
	}
    }

    public static String readFileAsString(final String filePath, final int bufferSize) throws java.io.IOException {
	InputStream is = null;
	BufferedInputStream bis = null;
	BufferedReader r = null;
	final StringBuilder fileData = new StringBuilder();

	is = new FileInputStream(filePath);
	bis = new BufferedInputStream(is);
	r = new BufferedReader(new InputStreamReader(bis, java.nio.charset.StandardCharsets.UTF_8));

	final char[] buf = new char[bufferSize];
	int numRead = 0;
	try {
	    while ((numRead = r.read(buf)) != -1) {
		fileData.append(buf, 0, numRead);
	    }
	} finally {
	    try {
		is.close();
	    } catch (final Exception e) {
	    }
	    try {
		bis.close();
	    } catch (final Exception e) {
	    }
	    try {
		r.close();
	    } catch (final Exception e) {
	    }
	}
	return fileData.toString();
    }

    public static boolean containsNumber(final String input) {
	return StringTools.doesStringHaveData(input)?input.matches(".*\\d+.*"):false;
    }

    public static boolean isValidInteger(final String testString) {
	boolean rtn = false;
	if (StringTools.isEmptyOrNull(testString)) {
	    rtn = false;
	} else {
	    try {
		Integer.parseInt(testString);
		rtn = true;
	    } catch (final NumberFormatException ne) {
		rtn = false;
	    }
	}
	return rtn;
    }

    public static String getContentFromStream(final InputStream sis) throws IOException {
	String rtn = "";
	if (sis != null) {
	    final BufferedReader reader = new BufferedReader(
		    new InputStreamReader(sis, java.nio.charset.StandardCharsets.UTF_8));
	    final StringBuilder buf2 = new StringBuilder();
	    final char[] cbuf2 = new char[2048];
	    int num2;
	    while (-1 != (num2 = reader.read(cbuf2))) {
		buf2.append(cbuf2, 0, num2);
	    }
	    rtn = buf2.toString();
	}
	return rtn;
    }

    public static String getContentFromStream(final ServletInputStream sis) throws IOException {
	String rtn = "";
	if (sis != null) {
	    final BufferedReader reader = new BufferedReader(
		    new InputStreamReader(sis, java.nio.charset.StandardCharsets.UTF_8));
	    final StringBuilder buf2 = new StringBuilder();
	    final char[] cbuf2 = new char[2048];
	    int num2;
	    while (-1 != (num2 = reader.read(cbuf2))) {
		buf2.append(cbuf2, 0, num2);
	    }
	    rtn = buf2.toString();
	}
	return rtn;
    }

    public static String stripHiphens( final String tsn )
    {
        String rtn = "";
        if (StringTools.doesStringHaveData(tsn))
        {
            final StringTokenizer tokenizer = new StringTokenizer(tsn, "-");
            final StringBuffer result = new StringBuffer();
            while (tokenizer.hasMoreTokens())
            {
                result.append(tokenizer.nextToken());
            }
            rtn = result.toString();
        }
        return rtn;
    }

    public static String stringListToCommaString(final List<String> codes) {
	final StringBuilder strbldr = new StringBuilder();
	if (codes != null) {
	    for (final String code : codes) {
		if (code != null && code.length() > 0) {
		    strbldr.append(code);
		    strbldr.append(",");
		}
	    }
	    if (strbldr.length() > 0) // remove last ','
	    {
		strbldr.setLength(strbldr.length() - 1);
	    }
	}
	return strbldr.toString();
    }

    public static String removeEnd(final String str, final String remove) {
	if (StringTools.isEmpty(str) || StringTools.isEmpty(remove)) {
	    return str;
	}
	if (str.endsWith(remove)) {
	    return str.substring(0, str.length() - remove.length());
	}
	return str;
    }

    public String returnFileAsStringWithoutLinebreaks(final String filename) throws Exception {
	return StringTools.removeLineBreaks(StringTools.readFileAsString(filename, 500));
    }

    /*
    public static boolean isValidPrice(final String price) {
	boolean isValid = false;
	if (!StringTools.isEmptyOrNull(price)) {
	    final StringTokenizer tokenizer = new StringTokenizer(price, ".");
	    int tokenCount = 0;
	    String myCurrency = null;
	    String myPrice = null;
	    if (tokenizer.countTokens() != 2) {
		isValid = false;
	    } else {
		while (tokenizer.hasMoreTokens()) {
		    if (tokenCount == 0) {
			myCurrency = tokenizer.nextToken();
		    }
		    if (tokenCount == 1) {
			myPrice = tokenizer.nextToken();
		    }
		    tokenCount++;
		}
		if (myCurrency != null && "USD".equals(myCurrency)
			&& myPrice != null && StringTools.isValidInteger(myPrice)) {
		    isValid = true;
		}
	    }
	}
	return isValid;
    }
    */
    
    public static boolean isValidPrice(final String price) {
          boolean isValid = false;
          final String priceRegularExp = "([$]||[U][S][D])((\\d{1,4})(((\\.)(\\d{0,2})){0,1}))([$]||[U][S][D])";
          if (StringTools.doesStringHaveData(price)) {
               if (price.matches(priceRegularExp)) {
                    isValid = true;
               }
          }
          return isValid;
     }    

    public static String combineStrings(final String... args) {
	final StringBuilder rtn = new StringBuilder();
	if (args != null) {
	    for (final String s : args) {
		rtn.append(s);
	    }
	}
	return rtn.toString();
    }

    public static String combineStringFromObjects(final Object... args) {
	final StringBuilder rtn = new StringBuilder();
	if (args != null) {
	    for (final Object obj : args) {
		rtn.append(obj.toString());
	    }
	}
	return rtn.toString();
    }

    /*
     * public static String objectToString( Object object ) { String rtn = ""; //
     * Check for null if ( object != null ) { // Lambda for field value retrieval
     * StringFunctionalInterface objectToString = ( String _fieldName ) -> { String
     * ret = null; String fieldName = _fieldName; Object methodReturnObject = null;
     * final String NO_SUCH_METHOD_EXISTS = "no such method exists"; final String
     * SECURITY_VIOLATION = "security violation"; final String
     * NO_PERMISSION_TO_ACCESS = "no permission to access";
     * 
     * fieldName = fieldName.substring( 0 , 1 ).toUpperCase() + fieldName.substring(
     * 1 ); try { Method method = object.getClass().getMethod( "get" + fieldName );
     * methodReturnObject = method.invoke( object ); if ( methodReturnObject == null
     * ) { ret = String.join( "=" , fieldName , null ); } else { ret = String.join(
     * "=" , fieldName , methodReturnObject.toString() ); } } catch (
     * NoSuchMethodException | SecurityException | IllegalAccessException |
     * IllegalArgumentException | InvocationTargetException e ) { if ( e instanceof
     * NoSuchMethodException ) { ret = String.join( ": " , e.getMessage() ,
     * NO_SUCH_METHOD_EXISTS ); } else if ( e instanceof SecurityException ) { ret =
     * String.join( ": " , e.getMessage() , SECURITY_VIOLATION ); } else if ( e
     * instanceof IllegalAccessException ) { ret = String.join( ": " ,
     * e.getMessage() , NO_PERMISSION_TO_ACCESS ); } else { ret = e.getMessage(); }
     * } return ret; };
     * 
     * // Iterate all fields and return formatted toString of object. Field[] fields
     * = object.getClass().getDeclaredFields(); StringJoiner stringJoiner = new
     * StringJoiner( "," , "[" , "]" ); Stream.of( fields ).map( Field::getName )
     * .filter( w -> !w.equalsIgnoreCase( "serialVersionUID" ) ) .map( ( String w )
     * -> objectToString.function( w ) ).forEach( a -> stringJoiner.add( a ) ); rtn
     * = stringJoiner.toString(); } return rtn; }
     */
    
   
}
