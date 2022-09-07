/*
给定一个字符串 s ，通过将字符串 s 中的每个字母转变大小写，我们可以获得一个新的字符串。
返回 所有可能得到的字符串集合。以 任意顺序 返回输出

输入：s = "a1b2"
输出：["a1b2", "a1B2", "A1b2", "A1B2"]

输入: s = "3z4"
输出: ["3z4","3Z4"]
 */

import java.util.ArrayList;
import java.util.List;

//回溯
class Solution {
    //返回的数组，减少参数设置。
    List<String> result = new ArrayList<String>();

    public List<String> letterCasePermutation(String s) {
        //空数组返回
        if (s.length() == 0)
            return result;

        //char数组存放拆解后的字符串元素，方便调用
        char[] chars = s.toCharArray();

        backTracking(chars , 0);
        return result;
    }

    private void backTracking(char[] chars, int start){
        //添加字符串到数组
        result.add(String.valueOf(chars));

        //递归,循环遍历数组里的值
        for (int i = start ; i < chars.length ; i ++){
            //小写字母转大写放一次
            if (chars[i] >= 'a' && chars[i] <= 'z'){
                chars[i] = (char)(chars[i] + 'A' - 'a');
                backTracking(chars, i+1);
                chars[i] = (char)(chars[i] - 'A' + 'a');
            }
            //大写字母转小写放一次
            else if(chars[i] >= 'A' && chars[i] <= 'Z'){
                chars[i] = (char)(chars[i] - 'A' + 'a');
                backTracking(chars, i+1);
                chars[i] = (char)(chars[i] + 'A' - 'a');
            }
        }
    }
}