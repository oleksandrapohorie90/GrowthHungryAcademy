package foundation_pre_course.week10;

import java.util.Arrays;

public class ValidAnagram {
    public static void main(String[] args) {
        String str1 = "listen";
        String str2 = "silent";

        System.out.println(isAnagram(str1, str2));
        System.out.println(isAnagram2(str1, str2));
        System.out.println(isAnagram3(str1, str2));
    }

    public static boolean isAnagram(String str1, String str2) {
        char[] arr1 = str1.toLowerCase().toCharArray();
        char[] arr2 = str2.toLowerCase().toCharArray();

        Arrays.sort(arr1);
        Arrays.sort(arr2);

        return Arrays.equals(arr1, arr2);
    }

    /**
 create a freq array w/ 26 indexes and iterate over str1, take each char and sub 'a' from it, we have 26 letters in english alphabet
     if you take 'a' - 'a'(sub ascii codes here = 97-97) => 0
     'b' - 'a' => 1 (98-97)
     ...just count how many letters you have, freq will count how many letters you have freq0 = how many 1's I have, freq1 how many b's etc
     'z' - 'a' => 25 (122-97)

     after 2 loops there will be only 0's in freq, bc letters were the same and each letter was incremented and decremented same num of times, if anagram

     if f is not 0 then for certain letter the freq were different
     */
    public static boolean isAnagram3(String str1, String str2) {
        int[] frequency = new int[26];
        for (int i =0; i< str1.length(); i++) frequency[str1.charAt(i) - 'a']++;
        for (int i =0; i< str2.length(); i++) frequency[str2.charAt(i) - 'a']--;
        for (int f : frequency) if (f != 0) return false;

        return true;

    }

    //less performant bc we convert toCharArr
    public static boolean isAnagram2(String str1, String str2) {
        int[] frequency = new int[26];
        for (char c : str1.toCharArray()) frequency[c - 'a']++;
        for (char d : str2.toCharArray()) frequency[d - 'a']--;
        for (int f : frequency) if (f != 0) return false;

        return true;

    }

}
