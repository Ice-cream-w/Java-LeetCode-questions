import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String s = "catsandog";
        List<String> worddict = new ArrayList<>();
        worddict.add("cats");
        worddict.add("dog");
        worddict.add("sand");
        worddict.add("cat");
        worddict.add("and");
        Solution s1 = new Solution();
        boolean s2 = s1.wordBreak(s,worddict);
        System.out.println(s2);
    }
}
