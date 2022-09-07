/*
给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合。
你可以按 任何顺序 返回答案。

输入：n = 4, k = 2
输出：
[
  [2,4],
  [3,4],
  [2,3],
  [1,2],
  [1,3],
  [1,4],
]

输入：n = 1, k = 1
输出：[[1]]
 */

import java.util.ArrayList;
import java.util.List;

//回溯,回溯是利用递归来实现多重for循环
class Solution {
    //返回的数组和放入的数组元素，全局变量方便回溯调用，减少参数设置
    List<List<Integer>> result = new ArrayList<List<Integer>>();
    List<Integer> list = new ArrayList<Integer>();

    public List<List<Integer>> combine(int n, int k) {
        //起始
        backTracking(n,k,1);
        return result;
    }

    //回溯
    private void backTracking(int n, int k, int start){
        //终止条件
        if(k == list.size()){
            //要创建新数组，否则是空值
            result.add(new ArrayList(list));
            return;
        }

        //递归，判断条件可以优化节省时间
        for (int i = start ; i <= n-k+1+list.size() ; i ++){
            list.add(i);
            backTracking(n,k,i+1);
            list.remove(list.size()-1);
        }
    }
}