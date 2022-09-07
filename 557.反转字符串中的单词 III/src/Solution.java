/*
给定一个字符串 s ，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。

输入：s = "Let's take LeetCode contest"
输出："s'teL ekat edoCteeL tsetnoc"

输入： s = "God Ding"
输出："doG gniD"
 */

class Solution {
    public String reverseWords(String s) {
        StringBuilder ans = new StringBuilder();

        //空格分开每个单词
        for(String str: s.trim().split(" ")){
            //转化为字符数组
            char[] chars = str.toCharArray();
            //反转单词
            reverseString(chars);
            //合并
            ans.append(chars).append(" ");
        }
        //将字符数组转为字符串形式输出，并删除头尾的空格
        //因为在追加最后一个字符的时候，末尾会有一个空格
        return ans.toString().trim();
    }

    public void reverseString(char[] chars){
        int left = 0;
        int right= chars.length-1;

        //交换两个字符
        while(left < right){
            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;
            //两个指针同时移动
            left++;
            right--;
        }
    }
}