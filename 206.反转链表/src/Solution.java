/*
给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。

输入：head = [1,2,3,4,5]
输出：[5,4,3,2,1]
 */

//递归
class Solution {
    public ListNode reverseList(ListNode head) {

        //1. 递归头  终止递归条件
        if(head == null || head.next == null)
            return head;

        //2. 递归体  自顶向下深入
        ListNode list = reverseList(head.next);

        //3. 回溯    自底向上跳出****
        head.next.next = head;
        head.next = null;

        return list;
    }
}