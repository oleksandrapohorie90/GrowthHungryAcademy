package data_structures_and_algorithms_CS210.Leetcode.SDET_Critical;

public class IfDivBy5_divBy3 {

   public static String labelNumber(int num) {
        if (num % 5 == 0) return "ABC";
        else if (num % 3 == 0) return "other";
        else return String.valueOf(num);
    }
}
