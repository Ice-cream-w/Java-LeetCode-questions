/*
给定两个字符串s和 p，找到s中所有p的异位词的子串，返回这些子串的起始索引。不考虑答案输出的顺序。

异位词 指由相同字母重排列形成的字符串（包括相同的字符串）。

输入: s = "cbaebabacd", p = "abc"
输出: [0,6]
解释:
起始索引等于 0 的子串是 "cba", 它是 "abc" 的异位词。
起始索引等于 6 的子串是 "bac", 它是 "abc" 的异位词。

输入: s = "abab", p = "ab"
输出: [0,1,2]
解释:
起始索引等于 0 的子串是 "ab", 它是 "ab" 的异位词。
起始索引等于 1 的子串是 "ba", 它是 "ab" 的异位词。
起始索引等于 2 的子串是 "ab", 它是 "ab" 的异位词。


 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//滑动窗口
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        if (s.length() < p.length() || s.length() == 0)
            return null;

        List<Integer> list = new ArrayList<>();
        //计算p和s一开始的字母量
        int[] pnum = new int[26];
        int[] snum = new int[26];
        for (int i = 0 ; i < p.length() ; i ++){
            pnum[p.charAt(i) - 'a']++;
            snum[s.charAt(i) - 'a']++;
        }

        //比较是不是异位词
        int i = p.length();
        while (i <= s.length()){
            if (Arrays.equals(snum, pnum))
                list.add(i-p.length());
            //去头加尾,最后一个跳出
            if(i == s.length())
                break;
            snum[s.charAt(i-p.length()) - 'a']--;
            snum[s.charAt(i) - 'a']++;
            i ++;
        }
        return list;
    }
}