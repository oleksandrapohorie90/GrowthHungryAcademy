package data_structures_and_algorithms_CS210.Second_Cohort.week29_BinaryTrees;

public class InvertBinaryTree {

    public class TreeNode {
        int val;
        TreeNode right = null;
        TreeNode left = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;

        TreeNode invertedLeftNode = invertTree(root.left);
        TreeNode invertedRightNode = invertTree(root.right);

        root.left = invertedRightNode;
        root.right = invertedLeftNode;

        return root;
    }
}
