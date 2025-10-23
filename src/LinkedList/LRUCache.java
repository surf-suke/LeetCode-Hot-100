package LinkedList;

import java.util.HashMap;
import java.util.Map;
public class LRUCache {    //LRU缓存
    public int capacity;
    public int size;
    public Map<Integer, DLinkedNode> map = new HashMap();
    public static class DLinkedNode {
        int key;
        int value;
        DLinkedNode prev;
        DLinkedNode next;
        public DLinkedNode () {}
        public DLinkedNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
    public DLinkedNode head;
    public DLinkedNode tail;
    public LRUCache(int capacity) {
        this.size=0;
        this.capacity=capacity;
        head=new DLinkedNode();
        tail=new DLinkedNode();
        this.head.next=this.tail;
        this.head.prev=null;
        this.tail.next=null;
        this.tail.prev=head;
    }
    public int get(int key) {
        if(!map.containsKey(key)){
            return -1;
        }
        DLinkedNode keyNode = map.get(key);
        keyNode.prev.next=keyNode.next;
        keyNode.next.prev=keyNode.prev;
        keyNode.next=this.head.next;
        keyNode.prev=this.head;
        keyNode.next.prev=keyNode;
        keyNode.prev.next=keyNode;
        return keyNode.value;
    }

    public void put(int key, int value) {
        if(map.containsKey(key)){
            DLinkedNode node =map.get(key);
            node.value=value;
            node.prev.next=node.next;
            node.next.prev=node.prev;
            node.next=this.head.next;
            node.prev=this.head;
            node.next.prev=node;
            node.prev.next=node;
            return;
        }
        DLinkedNode keyNode = new DLinkedNode(key,value);
        keyNode.next=this.head.next;
        keyNode.prev=this.head;
        keyNode.next.prev=keyNode;
        keyNode.prev.next=keyNode;
        if(this.size<this.capacity){
            map.put(key,keyNode);
            this.size++;
        }else {
            map.remove(this.tail.prev.key);
            this.tail.prev.prev.next=this.tail;
            this.tail.prev=this.tail.prev.prev;
            map.put(key,keyNode);
        }
    }
}

