package algos_and_ds.DS_ARRAYS;

public class ProductExceptSelf {
    public int[] productExceptSelf(int [] nums){
        /*
        nums[1,2,3,4]
        answer[24,12,8,6] -> product of all except the index number
        if 24 -> index of 0, so we skip 1 and do 2*3*4
        if 12 -> index of 1, so we skip 2 and do 1*3*4

        nums[o...i] - prefix
        nums[j..n-1] - suffix
        [1,2,3,4]
        nums[0...0]=[1]         pref_mul[0] = 1 = nums[0]
        nums[0...1]=[1,2]       pref_mul[1] = 1*2 = 2 = pref_mul[0] * nums[1]
        nums[0...2]=[1,2,3]     pref_mul[2] = 1*2*3 = 6 = pref_mul[1] * nums[2]
        nums[0...3]=[1,2,3,4]   pref_mul[3] = 1*2*3*4 = 24 = pref_mul[2] * nums[3]


        int n = nums.length;
        int[] pref_mul = new int[n];
        int[] sufff_mul = new int[n];
        for i=0 n-1
        pref_mul[i] = suffmul[i]=1
        pref_mul[0] = nums[0]
        for i=1..n-1
        pref_mul[i]=pref_mul[i-1] * nums[i]
        suff_mul[n-1]=nums[n-1] -> will equal to 4
         */
    }
}
