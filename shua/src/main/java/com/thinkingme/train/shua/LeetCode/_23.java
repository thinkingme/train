package com.thinkingme.train.shua.LeetCode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @ProjectName: 题目代码
 * @Package: LeetCode
 * @ClassName: _23
 * @Author: huige
 * @Description: 合并k个有序链表
 * @Date: 2021/8/4 10:26
 * @Version: 1.0
 */
public class _23 {
    static  PriorityQueue<ListNode> queue = new PriorityQueue<ListNode>(new Comparator<ListNode>() {
        @Override
        public int compare(ListNode o1, ListNode o2) {
            return o1.val - o2.val;
        }
    });

    public static void main(String[] args) {
        ListNode []listNodes =new ListNode[3];
        listNodes[0] = new ListNode(1);
        listNodes[0].next = new ListNode(2);
        listNodes[1] = new ListNode(3);
        listNodes[1].next = new ListNode(4);
        listNodes[2] = new ListNode(2);
        listNodes[2].next = new ListNode(6);
        ListNode head = mergeKLists(listNodes);
        System.out.println(head);
        String s= "sid:123456";
        System.out.println(s.matches("sid:[0-9]+"));
    }
    public static ListNode mergeKLists(ListNode[] lists) {
        for (ListNode node: lists) {
            if (node != null) {
                queue.offer(new ListNode(node.val, node.next));
            }
        }
        ListNode head = new ListNode(0);
        ListNode tail = head;
        while (!queue.isEmpty()) {
            ListNode f = queue.poll();
            tail.next = f;
            tail = tail.next;
            if (f.next != null) {
                queue.offer(new ListNode(f.next.val, f.next.next));
            }
        }
        return head.next;
    }
}
