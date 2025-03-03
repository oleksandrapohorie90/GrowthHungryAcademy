package data_structures_and_algorithms_CS210.Second_Cohort.week6_recurssion;

public class Practice {
    public static void main(String[] args) {
        //when a method called himself is recursion
        sayHi(3);
    }
    private static void sayHi(int count){
        System.out.println("HI");
        //base case - condition inside the method where it can return without making another recursive call
        //you need a base case otherwise the recursion will stock overflow
        if(count<=1) {
            return; //exits run of the method
        }
        sayHi(count - 1);
    }
}
