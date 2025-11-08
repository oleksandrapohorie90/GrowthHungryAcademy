package data_structures_and_algorithms_CS210.Leetcode.SDET_Critical;

import java.util.Arrays;

public class RemoveDuplicatesFromArrayInPlace {
    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 2, 3, 4, 5, 6, 7, 7, 7, 8, 9, 10};
        System.out.println(removeDuplicatesLeetcode(nums));
    }

    public static int removeDuplicatesLeetcode(int[] nums) {
        //2 pointers slow and fast
        int left = 0; // points to last unique element

        for (int right = 0; right < nums.length; right++) {
            if (nums[left] != nums[right]) {
                left++; // move to next unique spot
                nums[left] = nums[right]; // copy new unique value
            }
        }
        return left + 1; // total number of unique elements
    }

    public static int[] removeDuplicates(int[] nums) {
        return Arrays.stream(nums).distinct().toArray();
    }
}
