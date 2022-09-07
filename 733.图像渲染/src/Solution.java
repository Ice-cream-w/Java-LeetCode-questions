/*
有一幅以mxn的二维整数数组表示的图画image，其中image[i][j]表示该图画的像素值大小。

你也被给予三个整数 sr ,sc 和 newColor 。你应该从像素image[sr][sc]开始对图像进行 上色填充 。

为了完成 上色工作 ，从初始像素开始，记录初始坐标的 上下左右四个方向上 像素值与初始坐标相同的相连像素点，
接着再记录这四个方向上符合条件的像素点与他们对应 四个方向上 像素值与初始坐标相同的相连像素点，……，
重复该过程。将所有有记录的像素点的颜色值改为newColor。

最后返回 经过上色渲染后的图像。

输入: image = [[1,1,1],[1,1,0],[1,0,1]]，sr = 1, sc = 1, newColor = 2
输出: [[2,2,2],[2,2,0],[2,0,1]]
解析: 在图像的正中间，(坐标(sr,sc)=(1,1)),在路径上所有符合条件的像素点的颜色都被更改成2。
注意，右下角的像素没有更改为2，因为它不是在上下左右四个方向上与初始点相连的像素点。

输入: image = [[0,0,0],[0,0,0]], sr = 0, sc = 0, newColor = 2
输出: [[2,2,2],[2,2,2]]

深度优先搜索，广度优先搜索
 */

class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int oldColor = image[sr][sc];
        DFS(image,sr,sc,newColor,oldColor);
        return image;
    }

    public void DFS(int[][] image,int x,int y,int newColor,int oldColor){
        if(x < 0 || x >= image.length || y < 0 || y >= image[0].length) {
            return;
        }
        if(image[x][y] != oldColor || image[x][y] == newColor){
            return;
        }
        image[x][y] = newColor;
        DFS(image, x - 1, y,newColor,oldColor);
        DFS(image, x + 1, y,newColor,oldColor);
        DFS(image, x, y - 1,newColor,oldColor);
        DFS(image, x, y + 1,newColor,oldColor);
    }
}