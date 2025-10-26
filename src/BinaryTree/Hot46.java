package BinaryTree;

import com.sun.source.tree.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Hot46 {
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
    public List<Integer> rightSideView(TreeNode root) {
        if(root==null)
            return new ArrayList<>();
        List<Integer> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int size;
        while(!queue.isEmpty()){
            size= queue.size();
            res.add(queue.peek().val);
            for(int i=0;i<size;i++){
                root=queue.poll();
                if(root.right!=null)
                    queue.offer(root.right);
                if(root.left!=null)
                    queue.offer(root.left);
            }
        }
        return res;
    }
}
