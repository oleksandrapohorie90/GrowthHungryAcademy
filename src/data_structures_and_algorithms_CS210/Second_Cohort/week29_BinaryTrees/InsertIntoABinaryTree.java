package data_structures_and_algorithms_CS210.Second_Cohort.week29_BinaryTrees;

public class InsertIntoABinaryTree {
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

        public TreeNode searchBST(TreeNode root, int val) {
            //base case
            if (root == null) {
                return root;
            }

            if (val > root.val) {
                return searchBST(root.right, val);
            } else if (val < root.val) {
                return searchBST(root.left, val);
            } else {
                return root;
            }
        }

        public TreeNode insertIntoBST(TreeNode root, int val) {

            //base case, if no nodes and we have one to insert, create a new node
            if (root == null) {
                return new TreeNode(val);
            }

            if (val > root.val) {
                root.right = insertIntoBST(root.right, val);
            } else {
                root.left = insertIntoBST(root.left, val);
            }

            return root;
        }

        /**
         * Definition for a binary tree node.
         * public class TreeNode {
         * int val;
         * TreeNode left;
         * TreeNode right;
         * TreeNode() {}
         * TreeNode(int val) { this.val = val; }
         * TreeNode(int val, TreeNode left, TreeNode right) {
         * this.val = val;
         * this.left = left;
         * this.right = right;
         * }
         * }
         */
        class Solution {
            public TreeNode deleteNode(TreeNode root, int key) {
                //base case
                if (root == null) {
                    return root;
                }

                if (key > root.val) {
                    root.right = deleteNode(root.right, key);
                } else if (key < root.val) {
                    root.left = deleteNode(root.left, key);
                } else {
                    //cases when one of the roots children is null
                    if (root.left == null) return root.right;//search in right subtree
                    if (root.right == null) return root.left;//search in left subtree
//find minfrom subtree to delete, so we still have a balanced tree
                    TreeNode cur = root.right;//go to right sub tree
                    while (cur.left != null) { //in the right sub tree go to leftmost node till its null
                        cur = cur.left; //get the val of the min left most node, bc it will be smaller than right subtree
                    }
                    root.val = cur.val; //assign found min cur.val to the root.val
                    root.right = deleteNode(root.right, root.val); //now delete that last leaf of cur.val that you fund earlier in the right subtree
                }
                return root;
            }
/**
 5
 / \
 3   8
 /
 6
 Steps:
 5 has two children.

 Go to 5.right → it's 8.

 Go to 8.left → it's 6. (this is the smallest in the right subtree)

 Replace 5.val with 6 → tree becomes:
 6
 / \
 3   8
 /
 6
 Now delete 6 from the right subtree (deleteNode(8, 6))
 Resulting in:
 6
 / \
 3   8
 */

        }

    }
}
