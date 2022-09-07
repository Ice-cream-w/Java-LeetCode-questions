/*
给你一个字符串 s 和一个字符串列表 wordDict 作为字典。请你判断是否可以利用字典中出现的单词拼接出 s 。
注意：不要求字典中出现的单词全部都使用，并且字典中的单词可以重复使用。

输入: s = "leetcode", wordDict = ["leet", "code"]
输出: true
解释: 返回 true 因为 "leetcode" 可以由 "leet" 和 "code" 拼接成。

输入: s = "applepenapple", wordDict = ["apple", "pen"]
输出: true
解释: 返回 true 因为 "applepenapple" 可以由 "apple" "pen" "apple" 拼接成。
    注意，你可以重复使用字典中的单词。

输入: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
输出: false
 */

import java.util.List;

//动态规划
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        // memo[i] 表示 s 中索引为 [0,  i - 1] 范围的字符串是否可被 wordDict 拆分
        boolean[] memo = new boolean[s.length() + 1];
        memo[0] = true;

        for (int i = 1; i <= s.length(); i++) {
            //最后一个值为true的前提是有该字符串，而有该字符串的前提是前面还有，最后可以连起来形成s
            for (int j = 0; j < i; j++) {
                // [0, i] 的字符串可被拆分，当且仅当任一子串 [0, j] 及 [j, i] 可被拆分
                // memo[j]保证了必须前面能在字典里找到，才可以继续匹配后面的
                if (memo[j] && wordDict.contains(s.substring(j, i))) {
                    memo[i] = true;
                    break;
                }
            }
        }

        return memo[s.length()];
    }
}
