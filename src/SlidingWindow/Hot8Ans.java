package SlidingWindow;

import java.util.HashMap;
import java.util.Map;

public class Hot8Ans { //无重复字符最长字串长度
    //定义滑动窗口状态为是否有重复子串，如有则左边界右移直到没有重复子串，反之，右边界右移直到有重复子串
    //使用HashMap记录字符和索引位置，若有重复字符则更新左边界为重复字符的下一个位置
    //时间复杂度O(n)，空间复杂度O(min(n,m))，其中n为字符串长度，m为字符集大小
    //注意：如果字符集是ASCII字符集，则m=128；如果是Unicode字符集，则m=65536；如果是UTF-8字符集，则m=256。
    public int lengthOfLongestSubstring(String s) {
        //该题目本质为剪枝法
        //若(left,right)窗口存在重复子串，则{(left,x)∈重复子串|x∈[right+1,s.size()]} ==>剪枝：left++直到right位置上的字符不再重复
        //若(left,right)窗口不存在重复子串，则{(x,right)∈非重复子串|x∈[left+1,right-1]} ==>可行解的解空间：right++，不断搜索可行解。
        //初始化
        //边界情况
        int ans=0;
        Map<Character,Integer> map= new HashMap<>();
         for(int left=0,right=0;right<s.length();right++){ //定义滑动窗口左右边界阈值
             //记录滑动窗口字符数
             map.put(s.charAt(right), map.getOrDefault(s.charAt(right),0)+1);
             while(map.get(s.charAt(right))>1){ //如果滑动窗口状态为存在重复子串则左边界右移
                 //更新滑动窗口字符数直到right位置上的重复字符不在滑动窗口内
                 map.put(s.charAt(left),map.get(s.charAt(left))-1);
                 left++;
             }
             //如果滑动窗口状态为不存在重复子串，则将可行解加入解空间。
             ans = Math.max(ans,right-left+1);
         }
         return ans;
    }
    public static void main(String[] args){
        String s = "pwwkew";
        System.out.println(new Hot8Ans().lengthOfLongestSubstring(s));
    }

}
