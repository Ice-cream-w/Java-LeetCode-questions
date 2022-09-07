/*
给定一个长度为 n 的整数数组height。有n条垂线，第 i 条线的两个端点是(i, 0)和(i, height[i])。
找出其中的两条线，使得它们与x轴共同构成的容器可以容纳最多的水。
返回容器可以储存的最大水量。
说明：你不能倾斜容器。

输入：[1,8,6,2,5,4,8,3,7]
输出：49
解释：图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。
在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为49。
 */

//双指针
class Solution {
    public int maxArea(int[] height) {
        int area = 0;
        //空数组
        if(0 == height.length)
            return 0;

        //循环遍历每个元素，双指针左右并进，最小的移动
        for (int i = 0 , j = height.length - 1, area1 = 0; i < j; ) {
            if (height[i] > height[j]){
                area1 = height[j] * (j-i);
                j --;
            }
            else {
                area1 = height[i] * (j-i);
                i ++;
            }

            if (area1 > area)
                area = area1;
        }
        return area;
    }
}