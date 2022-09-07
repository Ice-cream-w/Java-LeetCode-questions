public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] nums = {{1,1,1},{1,1,0},{1,0,1}};
        s.floodFill(nums,1,1,2);
        for (int i = 0 ; i < nums.length ; i++)
            for (int j = 0; i < nums[i].length ; j ++)
                System.out.println(nums[i][j]);
    }
}