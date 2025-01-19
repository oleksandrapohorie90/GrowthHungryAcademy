package foundation_pre_course.week12;

public class LongestCommonPrefix {
    /* LCP problem
    Write a function to find the longest common prefix string amongst an array of strings.

If there is no common prefix, return an empty string "".

Example 1:

Input: strs = ["flower","flow","flight"]
Output: "fl"
Example 2:

Input: strs = ["dog","racecar","car"]
Output: ""
Explanation: There is no common prefix among the input strings.
     */
    public String longestCommonPrefix2(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        // Initialize 'prefix' with the longest possible prefix.
        // 'prefix' cannot be longer than any of the strings, so
        // simply initialize it with strs[0].
        String prefix = strs[0];

        // Iterate over all strings.
        for (int i = 1; i < strs.length; i++) {
            // Until 'prefix' is not a prefix of the current string,
            // reduce 'prefix' by one character and try to match again.
            while (strs[i].indexOf(prefix) != 0) {
                // Removing the last character from 'prefix'.
                prefix = prefix.substring(0, prefix.length() - 1);
            }
        }
        // Return found 'prefix' as it is a prefix of all strings in the list.
        return prefix;
    }

    public static void main(String[] args) {
        String[] strings = {"flower", "flow", "flight"};
        System.out.println(longestCommonPrefix(strings));
    }

    public static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }

        //init 'prefix' w/ the longest possible prefix.
        //prefix cant be longer than any of the strings so simply init it with strs[0]
        String prefix = strs[0];
        //iterate over all strings
        for (int i = 1; i < strs.length; i++) {
            //until prefix is not a prefix of the current string, reduce prefix by 1 character and try match again
            while (strs[i].indexOf(prefix) != 0) { //Returns the index within this string of the first occurrence of the specified substring.

                //removing the last character from 'prefix'
                prefix = prefix.substring(0, prefix.length() - 1);
            }
        }
        //return found 'prefix' as it is a prefix of all strings in the lest
        return prefix;
        /**
         * 1. Initial State
         *
         * prefix = "flower"
         * 2. Compare with Second String (strs[1] = "flow"):
         *
         * "flow".indexOf("flower") → -1 (prefix is not found at the start of "flow").
         * Shorten the prefix:
         * "flower" → "flowe"
         * "flowe" → "flow"
         * Now "flow".indexOf("flow") == 0. Prefix matches "flow".
         * 3. Compare with Third String (strs[2] = "flight"):
         *
         * "flight".indexOf("flow") → -1 (prefix is not found at the start of "flight").
         * Shorten the prefix:
         * "flow" → "flo"
         * "flo" → "fl"
         * Now "flight".indexOf("fl") == 0. Prefix matches "fl".
         * 4. Final State
         *
         * prefix = "fl"
         * Output:
         * Return "fl" as the longest common prefix.
         */
    }
}

