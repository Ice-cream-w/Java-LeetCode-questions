public class Main {
    public static void main(String[] args) {
        String s = "abccbdaeed";
        //for(int i = 0 ; i < s.length() ;i ++)
        //    System.out.println(s.charAt(i));
        Solution solution = new Solution();
        int i = solution.lengthOfLongestSubstring(s);
        System.out.println(i);
    }
}
