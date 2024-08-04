package data_structures_and_algorithms.week17;

public class SearchInRotatedSortedArrayII {
    //look up 81.search in rotated sorted array

    public boolean search(int[] nums, int target) {
        int n = nums.length;

        int left = 0;
        int right = n - 1;
        int answer = -1;
        while (left <= right) {
            int middle = left + (right - left) / 2;

            if (nums[middle] == target) {
                return true;
            }

            if (nums[middle] > nums[right]) {
                //middle is in the first increasing segment
                if (target < nums[right]) {
                    //target is in the 2nd increasing segment, so search in the right half
                    right = middle + 1;
                } else {
                    right = middle - 1;
                }
            } else {
                //we are already either in the 1st or 2nd increasing segment,
                //so just do a normal binary search.
                if (target < nums[middle]) {
                    right = middle - 1;
                } else {
                    //nums[middle]<target
                    left = middle + 1;
                }
            }
        }
        return false;
    }
}
