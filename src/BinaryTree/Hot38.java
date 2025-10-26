package BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class Hot38 {
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
    public int maxDepth(TreeNode root){
//        if(root==null)                                              //空间复杂度O(h) 时间复杂度O(n)
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

        if(root==null)
            return 0;
        Queue<TreeNode> queue =new LinkedList<>();      //空间复杂度O(w) 时间复杂度O(n)，w为树的最大宽度
        int ans=0;
        queue.offer(root);
        TreeNode node;
        int size;
        while(!queue.isEmpty()){
            size= queue.size();
            for(int i=0;i<size;i++){
                node= queue.poll();
                if(node.left!=null){
                    queue.offer(node.left);
                }
                if(node.right!=null){
                    queue.offer(node.right);
                }
            }
            ans+=1;
        }
        return ans;
    }
}
