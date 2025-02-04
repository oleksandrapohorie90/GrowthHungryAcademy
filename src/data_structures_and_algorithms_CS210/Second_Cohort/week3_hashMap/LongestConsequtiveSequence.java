package data_structures_and_algorithms_CS210.Second_Cohort.week3_hashMap;

import java.util.HashSet;
import java.util.Set;

public class LongestConsequtiveSequence {
    /**
     * Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.
     * <p>
     * You must write an algorithm that runs in O(n) time.
     * <p>
     * Example 1:
     * <p>
     * Input: nums = [100,4,200,1,3,2]
     * Output: 4
     * Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.
     * Example 2:
     * <p>
     * Input: nums = [0,3,7,2,5,8,4,6,0,1]
     * Output: 9
     */
    public static void main(String[] args) {
        int[] nums = {100, 4, 200, 1, 3, 2};
        System.out.println(longestConsecutive(nums));
    }

    public static int longestConsecutive(int[] nums) {

        //lets create a set to avoid duplicates and make sure all the look up of elements ara fast
        Set<Integer> set = new HashSet<>();
        for (int n : nums) {
            set.add(n);
        }
        // {99, 100, 4, 200, 1, 3, 2}
        //
        //        [1, 2, 3, 4] [99, 100] [200]
        //
        //        T: O(n)
        //        S: O(n)

        //assign a longest consecutive
        int longest_streak = 0;
        for (int n : nums) {
            //we need to make sure that the num is truly a start of the longest consecutive
            // if (n is the beginning of a streak)
            // Lookup works in O(1).
            if (!set.contains(n - 1)) {
                //This ensures we only start counting from the beginning of a sequence instead of checking every number redundantly.
                int streak_start = n;
                int streak_end = n;
                //This loop moves forward as long as streak_end + 1 exists in the set.
                //Example:
                //{1, 2, 3, 4}: If n = 1, we check for 2, then 3, then 4.
                while (set.contains(streak_end + 1)) {
                    streak_end++;
                }
                //Think about a sequence {1, 2, 3, 4}:
                //
                //streak_start = 1
                //streak_end = 4
                //Length of sequence = 4 - 1 + 1 = 4.
                //If we didn't add +1, we'd get 3, which is incorrect.
                //
                //Another example {99, 100}:
                //
                //streak_start = 99
                //streak_end = 100
                longest_streak = Math.max(longest_streak, streak_end - streak_start + 1);
            }
        }
        return longest_streak;
    }
    //O(n)
    //Adding elements to the HashSet takes O(n), and since each element is processed at most twice, the loop runs in O(n).
    //Space Complexity:
    //O(n)
    //We store all elements in the HashSet, which takes up to O(n) space.
}
