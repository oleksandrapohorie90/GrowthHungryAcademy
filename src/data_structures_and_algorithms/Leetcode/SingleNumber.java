package data_structures_and_algorithms.Leetcode;

public class SingleNumber {
    public static void main(String[] args) {
        System.out.println();
    }
    public int singleNumber(int[] nums) {
        int index = 0;
        for(int i = 0; i<nums.length;i++){

            index = index^nums[i];
        }
        return index;
    }
}
