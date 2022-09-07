/*
给定一个未排序的整数数组 nums ， 返回最长递增子序列的个数 。
注意 这个数列必须是 严格 递增的。

输入: [1,3,5,4,7]
输出: 2
解释: 有两个最长递增子序列，分别是 [1, 3, 4, 7] 和[1, 3, 5, 7]。
 */

//动态规划
class Solution {
    public int findNumberOfLIS(int[] nums) {
        //存放缓冲数组，一个存放长度，一个存放个数
        int[] dp = new int[nums.length];
        int[] counter = new int[nums.length];
        for (int i = 0 ; i < nums.length ; i ++){
            dp[i] = 1;
            counter[i] = 1;
        }
        int len = 1;
        int max = 1;

        //遍历每一个数，i是判断长度，j是判断个数
        for (int i = 1 ; i < nums.length; i ++) {
            for (int j = 0 ; j < i ; j ++) {
                if (nums[i] > nums[j]){
                    //当遍历到[0,i-1]的第一个最长子序列时，将该长度和个数给len[i]
                    //abc后面加e
                    if (dp[i] < dp[j] +1) {
                        dp[i] = dp[j] +1;
                        counter[i] = counter[j];
                    }
                    //当遍历到[0,i-1]的第n个最长子序列时，将该个数与i处已有个数相加
                    // 因为在abc后面加e的情况下，abd后面加e的情况的个数也要算进去
                    else if (dp[i] == dp[j] +1){
                        counter[i] += counter[j];
                    }
                }
            }

            //寻找最长的个数，遇到同一长度的，叠加
            if (dp[i] > len){
                len = dp[i];
                max = counter[i];
            }
            else if (dp[i] == len)
                max += counter[i];
        }

        return max;
    }
}