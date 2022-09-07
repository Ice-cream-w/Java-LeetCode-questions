public class Main {
    public static void main(String[] args) {
        int[] nums1 = {1, 2,5,8,9};
        int[] nums2 = {};

        Solution n = new Solution();
        double n1 = n.findMedianSortedArrays(nums1, nums2);
        System.out.println(n1);
    }
}
