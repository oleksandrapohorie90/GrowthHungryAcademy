package data_structures_and_algorithms.week17;

public class CapacityToShipPackagesWithinDDays {

    public static void main(String[] args) {
        int [] weights = {1,2,3,4,5,6,7,8,9,10};
        int days = 5;

        System.out.println(shipWithinDays(weights, days));
    }
    public static int shipWithinDays(int[] weights, int D) {
        int left = 0;
        int right = 0;
        int answer = -1;
        for (int w : weights) {
            left = Math.max(left, w);
            right += w;
        }
        while (left <= right) {
            int middle = (left + right) / 2;
            int need = 1;
            int cur = 0;
            for (int w : weights) {
                if (cur + w > middle) {
                    need += 1;
                    cur = w;
                } else {
                    cur += w;
                }
            }
            if (need > D) {
                left = middle + 1;
            } else {
                answer = middle;
                right = middle - 1;
            }
        }
        return answer;
    }
}
