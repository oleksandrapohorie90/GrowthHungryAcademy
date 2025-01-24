package data_structures_and_algorithms_CS210.First_Cohort.week16;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSums {
    //will have to use HashMap

    /**
     *
     * public int[] twoSum(int[] nums, int target) {
     *         //          i=5
     *         // [..., nums[i] = 17, ...]
     *         // target = 77
     *         // lastSeenSoFar = { 22: 0, 61: 1, 23: 4, 56: 3, 12: 2 }
     *         // lastSeenSoFar.containsKey(77 - 17, i.e. 60) -> false
     *         // No problem, let's record -> lastSeenSoFar.put(17, 5) // key=17 (number), value=5 (lastSeenIndex)
     *         // lastSeenSoFar = { 22: 0, 61: 1, 23: 4, 56: 3, 12: 2, 17: 5}
     *
     *         //          i=6
     *         // [..., nums[i] = 21, ...]
     *         // target = 77
     *         // lastSeenSoFar = { 22: 0, 61: 1, 23: 4, **56: 3**, 12: 2, 17: 5}
     *         // lastSeenSoFar.containsKey(77 - 21, i.e. 56) -> true
     *         // Cool! Return {lastSeenSoFar.get(56) [i.e. 3], i [i.e. 6]}
     *
     *         // Map<Number, IndexLastSeen>
     *         Map<Integer, Integer> lastSeenSoFar = new HashMap<>();
     *         for (int i = 0; i < nums.length; ++i) {
     *             int b = nums[i];
     *             int a = target - b;
     *             if (lastSeenSoFar.containsKey(a)) {
     *                 // Found pair of (a, b), so that a + b = target
     *                 // Number a last seen at index lastSeenSoFar.get(a)
     *                 // and number b is last seen at index i.
     *                 return new int[]{lastSeenSoFar.get(a), i};
     *             }
     *             // Save that number b (nums[i]) last seen at index i.
     *             lastSeenSoFar.put(b, i);
     *         }
     *         return new int[]{};
     *     }
     * }
     */
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 6};
        int target = 4;
        System.out.println(Arrays.toString(twoSum(nums, target)));
    }

    public static int[] twoSum(int[] nums, int target) {

    Map<Integer, Integer> lasSeenSoFar = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int a = nums[i];
            int b = target - a;
            if(lasSeenSoFar.containsKey(b)){
                return new int[]{lasSeenSoFar.get(b), i};
            }
            lasSeenSoFar.put(a,i);
        }
        return new int []{};
        }


}
