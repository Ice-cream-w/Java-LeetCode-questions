/*
在给定的m*n网格grid中，每个单元格可以有以下三个值之一：

值0代表空单元格；
值1代表新鲜橘子；
值2代表腐烂的橘子。
每分钟，腐烂的橘子周围4个方向上相邻 的新鲜橘子都会腐烂。

返回 直到单元格中没有新鲜橘子为止所必须经过的最小分钟数。如果不可能，返回-1。

输入：grid = [[2,1,1],[1,1,0],[0,1,1]]
输出：4

输入：grid = [[2,1,1],[0,1,1],[1,0,1]]
输出：-1
解释：左下角的橘子（第 2 行， 第 0 列）永远不会腐烂，因为腐烂只会发生在 4 个正向上。

[[2,1,1],
 [0,1,1],
 [1,0,1]]
 */
有误
//搜索
class Solution {
    private int row;
    private int col;
    //设置上下左右移动方向
    private int[][] vector = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public int orangesRotting(int[][] grid) {
        row = grid.length;
        col = grid[0].length;
        int k = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                // 如果元素在 0 附近且四周都是0，或者是边角是1，另外两个方向是0，返回-1
                if (grid[i][j] == 1 &&
                        (((i > 0 && grid[i - 1][j] == 0)
                          && (i < row - 1 && grid[i + 1][j] == 0)
                          && (j > 0 && grid[i][j - 1] == 0)
                          && (j < col - 1 && grid[i][j + 1] == 0))
                        || ((i == 0 && row > 1 && grid[i + 1][j] == 0)
                             && (j == 0 && grid[i][j + 1] == 0))
                        || ((i == 0 && grid[i + 1][j] == 0)
                             && (j == col - 1 && grid[i][j - 1] == 0))
                        || ((i == row - 1 && grid[i - 1][j] == 0)
                             && (j == 0 && grid[i][j + 1] == 0))
                        || ((i == row - 1 && grid[i - 1][j] == 0)
                             && (j == col - 1 && grid[i][j - 1] == 0))))
                    return -1;

                // 改 2 为 -2 ，避免与 2 分钟冲突
                if (grid[i][j] == 2)
                    grid[i][j] = -2;

                // 所有 1 元素初始化为一个较大值
                if (grid[i][j] == 1){
                    grid[i][j] = i + j;
                    k ++;
                    // 如果元素在 2 附近，保留元素值 1
                    if ((i > 0 && grid[i - 1][j] == -2)
                             || (i < row - 1 && grid[i + 1][j] == -2)
                             || (j > 0 && grid[i][j - 1] == -2)
                             || (j < col - 1 && grid[i][j + 1] == -2))
                        grid[i][j] = 1;
                }
            }
        }

        if (k == 0)
            return 0;

        k = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                // 优化：将元素值为 1 的点作为深搜起点，降低递归深度
                if (grid[i][j] == 1)
                    k = updateGrid(grid, i, j, k);
            }
        }
        return k;
    }

    /**
     * DFS 递归函数
     */
    private int updateGrid(int[][] grid, int r, int c, int k) {
        // 搜索上下左右四个方向
        for (int[] v : vector) {
            int nr = r + v[0], nc = c + v[1];
            //在值为a旁边的值，应该是a+1，比较此处的值与a+1的大小，大了就改
            if (nr >= 0 && nr < row && nc >= 0 && nc < col){
                if (grid[nr][nc] >= grid[r][c] + 1) {
                    grid[nr][nc] = grid[r][c] + 1;
                    k = updateGrid(grid, nr, nc, k);
                }
                if (grid[nr][nc] > k)
                    k = grid[nr][nc];
            }
        }

        return k;
    }
}

