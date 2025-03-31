package data_structures_and_algorithms_CS210.Second_Cohort.week22;

import java.util.Stack;

public class DailyTemperatures {
//to find the next bigger number
public int[] dailyTemperatures(int[] temperatures) {
    int n = temperatures.length;

    // Initially, all 0, stores distance between their next greater element
    // and the current temperature.
    int[] nge = new int[n];

    Stack<Integer> st = new Stack<>();
    // Move from right to left.
    for (int i = n - 1; i >= 0; i--) {
        // Pop until we find the next greater element to the right
        // (until temperatures[st.top()] > temperatures[i]).
        while (!st.isEmpty() && temperatures[st.peek()] <= temperatures[i]) {
            st.pop();
        }

        // If the stack is not empty, then we have some next greater element,
        // so we take the distance between the next greater and the current temperature.
        if (!st.isEmpty()) {
            nge[i] = st.peek() - i; // The distance between next greater and current.
        }

        // Push the index of the current temperature in the stack.
        st.push(i);
    }

    return nge;
}

}
