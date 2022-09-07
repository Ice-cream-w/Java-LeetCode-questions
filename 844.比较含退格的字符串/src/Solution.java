/*
给定 s 和 t 两个字符串，当它们分别被输入到空白的文本编辑器后，如果两者相等，返回 true 。# 代表退格字符。

注意：如果对空文本输入退格字符，文本继续为空。

输入：s = "ab#c", t = "ad#c"
输出：true
解释：s 和 t 都会变成 "ac"。

输入：s = "ab##", t = "c#d#"
输出：true
解释：s 和 t 都会变成 ""。

输入：s = "a#c", t = "b"
输出：false
解释：s 会变成 "c"，但 t 仍然是 "b"。
 */

//双指针
class Solution {
    public boolean backspaceCompare(String s, String t) {
        //记录退格数
        int skips = 0;
        int skipt = 0;
        char[] S = s.toCharArray();
        char[] T = t.toCharArray();

        for (int i = s.length() -1, j = t.length() -1;i >= 0 || j >= 0;i --, j --){
            //S,遇到退格，记录次数
            while(i >= 0){
                if (S[i] == '#')
                    skips ++;
                //遇到字符且记录数大于0则记录数-1
                else if (skips > 0)
                    skips --;
                //遇到字符且记录数为0则判断是否相同
                else
                    break;
                i --;
            }
            //T,遇到退格，记录次数
            while(j >= 0){
                if (T[j] == '#')
                    skipt ++;
                    //遇到字符且记录数大于0则记录数-1
                else if (skipt > 0)
                    skipt --;
                    //遇到字符且记录数为0则判断是否相同
                else
                    break;
                j --;
            }

            //比较字符
            if (i >= 0 && j >= 0) {
                if (S[i] != T[j])
                    return false;
            } else if (i >= 0 || j >= 0) {
                // 有其中一方已经遍历完整个字符串, 但另外一方没有遍历完整个字符串, 直接返回false
                return false;
            }
        }

        return true;
    }
}