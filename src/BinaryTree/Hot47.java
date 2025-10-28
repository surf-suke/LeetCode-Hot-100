package BinaryTree;
public class Hot47 {
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
    public void flatten(TreeNode root) {
        TreeNode cur=root;
        TreeNode next,predecessor;
        while(cur!=null){
            if(cur.left!=null){
                next=cur.left;
                predecessor=next;
                while(predecessor.right!=null){
                    predecessor=predecessor.right;
                }
                predecessor.right=cur.right;
                cur.right=cur.left;
                cur.left=null;
            }
            cur=cur.right;
        }
    }
}
