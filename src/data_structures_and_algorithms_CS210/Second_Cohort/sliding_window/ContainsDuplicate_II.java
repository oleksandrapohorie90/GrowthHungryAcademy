package data_structures_and_algorithms_CS210.Second_Cohort.sliding_window;

import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate_II {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> window = new HashSet<>();
        int left = 0;

        for(int right = 0; right<nums.length; right++){
            if(right-left > k){
                window.remove(nums[left]);
                left++;
            }
            if(window.contains(nums[right])){
                return true;
            }

            window.add(nums[right]);
        }
        return false;
    }
}
