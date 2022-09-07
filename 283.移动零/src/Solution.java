/*
给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
请注意 ，必须在不复制数组的情况下原地对数组进行操作。

输入: nums = [0,1,0,3,12]
输出: [1,3,12,0,0]

输入: nums = [0]
输出: [0]
 */

class Solution {
    public void moveZeroes(int[] nums) {
        //双指针
        int i = 0;
        int j = 0;

        //i是赋值指针，当i处是0则跳过赋值i++，i不为0则赋给j处，j递增不跳
        while(i < nums.length){
            if (nums[i] != 0)
                nums[j++] = nums[i];
            i++;
        }

        //赋完非0后把后面全部赋0
        while(j < nums.length){
            nums[j++] = 0;
        }
    }
}