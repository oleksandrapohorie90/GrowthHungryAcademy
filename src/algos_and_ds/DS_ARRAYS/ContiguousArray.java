package algos_and_ds.DS_ARRAYS;

import java.util.HashMap;

public class ContiguousArray {

    public int findMaxlength(int [] nums){
        int n = nums.length;
        int [] pref = new int[n];

        pref[0] = nums[0]==0?-1:+1;
        for (int i = 0; i < n; i++) {
            pref[i]= pref[i-1];
            if(nums[i]==0){
                pref[i]--;

            }else {
                pref[i]++;
            }
        }
        HashMap<Integer,Integer>hm= new HashMap<>();
        hm.put(0,-1);
        int answer=0;
    }
}
