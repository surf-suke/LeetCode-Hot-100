package SubString;

import java.util.HashMap;
import java.util.Map;

public class Hot12 {
    //定义滑动窗口
    //状态一：当窗口中不包含t中全部字符时，滑动窗口r指针右移
    //状态二：当窗口中包含t中全部字符时，滑动窗口l指针右移，直到得到最小窗口
    //使用hashmap或者数组记录滑动窗口和t中字符的频次
    //使用数组记录，A-Z的ASCII码为65-90，a-z的ASCII码为97-122，Z与a差32.
    Map<Character,Integer> tMap=new HashMap<>();
    Map<Character,Integer> window=new HashMap<>();
    public String minWindow(String s, String t) {
        int lenS=s.length();
        int minLen = Integer.MAX_VALUE;
        int ansL=-1,ansR=-1;
        int l=0,r=-1;
        for(char ch:t.toCharArray()){
            tMap.put(ch, tMap.getOrDefault(ch,0)+1);
        }
        while(r<lenS){
            r++;
            if(r<lenS&& tMap.containsKey(s.charAt(r))){
                window.put(s.charAt(r), window.getOrDefault(s.charAt(r),0)+1);
            }
            while(check()&&l<=r){                       //检查是否已经包含所有字符
                if(r-l+1<minLen){                          //更新最小窗口
                    minLen=r-l+1;
                    ansL=l;
                    ansR=r;
                }
               if(tMap.containsKey(s.charAt(l))){
                   window.put(s.charAt(l), window.get(s.charAt(l))-1);
               }
               l++;
            }
        }
        return ansL==-1?"":s.substring(ansL,ansR+1);              //注意substring的右边界是开区间
    }
    public boolean check(){
        for(char key:tMap.keySet()){
            if(window.getOrDefault(key,0)<tMap.get(key))
                return false;
        }
        return true;
    }
    public static void main(String[] args){
        String s="ADOBECODEBANC",t="ABC";
        System.out.println(new Hot12().minWindow(s,t));
    }

}
