public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        char[] s1 = {'h','e','l','i','o','s'};
        s.reverseString(s1);
        for (int i = 0 ; i < s1.length ; i ++)
            System.out.println(s1[i]);
    }
}