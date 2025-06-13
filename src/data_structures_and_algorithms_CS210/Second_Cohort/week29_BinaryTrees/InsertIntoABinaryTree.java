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
            if(root == null){
                return root;
            }

            if(val>root.val){
                return searchBST(root.right, val);
            }else if(val < root.val){
                return searchBST(root.left, val);
            }else{
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
    }
}
