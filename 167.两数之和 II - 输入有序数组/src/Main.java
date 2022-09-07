public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] s1 = {2,7,11,15};
        int[] s2 = s.twoSum(s1,9);
        for (int i = 0 ; i < s2.length ; i ++)
            System.out.println(s2[i]);
    }
}