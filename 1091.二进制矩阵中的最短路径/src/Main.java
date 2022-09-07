public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] nums = {{0,0,0},{1,1,0},{1,1,0}};
        int k = s.shortestPathBinaryMatrix(nums);
        System.out.println(k);
    }
}