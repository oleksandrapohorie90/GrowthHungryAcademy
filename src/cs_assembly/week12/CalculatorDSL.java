package cs_assembly.week12;

import java.util.Scanner;

public class CalculatorDSL {
    /**
     * extend our DEMO to support
     * - 9.5.1 Decimals
     * - 9.5.2 MOD operation (%)
     * - 9.5.3 POW operation (^)
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            String row_expr = scanner.nextLine();
            if ("quit".equalsIgnoreCase(row_expr)) break;

            String[] expr = row_expr.split(" ");
            if (expr.length != 3) {
                throw new IllegalArgumentException("Input doesn't satisfy language rules " + expr);
            }

            try {
                String operator = expr[0];
                double operand1 = Double.parseDouble(expr[1]);
                double operand2 = Double.parseDouble(expr[2]);
                double result = evaluate(operator, operand1, operand2);
                System.out.println(result);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        scanner.close();
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
                    throw new IllegalArgumentException("Division by 0 is not allowed");
                }
                return operand1 / operand2;
            case "MOD":
                return operand1 % operand2;
            case "POW":
                return Math.pow(operand1, operand2);
            default:
                throw new IllegalArgumentException("Unsupported operation" + operator);
        }

    }
}
