/*
给你一个数组 points ，其中 points[i] = [xi, yi] 表示 X-Y 平面上的一个点。
求最多有多少个点在同一条直线上。

输入：points = [[1,1],[2,2],[3,3]]
输出：3

输入：points = [[1,1],[3,2],[5,3],[4,1],[2,3],[1,4]]
输出：4
 */

import java.util.ArrayList;
import java.util.List;

//哈希表
class Solution {
    public int maxPoints(int[][] points) {
        //单个数组
        if(points.length == 1)
            return 1;

        //斜率一样的最大值
        int max = 0;
        //计算每个点与其他点的斜率，放入一个集合中，斜率为0的放入另一个集合
        for (int i = 0 ; i < points.length ; i++){
            List<Double> l = new ArrayList<Double>();
            List l2 = new ArrayList();

            for (int j = i +1 ; j < points.length ; j++){
                if (points[i][0] - points[j][0] != 0){
                    double k = (double)(points[i][1] - points[j][1]) / (points[i][0] - points[j][0]);
                    l.add(k);
                }
                else
                    l2.add(points[j]);
            }

            //比较集合中的数，数一样表示同斜率，表示在同一直线上，res+1
            for (int o = 0 ; o < l.size() ; o++){
                int res = 1;
                for (int p = o +1 ; p < l.size() ; p ++){
                    if (l.get(o) - l.get(p) == 0.0)
                        res ++;
                }
                max = Math.max(max, res+1);
            }

            //最后比较此点上斜率非0的同一直线上的点数量，和斜率为0的点数
            //斜率为0表示垂直线，也是同一直线上
            max = Math.max(max, l2.size()+1);
        }

        return max;
    }
}