package com.thinkingme.train.shua.LeetCode;

/**
 * @ProjectName: 题目代码
 * @Package: LeetCode
 * @ClassName: _24
 * @Author: huige
 * @Description: 两两交换链表中的节点
 * @Date: 2021/8/5 9:01
 * @Version: 1.0
 */
public class _24 {
    public static void main(String[] args) {
        ListNode head  = new ListNode(1);
        head.add(2);head.add(3);head.add(4);head.add(5);
        head.print();
        head = swapPairs(head);
        System.out.println();
        head.print();
    }
    public static ListNode swapPairs(ListNode head) {
        if(head == null || head.next ==null){
            return head;
        }
        ListNode pre = new ListNode(0);
        pre.next = head;
        ListNode first = head ,second = head.next;
        head = second;
        while(first !=null && second!=null){
            ListNode next = second.next;
            pre.next = second;
            second.next = first;
            first.next = next;
            if(next != null){
                pre = first;
                first = next;
                second = next.next;
            }else {
                break;
            }
        }
        return head;
    }

}
