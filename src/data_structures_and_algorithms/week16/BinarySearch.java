package data_structures_and_algorithms.week16;

public class BinarySearch {
    public int binarySearch(int[] nums, int x) {
        /**
         * Assume we have an array nums of length n(nums[0...n-1]) sorted
         * in ascending order
         * Lets find an int x in nums and return its index, or return -1 if its
         * not present
         */
        int n = nums.length;
        int left = 0;
        int right = n - 1;
        while (left < right) {
            int middle = (left + right) / 2;
            if (nums[middle] == x) {
                //we found it
                return middle;
            }
            if (nums[middle] < x) {
                //search in the right part [middle+1; right]
                left = middle + 1;
            } else {//x<nums[middle]
                //Search in the left part[left; middle-1]
                right = middle - 1;
            }
        }
        //couldn't find it
        return -1;

    }
}
