/*
给你一个 m x n 的矩阵 board ，由若干字符 'X' 和 'O' ，找到所有被 'X' 围绕的区域，
并将这些区域里所有的 'O' 用 'X' 填充。

输入：board = [
["X","X","X","X"],
["X","O","O","X"],
["X","X","O","X"],
["X","O","X","X"]]
输出：[
["X","X","X","X"],
["X","X","X","X"],
["X","X","X","X"],
["X","O","X","X"]]
解释：被围绕的区间不会存在于边界上，换句话说，任何边界上的'O'都不会被填充为'X'。
任何不在边界上，或不与边界上的'O'相连的'O'最终都会被填充为'X'。
如果两个元素在水平或垂直方向相邻，则称它们是“相连”的。
 */

//深度优先搜索
class Solution {
    private //四个方向
    int[][] vector = {{0,1},{0,-1},{1,0},{-1,0}};

    public void solve(char[][] board) {
        //将O全部改为y
        for(int i = 0 ; i < board.length ; i ++){
            for (int j = 0 ; j < board[0].length ; j ++){
                if (board[i][j] == 'O')
                    board[i][j] = 'y';
            }
        }

        //寻找边界上的y和与其相邻的y，改为O
        int i = 0;
        //第一行和最后一行
        while (i < board[0].length){
            BFS(0,i,board);
            BFS(board.length-1,i,board);
            i ++;
        }
        i = 0;
        //第一列和最后一列
        while (i < board.length){
            BFS(i,0,board);
            BFS(i,board[0].length-1,board);
            i ++;
        }

        //将被包围的全部改为X
        for(i = 0 ; i < board.length ; i ++){
            for (int j = 0 ; j < board[0].length ; j ++){
                if (board[i][j] == 'y')
                    board[i][j] = 'X';
            }
        }
    }

    private void BFS(int row, int col, char[][] grid){
        //是y就改为O
        if (grid[row][col] == 'y'){
            grid[row][col] = 'O';
            //向四周延伸
            for (int[] v : vector) {
                int nr = row + v[0], nc = col + v[1];
                //不超过边界
                if (nr >= 0 && nr < grid.length && nc >= 0 && nc < grid[0].length){
                    if (grid[nr][nc] == 'y') {
                        BFS(nr, nc,grid);
                    }
                }
            }
        }
    }
}