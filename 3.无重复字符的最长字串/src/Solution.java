import java.util.HashMap;
import java.util.Map;

public class Solution {

    public int lengthOfLongestSubstring(String s) {

            // 记录字符上一次出现的位置
            int[] last = new int[128];
            for(int i = 0; i < 128; i++) {
                last[i] = -1;
            }
            int n = s.length();

            int res = 0;
            int start = 0; // 窗口开始位置
            for(int i = 0; i < n; i++) {
                int index = s.charAt(i);
                // 记录字符上一次出现的位置
                start = Math.max(start, last[index] + 1);
                // 现在位置减去上一次位置，如果大于之前的res则更新
                res = Math.max(res, i - start + 1);
                last[index] = i;
            }
            return res;
    }
}
