package com.thinkingme.train.shua.LeetCode;

import java.util.HashMap;

/**
 * @ProjectName: 题目代码
 * @Package: LeetCode
 * @ClassName: _19
 * @Author: huige
 * @Description: 删除链表的倒数第 N 个结点
 * @Date: 2021/7/28 15:51
 * @Version: 1.0
 */
public class _19 {


    public ListNode removeNthFromEnd(ListNode head, int n) {
        HashMap<Integer,ListNode> hs = new HashMap<>();
        ListNode temp = head;
        int count = 0;
        while(temp!=null){
            hs.put(count++,temp);
            temp = temp.next;
        }
        if(count == 0||count ==1){
            return null;
        }
        if(count-n-1 == 0){
            head = head.next;
            return head;
        }
        hs.get(count-n-1).next =hs.get(count-n).next;
        return head;
    }
    public ListNode removeNthFromEnd2(ListNode head, int n) {
        ListNode dummy = new ListNode(0, head);
        ListNode first = head;
        ListNode second = dummy;
        for (int i = 0; i < n; ++i) {
            first = first.next;
        }
        while (first != null) {
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;
        ListNode ans = dummy.next;
        return ans;
    }

}
