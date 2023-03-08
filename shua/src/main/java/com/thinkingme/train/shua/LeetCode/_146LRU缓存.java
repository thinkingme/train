package com.thinkingme.train.shua.LeetCode;

import java.util.HashMap;

/**
 * <p>
 * 146. LRU 缓存
 * 双向链表，为什么用双向链表：方便配合哈希索引，找到对应的前后节点，然后进行插入删除操作
 *
 * </p>
 *
 * @author: huige
 * @date: 2022/6/22 16:31
 */
public class _146LRU缓存 {

    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(2);
        lruCache.put(1,0);
        lruCache.put(2,2);
        System.out.println(lruCache.get(1));
        lruCache.put(3,3);
        System.out.println(lruCache.get(2));
        lruCache.put(4,4);
        System.out.println(lruCache.get(1));
        System.out.println(lruCache.get(3));
        System.out.println(lruCache.get(4));
    }

    static class LRUCache {
        class Node{
            Node pre,next;
            int key,val;
            public Node(){
                val = -1;
            }
        }
        Node head = null;
        Node tail = null;
        HashMap<Integer, Node> hs = new HashMap();
        int cap = 0;
        int maxCap = 5;
        public LRUCache(int capacity) {
            maxCap = capacity;
            head = new Node();
            tail = new Node();
            head.next = tail;
            tail.pre = head;
        }

        public int get(int key) {
            if(hs.containsKey(key)){
                removeNode(hs.get(key));
                moveToHead(hs.get(key));
                return hs.get(key).val;
            }else{
                return -1;
            }
        }

        public void put(int key, int value) {
            if(!hs.containsKey(key)){
                Node node = new Node();
                node.val = value;
                node.key = key;
                moveToHead(node);
                hs.put(key,node);
                cap++;
                if(cap>maxCap){
                    hs.remove(tail.pre.key);
                    removeNode(tail.pre);
                    cap--;
                }
            }else{
                hs.get(key).val = value;
                removeNode(hs.get(key));
                moveToHead(hs.get(key));
            }
        }
        public void moveToTail(Node node){
            node.pre = tail.pre;
            node.next = tail;
            tail.pre.next = node;
            tail.pre = node;
        }
        public void removeNode(Node node){
            node.pre.next = node.next;
            node.next.pre = node.pre;
        }
        public void moveToHead(Node node){
            node.pre = head;
            node.next = head.next;
            head.next.pre = node;
            head.next = node;
        }
    }
}
