import java.util.List;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] nums = {{4,3,1},{3,2,4},{3},{4},{}};
        List<List<Integer>> k = s.allPathsSourceTarget(nums);
        System.out.println(k);
    }
}