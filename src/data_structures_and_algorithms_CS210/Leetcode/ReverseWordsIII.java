package data_structures_and_algorithms_CS210.Leetcode;

public class ReverseWordsIII {
    public String reverseWords(String s) {
        String [] strArray = s.split(" ");
        String [] resArray = new String[strArray.length];
        String result = "";

        for(int i = 0; i<strArray.length; i++){
            String str = reversedStr(strArray[i]);
            resArray[i] = str;

        }

        return result = String.join(" ", resArray);
    }

    public String reversedStr(String str) {
        char [] charArr = str.toCharArray();
        int left = 0;
        int right = charArr.length-1;

        while(left<right){
            char temp = charArr[left];
            charArr[left] = charArr[right];
            charArr[right] = temp;
            left++;
            right--;
        }

        return new String(charArr);

    }
}
