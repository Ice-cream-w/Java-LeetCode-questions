public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] s1 = {{1,3,5,7},{10,11,16,20},{23,30,34,60}};
        boolean i = s.searchMatrix(s1,3);
        System.out.println(i);
    }
}