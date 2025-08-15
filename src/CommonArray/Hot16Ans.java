package CommonArray;

public class Hot16Ans {
    //对Hot16的优化改进
    //由于需要额外两个空间大小为O(n)的哈希表存储前缀积和后缀积，空间大小为O(2n)
    //所以可以用输出数组进行代替
    public int[] productExceptSelf(int[] nums) {
        int length=nums.length;
        int[] ans=new int[length];
        ans[0]=1;                   //ans[i]表示左侧所有元素的乘积
        for(int i=1;i<length;i++){
            ans[i]=ans[i-1]*nums[i-1];
        }
        int right=1;            //right表示右侧所有元素的乘积
        for(int j=length-1;j>=0;j--){   //计算左侧和右侧乘积
            ans[j]=ans[j]*right;
            right=right*nums[j];
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        Hot16Ans hot = new Hot16Ans();
        int[] result = hot.productExceptSelf(nums);
        for (int val : result) {
            System.out.print(val + " ");
        }
        System.out.println();
    }

}
