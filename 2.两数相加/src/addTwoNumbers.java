import com.sun.org.apache.xpath.internal.objects.XNull;

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
给你两个非空 的链表，表示两个非负的整数。它们每位数字都是按照逆序的方式存储的，并且每个节点只能存储一位数字。
请你将两个数相加，并以相同形式返回一个表示和的链表。
你可以假设除了数字0之外，这两个数都不会以0开头。

输入：l1 = [2,4,3], l2 = [5,6,4]
输出：[7,0,8]
解释：342 + 465 = 807.

 */
class Solution extends ListNode {
    ListNode l1;

    public Solution() {
    }

    public Solution(ListNode l1) {
        this.l1 = l1;
    }

    public Solution(int val, ListNode l1) {
        super(val);
        this.l1 = l1;
    }

    public Solution(int val, ListNode next, ListNode l1) {
        super(val, next);
        this.l1 = l1;
    }

    public ListNode getL1() {
        return l1;
    }

    public void setL1(ListNode l1) {
        this.l1 = l1;
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        //创建初始对象
        ListNode l3 = new ListNode(0,null);
        l3.val = l1.val + l2.val;
        //进位情况
        if (l3.val >= 10){
            l3.val = l3.val % 10;
            //下一结点都不为空，进位递归
            if (null != l1.next && null != l2.next) {
                l1.next.val = l1.next.val + 1;
                l3.next = addTwoNumbers(l1.next,l2.next);
            }
            //下一结点都为空，创建下一结点
            else if (null == l1.next && null == l2.next)
                l3.next = new ListNode(1,null);
            //下一结点有一个为空，选择不为空的链表值进位为下一结点值，后接不为空的链表的下下结点
            else if (null == l1.next && null != l2.next)
                l3.next = addTwoNumbers(new ListNode(1,null),l2.next);
            else if (null != l1.next && null == l2.next)
                l3.next = addTwoNumbers(new ListNode(1,null),l1.next);
        }
        //不进位情况
        else {
            if (null != l1.next && null != l2.next)
                l3.next = addTwoNumbers(l1.next,l2.next);
            else if (null == l1.next && null == l2.next)
                l3.next = null;
            else if (null == l1.next || null == l2.next)
                l3.next = (null == l1.next) ? l2.next: l1.next;
        }
        return l3;
    }
}

/*
//最优解
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode root = new ListNode(0);
        ListNode cursor = root;
        int carry = 0;
        while(l1 != null || l2 != null || carry != 0) {
            int l1Val = l1 != null ? l1.val : 0;
            int l2Val = l2 != null ? l2.val : 0;
            int sumVal = l1Val + l2Val + carry;
            carry = sumVal / 10;

            ListNode sumNode = new ListNode(sumVal % 10);
            cursor.next = sumNode;
            cursor = sumNode;

            if(l1 != null) l1 = l1.next;
            if(l2 != null) l2 = l2.next;
        }

        return root.next;
    }
}*/