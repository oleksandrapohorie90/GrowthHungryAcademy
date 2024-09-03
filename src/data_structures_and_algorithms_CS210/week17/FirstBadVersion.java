package data_structures_and_algorithms_CS210.week17;

public class FirstBadVersion extends VersionControl {

    @Override
    boolean isBadVersion(int version) {
        return false;
    }

    //VersionControl is another class that has isBadVersion API defined
    public int firstBadVersion(int n) {
        int left = 1;
        int right = n;
        int answer = -1;

        while (left <= right) {
            //int middle = (left+right)/2; -> int overflow
            int middle = left + (right - left) / 2;
            if (!isBadVersion(middle)) {
                left = middle + 1;
            } else {
                //it is a bad version, there might be or not an earlier bad version,
                //but nevertherless lets save answer=middle
                answer = middle;
                right = middle - 1;
            }
        }
        return answer;
    }
}
