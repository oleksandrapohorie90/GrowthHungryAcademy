package java_intro.week3;

import java.util.Arrays;
import java.util.HashMap;

public class Practice1 {
    /**
     Given an array of integers nums and an integer target, return indices of the two numbers
     such that they add up to target.
     You may assume that each input would have exactly one solution, and you may not use the
     same element twice.
     You can return the answer in any order.
     class Solution {
     public int[] twoSum(int[] nums, int target) {
     }
     }

     */
    public static int[] twoSum(int[] nums, int target){
        HashMap<Integer,Integer> complements = new HashMap<>();
        for (int i = 0; i < nums.length; i++) { //O(n)
            int val = nums[i]; // get the current value
            //target == val + complement
            int complement = target-val; //how do you check if you have encountered complement or no
            if(complements.containsKey(complement)){
                return new int[]{complements.get(complement),i};
            }
            complements.put(val,i);
        }
        return new int[]{};
    }

    public static void main(String[] args) {
                   // 0 1 2 3
        int[] nums = {1,2,3,4};
        int[] indices = twoSum(nums,3); //if target is 3 then return indices are 0,1, if target i 6 then return indices are 1,3
        System.out.println(Arrays.toString(indices));
    }
}
