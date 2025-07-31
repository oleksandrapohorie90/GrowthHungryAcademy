package data_structures_and_algorithms_CS210.Leetcode.HashMap;

import java.util.HashMap;
import java.util.Map;

public class ContainsDuplicates_II {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        //correct approach will be HashMap
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i]) && i - map.get(nums[i]) <= k) {
                return true;
            }
            map.put(nums[i], i);
        }
        return false;
    }
}
