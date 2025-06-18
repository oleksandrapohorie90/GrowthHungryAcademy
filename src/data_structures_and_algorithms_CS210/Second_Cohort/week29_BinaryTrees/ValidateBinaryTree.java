package data_structures_and_algorithms_CS210.Second_Cohort.week29_BinaryTrees;

public class ValidateBinaryTree {
    private class TreeNode {
        int val;
       TreeNode left = null;
       TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }
    public boolean isValidBST(TreeNode root) {

        return isValidBSTHelper(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean isValidBSTHelper(TreeNode root, long low, long high) {
        if (root == null)
            return true; //if no children - valid bst

        if (root.val <= low || root.val >= high)
            return false;

        return isValidBSTHelper(root.left, low, root.val) && isValidBSTHelper(root.right, root.val, high);

    }
}
