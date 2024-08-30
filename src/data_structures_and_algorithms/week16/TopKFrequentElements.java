//package data_structures_and_algorithms.week16;
//
//import java.util.*;
//
//public class TopKFrequentElements {
//
//    //Hashtables
//
//    public int[] topKFrequent(int[] nums, int k) {
//        //Map<Number, Frequency>
//        Map<Integer, Integer> freq = new HashMap<>();
//
//        //first count for each number its frequency
//        for (int x : nums) {
//            freq.put(x, freq.getOrDefault(x, 0) + 1);
//        }
//        //(key , value)
//        //convert the Map<Number,Frequency> to List<Pair<Number, Frequency>>
//        List<Pair<Integer, Integer>> sorted_freq_pairs = new ArrayList<>();
//        for (var entry : freq.entrySet()) {
//            Pair<Integer, Integer> freq_pair = new Pair<>(entry.getKey(), entry.getValue());
//            sorted_freq_pairs.add(freq_pair);
//        }
//
//        //T: O(n log n)
//        //S: O(n)
//
//        //Sort List<Pair<Number, Frequency>> by the Frequency (i.e) value
//        //in descending order
//        Collections.sort(sorted_freq_pairs, (fp1, fp2) -> {
//            //sorts in descending order
//            return fp2.getValue() - fp1.getValue();
//        });
//
//        //create array to save k most frequent numbers
//        int[] results = new int[k];
//        for (int i = 0; i < k; i++) {
//            //key , value
//            //now(number, frequency) pairs are sorted
//            //get the first k Numbers (i.e. keys) and save them in results
//            results[i] = sorted_freq_pairs.get(i).getKey();
//        }
//        return results;
//
//    }
//
//}
