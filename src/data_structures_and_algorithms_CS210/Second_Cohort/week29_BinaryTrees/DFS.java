package data_structures_and_algorithms_CS210.Second_Cohort.week29_BinaryTrees;

public class DFS {
    public void inorder(InsertIntoABinaryTree.TreeNode root) {
        if (root == null) {
            return;
        }
        inorder(root.left);
        System.out.println(root.val);
        inorder(root.right);
    }

    public void preorder(InsertIntoABinaryTree.TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.println(root.val);
        preorder(root.left);
        preorder(root.right);
    }

    public void postorder(InsertIntoABinaryTree.TreeNode root) {
        if (root == null) {
            return;
        }
        postorder(root.left);
        postorder(root.right);
        System.out.println(root.val);
    }
}
