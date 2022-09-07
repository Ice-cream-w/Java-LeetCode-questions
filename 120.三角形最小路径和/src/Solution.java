import java.util.Arrays;
import java.util.List;

/*
给定一个三角形 triangle ，找出自顶向下的最小路径和。

每一步只能移动到下一行中相邻的结点上。
相邻的结点在这里指的是 下标 与 上一层结点下标 相同或者等于 上一层结点下标 + 1 的两个结点。
也就是说，如果正位于当前行的下标 i ，那么下一步可以移动到下一行的下标 i 或 i + 1 。

输入：triangle = [[2],[3,4],[6,5,7],[4,1,8,3]]
输出：11
解释：如下面简图所示：
   2
  3 4
 6 5 7
4 1 8 3
自顶向下的最小路径和为11（即，2+3+5+1= 11）。

输入：triangle = [[-10]]
输出：-10
 */

//动态规划
class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        //空数组和单排和两排
        if (triangle == null || triangle.size() == 0)
            return 0;

        //动态规划,先声明顶元素,然后循环判断
        int[] memo = new int[triangle.size() +1];
        //倒着循环,防止覆盖
        for (int i = triangle.size() -1 ; i >= 0 ; i --){
            //获得当前行数据，防止覆盖
            List<Integer> list = triangle.get(i);

            for (int j = 0 ; j <= i ; j ++)
                memo[j] = list.get(j) + Math.min(memo[j], memo[j+1]);
        }

        return memo[0];
    }
}

/*//直接在上面改
int minimumTotal(vector<vector<int>> &triangle)
{
    for (int i = triangle.size() - 2; i >= 0; i--)
        for (int j = 0; j < triangle[i].size(); j++)
            triangle[i][j] += min(triangle[i + 1][j], triangle[i + 1][j + 1]);
    return triangle[0][0];
}
 */