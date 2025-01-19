package foundation_pre_course.week13;

import java.util.HashSet;

public class LongestPalindrome {
    //odd palindrome or even palindrome

    /*
    Given a string s which consists of lowercase or uppercase letters, return the length of the longest
palindrome
 that can be built with those letters.

Letters are case sensitive, for example, "Aa" is not considered a palindrome.

Example 1:

Input: s = "abccccdd"
Output: 7
Explanation: One longest palindrome that can be built is "dccaccd", whose length is 7.
Example 2:

Input: s = "a"
Output: 1
Explanation: The longest palindrome that can be built is "a", whose length is 1.
     */

    //A palindrome is a sequence of characters that reads the same backward as forward, such as "madam" or "racecar". In the context of your provided Java method
    public int longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        HashSet<Character> hash_set = new HashSet<Character>();
        //it will be the longest palindrome length
        int palindrome_length = 0;

        //iterate over the characters in the 's' string
        for (char ch : s.toCharArray()) {
            //for each ch we will check if its already in the hashset
            if (hash_set.contains(ch)) {
                //if it IS, THEN we
                // Found a pair of characters `ch`,
                // increase the palindrome_length by 2
                // and remove `ch` from hash set.
                hash_set.remove(ch);
                palindrome_length += 2;
            } else {
                // Character `ch` doesn't have a pair yet,
                // so put it in the hash set for now.
                hash_set.add(ch);
            }
        }
        // If hash set is not empty, it means there are
        // characters which we couldn't pair. We can use
        // one of them – put in the center of our palindrome.
        //see example: Input: s = "abccccdd"
        //Output: 7
        //Explanation: One longest palindrome that can be built is "dccaccd", whose length is 7.

        //After processing all characters, if the hash_set is not empty, it means there are characters with an odd count remaining. In a palindrome, you can have at most one character with an odd count placed in the center. Therefore, if such characters exist, we add 1 to the palindrome_length.
        if (!hash_set.isEmpty()) {
            palindrome_length++;
        }
        return palindrome_length;
    }
}
