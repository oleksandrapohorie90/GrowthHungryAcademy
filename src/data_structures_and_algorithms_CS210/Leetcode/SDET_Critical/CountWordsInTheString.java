package data_structures_and_algorithms_CS210.Leetcode.SDET_Critical;

public class CountWordsInTheString {
    public static void main(String[] args) {
        String str = " Hello world Java ";
        System.out.println(countWordsInString(str));
    }

    public static int countWordsInString(String str) {
        //trim() removes spaces at the beginning and end of the string.
        //.split() returns an array of words.
        //And arrays have a property called .length (note: no parentheses!) — that tells us how many elements are in the array.
        return str.trim().isEmpty() ? 0 : str.trim().split("\\s").length;
    }
}
