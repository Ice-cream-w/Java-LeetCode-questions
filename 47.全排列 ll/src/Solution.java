/*
给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。

输入：nums = [1,1,2]
输出：
[[1,1,2],
 [1,2,1],
 [2,1,1]]

输入：nums = [1,2,3]
输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//递归，回溯
class Solution {
    //返回的数组和放入的数组元素，全局变量方便回溯调用，减少参数设置
    List<List<Integer>> result = new ArrayList<List<Integer>>();
    List<Integer> list = new ArrayList<Integer>();

    public List<List<Integer>> permuteUnique(int[] nums) {
        //创建集合判断每个数是否有重复
        boolean[] used = new boolean[nums.length];
        Arrays.fill(used,false);

        Arrays.sort(nums);
        backTracking(nums,used);
        return result;
    }

    private void backTracking(int[] nums ,boolean[] used){
        //终止条件
        if (nums.length == list.size()){
            result.add(new ArrayList<>(list));
            return;
        }

        //递归,循环遍历数组里的值
        for (int i = 0; i < nums.length; i++){
            // used[i - 1] == true，说明同⼀树⽀nums[i - 1]使⽤过
            // used[i - 1] == false，说明同⼀树层nums[i - 1]使⽤过
            // 如果同⼀树层nums[i - 1]使⽤过则直接跳过
            if (i > 0 && nums[i] == nums[i - 1] && used[i - 1] == false) {
                continue;
            }

            //有重复数，不能用!list.contains(num)
            //如果同⼀树层nums[i - 1]没使用
            if(used[i] == false){
                used[i] = true;
                list.add(nums[i]);
                backTracking(nums,used);
                list.remove(list.size()-1);
                //用于回溯
                used[i] = false;
            }
        }
    }
}
