/*
给你一个字符串 s，找到 s 中最长的回文子串。

输入：s = "babad"
输出："bab"
解释："aba" 同样是符合题意的答案。
 */
//10ms
class Solution {
    public String longestPalindrome(String s) {
        //存放标记的数组
        int[] c = {0, 1};
        char[] chars = new char[s.length()];

        //0个和1个
        if (null == s)
            return null;
        if (1 == s.length())
            return s;

        for(int i = 0 ; i < s.length() ;i ++)
            chars[i] = s.charAt(i);

        //i是起始指针，判断该元素是否与下一元素相同，相同则往两边扩散寻找回文范围
        //回文是ebccbade或者ababba形式，中间两个或者中间的左右两个必定相同
        for (int i = 0 , max = 0; i < s.length() - 1; i++) {
            //要返回最长回文，判断是否比之前的回文长度长
            if (i < s.length() - 2 && chars[i] == chars[i + 2]){
                int max1 = numPalindrome(chars, i+1, i+1);
                if (max1 > max){
                    max = max1;
                    c[0] = i+1-max1;
                    c[1] = i+2+max1;
                }
            }
            if(chars[i] == chars[i + 1]){
                int max1 = numPalindrome(chars, i, i+1);
                if (max1 >= max){
                    max = max1;
                    c[0] = i-max1;
                    c[1] = i+2+max1;
                }
            }
        }
        //找不到就返回第一个字母
        return s.substring(c[0],c[1]);
    }

    //判断是否是回文aabba
    public int numPalindrome(char[] chars, int m, int n) {
        for (int j = 1; j<m+1 && j<chars.length-n; j++) {
            if (chars[m - j] != chars[n + j])
                return j-1;
        }
        return Math.min(m,chars.length-n-1);
    }
}

/*更优解4ms
class Solution {
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
//         保存起始位置，测试了用数组似乎能比全局变量稍快一点
        int[] range = new int[2];
        char[] str = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
//             把回文看成中间的部分全是同一字符，左右部分相对称
//             找到下一个与当前字符不同的字符
            i = findLongest(str, i, range);
        }
        return s.substring(range[0], range[1] + 1);
    }

    public static int findLongest(char[] str, int low, int[] range) {
//         查找中间部分
        int high = low;
        while (high < str.length - 1 && str[high + 1] == str[low]) {
            high++;
        }
//         定位中间部分的最后一个字符
        int ans = high;
//         从中间向左右扩散
        while (low > 0 && high < str.length - 1 && str[low - 1] == str[high + 1]) {
            low--;
            high++;
        }
//         记录最大长度
        if (high - low > range[1] - range[0]) {
            range[0] = low;
            range[1] = high;
        }
        return ans;
    }
}
 */

