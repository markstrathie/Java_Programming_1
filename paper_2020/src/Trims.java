public class Trims {
	
/* Removes whitespace at the beginning of a string */
	public static String leftTrim (String s) {
		int i = 0;
		while (i < s.length() && Character.isWhitespace(s.charAt(i))) {
			i++;
		}
		return s.substring(i);
	}

 /* Removes whitespace at the end of a string */
	public static String rightTrim (String s) {
		int i = s.length() - 1;
		while (i > 0 && Character.isWhitespace(s.charAt(i))) {
			i--;
		}
		return s.substring(0, i + 1);
	}

	public static void main (String[] args) {
		System.out.println(leftTrim(rightTrim("          Trim me                ")));
	}
 }