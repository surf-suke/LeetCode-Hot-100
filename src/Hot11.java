// src/Hot11.java
public class Hot11 {
    //三次数组翻转法
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        if (n == 0 || k % n == 0) return;
        k = k % n;
        reverse(nums, 0, n - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, n - 1);
    }
    private void reverse(int[] nums, int left, int right) {
        while (left < right) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }
    }
    public static void main(String[] args){
        int[] nums = {-1, -100, 3, 99};
        int k = 2;
        new Hot11().rotate(nums, k);
        for (int x : nums) {
            System.out.print(x + " ");
        }
    }
}