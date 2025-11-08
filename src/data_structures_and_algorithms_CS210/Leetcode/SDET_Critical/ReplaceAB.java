package data_structures_and_algorithms_CS210.Leetcode.SDET_Critical;

public class ReplaceAB {
    public static void main(String[] args) {
        int a = 9;
        int b = 10;
        swap(a, b);
    }

    public static void swap(int a, int b) {
        a = a + b;
        b = a - b;
        a = a - b;

        System.out.print(a + "," + b);
    }
}
