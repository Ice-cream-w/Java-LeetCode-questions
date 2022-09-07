/*
给你两个字符串s1和s2 ，写一个函数来判断 s2 是否包含 s1的排列。如果是，返回 true ；否则，返回 false 。
换句话说，s1 的排列之一是 s2 的 子串 。

输入：s1 = "ab" s2 = "eidbaooo"
输出：true
解释：s2 包含 s1 的排列之一 ("ba").

输入：s1= "ab" s2 = "eidboaoo"
输出：false
 */

class Solution {
    public boolean checkInclusion(String s1, String s2) {
        //记录s1串对应字符出现的个数,26个字母全设0
        int[] a= new int[26];
        //待排字符个数，也就是s1长度，后面需要增减判断是否达到长度
        int cnt=0;
        //s1中每有一个该字母，该字母的元素值+1
        for(int i=0;i<s1.length();i++)
        {
            a[s1.charAt(i)-'a']++;
            cnt++;
        }

        //左右指针判断长度
        int right=0;
        int left=0;

        //超出s2长度即判断不包含
        while(right<s2.length())
        {
            //s2中该元素值-1，如果小于0则表示s1中没有该元素，也就不匹配了
            a[s2.charAt(right)-'a']--;
            //不匹配的时候，表示左右指针中间一部分不匹配s1，可以将左指针移动到右指针位置
            while(a[s2.charAt(right)-'a']<0)
            {
                a[s2.charAt(left)-'a']++;
                left++;
                cnt++;
            }

            //如果大于等于0，则表示匹配到了s1中的该元素，匹配元素值-1
            cnt--;
            right++;
            //待匹配元素值为0时，匹配成功
            if(cnt==0)
                return true;
        }

        return false;
    }
}
