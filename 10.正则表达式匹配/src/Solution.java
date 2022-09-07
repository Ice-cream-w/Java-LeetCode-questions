/*+
给你一个字符串s和一个字符规律p，请你来实现一个支持 '.'和'*'的正则表达式匹配。

'.' 匹配任意单个字符
'*' 匹配零个或多个前面的那一个元素
所谓匹配，是要涵盖整个字符串s的，而不是部分字符串。

输入：s = "aa", p = "a"
输出：false
解释："a" 无法匹配 "aa" 整个字符串。

 *///超时，但是正确的
class Solution {
    public boolean isMatch(String s, String p) {
        if ("" == p || "" == s)
            return false;

        char[] chars = s.toCharArray();
        char[] chars1 = p.toCharArray();
/*      si =    pj  或pj =  .    下一个
        si !=   pj  1.pj =  * 且pj-1 =  .                算相等
        si !=   pj  2.pj =  * 且si-1 =  pj-1 且si =si-1  算相等
                    3.pj =  * 且si-1 != pj-1             跳过这个pj  i <= s.length() && j <= p.length()
        */
        for (int i = 0, j = 0; ;) {
            //相等，或p[j]是.,则直接通过,判定下一个,到底则返回
            while (i < s.length() && j < p.length() && (chars[i] == chars1[j] || '.' == chars1[j])){
                i ++;
                j ++;
            }
            //不相等，且p[j]是*，则查看p[j-1]是否为.,是.则跳下一个看是否相等，不相等则i++再判断
            if (i < s.length() && j < p.length() && '*' == chars1[j] && '.' == chars1[j - 1]){
                //p到底了
                if (j == p.length() - 1)
                    return true;
                //p没到底，s到底了
                else if (i == s.length() - 1)
                    return false;
                //ps都没到底，判断s和p下一个是否相等，相等则跳出去
                else {
                    while (i < s.length() && chars[i] != chars1[j + 1])
                        i ++;
                    j ++;
                }
                continue;
            }

            //不相等，且p[j]是*，则查看前一个是否相等且s[i]是否和s[i-1]相等    a？？和a*？
            if (i < s.length() && j < p.length() && '*' == chars1[j] && chars[i-1] == chars1[j-1]){
                //p到底了
                if (j == p.length() - 1)
                    return true;
                //p没到底，s到底了
                else if (i == s.length() - 1)
                    return false;
                //ps都没到底，s[i-1]不等于s[i],  ab和a*b
                else if(chars[i] != chars[i-1] && chars1[j++] != chars[i])
                    return false;
                //ps都没到底，s[i-1]等于s[i]，  aaa和a*
                else{
                    while(i < s.length()-1 && chars[i] == chars[i-1]){
                        i++;
                    }
                    j++;
                }
                continue;
            }

            //不相等，判断p下一个是否为*，是*代表p[j]可以去掉，p跳到下下个,s不变    aa和b*aa，如果是aa和b*就false
            if (i < s.length() && j < p.length() - 1 && chars[i] != chars1[j]){
                //s没到底，p到底了，和p的一个不相等，false
                if ('*' != chars1[j + 1]) {
                    return false;
                }
                else {
                    //ab和b*a
                    if (j == p.length()-3 && i == s.length() - 1 && chars[i] == chars1[j+2])
                        return true;
                    //ab和b*b*ab
                    while (j < p.length() - 4 && chars1[j++] != chars[i]){
                        if  ('*' == chars1[j++])
                            continue;
                        return false;
                    }
                }
                continue;
            }

            //完全匹配，要同时到底
            else if (i == s.length() && j == p.length())
                return true;

            else return false;
        }
    }
}

//优解，1ms
/*
class Solution {
    public boolean isMatch(String s, String p) {
        boolean[][] dpTable = new boolean[s.length() + 1][p.length() + 1];
        int count = 0;
        for (int i = 1; i < dpTable[0].length; i++) {
            if (i % 2 != 0) {
                dpTable[0][i] = false;
            } else {
                char pChar = p.charAt(i - 1);
                if (pChar != '*') {
                    dpTable[0][i] = false;
                } else {
                    count++;
                    if (count == i / 2) {
                        dpTable[0][i] = true;
                    }
                }
            }
        }
        dpTable[0][0] = true;
        for (int i = 1; i < dpTable.length; i++) {
            char sChar = s.charAt(i - 1);
            for (int j = 1; j < dpTable[0].length; j++) {
                char pChar = p.charAt(j - 1);
                if (sChar == pChar || pChar == '.') {
                    dpTable[i][j] = dpTable[i - 1][j - 1];
                } else {
                    if (pChar != '*') {
                        dpTable[i][j] = false;
                    } else {
                        if (j - 2 >= 0) {
                            char pCharTwo = p.charAt(j - 2);
                            if (pCharTwo == sChar || pCharTwo == '.') {
                                dpTable[i][j] = dpTable[i - 1][j - 1] || dpTable[i - 1][j];
                                dpTable[i][j] = dpTable[i][j] || dpTable[i][j - 2];
                            } else {
                                dpTable[i][j] = dpTable[i][j - 2];
                            }
                        }
                    }
                }
            }
        }
        return dpTable[dpTable.length - 1][dpTable[0].length - 1];
    }
}
 */