package algos_and_ds;

import java.util.Scanner;

public class Recursion {
    public static void main(String[] args) {
        Scanner in = new Scanner((System.in));
        int t = in.nextInt();
        while(t>0){
            t--;
            int a = in.nextInt();
            int b = in.nextInt();
            System.out.println(fastExp(a,b));
        }
    }
    private static int fastExp(int a, int b){
        if(b==0) return 1;
        int x = fastExp(a,b/2);
        long result = x*1L *a% 1000000007L;
        return (int)result;
    }
}
