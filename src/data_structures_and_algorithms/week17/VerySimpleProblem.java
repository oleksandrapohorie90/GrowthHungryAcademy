package data_structures_and_algorithms.week17;

import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Scanner;

public class VerySimpleProblem {
    public void run(Scanner sc, PrintWriter out) {
        int n = sc.nextInt();
        int x = sc.nextInt();
        int y = sc.nextInt();

        int left = 0;
        int right = (int) 1e9;
        int answer = -1;
        n--;//first copy will be printed in Math.min(x,y) time. Next copies will utilize both printers.
        while (left <= right) {
            int middle = left + (right - left) / 2;
            //1st printer I can print middle/x copies on the 1st printer
            //middle/y copies on the 2nd printer

            if (middle / x + middle / y >= n) {//then this is enough time
                answer = middle;
                right = middle - 1; //keep search on the left
            } else {
                left = middle + 1; //then search on the right
            }
        }
        System.out.println(Math.min(x, y) + answer);
    }
}
