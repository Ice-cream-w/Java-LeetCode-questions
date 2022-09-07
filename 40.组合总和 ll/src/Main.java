import java.util.List;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = {10,1,2,7,6,1,5};
        List<List<Integer>> k = s.combinationSum2(nums,8);
        System.out.println(k);
    }
}