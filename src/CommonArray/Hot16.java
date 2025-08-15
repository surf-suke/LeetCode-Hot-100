package CommonArray;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Hot16 {
    public int[] productExceptSelf(int[] nums) {
        int len= nums.length;
        int[] ans=new int[len];
        if(len==0)
            return null;
        if(len==1)
            return new int[]{0};
        Map<Integer,Integer> preProduct= new HashMap<>();    //可以用数组替代
        Map<Integer,Integer> postProduct= new HashMap<>();   //可以用数组替代
        preProduct.put(0,1);
        postProduct.put(len-1,1);
        for(int i=1;i<len;i++){
            int pre=preProduct.get(i-1)*nums[i-1];
            preProduct.put(i,pre);
        }
        for(int j=len-2;j>=0;j--){
            int post=postProduct.get(j+1)*nums[j+1];
            postProduct.put(j,post);
        }
        for(int k=0;k<len;k++){
            ans[k]=preProduct.get(k)*postProduct.get(k);
        }
        return ans;
    }
    public static void main(String[] args){
        int[] nums = {1, 2, 3, 4};
        Hot16 hot = new Hot16();
        int[] result = hot.productExceptSelf(nums);
        for (int val : result) {
            System.out.print(val + " ");
        }
        System.out.println();

        int[] nums2 = {0, 4, 0};
        int[] result2 = hot.productExceptSelf(nums2);
        for (int val : result2) {
            System.out.print(val + " ");
        }
        System.out.println();

        int[] nums3 = {2, 0, 4};
        int[] result3 = hot.productExceptSelf(nums3);
        for (int val : result3) {
            System.out.print(val + " ");
        }
        System.out.println();

        int[] nums4 = {5};
        int[] result4 = hot.productExceptSelf(nums4);
        for (int val : result4) {
            System.out.print(val + " ");
        }
        System.out.println();

        int[] nums5 = {};
        int[] result5 = hot.productExceptSelf(nums5);
        System.out.println(Arrays.toString(result5)); // 应输出 null
    }
}
