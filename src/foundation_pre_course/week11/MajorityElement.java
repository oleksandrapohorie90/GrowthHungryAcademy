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

        System.out.println(majorityElement2(arr));
    }

    //approach I knew
    public static int majorityElement1(int[] nums) {
        // Create a HashMap to store the frequency of each element
        Map<Integer, Integer> frequency = new HashMap<>();

        // Iterate through the array
        for (int x : nums) {
            // Update the count for each element
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
        int candidate = -1;

        for (int n : nums) {
            //if count fof the current number became 0, pick a new candidate number
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
