import java.util.List;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        char[][] board = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        boolean k = s.exist(board, "ABCB");
        System.out.println(k);
    }
}