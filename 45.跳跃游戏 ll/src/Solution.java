/*
给你一个非负整数数组nums ，你最初位于数组的第一个位置。
数组中的每个元素代表你在该位置可以跳跃的最大长度。
你的目标是使用最少的跳跃次数到达数组的最后一个位置。
假设你总是可以到达数组的最后一个位置。

输入: nums = [2,3,1,1,4]
输出: 2
解释: 跳到最后一个位置的最小跳跃数是 2。
    从下标为 0 跳到下标为 1 的位置，跳1步，然后跳3步到达数组的最后一个位置。

输入: nums = [2,3,0,1,4]
输出: 2
 */

//动态规划
class Solution {
    public int jump(int[] nums) {
        //单个值的数组
        if(nums.length == 1) return 0;

        int reach = 0;
        int nextreach = nums[0];
        int step = 0;
        for(int i = 0;i<nums.length;i++){
            //按该处能跳的最远点+之前差的距离i，与上一个能跳的距离相比，取最大值
            nextreach = Math.max(i+nums[i],nextreach);

            //要跳的最远点超过了数组最后，直接返回
            if(nextreach >= nums.length-1)
                return (step+1);

            //遇到0值的时候不管，下一个需要跳的加一
            if(i == reach){
                step++;
                reach = nextreach;
            }
        }

        return step;
    }
}