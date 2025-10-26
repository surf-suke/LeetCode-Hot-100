package BinaryTree;

public class Hot43 {
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
    public TreeNode sortedArrayToBST(int[] nums) {
        int len=nums.length;
        if(len == 0)
            return null;
        TreeNode mid = new TreeNode(nums[(len-1)/2]);
        mid.left=sortedArrayToBST(nums,0,(len-1)/2-1);
        mid.right=sortedArrayToBST(nums,(len-1)/2+1,len-1);
        return mid;
    }
    public TreeNode sortedArrayToBST(int[] nums, int left, int right){
        int len= right-left+1;
        if(nums.length==0 || left<0 || len<=0)
            return null;
        TreeNode mid = new TreeNode(nums[left+(len-1)/2]);
        mid.left=sortedArrayToBST(nums,left,left+(len-1)/2-1);
        mid.right=sortedArrayToBST(nums,left+(len-1)/2+1,right);
        return mid;
    }
}
