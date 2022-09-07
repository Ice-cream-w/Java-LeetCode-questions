public class Main {
    public static void main(String[] args) {
        int[] nums = {4,5,7,2,6,9,5,8,1};
        int target = 5;
        Solution ints = new Solution();
        int[] s = ints.twoSum(nums, target);
        for (int i = 0 ; i < s.length ; i ++)
            System.out.println(s[i]);
    }
}
