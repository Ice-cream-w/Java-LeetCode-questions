public class Main {
    public static void main(String[] args) {
        String s = "mississippi";
        String p = "mis*is*ip*.";
        Solution solution = new Solution();
        boolean s1 = solution.isMatch(s,p);
        System.out.println(s1);
    }
}
