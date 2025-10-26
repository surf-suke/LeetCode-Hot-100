package BinaryTree;

public class Hot39 {
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
    public TreeNode invertTree(TreeNode root) {
        if(root==null)
            return null;
        TreeNode tmp;
        TreeNode left=null;
        TreeNode right=null;
        if(root.left!=null)
            left= invertTree(root.left);
        if(root.right!=null)
            right=invertTree(root.right);
        tmp=left;
        left=right;
        right=tmp;
        root.left=left;
        root.right=right;
        return root;

    }
}
