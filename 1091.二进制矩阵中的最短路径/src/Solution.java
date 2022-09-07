/*
给你一个 n x n 的二进制矩阵 grid 中，返回矩阵中最短 畅通路径 的长度。如果不存在这样的路径，返回 -1 。
二进制矩阵中的 畅通路径 是一条从 左上角 单元格（即，(0, 0)）到 右下角 单元格（即，(n - 1, n - 1)）的路径，
该路径同时满足下述要求：

路径途经的所有单元格都的值都是 0 。
路径中所有相邻的单元格应当在 8 个方向之一 上连通（即，相邻两单元之间彼此不同且共享一条边或者一个角）。
畅通路径的长度 是该路径途经的单元格总数。

输入：grid = [
[0,1],
[1,0]]
输出：2

输入：grid = [
[0,0,0],
[1,1,0],
[1,1,0]]
输出：4

输入：grid = [
[1,0,0],
[1,1,0],
[1,1,0]]
输出：-1
 */

import java.util.LinkedList;
import java.util.Queue;

//深度优先搜索
class Solution {
    public static int shortestPathBinaryMatrix(int[][] grid) {
        //空数组
        if (grid == null || grid.length == 0 || grid[0].length == 0)
            return -1;

        // 如果起点就阻塞那就玩完啦
        if (grid[0][0]==1)
            return -1;

        //定义 8个方向
        int[][] dir = {{1, -1}, {1, 0}, {1, 1}, {0,-1},{0,1},{-1,-1},{-1,0},{-1,1}};
        int m = grid.length;
        int n = grid[0].length;
        //bfs的老套路 来个队列
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0,0});   //把起点扔进去
        grid[0][0] = 1;        // 把起点标记为阻塞
        int path = 1;     // 层数

        while (!queue.isEmpty()){
            int size = queue.size();
            while(size-- > 0){
                int[] cur = queue.poll();
                int x  = cur[0];
                int y  = cur[1];

                //能放进队列里的都是为0可以走的（这一点在后面保证了）
                // 如果等于终点则返回
                if (x == m-1 && y == n-1){    //
                    return path;
                }

                //开始八个方向的判断
                for (int[] d : dir){
                    int x1 = x + d[0];
                    int y1 = y + d[1];
                    //这里开始过滤
                    if (x1 < 0 || x1 >= m || y1 < 0||y1>=m || grid[x1][y1]==1){
                        continue;
                    }
                    //把在数组范围内 并且为0不阻塞的放入队列中
                    queue.add(new int[]{x1,y1});
                    grid[x1][y1] = 1; // 经过即改标记
                }
            }
            path++;  //遍历完一层 这时候要 ++啦
        }
        return -1;
    }
}
