package data_structures_and_algorithms_CS210.Leetcode.Stack;

import java.util.Stack;

public class FinalPricesWithSpecialDiscountInShop {
    public int[] finalPrices(int[] prices) {
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < prices.length; i++) {
            // If the current price is less than or equal to the price at the index on top of the stack
            while (!stack.isEmpty() && prices[stack.peek()] >= prices[i]) {
                int idx = stack.pop();
                prices[idx] -= prices[i];
            }
            stack.push(i); // Store index instead of value
        }

        return prices;
    }
}