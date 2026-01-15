package data_structures_and_algorithms_CS210.Leetcode;

public class TaskTwo {
    public static void main(String[] args) {

        int number = -1;
        int a = 1;
        int b = 2;
        int c = 3;

        System.out.println(evenOrOdd(number));
        //System.out.println(isPalindrome(number));
    }

    public static String evenOrOdd(int num){

    return num % 2 == 0 ? "even" : "odd";
    }

    public static int findAverage(int a, int b, int c){

        return (a+b+c)/3;
    }

    public static boolean isPalindrome(int number){
        int res = 0;
        int actualNumber = number;

        if(number <= 0){
            return false;
        }

        if(number % 10 == 0){
            return false;
        }
        //121
        while(number > 0){
            int lastDigit = number % 10;
            res = res * 10 + lastDigit;
            number = number / 10;
        }

        return actualNumber == res;
    }
}
