package data_structures_and_algorithms_CS210.Second_Cohort.Neetcode;

public class LowestCommonAncestorInBinarySearchTree {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        if (p == root || q == root) return root;
        if (p.val < root.val && q.val > root.val) return root;
        if (Math.max(p.val, q.val) < root.val) return root = lowestCommonAncestor(root.left, p, q);
        if (Math.min(p.val, q.val) > root.val) return root = lowestCommonAncestor(root.right, p, q);
        return root;
    }

}
