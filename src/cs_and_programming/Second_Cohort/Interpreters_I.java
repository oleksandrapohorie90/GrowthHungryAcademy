package cs_and_programming.Second_Cohort;

import java.util.Scanner;

import static java.lang.Integer.valueOf;

public class Interpreters_I {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line;

        while (!"quit".equalsIgnoreCase(line = scanner.nextLine())) {
            String[] expr = line.split(" ");
            if (expr.length != 3) {
                System.out.println("Invalid expression received: " + line);
                continue;
            }
            try {
                String operator = expr[0];
                double operand1 = Double.parseDouble(expr[1]);
                double operand2 = Double.parseDouble(expr[2]);

                double result = evaluate(operator, operand1, operand2);
                System.out.printf("Result: %.2f%n", result);


            } catch (NumberFormatException e) {
                System.out.println("Invalid number received: " + line);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static double evaluate(String operator, double operand1, double operand2) {

        switch (operator) {
            case "ADD":
                return operand1 + operand2;
            case "SUB":
                return operand1 - operand2;
            case "MUL":
                return operand1 * operand2;
            case "DIV":
                if (operand2 == 0) {
                    throw new IllegalArgumentException("Cannot divide by zero");
                }
                return operand1 / operand2;
            case "POW":
                return (int) Math.pow(operand1, operand2);
            case "MOD":
                return operand1 % operand2;
            default:
                throw new UnsupportedOperationException("Operation is not supported" + operator);
        }

        //return Integer.parseInt(operator);

    }
}
