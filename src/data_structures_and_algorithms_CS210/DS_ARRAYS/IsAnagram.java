package data_structures_and_algorithms_CS210.DS_ARRAYS;

public class IsAnagram {
    public static void main(String[] args) {
        String a = "abc";
        String b = "cab";

        System.out.println(isAnagram(a, b));
    }
    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        int[] count = new int[26];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
            count[t.charAt(i) - 'a']--;
        }

        for (int val : count) {
            if (val != 0) {
                return false;
            }
        }
        return true;
    }
}
