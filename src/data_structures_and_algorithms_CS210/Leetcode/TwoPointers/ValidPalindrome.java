package data_structures_and_algorithms_CS210.Leetcode.TwoPointers;

public class ValidPalindrome {
    public boolean isPalindrome(String s) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            if (Character.isLetterOrDigit(s.charAt(i))) {
                sb.append(Character.toLowerCase(s.charAt(i)));
            }
        }

        String res = sb.toString();

        int left = 0;
        int right = res.length() - 1;
        while (left < right) {
            if (res.charAt(left) != res.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
