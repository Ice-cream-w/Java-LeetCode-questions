public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] nums = {{0,0,1,0,0,0,0,1,0,0,0,0,0}};
        s.maxAreaOfIsland(nums);
        for (int i = 0 ; i < nums.length ; i++)
            for (int j = 0 ; j < nums[i].length ; j ++)
                System.out.println(nums[i][j]);
    }
}