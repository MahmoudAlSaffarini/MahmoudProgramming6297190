package org.Mahmoud;

public class Util {
    /**
     * Converts each word in a string to title case.
     * @param str the input string to be converted.
     * @return the string to be converted to title case (first letter uppercase, rest lowercase).
     */
    public static String toTitleCase(String str) {
        if (str == null || str.isEmpty()) {
            return str;
        }

        String[] words = str.split(" ");
        String result = "";

        for (String word : words) {
            if (!word.isEmpty()) {
                String firstWord = word.substring(0, 1).toUpperCase();
                String rest = word.substring(1).toLowerCase();

                result += (firstWord + rest + " ");
            }
        }
        return result.trim();
    }
}
