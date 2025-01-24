package data_structures_and_algorithms_CS210.First_Cohort.week8;

import java.util.ArrayList;

public class LongestPalindrome {
    public static void main(String[] args) {
        String str = "aybabtu";
        System.out.println(longestPalindrome(str));

    }

    public static String longestPalindrome(String str) {
        String longest = "";
        ArrayList<String> list = new ArrayList<>();

        for (int i = 0; i < str.length(); i++) {
            for (int j = i + 1; j < str.length(); j++) {
                list.add(str.substring(i, j));
            }
        }
        for (String each : list) {
            String reverse = "";
            for (int i = each.length() - 1; i >= 0; i--) {
                reverse += each.charAt(i);
            }
            if(each.equalsIgnoreCase(reverse) && each.length() > longest.length()){
                longest=each;
            }
        }
        return longest;
    }


}
