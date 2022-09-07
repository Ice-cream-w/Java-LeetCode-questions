/*
给定两个由一些 闭区间 组成的列表，firstList 和 secondList ，其中 firstList[i] = [starti, endi]
而secondList[j] = [startj, endj] 。每个区间列表都是成对 不相交 的，并且 已经排序 。

返回这 两个区间列表的交集 。
形式上，闭区间[a, b]（其中a <= b）表示实数x的集合，而a <= x <= b 。
两个闭区间的 交集 是一组实数，要么为空集，要么为闭区间。例如，[1, 3] 和 [2, 4] 的交集为 [2, 3] 。

输入：firstList = [[0,2],[5,10],[13,23],[24,25]], secondList = [[1,5],[8,12],[15,24],[25,26]]
输出：[[1,2],[5,5],[8,10],[15,23],[24,24],[25,25]]

输入：firstList = [[1,3],[5,9]], secondList = []
输出：[]

输入：firstList = [[1,7]], secondList = [[3,10]]
输出：[[3,7]]
 */

import java.util.ArrayList;
import java.util.List;

//双指针
class Solution {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        //存储数组
        List<int[]> list = new ArrayList<>();
        int left = 0;
        int right = 0;

        //双指针遍历，判断是否有交集
        while(left < firstList.length && right < secondList.length){
            //选取交集，取两个数组开始的最大值和结束的最小值，组成集合
            int a = Math.max(firstList[left][0], secondList[right][0]);
            int b = Math.min(firstList[left][1], secondList[right][1]);

            //判断交集，两种情况
            // a<=b，返回集合ab，判断b是哪个数组的，再决定哪个left++还是right++
            // a>b，无交集，直接判断b是哪个数组的，再决定哪个left++还是right++
            if (a <= b){
                int[] ab = {a,b};
                list.add(ab);
            }

            if (b == firstList[left][1])
                left ++;
            else
                right ++;
        }
        //返回
        return list.toArray(new int[list.size()][]);
    }
}