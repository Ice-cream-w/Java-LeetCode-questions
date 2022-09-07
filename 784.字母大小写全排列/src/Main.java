import java.util.List;

public class Main {
    public static void main(String[] args) {
        String  s1 = "a1b2";
        Solution s = new Solution();
        List<String> s2 = s.letterCasePermutation(s1);
        for (int i = 0 ; i < 6 ; i ++)
            System.out.println(s2.get(i));
    }
}