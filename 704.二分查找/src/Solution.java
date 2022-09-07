/*
给定一个n个元素有序的（升序）整型数组nums 和一个目标值target，写一个函数搜索nums中的target，
如果目标值存在返回下标，否则返回 -1。

输入: nums = [-1,0,3,5,9,12], target = 9
输出: 4
解释: 9 出现在 nums 中并且下标为 4

输入: nums = [-1,0,3,5,9,12], target = 2
输出: -1
解释: 2 不存在 nums 中因此返回 -1
 */

class Solution {
    public int search(int[] nums, int target) {
        int i = nums.length ;
        int j = 0;

        //左右移动
        while(i != j){
            if (target == nums[(i+j)/2])
                return (i+j)/2;
            else if (i == j+1)
                break;
            else if (target > nums[(i+j)/2])
                j = (i+j)/2;
            else
                i = (i+j)/2;;
        }

        return -1;
    }
}