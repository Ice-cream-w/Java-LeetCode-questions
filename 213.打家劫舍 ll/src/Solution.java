/*
你是一个专业的小偷，计划偷窃沿街的房屋，每间房内都藏有一定的现金。这个地方所有的房屋都 围成一圈 ，
这意味着第一个房屋和最后一个房屋是紧挨着的。同时，相邻的房屋装有相互连通的防盗系统，
如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警 。

给定一个代表每个房屋存放金额的非负整数数组，计算你 在不触动警报装置的情况下 ，今晚能够偷窃到的最高金额。

输入：nums = [2,3,2]
输出：3
解释：你不能先偷窃 1 号房屋（金额 = 2），然后偷窃 3 号房屋（金额 = 2）, 因为他们是相邻的。

输入：nums = [1,2,3,1]
输出：4
解释：你可以先偷窃 1 号房屋（金额 = 1），然后偷窃 3 号房屋（金额 = 3）。
偷窃到的最高金额 = 1 + 3 = 4 。

输入：nums = [1,2,3]
输出：3
 */

//动态规划
class Solution {
    public int rob(int[] nums) {
        //空数组返回
        if (nums.length <= 1)
            return nums.length == 0 ? 0 : nums[0];

        return Math.max(isMaxRob(nums,0),isMaxRob(nums,nums.length-1));
    }

    private int isMaxRob(int[] nums, int k){
        //首尾不同时拿，所以可以分成不拿首和不拿尾两个，比较大小
        int j = nums[k];
        nums[k] = 0;

        //动态规划，先声明一个数和二个数的返回值，再循环判断k个数，每次判断后将值放入数组便于继续判断
        int n = nums.length;
        int[] memo = new int[n];
        memo[0] = nums[0];
        memo[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < n; i++)
            memo[i] = Math.max(memo[i - 1], nums[i] + memo[i - 2]);

        nums[k] = j;
        return memo[n -1];
    }
}