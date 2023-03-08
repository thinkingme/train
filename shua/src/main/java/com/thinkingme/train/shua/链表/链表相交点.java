package com.thinkingme.train.shua.链表;

import java.util.*;
class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
public class 链表相交点 {
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
         if(pHead1 == null || pHead2 == null) return null;
        HashMap<ListNode,Integer> hs = new HashMap<>();
        while(pHead1!=null){
            hs.put(pHead1,hs.getOrDefault(pHead1,0)+1);
            pHead1 = pHead1.next;
        }
        while(pHead2!=null){
            if(hs.get(pHead2) == 1)
                return pHead2;
            pHead2 = pHead2.next;
        }
        return null;
    }
}
