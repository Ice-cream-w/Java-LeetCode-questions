import java.util.List;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = {2,3,6,7};
        List<List<Integer>> k = s.combinationSum(nums,7);
        System.out.println(k);
    }
}