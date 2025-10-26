package BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class Hot41 {
    int ans;                              //节点数
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
    public int diameterOfBinaryTree(TreeNode root) {
//        if(root==null)                               //空间复杂度O(h) 时间复杂度O(n)
//            return 0;
//        int left=0;
//        int right=0;
//        if(root.left!=null)
//            left=maxDepth(root.left);
//        if(root.right!=null)
//            right=maxDepth(root.right);
//        int d1=left+right;
//        int d2=diameterOfBinaryTree(root.left);
//        int d3=diameterOfBinaryTree(root.right);
//        return Math.max(d1,Math.max(d2,d3));
        ans=1;
        depth(root);
        return ans-1;
    }
//    public int maxDepth(TreeNode root){
//        if(root==null)
//            return 0;
//        int leftDepth=0;
//        int rightDepth=0;
//        if(root.left!=null){
//            leftDepth=maxDepth(root.left);
//        }
//        if(root.right!=null){
//            rightDepth=maxDepth(root.right);
//        }
//        return leftDepth>rightDepth?leftDepth+1:rightDepth+1;
//    }
    public int depth(TreeNode root){
        if(root==null)
            return 0;
        int L=depth(root.left);
        int R=depth(root.right);
        ans=Math.max(ans,L+R+1);    //统计节点数
        return L>R?L+1:R+1;
    }
}
