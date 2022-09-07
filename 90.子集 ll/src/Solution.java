/*
给你一个整数数组 nums ，其中可能包含重复元素，请你返回该数组所有可能的子集（幂集）。
解集 不能 包含重复的子集。返回的解集中，子集可以按 任意顺序 排列。

输入：nums = [1,2,2]
输出：[[],[1],[1,2],[1,2,2],[2],[2,2]]

输入：nums = [0]
输出：[[],[0]]
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//递归
class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        //排序，便于后面判断前后值是否重复
        Arrays.sort(nums);

        //空集
        list.add(new ArrayList<>());
        int left = 0 , right = 1 , len = 0;
        //正序遍历，每遍历一个值，就将以前的子集加上此值形成新子集，加入list
        for (int i = 0 ; i < nums.length ; i ++) {
            //若前后值出现重复，计算上一次增加的集合长度；否则，和78题一样
            if (i != 0 && nums[i] == nums[i - 1])
                left = list.size() - len;
            else left = 0;

            //重新计算集合大小和此次添加的集合数量，便于循环添加新集合，和后一个数的判断
            right = list.size();
            len = right - left;
            son(nums[i], list, left, right);
        }
        return list;
    }

    //遍历每一个值，将以前的每一个子集加上此值形成新子集，加入list
    private void son(int n, List<List<Integer>> list, int left, int right){
        for (int i = left ; i < right ; i ++){
            //创建新集合，不然会影响原集合
            List<Integer> t = new ArrayList<>(list.get(i));
            t.add(n);
            list.add(t);
        }
    }
}