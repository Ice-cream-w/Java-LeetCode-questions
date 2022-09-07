/*
一个机器人位于一个 m*n网格的左上角 （起始点在下图中标记为 “Start” ）。
机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish” ）。
问总共有多少条不同的路径？

输入：m = 3, n = 7
输出：28

输入：m = 3, n = 2
输出：3
解释：
从左上角开始，总共有 3 条路径可以到达右下角。
1. 向右 -> 向下 -> 向下
2. 向下 -> 向下 -> 向右
3. 向下 -> 向右 -> 向下
 */

//DFS，超时
/*
class Solution {
    public int uniquePaths(int m, int n) {
        //终止条件
        if (m == 1 || n == 1)
            return 1;

        int num = 0;

        num += uniquePaths(m-1, n);
        num += uniquePaths(m, n-1);

        return num;
    }
}*/

//动态规划
class Solution {
    public int uniquePaths(int m, int n) {
        //DP数组
        int[][] dp = new int[m][n];

        //倒序遍历每一个值，然后与前一个值相加
        for (int i= 0; i < m ; i ++){
            for (int j = 0 ; j < n ; j ++){
                //将底层的值赋予1，因为到底后只有一条路
                if (i == 0 || j == 0)
                    dp[i][j] = 1;

                else
                    dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }

        return dp[m-1][n-1];
    }
}