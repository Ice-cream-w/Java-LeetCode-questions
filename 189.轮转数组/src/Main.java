public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = {0,1,3,4};
        s.rotate(nums,3);
        for (int i = 0 ; i < nums.length ; i++)
            System.out.println(nums[i]);
    }
}