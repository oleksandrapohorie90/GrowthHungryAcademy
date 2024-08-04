package data_structures_and_algorithms.week17;

public class KokoEatingBananas {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int right = 0;
        for (int pile : piles) right = Math.max(right, pile);
        //max of piles is the max speed she might have
        int answer = -1;
        //she wants to eat slowly
        while (left <= right) {
            int middle = (left + right) / 2;
        //to avoid overflowing need to use long
            long total_hours = 0;
            for (int pile : piles) total_hours += (long) Math.ceil(pile * 1.0 / middle);

            if (total_hours <= (long)h) {
                answer = middle;
                right = middle - 1;
            } else {//total_hours > h
                left = middle + 1;
            }
        }

        //assume x bananas per hour - is this reasonable speed ?
        //will she be done in h hours or less

        //for (int pile : piles) total_hours += (int)math.ceil(pile/X);
        //else{...}
        return answer;
    }
}
