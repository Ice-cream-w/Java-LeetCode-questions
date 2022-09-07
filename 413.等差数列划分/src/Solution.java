/*
如果一个数列 至少有三个元素 ，并且任意两个相邻元素之差相同，则称该数列为等差数列。

例如，[1,3,5,7,9]、[7,7,7,7] 和 [3,-1,-5,-9] 都是等差数列。
给你一个整数数组 nums ，返回数组 nums 中所有为等差数组的 子数组 个数。
子数组 是数组中的一个连续序列。

输入：nums = [1,2,3,4,5,6]1,3,6,10
输出：3
解释：nums 中有三个子等差数组：[1, 2, 3]、[2, 3, 4] 和 [1,2,3,4] 自身。

输入：nums = [1]
输出：0
 */

import java.util.ArrayList;
import java.util.List;

//动态规划
class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        //数组元素少于3个的
        if (nums.length < 3)
            return 0;

        //等差的差，存放个数的集合，1234的差，总个数
        int derta = nums[1] - nums[0];
        //int[] t = new int[nums.length];
        int k = 1;
        int sum = 0;

        for (int i = 1 ; i < nums.length -1; i++){
            //此处的差和上一处的差相等，即为一个等差序列，sum+k
            if (nums[i+1] - nums[i] == derta)
                //1,3,6,10,15.....，每次+k后k要++
                sum += k++;

            //此处的差和上一处的差不相等，即重新判断，等差重新计数
            else{
                derta = nums[i+1] - nums[i];
                k = 1;
            }
        }

        return sum;
    }
}
