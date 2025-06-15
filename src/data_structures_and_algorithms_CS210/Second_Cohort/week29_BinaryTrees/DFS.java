package data_structures_and_algorithms_CS210.Second_Cohort.week29_BinaryTrees;

public class DFS {
    public void inorder(InsertIntoABinaryTree.TreeNode root) {
        //traverse through the entire tree to traverse through the tree in a sorted order
        //recursive function - goes from bottom to top each time node by node > left to right child
        //when we reach the top root node then go to right child, we go all the way to the bottom first starting from left node
        //process the entire left subtree left child > go to left child first > then right child first > make sure they dont have kids, if not root==null go back up step by step
        //go back to parent > go to right subtree and start from left child again check if has children if root ==null go back up to parent and print the parent root then > go to right child, check if has children
        //LEFT > CURRENT_NODE > RIGHT
        if (root == null) {
            return;
        }
        inorder(root.left);
        System.out.println(root.val);
        inorder(root.right);
    }

    public void preorder(InsertIntoABinaryTree.TreeNode root) {
        //VISIT THE ROOT NODE THEN VISIT ITS CHILDREN
        //start from left subtree then to right subtree
        //print first then preorder(left) and preorder(right)
        if (root == null) {
            return;
        }
        System.out.println(root.val);
        preorder(root.left);
        preorder(root.right);
    }

    public void postorder(InsertIntoABinaryTree.TreeNode root) {
        //traverse all the val's in the left subtree then traverse all the values in the right subtree and then print the root node
        if (root == null) {
            return;
        }
        postorder(root.left);
        postorder(root.right);
        System.out.println(root.val);
    }

    /**
     * reversed order - start from very last right subtree child
     * then go up step by step to the root node and go to left subtree
     */
    public void reversedOrder(InsertIntoABinaryTree.TreeNode root) {
        if (root == null) {
            return;
        }
        postorder(root.right);
        System.out.println(root.val);
        postorder(root.left);
    }
}
