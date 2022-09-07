/*
给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
子数组 是数组中的一个连续部分。

输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
输出：6
解释：连续子数组 [4,-1,2,1] 的和最大，为 6 。

输入：nums = [5,4,-1,7,8]
输出：23
 */

import java.util.Arrays;

//动态规划
class Solution {
    public int maxSubArray(int[] nums) {
        //空数组
        if (nums.length == 0)
            return 0;

        //存放每个数之前子数组的最大值数组
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int max = nums[0];

        for (int i = 1 ; i < nums.length ; i ++){
            dp[i] = nums[i] + Math.max(dp[i - 1], 0);
            max = Math.max(max, dp[i]);
        }

        return max;
    }
}