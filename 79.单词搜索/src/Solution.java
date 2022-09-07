/*
给定一个m*n 二维字符网格board 和一个字符串单词word 。如果word 存在于网格中，返回 true；否则，返回 false。

单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。
同一个单元格内的字母不允许被重复使用。

输入：board = [
["A","B","C","E"],
["S","F","C","S"],
["A","D","E","E"]], word = "ABCCED"
输出：true

输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "SEE"
输出：true

输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCB"
输出：false
 */

import java.util.ArrayList;
import java.util.List;

//回溯
class Solution {
    //是否符合的标志
    private boolean iseuqal = false;
    private int[][] vector = {{0,1},{0,-1},{1,0},{-1,0}};

    public boolean exist(char[][] board, String word) {
        //空数组,空字符串,或数组长度小于字符串长度的
        if (word.length() == 0)
            return true;
        if (board.length == 0 || board.length * board[0].length < word.length())
            return false;

        //找到符合条件的起始点
        for (int i = 0 ; i < board.length ; i ++){
            for (int j = 0 ; j < board[0].length ; j ++){
                if (word.charAt(0) == board[i][j])
                    equals(i,j,1,word,board);
            }
        }

        return iseuqal;
    }

    //递归
    private void equals(int n, int m, int k, String word, char[][] board){
        //终止条件
        if (k == word.length()){
            iseuqal = true;
            return;
        }

        //递归，搜索上下左右四个方向
        for (int[] v : vector) {
            int n1 = n + v[0], m1 = m + v[1];
            //查找四周在边界内，且与字符串该位置处字母一样的元素
            if (n1 >= 0 && n1 < board.length && m1 >= 0 && m1 < board[0].length){
                if (word.charAt(k) == board[n1][m1]){
                    char c = board[n][m];
                    //改变值，防止走回头路
                    board[n][m] = '1';

                    equals(n1,m1,k+1,word,board);

                    //走完或者不通，则把原来的值改回来
                    board[n][m] = c;
                }
            }
        }
    }
}