/*
给你一个字符串数组，请你将 字母异位词 组合在一起。可以按任意顺序返回结果列表。

字母异位词 是由重新排列源单词的字母得到的一个新单词，所有源单词中的字母通常恰好只用一次。

输入: strs = ["eat", "tea", "tan", "ate", "nat", "bat"]
输出: [["bat"],["nat","tan"],["ate","eat","tea"]]

输入: strs = [""]
输出: [[""]]
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

//哈希表排序
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        //字符串和对应存放数组的哈希表
        HashMap<String,ArrayList<String>> hashMap = new HashMap<>();

        //遍历每个字符串
        for(String s:strs){
            //把每个字符串拆分成字母，排序
            char[] ch=s.toCharArray();
            Arrays.sort(ch);

            //对比这个数组和其他key，相同则放进去
            String key=String.valueOf(ch);
            if(!hashMap.containsKey(key))
                hashMap.put(key,new ArrayList<>());
            hashMap.get(key).add(s);
        }

        return new ArrayList(hashMap.values());
    }
}