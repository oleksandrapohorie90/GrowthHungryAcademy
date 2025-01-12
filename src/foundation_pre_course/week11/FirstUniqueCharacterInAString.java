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
    public static void main(String[] args) {
        String s = "leetcode";
        System.out.println(firstUniqChar(s));
    }

    public static int firstUniqChar(String s) {
        //find the frequencies of numbers 1st
        //A fixed-size array freq of length 26 is created to store the frequencies of each letter in the alphabet.
        //Each index in the array corresponds to a letter: 0 → 'a', 1 → 'b', ..., 25 → 'z'.
        //Initially, all values in freq are 0.
        int[] freq = new int[26];

        //count the frequencies
        //The loop iterates over each character c in the string s.
        //c - 'a' computes the index for the character. For example:
        //'a' - 'a' → 0
        //'b' - 'a' → 1
        //'z' - 'a' → 25
        //The frequency of the character c is incremented in the freq array.
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            freq[c - 'a']++;
            //freq[4] = 2  // 'e' appears twice
            //freq[11] = 1 // 'l' appears once: l is 101 and a is 97
            //freq[19] = 1 // 't' appears once
            //freq[2] = 1  // 'c' appears once
            //freq[3] = 1  // 'd' appears once
            //All other entries in freq remain 0.
        }

        //The loop iterates over each character c in the string s again.
        //For each character, it checks if the frequency freq[c - 'a'] is 1.
        //If it finds a character with frequency 1, it returns the current index i.
        //Key Debugging Observations:
        //
        //For "leetcode", the iterations proceed as follows:
        //i = 0, c = 'l': freq[11] = 1 → Returns 0.
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (freq[c - 'a'] == 1) {
                return i;
            }
        }
        return -1;
    }

    public static int firstUniqChar1(String s) {
        int bestIndex = 1000000000;
        for (char c = 'a'; c <= 'z'; c++) {
            //below functions return -1 if char doesn't appear in the string
            int first = s.indexOf(c);
            int last = s.lastIndexOf(c);
            if (first != -1 && first == last) {
                bestIndex = Math.min(bestIndex, first);
            }
        }
        if (bestIndex == 1000000000) bestIndex = -1;
        return bestIndex;
    }

}
