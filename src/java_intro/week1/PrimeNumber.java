package java_intro.week1;

public class PrimeNumber {
    public static void main(String[] args) {

        System.out.println(isPrime(10));
        System.out.println(isPrime(12));
        System.out.println(isPrime(5));

    }

    public static boolean isPrime(int number) {

        if (number <= 1) { //not prime
            return false;
        }
        for (int i = 2; i < number; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}
