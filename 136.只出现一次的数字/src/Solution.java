/*
给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。

说明：
你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？

输入: [2,2,1]
输出: 1

输入: [4,1,2,1,2]
输出: 4
 */
/* 思路
交换律：a ^ b ^ c <=> a ^ c ^ b
任何数于0异或为任何数 0 ^ n => n
相同的数异或为0: n ^ n => 0

var a = [2,3,2,4,4]
2 ^ 3 ^ 2 ^ 4 ^ 4等价于 2 ^ 2 ^ 4 ^ 4 ^ 3 => 0 ^ 0 ^3 => 3
 */

//位运算
class Solution {
    public int singleNumber(int[] nums) {
        //单数字直接返回
        if (nums.length == 1)
            return nums[0];

        //多个数异或，同样的数会被归零，奇数个的数字会保留
        for (int i = 0 ; i < nums.length -1 ; i ++)
            nums[i+1] = nums[i] ^ nums[i +1];

        return nums[nums.length -1];
    }
}