package data_structures_and_algorithms_CS210.Leetcode.TwoPointers;

public class TaskThree {
    public static void main(String[] args) {
        int num = 62;
        System.out.println(FToC(num));
    }

    public static double FToC(int num){
        return (num - 32) / 1.8;
    }

    public static boolean isPrime(int num){

        if(num <= 1){
            return false;
        }

        for(int i=2; i<=(int)Math.sqrt(num); i++){
            if(num % i == 0){
                return false;
            }
        }

        return true;
    }
}
