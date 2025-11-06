package data_structures_and_algorithms_CS210.Leetcode.SDET_Critical;

public class IsPrime {
    public static void main(String[] args) {
        int num = 7;
        System.out.println(isPrime(num));
    }

    public static boolean isPrime(int num) {
        if (num <= 1) return false;
        for (int i = 2; i < num; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

//    boolean isPrime(int num) {
//        if (num <= 1) return false;
//        for (int i = 2; i <= Math.sqrt(num); i++) {
//            if (num % i == 0) return false;
//        }
//        return true;
//    }

}
