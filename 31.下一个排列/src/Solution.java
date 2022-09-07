import java.util.Arrays;

/*
整数数组的一个 排列就是将其所有成员以序列或线性顺序排列。
例如，arr = [1,2,3] ，以下这些都可以视作 arr 的排列：[1,2,3]、[1,3,2]、[3,1,2]、[2,3,1] 。
整数数组的 下一个排列 是指其整数的下一个字典序更大的排列。更正式地，如果数组的所有排列根据其字典顺序从小到大排列在一个容器中，
那么数组的 下一个排列 就是在这个有序容器中排在它后面的那个排列。如果不存在下一个更大的排列，
那么这个数组必须重排为字典序最小的排列（即，其元素按升序排列）。

例如，arr = [1,2,3] 的下一个排列是 [1,3,2] 。
类似地，arr = [2,3,1] 的下一个排列是 [3,1,2] 。
而 arr = [3,2,1] 的下一个排列是 [1,2,3] ，因为 [3,2,1] 不存在一个字典序更大的排列。
给你一个整数数组 nums ，找出 nums 的下一个排列。必须原地修改，只允许使用额外常数空间。

输入：nums = [1,2,3]
输出：[1,3,2]
 */
//其实就是从数组倒着查找，找到nums[i] 比nums[i+1]小的时候，就将nums[i]跟nums[i+1]到nums[nums.length - 1]
//当中找到一个最小的比nums[i]大的元素交换。交换后，再把nums[i+1]到nums[nums.length-1]排序，就ok了
class Solution {
    public void nextPermutation(int[] nums) {
        if (nums.length < 2)
            return;

        //倒着读,m记录比前一个元素大的那个点，n记录从m到末尾比m处值大的最小值，i记录m-1的值
        //比如12543，m是第三个，n是第五个，i是2
        int m = nums.length - 1;
        int t = 0;
        while(m >= 0){
            //当该值比其下一个小的时候，读下一个
            if (m > 0 && nums[m] <= nums[m-1])
                m--;
            //321情况
            else if (m == 0){
                Arrays.sort(nums,m,nums.length);
                return;
            }
            else {
                t = nums[m-1];
                nums[m-1] = nums[m];
                break;
            }
        }
        //交换
        int n = m;
        for(int i = m+1 ; i <= nums.length -1 ; i ++){
            if (nums[i] > t && nums[i] < nums[m-1]){
                nums[m-1] = nums[i];
                n = i;
            }
        }
        nums[n] = t;
        Arrays.sort(nums,m,nums.length);
        return;
    }
}