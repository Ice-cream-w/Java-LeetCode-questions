/*
给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。

输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
输出：6
解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，
可以接 6 个单位的雨水（蓝色部分表示雨水）。

输入：height = [4,2,0,3,2,5]
输出：9
 */

import java.util.Stack;

//双指针，栈
class Solution {
    public int trap(int[] height) {
        //空数组
        if (height == null)
            return 0;

        //栈
        Stack<Integer> stack = new Stack<>();
        int ans = 0;

        for (int i = 0; i < height.length; i++) {
            //栈尾小于下一个值，表示可以接水了
            while(!stack.isEmpty() && height[stack.peek()] < height[i]) {
                int curIdx = stack.pop();
                //柱子和刚弹栈的同高度，继续弹
                while (!stack.isEmpty() && height[stack.peek()] == height[curIdx])
                    stack.pop();

                //计算这一高度的雨水量
                if (!stack.isEmpty()) {
                    int stackTop = stack.peek();
                    //[4,2,2,2,5]，2和2是curIdx在上一个while被弹出，左值stackTop=4小于右值height[i]=5
                    //ans结果为高度（min(4,5)-2）*（长度-1）
                    ans += (Math.min(height[stackTop], height[i]) - height[curIdx]) * (i - stackTop - 1);
                }
            }

            //栈尾大于下一个值，还不能接水，入栈
            stack.add(i);
        }

        return ans;
    }
}