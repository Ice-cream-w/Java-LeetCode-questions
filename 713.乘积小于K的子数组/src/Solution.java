/*
给你一个整数数组 nums 和一个整数 k ，请你返回子数组内所有元素的乘积严格小于 k 的连续子数组的数目。

输入：nums = [10,5,2,6], k = 100
输出：8
解释：8 个乘积小于 100 的子数组分别为：[10]、[5]、[2],、[6]、[10,5]、[5,2]、[2,6]、[5,2,6]。
需要注意的是 [10,5,2] 并不是乘积小于 100 的子数组。

输入：nums = [1,2,3], k = 0
输出：0
 */

//滑动窗口
class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        //结果和判断值
        int ans = 0;
        int product = 1;
        //循环遍历每个值
        for (int right = 0, left = 0; right < nums.length; right++) {
            //乘积，判断
            product *= nums[right];
            //左右指针中间的部分判断是否大于k，大于就右移左指针直到小于，此时开始计数
            while (left <= right && product >= k) {
                product /= nums[left++];
            }

            //只会计算含有右指针处的数组，即[1,2,3],k=6中，右指针为3时，ans加的是[1,2,3][2,3][3]
            //而[1][1,2][2]在之前遍历时已经加算过
            ans += right - left + 1;
        }
        return ans;
    }
}
