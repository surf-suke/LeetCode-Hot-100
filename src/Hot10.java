// src/Hot10.java
import java.util.HashMap;

public class Hot10 {
    //前缀和+哈希表
    //preSum[i]=∑i ==> preSum[i]=preSum[i-1]+nums[i]
    //故有 [j...i] 的和为 k 的条件是 preSum[i] - preSum[j-1] = k
    //即 preSum[i] - k = preSum[j-1]
    //因此可以用哈希表存储 preSum[j-1] 的值，
    //当遍历到 preSum[i] 时，查找 preSum[i] - k 是否存在于哈希表中，
    //如果存在，则说明有 preSum[j-1] = preSum[i] - k，
    //即存在一个子数组 [j...i] 的和为 k。
    //时间复杂度 O(n)，空间复杂度 O(n)
    //注意：如果数组中有负数，不能用双指针滑动窗口
    public int subarraySum(int[] nums, int k) {
        int count = 0, sum = 0;
        HashMap<Integer, Integer> preSum = new HashMap<>();
        preSum.put(0, 1); // 初始化前缀和为0出现1次
        for (int num : nums) {
            sum += num;
            count += preSum.getOrDefault(sum - k, 0);
            preSum.put(sum, preSum.getOrDefault(sum, 0) + 1);
        }
        return count;
    }
    public static void main(String[] args){
        int[] nums = {1,2,3};
        int k = 3;
        int count = new Hot10().subarraySum(nums, k);
        System.out.println(count); // 输出2
    }
}