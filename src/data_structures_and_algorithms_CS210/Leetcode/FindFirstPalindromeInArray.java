package data_structures_and_algorithms_CS210.Leetcode;

public class FindFirstPalindromeInArray {
    public String firstPalindrome(String[] words) {
        String str = "";
        for (int i = 0; i < words.length; i++) {
            char[] charArr = words[i].toCharArray();
            int left = 0;
            int right = charArr.length - 1;
            boolean isPalindrome = true;
            while (left < right) {
                if(charArr[left]!=charArr[right]){
                    isPalindrome = false;
                    break;
                }
                left++;
                right--;
            }


            if (isPalindrome) {
                return words[i];
            }
        }
        return str;
    }

}
