package foundation_pre_course.week11;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MajorityElement {
    /**
     * Given an array nums of size n, return the majority element.
     * <p>
     * The majority element is the element that appears more than ⌊n / 2⌋ times. You may assume that the majority element always exists in the array.
     * Example 1:
     * <p>
     * Input: nums = [3,2,3]
     * Output: 3
     * Example 2:
     * <p>
     * Input: nums = [2,2,1,1,1,2,2]
     * Output: 2
     */
    public static void main(String[] args) {
        int[] arr = {2, 2, 1, 1, 1, 2, 2};

        System.out.println(majorityElement3(arr));
    }

    //approach I knew
    public static int majorityElement1(int[] nums) {
        // Create a HashMap to store the frequency of each element
        Map<Integer, Integer> frequency = new HashMap<>();

        // Iterate through the array
        for (int x : nums) {
            // Update the count for each element
            /*
             * frequency.getOrDefault(x, 0):
             *
             * Purpose: Retrieves the current count of the element x from the frequency map.
             * Behavior:
             * If x exists in the map, it returns its associated value (the current count).
             * If x does not exist, it returns the default value 0.
             * Example:
             * If x = 5 and frequency contains {5=2}, then frequency.getOrDefault(5, 0) returns 2.
             * If x = 7 and frequency does not contain 7, then frequency.getOrDefault(7, 0) returns 0.
             * frequency.getOrDefault(x, 0) + 1:
             *
             * Purpose: Calculates the new count for the element x by adding 1 to the current count.
             * Behavior:
             * If x is already in the map with a count of 2, this expression becomes 2 + 1, resulting in 3.
             * If x is not in the map, it becomes 0 + 1, resulting in 1.
             * frequency.put(x, frequency.getOrDefault(x, 0) + 1):
             *
             * Purpose: Updates the frequency map by setting the key x to its new count.
             * Behavior:
             * If x is already in the map, its value is updated to the new count.
             * If x is not in the map, a new entry is added with x as the key and 1 as its count.
             * Example:
             * If x = 5 and frequency is {5=2}, after this operation, frequency becomes {5=3}.
             * If x = 7 and frequency is {5=3}, after this operation, frequency becomes {5=3, 7=1}.
             */
            frequency.put(x, frequency.getOrDefault(x, 0) + 1);
        }

        // Iterate through the HashMap entries
        for (Map.Entry<Integer, Integer> entry : frequency.entrySet()) {
            // Check if the count of the element is greater than half the array length
            if (entry.getValue() > nums.length / 2) {
                // Return the element as the majority element
                return entry.getKey();
            }
        }

        // Return a default value if no majority element is found (though the problem guarantees one exists)
        return Integer.MIN_VALUE;
    }

    //easiest
    //By sorting the array, the majority element will always occupy the middle position due to its frequency.
    public static int majorityElement2(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }

    //fastest
    //Boyer-Moore Voting Algorithm
    //This efficient algorithm maintains a candidate and adjusts its count based on the array's elements to find the majority element.
    public static int majorityElement3(int[] nums) {
        int count = 0;
        //In the Boyer-Moore Majority Vote Algorithm, the initial value assigned to the candidate variable is arbitrary and does not impact the algorithm's correctness. This is because the algorithm's logic ensures that the correct majority element is identified through its iteration process, regardless of the initial candidate value.
        int candidate = 0;

        for (int n : nums) {
            //if count for the current number became 0, pick a new candidate number
            if (count == 0) candidate = n;

            //if current num is the candidate num, increase count by 1
            if (n == candidate) count++;
                //otherwise, decrement count by 1. You can think of it like a single non-candidate number kills a single candidate
            else count--;
        }
        //since there is one number appears > n/2 times, it is un-killable.
        //it should win over all other candidates
        return candidate;
    }
}
