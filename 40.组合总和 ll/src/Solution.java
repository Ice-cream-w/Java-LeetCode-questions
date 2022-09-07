/*
给定一个候选人编号的集合candidates和一个目标数target，找出candidates中所有可以使数字和为target的组合。
candidates中的每个数字在每个组合中只能使用一次。
注意：解集不能包含重复的组合。

输入: candidates =[10,1,2,7,6,1,5], target =8,
输出:
[[1,1,6],[1,2,5],[1,7],[2,6]]

输入: candidates = [2,5,2,1,2], target = 5,
输出:
[[1,2,2],[5]]
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//回溯
class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> listAll = new ArrayList<>();
        //空集
        if (candidates.length == 0)
            return new ArrayList<>();

        //排序，方便递归
        Arrays.sort(candidates);

        DFS(target, 0, listAll, new ArrayList<>(), candidates);

        return listAll;
    }

    //递归
    private void DFS(int target, int n, List<List<Integer>> listAll, List<Integer> list, int[] candidates){
        //终止条件
        if (target == 0){
            listAll.add(list);
            return;
        }

        //防止与前面的重复
        if (n < candidates.length && candidates[n] > target)
            return;
        for (int i = n ; i < candidates.length && candidates[i] <= target ; i ++){
            //出现重复节点，同层的第一个节点已经被访问过，所以直接跳过
            if (i > n && candidates[i] == candidates[i - 1])
                continue;

            List<Integer> list1 = new ArrayList<>(list);
            list1.add(candidates[i]);
            //i+1而不是n+1防止与之前的重复，与39题不同的关键地方
            DFS(target-candidates[i],i+1, listAll, list1, candidates);
        }
    }
}