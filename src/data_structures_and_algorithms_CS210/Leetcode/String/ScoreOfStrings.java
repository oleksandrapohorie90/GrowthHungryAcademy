package data_structures_and_algorithms_CS210.Leetcode.String;

public class ScoreOfStrings {
    public int scoreOfString(String s) {
        int absolute_sum = 0;


        for(int i=0; i<s.length()-1; i++){
            absolute_sum += Math.abs(s.charAt(i)-s.charAt(i+1));
        }
        return absolute_sum;
    }
}
