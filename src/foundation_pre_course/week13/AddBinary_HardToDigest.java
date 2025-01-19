package foundation_pre_course.week13;

public class AddBinary_HardToDigest {
    /*
    Given two binary strings a and b, return their sum as a binary string.
Example 1:

Input: a = "11", b = "1"
Output: "100"
Example 2:

Input: a = "1010", b = "1011"
Output: "10101"

Constraints:

1 <= a.length, b.length <= 104
a and b consist only of '0' or '1' characters.
Each string does not contain leading zeros except for the zero itself.
     */
    public static void main(String[] args) {
        String a = "1010";
        String b = "1011";
        System.out.println(addBinary(a, b));
    }

    public static String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int i = a.length() - 1;
        int j = a.length() - 1;
        int carry = 0;

        while (carry > 0 || i >= 0 || j >= 0) {
            int sum = carry;
            if (i >= 0) {
                //converts the character to its integer value (0 or 1).
                sum += a.charAt(i) - '0';
                //is decremented to move to the next bit to the left.
                i--;
            }
            if (j >= 0) {
                sum += b.charAt(j) - '0';
                j--;
            }
            //Determines the new carry. In binary addition, a sum of 2 or 3 means there's a carry of 1.
            carry = sum / 2;

            //Appends the current bit to the StringBuilder. sum % 2 gives the remainder when sum is divided by 2, effectively providing the current bit (0 or 1).
            sb.append(sum % 2);
        }
        return sb.reverse().toString();
    }

}
