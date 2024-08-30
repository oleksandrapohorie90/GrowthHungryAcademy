package data_structures_and_algorithms.week16;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {
    /**
     * public int longestConsecutive(int[] nums) {
     * // Add each number to a HashSet.
     * Set<Integer> set = new HashSet<>();
     * for (int n : nums) {
     * set.add(n);
     * }
     * <p>
     * {99, 100, 4, 200, 1, 3, 2}
     * <p>
     * [1, 2, 3, 4] [99, 100] [200]
     * <p>
     * // T: O(n)
     * // S: O(n)
     * <p>
     * int longest_streak = 0;
     * for (int n : set) {
     * // if (n is the beginning of a streak)
     * // Lookup works in O(1).
     * if (!set.contains(n - 1)) {
     * int streak_start = n;
     * int streak_end = n;
     * <p>
     * // Walk the streak to the last element.
     * while (set.contains(streak_end + 1)) {
     * streak_end++;
     * }
     * <p>
     * // Update the value of the longest streak with the length of the current one.
     * longest_streak = Math.max(longest_streak, streak_end - streak_start + 1);
     * }
     * }
     * return longest_streak;
     * }
     */

    public int longestConsecutive(int[] nums) {
        //Add each number to a HashSet, bc no duplicate are allowed, no ordering
        Set<Integer> set = new HashSet<>();
        //consecutive interval from 1 to 2, then another cons interval 100, 200
        //[1,2,3,4] [100] [200]
        // {100, 4, 200, 1, 3, 2}
        for (int n : nums) {
            set.add(n);
        }

        int longest_streak = 0;
        //now lets iterate over above set and look, does this set, contain number that is 1 less than 100, like 99 ?
        // {100, 4, 200, 1, 3, 2}
        //if there is 99 then we know for sure no reason to check the interval from 100,and whenevr we find a beginning of an interval then we should understand how long is that interval, if in the Hashset there is no number 98 then we know for sure 99 is the beginning of the interval
        //ok, lets start walking from 99, doe it have next one yes = 100, does it have another next no, ok so interval is {99,100}
        //T: O(n)
        //S: O(n)
        for (int n : set) {//does this set contain number that is one less than this number 99
            if (!set.contains(n - 1)) {
                int streak_start = n;
                int streak_end = n;

                //walk the streak to the last element
                while (set.contains(streak_end + 1)) {
                    streak_end++;
                }
                //update the value of the longest streak w/ the length of current one
                longest_streak = Math.max(longest_streak, streak_end - streak_start + 1);
            }
        }
        return longest_streak;
    }
}
