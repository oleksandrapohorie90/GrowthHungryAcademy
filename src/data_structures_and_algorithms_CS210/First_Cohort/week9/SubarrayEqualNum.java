package data_structures_and_algorithms_CS210.First_Cohort.week9;

import java.util.HashMap;
import java.util.Map;

public class SubarrayEqualNum {

    public int subarraySum(int [] nums, int k){

        int answer = 0;
        int prefix_sum_i = 0;
        Map<Integer, Integer> HT = new HashMap<>();

        HT.put(0,1); //single empty subarray in the beginning
        for (int i = 0; i < nums.length; i++) {
            prefix_sum_i +=nums[i];
            if(HT.containsKey(prefix_sum_i-k)){
                answer+=HT.get(prefix_sum_i-k);
            }
            HT.put(prefix_sum_i, HT.getOrDefault(prefix_sum_i,0)+1);
        }
        return answer;
    }
    //group anagrams, longest consecutive sequence
}
