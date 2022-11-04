package cn.thinkingme.train.shua.双指针;

class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
/**
 * 
 * 先将一个指针p1往后移动k个节点
 * 然后再和一个指针p2一起往后移动直到前一个节点p1到末尾
 * 返回p2
 * @author Administrator
 *
 */
public class 链表中倒数第K个结点 {
	public ListNode FindKthToTail(ListNode head, int k) {
	    if (head == null)
	        return null;
	    ListNode P1 = head;
	    while (P1 != null && k-- > 0)
	        P1 = P1.next;
	    if (k > 0)
	        return null;
	    ListNode P2 = head;
	    while (P1 != null) {
	        P1 = P1.next;
	        P2 = P2.next;
	    }
	    return P2;
	}
}
