import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

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
给你一个链表数组，每个链表都已经按升序排列。
请你将所有链表合并到一个升序链表中，返回合并后的链表。

输入：lists = [[1,4,5],[1,3,4],[2,6]]
输出：[1,1,2,3,4,4,5,6]
解释：链表数组如下：
[
  1->4->5,
  1->3->4,
  2->6
]
将它们合并到一个有序链表中得到。
1->1->2->3->4->4->5->6
 */

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0)
            return null;

        //待传链表
        ListNode dummyHead = new ListNode(0);
        ListNode curr = dummyHead;
        //优先队列
        PriorityQueue<ListNode> priorityQueue = new PriorityQueue<>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;
            }
        });

        //加入元素进优先队列
        for (ListNode list : lists){
            if (list == null)
                continue;
            priorityQueue.add(list);
        }

        //非空传进新链表
        while(!priorityQueue.isEmpty()){
            ListNode next = priorityQueue.poll();
            curr.next = next;
            curr = curr.next;
            if (next.next !=  null)
                priorityQueue.add(next.next);
        }
        return dummyHead.next;
    }
}