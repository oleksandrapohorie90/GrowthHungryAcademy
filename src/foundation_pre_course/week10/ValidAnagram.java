package foundation_pre_course.week10;

import java.util.Arrays;

public class ValidAnagram {
    public static void main(String[] args) {
        String str1 = "listen";
        String str2 = "silent";

        System.out.println(isAnagram(str1, str2));
        System.out.println(isAnagram2(str1, str2));
    }

    public static boolean isAnagram(String str1, String str2) {
        char[] arr1 = str1.toLowerCase().toCharArray();
        char[] arr2 = str2.toLowerCase().toCharArray();

        Arrays.sort(arr1);
        Arrays.sort(arr2);

        return Arrays.equals(arr1, arr2);
    }

    public static boolean isAnagram2(String str1, String str2) {
        int[] frequency = new int[26];
        for (char c : str1.toCharArray()) frequency[c - 'a']++;
        for (char d : str2.toCharArray()) frequency[d - 'a']--;
        for (int f : frequency) if (f != 0) return false;

        return true;

    }

}
