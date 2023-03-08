package com.thinkingme.train.shua.dataStructure;

/**
 * <p>
 * 链表
 * </p>
 *
 * @author: huige
 * @date: 2022/8/31 10:13
 */
public class ListNode {
    public int val;
    // 下一个链表对象
    public ListNode next;
    //赋值链表的值
    public ListNode(int x) { val = x; }

    /**
     * @param str 示例 “4,2,1,3”
     * @return
     */
    //字符串生成链表
    public static ListNode createList(String str){
        if (str==null) return null;
        String[] split = str.split(",");
        ListNode root = new ListNode(-1);
        ListNode temp = root;
        for (String s : split) {
            ListNode next = new ListNode(Integer.parseInt(s));
            temp.next = next;
            temp = next;
        }
        return root.next;
    }

}
