package BinaryTree;

import java.util.LinkedList;

public class Hot48 {
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
    public TreeNode buildTree(int[] preorder, int[] inorder) {                 //preorder代表进栈顺序，inorder代表出栈顺序
        if(preorder.length!=inorder.length || preorder.length==0 ) return null;
        return build(preorder,inorder,0,preorder.length-1,0,inorder.length-1);
    }
    //查询中序遍历数组中根节点时需要O(n)的时间，然后构建树又要O(n)所以总体复杂度为O(n²)，空间复杂度为O(1)，但是我们可以将中序遍历数组存为哈希表，哈希表的查询只需要O(1)复杂度
    //但是会带来O(n)的空间复杂度
    public TreeNode build(int[] preorder, int[] inorder, int preStart, int preEnd, int inStart, int inEnd){
        if(preStart>preEnd || inStart>inEnd || preStart>=preorder.length || inStart>= inorder.length || preEnd<0 || inEnd<0)
            return null;
        int rootVal=preorder[preStart];
        int rootIndexInOrder=-1;
        for(int i=inStart;i<=inEnd;i++){
            if(inorder[i]==rootVal){
                rootIndexInOrder=i;
                break;
            }
        }
        if(rootIndexInOrder == -1) return null; // 根在 inorder 中未找到，退出或抛异常也可
        TreeNode root=new TreeNode(rootVal);
        int leftSize = rootIndexInOrder - inStart;
        TreeNode left=build(preorder,inorder,preStart+1,preStart+leftSize,inStart,rootIndexInOrder-1);
        TreeNode right=build(preorder,inorder,preStart+leftSize+1,preEnd,rootIndexInOrder+1,inEnd);
        root.left=left;
        root.right=right;
        return root;
    }

}
