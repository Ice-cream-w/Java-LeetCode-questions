public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] s1 = {0,1,0,3,12};
        s.moveZeroes(s1);
        for (int i = 0 ; i < s1.length ; i ++)
            System.out.println(s1[i]);
    }
}