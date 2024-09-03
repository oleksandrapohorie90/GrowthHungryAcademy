package data_structures_and_algorithms_CS210.DS_ARRAYS;

public class FindMaxLength {

    public int findMaxLength(int [] nums){
        int n = nums.length;
    int answer = 0;
        for (int start = 0; start < n; start++) { //O(n)
            int zeroes = 0;
            int ones = 0;
            for (int i = start; i < n; i++) { //O(n)
                if(nums[i]==0) zeroes++;
                else ones++;

                if (zeroes==ones){
                    answer = Math.max(answer,zeroes+ones);
                }
            }
        }
        return answer;
    }
}
