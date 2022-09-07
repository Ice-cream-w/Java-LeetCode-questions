/*
给你两个整数 left 和 right ，表示区间 [left, right] ，
返回此区间内所有数字 按位与 的结果（包含 left 、right 端点）。

输入：left = 5, right = 7
0101 0110  0111  =0100
输出：4

输入：left = 1, right = 2147483647
输出：0
 */

//位运算
/*
class Solution {
    public int rangeBitwiseAnd(int left, int right) {
        int[] m = new int[31];
        int[] n = new int[31];
        int[] k = new int[31];

        //放进数组，形成{1010}和{1110}
        int i = 0;
        while (right != 0){
            if (left != 0){
                m[i] = left % 2;
                left /= 2;
            }

            n[i++] = right % 2;
            right /= 2;
        }

        //倒着找第一个left和right同时为1的位置，判断l和r所属的区间
        for (int j = 30 ; j >= 0 ; j --){
            //排除末尾一堆0
            if (n[j] != 0)
                k[j] = n[j] & m[j];

            //right比left大一个量级的话，相与必是0
            // 找到第一个11后，寻找第一个不是11的
            if (n[j] != m[j])
                break;
        }

        int t = 30;
        int max = 0;
        while (t >= 0)
            max = max * 2 + k[t--];

        return max;
    }
}*/

//位运算
class Solution {
    public int rangeBitwiseAnd(int left, int right) {
        int max = 0;

        //寻找left和right相同的时候，不相同则右移，去掉不相同的尾端
        while (left != right){
            right >>= 1;
            left >>= 1;
            max ++;
        }

        //返回移动后的right
        return right <<= max;
    }
}