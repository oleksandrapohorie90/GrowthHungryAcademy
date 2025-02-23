package data_structures_and_algorithms_CS210.Second_Cohort.week5_twoPointers_slidingWindow;

public class StringCompression {
    /**
     * Given an array of characters chars, compress it using the following algorithm:
     * <p>
     * Begin with an empty string s. For each group of consecutive repeating characters in chars:
     * <p>
     * If the group's length is 1, append the character to s.
     * Otherwise, append the character followed by the group's length.
     * The compressed string s should not be returned separately, but instead, be stored in the input character array chars. Note that group lengths that are 10 or longer will be split into multiple characters in chars.
     * <p>
     * After you are done modifying the input array, return the new length of the array.
     * <p>
     * You must write an algorithm that uses only constant extra space.
     * Example 1:
     * <p>
     * Input: chars = ["a","a","b","b","c","c","c"]
     * Output: Return 6, and the first 6 characters of the input array should be: ["a","2","b","2","c","3"]
     * Explanation: The groups are "aa", "bb", and "ccc". This compresses to "a2b2c3".
     * Example 2:
     * <p>
     * Input: chars = ["a"]
     * Output: Return 1, and the first character of the input array should be: ["a"]
     * Explanation: The only group is "a", which remains uncompressed since it's a single character.
     * Example 3:
     * <p>
     * Input: chars = ["a","b","b","b","b","b","b","b","b","b","b","b","b"]
     * Output: Return 4, and the first 4 characters of the input array should be: ["a","b","1","2"].
     * Explanation: The groups are "a" and "bbbbbbbbbbbb". This compresses to "ab12".
     */

    public static void main(String[] args) {

        char[] chars = {'a', 'a', 'b', 'b', 'c', 'c', 'c'};
        compress(chars);
    }

    public static int compress(char[] chars) {
        //analyze string streak by streak, bc each char form a streak of 1 or more chars

        int n = chars.length;
        //a pointer that starts at the beginning of chars array, points at the beginning of the next streak
        int streakStart = 0;
        //a pointer to where I will be writing my answer, we should be modifying the input array chars, we shouldnt create a new one, so I will directly override the chars array starting from index 0
        //if I have "a","a" -> I will override with ["a", "2"]
        int indexAnswer = 0;

        //I iterate till streakStart is less than chars length
        while (streakStart < n) {
            char streakChar = chars[streakStart];

            //for now it will be the start too
            int strealEnd = streakStart;
            //i have 1 char only at position streakStart
            int count = 1;

            //i want to increase my streak by 1 if its the same as streakChar
            while (strealEnd + 1 < n && chars[strealEnd + 1] == streakChar) {
                strealEnd++;
                count++; //I want to count how many (same)chars there in this streak
            }

            chars[indexAnswer] = streakChar;
            indexAnswer++; //increment so I can start writing the count, or if count ==1 then i just skip below part and indexAnswer just points where the next char should be

            if (count > 1) {
                //then i Convert my count into a String and then into a char arr
                char[] countAsChars = Integer.toString(count).toCharArray();
                //iterate over this digits
                //I write into index answer and increment
                for (char digit : countAsChars) {
                    chars[indexAnswer] = digit;
                    indexAnswer++;
                }
                //at the end streakStart assign to streakEnd+1
            }
            streakStart = strealEnd + 1;
        }
        return indexAnswer;

    }
}


/**
 * int n = chars.length;
 * <p>
 * int streakStart = 0;
 * int indexAnswer = 0;
 * while (streakStart < n) {
 * // Current streak starts with chars[streakStart]
 * char streakChar = chars[streakStart];
 * <p>
 * // Count how many consecutive streakChar-s there are in this streak.
 * // streakStart and streakEnd are the two pointers. This is a common technique.
 * int streakEnd = streakStart;
 * int count = 1;
 * while (streakEnd + 1 < n && chars[streakEnd + 1] == streakChar) {
 * streakEnd++;
 * count++;
 * }
 * <p>
 * // if count == 1 ~> then we should write in `chars` just the `streakChar`
 * // else ~> then we should write in `chars` the `streakChar` followed by the integer `count` as characters
 * chars[indexAnswer] = streakChar;
 * indexAnswer++;
 * <p>
 * if (count > 1) {
 * char[] countAsChars = Integer.toString(count).toCharArray();
 * for (char digit : countAsChars) {
 * chars[indexAnswer] = digit;
 * indexAnswer++;
 * }
 * }
 * <p>
 * streakStart = streakEnd + 1;
 * }
 * System.out.println(indexAnswer);
 * return indexAnswer;
 */

