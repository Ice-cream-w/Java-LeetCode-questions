/*
给定一个仅包含数字2-9的字符串，返回所有它能表示的字母组合。答案可以按任意顺序返回。
给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
2-abc，3-def，4-ghi，5-jkl，6-mno，7-pqrs，8-tuv，9-wxyz

输入：digits = "23"
输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
 */
import java.util.ArrayList;
import java.util.List;

//普通方法
class Solution {
    //创建返回链表，导入数据
    private static List<char[]> phoneChar =  new ArrayList<char[]>();
    private static int[] charNum = new int[]{0,0,3,3,3,3,3,4,3,4};
    static {
        phoneChar.add(null);
        phoneChar.add(null);
        phoneChar.add(new char[]{'a','b','c'});//2
        phoneChar.add(new char[]{'d','e','f'});//3
        phoneChar.add(new char[]{'g','h','i'});//4
        phoneChar.add(new char[]{'j','k','l'});//5
        phoneChar.add(new char[]{'m','n','o'});//6
        phoneChar.add(new char[]{'p','q','r','s'});//7
        phoneChar.add(new char[]{'t','u','v'});//8
        phoneChar.add(new char[]{'w','x','y','z'});//9
    }

    //组合的总数
    private int sum(int[] a){
        int sum = 1;
        int n = a.length;
        for(int i = 0; i < n; i++){
            sum *= charNum[a[i]];
        }
        return sum;
    }

    public List<String> letterCombinations(String digits) {

        List<String> list = new ArrayList<String>();
        //判断空串时的特殊情况
        if(digits.equals(""))
            return list;
        int m = digits.length();
        int[] a = new int[m];
        for(int i = 0; i < m; i++){
            a[i] = Integer.parseInt("" + digits.charAt(i));
        }
        //地址转换字母
        int b[] = new int[m+1];
        int n = sum(a);
        for(int i = 0; i < n; i++){String s = "";
            //拼接一个字符串
            for(int j = 0;j < m; j++)
                s += phoneChar.get(a[j])[b[j]];
            list.add(s);
            //对a[i]字母使用计数，使用了一次+1，防止重复输出
            b[0]++;
            //判断第一个字母是否到底，到底返回，重新计数，让第二个字母进入下一个
            //第二个字母到底，则第三个字母进入下一个，第二个字母重新计数
            for(int j = 0; j < m; j++){
                if(b[j] == charNum[a[j]]){
                    b[j] = 0;
                    b[j+1]++;
                } else {
                    break;
                }
            }
        }
        return list;
    }
}