package data_structures_and_algorithms_CS210.Second_Cohort.Neetcode;

public class BinarySearch {
    public int search(int[] nums, int target) {

        int left = 0;
        int right = nums.length-1;

        while(left<=right){
            int mid = left + (right-left)/2;

            if(nums[mid]==target){
                return mid; //index of the number
            }
            else if(nums[mid] < target){
                left = mid + 1; //move forward from mid to +1
            }else {
                right = mid - 1;
            }
        }
        return -1;
    }
}
