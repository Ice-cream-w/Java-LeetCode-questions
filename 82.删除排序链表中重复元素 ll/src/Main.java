public class Main {
    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1,new ListNode(2,new ListNode(3,new ListNode(3,new ListNode(4,new ListNode(4,new ListNode(4,new ListNode(5,null))))))));
        Solution s = new Solution();
        ListNode b = s.deleteDuplicates(listNode1);
        for (int i = 0 ; i < 6 ; i ++){
            System.out.print(b.val);
            if (b.next != null)
                b = b.next;
            else
                break;
        }
    }
}