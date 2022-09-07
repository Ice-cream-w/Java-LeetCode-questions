/*
给定一个含有n个正整数的数组和一个正整数 target 。

找出该数组中满足其和 ≥ target 的长度最小的 连续子数组[numsl, numsl+1, ..., numsr-1, numsr] ，
并返回其长度。如果不存在符合条件的子数组，返回 0 。

输入：target = 7, nums = [2,3,1,2,4,3]
输出：2
解释：子数组 [4,3] 是该条件下的长度最小的子数组。

输入：target = 4, nums = [1,4,4]
输出：1

输入：target = 11, nums = [1,1,1,1,1,1,1,1]
输出：0
 */

//滑动窗口
class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        //空数组
        if (nums.length == 0)
            return 0;
        //指针，判断，返回的长度
        int i = 0;
        int sum = 0;
        int len = 0;

        //遍历每个值，该值与前面的数组成的大于sum的数组，判断这个数组的长度是否比以前长度最小数组的长度还短
        for (int j = 0; j < nums.length; j++) {
            sum += nums[j];
            //获得每个i处的，和大于sum的，最小长度数组长度
            while (sum >= s) {
                len = len == 0 ? j - i + 1 : Math.min(len, j - i + 1);
                sum -= nums[i++];
            }
        }
        return len;
    }
}