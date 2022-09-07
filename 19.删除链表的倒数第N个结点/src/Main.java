public class Main {
    public static void main(String[] args) {
        ListNode digits = new ListNode(1,new ListNode(2,new ListNode(3,new ListNode(4,null))));
        Solution s = new Solution();
        ListNode b = s.removeNthFromEnd(digits, 4);
        for (int i = 0 ; i < 3 ; i ++){
            System.out.print(b.val);
            b = b.next;
        }
    }
}