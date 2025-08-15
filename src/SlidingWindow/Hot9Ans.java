package SlidingWindow;// src/SlidingWindow.Hot9.java
import java.util.ArrayList;
import java.util.List;

public class Hot9Ans {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();       //答案
        if (s.length() < p.length()) return res;

        int[] pCount = new int[26];
        int[] sCount = new int[26];
        //统计两个字符串频率
        for (int i = 0; i < p.length(); i++) {
            pCount[p.charAt(i) - 'a']++;
            sCount[s.charAt(i) - 'a']++;
        }
        //如果一开始频率相等说明一定s包含一个异位词p,初始窗口
        if (matches(pCount, sCount)) res.add(0);
        //窗口移动
        for (int i = p.length(); i < s.length(); i++) {
            sCount[s.charAt(i) - 'a']++;
            sCount[s.charAt(i - p.length()) - 'a']--;
            if (matches(pCount, sCount)) res.add(i - p.length() + 1);
        }
        return res;
    }

    private boolean matches(int[] a, int[] b) {
        for (int i = 0; i < 26; i++) {
            if (a[i] != b[i]) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "cbaebabacd", p = "abc";
        List<Integer> list = new Hot9Ans().findAnagrams(s, p);
        for (Integer x : list) {
            System.out.print(x + " ");
        }
    }
}