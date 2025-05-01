package data_structures_and_algorithms_CS210.Second_Cohort.week26_MergeSort;

public class MergeSortedArray {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
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
}
