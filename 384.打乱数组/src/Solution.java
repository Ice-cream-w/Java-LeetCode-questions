/*
给你一个整数数组nums，设计算法来打乱一个没有重复元素的数组。打乱后，数组的所有排列应该是等可能的。

实现 Solution class:

Solution(int[] nums) 使用整数数组 nums 初始化对象
int[] reset() 重设数组到它的初始状态并返回
int[] shuffle() 返回数组随机打乱后的结果

输入
["Solution", "shuffle", "reset", "shuffle"]
[[[1, 2, 3]], [], [], []]
输出
[null, [3, 1, 2], [1, 2, 3], [1, 3, 2]]
解释
Solution solution = new Solution([1, 2, 3]);
solution.shuffle();    // 打乱数组 [1,2,3] 并返回结果。任何 [1,2,3]的排列返回的概率应该相同。
例如，返回 [3, 1, 2]
solution.reset();      // 重设数组到它的初始状态 [1, 2, 3] 。返回 [1, 2, 3]
solution.shuffle();    // 随机返回数组 [1, 2, 3] 打乱后的结果。例如，返回 [1, 3, 2]
 */

//随机数
class Solution {

    private int[] n;

    public Solution(int[] nums) {
        n = nums;
    }

    public int[] reset() {
        return n;
    }

    //思路是在前n-1张牌洗好的情况下，第n张牌随机与前n-1张牌的其中一张牌交换，或者不换
    public int[] shuffle() {
        //新数组，不然会污染n
        int[] m = new int[n.length];
        for (int i = 0 ; i < n.length ; i ++)
            m[i] = n[i];
        int j = 0;

        for (int i = 0 ; i < n.length ; i ++){
            int k = (int)(Math.random()*n.length);
            //交换
            j = m[i];
            m[i] = m[k];
            m[k] = j;
        }
        return m;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */