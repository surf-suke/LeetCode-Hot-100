package BinaryTree;

public class Hot44 {
    public class TreeNode{
        int val ;
        TreeNode left;
        TreeNode right;
        TreeNode(){}
        TreeNode(int val) {this.val = val ;}
        TreeNode(int val, TreeNode left, TreeNode right){
            this.val = val ;
            this.left = left;
            this.right = right;
        }
    }
    public boolean isValidBST(TreeNode root) {
         if(root==null)
             return true;
         TreeNode pre=null;
         TreeNode post=null;
         if(root.left!=null){
             pre=root.left;
             while(pre.right!=null){
                 pre=pre.right;
             }
         }
         if(root.right!=null){
             post=root.right;
             while(post.left!=null) {
                 post = post.left;
             }
         }
         if((pre!=null && pre.val>=root.val) || (post!=null && post.val<=root.val))
             return false;
         boolean left=isValidBST(root.left);
         boolean right=isValidBST(root.right);
         return left && right;
    }
}
