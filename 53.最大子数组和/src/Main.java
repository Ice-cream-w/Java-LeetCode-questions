public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        int i = s.maxSubArray(nums);
        System.out.println(i);
    }
}