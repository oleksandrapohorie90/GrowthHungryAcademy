package data_structures_and_algorithms_CS210.Leetcode.Stack;

import java.util.Stack;

public class CrawlerLogFolder {
    // public int minOperations(String[] logs) {
    //     int steps = 0;

    //     for (int i = 0; i < logs.length; i++) {
    //         switch (logs[i]) {
    //             case "./":
    //                 break;
    //             case "../":
    //                 if (steps > 0) {
    //                     steps--;
    //                 }
    //                 break;
    //             default:
    //                 steps++;
    //                 break;
    //         }
    //     }
    //     return steps;
    // }
    public int minOperations(String[] logs) {
        Stack<String> stack = new Stack<>();

        for (String str : logs) {
            if(str.equals("./")){
                //do nothing
            }else if(str.equals("../")){
                if(!stack.isEmpty()){
                    stack.pop(); //decrement
                }
            }else{
                stack.push(str);//increment
            }
        }

        return stack.size();
    }

}
