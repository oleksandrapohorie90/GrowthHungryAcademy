package data_structures_and_algorithms_CS210.week16;

public class HIndexII {
    //straightforward binary search

    public int hIndex(int[] citations){
        //left boundary = 0(min index possible), right boundary = n-1(max index possible)
        //middle = (left+right)/2
        //Im looking at index middle[0,1,3,5,6] - central index is 3, 3 papers 3,5,6
        //if my h index = 3, array is sorted
        //how many papers do I have from middle to n-1 ? - number of papers I have = n - middle
        //if (citations[middle] >= (n-middle))
        //h_index = n-middle
        //right = middle -1
        //else
        //left = middle + 1
        int n = citations.length;
        int left = 0;
        int right = n-1;
        int h_index=0;
        while (left<=right){
            int middle = (left+right)/2;
            if(citations[middle]>=n-middle){
                h_index = n- middle;
                right = middle-1;
            }else{
                //
            }
        }
        return h_index;
    }
}
