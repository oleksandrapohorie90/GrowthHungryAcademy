package foundation_pre_course.week12;

import java.util.Arrays;

public class MergeSortedArray {
    /*
    You are given two integer arrays nums1 and nums2, sorted in non-decreasing order, and two integers m and n, representing the number of elements in nums1 and nums2 respectively.

Merge nums1 and nums2 into a single array sorted in non-decreasing order.

The final sorted array should not be returned by the function, but instead be stored inside the array nums1. To accommodate this, nums1 has a length of m + n, where the first m elements denote the elements that should be merged, and the last n elements are set to 0 and should be ignored. nums2 has a length of n.

Example 1:

Input: nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
Output: [1,2,2,3,5,6]
Explanation: The arrays we are merging are [1,2,3] and [2,5,6].
The result of the merge is [1,2,2,3,5,6] with the underlined elements coming from nums1.
     */
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int m = 3;
        int[] nums2 = {2, 5, 6};
        int n = 3;

        merge(nums1, m, nums2, n);
    }

    public void merge2(int[] nums1, int m, int[] nums2, int n) {
        int tail1 = m - 1; // pointer at the largest value in nums1
        int tail2 = n - 1; // pointer at the largest value in nums2
        int insertPosition = m + n - 1; // the very end of nums1, where we will start
        // putting the merging arrays nums1 and nums2.

        // Keep merging until we run out of elements in nums2.
        while (tail2 >= 0) {
            if (tail1 >= 0 && nums1[tail1] > nums2[tail2]) {
                // If nums1 has the next element, and if it is
                // greater than the next element in nums2, then
                // put the next element from nums1 in the insertPosition
                // and decrement both insertPosition and tail1.
                nums1[insertPosition--] = nums1[tail1--];
            } else {
                // Otherwise, put the next element from nums2
                // in the insertPosition and decrement both
                // insertPosition and tail2.
                nums1[insertPosition--] = nums2[tail2--];
            }
        }

        /*
                                             0  1  2  3  4   5
                                    nums1 = [1, 2, 3, 0, 0, *6*]
                     tail1 = 2                     ^
            insertPosition = 5                               ^
                                             0  1  2
                                    nums2 = [2, 5, 6]
            tail2 = 2                              ^

            The next element of nums2 is bigger, so put it
            at insertPosition = 5 and decrement both
            insertPosition and tail2.

                                             0  1  2  3   4   5
                                    nums1 = [1, 2, 3, 0, *5*, 6]
                     tail1 = 2                     ^
            insertPosition = 4                            ^
                                             0  1  2
                                    nums2 = [2, 5, 6]
            tail2 = 1                           ^

            The next element of nums2 is bigger, so put it
            at insertPosition = 4 and decrement both
            insertPosition and tail2.

                                             0  1  2   3   4  5
                                    nums1 = [1, 2, 3, *3*, 5, 6]
                     tail1 = 2                     ^
            insertPosition = 3                         ^
                                             0  1  2
                                    nums2 = [2, 5, 6]
            tail2 = 0                        ^

            The next element of nums1 is bigger, so put it
            at insertPosition = 3 and decrement both
            insertPosition and tail1.

                                             0  1   2   3  4  5
                                    nums1 = [1, 2, *2*, 3, 5, 6]
                     tail1 = 1                  ^
            insertPosition = 2                      ^
                                             0  1  2
                                    nums2 = [2, 5, 6]
            tail2 = 0                        ^

            The next element of nums1 isn't bigger (both equal), so put the next element of nums2
            at insertPosition = 2 and decrement both
            insertPosition and tail2.

                                             0  1  2   3  4  5
                                    nums1 = [1, 2, 2, 3, 5, 6]
                     tail1 = 1                  ^
            insertPosition = 1                  ^
                                             0  1  2
                                    nums2 = [2, 5, 6]
            tail2 = -1                    ^

            There are no elements in tail2 left (tail2 < 0) – stop the procedure,
            the two arrays are merged.
        */
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int tail1 = m - 1;
        int tail2 = n - 1;
        int insert_position = m + n - 1;

        while (tail2 >= 0) {
            if (tail1 >= 0 && nums1[tail1] > nums2[tail2]) {
                nums1[insert_position--] = nums1[tail1--];
            } else {
                nums1[insert_position--] = nums2[tail2--];
            }
        }
        System.out.println(Arrays.toString(nums1));
    }
}
