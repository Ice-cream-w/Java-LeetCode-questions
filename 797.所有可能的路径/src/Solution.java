/*
给你一个有n个节点的 有向无环图（DAG），请你找出所有从节点 0到节点 n-1的路径并输出（不要求按特定顺序）
graph[i]是一个从节点 i 可以访问的所有节点的列表（即从节点 i 到节点graph[i][j]存在一条有向边）。

输入：graph = [[1,2],[3],[3],[]]
输出：[[0,1,3],[0,2,3]]
解释：有两条路径 0 -> 1 -> 3 和 0 -> 2 -> 3

输入：graph = [[4,3,1],[3,2,4],[3],[4],[]]
输出：[[0,4],[0,3,4],[0,1,3,4],[0,1,2,3,4],[0,1,4]]
 */

import java.util.ArrayList;
import java.util.List;

//深度优先搜索
class Solution {
    private List<List<Integer>> list = new ArrayList<>();
    private List<Integer> list1 = new ArrayList<>();

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        //空数组
        if (graph.length <= 1)
            return list;

        //节点0开始
        list1.add(0);
        DFS(0,  graph.length -1, graph);

        return list;
    }

    //i是此时的节点数字，nums是n-1
    private void DFS(int i, int nums, int[][] graph){
        //终止条件
        if (i == nums){
            List<Integer> L = new ArrayList<>(list1);
            list.add(L);
        }

        //回溯，j是要跳的节点，同时也是加入集合的数字
        for (int j = 0 ; j < graph[i].length ; j ++){
            list1.add(graph[i][j]);
            DFS(graph[i][j], nums, graph);
            list1.remove(list1.size() -1);
        }
    }
}