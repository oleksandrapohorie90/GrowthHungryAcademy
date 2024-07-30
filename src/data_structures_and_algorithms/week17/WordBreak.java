package data_structures_and_algorithms.week17;

import java.util.Arrays;
import java.util.List;

public class WordBreak {
    //Basic backtracking problem
    private int[] memo;

    public boolean wordBreak(String s, List<String> wordDict) {
        memo = new int[s.length()]; //an array where I store that certain suffixes are impossible to compute,is a certain suffix impossible to break
        Arrays.fill(memo, -1);
        return match(s, wordDict, 0);
    }
    /*
    s = "abc"
    wordDict = ["ab","a","b"]
    return match(s="abc", wordDict=["ab","a", "b"], i=0)
     */

    private boolean match(String s, List<String> wordDict, int i) {
        if (i == s.length()) { //I broke my string s into words from wordDict, so return true
            return true;
        }

        if (memo[i] == -1) {
            for (String word : wordDict) {

                int l = word.length();
                if (i + l - 1 < s.length() && s.substring(i, i + 1).equals(word)) {
                    boolean result = match(s, wordDict, i + l);
                    if (result) {
                        memo[i] = i;
                        break;
                    }
                }
            }
            if (memo[i] != 1) {
                memo[i] = 0;
            }
        }
        return memo[i] == 0 ? false : true;
    }
}
