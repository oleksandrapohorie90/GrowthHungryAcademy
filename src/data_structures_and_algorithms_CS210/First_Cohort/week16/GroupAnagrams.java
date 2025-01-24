package data_structures_and_algorithms_CS210.First_Cohort.week16;

import java.util.*;

public class GroupAnagrams {
    /**
     * public List<List<String>> groupAnagrams(String[] strs) {
     * Map<String, List<String>> map = new HashMap<>();
     * <p>
     * // L = length of all strings together
     * // T: O(L log L)
     * // S: O(L)
     * <p>
     * for (String word : strs) {  // O(N)
     * // Each anagram can be identified uniquely
     * // by a sorted list of its characters.
     * //
     * // For each word, create its copy
     * // with all characters sorted.
     * char[] chars = word.toCharArray();
     * Arrays.sort(chars);
     * String sortedWord = new String(chars);
     * <p>
     * // if (map doesn't contain key sortedWord, i.e. such anagram was never seen before) {
     * //   create an empty list for that new anagram
     * // }
     * // add to this list the current word as it corresponds to that anagram
     * if (!map.containsKey(sortedWord)) {
     * map.put(sortedWord, new ArrayList<>());
     * }
     * map.get(sortedWord).add(word);
     * }
     * <p>
     * return new ArrayList<>(map.values());
     * }
     * }
     */

    //TIME COMPLEXITY:
    //(1) -> iterate over the words O(N)
    //(2) -> sort all of the chars in all of the strings:
    //L = length of all strings together -> T: O(L log L) time complexity
    //in HashMap we store n copies, all of the n's strings, their total length = L -> S: O(L) space complexity

    //anagram - a word that's formed by using all the original letters exactly once
    //eat, tea, ate,  tan, nat,
    public List<List<String>> groupAnagrams(String[] strs) {
        //for each key(sortedWord) I store a list of words, which are all anagrams of this key
        Map<String, List<String>> map = new HashMap<>();

        //iterate over words, we will take each string
        for (String word : strs) {
            //convert each word to a character array
            char[] chars = word.toCharArray();
            //we create a key(sorted word) sort of for all of the anagrams; each word has its key and this key will equal to the sorted word
            //I sort the array of characters
            Arrays.sort(chars);
            //I create a sorted word and it will act as a key in my HashMap
            String sortedWord = new String(chars);
            //for ex, we iterate over above array and I have 'eat' word, I create 'eat' sorted version -> 'aet'

            //then I need to check, if I haven't see yet that sortedWord => 'aet', then for this key I will create an empty List<>
            if (!map.containsKey(sortedWord)) {
                //int [] arr = {"eat", "tea", "tan", "ate", "nat"};
                //for ex, I have word 'eat' its sortedWord='aet', since I haven't seen 'aet' yet before, for KEY 'aet' -> I create in my map an empty list and I insert for the key 'aet' THAT WORD 'eat', next I have a word 'tea' -> I create a sorted version its also 'aet', so in this same list where I have 'eat' I also insert 'tea', next I see 'tan' but I haven't seen sortedWord='ant' so for it -> I create an empty list in my map and I insert word 'tan', next is 'ate' -> I have seen this before, so I insert in the list for key 'aet' I insert word 'ate' as well

                map.put(sortedWord, new ArrayList<>());
            }
            //next step I will insert for this particular key, I will add the current word
            map.get(sortedWord).add(word);
        }
        //so at the end I create a List of those Lists, those are simply values in my HashMap, all of those Lists and I create a big List with the value=Lists from my HashMap
        return new ArrayList<>(map.values());
    }


    public void main() {
    }
}