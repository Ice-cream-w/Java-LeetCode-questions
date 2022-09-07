/*
峰值元素是指其值严格大于左右相邻值的元素。

给你一个整数数组nums，找到峰值元素并返回其索引。数组可能包含多个峰值，在这种情况下，返回 任何一个峰值 所在位置即可。
你可以假设nums[-1] = nums[n] = -∞ 。
你必须实现时间复杂度为 O(log n) 的算法来解决此问题。

输入：nums = [1,2,3,1]
输出：2
解释：3 是峰值元素，你的函数应该返回其索引 2。

输入：nums = [1,2,1,3,5,6,4]
输出：1 或 5
解释：你的函数可以返回索引 1，其峰值元素为 2；或者返回索引 5， 其峰值元素为 6。

 */

//二分查找
class Solution {
    public int findPeakElement(int[] nums) {
        int left = 0;
        int right = nums.length -1;
        int mid = left + (right - left)/2;

        //空数组
        if (nums.length == 0)
            return 0;

        while(mid < nums.length -1 && mid > 0){

            if (nums[mid] > nums[mid +1] && nums[mid] > nums[mid -1])
                return mid;

            //表明左半边会有峰值
            if (nums[mid] >= nums[mid +1]){
                right = mid;
                mid = left + (right - left)/2;
            }
            else {
                left = mid +1;
                mid = left + (right - left)/2;
            }

            //mid和左边界/右边界重合的时候，跳出去
            if (mid == left || mid == right)
                break;
        }

        if (nums[left] > nums[right])
            return left;
        return right;
    }
}

/*//更简洁，内存少
class Solution {
    public int findPeakElement(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while(left < right){
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[mid + 1]){
                right = mid;
            }
            else
               left = mid + 1;
        }
        return left;
    }
}
 */