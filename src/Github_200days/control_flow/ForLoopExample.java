package Github_200days.control_flow;

public class ForLoopExample {
    public static void main(String[] args) {
        //a counting loop var, how long it should loop
        for (int counter = 1; counter < 11; counter++) {
            System.out.printf("Counter is %d%n",counter);
        }
        String [] fruits = {"apple", "orange", "pear", "plum"};
        //enhanced for loop, if no index/counter
        for (String fruit: fruits) {
            System.out.println(fruit);
        }
    }
}
