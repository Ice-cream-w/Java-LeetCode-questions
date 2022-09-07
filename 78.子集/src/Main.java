import java.util.List;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = {1,2,3};
        List<List<Integer>> k = s.subsets(nums);
        System.out.println(k);
    }
}