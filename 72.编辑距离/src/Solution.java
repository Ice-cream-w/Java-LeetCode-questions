/*
给你两个单词word1 和word2， 请返回将word1转换成word2 所使用的最少操作数。
你可以对一个单词进行如下三种操作：

插入一个字符
删除一个字符
替换一个字符

输入：word1 = "horse", word2 = "ros"
输出：3
解释：
horse -> rorse (将 'h' 替换为 'r')
rorse -> rose (删除 'r')
rose -> ros (删除 'e')

输入：word1 = "intention", word2 = "execution"
输出：5
解释：
intention -> inention (删除 't')
inention -> enention (将 'i' 替换为 'e')
enention -> exention (将 'n' 替换为 'x')
exention -> exection (将 'n' 替换为 'c')
exection -> execution (插入 'u')
 */

//动态规划
class Solution {
    public int minDistance(String word1, String word2) {
        //空字符串
        if (word1.length() == 0)
            return word2.length();
        if (word2.length() == 0)
            return word1.length();

        //存放word1到word2的步骤数的数组
        int[][] dp = new int[word1.length()+1][word2.length()+1];
        //[0,i]的word1，变成0个字符的word2需要的步骤
        for (int i = 0; i <= word1.length() ; i++)
            dp[i][0] = i;
        //[0,j]的word2，变成0个字符的word1需要的步骤
        for (int j = 0; j <= word2.length() ; j++)
            dp[0][j] = j;

        //全部遍历一遍，每一步选较小的步骤
        for (int i = 1 ; i <= word1.length() ; i ++){
            for(int j = 1 ; j <= word2.length() ; j++){
                //字符一样，不用增加一步
                if (word1.charAt(i-1) == word2.charAt(j-1))
                    dp[i][j] = dp[i-1][j-1];
                //字符不一样，考虑改/删/增三种步骤哪个步骤少，在此基础上增加一步
                else
                    dp[i][j] = Math.min(Math.min(dp[i-1][j],dp[i][j-1]),dp[i-1][j-1]) +1;
            }
        }

        return dp[word1.length()][word2.length()];
    }
}