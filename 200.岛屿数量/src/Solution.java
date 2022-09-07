/*
给你一个由'1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。
此外，你可以假设该网格的四条边均被水包围

输入：grid = [
  ["1","1","1","1","0"],
  ["1","1","0","1","0"],
  ["1","1","0","0","0"],
  ["0","0","0","0","0"]
]
输出：1

输入：grid = [
  ["1","1","0","0","0"],
  ["1","1","0","0","0"],
  ["0","0","1","0","0"],
  ["0","0","0","1","1"]
]
输出：3
 */

//深度优先搜索
class Solution {
    public int numIslands(char[][] grid) {
        int num = 0;
        //遍历每一个岛屿，遇到一个岛屿，把该岛屿的所有值转为0，然后计数+1
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == '1'){
                    DFS(grid, i, j);
                    num ++;
                }
            }
        }

        return num;
    }

    public void DFS(char[][] grid,int x,int y){
        //除超出边界的、值为0的
        if (x < 0 || y < 0 || x >= grid.length || y >= grid[x].length || grid[x][y] == '0')
            return;

        //防止二次计算该处
        grid[x][y] = '0';
        //四方遍历，遇1归0
        DFS(grid, x+1, y);
        DFS(grid, x, y+1);
        DFS(grid, x-1, y);
        DFS(grid, x, y-1);
    }
}