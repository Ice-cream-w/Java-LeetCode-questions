public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        char[][] grid = {
                {'1','1','1','0','0'},
                {'1','1','0','0','0'},
                {'0','0','1','0','0'},
                {'0','0','0','1','1'}};
        int k = s.numIslands(grid);
        System.out.println(k);
    }
}