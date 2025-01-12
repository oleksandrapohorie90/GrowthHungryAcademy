package foundation_pre_course.week11;

public class FirstUniqueCharacterInAString {
    /*
    Given a string s, find the first non-repeating character in it and return its index. If it does not exist, return -1.

Example 1:

Input: s = "leetcode"

Output: 0

Explanation:

The character 'l' at index 0 is the first character that does not occur at any other index.
LEFTMOST IN THE STRING AND APPEARS ONLY ONCE
     */
    //WAY FROM JAVA SESSION 1 FOR COUNT/FIND THE FREQUENCIES
    public int firstUniqChar(String s) {

        //find the frequencies 1st
        int[] freq = new int[26];

        //count the frequencies
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            freq[c - 'a']++;
        }

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (freq[c - 'a'] == 1) {
                return i;
            }
        }
        return -1;
    }

}
