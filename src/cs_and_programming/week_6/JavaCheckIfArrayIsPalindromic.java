package cs_and_programming.week_6;

public class JavaCheckIfArrayIsPalindromic {

    public static void main(String[] args) {
        String[] str = {"Daaay", "DAD", "radar", "Testing", "automation"};
        isArrayPalindromic(str);
    }

    public static void isArrayPalindromic(String[] arr) {

        for (int i = 0; i < arr.length; i++) {
            //to assign each string to have smth to compare to after reversing
            String original = arr[i];
            System.out.println("My original string is " + original);
            //to init obj of string builder to use methods of reverse
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder = stringBuilder.append(original);
            String reversed = stringBuilder.reverse().toString();

            //to compare original and reversed options of the strings
            //to see if they equal => palindrome
            if (original.equals(reversed)) {
                System.out.println("This String is palindrome - " + reversed);
            } else {
                System.out.println("This String is NOT palindrome - " + reversed);
            }
        }
    }
}
