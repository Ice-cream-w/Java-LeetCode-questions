import java.util.ArrayList;
import java.util.List;
//回溯
class Soul {
    //结果集合，字符串转成字母
    private List<String> list = new ArrayList<>();
    private char[][] chars = {{'a','b','c'},{'d','e','f'},
            {'g','h','i'},{'j','k','l'},{'m','n','o'},
            {'p','q','r','s'},{'t','u','v'},{'w','x','y','z'}};

    public List<String> letterCombinations(String digits) {
        //装单个结果的数组，便于拼接
        char[] chars1 = new char[digits.length()];

        //空字符串
        if (digits.length() == 0)
            return list;

        backTrack(0, chars1, digits);
        return list;
    }

    public void backTrack(int n, char[] chars1, String digits){
        //终止条件，到底了就拼接成字符串放入list
        if(n == digits.length()){
            String s = "";
            for (int i = 0 ; i < n ; i ++)
                s = s + chars1[i];
            list.add(s);
            return;
        }

        //表示digits里第n个数字对应的char数组里的地方
        int m = digits.charAt(n) - '2';
        //递归
        for(int i = 0; i < chars[m].length; i++){
            //将chars里对应的每个字母放入
            chars1[n] = chars[m][i];
            // 回溯
            backTrack(n+1, chars1, digits);
        }
    }
}

