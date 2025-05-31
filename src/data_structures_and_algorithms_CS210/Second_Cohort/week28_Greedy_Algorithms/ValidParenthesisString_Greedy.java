package data_structures_and_algorithms_CS210.Second_Cohort.week28_Greedy_Algorithms;

public class ValidParenthesisString_Greedy {
    public boolean checkValidString(String s) {
//O(1) space
        int low = 0; //lowest num of floating balloons possible so far
        int high = 0; //highest number of balloons possible so far
        for (char c : s.toCharArray()) {
            if (c == '(') { //float a new balloon
                low++;
                high++;
            } else if (c == ')') { //burst a balloon
                low--;
                high--;
            } else {
                //c=='*' -> we can either float a new balloon or burst
                low--;
                high++;
            }
            if (low < 0) {
                low = 0;
            }
            if (high < 0) { //no matter how much we tried to burst, we failed
                return false;
            }
        }
        return low == 0;
    }

}
