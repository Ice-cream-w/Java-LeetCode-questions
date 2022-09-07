/*
编写一个函数，其作用是将输入的字符串反转过来。输入字符串以字符数组 s 的形式给出。
不要给另外的数组分配额外的空间，你必须原地修改输入数组、使用 O(1) 的额外空间解决这一问题。

输入：s = ["h","e","l","l","o"]
输出：["o","l","l","e","h"]

输入：s = ["H","a","n","n","a","h"]
输出：["h","a","n","n","a","H"]
 */
//递归方法，但是满，占用内存多
class Solution {
    public void reverseString(char[] s) {
        //空数组或单个数组
        if (s == null || s.length == 1)
            return;
        change(s,0,s.length-1);
    }

    public void change(char[] chars, int left, int right){
        //终止条件
        if (left >= right){
            return;
        }

        //交换
        char i = chars[left];
        chars[left] = chars[right];
        chars[right] = i;

        change(chars,++left,--right);
    }
}

//直接循环更好
/*
class Solution {
    public void reverseString(char[] s) {
        int l = 0;
        int r = s.length - 1;
        while (l < r) {
            s[l] ^= s[r];  //构造 a ^ b 的结果，并放在 a 中
            s[r] ^= s[l];  //将 a ^ b 这一结果再 ^ b ，存入b中，此时 b = a, a = a ^ b
            s[l] ^= s[r];  //a ^ b 的结果再 ^ a ，存入 a 中，此时 b = a, a = b 完成交换
            l++;
            r--;
        }
    }
}
 */