/*
数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且有效的括号组合。

输入：n = 3
输出：["((()))","(()())","(())()","()(())","()()()"]
 */

import java.util.ArrayList;
import java.util.List;

//回溯
class Solution {
    //结果集合
    private List<String> list = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        backTrack(n,0,0,"");
        return list;
    }

    //递归,count1计数左括号，count2计数右括号
    public void backTrack(int n, int count1, int count2, String s1) {
        //终止条件，一方到底返回，都到底了就输出
        if (count1 > n || count2 > n) return;
        if (count1 == n && count2 == n) list.add(s1);

        //一定先左括号再是右括号，每次遍历一个左括号，就创建两个递归，一个继续走左括号，另一个走右括号
        if (count1 >= count2){
            String s2 = new String(s1);
            backTrack(n,count1+1,count2,s1+"(");
            backTrack(n,count1,count2+1,s2+")");
        }
    }
}