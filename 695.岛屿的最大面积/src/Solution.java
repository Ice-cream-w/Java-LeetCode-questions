/*
给你一个大小为m*n的二进制矩阵 grid 。
岛屿是由一些相邻的1(代表土地) 构成的组合，这里的「相邻」要求两个 1 必须在 水平或者竖直的四个方向上 相邻。
你可以假设grid 的四个边缘都被 0（代表水）包围着。
岛屿的面积是岛上值为 1 的单元格的数目。
计算并返回 grid 中最大的岛屿面积。如果没有岛屿，则返回面积为 0 。

输入：grid =
[[0,0,1,0,0,0,0,1,0,0,0,0,0],
 [0,0,0,0,0,0,0,1,1,1,0,0,0],
 [0,1,1,0,1,0,0,0,0,0,0,0,0],
 [0,1,0,0,1,1,0,0,1,0,1,0,0],
 [0,1,0,0,1,1,0,0,1,1,1,0,0],
 [0,0,0,0,0,0,0,0,0,0,1,0,0],
 [0,0,0,0,0,0,0,1,1,1,0,0,0],
 [0,0,0,0,0,0,0,1,1,0,0,0,0]]
输出：6
解释：答案不应该是 11 ，因为岛屿只能包含水平或垂直这四个方向上的 1 。

输入：grid = [[0,0,0,0,0,0,0,0]]
输出：0
 */

class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int max = 0;
        //遍历每一个岛屿，比较出返回的最大值
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 1){
                    max = Math.max (DFS(grid, i, j), max);
                }
            }
        }

        return max;
    }

    public int DFS(int[][] grid,int x,int y){
        //除超出边界的、值为0的
        if (x < 0 || y < 0 || x >= grid.length || y >= grid[x].length || grid[x][y] == 0)
            return 0;

        //防止二次计算该处
        grid[x][y] = 0;
        int nums = 1;
        //四方遍历
        nums += DFS(grid, x+1, y);
        nums += DFS(grid, x, y+1);
        nums += DFS(grid, x-1, y);
        nums += DFS(grid, x, y-1);

        return nums;
    }
}