package data_structures_and_algorithms_CS210.week17;

public class FindMinInRotatedSortedArray {
    public int findMin(int[] nums) {
        int n = nums.length;

        //empty nums
        if (nums == null || n == 0) return 0;

        //just a single element
        if (n == 1) return nums[0];

        //[4,5,6,7,0,1,2]
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int middle = (left + right) / 2;

            //if(middle is the inflection point) return nums(middle);
            if (middle > 0 && nums[middle - 1] > nums[middle]) return nums[middle];

            if (nums[middle] > nums[right]) left = middle + 1;
            else right = middle - 1;
        }
        //shouldn't reach here
        return -1;
    }
}
