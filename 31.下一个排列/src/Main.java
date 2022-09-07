public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = {3,2,1};
        s.nextPermutation(nums);
        for (int i = 0 ; i < nums.length ; i ++){
            System.out.print(nums[i]);
        }
    }
}