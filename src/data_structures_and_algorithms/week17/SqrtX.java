package data_structures_and_algorithms.week17;

public class SqrtX {

    public int mySqrt(int x) {
        //for special cases when x<is 0 or 1, return x
        if (x == 0 || x == 1) return x;

        //initialize search range for the square root
        int left = 1;
        int right = x;
        int answer = -1;

        //perform binary search to find a sqrt of x
        while (left <= right) {
            //calculate the middle point using "left +(right-left)/2" to avoid integer overflow
            int middle = left + (right - left) / 2;

            if ((long) middle * middle > (long) x) {
                //if the square of the middle value is greater than x, move the "right" to the left (mid-1)
                right = middle - 1;
            } else {
                //if square of the middle value is less than or equal to x, middle is the best candidate so far, so
                //save it and keep searching for better
                answer = middle;
                left = middle + 1;
            }
        }
        return answer;
    }
}
