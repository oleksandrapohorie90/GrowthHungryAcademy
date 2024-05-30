package algos_and_ds.week10;

import java.util.HashMap;
import java.util.Map;

public class HashMapTwoSum {
    /**
     * nums 2,7,11,15
     * target=9
     * answer=[0,1]
     * Brute Force solution-simplest way
     * O(n)^2 - time complexity
     * Big theta (1) - space complexity
     * for i=1...n-1{
     *     for j=0...i-1{
     *         if numsi+numsj==target
     *         return [i,j]
     *
     *         i=1..n-1
     *         j=0,j<i,j++
     *     }
     * }
     * Is there a num to the left before numsi => target - numsi = numsj
     * (key=numsj, value=j)
     */
    public int[]twoSum(int[ ]nums, int target){


        Map<Integer, Integer> HT = new HashMap<>();

        //Time: O(N)
        //Space: O(N)
        for (int i = 0; i < nums.length; i++) { //O(N)
            int complement = target-nums[i]; //nums[j] == target - nums[i], j<1
            if(HT.containsKey(complement)){ //O(1)
                return new int[] {i,HT.get(complement)};//O(1)
            }
            HT.put(nums[i],i); //insert key-value pair (k=nums[i], v=i)  //O(1)
        }
        //in case there is no solution
        return null;
    }

}
