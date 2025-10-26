package BinaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Hot42 {
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
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root==null)
            return new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list;
        Queue<TreeNode> queue = new LinkedList<>();
        int size;
        TreeNode cur;
        queue.offer(root);
        while(!queue.isEmpty()){
            size=queue.size();
            list= new ArrayList<>();
            for(int i=0;i<size; i++){
                cur=queue.poll();
                list.add(cur.val);
                if(cur.left!=null)
                    queue.offer(cur.left);
                if(cur.right!=null)
                    queue.offer(cur.right);
            }
            res.add(list);
        }
        return res;
    }
}
