/*
给定一个由 0 和 1 组成的矩阵 mat，请输出一个大小相同的矩阵，其中每一个格子是 mat 中对应位置元素到最近的 0 的距离。
两个相邻元素间的距离为 1 。

输入：mat = [[0,0,0],[0,1,0],[0,0,0]]
输出：[[0,0,0],[0,1,0],[0,0,0]]

输入：mat = [[0,0,0],[0,1,0],[1,1,1]]
输出：[[0,0,0],[0,1,0],[1,2,1]]
 */

import java.util.LinkedList;
import java.util.Queue;

class Solution {
    private int row;
    private int col;
    //设置上下左右移动方向
    private int[][] vector = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    /**
     * DP（两次遍历，可 AC）动态规划，Dynamic Programming
     */
    public int[][] updateMatrix_1(int[][] matrix) {
        row = matrix.length;
        col = matrix[0].length;
        // 第一次遍历，正向遍历，根据相邻左元素和上元素得出当前元素的对应结果
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                //将元素为1的格子的元素改成行+列的值，即视[0][0]为0元素
                if (matrix[i][j] == 1)
                    matrix[i][j] = row + col;
                //比较此元素行+列的值，和左边元素+1后值的大小，更新值
                if (i > 0)
                    matrix[i][j] = Math.min(matrix[i][j], matrix[i - 1][j] + 1);
                //比较此元素行+列的值，和上边元素+1后值的大小，更新值
                if (j > 0)
                    matrix[i][j] = Math.min(matrix[i][j], matrix[i][j - 1] + 1);
            }
        }
        // 第二次遍历，反向遍历，根据相邻右元素和下元素及当前元素的结果得出最终结果
        for (int i = row - 1; i >= 0; i--) {
            for (int j = col - 1; j >= 0; j--) {
                //比较此元素行+列的值，和右边元素+1后值的大小，更新值
                if (i < row - 1)
                    matrix[i][j] = Math.min(matrix[i][j], matrix[i + 1][j] + 1);
                //比较此元素行+列的值，和下边元素+1后值的大小，更新值
                if (j < col - 1)
                    matrix[i][j] = Math.min(matrix[i][j], matrix[i][j + 1] + 1);
            }
        }
        return matrix;
    }


    /**
     * BFS（迭代实现，可 AC），广度优先搜索，Breadth First Search
     */
    public int[][] updateMatrix_2(int[][] matrix) {
        row = matrix.length;
        col = matrix[0].length;
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                // 将所有 0 元素作为 BFS 第一层，元素为0的位置开始往下搜索
                if (matrix[i][j] == 0)
                    queue.add(new int[]{i, j});
                else
                    matrix[i][j] = row + col;
            }
        }
        while (!queue.isEmpty()) {
            int[] s = queue.poll();
            // 搜索上下左右四个方向，在值为a旁边的值，应该是a+1，比较此处的值与a+1的大小，大了就改
            for (int[] v : vector) {
                int r = s[0] + v[0], c = s[1] + v[1];
                if (r >= 0 && r < row
                        && c >= 0 && c < col
                        && matrix[r][c] > matrix[s[0]][s[1]] + 1) {
                    matrix[r][c] = matrix[s[0]][s[1]] + 1;
                    queue.add(new int[]{r, c});
                }
            }
        }
        return matrix;
    }


    /**
     * DFS（递归实现，解答正确，但是会超时，下方是优化版），深度优先搜索，Depth First Search
     */
    public int[][] updateMatrix_3(int[][] matrix) {
        row = matrix.length;
        col = matrix[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                //将元素为1的格子的元素改成行+列的值，即视[0][0]为0元素
                //会超时，因为原本在0旁边的1不需要改
                if (matrix[i][j] == 1) {
                    matrix[i][j] = row + col;
                }
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                //从元素为0开始更新
                if (matrix[i][j] == 0) {
                    updateMatrix(matrix, i, j);
                }
            }
        }
        return matrix;
    }


    /**
     * DFS（递归实现，优化版，可 AC），深度优先搜索，
     */
    public int[][] updateMatrix(int[][] matrix) {
        row = matrix.length;
        col = matrix[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                // 优化：如果元素在 0 附近，保留元素值 1，不在 0 附近，初始化为一个较大值
                if (matrix[i][j] == 1
                        && !((i > 0 && matrix[i - 1][j] == 0)
                        || (i < row - 1 && matrix[i + 1][j] == 0)
                        || (j > 0 && matrix[i][j - 1] == 0)
                        || (j < col - 1 && matrix[i][j + 1] == 0)))
                    matrix[i][j] = row + col;
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                // 优化：将元素值为 1 的点作为深搜起点，降低递归深度
                if (matrix[i][j] == 1)
                    updateMatrix(matrix, i, j);
            }
        }
        return matrix;
    }

    /**
     * DFS 递归函数
     */
    private void updateMatrix(int[][] matrix, int r, int c) {
        // 搜索上下左右四个方向
        for (int[] v : vector) {
            int nr = r + v[0], nc = c + v[1];
            //在值为a旁边的值，应该是a+1，比较此处的值与a+1的大小，大了就改
            if (nr >= 0 && nr < row
                    && nc >= 0 && nc < col
                    && matrix[nr][nc] > matrix[r][c] + 1) {
                matrix[nr][nc] = matrix[r][c] + 1;
                updateMatrix(matrix, nr, nc);
            }
        }
    }
}
