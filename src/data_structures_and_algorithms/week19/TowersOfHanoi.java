package data_structures_and_algorithms.week19;

import java.io.InputStreamReader;
import java.io.PrintWriter;

public class TowersOfHanoi {
    //for recursion you have to define base case
    //it can be divided by subproblems and subproblems can be solved in the same way as
    private void hanoi(int n, int from, int to) {
        if (n == 0) return;
        int aux = (1 + 2 + 3) - (from + to);
        //to know the aux rot, if from and to are subtr then we know which one is the aux
        //(1) - I want to ove n-1 disks from the starting rode to the auxilary(helper)rode
        hanoi(n - 1, from, aux);

        //(2) next I move largest 'n'th disk from the starting rod to the finish rod
        System.out.println(n + " " + from + " " + to);

        //(3) then I have 'n-1' disks on the auxilary rode, so I move those disks from the aux(helper) to the finish rode
        hanoi(n - 1, aux, to);
    }

    public void run(InputStreamReader in, PrintWriter out) {
        //int n = in.nextInt();
        //hanoi(n, 1, 3); -> in the very I move n disks from the 1 rode to the 3rd rode
    }
}
