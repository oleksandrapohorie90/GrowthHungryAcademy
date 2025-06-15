package data_structures_and_algorithms_CS210.Second_Cohort.week29_BinaryTrees;

import java.util.ArrayDeque;
import java.util.Deque;

public class BFS {
    //BREADTH FIRST SEARCH(level order traversal) - NO recursion instead iterative approach
    //go layer by layer - all the closest nodes first then all the next closest once in the next layer
    //usually you go left to right
    //FIFO - use QUEUE ds
    // Definiton of TreeNode in Java

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
            left = null;
            right = null;
        }
    }

    //time complexity - O(n) - the size of the DS we are traversing which the number of nodes, even though has empty loops, we traverse each node once, we had 3 operations for each node: ad, print, pop
    public void bfs(TreeNode root) {
        //Deque - a double ended queue
        Deque<TreeNode> queue = new ArrayDeque<TreeNode>();
        if (root != null) {//if empty add a node
            queue.add(root);
        }
        int level = 0; //count levels
        while (!queue.isEmpty()) { //as long as queue is not empty lets run the loop
            System.out.print("level " + level + ": ");
            int levelLength = queue.size();
            for (int i = 0; i < levelLength; i++) {
                TreeNode curr = queue.removeFirst(); //we're adding elements to the right and popping from the left, this is a standard queue pop we pop from the opposite site of where we pushing > FIFO
                System.out.print(curr.val + " ");
                if (curr.left != null) { //if left child is not null we want to add it to the queue
                    queue.add(curr.left);
                }
                if (curr.right != null) { //if right child is not null we want to add it to the queue
                    queue.add(curr.right);
                }
            }
            level++;
            System.out.println();
        }
    }

}
