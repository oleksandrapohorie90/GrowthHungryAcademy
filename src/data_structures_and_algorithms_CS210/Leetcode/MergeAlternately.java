package data_structures_and_algorithms_CS210.Leetcode;

public class MergeAlternately {
    public String mergeAlternately(String word1, String word2) {
        char[] charArray1 = word1.toCharArray();
        char[] charArray2 = word2.toCharArray();
        char[] charArray = new char[word1.length() + word2.length()];

        int p1 = 0, p2 = 0;
        int i = 0;

        while (p1 < charArray1.length || p2 < charArray2.length) {
            if (p1 < charArray1.length) {
                charArray[i++] = charArray1[p1++];
            }
            if (p2 < charArray2.length) {
                charArray[i++] = charArray2[p2++];
            }
        }

        return new String(charArray);
    }
}
