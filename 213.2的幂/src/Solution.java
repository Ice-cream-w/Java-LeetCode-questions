/*
给你一个整数 n，请你判断该整数是否是 2 的幂次方。如果是，返回 true ；否则，返回 false 。
如果存在一个整数 x 使得n == 2x ，则认为 n 是 2 的幂次方。

输入：n = 1
输出：true
解释：2的0次方 = 1

输入：n = 3
输出：false
 */

//递归
class Solution {
    public boolean isPowerOfTwo(int n) {
        // 1%2不为0，0%2为0，但是得单独提出来
        if(n == 1)
            return true;
        if(n == 0)
            return false;

        //递归排除%2不为0的非2的幂次方的数
        if (n % 2 != 0)
            return false;
        return isPowerOfTwo(n / 2);
    }
}