import java.util.List;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        String s1 = "cbaebabacd";
        String s2 = "abc";
        List<Integer> i = s.findAnagrams(s1, s2);
        System.out.println(i);
    }
}