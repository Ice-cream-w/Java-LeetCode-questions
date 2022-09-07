/*
给你一个按 非递减顺序 排序的整数数组 nums，返回 每个数字的平方 组成的新数组，要求也按 非递减顺序 排序。

输入：nums = [-4,-1,0,3,10]
输出：[0,1,9,16,100]
解释：平方后，数组变为 [16,1,0,9,100]
排序后，数组变为 [0,1,9,16,100]

输入：nums = [-7,-3,2,3,11]
输出：[4,9,9,49,121]
 */

class Solution {
    public int[] sortedSquares(int[] nums) {
        int right = 1;
        int left = 0;
        int i = 0;
        int[] nums1 = new int[nums.length];
        //空数组或单数字数组
        if (nums.length == 1){
            nums1[0] = nums[0] * nums[0];
            return nums1;
        }

        //判断平方最小的一项
        while(i < nums.length){
            //不是倒数第二项，且此时小于0，后面一项大于0时候，左指针指向i，右指针指向下一个值
            if ((nums[i] < 0 && nums[i+1] >= 0) || (nums[i] >= 0) || (i == nums.length - 2)){
                right = i + 1;
                left = i;
                i = 0 ;
                break;
            }
                i ++;
        }

        int a = nums[left] * nums[left];
        int b = nums[right] * nums[right];

        //平方比较
        while(true){
            if (a <= b){
                nums1[i] = a;
                left--;
                if (left < 0)
                    break;
                a = nums[left] * nums[left];
            }
            else{
                nums1[i] = b;
                right++;
                if (right > nums.length -1)
                    break;
                b = nums[right] * nums[right];
            }
            i++;
        }

        i++;
        while(right <= nums.length -1){
            nums1[i] = b;
            right++;
            if (right > nums.length -1)
                break;
            b = nums[right] * nums[right];
            i++;
        }
        while(left >= 0){
            nums1[i] = a;
            left--;
            if (left < 0)
                break;
            a = nums[left] * nums[left];
            i++;
        }

        return nums1;
    }
}

/*
//内存优解，速度慢了，因为用了array的排序
class Solution {
  public int[] sortedSquares(int[] nums) {
        int[] ans = new int[nums.length];
        for (int i = 0; i < nums.length; ++i) {
            ans[i] = nums[i] * nums[i];
        }
        Arrays.sort(ans);
        return ans;
    }
}
 */