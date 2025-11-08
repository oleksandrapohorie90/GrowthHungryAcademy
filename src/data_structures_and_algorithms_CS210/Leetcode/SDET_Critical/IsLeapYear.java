package data_structures_and_algorithms_CS210.Leetcode.SDET_Critical;

public class IsLeapYear {

    /*
    A year is a leap year if it is divisible by 4,
    Except if it’s also divisible by 100 — then it’s not a leap year,
    Unless it’s also divisible by 400 — then it is a leap year.
     */

    public static void main(String[] args) {
        int year = 2020;//Divisible by 4, not 100
        int year1 = 2000;//Divisible by 400
        int year2 = 1900;//Divisible by 100, not 400

        System.out.println(isLeapYear(year));
        System.out.println(isLeapYear(year1));
        System.out.println(isLeapYear(year2));
    }

    public static boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }

}
