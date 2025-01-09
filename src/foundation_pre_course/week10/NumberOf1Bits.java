package foundation_pre_course.week10;

public class NumberOf1Bits {
    //*bitmask
    // you have to compute AND operation on all bits and see if the result is non zero, if yes, then you have enabled a bit
    //from 0 to 30 since we are interested only in positive numbers
    public static void main(String[] args) {

    }

    public static int enabledBit(int n) {
        //binary representation in comp in general
        int one = 1 << 0;   //binary repr: 00001
        int two = 1 << 1;   //binary repr: 00010
        int four = 1 << 2;  //binary repr: 00100

        int answer = 0;
        for (int i = 0; i < 30; i++) {
            //i = 0, 000000000000001    <<shift 1 by 0
            //i = 1, 000000000000010    <<shift 1 by 1
            //i = 2, 000000000000100    <<shift 1 by 2
            //i = 3, 000000000001000    <<shift 1 by 3
            //...
            int bitmask = 1 << i;
            if ((n & bitmask) > 0) {
                answer++;
            }
            //x | y
            //x ^ y
            //x >> 1 -> right shift, you have to delete the last bit
        }
        return answer;
    }
}
