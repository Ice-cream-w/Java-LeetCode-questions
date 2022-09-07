import java.util.List;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = {1,1,2};
        List<List<Integer>> k = s.permuteUnique(nums);
        System.out.println(k);
    }
}