package data_structures_and_algorithms_CS210.Second_Cohort.neetcode_backtracking;

import java.util.ArrayList;

public class CanReachTheLeaf_IsAPath {
    /**
     * apply backtracking to a binary tree -
     * if a path exists from the root to the leaf node, as long as entire path doesnt contain any zeroes
     * <p>
     *   4
     *  / \
     * 0   1
     / \  / \
     * 7  2  0
     * <p>
     * 1. start at root node, make sure not zero
     * 2. check the left side of a tree, its a ZERO > go back up >
     * the IDEA is like going in the MAZE - when a dead end you turn around
     * and backtrack to reach the end, we recursively try every single path
     * you go through every single possibility, if a regular tree and not BST,
     * you have no idea which path can lead to the end
     * 3. go to right sub tree > has children then continue > go to left child
     * doesnt have children so we found the answer there is a path, no NEED to look
     * in the right subtree, we have a path return TRUE
     */

    public class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }

    public boolean canReachLeaf(TreeNode root) {
        if (root == null || root.val == 0) {
            return false;
        }
        if (root.left == null && root.right == null) {
            return true;
        }
        if (canReachLeaf(root.left)) {
            return true;
        }
        if (canReachLeaf(root.right)) {
            return true;
        }
        return false;
    }

    /**
     * <p>
     *   4
     *  / \
     * 0    1
     / \   / \
     * 7  3   2
     *     \
     *      0
     * <p>
     */

//2nd option - more complicated, what values of that path will look like
    //O(n) will run through all possible options - thru size of the tree
    public boolean leafPath(TreeNode root, ArrayList<Integer> path) {
        if (root == null || root.val == 0) {
            return false;
        }

        path.add(root.val);

        if (root.left == null && root.right == null) {
            return true;
        }
        if (leafPath(root.left, path)) {
            return true;
        }
        if (leafPath(root.right, path)) {
            return true;
        }
        path.remove(path.size() - 1);
        return false;
    }
}
