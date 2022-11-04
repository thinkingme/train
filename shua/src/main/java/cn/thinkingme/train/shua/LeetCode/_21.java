package cn.thinkingme.train.shua.LeetCode;
class ListNode {
	int val;
	ListNode next;
	ListNode() {}
	ListNode(int val) { this.val = val; }
	ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    // 添加新的结点
    public void add(int newval) {
        ListNode newNode = new ListNode(newval);
        if(this.next == null)
            this.next = newNode;
        else
            this.next.add(newval);
    }
    // 打印链表
    public void print() {
        System.out.print(this.val);
        if(this.next != null)
        {
            System.out.print("-->");
            this.next.print();
        }
    }

}
public class _21 {

	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		ListNode root = null;
		if(l1==null && l2==null) {
			return root;
		}
		if(l1 == null) {
			return l2;
		}
		if(l2 == null) {
			return l1;
		}
        if(l1.val>l2.val){
            root = new ListNode(l2.val);
            l2 = l2.next;
        }else{
        	root = new ListNode(l1.val);
            l1 = l1.next;
        }
        ListNode head = root;
        while(l1!=null && l2!=null){
            if(l1.val>l2.val){
                root.next = new ListNode(l2.val);
                l2 = l2.next;
            }else{
                root.next = new ListNode(l1.val);
                l1 = l1.next;
            }
        }
        if(l1 != null){
            while(l1 != null){
                root.next = new ListNode(l1.val);
                l1 = l1.next;
            }
        }
        if(l2 != null){
            while(l2 != null){
                root.next = new ListNode(l2.val);
                l2 = l2.next;
            }
        }
        return head;
    }
}
