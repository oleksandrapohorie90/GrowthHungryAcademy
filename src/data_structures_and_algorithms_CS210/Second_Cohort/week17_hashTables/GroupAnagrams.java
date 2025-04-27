package data_structures_and_algorithms_CS210.Second_Cohort.week17_hashTables;

import java.util.*;

public class GroupAnagrams {

    //Is there a way to get a better recap of Time and Space complexity topic ? I still dont get it, I rewatched your lecture twice and when it comes to an example Im just starring at it ?
    /**
     * Given an array of strings strs, group the
     * anagrams
     * together. You can return the answer in any order.
     * Example 1:
     * <p>
     * Input: strs = ["eat","tea","tan","ate","nat","bat"]
     * <p>
     * Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
     * <p>
     * Explanation:
     * <p>
     * There is no string in strs that can be rearranged to form "bat".
     * The strings "nat" and "tan" are anagrams as they can be rearranged to form each other.
     * The strings "ate", "eat", and "tea" are anagrams as they can be rearranged to form each other.
     * Example 2:
     * <p>
     * Input: strs = [""]
     * <p>
     * Output: [[""]]
     * <p>
     * Example 3:
     * <p>
     * Input: strs = ["a"]
     * <p>
     * Output: [["a"]]
     */
    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(groupAnagrams(strs));
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        // L = length of all strings together
        // T: O(L log L)
        // S: O(L)

        for (String word : strs) {  // O(N)
            // Each anagram can be identified uniquely
            // by a sorted list of its characters.
            //
            // For each word, create its copy
            // with all characters sorted.
            char[] chars = word.toCharArray();
            Arrays.sort(chars);
            String sortedWord = new String(chars);

            // if (map doesn't contain key sortedWord, i.e. such anagram was never seen before) {
            //   create an empty list for that new anagram
            // }
            // add to this list the current word as it corresponds to that anagram
            if (!map.containsKey(sortedWord)) {
                map.put(sortedWord, new ArrayList<>());
            }
            map.get(sortedWord).add(word);
        }

        return new ArrayList<>(map.values());
    }
}
