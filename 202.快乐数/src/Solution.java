/*
编写一个算法来判断一个数 n 是不是快乐数。
「快乐数」定义为：

对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和。
然后重复这个过程直到这个数变为 1，也可能是 无限循环 但始终变不到 1。
如果这个过程 结果为1，那么这个数就是快乐数。
如果 n 是 快乐数 就返回 true ；不是，则返回 false 。

输入：n = 19
输出：true
解释：
12 + 92 = 82
82 + 22 = 68
62 + 82 = 100
12 + 02 + 02 = 1

输入：n = 2
输出：false
 */

import java.util.HashMap;

//哈希表
class Solution {
    public boolean isHappy(int n) {
        //建立一一对应的哈希表，便于查找存放
        HashMap<Integer,Integer> hash = new HashMap<Integer,Integer>();
        int k = 0;
        int i = 0;

        //k为1跳出返回true
        while (n != 1){
            //如果哈希表中有k了，表示无限循环达不到1
            if (hash.containsKey(n))
                return false;

            //把k存入哈希表
            hash.put(n,i++);
            k = 0;
            for (int j = 0 ; n != 0 ; j ++){
                k += (n % 10) * (n % 10);
                n /= 10;
            }

            n = k;
        }

        return true;
    }
}

/*
//双指针
//参考英文网站热评第一。这题可以用快慢指针的思想去做，有点类似于检测是否为环形链表那道题
//如果给定的数字最后会一直循环重复，那么快的指针（值）一定会追上慢的指针（值），也就是
//两者一定会相等。如果没有循环重复，那么最后快慢指针也会相等，且都等于1。
class Solution {
    public boolean isHappy(int n) {
        int fast=n;
        int slow=n;
        do{
            slow=squareSum(slow);
            fast=squareSum(fast);
            fast=squareSum(fast);
        }while(slow!=fast);
        if(fast==1)
            return true;
        else return false;
    }

    private int squareSum(int m){
        int squaresum=0;
        while(m!=0){
           squaresum+=(m%10)*(m%10);
            m/=10;
        }
        return squaresum;
    }
}
 */