/*
给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。

输入：nums = [1,2,3]
输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]

输入：nums = [0,1]
输出：[[0,1],[1,0]]
 */

import java.util.ArrayList;
import java.util.List;

//回溯
class Solution {
    //返回的数组和放入的数组元素，全局变量方便回溯调用，减少参数设置
    List<List<Integer>> result = new ArrayList<List<Integer>>();
    List<Integer> list = new ArrayList<Integer>();

    public List<List<Integer>> permute(int[] nums) {
        backTracking(nums,list);
        return result;
    }

    private void backTracking(int[] nums , List<Integer> list){
        //终止条件
        if (nums.length == list.size()){
            result.add(new ArrayList<>(list));
            return;
        }

        //递归,循环遍历数组里的值
        for (int num : nums){
            if(!list.contains(num)){
                list.add(num);
                backTracking(nums,list);
                list.remove(list.size()-1);
            }
        }
    }
}