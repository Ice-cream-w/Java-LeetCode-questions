import java.util.List;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        List<String> b = s.generateParenthesis(3);
        for (int i = 0 ; i < 3 ; i ++){
            System.out.print(b);
        }
    }
}