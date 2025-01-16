package foundation_pre_course.week13;

import java.util.HashSet;

public class LongestPalindrome {
    //off palindrome or even palindrome

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
    public int longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        HashSet<Character> hash_set = new HashSet<Character>();
        int palindrome_length = 0;
        for (char ch : s.toCharArray()) {
            if (hash_set.contains(ch)) {
                hash_set.remove(ch);
                palindrome_length += 2;
            } else {
                hash_set.add(ch);
            }

        }
        if (!hash_set.isEmpty()) {
            palindrome_length++;
        }
        return palindrome_length;
    }
}
