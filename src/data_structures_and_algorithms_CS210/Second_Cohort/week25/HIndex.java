package data_structures_and_algorithms_CS210.Second_Cohort.week25;

public class HIndex {
    public int hIndex(int[] citations) {
        // Say, a researcher has 5 research papers.
        // h-index is 5, if the researcher has >= 5 papers with >= 5 citations each. If not, then
        // h-index is 4, if the researcher has >= 4 papers with >= 4 citations each. If not, then
        // h-index is 3, if the researcher has >= 3 papers with >= 3 citations each. If not, then
        // h-index is 2, if the researcher has >= 2 papers with >= 2 citations each. If not, then
        // h-index is 1, if the researcher has >= 1 papers with >= 1 citations each. If not, then
        // h-index is 0.

        // buckets[5] -> # of papers with >= 5 citations.
        // buckets[4] -> # of papers with 4 citations.
        // buckets[3] -> # of papers with 3 citations.
        // buckets[2] -> # of papers with 2 citations.
        // buckets[1] -> # of papers with 1 citation.

        // If buckets[5] >= 5, then h-index is 5,
        // i.e. if (# of papers with >= 5 citations) >= 5.

        // If buckets[5] + buckets[4] >= 4, then h-index is 4,
        // i.e. if (# of papers with >= 4 citations) >= 4.

        // If buckets[5] + buckets[4] + buckets[3] >= 3, then h-index is 3,
        // i.e. if (# of papers with >= 3 citations) >= 3.

        // If buckets[5] + buckets[4] + buckets[3] + buckets[2] >= 2, then h-index is 2,
        // i.e. if (# of papers with >= 2 citations) >= 2.

        // If buckets[5] + buckets[4] + buckets[3] + buckets[2] + buckets[1] >= 1, then h-index is 1,
        // i.e. if (# of papers with >= 1 citations) >= 1.

        // Otherwise, h-index is 0.

        //Ex: citations = [4, 4, 4, 2, 1]
        //why not 4 ? - Because at i = 4:
        //
        //We only have 3 papers with 4 or more citations.
        //
        //But H=4 needs 4 papers, not 3.
        //
        //So H=4 is too big → not valid.

        int n = citations.length;
        int[] buckets = new int[n + 1];
        for (int c : citations) {
            if (c > n) {
                // It doesn't matter if a paper has more than n citations, because
                // h-index can't be more than n (the number of papers a researcher produced in total).
                // So, we can count this paper into n-th bucket.
                buckets[n]++;
            } else {
                buckets[c]++;
            }
        }
        int count = 0;
        for (int i = n; i >= 1; i--) {
            count += buckets[i];
            // count now equals (total number of papers with >= i citations)
            if (count >= i) { // if (total number of papers with >= i citations) >= i, then h-index = i.
                return i;
            }
        }
        return 0;
    }
}
