package algos_and_ds;

import java.util.Scanner;

public class TowerOfHanoi {
    public static void main (String[] args) throws java.lang.Exception
    {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        System.out.println((1 << n) - 1);
        hanoi(n, 1, 3, 2);
    }

    private static void hanoi(int n, int s, int f, int i) {
        if (n == 0) return;
        hanoi(n - 1, s, i, f);
        System.out.println(s + " " + f);
        hanoi(n - 1, i, f, s);
    }
}
