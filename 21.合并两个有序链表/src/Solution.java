/*
将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。

输入：l1 = [1,2,4], l2 = [1,3,4]
输出：[1,1,2,3,4,4]
 */
//递归
class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        //创建初始链表
        ListNode list = new ListNode(0);
        ListNode l = list;
        //进入递归
        list = compareListNodes(list,list1,list2);
        //第一个值舍弃，第一个值为了开辟链表
        return list.next;

    }

    public ListNode compareListNodes(ListNode list, ListNode listNode1 , ListNode listNode2){
        if (null != listNode1 && null != listNode2){
            //list接上小的那个结点，将小的那个往后挪一个结点
            if (listNode1.val < listNode2.val){
                list.next = listNode1;
                listNode1 = listNode1.next;
            }
            else {
                list.next= listNode2;
                listNode2 = listNode2.next;
            }
            compareListNodes(list.next,listNode1,listNode2);
        }
        //当某个链表为空时，代表递归结束，list接上另一个链表，此处包含空链表情况
        else list.next = (null == listNode1) ? listNode2 : listNode1;
        return list;
    }
}