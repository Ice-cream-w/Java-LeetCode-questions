/*
有 n 个城市，其中一些彼此相连，另一些没有相连。如果城市 a 与城市 b 直接相连，
且城市 b 与城市 c 直接相连，那么城市 a 与城市 c 间接相连。

省份 是一组直接或间接相连的城市，组内不含其他没有相连的城市。
给你一个 n x n 的矩阵 isConnected ，其中 isConnected[i][j] = 1
表示第 i 个城市和第 j 个城市直接相连，而 isConnected[i][j] = 0 表示二者不直接相连。

返回矩阵中 省份 的数量。

输入：isConnected =
[[1,1,0]
,[1,1,0]
,[0,0,1]]
输出：2

输入：isConnected =
[[1,0,0]
,[0,1,0]
,[0,0,1]]
输出：3
 */

//深度优先搜索
class Solution {
    public int findCircleNum(int[][] xy) {
        int count = 0;
        int n = xy.length;
        //记录每个城市是否被遍历，或者是否与之前被遍历的城市直接间接相连
        boolean[] visited = new boolean[n];

        for(int i=0;i<n;++i){
            //未遍历的城市记为一个省份，并查找与之直接间接相连的城市，将其转换成遍历过的状态
            if(!visited[i]){
                ++count;
                dfs(xy,i,n,visited);
            }
        }
        return count;
    }

    public void dfs(int[][] xy,int i,int n,boolean[] visited){
        visited[i]=true;
        for(int j=0;j<n;++j){
            //visit可以排除xy[i][i]
            if(!visited[j] && xy[i][j]==1){
                dfs(xy,j,n,visited);
            }
        }
    }
}