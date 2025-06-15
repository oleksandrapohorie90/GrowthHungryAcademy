package data_structures_and_algorithms_CS210.Second_Cohort.week29_BinaryTrees;

import java.util.Arrays;

public class ConstructBinaryTreefromPreorderAndInorderTraversal {

    public class TreeNode {
        int val;
        TreeNode right = null;
        TreeNode left = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0 || inorder.length == 0) {
            return null;
        }
        //we know that preorder starts with root always, so the first elemnt in the arr
        //will be a root
        TreeNode root = new TreeNode(preorder[0]);

        int mid = 0; //we need a mid pinter in the inorder arr
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == preorder[0]) {
                mid = i;//now find an index of that mid value, the 1st element in the
                //preorder arr = root it will be the middle point in the inorder array
                //from which we will find left node from the left of root
                //and right node from the right of node
                break;
            }
        }

        //now we need to buid left subtree since we have a root
        int[] leftPreorder = Arrays.copyOfRange(preorder, 1, mid + 1);
        int[] leftInorder = Arrays.copyOfRange(inorder, 0, mid);
        root.left = buildTree(leftPreorder, leftInorder);

        //now build right subtree
        int[] rightPreorder = Arrays.copyOfRange(preorder, mid + 1, preorder.length);
        int[] rightInorder = Arrays.copyOfRange(inorder, mid + 1, inorder.length);
        root.right = buildTree(rightPreorder, rightInorder);

        return root;
    }

}
