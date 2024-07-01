package cs_and_programming.week11;

import java.util.Scanner;

public class DSL {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            String raw_expr = sc.nextLine();
            if ("quit".equalsIgnoreCase(raw_expr)) break;

            String[] expr = raw_expr.split(" ");
            if (expr.length != 3) {
                throw new IllegalArgumentException("It doesnt support");
            }

            try {
                String operator = expr[0];
                int operator1 = Integer.parseInt(expr[1]);
                int operator2 = Integer.parseInt(expr[2]);

                int result = evaluate(operator, operator1, operator2);
                System.out.println(result);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        sc.close();
    }


    private static int evaluate(String operator, int operand1, int operand2) {

        switch (operator) {
            case "ADD":
                return operand1 + operand2;
            case "SUB":
                return operand1 - operand2;
            case "MUL":
                return operand1 * operand2;
            case "DIV":
                if (operand2 == 0) {
                    throw new IllegalArgumentException("Division by zero is not allowed");
                }
                return operand1 / operand2;
            default:
                throw new UnsupportedOperationException("Unsupported operation: " + operator);
        }

    }
}
