/*
给你一个包含 n 个整数的数组nums，判断nums中是否存在三个元素 a，b，c ，
使得a + b + c = 0 ？请你找出所有和为 0 且不重复的三元组。
注意：答案中不可以包含重复的三元组。

输入：nums = [-1,0,1,2,-1,-4]
输出：[[-1,-1,2],[-1,0,1]]
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List list = new ArrayList();
        //空数组
        if ( null == nums || nums.length < 3)
            return list;

        //从小到大排序
        Arrays.sort(nums);
        for (int a = 0; a < nums.length - 2 && nums[a] <= 0; a++) {
            twoSum(nums, a, list);
            while(nums[a] == nums[a + 1] && a < nums.length - 2 ){
                a++;
            }
        }
        return list;
    }
    //两数之和
    public void twoSum(int[] nums, int a, List list) {
        int a1 = nums[a];

        // 建立k-v ，一一对应的哈希表
        HashMap<Integer, Integer> hash = new HashMap<Integer, Integer>();
        //从a开始循环，前面的归零不管
        int left = a + 1;
        int right = nums.length - 1;
            //查找下一个数字的大小.
            //左右指针
            while (left < right) {
                if (nums[left] + nums[right] + nums[a] > 0) {
                    while (right > left + 1 && nums[right] == nums[right - 1])
                        right--;
                    right--;
                } else if (nums[left] + nums[right] + nums[a] < 0) {
                    while (left < right - 1  && nums[left] == nums[left + 1])
                        left++;
                    left++;
                } else {
                    /*int[] n = new int[3];
                    n[0] = nums[a];
                    n[1] = nums[left];
                    n[2] = nums[right];
                    list.add(n);*/
                    list.add(Arrays.asList(nums[a], nums[left], nums[right]));
                    if (nums[left]== nums[right])
                        break;
                    while (nums[left] == nums[left + 1])
                        left++;
                    left++;
                }
            }
        return;
    }
}