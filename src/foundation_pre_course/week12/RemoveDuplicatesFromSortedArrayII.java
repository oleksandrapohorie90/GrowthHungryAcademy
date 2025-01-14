package foundation_pre_course.week12;

import java.util.Arrays;

public class RemoveDuplicatesFromSortedArrayII {
    //similar to remove Duplicates From Sorted Array I

    /**
     * Given an integer array nums sorted in non-decreasing order, remove some duplicates in-place such that each unique element appears at most TWICE. The relative order of the elements should be kept the same.
     * <p>
     * Since it is impossible to change the length of the array in some languages, you must instead have the result be placed in the first part of the array nums. More formally, if there are k elements after removing the duplicates, then the first k elements of nums should hold the final result. It does not matter what you leave beyond the first k elements.
     * <p>
     * Return k after placing the final result in the first k slots of nums.
     * <p>
     * Do not allocate extra space for another array. You must do this by modifying the input array in-place with O(1) extra memory.
     * <p>
     * Custom Judge:
     * <p>
     * The judge will test your solution with the following code:
     * <p>
     * int[] nums = [...]; // Input array
     * int[] expectedNums = [...]; // The expected answer with correct length
     * <p>
     * int k = removeDuplicates(nums); // Calls your implementation
     * <p>
     * assert k == expectedNums.length;
     * for (int i = 0; i < k; i++) {
     * assert nums[i] == expectedNums[i];
     * }
     */
    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 1, 2, 2, 3, 4, 4};
        System.out.println(removeDuplicates(nums));
    }

    //TODO: Ask about where are the code snippets
    public static int removeDuplicates(int[] nums) {
        /** [1,1,1,1,2,2,3,4,4]
         *   n n d d n n n n d
         *   Numbers nums[0] and nums[1] will stay where they are since at most TWICE
         * 1st iterate over the numbers from i=2
         * and iterate over the numbers that we need at insertPosition one-by-one
         */
        int insetPosition = 2; // Initialize the position to insert unique elements

        // Iterate over the array starting from the third element
        for (int i = 2; i < nums.length; i++) {
            // Check if the current element is different from the element two positions before
            if (nums[i] != nums[insetPosition - 2]) {
                nums[insetPosition] = nums[i]; // Place the unique element at the insert position
                insetPosition++; // Move the insert position forward
            }
        }
        System.out.println(Arrays.toString(nums));
        return insetPosition; // Return the new length of the array
    }
    /*
    Initialization:

insetPosition is set to 2, indicating the index where the next unique element should be placed.
Iteration:

The loop starts from index 2 (i = 2) because the first two elements are always allowed to appear at most twice.
Condition Check:

For each element at index i, the code checks if it is different from the element two positions before (nums[i] != nums[insetPosition - 2]). This ensures that no element appears more than twice consecutively.
Insertion:

If the condition is met (i.e., the element is unique or appears only once), it is placed at the insetPosition, and insetPosition is incremented.
Return Value:

After processing all elements, insetPosition represents the length of the modified array containing unique elements.
     */
}
