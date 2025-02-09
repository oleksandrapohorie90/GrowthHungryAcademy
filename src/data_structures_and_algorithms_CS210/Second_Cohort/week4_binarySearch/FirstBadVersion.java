package data_structures_and_algorithms_CS210.Second_Cohort.week4_binarySearch;

public class FirstBadVersion extends VersionControl {
    /**
     * You are a product manager and currently leading a team to develop a new product. Unfortunately, the latest version of your product fails the quality check. Since each version is developed based on the previous version, all the versions after a bad version are also bad.
     * <p>
     * Suppose you have n versions [1, 2, ..., n] and you want to find out the first bad one, which causes all the following ones to be bad.
     * <p>
     * You are given an API bool isBadVersion(version) which returns whether version is bad. Implement a function to find the first bad version. You should minimize the number of calls to the API.
     * <p>
     * Example 1:
     * <p>
     * Input: n = 5, bad = 4
     * Output: 4
     * Explanation:
     * call isBadVersion(3) -> false
     * call isBadVersion(5) -> true
     * call isBadVersion(4) -> true
     * Then 4 is the first bad version.
     * Example 2:
     * <p>
     * Input: n = 1, bad = 1
     * Output: 1
     */

    /* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */
    public int firstBadVersion(int n) {
        int left = 1;
        int right = n;
        int answer = -1;
        while (left <= right) {
            //int middle = (left + right) / 2; -> integer overflow
            int middle = left + (right - left) / 2; //common technique to avoid int overflow
            if (!isBadVersion(middle)) {
                left = middle + 1;
            } else { //it is a bad version
                //there might be or not an earlier bad vesrion,
                //but, nevertheless, lets save answer = middle
                answer = middle;
                right = middle - 1;
            }
        }
        return answer;
    }

}
