package foundation_pre_course.week11;

public class ReverseBits {
    //session 1
    //boolean logic lecture
    //bitmask

    /**
     * Reverse bits of a given 32 bits unsigned integer.
     * Note:
     * Note that in some languages, such as Java, there is no unsigned integer type. In this case, both input and output will be given as a signed integer type. They should not affect your implementation, as the integer's internal binary representation is the same, whether it is signed or unsigned.
     * In Java, the compiler represents the signed integers using 2's complement notation. Therefore, in Example 2 above, the input represents the signed integer -3 and the output represents the signed integer -1073741825.
     * <p>
     * Example 1:
     * Input: n = 00000010100101000001111010011100
     * Output:    964176192 (00111001011110000010100101000000)
     * Explanation: The input binary string 00000010100101000001111010011100 represents the unsigned integer 43261596, so return 964176192 which its binary representation is 00111001011110000010100101000000.
     * Example 2:
     * Input: n = 11111111111111111111111111111101
     * Output:   3221225471 (10111111111111111111111111111111)
     * Explanation: The input binary string 11111111111111111111111111111101 represents the unsigned integer 4294967293, so return 3221225471 which its binary representation is 10111111111111111111111111111111.
     */
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int res = 0;
        for (int i = 0; i <= 31; i++) {
            //           543210
            //00000000101010111 n
            //00000000000000001 => to see if a bit is enabled we have to apply & operation 1 & 1 = 1 -> if res=1 then the bit is on/enabled
            //00000000000000001

            //how to set a bit ??
            //0000000000110 -> result
            // take above result and OR bit with below bitmask
            //0000000010000 -> bitmask
            //0000000010110 -> result | bitmask

            //(n>>5) & 1
            int bit = (n >> i) & 1;
            if (bit == 1) { //this bit can be 1 or 0 only, if n's i-th bit is true, then
                //if 0's bit is enabled ==1 we need to enable the 31st bit
                res |= 1 << (31 - i);//set true the result's (31-i)-th bit

            }
        }
        return res;
    }
}
