public class Main {
    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1,new ListNode(2,new ListNode(4,null)));
        ListNode listNode2 = new ListNode(1,new ListNode(3,new ListNode(4,null)));
        Solution s = new Solution();
        ListNode b = s.mergeTwoLists(listNode1, listNode2);
        for (int i = 0 ; i < 6 ; i ++){
            System.out.print(b.val);
            b = b.next;
        }
    }
}