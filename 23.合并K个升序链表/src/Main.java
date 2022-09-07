import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        ListNode list1 = new ListNode(1,new ListNode(2,new ListNode(4,null)));
        ListNode list2 = new ListNode(1,new ListNode(3,new ListNode(5,null)));
        ListNode list3 = new ListNode(3,new ListNode(6,new ListNode(7,null)));
        ListNode[] list = {list1,list2,list3};
        ListNode b = s.mergeKLists(list);
        for (int i = 0 ; i < 9 ; i ++){
            System.out.print(b.val);
            b = b.next;
        }
    }
}