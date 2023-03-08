package com.thinkingme.train.shua.LeetCode;

import java.util.HashMap;

/**
 * @ProjectName: 题目代码
 * @Package: LeetCode
 * @ClassName: _138
 * @Author: huige
 * @Description: 复制带随机指针的链表
 * @Date: 2021/7/22 11:04
 * @Version: 1.0
 */
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
public class _138 {
    public static void main(String[] args) {
        Node node = new Node(7);
        Node node2 = new Node(13);
        Node node3 = new Node(11);
        Node node4 = new Node(10);
        Node node5 = new Node(1);
        node.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node.random = null;
        node2.random = node;
        node3.random = node5;
        node4.random = node3;
        node5.random = node;
        copyRandomList(node);
    }
    public static Node copyRandomList(Node head) {
        Node h1 = head,h2 = head;
        Node copy = null, copyHead = null,res = null;
        HashMap<Node ,Integer > origin = new HashMap<>(1024);
        HashMap<Integer, Node> copyhs = new HashMap<>(1024);
        int count = 0;
        if(h1!=null){
            copy = new Node(h1.val);
            copyHead = copy;
            res = copy;
            origin.put( h1 ,count  );
            copyhs.put(count ,copy );
            ++count;
            h1 = h1.next;
            //copy = copy.next;
        }
        while(h1 != null){
            Node temp = new Node(h1.val);
            copy.next = temp;
            copy = copy.next;
            origin.put( h1 ,count );
            copyhs.put(count ,copy );
            ++count;
            h1 = h1.next;
        }

        while(copyHead != null&&h2!=null){
            copyHead.random = copyhs.getOrDefault(origin.getOrDefault(h2.random , null),null);
            copyHead = copyHead.next;
            h2 = h2.next;
        }
        return res;
    }
}
