package BinaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Hot37 {
    public class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val){
            this.val =val ;
        }
        TreeNode(int val, TreeNode left, TreeNode right){
            this.val= val;
            this.left=left;
            this.right =right;
        }
    }
//    public List<Integer> inorderTraversal(TreeNode root){        //O(n)时间复杂度 O(h)空间复杂度，h为树的高度。
//        List<Integer> res= new ArrayList<>();
//        LinkedList<TreeNode> stack =new LinkedList<>();
//        while(root !=null || !stack.isEmpty()){
//            while(root!=null){
//                stack.push(root);
//                root=root.left;
//            }
//            root=stack.pop();
//            res.add(root.val);
//            root=root.right;
//        }
//        return res;
//    }
    public List<Integer> inorderTraversal(TreeNode root){
        List<Integer> res= new ArrayList<>();
        TreeNode p=null;
        while(root!=null){
            if(root.left !=null){                   //左子树不为空，找到中序遍历的前驱，建立返回路径
                p=root.left;
                while(p.right !=null && p.right !=root){
                    p=p.right;
                }
                if(p.right ==null){                          //建立返回路径
                    p.right =root;
                    root=root.left;
                }else{                                       //返回到根节点，断开返回路径
                    p.right =null;
                    res.add(root.val);
                    root=root.right;
                }
            }else{                                   //左子树为空，直接访问根节点，进入右子树
                res.add(root.val);
                root=root.right;
            }
        }
        return res;
    }

}
