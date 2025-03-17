package cs_and_programming.Second_Cohort;

import java.util.Scanner;

public class Inrepreners_I {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();

        while (!"quit".equalsIgnoreCase(line)) {
            String[] expr = line.split(" ");
            if (expr.length != 3) {
                System.out.println("Invalid expression received: " + line);
                continue;
            }
            line = scanner.nextLine();
        }

    }
}
