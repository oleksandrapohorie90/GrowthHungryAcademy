package data_structures_and_algorithms_CS210.Second_Cohort.week29_BinaryTrees;


public class MaxDepth {
    private class TreeNode {
        int val;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public int maxDepth(TreeNode v) {
        if (v == null) {
            return 0;
        }
        if (v.left == null && v.right == null) {
            return 1;
        }

        int max_depth = 0;
        if (v.left != null) max_depth = Math.max(max_depth, maxDepth(v.left));
        if (v.right != null) max_depth = Math.max(max_depth, maxDepth(v.right));

        return max_depth + 1;
    }
}
