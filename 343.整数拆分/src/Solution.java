/*
给定一个正整数 n ，将其拆分为 k 个 正整数 的和（ k >= 2 ），并使这些整数的乘积最大化。

返回 你可以获得的最大乘积 。

输入: n = 2
输出: 1
解释: 2 = 1 + 1, 1 × 1 = 1。

输入: n = 10
输出: 36
解释: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36。
 */

import java.util.Arrays;

//动态规划
class Solution {
    public int integerBreak(int n) {
        //n为2，1*1 特例,
        if (n == 2)
            return 1;
        //n为3 特例
        if (n == 3)
            return 2;

        //创建dp数组
        int[] dp = new int[n/3 +1];
        int max = 1;

        //拆分成3时最大
        for (int i = n , j = 0; i >= 0 ; i --){
            //终止条件
            if (i == 0){
                //拆到最后是3,3...3,3,1的时候，变成3,3....3,2,2
                if (dp[j] == 1){
                    dp[j-1]--;
                    dp[j]++;
                }
                break;
            }

            //将n的值给dp[j]
            dp[j]++;

            if (dp[j] == 3)
                j++;
        }

        for (int i = 0 ; i < dp.length && dp[i] != 0 ; i ++)
                max *= dp[i];

        return max;
    }
}