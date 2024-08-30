package data_structures_and_algorithms.week16;

public class SubArraySumEqualsK {
    // public int subarraySum(int[] nums, int k) {
    //        int currentPrefixSum = 0;
    //        int answer = 0;
    //
    //        //        key       value
    //        // Map<prefixSum, seenCount>
    //        // seenCount is how many times prefixSum has been seen previously.
    //        Map<Integer, Integer> prefixSumSeenCount = new HashMap<>();
    //
    //        // Empty prefix => (prefixSum = 0, seenCount = 1)
    //        prefixSumSeenCount.put(0, 1);
    //
    //        // T: O(n)
    //        // S: O(n)
    //
    //        for (int i = 0; i < nums.length; i++) {
    //            currentPrefixSum += nums[i];
    //            // currentPrefixSum = sum(nums[0 .. i])
    //
    //            // Let's add to the answer
    //            // the count of subarrays that end at index i
    //            // and have the sum of k.
    //            //
    //            // That number = seenCount of (currentPrefixSum - k)
    //            // Why?
    //            //
    //            // Imagine that there is a prefix nums[0 .. j]
    //            // that has the sum of (currentPrefixSum - k)
    //            // that we have seen before index i. j < i
    //            //
    //            // If we subtract that prefix from our current prefix,
    //            // i.e. sum(nums[0 .. i]) - sum(nums[0 .. j]), then we will have
    //            // a subarray nums[j + 1 .. i] with a sum of
    //            // currentPrefixSum - currentPrefixSum + k = k.
    //            //
    //            // Going back, we need to add seenCount of (currentPrefixSum - k)
    //            // because there can be many prefixes with a sum of (currentPrefixSum - k)
    //            // that we have seen and all of them when subtracted from currentPrefixSum
    //            // produce valid subarrays that end at index i and have the sum equal to k.
    //            //
    //            // If we add to the answer for each i the count of subarrays that end at index i
    //            // and have the sum of k, then we will have counted the total number of subarrays
    //            // that have the sum of k.
    //            answer += prefixSumSeenCount.getOrDefault(currentPrefixSum - k, 0);
    //
    //            // After we have processed current prefix, we should add 1 to its seenCount.
    //            prefixSumSeenCount.put(
    //                currentPrefixSum,
    //                prefixSumSeenCount.getOrDefault(currentPrefixSum, 0) + 1);
    //        }
    //
    //        return answer;
    //    }
    //HashTable
    public int subarraySum(int[] sums,)
}
