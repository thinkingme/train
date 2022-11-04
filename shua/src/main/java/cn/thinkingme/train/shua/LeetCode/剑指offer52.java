package cn.thinkingme.train.shua.LeetCode;

import java.util.HashSet;

public class 剑指offer52 {
    public static void main(String[] args) {

    }

    /**
     * easy method
     *
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        HashSet<ListNode> listNodes = new HashSet<>();
        while(headA !=null){
            listNodes.add(headA);
            headA = headA.next;
        }
        while(headB !=null){
            if(listNodes.contains(headB)){
                return headB;
            }
            headB = headB.next;
        }
        return null;
    }
    /**
     * a+b+c = c+b+a
     *
     */
    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode pA = headA, pB = headB;
        while (pA != pB) {
            pA = pA == null ? headB : pA.next;
            pB = pB == null ? headA : pB.next;
        }
        return pA;
    }
}
