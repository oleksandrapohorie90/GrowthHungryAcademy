package data_structures_and_algorithms_CS210.Second_Cohort.week3_hashTables;

import java.util.*;

public class Top_K_FrequentElements_RevisitComparator {
    /**
     * Given an integer array nums and an integer k, return the k most frequent elements. You may return the answer in any order.
     * Example 1:
     * <p>
     * Input: nums = [1,1,1,2,2,3], k = 2
     * Output: [1,2]
     * Example 2:
     * <p>
     * Input: nums = [1], k = 1
     * Output: [1]
     */
    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 2, 2, 3};
        int k = 2;

        System.out.println(Arrays.toString(topKFrequent(nums, k)));
    }

    public static class Pair<K, V> {
        private final K key;
        private final V value;

        public Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }
    }

    public static int[] topKFrequent(int[] nums, int k) {
        //is there a way to avoid creating a list of pairs, where did it come from ? <---Priority Queue
        //also can you do without Comparator ?

        // Map<Number, Frequency>
        Map<Integer, Integer> freq = new HashMap<>();

        // First, count for each number its frequency.
        for (int x : nums) {
            freq.put(x, freq.getOrDefault(x, 0) + 1);
        }

        //                                                 (key  ,   value)
        // Convert the Map<Number, Frequency> to List<Pair<Number, Frequency>>.
        List<Pair<Integer, Integer>> sorted_freq_pairs = new ArrayList<>();
        for (var entry : freq.entrySet()) {
            Pair<Integer, Integer> freq_pair = new Pair<>(entry.getKey(), entry.getValue());
            sorted_freq_pairs.add(freq_pair);
        }

        // T: O(n log n)
        // S: O(n)

        //                (key  ,   value)
        // Sort List<Pair<Number, Frequency>> by the Frequency (i.e. value)
        // in descending order.
        Collections.sort(sorted_freq_pairs, (fp1, fp2) -> {
            // < 0
            // == 0
            // > 0
            return fp2.getValue() - fp1.getValue();
        });

        // Create array to save k most frequent numbers.
        int[] results = new int[k];
        for (int i = 0; i < k; i++) {
            //      (key   , value   )
            // Now, (Number, Frequency) pairs are sorted in descending order.
            // Get the first k Numbers (i.e. keys) and save them in results.
            results[i] = sorted_freq_pairs.get(i).getKey();
        }
        return results;

    }
}
