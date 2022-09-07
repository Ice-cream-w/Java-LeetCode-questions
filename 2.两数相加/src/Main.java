public class Main {
    public static void main(String[] args) {
        ListNode L1 = new ListNode(9,new ListNode(9,new ListNode(9,new ListNode(9,new ListNode(9,null)))));
        ListNode L2 = new ListNode(9,new ListNode(9,new ListNode(9,null)));

        Solution L3 = new Solution();
        ListNode L4 = L3.addTwoNumbers(L1,L2);
        //需要debug查看，运行没结果
        System.out.println(L4.val);
        for (int i = 0 ; i < 4 ; i ++){
            System.out.println(L4.next.val);
        }
    }
}
