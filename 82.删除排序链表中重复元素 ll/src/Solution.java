/*
给定一个已排序的链表的头 head ， 删除原始链表中所有重复数字的节点，只留下不同的数字 。返回 已排序的链表 。

输入：head = [1,2,3,3,4,4,5]
输出：[1,2,5]

输入：head = [1,1,1,2,3]
输出：[2,3]
 */

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

//递归
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        int start = 0;
        //空链表和单个数的链表
        if (head == null ||head.next == null)
            return head;

        ListNode listNode = head.next;
        //递归
        if (head.val == listNode.val) {
            //1,相等，跳过,直到不相等
            while (listNode != null && head.val == listNode.val) {
                listNode = listNode.next;
            }
            //2,此时head也要舍弃
            head = deleteDuplicates(listNode);
        } else {
            //3,不相等，判断下一个
            head.next = deleteDuplicates(listNode);
        }

        return head;
    }
}