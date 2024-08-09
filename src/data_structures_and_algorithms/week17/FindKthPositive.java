package data_structures_and_algorithms.week17;

public class FindKthPositive {
    public int findKthPositive(int[] arr, int k) {
        //TODO: reqrite code it has mistakes

        int n = arr.length;
        //Assume 1-indexed array instead of 0-indexed array
        //assume there exists arr[n+1] = arr[n]+k
        //missing[n+1] = (arr[n] + k) - (n + 1)

        //k = 5
        //          1   2   3   4   5   6
        //arr    = [2,  3,  4,  7,  11] 16
        //missing= [1,  1,  1,  3,  6 ] 10
        //missing[i] = arr[i] - i
        //7..11 = 11 - 7 -1 =3 missing integers (8,9,10)

        //11
        //6
        //10 -> 6
        //9 -> 5


        //idea find min position 'pos' such that 'missing[po] >= k' ===> so number 6, 5th position
        //the answer => arr[pos] - (missing[pos] - k + 1) from 11 you need to subtract 2
        int left = 0;
        int right = n;
        int pos = -1;
        while (left <= right) {
            int middle = left + (right - left) / 2;
            int missing = middle == n ? (arr[n - 1] + k) - (middle + 1)
                    : arr[middle] - (middle + 1);
            if (missing >= k) {
                pos = middle;
                right = middle - 1;
            } else {
                left = middle + 1;
            }
        }
        if (pos == n) {
            int missing = (arr[n - 1] + k) - (n + 1);
            return (arr[n - 1] + k) - (missing - k + 1);
        }
        return arr[pos] - (arr[pos] - (pos + 1) - (k + 1) + 1);
    }
}
