package data_structures_and_algorithms_CS210.First_Cohort.week18;

public class ContainerWithMostWater {
    //Time complexity: O(n) times
    //the idea or formula is
    //answer = max(answer, (j-i) * min(height[i], height[j])) = max(0,8 * 1) = 8
    //How to move pointers? if left pillar is the shortest among them, then we move to the next position(increment left pointer)
    //left pointer is the shortest so move forward(right) by one

    //now execute formula again:
    //answer = max(answer, (j-i) * min(height[i], height[j])) = max(8,7 * 7) = 49
    //for right is the opposite if right is the shortest pillar-move to the left

    public int maxArea(int[] height) {
        int i = 0;
        int j = height.length - 1;

        int answer = 0;

        while (i < j) {//while they are not pointing to the same pillar
            //we fixed pillars i and j - now, we want to know how much water
            //we can fill in btw them.

            //width between pillars i and j
            //lets call it "w" for "width"
            int w = j - 1; //-> so with of the space btw them, the length of the space btw them

            //This is, at most, how much water can be filled vertically
            //at any point between pillars i and j, so that it doesnt't
            //spill over to the left of pillar i or to the right of pillar j
            //Lets call it "h" for "height"

            //we will call the lower pillar the "limiting factor"
            int h = Math.min(height[i], height[j]);

            //the total volume of water that can be filled between pillars i and j
            //lets call it "v" for "volume"
            int v = w * h;

            //update the answer
            answer = Math.max(answer, v);

            if (height[i] < height[j]) {
                //if pillar i is the "Limiting factor",
                //then lets move i to (i+1) in hopes that
                //it will improve our answer
                i++;
            } else {
                //otherwise, lets move j to (j-1) in hopes that it will
                //improve our answer
                j--;
            }
        }
        return answer;
    }
}



