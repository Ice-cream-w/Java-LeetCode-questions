public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] nums = {{1,1,0},{1,1,0},{0,0,1}};
        int k = s.findCircleNum(nums);
        System.out.println(k);
    }
}