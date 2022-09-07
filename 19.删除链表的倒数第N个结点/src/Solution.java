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
/*
给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
输入：head = [1,2,3,4,5], n = 2
输出：[1,2,3,5]
 */

//递归
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        //返回节点，当返回值为n时，跳过该节点，
        if (removeNode(head,n) == n)
            return head.next;
        else
            return head;
    }

    //返回值判断是否为倒数第n个
    public int removeNode(ListNode node,int n) {
        //只有一个节点的返回1，即输出head
        if(node.next == null)  return 1;
        //递归，传递node下一节点和n
        int m = removeNode(node.next, n);
        //判断如果返回值=n，判断是否到底
        if(m == n)
            if(m == 1) node.next = null;
            else node.next = node.next.next;
        return m+1;
    }
}
