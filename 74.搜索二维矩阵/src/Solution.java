/*
编写一个高效的算法来判断m*n矩阵中，是否存在一个目标值。该矩阵具有如下特性：

每行中的整数从左到右按升序排列。
每行的第一个整数大于前一行的最后一个整数。

输入：matrix = [
[1, 3, 5, 7 ],
[10,11,16,20],
[23,30,34,60]], target = 3
输出：true

输入：matrix = [
[1, 3, 5, 7 ],
[10,11,16,20],
[23,30,34,60]], target = 13
输出：false
 */

//非二分搜索
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        //行数和列数，从第一行最后一个开始，防止仅有一行的矩阵
        int row = 0, col = matrix[0].length-1;

        //判断是否在矩阵里
        while(row < matrix.length && col >= 0){
            //先判断目标值与此行最大值的关系
            if(matrix[row][col] < target)
                row++;
            else if(matrix[row][col] > target)
                col--;
            else
                return true;
        }

        return false;
    }
}

/*//二分搜索
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0)
            return false;
        int begin, mid, end;
        begin = mid = 0;
        int len1 = matrix.length, len2 = matrix[0].length;
        end = len1 * len2 - 1;
        while (begin < end) {
            mid = (begin + end) / 2;
            if (matrix[mid / len2][mid % len2] < target)
                begin = mid + 1;
            else
                end = mid;
        }
        return matrix[begin / len2][begin % len2] == target;
    }
}
 */