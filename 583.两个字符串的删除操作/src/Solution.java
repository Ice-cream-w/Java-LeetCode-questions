/*
给定两个单词 word1 和 word2 ，返回使得 word1 和  word2 相同所需的最小步数。
每步 可以删除任意一个字符串中的一个字符。

输入: word1 = "sea", word2 = "eat"
输出: 2
解释: 第一步将 "sea" 变为 "ea" ，第二步将 "eat "变为 "ea"

输入：word1 = "leetcode", word2 = "etco"
输出：4
 */

//动态规划
class Solution {
    public int minDistance(String word1, String word2) {
        //空字符串
        if (word1.length() == 0)
            return word2.length();
        if (word2.length() == 0)
            return word1.length();

        //存放公共子序列长度的数组
        int[][] dp = new int[word1.length()+1][word2.length()+1];

        //全部遍历一遍，从1开始避免i-1和j-1出错
        for (int i = 1 ; i <= word1.length() ; i ++){
            for(int j = 1 ; j <= word2.length() ; j++){
                //匹配到了，在上一个基础上+1
                if (word1.charAt(i-1) == word2.charAt(j-1))
                    dp[i][j] = dp[i-1][j-1] +1;
                    //没匹配到
                else
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
            }
        }

        // 在1143的基础上，求出最长公共子序列后，
        // 用两个字符串的长度和减去两倍最长公共子序列就是要执行的步骤
        return word1.length()+word2.length()-
                2*dp[word1.length()][word2.length()];
    }
}