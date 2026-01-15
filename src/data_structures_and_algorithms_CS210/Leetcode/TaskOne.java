package data_structures_and_algorithms_CS210.Leetcode;

public class TaskOne {
    public static void main(String[] args) {
        int [] nums = {45,30,40,10};
        System.out.println(findSecondHighestNumber(nums));
    }

    public static int findSecondHighestNumber(int[] nums){
        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;

        for(int i=0; i<nums.length; i++){
            if(nums[i] > largest){
                largest = nums[i];
            }
            if(nums[i] > secondLargest && nums[i] < largest){
                secondLargest = nums[i];
            }
        }

        return secondLargest;
    }
}
