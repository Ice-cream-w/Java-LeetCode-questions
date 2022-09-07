/*
给你一个 无重复元素 的整数数组candidates 和一个目标整数target，
找出candidates中可以使数字和为目标数target 的 所有不同组合 ，并以列表形式返回。
你可以按 任意顺序 返回这些组合。

candidates 中的 同一个 数字可以 无限制重复被选取 。如果至少一个数字的被选数量不同，则两种组合是不同的。
对于给定的输入，保证和为target 的不同组合数少于 150 个。

输入：candidates = [2,3,6,7], target = 7
输出：[[2,2,3],[7]]
解释：
2 和 3 可以形成一组候选，2 + 2 + 3 = 7 。注意 2 可以使用多次。
7 也是一个候选， 7 = 7 。
仅有这两种组合。

输入: candidates = [2,3,5], target = 8
输出: [[2,2,2,2],[2,3,3],[3,5]]

输入: candidates = [2], target = 1
输出: []
 */

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//回溯
class Solution {
    List<List<Integer>> listAll = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        //空集
        if (candidates.length == 0)
            listAll.add(new ArrayList<>());
        Arrays.sort(candidates);

        DFS(target, candidates, new ArrayList<>(), 0);

        return listAll;
    }

    //递归
    private void DFS(int target, int[] candidates, List<Integer> list, int n){
        //终止条件
        if (target == 0){
            listAll.add(list);
            return;
        }
        //比最小的还小表示已经没法继续了，返回
        if (candidates[0] > target)
            return;

        //i不能从头开始，要从当前数字开始，否则会出现重复的元素集合
        for (int i = n ; i < candidates.length && candidates[i] <= target ; i ++){
            //创建新集合，不然会影响原集合
            List<Integer> t = new ArrayList<>(list);
            t.add(candidates[i]);
            DFS(target-candidates[i] , candidates, t, i);
        }
    }
}