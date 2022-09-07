/*
给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。

输入：nums = [1,2,3]
输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]

输入：nums = [0]
输出：[[],[0]]
 */

import java.util.ArrayList;
import java.util.List;

//递归
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();

        //空集
        list.add(new ArrayList<>());
        //正序遍历，每遍历一个值，就将以前的子集加上此值形成新子集，加入list
        for (int i = 0 ; i < nums.length ; i ++)
            son(nums[i], list);

       return list;
    }

    //遍历每一个值，将以前的每一个子集加上此值形成新子集，加入list
    private void son(int n, List<List<Integer>> list){
        int m = list.size();
        for (int i = 0 ; i < m ; i ++){
            //创建新集合，不然会影响原集合
            List<Integer> t = new ArrayList<>(list.get(i));
            t.add(n);
            list.add(t);
        }
    }
}