public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        char[][] nums = {
                {'X','O','X','O','X','O'},
                {'O','X','O','X','O','X'},
                {'X','O','X','O','X','O'},
                {'O','X','O','X','O','X'}};
        s.solve(nums);
        System.out.println();
    }
}