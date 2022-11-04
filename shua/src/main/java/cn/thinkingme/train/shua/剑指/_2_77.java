package cn.thinkingme.train.shua.剑指;

import cn.thinkingme.train.shua.dataStructure.ListNode;

/**
 * <p>
 * 剑指 Offer II 077. 链表排序
 * Tips: 合并排序
 * </p>
 *
 * @author: huige
 * @date: 2022/8/31 9:43
 */
public class _2_77 {

    public static void main(String[] args) {
        ListNode node = ListNode.createList("4,2,1,3");
        ListNode listNode = sortList(node);
        System.out.println();
    }

    public static ListNode sortList(ListNode head) {
        if(head == null) return null;
        int n = 1;
        ListNode temp = head;
        while ((temp = temp.next)!=null)n++;

        return merge_sort(head,n);
    }
    public static ListNode merge_sort(ListNode head,int n){
        if(n == 1){head.next = null;return head;}
        int mid = n>>1;
        ListNode rHead = merge_sort(move(head,mid),n-mid);
        ListNode lHead = merge_sort(head,mid);
        return merge(lHead,mid,rHead,n-mid);
    }
    public static ListNode merge(ListNode left,int ln,ListNode right,int rn){
        ListNode head = new ListNode(0);
        ListNode cur = head;
        while(ln>0 && rn>0){
            if(left.val<right.val){
                cur.next = left;
                left = left.next;
                cur = cur.next;
                ln--;
            }else{
                cur.next = right;
                right = right.next;
                cur = cur.next;
                rn--;
            }
        }

        while(ln>0){
            cur.next = left;
            left = left.next;
            cur = cur.next;
            ln--;
        }
        while(rn>0){
            cur.next = right;
            right = right.next;
            cur = cur.next;
            rn--;
        }
        return head.next;
    }
    public static ListNode move(ListNode head,int n){
        while(n--!=0){
            head = head.next;
        }
        return head;
    }
}
