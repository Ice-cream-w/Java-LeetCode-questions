public class Main {
    public static void main(String[] args) {
        int[][] firstList = {{0,2},{5,10},{13,23},{24,25}};
        int[][] secondList = {{1,5},{8,12},{15,24},{25,26}};
        Solution s = new Solution();
        int[][] s1 = s.intervalIntersection(firstList,secondList);
        System.out.println(s1.toString());
    }
}
