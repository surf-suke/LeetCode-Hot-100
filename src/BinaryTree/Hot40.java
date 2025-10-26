package BinaryTree;

public class Hot40 {
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
    public boolean isSymmetric(TreeNode root) {
        if(root==null)
            return true;
        return isSymmetricHelper(root.left,root.right);
    }
    public boolean isSymmetricHelper(TreeNode r1, TreeNode r2){
        if(r1==null && r2!=null)
            return false;
        if(r1!=null && r2==null)
            return false;
        if(r1==null && r2==null)
            return true;
        if(r1.val!=r2.val)
            return false;
        boolean r1LeftR2Right = isSymmetricHelper(r1.left,r2.right);
        boolean r1RightR2Left = isSymmetricHelper(r1.right,r2.left);
        return r1LeftR2Right && r1RightR2Left;
    }
}
