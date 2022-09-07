/*
整数数组 nums 按升序排列，数组中的值 互不相同 。
在传递给函数之前，nums 在预先未知的某个下标 k（0 <= k < nums.length）上进行了 旋转，使数组变为
[nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]（下标 从 0 开始 计数）。
例如， [0,1,2,4,5,6,7] 在下标 3 处经旋转后可能变为[4,5,6,7,0,1,2] 。
给你 旋转后 的数组 nums 和一个整数 target ，如果 nums 中存在这个目标值 target ，则返回它的下标，否则返回-1。

输入：nums = [4,5,6,7,0,1,2], target = 0
输出：4

输入：nums = [4,5,6,7,0,1,2], target = 3
输出：-1
 */

//二分查找
class Solution {
    public int search(int[] nums, int target) {
        //空数组,单个数但是不是目标值
        if (nums.length == 0 || (nums.length == 1 && nums[0] != target))
            return -1;
        //单个数是目标值
        if (nums.length == 1 && nums[0] == target)
            return 0;

        //找旋转的下标
        int k = nums.length;
        for (int i = 0 ; i < nums.length -1 ; i ++){
            if (nums[i] > nums[i+1]){
                k = i +1;
                break;
            }
        }

        int left = 0;
        int right = nums.length -1;
        if (target == nums[nums.length -1])
            return nums.length -1;

        //如果旋转下标为0或者nums.length，等于未旋转，left和right不变
        //若旋转，且目标值在k右边，区间缩小为[k,right]
        else if (target < nums[nums.length -1]){
            left = (k == nums.length)?0 : k;

            while (left < right){
                int mid = left + (right - left) / 2;
                if (nums[mid] == target)
                    return mid;
                else if (nums[mid] < target)
                    left = mid +1;
                else
                    right = mid;
            }
        }

        //若旋转，且目标值在k左边，区间缩小为[left,k-1]
        else{
            right = k -1;

            while (left < right){
                int mid = left + (right - left) / 2;
                if (nums[mid] == target)
                    return mid;
                else if (nums[mid] < target)
                    left = mid +1;
                else
                    right = mid;
            }
        }

        //循环里没return，表示数组里没有目标值，否则就是right=left的情况
        if (nums[right] == target)
            return right;
        else if (nums[left] == target)
            return left;
        else return -1;
    }
}